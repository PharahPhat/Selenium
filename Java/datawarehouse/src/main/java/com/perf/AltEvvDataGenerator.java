package com.perf;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.interop.common.Commons;
import com.interop.common.State;
import com.interop.common.StateAccount;
import com.interop.common.constants.Constant;
import com.interop.models.ProviderIdentification;
import com.interop.models.altevv.client.AltEvvClient;
import com.interop.models.altevv.client.AltEvvClientDataGenerator;
import com.interop.models.altevv.employee.AltEvvEmployee;
import com.interop.models.altevv.employee.AltEvvEmployeeDataGenerator;
import com.interop.models.altevv.visit.*;
import com.sandata.core.config.Environment;
import com.sandata.core.config.TestConfiguration;
import com.sandata.core.config.TestContext;
import com.sandata.utilities.JsonReader;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AltEvvDataGenerator {
    private static final Logger LOGGER = Logger.getLogger(AltEvvDataGenerator.class);
    private static final int MAX_RECORDS = 5000;
    private static Random rand = new Random();
    private static Commons commons = new Commons();
    private static final String STAGE = System.getProperty("environment");
    private static final String ENVID = System.getProperty("DefaultENVID");
    private static final String EXPORT_FILE_PATH = Constant.DEFAULT_FOLDER + File.separator + "%s.txt";

    static {
        TestConfiguration testConfiguration = TestContext.initTestConfig();
        Environment environment = JsonReader.loadEnvironment(STAGE, ENVID);
        testConfiguration.setEnvironment(environment);
        TestContext.set(testConfiguration);
    }

    //    QA
    private static String[][] accountsInQA = {{"100112322", "60247"},
            // AMP PA List
            {"999999888", "60138"},
            //PA - 1st List
            {"114334796", "62038"}, {"322112389", "60207"},
            {"300112389", "60209"}, {"152345706", "60221"},
            {"009988536", "60233"}, {"987000011", "60239"},
            {"0167780", "167780"}, {"999999888", "60138"},
            {"167117122", "60246"},

            //PA - 2nd List
            {"100112322", "60247"},
            {"100112111", "60250"}, {"167117177", "60251"},
            {"083011532", "60322"}, {"201908301", "60330"}, {"083002090", "60334"},
            {"083004464", "60347"}, {"083004364", "60348"},
            {"083004164", "60349"}, {"083003664", "60350"},
            {"290123415", "60240"}, {"290123451", "60365"},
            {"083011532", "60332"},

            {"1235566", "29000"},// INDIA
            {"8000811", "800011"},//VT
            {"0167780", "167780"}, //RI
            {"A23567", "80112"},//AZ
            {"563241", "85000"},//HI


    };

    //    DEV
    private static String[][] accountsInDEV = {{"300442388", "324241"}, {"300433870", "324242"},
            {"900002318", "324243"}, {"100001726", "324244"},
            {"100001421", "324245"}, {"200084104", "324246"},
            {"101397666", "324247"}, {"300319849", "324248"},
            {"100006099", "324249"}, {"300443518", "324250"},
            {"100000961", "324251"}, {"100000166", "324252"},
            {"102455620", "324264"}, {"100772735", "324254"},
            {"300504972", "324255"}, {"100007309", "324256"},
            {"101325845", "324257"}, {"300357133", "324262"},
            {"100000620", "324263"}, {"100000916", "324260"}};

    public static StateAccount getStateAccountByAccountNumber(int accountNumber) {
        return getStateAccounts(40).stream()
                .filter(stateAccount -> accountNumber == Integer.parseInt(stateAccount.getAccountID()))
                .findFirst().orElseThrow(RuntimeException::new);
    }

    private static List<StateAccount> getStateAccounts(int noAccounts) {
        TestConfiguration testConfiguration = TestContext.initTestConfig();
        Environment environment = JsonReader.loadEnvironment(STAGE, ENVID);
        testConfiguration.setEnvironment(environment);
        TestContext.set(testConfiguration);

        List<StateAccount> stateAccounts = new ArrayList<>();
        StateAccount defaultAccount = StateAccount.loadStateAccount(STAGE, ENVID);

        String[][] accounts;
        if (STAGE.equalsIgnoreCase("dev")) {
            LOGGER.info("Loading states in DEV environment");
            accounts = accountsInDEV;
        } else {
            LOGGER.info("Loading states in QA environment");
            accounts = accountsInQA;
        }

        for (String[] account : accounts) {
            StateAccount state = new StateAccount();
            state.setProviderID(account[0]);
            state.setProviderQualifier(defaultAccount.getProviderQualifier());
            state.setAccountID(account[1]);
            state.setClientQualifier(defaultAccount.getClientQualifier());
            state.setEmployeeQualifier(defaultAccount.getEmployeeQualifier());
            state.setDefaultPayerID(defaultAccount.getDefaultPayerID());
            state.setAccountTemplate(defaultAccount.getAccountTemplate());
            state.setStateName(defaultAccount.getStateName());
            state.setStateEnum(State.valueOf(state.getStateName().toUpperCase()));
            stateAccounts.add(state);
            if (stateAccounts.size() == noAccounts) break;
        }
        return stateAccounts;
    }

    public static String generate5kAltEvvVisitRecords(int noAccounts, int noRecords) throws IOException {
        int maxRecord = (noRecords != 0) ? noRecords : MAX_RECORDS;
        List<StateAccount> stateAccounts = getStateAccounts(noAccounts);
        List<AltEvvVisit> visits = new ArrayList<>();
        Map<String, AltEvvVisitDataGenerator> visitGenerators = new HashMap<>();
        String fName = "PerfAltEvvVisit" + RandomStringUtils.randomAlphabetic(10);
        String memo = commons.generateUniqueNumber();
        for (int i = 0; i < maxRecord; i++) {
            StateAccount currentAccount = stateAccounts.get(rand.nextInt(stateAccounts.size()));
            AltEvvVisitDataGenerator visitGenerator;
            if (!visitGenerators.containsKey(currentAccount.getAccountID())) {
                visitGenerator = new AltEvvVisitDataGenerator(currentAccount);
                visitGenerators.put(currentAccount.getAccountID(), visitGenerator);
            } else visitGenerator = visitGenerators.get(currentAccount.getAccountID());

            AltEvvVisit visitModel = AltEvvVisit.builder()
                    .providerIdentification(ProviderIdentification.builder().withState(currentAccount).build())
                    .call(Call.builder().enterDefaultCallInfo(60).setCallAssignment(CallAssignment.TIME_IN).build())
                    .call(Call.builder().enterDefaultCallInfo(0).setCallAssignment(CallAssignment.TIME_OUT).build())
                    .visitChange(VisitChange.builder().build())
                    .visitException(VisitException.builder().build())
                    .clientID(visitGenerator.assignRandomClient())
                    .employeeIdentifier(visitGenerator.assignRandomEmployee())
                    .memo(memo)
                    .build();

            visitModel.setSequenceID(generateUniqueSequenceIDInADay());
            visits.add(visitModel);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(visits);
        commons.generateJsonBody(jsonString, Constant.DEFAULT_FOLDER + File.separator + "Visit_" + fName + "_" + maxRecord + ".txt");
        return jsonString;
    }

    public static String generate5kAltEvvVisitForAccount(StateAccount stateAccount, int noRecords) throws IOException {
        int maxRecord = (noRecords != 0) ? noRecords : MAX_RECORDS;
        List<AltEvvVisit> visits = generateAltEvvVisits(stateAccount, maxRecord);
        return writeJsonToFile(visits, "Visit_Payload_" + noRecords + "_" + visits.get(0).getSequenceID());
    }

    public static String generateVisitPayloadWithInvalidRecords(StateAccount stateAccount, int noRecords, int numberOfValidRecords) throws IOException {
        int maxRecord = (noRecords != 0) ? noRecords : MAX_RECORDS;
        String duplicatedClientId = commons.generateUniqueNumber17Digits();
        List<AltEvvVisit> visits = generateAltEvvVisits(stateAccount, maxRecord);

        //Update invalid records by duplicate sequence id
        for (int i = numberOfValidRecords; i < visits.size(); i++) visits.get(i).setSequenceID(duplicatedClientId);

        return writeJsonToFile(visits, "Visit_InvalidPayload_" + visits.get(0).getSequenceID());
    }

    private static String writeJsonToFile(List objectList, String fileName) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(objectList);
        if (!fileName.isEmpty()) commons.generateJsonBody(json, String.format(EXPORT_FILE_PATH, fileName));
        return json;
    }

    public static List<AltEvvVisit> generateAltEvvVisits(StateAccount stateAccount, int noRecords) {
        List<AltEvvVisit> visits = new ArrayList<>();
        Map<String, AltEvvVisitDataGenerator> visitGenerators = new HashMap<>();
        String memo = commons.generateUniqueNumber();
        for (int i = 0; i < noRecords; i++) {
            AltEvvVisitDataGenerator visitGenerator;
            if (!visitGenerators.containsKey(stateAccount.getAccountID())) {
                visitGenerator = new AltEvvVisitDataGenerator(stateAccount);
                visitGenerators.put(stateAccount.getAccountID(), visitGenerator);
            } else visitGenerator = visitGenerators.get(stateAccount.getAccountID());

            AltEvvVisit visitModel = AltEvvVisit.builder()
                    .providerIdentification(ProviderIdentification.builder().withState(stateAccount).build())
                    .call(Call.builder().enterDefaultCallInfo(60).setCallAssignment(CallAssignment.TIME_IN).build())
                    .call(Call.builder().enterDefaultCallInfo(0).setCallAssignment(CallAssignment.TIME_OUT).build())
                    .visitChange(VisitChange.builder().build())
                    .visitException(VisitException.builder().build())
                    .clientID(visitGenerator.assignRandomClient())
                    .employeeIdentifier(visitGenerator.assignRandomEmployee())
                    .memo(memo)
                    .build();

            visitModel.setSequenceID(generateUniqueSequenceIDInADay());

            //Default PA, customize for different state
            switch (stateAccount.getStateEnum()) {
                case INDIANA:
                    for (Call call :
                            visitModel.getCalls())
                        call.setCallType("OTHER");
                    break;
                case VERMONT:
                    // Vermont account configured with Reason Code = 99 and ResolutionCode = A as a valid combination\
                    // -- Need to double check on configuration.
                    visitModel.getVisitChanges().get(0).setReasonCode("99");
                    visitModel.getVisitChanges().get(0).setResolutionCode("A");
                    break;
                case RHODEISLAND:
                default:
                    break;
            }

            visits.add(visitModel);
        }
        return visits;
    }

    public static String generateAltEvvClientListValidMixAccounts(int noAccounts, int noRecords, int startNumber) throws IOException {
        int maxRecord = (noRecords != 0) ? noRecords : MAX_RECORDS;
        List<AltEvvClient> clients = generateAltEvvClientListMixAccounts(noAccounts, maxRecord, startNumber);
        String fName = clients.get(0).getClientFirstName();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(clients);
        commons.generateJsonBody(json, Constant.DEFAULT_FOLDER + File.separator + fName + "_" + maxRecord + ".txt");
        return json;
    }


    public static String generateAltEvvClientListInvalidMixAccounts(int noAccounts, int noRecords, int numberOfValidRecords) throws IOException {
        int maxRecord = (noRecords != 0) ? noRecords : MAX_RECORDS;
        String duplicatedClientId = commons.generateUniqueNumber17Digits();
        List<AltEvvClient> clients = generateAltEvvClientListMixAccounts(noAccounts, maxRecord, 1);

        //Update invalid records by duplicate sequence id
        for (int i = numberOfValidRecords; i < clients.size(); i++) clients.get(i).setSequenceID(duplicatedClientId);

        return writeJsonToFile(clients, "Client_" + clients.get(0).getClientFirstName() + "_" + maxRecord);
    }

    public static List<AltEvvClient> generateAltEvvClientByAccountId(int accountId, int maxRecord, int startNumber) {
        List<AltEvvClient> clients = new ArrayList<>();
        StateAccount currentAccount = getStateAccountByAccountNumber(accountId);
        String fName = "PerfAltEvvClient" + RandomStringUtils.randomAlphabetic(10);

        for (int i = 0; i < maxRecord; i++) {
            AltEvvClient clientModel = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
            clientModel.setProviderIdentification(ProviderIdentification.builder().withState(currentAccount).build());
            clientModel.setClientFirstName(fName);

            //Generate unique client id from the given start number (0000000001 -> 0000005000)
            startNumber = startNumber + 1;
            String clientID = StringUtils.leftPad(String.valueOf(startNumber), 10, "0");
            String clientSSN = StringUtils.leftPad(String.valueOf(startNumber), 9, "0");
            clientModel.setClientID(null); // AltEvv doesn't use the ClientID, only ClientIdentifier
            clientModel.setClientIdentifier(clientID);
            clientModel.setClientCustomID(clientID);
            clientModel.setClientSSN(clientSSN);

            clientModel.setSequenceID(generateUniqueSequenceIDInADay());
            clients.add(clientModel);
        }
        return clients;
    }

    private static List generateAltEvvClientListMixAccounts(int noAccounts, int maxRecord, int startNumber) {
        List<AltEvvClient> clients = new ArrayList<>();
        List<StateAccount> stateAccounts = getStateAccounts(noAccounts);
        String fName = "PerfAltEvvClient" + RandomStringUtils.randomAlphabetic(10);

        for (int i = 0; i < maxRecord; i++) {
            StateAccount currentAccount = stateAccounts.get(rand.nextInt(stateAccounts.size()));
            AltEvvClient clientModel = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
            clientModel.setProviderIdentification(ProviderIdentification.builder().withState(currentAccount).build());
            clientModel.setClientFirstName(fName);

            //Generate unique client id from the given start number (0000000001 -> 0000005000)
            startNumber = startNumber + 1;
            String clientID = StringUtils.leftPad(String.valueOf(startNumber), 10, "0");
            String clientSSN = StringUtils.leftPad(String.valueOf(startNumber), 9, "0");
            clientModel.setClientID(null); // AltEvv doesn't use the ClientID, only ClientIdentifier
            clientModel.setClientIdentifier(clientID);
            clientModel.setClientCustomID(clientID);
            clientModel.setClientSSN(clientSSN);

            clientModel.setSequenceID(generateUniqueSequenceIDInADay());
            clients.add(clientModel);
        }
        return clients;
    }

    public static String generate5kAltEvvEmployeeRecords(int noAccounts, int noRecords, int startNumber) throws IOException {
        int maxRecord = (noRecords != 0) ? noRecords : MAX_RECORDS;

        List<StateAccount> stateAccounts = getStateAccounts(noAccounts);
        List<AltEvvEmployee> employees = new ArrayList<>();
        String fName = "PerfAltEvvEmp" + RandomStringUtils.randomAlphabetic(10);

        for (int i = 0; i < maxRecord; i++) {
            StateAccount currentAccount = stateAccounts.get(rand.nextInt(stateAccounts.size()));
            ProviderIdentification providerIdentification = ProviderIdentification.builder().withState(currentAccount).build();
            AltEvvEmployee employeeModel = AltEvvEmployeeDataGenerator.getAltEvvEmployeeByState(currentAccount);
            employeeModel.setProviderIdentification(providerIdentification);
            employeeModel.setEmployeeFirstName(fName);

            //Generate unique employee identifier from the given start number
            startNumber = startNumber + 1;
            String employeeID = StringUtils.leftPad(String.valueOf(startNumber), 9, "0");
            employeeModel.setEmployeeIdentifier(employeeID);
            employeeModel.setEmployeeSSN(employeeID);
            employeeModel.setSequenceID(generateUniqueSequenceIDInADay());
            employees.add(employeeModel);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(employees);
        commons.generateJsonBody(json, Constant.DEFAULT_FOLDER + File.separator + fName + "_" + maxRecord + ".txt");
        return json;
    }


    public static List<AltEvvEmployee> generateAltEvvEmployeeListByAccountNumber(int accountNumber, int noRecords, int startNumber) throws IOException {
        int maxRecord = (noRecords != 0) ? noRecords : MAX_RECORDS;

        StateAccount currentAccount = getStateAccountByAccountNumber(accountNumber);
        List<AltEvvEmployee> employees = new ArrayList<>();
        String fName = "PerfAltEvvEmp" + RandomStringUtils.randomAlphabetic(10);

        for (int i = 0; i < maxRecord; i++) {

            ProviderIdentification providerIdentification = ProviderIdentification.builder().withState(currentAccount).build();
            AltEvvEmployee employeeModel = AltEvvEmployeeDataGenerator.getAltEvvEmployeeByState(currentAccount);
            employeeModel.setProviderIdentification(providerIdentification);
            employeeModel.setEmployeeFirstName(fName);

            //Generate unique employee identifier from the given start number

            String employeeID = StringUtils.leftPad(String.valueOf(startNumber), 9, "0");
            startNumber = startNumber + 1;
            employeeModel.setEmployeeIdentifier(employeeID);
            employeeModel.setEmployeeSSN(employeeID);
            employeeModel.setSequenceID(generateUniqueSequenceIDInADay());
            employees.add(employeeModel);
        }

        return employees;
    }


    /***Return the unique SequenceID from the yyyyMMddHHmmssSSS by removing the first 2 yy, and add 2 random number at the end.
     **/
    private static String generateUniqueSequenceIDInADay() {
        String dateTimeFormat = "yyyyMMddHHmmss";
        String clientSequenceID = new SimpleDateFormat(dateTimeFormat).format(new Date());
        //Client body doesn't accept 2 sequenceId have the same value. Have to modify by its sequence number.
        return clientSequenceID + RandomStringUtils.randomNumeric(2);
    }

    public static void main(String[] args) throws IOException {
/*
        List<AltEvvClient> clients = generateAltEvvClientByAccountId(324241, 10, 10000);
        writeJsonToFile(clients, "324241_Client_" + clients.get(0).getClientFirstName());

        List<AltEvvEmployee> employees = generateAltEvvEmployeeListByAccountNumber(324241, 10, 10000);
        writeJsonToFile(employees, "324241_Employee_" + employees.get(0).getEmployeeFirstName());
*/


        StateAccount stateAccount = AltEvvDataGenerator.getStateAccountByAccountNumber(60247);
        List<AltEvvVisit> visits = AltEvvDataGenerator.generateAltEvvVisits(stateAccount, 2);
        writeJsonToFile(visits, "324241_Visits_");
    }
}