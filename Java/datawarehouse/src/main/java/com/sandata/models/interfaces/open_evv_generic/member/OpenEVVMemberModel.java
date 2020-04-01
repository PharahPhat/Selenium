package com.sandata.models.interfaces.open_evv_generic.member;

import com.google.gson.annotations.Expose;
import com.sandata.common.Constant;
import com.interop.common.StateAccount;
import com.sandata.common.resource.Client;
import com.sandata.models.GenericModel;
import com.sandata.models.interfaces.open_evv_connecticut.client.OpenEVVClientModel;
import com.sandata.models.interfaces.open_evv_generic.client.ClientDesignees_A;
import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.sandata.common.Constant.ClientDBColumns.*;
import static com.sandata.common.Constant.ClientType.*;

public class OpenEVVMemberModel extends GenericModel {
    @Expose
    public transient List<OpenEVVMemberModel> openEVVMemberModelList;
    @Expose
    public transient OpenEVVMemberModel openEVVMemberModel;
    @Expose
    public transient List<String> clientIds;
    public String ClientID;
    public String ClientFirstName;
    public String ClientMiddleInitial;
    public String ClientLastName;
    public String ClientSSN;
    public String ClientMedicalRecordNumber;
    public String ClientCustomID;
    public String ClientOtherID;
    public String ClientSuffix;
    public String Action;
    public String ProviderQualifier;
    public String ProviderID;
    public String CaseManager;
    public String ClientCaseManagerEmail;
    public String ClientCoordinatorEmail;
    public String ClientLanguage;
    public String ClientGender;
    public String ClientBirthDate;
    public String ClientMaritalStatus;
    public String ClientEmail;
    public String ClientPriority;
    public String ClientTimeZone;
    public String ClientDesigneeFirstName;
    public String ClientDesigneeLastName;
    public String ClientDesigneeEmail;
    public String ClientDesigneeStatus;
    public String ClientDesigneeStartDate;
    public String ClientDesigneeEndDate;
    public String MemberEnrollmentDate;
    private List<ClientEligibility_A> ClientEligibility;
    private List<ClientContact_A> ClientContact;
    private List<ClientAddress_A> ClientAddress;
    private List<ClientPhone_A> ClientPhone;
    private List<ClientWorkerXref_A> ClientWorkerXref;
    private List<ClientDesignees_A> ClientDesignee;

    public static OpenEVVMemberModel initModelByState(StateAccount state) {
        OpenEVVMemberModel model = new OpenEVVMemberModel();
        model = model.initOpenEVVGenericData();

        model.ProviderID = state.getProviderID();
        model.ProviderQualifier = state.getProviderQualifier();
        model.ClientEligibility.get(0).PayerID = state.getDefaultPayerID();
        model.ClientEligibility.get(0).PayerProgram = state.getDefaultPayerProgram();
        model.ClientEligibility.get(0).PayerService = state.getDefaultProcedureCode();
        return model;
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }

    public List<ClientEligibility_A> createClientEligibilities(int count) {

        List<ClientEligibility_A> clientEligibilities = new ArrayList<>();

        for (int i = 0; i <= count - 1; i++) {
            ClientEligibility_A clientEligibility = new ClientEligibility_A();
            clientEligibility.PayerID = "INFSSA";
            clientEligibility.PayerProgram = "Indiana";
            clientEligibility.PayerService = "S5130";
            clientEligibility.PayerRegion = "NA";
            clientEligibility.ClientEligibilityDateBegin = commons.getDateString(-30, "yyyy-MM-dd");
            clientEligibility.ClientEligibilityDateEnd = commons.getDateString(30, "yyyy-MM-dd");
            clientEligibility.ClientStartOfCareDate = commons.getDateString(-30, "yyyy-MM-dd");
            clientEligibility.ClientEndOfCareDate = commons.getDateString(30, "yyyy-MM-dd");
            clientEligibility.ClientPrimaryDiagnosisCode = "M54.2";
            clientEligibility.ClientSecondaryDiagnosisCode = "M54.1";
            clientEligibility.ClientStatus = Constant.ClientStatus.Active.toString();
            clientEligibility.ClientStatusDate = commons.getDateString(-30, "yyyy-MM-dd");
            clientEligibility.Modifier1 = "A1";
            clientEligibility.Modifier2 = "A2";
            clientEligibility.Modifier3 = "A3";
            clientEligibility.Modifier4 = "A4";

            clientEligibilities.add(clientEligibility);
        }

        return clientEligibilities;
    }

    public List<ClientContact_A> createClientContacts(int count) {
        String unique = commons.generateUniqueNumber();
        List<ClientContact_A> clientContacts = new ArrayList<>();

        for (int i = 0; i <= count - 1; i++) {
            ClientContact_A clientContact = new ClientContact_A();
            clientContact.ClientContactType = Constant.ClientContactType.Other.toString();
            clientContact.ClientContactFirstName = "CLCFN" + RandomStringUtils.randomAlphabetic(25);
            clientContact.ClientContactLastName = "CLCLN" + RandomStringUtils.randomAlphabetic(25);
            clientContact.ClientContactPhoneType = Constant.ClientContactPhoneType.Business.toString();
            clientContact.ClientContactPhone = RandomStringUtils.randomNumeric(10);
            clientContact.ClientContactEmailAddress = "STX" + unique + "@sandata.com";
            clientContact.ClientContactAddressLine1 = "CLC address 1" + RandomStringUtils.randomAlphanumeric(17);
            clientContact.ClientContactAddressLine2 = "CLC address 2" + RandomStringUtils.randomAlphanumeric(17);
            clientContact.ClientContactCity = "Manhattan";
            clientContact.ClientContactState = Constant.CLIENTSTATE[new Random().nextInt(Constant.CLIENTSTATE.length)];
            clientContact.ClientContactZip = "10017";
            clientContacts.add(clientContact);
        }
        return clientContacts;
    }

    public List<ClientAddress_A> createClientAddresses(int count) {
        List<ClientAddress_A> clientAddresses = new ArrayList<>();
        for (int i = 0; i <= count - 1; i++) {
            ClientAddress_A clientAddress = new ClientAddress_A();

            clientAddress.ClientAddressType = Constant.ClientAddressType.Home.toString();
            clientAddress.ClientAddressLine1 = "CLA address 1" + RandomStringUtils.randomAlphanumeric(17);
            clientAddress.ClientAddressLine2 = "CLA address 2" + RandomStringUtils.randomAlphanumeric(17);
            clientAddress.ClientCounty = "HA";
            clientAddress.ClientCity = "New York";
            clientAddress.ClientState = Constant.CLIENTSTATE[new Random().nextInt(Constant.CLIENTSTATE.length)];
            clientAddress.ClientZip = "11235";
            clientAddresses.add(clientAddress);
        }
        return clientAddresses;
    }

    public List<ClientPhone_A> createClientPhones(int count) {
        List<ClientPhone_A> ClientPhones = new ArrayList<>();
        for (int i = 0; i <= count - 1; i++) {
            ClientPhone_A clientPhone = new ClientPhone_A();
            clientPhone.ClientPhoneType = Constant.ClientPhoneType.Home.toString();
            clientPhone.ClientPhone = RandomStringUtils.randomNumeric(10);

            ClientPhones.add(clientPhone);
        }
        return ClientPhones;
    }

    public List<ClientWorkerXref_A> createClientWorkerXrefs(int count) {
        List<ClientWorkerXref_A> clientWorkerXrefs = new ArrayList<>();
        for (int i = 0; i <= count - 1; i++) {
            ClientWorkerXref_A clientWorkerXref = new ClientWorkerXref_A();

            clientWorkerXref.Account = account_id;
            clientWorkerXref.VendorCode = "12V";
            clientWorkerXref.EmployeePIN = RandomStringUtils.randomNumeric(9);
            clientWorkerXref.Service = "T1001";
            clientWorkerXref.XRefStartDate = commons.getDateString(-10, "yyyy-MM-dd");
            clientWorkerXref.XRefEndDate = commons.getDateString(30, "yyyy-MM-dd");
            clientWorkerXrefs.add(clientWorkerXref);
        }
        return clientWorkerXrefs;
    }

    public List<String> getClientIds() {
        clientIds = new ArrayList<>();
        for (int i = 0; i <= openEVVMemberModelList.size() - 1; i++) {
            clientIds.add(openEVVMemberModelList.get(i).ClientID);
        }
        return clientIds;
    }

    public void setClientIds(List<String> clientIds) {
        this.clientIds = clientIds;
    }

    public boolean getFinalStatus() {
        boolean result = getFinalStatus(Client.INTAKE_CHECK_STATUS);
        return result;
    }

    /***
     * Validate field 'ClientContactType' in table 'ClientContact', validate response status as well as in database
     * dataType = {alphabetic, numeric, alphaNumeric, userInput}
     * if dataType = userInput, user should transfer value to the parameter input
     * @param dataType {alphabetic, numeric, alphaNumeric, userInput}
     * @param maxLength
     * @param input
     * @param expected
     * @return
     */

    public boolean ClientID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        return true;
    }

    /***
     * Init data for 1 clients with 1 segment
     * @return
     */
    public void initData(int count) {
        if (count < 1) {
            return;
        }
        openEVVMemberModelList = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            OpenEVVMemberModel openEVVMemberModel = initOpenEVVGenericData();
            this.openEVVMemberModelList.add(openEVVMemberModel);
        }
    }

    /***
     * Init data for multiple clients with multiple segments
     * @param count number of clients
     * @param ClientEligibility number of ClientEligibility
     * @param ClientContact number of ClientContact
     * @param ClientAddress number of ClientAddress
     * @param ClientPhone number of ClientPhone
     * @param ClientWorkerXref number of ClientWorkerXref
     * @return
     */
    public void initData(int count, int ClientEligibility, int ClientContact, int ClientAddress,
                         int ClientPhone, int ClientWorkerXref) {
        if (count < 1) {
            return;
        }
        openEVVMemberModelList = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            OpenEVVMemberModel openEVVMemberModel = initOpenEVVGenericData(ClientEligibility, ClientContact,
                    ClientAddress, ClientPhone, ClientWorkerXref);
            this.openEVVMemberModelList.add(openEVVMemberModel);
        }
    }

    public OpenEVVMemberModel initOpenEVVGenericData(int ClientEligibility, int ClientContact, int ClientAddress,
                                                     int ClientPhone, int ClientWorkerXref) {
        String unique = commons.generateUniqueNumber();
        super.initData();
        OpenEVVMemberModel openEVVMemberModel = new OpenEVVMemberModel();

        List<ClientEligibility_A> clientEligibilities = createClientEligibilities(ClientEligibility);
        List<ClientContact_A> clientContacts = createClientContacts(ClientContact);
        List<ClientAddress_A> clientAddresses = createClientAddresses(ClientAddress);
        List<ClientPhone_A> clientPhones = createClientPhones(ClientPhone);
        List<ClientWorkerXref_A> clientWorkerXrefs = createClientWorkerXrefs(ClientWorkerXref);

        openEVVMemberModel.ClientID = clientDbService.generateNewClientId(account_id);
        openEVVMemberModel.ClientFirstName = RandomStringUtils.randomAlphabetic(30);
        openEVVMemberModel.ClientMiddleInitial = "T";
        openEVVMemberModel.ClientLastName = RandomStringUtils.randomAlphabetic(30);
        openEVVMemberModel.ClientSSN = clientDbService.generateNewClientSsn(account_id);
        openEVVMemberModel.ClientMedicalRecordNumber = RandomStringUtils.randomNumeric(12);
        openEVVMemberModel.ClientCustomID = clientDbService.generateNewClientIDCustomer1(account_id, 24);
        openEVVMemberModel.ClientOtherID = clientDbService.generateNewClientIDCustomer2(24);
        openEVVMemberModel.ClientSuffix = "Sr";
        openEVVMemberModel.Action = "A";
        openEVVMemberModel.ProviderQualifier = "SandataID";
        openEVVMemberModel.ProviderID = provider_id;
        openEVVMemberModel.CaseManager = "";
        openEVVMemberModel.ClientCaseManagerEmail = "";
        openEVVMemberModel.ClientCoordinatorEmail = "";
        openEVVMemberModel.ClientLanguage = "";
        openEVVMemberModel.ClientGender = "M";
        openEVVMemberModel.ClientBirthDate = "1990-01-02";
        openEVVMemberModel.ClientMaritalStatus = "M";
        openEVVMemberModel.ClientEmail = "STX" + unique + "@sandata.com";
        openEVVMemberModel.ClientPriority = "";
        openEVVMemberModel.ClientTimeZone = "US/Eastern";
        openEVVMemberModel.ClientDesigneeFirstName = "DesigneeFN" + RandomStringUtils.randomAlphabetic(20);
        openEVVMemberModel.ClientDesigneeLastName = "DesigneeLN" + RandomStringUtils.randomAlphabetic(20);
        openEVVMemberModel.ClientDesigneeEmail = "STXDesignee" + unique + "@sandata.com";
        openEVVMemberModel.ClientDesigneeStatus = Constant.ClientStatus.Active.toString();
        openEVVMemberModel.ClientDesigneeStartDate = commons.getDateString(-10, "yyyy-MM-dd");
        openEVVMemberModel.ClientDesigneeEndDate = commons.generateClientDesigneeEndDate(0, "yyyy-MM-dd", "US/Eastern");

        openEVVMemberModel.ClientEligibility = clientEligibilities;
        openEVVMemberModel.ClientContact = clientContacts;
        openEVVMemberModel.ClientAddress = clientAddresses;
        openEVVMemberModel.ClientPhone = clientPhones;
        openEVVMemberModel.ClientWorkerXref = clientWorkerXrefs;

        return openEVVMemberModel;
    }

    public OpenEVVMemberModel initOpenEVVGenericData() {
        String unique = commons.generateUniqueNumber();

        super.initData();
        OpenEVVMemberModel openEVVMemberModel = new OpenEVVMemberModel();

        openEVVMemberModel.ClientID = RandomStringUtils.randomAlphabetic(10);
        openEVVMemberModel.ClientFirstName = RandomStringUtils.randomAlphabetic(30);
        openEVVMemberModel.ClientMiddleInitial = "T";
        openEVVMemberModel.ClientLastName = RandomStringUtils.randomAlphabetic(30);
        openEVVMemberModel.ClientSSN = RandomStringUtils.randomNumeric(9);
        openEVVMemberModel.ClientMedicalRecordNumber = RandomStringUtils.randomNumeric(12);
        openEVVMemberModel.ClientCustomID = commons.generateUniqueNumber();
        openEVVMemberModel.ClientOtherID = commons.generateUniqueNumber();
        openEVVMemberModel.ClientSuffix = "Sr";
        openEVVMemberModel.Action = "A";
        openEVVMemberModel.ProviderQualifier = "SandataID";
        openEVVMemberModel.ProviderID = provider_id;
        openEVVMemberModel.CaseManager = "";
        openEVVMemberModel.ClientCaseManagerEmail = "";
        openEVVMemberModel.ClientCoordinatorEmail = "";
        openEVVMemberModel.ClientLanguage = "";
        openEVVMemberModel.ClientGender = "M";
        openEVVMemberModel.ClientBirthDate = "1990-01-02";
        openEVVMemberModel.ClientMaritalStatus = "M";
        openEVVMemberModel.ClientEmail = "STX" + unique + "@sandata.com";
        openEVVMemberModel.ClientPriority = "";
        openEVVMemberModel.ClientTimeZone = "US/Eastern";
        openEVVMemberModel.MemberEnrollmentDate = commons.getDateString(-10, "yyyy-MM-dd");

        openEVVMemberModel.setClientEligibility(createClientEligibilities(1));
        openEVVMemberModel.setClientAddress(createClientAddresses(1));
        openEVVMemberModel.setClientPhone(createClientPhones(1));

        OpenEVVClientModel openEVVClientModel = new OpenEVVClientModel();
        openEVVMemberModel.setClientDesignees(openEVVClientModel.createClientDesignees(1));
        openEVVMemberModel.getClientDesignees().get(0).setClientDesigneeRelationship("Mother");
//        openEVVMemberModel.getClientDesignees().get(1).setClientDesigneeRelationship("Father");

        return openEVVMemberModel;
    }

    /***
     * Create multiple clients with multiple segments
     * @param count number of clients, each client will have 1 segment
     * @return
     */
    public boolean createMultipleClients(int count) {
        int retry1 = 10;
        int retry2 = 3;
        int i = 1;
        int j = 1;

        while (i <= retry1) {
            initData(count);
            while (j <= retry2) {
                boolean output1 = post();
                if (output1) {
                    logInfo(String.format("SUCCESS: Post request to create open generic client"));
                    boolean output2 = getFinalStatus();

                    List<String> clientIds = getClientIds();
                    boolean areAllClientsExistInDB = clientDbService.areClientsExistInDatabase(account_id, clientIds);

                    if (output2 && areAllClientsExistInDB) {
                        for (int k = 0; k <= count - 1; k++) {
                            logPass(String.format("SUCCESS: Post request to create client, client '%s' is added into EVV Database Successfully", openEVVMemberModelList.get(k).ClientID));
                        }
                        return true;
                    }
                } else {
                    logInfo(String.format("FAILED: Post request to create '%s' clients", count));
                }
                j++;
            }
            i++;
        }
        return false;
    }

    /***
     * Create multiple clients with multiple segments
     * @param clientCount number of clients
     * @param ClientEligibility number of ClientEligibility
     * @param ClientContact number of ClientContact
     * @param ClientAddress number of ClientAddress
     * @param ClientPhone number of ClientPhone
     * @param ClientWorkerXref number of ClientWorkerXref
     * @return
     */
    public boolean createMulipleClients(int clientCount, int ClientEligibility, int ClientContact, int ClientAddress,
                                        int ClientPhone, int ClientWorkerXref) {
        int retry1 = 10;
        int retry2 = 3;
        int i = 1;
        int j = 1;

        while (i <= retry1) {
            initData(clientCount, ClientEligibility, ClientContact, ClientAddress, ClientPhone, ClientWorkerXref);
            while (j <= retry2) {
                boolean output1 = post();
                if (output1) {
                    logInfo(String.format("SUCCESS: Post request to create open generic client"));
                    boolean output2 = getFinalStatus();

                    List<String> clientIds = getClientIds();
                    boolean areAllClientsExistInDB = clientDbService.areClientsExistInDatabase(account_id, clientIds);

                    if (output2 && areAllClientsExistInDB) {
                        for (int k = 0; k <= clientCount - 1; k++) {
                            logPass(String.format("SUCCESS: Post request to create client, client '%s' is added into EVV Database Successfully", openEVVMemberModelList.get(k).ClientID));
                        }
                        return true;
                    }
                } else {
                    logInfo(String.format("FAILED: Post request to create '%s' clients", clientCount));
                }
                j++;
            }
            i++;
        }
        return false;
    }

    public boolean post() {
        request_url = getTestEnvironment().get("intake_endpoint") + Client.INTAKE_OPEN_EVV_GENERIC_IMPORT_MEMBER;
        boolean result = post(openEVVMemberModel, request_url);
        return result;
    }

    public boolean ClientContactType(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientContact.get(0).ClientContactType = value;

        logInfo(String.format("Request to create client with ClientContactType with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(contact, CLC_CONTACT_TYPE_CODE, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientContactFirstName(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientContact.get(0).ClientContactFirstName = value;

        logInfo(String.format("Request to create client with ClientContactFirstName with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(contact, CLC_F_NAME, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientContactLastName(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientContact.get(0).ClientContactLastName = value;

        logInfo(String.format("Request to create client with ClientContactLastName with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(contact, CLC_L_NAME, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientMiddleInitial(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientMiddleInitial = value;
        logInfo(String.format("Request to create client with ClientMiddleInitial with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CL_M_NAME, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientSSN(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientSSN = value;
        logInfo(String.format("Request to create client with ClientSSN with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CLS_CLIENT_SSN, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientMedicalRecordNumber(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientMedicalRecordNumber = value;
        logInfo(String.format("Request to create client with ClientMedicalRecordNumber with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CLS_MRN, input, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientCustomID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientCustomID = value;
        logInfo(String.format("Request to create client with ClientCustomID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CLS_MEDICAID_ID, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientOtherID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientOtherID = value;
        logInfo(String.format("Request to create client with ClientOtherID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CLS_CLIENT_ID_CUSTOM1, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientSuffix(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientSuffix = value;
        logInfo(String.format("Request to create client with ClientSuffix with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CL_NAME_SUFFIX, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ProviderQualifier(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ProviderQualifier = value;
        logInfo(String.format("Request to create client with ProviderQualifier with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean ProviderID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ProviderID = value;
        logInfo(String.format("Request to create client with ProviderID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(auth_limit, AU_PROVIDER, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean CaseManager(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).CaseManager = value;
        logInfo(String.format("Request to create client with CaseManager with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CLS_CASE_MANAGER, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientCaseManagerEmail(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientCaseManagerEmail = value;
        logInfo(String.format("Request to create client with CaseManager with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CLS_CASE_MANAGER_E_MAIL, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientCoordinatorEmail(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientCoordinatorEmail = value;
        logInfo(String.format("Request to create client with ClientCoordinatorEmail with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CL_SPV_E_MAIL, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientLanguage(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientLanguage = value;
        logInfo(String.format("Request to create client with ClientLanguage with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CLS_LANGUAGE, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientGender(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientGender = value;
        logInfo(String.format("Request to create client with ClientGender with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CLS_SEX, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientMaritalStatus(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientMaritalStatus = value;
        logInfo(String.format("Request to create client with ClientMaritalStatus with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CLS_MARITAL_STATUS_CODE, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientBirthDate(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientBirthDate = value;
        logInfo(String.format("Request to create client with ClientMaritalStatus with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CLS_DOB, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientEmail(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEmail = value;
        logInfo(String.format("Request to create client with ClientEmail with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CLS_EMAIL, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientAction(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).Action = value;
        logInfo(String.format("Request to create client with Action with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        return (result1);
    }

    public boolean ClientContactPhoneType(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientContact.get(0).ClientContactPhoneType = value;

        logInfo(String.format("Request to create client with ClientContactPhoneType with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean ClientContactPhone(Constant.DataType dataType, int maxLength, String phoneType, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientContact.get(0).ClientContactPhoneType = phoneType;
        openEVVMemberModelList.get(0).ClientContact.get(0).ClientContactPhone = value;

        logInfo(String.format("Request to create client with ClientContactPhone with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = false;
        switch (phoneType) {
            case "Business":
                result3 = validateClientRecordsExistInDatabase(contact, CLC_PHONENUM_BUSINESS, value, expected);
                break;
            case "Home":
                result3 = validateClientRecordsExistInDatabase(contact, CLC_PHONENUM_HOME, value, expected);
                break;
            case "Mobile":
                result3 = validateClientRecordsExistInDatabase(contact, CLC_PHONENUM_MOBILE, value, expected);
                break;
            case "Other":
                result3 = validateClientRecordsExistInDatabase(contact, CLC_PHONENUM_OTHER, value, expected);
                break;
            default:
                boolean result3_1 = validateClientRecordsExistInDatabase(contact, CLC_PHONENUM_BUSINESS, value, expected);
                boolean result3_2 = validateClientRecordsExistInDatabase(contact, CLC_PHONENUM_HOME, value, expected);
                boolean result3_3 = validateClientRecordsExistInDatabase(contact, CLC_PHONENUM_MOBILE, value, expected);
                boolean result3_4 = validateClientRecordsExistInDatabase(contact, CLC_PHONENUM_OTHER, value, expected);
                result3 = result3_1 && result3_2 && result3_3 && result3_4;
                break;
        }

        return (result1 && result2 & result3);
    }

    public boolean ClientContactEmailAddress(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientContact.get(0).ClientContactEmailAddress = value;

        logInfo(String.format("Request to create client with ClientContactEmailAddress with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(contact, CLC_E_MAIL, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientContactAddressLine1(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientContact.get(0).ClientContactAddressLine1 = value;

        logInfo(String.format("Request to create client with ClientContactAddressLine1 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(contact, CLC_ADDR1, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientContactAddressLine2(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientContact.get(0).ClientContactAddressLine2 = value;

        logInfo(String.format("Request to create client with ClientContactAddressLine2 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(contact, CLC_ADDR2, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientContactCity(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientContact.get(0).ClientContactCity = value;

        logInfo(String.format("Request to create client with ClientContactCity with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(contact, CLC_CITY, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientContactState(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientContact.get(0).ClientContactState = value;

        logInfo(String.format("Request to create client with ClientContactState with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(contact, CLC_STATE, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientContactZip(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientContact.get(0).ClientContactZip = value;

        logInfo(String.format("Request to create client with ClientContactZip with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(contact, CLC_ZIPCODE, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientAddressType(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientAddress.get(0).ClientAddressType = value;

        logInfo(String.format("Request to create client with ClientAddressType with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(address, CLS_ADDR_TYPE_QLFR, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientAddressLine1(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientAddress.get(0).ClientAddressLine1 = value;

        logInfo(String.format("Request to create client with ClientAddressLine1 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(address, CLS_ADDR1, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientAddressLine2(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientAddress.get(0).ClientAddressLine2 = value;

        logInfo(String.format("Request to create client with ClientAddressLine2 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(address, CLS_ADDR2, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientCounty(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientAddress.get(0).ClientCounty = value;

        logInfo(String.format("Request to create client with ClientCounty with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(address, CLS_COUNTY, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientCity(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientAddress.get(0).ClientCity = value;

        logInfo(String.format("Request to create client with ClientCity with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(address, CLS_CITY, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientState(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientAddress.get(0).ClientState = value;

        logInfo(String.format("Request to create client with ClientState with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(address, CLS_STATE, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientZip(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientAddress.get(0).ClientZip = value;

        logInfo(String.format("Request to create client with ClientZip with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(address, CLS_ZIP_CODE, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientPhoneType(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        input = generateFieldValue(dataType, maxLength, input);

        openEVVMemberModelList.get(0).ClientPhone.get(0).ClientPhoneType = input;

        logInfo(String.format("Request to create client with ClientPhoneType with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, input, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        input = input.isEmpty() ? "Other" : input;

        boolean result3 = validateClientRecordsExistInDatabase(ani, AN_DESCRIPTION, input, expected);
        return (result1 && result2 & result3);
    }

    public boolean ClientPhone(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientPhone.get(0).ClientPhone = value;

        logInfo(String.format("Request to create client with ClientPhone with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(ani, ANI_ANI, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean VendorCode(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientWorkerXref.get(0).VendorCode = value;

        logInfo(String.format("Request to create client with VendorCode with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean EmployeePIN(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientWorkerXref.get(0).EmployeePIN = value;

        logInfo(String.format("Request to create client with EmployeePIN (STX_ID) with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(xref, XREF_STX_ID, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean Service(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientWorkerXref.get(0).EmployeePIN = value;

        logInfo(String.format("Request to create client with Service with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(xref, XREF_SERVICE, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean XRefStartDate(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientWorkerXref.get(0).XRefStartDate = value;
        openEVVMemberModelList.get(0).ClientWorkerXref.get(1).XRefStartDate = value;

        logInfo(String.format("Request to create client with XRefStartDate with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(xref, XREF_BEG_DATE, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean XRefEndDate(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientWorkerXref.get(0).XRefEndDate = value;
        openEVVMemberModelList.get(0).ClientWorkerXref.get(1).XRefEndDate = value;

        logInfo(String.format("Request to create client with XRefEndDate with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(xref, XREF_END_DATE, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean PayerID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEligibility.get(0).PayerID = value;

        logInfo(String.format("Request to create client with PayerID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(auth_limit, AU_PAYOR_ID, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean PayerProgram(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEligibility.get(0).PayerProgram = value;

        logInfo(String.format("Request to create client with PayerProgram with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(auth_limit, AL_PROGRAM, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean PayerService(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEligibility.get(0).PayerService = value;

        logInfo(String.format("Request to create client with PayerService with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(auth_limit, AL_SERVICE, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean PayerRegion(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEligibility.get(0).PayerRegion = value;

        logInfo(String.format("Request to create client with PayerRegion with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CLS_REGION, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientEligibilityDateBegin(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEligibility.get(0).ClientEligibilityDateBegin = value;

        logInfo(String.format("Request to create client with ClientEligibilityDateBegin with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(auth_limit, AU_BEG_DATE, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientEligibilityDateEnd(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEligibility.get(0).ClientEligibilityDateEnd = value;

        logInfo(String.format("Request to create client with ClientEligibilityDateEnd with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(auth_limit, AU_END_DATE, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientStartOfCareDate(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEligibility.get(0).ClientEligibilityDateBegin = value;
        openEVVMemberModelList.get(0).ClientEligibility.get(0).ClientStartOfCareDate = value;

        logInfo(String.format("Request to create client with ClientStartOfCareDate with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(auth_limit, AU_BEG_DATE, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientEndOfCareDate(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEligibility.get(0).ClientEligibilityDateEnd = value;
        openEVVMemberModelList.get(0).ClientEligibility.get(0).ClientEndOfCareDate = value;

        logInfo(String.format("Request to create client with ClientEndOfCareDate with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(auth_limit, AU_END_DATE, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientPrimaryDiagnosisCode(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEligibility.get(0).ClientPrimaryDiagnosisCode = value;

        logInfo(String.format("Request to create client with ClientPrimaryDiagnosisCode with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(auth_limit, AU_DIAGNOSIS_CODE, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean validateResponseStatus(boolean isResponseSuccess, boolean finalStatus, Constant.DataType dataType,
                                          int maxLength, String input, boolean expected) {

        if (isResponseSuccess == expected
                && finalStatus == expected) {
            logInfo(String.format("Request to create client with ClientContactType with data type: '%s', length '%s', user input: '%s' successfully",
                    dataType.toString(), maxLength, input));
            logPass(String.format("Passed. Response status is '%s' matched with Expected Result is '%s'", isResponseSuccess, expected));
            return true;
        } else {
            logInfo(String.format("Failed to create client with ClientContactType with data type: '%s', length '%s', user input: '%s'.",
                    dataType.toString(), maxLength, input));
        }
        return false;
    }

    /***
     * Validate basic client information record is inserted into STX.Clients or not
     * @param expected
     * @return
     */
    public boolean validateClientRecordsExistInDatabase(boolean expected) {
        List<String> locs = getClientIds();

        boolean result = clientDbService.areClientsExistInDatabase(account_id, locs, expected);

        if (result) {
            if (expected) {
                logPass("PASSED. Record(s) inserted into DB because expected is " + expected);
            } else {
                logPass("PASSED. Record(s) not inserted into DB because expected is " + expected);
            }
        } else {
            if (expected) {
                logError("FAILED. Record(s) not inserted into DB when expected is " + expected);
            } else {
                logError("FAILED. Record(s) inserted into DB when expected is " + expected);
            }
        }
        return result;
    }

    public boolean validateClientRecordsExistInDatabase(Constant.ClientType clientType, Constant.ClientDBColumns columnName, String value, boolean expected) {
        List<String> locs = getClientIds();

        List<Map<String, Object>> rows = new ArrayList<>();

        switch (clientType) {
            case basic_info:
                rows = clientDbService.getClientBasicInformation(account_id, locs, expected);
                break;
            case auth_limit:
                rows = clientDbService.getClientAuthAndAuthLimit(account_id, locs, expected);
                break;
            case address:
                rows = clientDbService.getClientAddress(account_id, locs, expected);
                break;
            case contact:
                rows = clientDbService.getClientContact(account_id, locs, expected);
                break;
            case ani:
                rows = clientDbService.getClientAni(account_id, locs, expected);
                break;
            case app_user:
                rows = clientDbService.getClientAppUser(account_id, locs, expected);
                break;
            case xref:
                rows = clientDbService.getClientXref(account_id, locs, expected);
                break;
        }

        boolean result = isRowExist(rows, columnName.toString(), value);
        boolean finalResult = false;
        if (result) {
            if (expected) {
                logPass(String.format("PASSED. FOUND Row with column name '%s' & value '%s' because expected is '%s'", columnName, value, expected));
                finalResult = true;
            } else {
                logError(String.format("FAILED. FOUND Row with column name '%s' & value '%s' while expected is '%s'", columnName, value, expected));
                finalResult = false;
            }
        } else {
            if (expected) {
                logError(String.format("FAILED. NOT FOUND Row with column name '%s' & value '%s' while expected is '%s'", columnName, value, expected));
                finalResult = false;
            } else {
                logPass(String.format("PASSED. NOT FOUND Row with column name '%s' & value '%s' because expected is '%s'", columnName, value, expected));
                finalResult = true;
            }
        }
        return finalResult;
    }

    public boolean ClientSecondaryDiagnosisCode(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEligibility.get(0).ClientSecondaryDiagnosisCode = value;

        logInfo(String.format("Request to create client with ClientSecondaryDiagnosisCode with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    // TODO:
    public boolean ClientStatus(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEligibility.get(0).ClientStatus = value;

        logInfo(String.format("Request to create client with ClientStatus with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(auth_limit, CLS_REGION, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientStatusDate(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEligibility.get(0).ClientStatusDate = value;

        logInfo(String.format("Request to create client with ClientStatusDate with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean Modifier1(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEligibility.get(0).Modifier1 = value;

        logInfo(String.format("Request to create client with Modifier1 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(auth_limit, AL_MODIFIER1, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean Modifier2(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEligibility.get(0).Modifier2 = value;

        logInfo(String.format("Request to create client with Modifier2 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(auth_limit, AL_MODIFIER2, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean Modifier3(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEligibility.get(0).Modifier3 = value;

        logInfo(String.format("Request to create client with Modifier3 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(auth_limit, AL_MODIFIER3, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean Modifier4(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientEligibility.get(0).Modifier4 = value;

        logInfo(String.format("Request to create client with Modifier4 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(auth_limit, AL_MODIFIER4, value, expected);

        return (result1 && result2 & result3);
    }

    private boolean isRowExist(List<Map<String, Object>> rows, String columnName, String value) {
        for (int i = 0; i <= rows.size() - 1; i++) {
            Map<String, Object> row = rows.get(i);
            if (value != null && !value.isEmpty()) {
                if (row.size() != 0 && row.get(columnName) != null && String.valueOf(row.get(columnName)).contains(value)) {
                    logInfo(String.format("FOUND Row '%s' with column name '%s' has value '%s'", i, columnName, row.get(columnName).toString()));
                    return true;
                }
            }
            if (row.size() != 0 && row.get(columnName) == null) {
                logInfo(String.format("FOUND Row '%s' with column name '%s' has null value,", i, columnName));
                return true;
            } else {
                logInfo(String.format("NOT FOUND Row '%s' with column name '%s' & value '%s'", i, columnName, row.get(columnName)));
            }
        }
        logInfo(String.format("NOT FOUND Row with column name '%s' & value '%s'", columnName, value));
        return false;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public String getClientFirstName() {
        return ClientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        ClientFirstName = clientFirstName;
    }

    public String getClientMiddleInitial() {
        return ClientMiddleInitial;
    }

    public void setClientMiddleInitial(String clientMiddleInitial) {
        ClientMiddleInitial = clientMiddleInitial;
    }

    public String getClientLastName() {
        return ClientLastName;
    }

    public void setClientLastName(String clientLastName) {
        ClientLastName = clientLastName;
    }

    public String getClientSSN() {
        return ClientSSN;
    }

    public void setClientSSN(String clientSSN) {
        ClientSSN = clientSSN;
    }

    public String getClientMedicalRecordNumber() {
        return ClientMedicalRecordNumber;
    }

    public void setClientMedicalRecordNumber(String clientMedicalRecordNumber) {
        ClientMedicalRecordNumber = clientMedicalRecordNumber;
    }

    public String getClientCustomID() {
        return ClientCustomID;
    }

    public void setClientCustomID(String clientCustomID) {
        ClientCustomID = clientCustomID;
    }

    public String getClientOtherID() {
        return ClientOtherID;
    }

    public void setClientOtherID(String clientOtherID) {
        ClientOtherID = clientOtherID;
    }

    public String getClientSuffix() {
        return ClientSuffix;
    }

    public void setClientSuffix(String clientSuffix) {
        ClientSuffix = clientSuffix;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public String getProviderQualifier() {
        return ProviderQualifier;
    }

    public void setProviderQualifier(String providerQualifier) {
        ProviderQualifier = providerQualifier;
    }

    public String getProviderID() {
        return ProviderID;
    }

    public void setProviderID(String providerID) {
        ProviderID = providerID;
    }

    public String getCaseManager() {
        return CaseManager;
    }

    public void setCaseManager(String caseManager) {
        CaseManager = caseManager;
    }

    public String getClientCaseManagerEmail() {
        return ClientCaseManagerEmail;
    }

    public void setClientCaseManagerEmail(String clientCaseManagerEmail) {
        ClientCaseManagerEmail = clientCaseManagerEmail;
    }

    public String getClientCoordinatorEmail() {
        return ClientCoordinatorEmail;
    }

    public void setClientCoordinatorEmail(String clientCoordinatorEmail) {
        ClientCoordinatorEmail = clientCoordinatorEmail;
    }

    public String getClientLanguage() {
        return ClientLanguage;
    }

    public void setClientLanguage(String clientLanguage) {
        ClientLanguage = clientLanguage;
    }

    public String getClientGender() {
        return ClientGender;
    }

    public void setClientGender(String clientGender) {
        ClientGender = clientGender;
    }

    public String getClientBirthDate() {
        return ClientBirthDate;
    }

    public void setClientBirthDate(String clientBirthDate) {
        ClientBirthDate = clientBirthDate;
    }

    public String getClientMaritalStatus() {
        return ClientMaritalStatus;
    }

    public void setClientMaritalStatus(String clientMaritalStatus) {
        ClientMaritalStatus = clientMaritalStatus;
    }

    public String getClientEmail() {
        return ClientEmail;
    }

    public void setClientEmail(String clientEmail) {
        ClientEmail = clientEmail;
    }

    public String getClientPriority() {
        return ClientPriority;
    }

    public void setClientPriority(String clientPriority) {
        ClientPriority = clientPriority;
    }

    public String getClientTimeZone() {
        return ClientTimeZone;
    }

    public void setClientTimeZone(String clientTimeZone) {
        ClientTimeZone = clientTimeZone;
    }

    public String getClientDesigneeFirstName() {
        return ClientDesigneeFirstName;
    }

    public void setClientDesigneeFirstName(String clientDesigneeFirstName) {
        ClientDesigneeFirstName = clientDesigneeFirstName;
    }

    public String getClientDesigneeLastName() {
        return ClientDesigneeLastName;
    }

    public void setClientDesigneeLastName(String clientDesigneeLastName) {
        ClientDesigneeLastName = clientDesigneeLastName;
    }

    public String getClientDesigneeEmail() {
        return ClientDesigneeEmail;
    }

    public void setClientDesigneeEmail(String clientDesigneeEmail) {
        ClientDesigneeEmail = clientDesigneeEmail;
    }

    public String getClientDesigneeStatus() {
        return ClientDesigneeStatus;
    }

    public void setClientDesigneeStatus(String clientDesigneeStatus) {
        ClientDesigneeStatus = clientDesigneeStatus;
    }

    public String getClientDesigneeStartDate() {
        return ClientDesigneeStartDate;
    }

    public void setClientDesigneeStartDate(String clientDesigneeStartDate) {
        ClientDesigneeStartDate = clientDesigneeStartDate;
    }

    public String getClientDesigneeEndDate() {
        return ClientDesigneeEndDate;
    }

    public void setClientDesigneeEndDate(String clientDesigneeEndDate) {
        ClientDesigneeEndDate = clientDesigneeEndDate;
    }

    public String getMemberEnrollmentDate() {
        return MemberEnrollmentDate;
    }

    public void setMemberEnrollmentDate(String memberEnrollmentDate) {
        MemberEnrollmentDate = memberEnrollmentDate;
    }

    public List<com.sandata.models.interfaces.open_evv_generic.member.ClientEligibility_A> getClientEligibility() {
        return ClientEligibility;
    }

    public void setClientEligibility(List<com.sandata.models.interfaces.open_evv_generic.member.ClientEligibility_A> clientEligibility) {
        ClientEligibility = clientEligibility;
    }

    public List<com.sandata.models.interfaces.open_evv_generic.member.ClientContact_A> getClientContact() {
        return ClientContact;
    }

    public void setClientContact(List<com.sandata.models.interfaces.open_evv_generic.member.ClientContact_A> clientContact) {
        ClientContact = clientContact;
    }

    public List<com.sandata.models.interfaces.open_evv_generic.member.ClientAddress_A> getClientAddress() {
        return ClientAddress;
    }

    public void setClientAddress(List<com.sandata.models.interfaces.open_evv_generic.member.ClientAddress_A> clientAddress) {
        ClientAddress = clientAddress;
    }

    public List<com.sandata.models.interfaces.open_evv_generic.member.ClientPhone_A> getClientPhone() {
        return ClientPhone;
    }

    public void setClientPhone(List<com.sandata.models.interfaces.open_evv_generic.member.ClientPhone_A> clientPhone) {
        ClientPhone = clientPhone;
    }

    public List<com.sandata.models.interfaces.open_evv_generic.member.ClientWorkerXref_A> getClientWorkerXref() {
        return ClientWorkerXref;
    }

    public void setClientWorkerXref(List<com.sandata.models.interfaces.open_evv_generic.member.ClientWorkerXref_A> clientWorkerXref) {
        ClientWorkerXref = clientWorkerXref;
    }

    public List<ClientDesignees_A> getClientDesignees() {
        return ClientDesignee;
    }

    public void setClientDesignees(List<ClientDesignees_A> clientDesignees) {
        this.ClientDesignee = clientDesignees;
    }

    public boolean ClientPriority(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientPriority = value;

        logInfo(String.format("Request to create client with ClientPriority with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CLS_CLIENT_PRIORITY, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientTimeZone(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientTimeZone = value;

        logInfo(String.format("Request to create client with ClientTimeZone with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CL_TZNAME, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientDesigneeFirstName(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientDesigneeFirstName = value;

        logInfo(String.format("Request to create client with ClientDesigneeFirstName with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CLC_F_NAME, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientDesigneeLastName(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientDesigneeLastName = value;

        logInfo(String.format("Request to create client with ClientDesigneeLastName with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CLC_L_NAME, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean ClientDesigneeEmail(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openEVVMemberModelList.get(0).ClientDesigneeEmail = value;

        logInfo(String.format("Request to create client with ClientDesigneeEmail with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateClientRecordsExistInDatabase(expected);

        boolean result3 = validateClientRecordsExistInDatabase(basic_info, CLC_E_MAIL, value, expected);

        return (result1 && result2 & result3);
    }

    public boolean VerifyClientDesigneeStatus(Constant.DataType dataType, int maxLength, String valueStatus,
                                              String valueStartDate, String valueEndDate, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, valueStatus);
        openEVVMemberModelList.get(0).ClientDesigneeStatus = value;

        value = generateFieldValue(dataType, maxLength, valueStartDate);
        openEVVMemberModelList.get(0).ClientDesigneeStartDate = value;

        value = generateFieldValue(dataType, maxLength, valueEndDate);
        openEVVMemberModelList.get(0).ClientDesigneeEndDate = value;

        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        if (valueStatus == null) {
            if (valueStartDate != null & valueEndDate != null) {
                expected = true;
            }
            boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, valueStatus, expected);

            boolean result2 = validateClientContactRecordsExistInDatabase(expected);

            return (result1 && result2);

        } else if (valueStartDate == null && valueEndDate == null) {

            boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, valueStartDate, expected);

            boolean result2 = validateClientContactRecordsExistInDatabase(expected);

            boolean result3 = validateClientRecordsExistInDatabase(contact, CLC_STATUS, valueStatus, expected);

            return (result1 && result2 && result3);
        }
        return false;
    }

    /***
     * Validate client designee information record is inserted into STX.Clients_Contact or not
     * @param expected
     * @return
     */
    public boolean validateClientContactRecordsExistInDatabase(boolean expected) {
        List<String> locs = getClientIds();

        boolean result = clientDbService.areClientDesigneeExistInDatabase(account_id, locs, expected);

        if (result) {
            if (expected) {
                logPass("PASSED. Record(s) inserted into DB because expected is " + expected);
            } else {
                logPass("PASSED. Record(s) not inserted into DB because expected is " + expected);
            }
        } else {
            if (expected) {
                logError("FAILED. Record(s) not inserted into DB when expected is " + expected);
            } else {
                logError("FAILED. Record(s) inserted into DB when expected is " + expected);
            }
        }
        return result;
    }


}
