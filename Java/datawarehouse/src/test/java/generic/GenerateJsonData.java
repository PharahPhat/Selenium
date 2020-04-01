package generic;

import com.interop.common.Commons;
import com.sandata.common.Constant;
import com.sandata.core.Wrapper;
import com.sandata.db.ClientDbService;
import com.sandata.db.EmployeeDbService;
import com.sandata.db.VisitDbService;
import com.sandata.entity.connecticut.authorization.AuthorizationEntity;
import com.sandata.entity.connecticut.client.ClientConnecticutPhone;
import com.sandata.entity.connecticut.client.ClientConnecticutWithConfigurationModel;
import com.sandata.entity.connecticut.client.ConnecticutClientAddress;
import com.sandata.entity.connecticut.employee.EmployeeConnecticutWithConfigurationModel;
import com.sandata.entity.connecticut.visit.Calls;
import com.sandata.entity.connecticut.visit.VisitChanges;
import com.sandata.entity.connecticut.visit.VisitsConnecticutWithConfigurationModel;
import com.sandata.entity.exportDWH.*;
import com.sandata.entity.molina.employee.EmployeeGeneralEntity;
import com.sandata.entity.molina.visit.VisitGeneralEntity;
import com.sandata.entity.ohio.client.PatientAdressEntity;
import com.sandata.entity.ohio.client.PatientGeneralEntity;
import com.sandata.entity.ohio.client.PatientPhonesEntity;
import com.sandata.entity.ohio.client.ResponsiblePartyModel;
import com.sandata.utilities.DbUtilsCon;
import com.sandata.ws.AuthorizationService;
import com.sandata.ws.ClientWebService;
import com.sandata.ws.EmployeeWebService;
import com.sandata.ws.VisitWebService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.interop.sql.Sql.*;


public class GenerateJsonData {
    public String clientLOC;
    public String clientFName;
    public String clientLName;
    public String employeeFName;
    public String employeeLName;
    public String clientSSN;
    public String clientMedicaidId;
    public String employeeCustomId;
    public String employeeSSN;
    public ClientWebService clientServices = new ClientWebService();
    public EmployeeWebService employeeWebService = new EmployeeWebService();
    public VisitWebService visitWebService = new VisitWebService();
    public VisitWebService visitServices = new VisitWebService();
    public AuthorizationService authorizationService = new AuthorizationService();
    public EmployeeDbService employeeDbService = new EmployeeDbService();
    public ClientDbService clientDbService = new ClientDbService();
    public VisitDbService visitDbService = new VisitDbService();
    public Commons commons = new Commons();


    protected Wrapper baseObj;

    public String getClientSSN() {
        return clientSSN;
    }

    public void setClientSSN(String clientSSN) {
        this.clientSSN = clientSSN;
    }

    public String getEmployeeCustomId() {
        return employeeCustomId;
    }

    public void setEmployeeCustomId(String employeeCustomId) {
        this.employeeCustomId = employeeCustomId;
    }

    public Wrapper getBaseObj() {
        return baseObj;
    }

    public void setBaseObj(Wrapper baseObj) {
        this.baseObj = baseObj;
    }

    public String getClientFName() {
        return clientFName;
    }

    public void setClientFName(String clientFName) {
        this.clientFName = clientFName;
    }

    public String getClientLName() {
        return clientLName;
    }

    public void setClientLName(String clientLName) {
        this.clientLName = clientLName;
    }

    public String getEmployeeFName() {
        return employeeFName;
    }

    public void setEmployeeFName(String employeeFName) {
        this.employeeFName = employeeFName;
    }

    public String getEmployeeLName() {
        return employeeLName;
    }

    public void setEmployeeLName(String employeeLName) {
        this.employeeLName = employeeLName;
    }

    public String getEmployeeSSN() {
        return employeeSSN;
    }

    public void setEmployeeSSN(String employeeSSN) {
        this.employeeSSN = employeeSSN;
    }

    public String getClientMedicaidId() {
        return clientMedicaidId;
    }

    public void setClientMedicaidId(String clientMedicaidId) {
        this.clientMedicaidId = clientMedicaidId;
    }

    public String getClientLOC() {
        return clientLOC;
    }

    public void setClientLOC(String clientLOC) {
        this.clientLOC = clientLOC;
    }

    public String generateRandomConnecticutClientByApi(String fName, String lName) {
        String accountType = "CONNECTICUT";

        String clientId = commons.generateRandomNumberOfFixLength(5);
        clientSSN = commons.generateRandomNumberOfFixLength(9);
        ClientConnecticutWithConfigurationModel clientModel = new ClientConnecticutWithConfigurationModel();
        clientModel.setClientID(clientId);
        clientModel.setClientLastName(lName);
        setClientLName(lName);
        clientModel.setClientFirstName(fName);
        setClientFName(fName);
        clientModel.setClientSSN(clientSSN);
        clientModel.setClientMedicaidID(commons.generateRandomNumberOfFixLength(10));
        clientModel.setClientEmailAddress(commons.generateEmailAddressInString(20));

        List<ConnecticutClientAddress> clientAddresses = new ArrayList<>();
        ConnecticutClientAddress clientAddress = new ConnecticutClientAddress();
        clientAddress.setClientID(clientId);
        clientAddresses.add(clientAddress);

        List<ClientConnecticutPhone> clientPhones = new ArrayList<>();
        ClientConnecticutPhone clientPhone = new ClientConnecticutPhone();
        clientPhone.setClientID(clientId);
        clientPhones.add(clientPhone);

        clientModel.setClientAddress(clientAddresses);
        clientModel.setClientPhone(clientPhones);

        String username = baseObj.getEnvironment("Username14420");
        String password = baseObj.getEnvironment("Password14420");
        String account = baseObj.getEnvironment("Account14420");

        return clientServices.callCreateConnecticutClient(accountType, username,
                password, account, clientModel,
                baseObj.getTestEnvironment());
    }

    public String generateRandomConnecticutEmployeeByApi(String fName, String lName) {
        String accountType = "CONNECTICUT";

        employeeCustomId = employeeDbService.generateNewEmployeeCustomId(baseObj.getEnvironment("connecticut_accountId"));
        EmployeeConnecticutWithConfigurationModel employeeModel = new EmployeeConnecticutWithConfigurationModel();
        employeeModel.setEmployeePIN(commons.generateRandomNumberOfFixLength(9));
        employeeModel.setEmployeeLastName(lName);
        setEmployeeLName(employeeLName);
        employeeModel.setEmployeeFirstName(fName);
        setEmployeeFName(fName);
        employeeModel.setEmployeeID(commons.generateRandomNumberOfFixLength(5));
        employeeModel.setEmployeeIDCustom1(employeeCustomId);
        employeeModel.setEmployeeIDCustom2(commons.generateRandomNumberOfFixLength(9));
        employeeModel.setEmployeeSocialSecurity(commons.generateRandomNumberOfFixLength(9));
        employeeModel.setEmployeeEmailAddress(commons.generateRandomStringOfFixLength(13) + "@test.com");

        String username = baseObj.getEnvironment("Username14420");
        String password = baseObj.getEnvironment("Password14420");
        String account = baseObj.getEnvironment("Account14420");

        return employeeWebService.callCreateConnecticutEmployee(accountType, username, password,
                account, employeeModel, baseObj.getTestEnvironment());
    }

    public String generateRandomConnecticutVisitByApi(String clientSSN, String employeeCustomId, String memo) {
        String accountType = "CONNECTICUT";

        String providerQualifier = baseObj.getEnvironment("connecticut_providerQualifier");
        VisitsConnecticutWithConfigurationModel visitModel = new VisitsConnecticutWithConfigurationModel();

        ProviderIdentification providerIdentification = new ProviderIdentification();
        providerIdentification.setProviderID(baseObj.getEnvironment("connecticut_providerId"));
        providerIdentification.setProviderQualifier(providerQualifier);
        visitModel.setProviderIdentification(providerIdentification);

        visitModel.setVisitOtherID(commons.generateRandomNumberOfFixLength(9));
        visitModel.setSequenceID(commons.generateRandomNumberOfFixLength(9));
        if (employeeCustomId != null && !employeeCustomId.equals(""))
            visitModel.setEmployeeIdentifier(employeeCustomId);
        else visitModel.setEmployeeIdentifier(this.employeeCustomId);

        if (clientSSN != null && !clientSSN.equals(""))
            visitModel.setClientID(clientSSN);
        else visitModel.setClientID(this.clientSSN);

        visitModel.setMemo(memo);
        String timeIn = commons.getDateUTCFormat(-1, "yyyy-MM-dd") + "T" + "16:02:00Z";
        String timeOut = commons.getDateUTCFormat(-1, "yyyy-MM-dd") + "T" + "17:10:00Z";
        visitModel.setScheduleStartTime(timeIn);
        visitModel.setAdjInDateTime(timeIn);
        visitModel.setScheduleEndTime(timeOut);
        visitModel.setAdjOutDateTime(timeOut);

        List<Calls> calls = new ArrayList<>();
        Calls callIn = new Calls();
        callIn.setCallDateTime(timeIn);
        Calls callOut = new Calls();
        callOut.setCallDateTime(timeOut);
        calls.add(callIn);
        calls.add(callOut);
        visitModel.setCalls(calls);

        List<VisitChanges> visitChangesList = new ArrayList<>();
        VisitChanges visitChanges = new VisitChanges();
        visitChanges.setChangeDateTime(commons.getDateUTCFormat(-1, "yyyy-MM-dd'T'HH:mm:ss'Z'"));
        visitChangesList.add(visitChanges);
        visitModel.setVisitChanges(visitChangesList);

        String username = baseObj.getEnvironment("Username14420");
        String password = baseObj.getEnvironment("Password14420");
        String account = baseObj.getEnvironment("Account14420");
        return visitWebService.callCreateGenericVisit(accountType, username, password, account, visitModel,
                baseObj.getTestEnvironment());
    }

    public boolean waitDataExistInDb(String accountId, String sql) {
        boolean isExisted = false;
        int retryCount = 3;

        while (!isExisted && retryCount > 0) {
            System.out.println("retryCount = " + retryCount);

            if (DbUtilsCon.getDataTable(
                    baseObj.getTestEnvironment().getOracleUrl(),
                    baseObj.getTestEnvironment(), sql).size() != 0) isExisted = true;
            else isExisted = false;
            baseObj.sleep(8000);
            retryCount--;
        }
        return isExisted;
    }

    public void generateRandomVisitFlow(String accountId, String clientFName, String clientLName,
                                        String employeeFName, String employeeLName, String memo) {
        generateRandomConnecticutClientByApi(clientFName, clientLName);
        String clientSql = String.format(SQL_GET_CLIENT, accountId, clientFName, clientLName);
        boolean clientExistInDb = waitDataExistInDb(accountId, clientSql);
        String employeeSql = String.format(SQL_GET_EMPLOYEE, employeeFName, employeeLName, accountId);
        String visitSql = String.format(SQL_GET_VISIT_KEY_BY_MEMO, accountId, clientFName, clientLName, memo);
        if (clientExistInDb) {
            generateRandomConnecticutEmployeeByApi(employeeFName, employeeLName);
            boolean employeeExistInDb = waitDataExistInDb(accountId, employeeSql);
            int retryCount = 2;
            while (!employeeExistInDb && retryCount > 0) {
                generateRandomConnecticutEmployeeByApi(employeeFName, employeeLName);
                employeeExistInDb = waitDataExistInDb(accountId, employeeSql);
                retryCount--;
            }
            if (employeeExistInDb) {
                baseObj.sleep(8000);
                if (memo == null)
                    generateRandomConnecticutVisitByApi(this.clientSSN, this.employeeCustomId,
                            commons.generateRandomStringOfFixLength(10));
                else generateRandomConnecticutVisitByApi(this.clientSSN, this.employeeCustomId, memo);
                waitDataExistInDb(accountId, visitSql);
            }
        }
    }

    public void generateRandomDataWithoutVisit(String clientFName, String clientLName,
                                               String employeeFName, String employeeLName) {
        String accountId = baseObj.readDataValue("AccountId");
        generateRandomConnecticutClientByApi(clientFName, clientLName);
        String clientSql = String.format(SQL_GET_CLIENT, accountId, clientFName, clientLName);
        boolean clientExistInDb = waitDataExistInDb(accountId, clientSql);
        String employeeSql = String.format(SQL_GET_EMPLOYEE, employeeFName, employeeLName, accountId);
        if (clientExistInDb) {
            generateRandomConnecticutEmployeeByApi(employeeFName, employeeLName);
            boolean employeeExistInDb = waitDataExistInDb(accountId, employeeSql);
            int retryCount = 2;
            while (!employeeExistInDb && retryCount > 0) {
                generateRandomConnecticutEmployeeByApi(employeeFName, employeeLName);
                employeeExistInDb = waitDataExistInDb(accountId, employeeSql);
                retryCount--;
            }
        }
    }

    public String generateRandomMolinaClientByApi(String fName, String lName) {
        String accountType = "MOLINA";
        String providerId = baseObj.getEnvironment("molina_providerId");
        String providerQualifier = baseObj.readDataValue("ProviderQualifier");
        String clientQualifier = "ClientCustomID";

        String clientId = commons.generateRandomNumberOfFixLength(10);
        String clientMedicaidID = commons.generateRandomNumberOfFixLength(10);
        setClientMedicaidId(clientMedicaidID);
        String clientOtherId = commons.generateRandomNumberOfFixLength(9);
        String clientIdentifier = commons.generateRandomNumberOfFixLength(9);
        String sequenceID = commons.generateRandomNumberOfFixLength(12);

        ClientMolinaModel clientMolinaWithConfigurationModel = new ClientMolinaModel();
        ProviderIdentification providerIdentification = new ProviderIdentification();
        providerIdentification.setProviderID(providerId);
        providerIdentification.setProviderQualifier(providerQualifier);

        clientMolinaWithConfigurationModel.setClientFirstName(fName);
        setClientFName(fName);
        clientMolinaWithConfigurationModel.setClientLastName(lName);
        setClientLName(lName);

        clientMolinaWithConfigurationModel.setProviderIdentification(providerIdentification);
        clientMolinaWithConfigurationModel.setClientQualifier(clientQualifier);

        clientMolinaWithConfigurationModel.setClientMedicaidID(clientMedicaidID);
        clientMolinaWithConfigurationModel.setClientIdentifier(clientIdentifier);
        clientMolinaWithConfigurationModel.setSequenceID(sequenceID);
        clientMolinaWithConfigurationModel.setClientOtherID(clientOtherId);
        clientMolinaWithConfigurationModel.setClientID(clientId);
        clientSSN = commons.generateRandomNumberOfFixLength(9);
        clientMolinaWithConfigurationModel.setClientSSN(clientSSN);

        String username = baseObj.getEnvironment("molina_UserName");
        String password = baseObj.getEnvironment("molina_Password");
        String account = baseObj.getEnvironment("molina_accountId");

        return clientServices.callCreateClient(accountType, username,
                password, account, clientMolinaWithConfigurationModel,
                baseObj.getTestEnvironment());
    }

    public String generateRandomMolinaEmployeeByApi(String fName, String lName) {
        String accountType = "MOLINA";
        String providerQualifier = baseObj.readDataValue("ProviderQualifier");
        String providerId = baseObj.getEnvironment("molina_providerId");

        String employeeIdentifier = commons.generateRandomNumberOfFixLength(9);
        String employeeOtherID = commons.generateRandomNumberOfFixLength(9);
        String sequenceID = commons.generateRandomNumberOfFixLength(10);
        String employeeQualifier = "EmployeeSSN";
        String employeeSSN = commons.generateRandomNumberOfFixLength(9);

        EmployeeGeneralEntity employeeMolinaWithConfigurationModel = new EmployeeGeneralEntity();
        ProviderIdentification providerIdentification = new ProviderIdentification();
        providerIdentification.setProviderID(providerId);
        providerIdentification.setProviderQualifier(providerQualifier);

        employeeMolinaWithConfigurationModel.setProviderIdentification(providerIdentification);

        employeeMolinaWithConfigurationModel.setEmployeeIdentifier(employeeIdentifier);
        setEmployeeSSN(employeeIdentifier);
        employeeMolinaWithConfigurationModel.setEmployeeOtherID(employeeOtherID);
        employeeMolinaWithConfigurationModel.setSequenceID(sequenceID);
        employeeMolinaWithConfigurationModel.setEmployeeQualifier(employeeQualifier);
        employeeMolinaWithConfigurationModel.setEmployeeSSN(employeeSSN);
        employeeMolinaWithConfigurationModel.setEmployeeLastName(lName);
        employeeMolinaWithConfigurationModel.setEmployeeFirstName(fName);

        String username = baseObj.getEnvironment("molina_UserName");
        String password = baseObj.getEnvironment("molina_Password");
        String account = baseObj.getEnvironment("molina_accountId");

        return employeeWebService.callCreateEmployee(accountType, username,
                password, account, employeeMolinaWithConfigurationModel,
                baseObj.getTestEnvironment());
    }

    public String generateRandomMolinaVisitByApi(String clientMedicaidId, String employeeSSN, String memo) {

        String accountType = "MOLINA";
        String providerId = baseObj.getEnvironment("molina_providerId");
        String providerQualifier = baseObj.readDataValue("ProviderQualifier");

        VisitGeneralEntity visitMolinaModel = new VisitGeneralEntity();
        ProviderIdentification providerIdentification = new ProviderIdentification();
        providerIdentification.setProviderID(providerId);
        providerIdentification.setProviderQualifier(providerQualifier);
        visitMolinaModel.setProviderIdentification(providerIdentification);
        visitMolinaModel.setSequenceID(commons.generateRandomNumberOfFixLength(9));

        visitMolinaModel.setEmployeeQualifier("EmployeeSSN");
        if (employeeSSN != null && !employeeSSN.equals(""))
            visitMolinaModel.setEmployeeIdentifier(employeeSSN);
        else visitMolinaModel.setEmployeeIdentifier(employeeSSN);


        visitMolinaModel.setClientQualifier("ClientMedicaidID");
        if (clientMedicaidId != null && !clientMedicaidId.equals(""))
            visitMolinaModel.setClientIdentifier(clientMedicaidId);
        else visitMolinaModel.setClientIdentifier(this.clientMedicaidId);

        visitMolinaModel.setMemo(memo);
        visitMolinaModel.setVisitOtherID(commons.generateRandomNumberOfFixLength(9));

        String timeIn = commons.getDateUTCFormat(-1, "yyyy-MM-dd") + "T" + "16:02:00Z";
        String timeOut = commons.getDateUTCFormat(-1, "yyyy-MM-dd") + "T" + "17:10:00Z";

        visitMolinaModel.setScheduleStartTime(timeIn);
        visitMolinaModel.setScheduleEndTime(timeOut);
        visitMolinaModel.setAdjInDateTime(timeIn);
        visitMolinaModel.setAdjOutDateTime(timeOut);

        List<Call> Calls = new ArrayList<>();
        Call callIn = new Call();
        callIn.setCallDateTime(timeIn);
        Calls.add(callIn);
        Call callOut = new Call();
        callOut.setCallDateTime(timeOut);
        Calls.add(callOut);
        visitMolinaModel.setCalls(Calls);

        List<VisitChange> visitChanges = new ArrayList<>();
        VisitChange visitChange = new VisitChange();
        visitChange.setChangeDateTime(timeIn);
        visitChanges.add(visitChange);
        visitMolinaModel.setVisitChanges(visitChanges);

        String username = baseObj.getEnvironment("molina_UserName");
        String password = baseObj.getEnvironment("molina_Password");
        String account = baseObj.getEnvironment("molina_accountId");

        return visitServices.callCreateVisit(accountType, username,
                password, account, visitMolinaModel,
                baseObj.getTestEnvironment());
    }

    public void generateRandomMolinaVisitFlow(String accountId, String clientFName, String clientLName,
                                              String employeeFName, String employeeLName, String memo) {
        generateRandomMolinaClientByApi(clientFName, clientLName);
        String clientSql = String.format(SQL_GET_CLIENT, accountId, clientFName, clientLName);
        boolean clientExistInDb = waitDataExistInDb(accountId, clientSql);
        String employeeSql = String.format(SQL_GET_EMPLOYEE, employeeFName, employeeLName, accountId);
        String visitSql = String.format(SQL_GET_VISIT_KEY_BY_MEMO, accountId, clientFName, clientLName, memo);
        if (clientExistInDb) {
            generateRandomMolinaEmployeeByApi(employeeFName, employeeLName);
            boolean employeeExistInDb = waitDataExistInDb(accountId, employeeSql);
            int retryCount = 2;
            while (!employeeExistInDb && retryCount > 0) {
                generateRandomMolinaEmployeeByApi(employeeFName, employeeLName);
                employeeExistInDb = waitDataExistInDb(accountId, employeeSql);
                retryCount--;
            }
            if (employeeExistInDb) {
                baseObj.sleep(8000);
                if (memo.equals("") || memo == null)
                    generateRandomMolinaVisitByApi(this.clientMedicaidId, this.employeeSSN,
                            commons.generateRandomStringOfFixLength(10));
                else generateRandomMolinaVisitByApi(this.clientMedicaidId, this.employeeSSN, memo);
                waitDataExistInDb(accountId, visitSql);
            }
        }
    }

    public void generateRandomMolinaWithoutVisitFlow(String accountId, String clientFName, String clientLName,
                                                     String employeeFName, String employeeLName) {
        generateRandomMolinaClientByApi(clientFName, clientLName);
        String clientSql = String.format(SQL_GET_CLIENT, accountId, clientFName, clientLName);
        boolean clientExistInDb = waitDataExistInDb(accountId, clientSql);
        String employeeSql = String.format(SQL_GET_EMPLOYEE, employeeFName, employeeLName, accountId);
        if (clientExistInDb) {
            generateRandomMolinaEmployeeByApi(employeeFName, employeeLName);
            boolean employeeExistInDb = waitDataExistInDb(accountId, employeeSql);
            int retryCount = 2;
            while (!employeeExistInDb && retryCount > 0) {
                generateRandomMolinaEmployeeByApi(employeeFName, employeeLName);
                employeeExistInDb = waitDataExistInDb(accountId, employeeSql);
                retryCount--;
            }
        }
    }

    public String getClientIdBy(String accountId, String clientFName, String clientLName) {
        String sql = String.format(SQL_GET_CLIENT_ID_BY_NAME, clientFName, clientLName, accountId);
        Object clientId = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("LOC");
        return String.valueOf(clientId);
    }

    public AuthorizationEntity CreateAuthorizationForConnecticut(String accountId, String clientFName, String clientLName) {
        String username = baseObj.getEnvironment("Username14420");
        String password = baseObj.getEnvironment("Password14420");
        String account = baseObj.getEnvironment("Account14420");
        clientLOC = getClientIdBy(accountId, clientFName, clientLName);

        AuthorizationEntity authorizationEntity = new AuthorizationEntity();
        authorizationEntity.setPayerID(commons.generateRandomStringOfFixLength(10));
        authorizationEntity.setPayerProgram(commons.generateRandomStringOfFixLength(9));
        authorizationEntity.setClientQualifier("ClientSSN");
        authorizationEntity.setClientIdentifier(clientLOC);
        authorizationEntity.setEmployeePINQualifier("EmployeeCustomID");
        authorizationEntity.setEmployeeID(employeeCustomId);
        authorizationEntity.setProviderQualifier(baseObj.getEnvironment("connecticut_providerQualifier"));
        authorizationEntity.setProviderID(baseObj.getEnvironment("connecticut_providerId"));
        authorizationEntity.setAuthorizationReferenceNumber(commons.generateRandomNumberOfFixLength(20));
        authorizationEntity.setAuthorizationServiceID("1015");
        authorizationEntity.setAuthorizationBillingType(commons.generateRandomStringOfFixLength(10));
        authorizationEntity.setModifier1(commons.generateRandomStringOfFixLength(2));
        authorizationEntity.setModifier2(commons.generateRandomStringOfFixLength(2));
        authorizationEntity.setModifier3(commons.generateRandomStringOfFixLength(2));
        authorizationEntity.setModifier4(commons.generateRandomStringOfFixLength(2));
        authorizationEntity.setAuthorizationAmountType("H");
        authorizationEntity.setAuthorizationMaximum("123");
        authorizationEntity.setUnits("12");

        String currentDate = commons.getDateUTCFormat(0, "yyyy-MM-dd");
        authorizationEntity.setAuthorizationStartDate(currentDate);
        authorizationEntity.setAuthorizationEndDate(currentDate);
        authorizationEntity.setAuthorizationShared("Y");
        authorizationEntity.setAuthorizationComments(commons.generateRandomStringOfFixLength(5));
        authorizationEntity.setAuthorizationLimitType("W");
        authorizationEntity.setAuthorizationStatus("A");
        authorizationEntity.setClientDiagnosisCode("E10.45");

        try {
            authorizationService.preparePostRequestClientData(
                    authorizationEntity, username, password, account, baseObj.getTestEnvironment());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authorizationEntity;
    }

    public List<PatientGeneralEntity> initializeClientCurrentOhioODMData(String accountId, String providerId) {
        List<PatientGeneralEntity> patientGeneralEntities = new ArrayList<>();
        PatientGeneralEntity patientGeneralEntity = new PatientGeneralEntity();

        patientGeneralEntity.BusinessEntityID = accountId;
        patientGeneralEntity.BusinessEntityMedicaidIdentifier = providerId;
        patientGeneralEntity.IsPatientNewborn = false;
        patientGeneralEntity.PatientAlternateID = commons.generateRandomNumberOfFixLength(7);
        patientGeneralEntity.PatientFirstName = clientDbService.generateNewClientFName(accountId);
        patientGeneralEntity.PatientLastName = clientDbService.generateNewClientLName(accountId);
        patientGeneralEntity.PatientMedicaidID = clientDbService.generateNewPatientMedicaidID(accountId);
        patientGeneralEntity.PatientOtherID = clientDbService.generateNewPatientOtherID(accountId);
        patientGeneralEntity.PatientTimezone = "US/Eastern";
        patientGeneralEntity.SequenceID = clientDbService.generateNewClientLSequenceNumber(accountId);

        List<ResponsiblePartyModel> responsibleParties = new ArrayList<>();
        ResponsiblePartyModel responsiblePartyModel = new ResponsiblePartyModel();
        responsiblePartyModel.PatientResponsiblePartyFirstName = "JStevee";
        responsiblePartyModel.PatientResponsiblePartyLastName = "KJobss";
        responsibleParties.add(responsiblePartyModel);
        patientGeneralEntity.ResponsibleParty = responsibleParties;

        List<IndividualPayerInformationModel> individualPayerInformationModels = new ArrayList<>();
        IndividualPayerInformationModel individualPayerInformationModel = new IndividualPayerInformationModel();
        individualPayerInformationModel.Payer = "ODM";
        individualPayerInformationModel.PayerProgram = "SP";
        individualPayerInformationModel.ProcedureCode = "T1000";
        individualPayerInformationModels.add(individualPayerInformationModel);
        patientGeneralEntity.IndividualPayerInformation = individualPayerInformationModels;

        List<PatientPhonesEntity> phones = new ArrayList<>();
        PatientPhonesEntity phone = new PatientPhonesEntity();
        phone.PatientPhoneNumber = "9431650001";
        phone.PatientPhoneType = "Home";
        phones.add(phone);
        patientGeneralEntity.Phones = phones;

        List<PatientAdressEntity> addresses = new ArrayList<>();
        PatientAdressEntity address1 = new PatientAdressEntity();
        address1.PatientAddressIsPrimary = false;
        address1.PatientAddressLine1 = "201 Harbour Drive Rd";
        address1.PatientAddressLine2 = "2nd Floor";
        address1.PatientAddressType = "School";
        address1.PatientCity = "Port Washington";
        address1.PatientLatitude = 88.1155122001;
        address1.PatientLongitude = 85.1155122001;
        address1.PatientState = "OH"; //  set PatientState = "OH"
        address1.PatientTimezone = null; // set PatientTimezone = null
        address1.PatientZip = "55556";

        addresses.add(address1);
        patientGeneralEntity.Address = addresses;

        patientGeneralEntities.add(patientGeneralEntity);
        return patientGeneralEntities;
    }

    public List<com.sandata.entity.ohio.visit.VisitGeneralEntity> initializeVisitOhioData(String accountId, String providerId,
                                                                                          String StaffOtherID, String PatientOtherID, String PatientMedicaidID) {
        String scheduleStartTime = commons.getDateUTCFormat(-1, "yyyy-MM-dd") + "T00:00:00Z";
        String scheduleEndTime = commons.getDateUTCFormat(-1, "yyyy-MM-dd") + "T00:05:00Z";
        String changeDateTime = commons.getDateUTCFormat(-1, "yyyy-MM-dd") + "T00:00:00Z";

        String sequenceId = visitDbService.generateNewVisitSequenceNumber(accountId);
        String memo = visitDbService.generateNewVisitMemo(accountId);

        List<com.sandata.entity.ohio.visit.VisitGeneralEntity> visitGeneralEntities = new ArrayList<>();
        com.sandata.entity.ohio.visit.VisitGeneralEntity visitGeneralEntity = new com.sandata.entity.ohio.visit.VisitGeneralEntity();

        visitGeneralEntity.BusinessEntityID = accountId;
        visitGeneralEntity.BusinessEntityMedicaidIdentifier = providerId;
        visitGeneralEntity.VisitOtherID = visitDbService.generateNewVisitOtherId(accountId);
        visitGeneralEntity.SequenceID = visitDbService.generateNewVisitSequenceNumber(accountId);
        visitGeneralEntity.StaffOtherID = StaffOtherID;
        visitGeneralEntity.PatientOtherID = PatientOtherID;
        visitGeneralEntity.PatientMedicaidID = PatientMedicaidID;
        visitGeneralEntity.VisitCancelledIndicator = false;
        visitGeneralEntity.Payer = "ODM";
        visitGeneralEntity.PayerID = "77667";
        //TODO: {Payer: "ODM", PayerProgram: "OHC", ProcedureCode: "MR816"}, {Payer: "ODM", PayerProgram: "SP", ProcedureCode: "MR816"}
        visitGeneralEntity.PayerProgram = "OHC";
        visitGeneralEntity.ProcedureCode = "T1000";
        visitGeneralEntity.GroupVisitIndicator = "true";
        visitGeneralEntity.GroupVisitCode = "123456";
        visitGeneralEntity.TimeZone = "US/Eastern";
        visitGeneralEntity.AdjInDateTime = scheduleStartTime;
        visitGeneralEntity.AdjOutDateTime = scheduleEndTime;
        visitGeneralEntity.BillVisit = true;
        visitGeneralEntity.HoursToBill = 120;
        visitGeneralEntity.VisitMemo = memo;
        visitGeneralEntity.MemberVerifiedTimes = false;
        visitGeneralEntity.MemberVerifiedService = false;
        visitGeneralEntity.MemberSignatureAvailable = false;
        visitGeneralEntity.MemberVoiceRecording = false;

        List<com.sandata.entity.ohio.visit.Call> calls = new ArrayList<>();
        com.sandata.entity.ohio.visit.Call call = new com.sandata.entity.ohio.visit.Call();
        call.CallExternalID = commons.generateUniqueNumber();
        call.CallDateTime = scheduleStartTime;
        call.CallAssignment = Constant.CallAssignment.CallIn.toString();
        call.CallType = Constant.CallType.Other.toString();
        call.GroupVisitCode = "12378";
        call.ProcedureCode = "G0300";
        call.PatientIdentifierOnCall = "02225";
        call.MobileLogin = "qweqewq";
        call.CallLatitude = "86.2";
        call.CallLongitude = "160.2";
        call.TelephonyPIN = 2252;
        call.OriginatingPhoneNumber = "1234567890";
        calls.add(call);
        visitGeneralEntity.Calls = calls;

        List<VisitExceptionAcknowledgement> visitExceptionAcknowledgements = new ArrayList<>();
        VisitExceptionAcknowledgement visitExceptionAcknowledgement1 = new VisitExceptionAcknowledgement();
        visitExceptionAcknowledgement1.ExceptionID = "25";
        visitExceptionAcknowledgement1.ExceptionAcknowledged = true;
        visitExceptionAcknowledgements.add(visitExceptionAcknowledgement1);

        visitGeneralEntity.VisitException = visitExceptionAcknowledgements;

        List<com.sandata.entity.ohio.visit.VisitChange> visitChanges = new ArrayList<>();
        com.sandata.entity.ohio.visit.VisitChange visitChange = new com.sandata.entity.ohio.visit.VisitChange();
        visitChange.SequenceID = sequenceId;
        visitChange.ChangeMadeByEmail = "yesterday2010@test.com";
        visitChange.ChangeDateTime = changeDateTime;
        visitChange.ReasonCode = "02";
        visitChange.ChangeReasonMemo = "Change Reason Memo " + memo;
        visitChange.ResolutionCode = "A";

        visitChanges.add(visitChange);
        visitGeneralEntity.VisitChanges = visitChanges;

        visitGeneralEntities.add(visitGeneralEntity);

        return visitGeneralEntities;
    }
}