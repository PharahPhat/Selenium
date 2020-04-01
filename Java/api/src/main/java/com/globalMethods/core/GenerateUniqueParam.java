package com.globalMethods.core;

import Utills_ExtentReport_Log4j.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import static com.globalMethods.core.Constant_SQL.random_Client_AltEVVGeneric_Not_Contain;
import static com.globalMethods.core.Constant_SQL.random_Worker_AltEVVGeneric_PA_Not_Contain;
import static com.globalMethods.core.globalVariables.*;

public class GenerateUniqueParam extends BaseTest {

    private String[] primaryField;

    private DataBaseVerifier dataBaseVerifier = new DataBaseVerifier();
    private Constant_SQL Constant_SQL = new Constant_SQL();
    private Assertion_DbVerifier Assertion_DbVerifier = new Assertion_DbVerifier();


    // ************** Unique Generator for Client *********************************//

    @SuppressWarnings("unchecked")
    public JSONArray ClientParams_OpenEVV(String jsonNameClient) throws IOException, ParseException {
        JSONArray j = loadOpenEvvClient(jsonNameClient);
        JSONObject js = (JSONObject) j.get(0);
        if (state.equalsIgnoreCase("PA")) {
            js.put(ClientBirthDate, "1990-10-28");
        }
        return j;
    }

    private JSONArray loadOpenEvvClient(String jsonNameClient) throws IOException, ParseException {

        String uniqueClientId = CommonMethods.generateRandomNumberOfFixLength(5);

        JSONArray j = CommonMethods.LoadJSON_OpenEVV(jsonNameClient);

        JSONObject js = (JSONObject) j.get(0);
        js.put(ClientID, uniqueClientId);
        js.put(Account, stateInfo.get(ACCID));
        js.put(PayerID, stateInfo.get(PayerID));
        js.put(PayerProgram, stateInfo.get(PayerProgram));
        js.put(ProcedureCode, stateInfo.get(ProcedureCode));
        js.put(ClientSSN, CommonMethods.generateRandomNumberOfFixLength(9));
        js.put(ClientFirstName, CommonMethods.generateRandomStringOfFixLength(15));
        js.put(ClientLastName, CommonMethods.generateRandomStringOfFixLength(15));
        js.put(ClientMedicaidID, CommonMethods.generateRandomNumberOfFixLength(9));
        js.put(ClientEmailAddress, CommonMethods.generateEmailAddress_string(10));

        JSONArray jsonClientPayerInformation = (JSONArray) js.get(Client_Payer_Information);
        JSONObject clientPayerInfo = (JSONObject) jsonClientPayerInformation.get(0);
        clientPayerInfo.put(PayerID, stateInfo.get(PayerID));
        clientPayerInfo.put(PayerProgram, stateInfo.get(PayerProgram));
        clientPayerInfo.put(ProcedureCode, stateInfo.get(ProcedureCode));

        JSONArray j2 = (JSONArray) js.get(ClientPhone);
        JSONObject js2 = (JSONObject) j2.get(0);
        js2.put(Account, stateInfo.get(ACCID));
        js2.put(ClientID, uniqueClientId);

        JSONArray j3 = (JSONArray) js.get(ClientAddress);
        JSONObject js3 = (JSONObject) j3.get(0);
        js3.put(Account, stateInfo.get(ACCID));
        js3.put(ClientID, uniqueClientId);
        js3.put(ClientAddressLine1, CommonMethods.generateRandomStringOfFixLength(9));
        js3.put(ClientAddressLine2, CommonMethods.generateRandomStringOfFixLength(9));
        js3.put(ClientCity, CommonMethods.generateRandomStringOfFixLength(9));
        js3.put(ClientZip, CommonMethods.generateRandomNumberOfFixLength(9));
        js3.put(ClientCounty, CommonMethods.generateRandomStringOfFixLength(9));

        JSONObject js4 = (JSONObject) j3.get(1);
        js4.put(Account, stateInfo.get(ACCID));
        js4.put(ClientID, uniqueClientId);
        js4.put(ClientAddressLine1, CommonMethods.generateRandomStringOfFixLength(9));
        js4.put(ClientAddressLine2, CommonMethods.generateRandomStringOfFixLength(9));
        js4.put(ClientCity, CommonMethods.generateRandomStringOfFixLength(9));
        js4.put(ClientZip, CommonMethods.generateRandomNumberOfFixLength(9));
        js4.put(ClientCounty, CommonMethods.generateRandomStringOfFixLength(9));

        return j;
    }

    @SuppressWarnings("unchecked")
    public JSONArray Schedule_OpenEVV(String jsonNameClient) throws IOException, ParseException {

        String uniqueClientId = CommonMethods.generateRandomNumberOfFixLength(5);

        JSONArray j = CommonMethods.Schedule_OpenEVV(jsonNameClient);

        JSONObject js = (JSONObject) j.get(0);
        js.put("ARNumber", uniqueClientId);

        js.put("ScheduleID", CommonMethods.generateRandomNumberOfFixLength(5));
        js.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(6));
        return j;

    }

    @SuppressWarnings("unchecked")
    public JSONArray ClientParams_3P(String jsonNameClient) throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException {

        JSONArray j = CommonMethods.LoadJSON_ThreeP(jsonNameClient);
        Map<String, String> DbMap = new HashMap<String, String>();

        DbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount, CommonMethods.propertyfileReader(globalVariables.ohio_accid)));

        System.out.println(DbMap.get("PROVIDER_ID"));
        System.out.println(DbMap.get("ACCOUNT"));

        String BusinessEntityMedicaidIdentifier = DbMap.get("PROVIDER_ID");
        String BusinessEntityID = DbMap.get("ACCOUNT");

        JSONObject js = (JSONObject) j.get(0);

        js.put("BusinessEntityID", BusinessEntityID);
        js.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
        js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
        js.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
        js.put("PatientFirstName", CommonMethods.generateRandomStringOfFixLength(10));
        js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(10));

        JSONArray j2 = (JSONArray) js.get("Address");
        JSONObject js2 = (JSONObject) j2.get(0);

        JSONArray j5 = (JSONArray) js.get("Address");
        JSONObject js5 = (JSONObject) j5.get(1);
        String ZipCode = CommonMethods.generateRandomNumberOfFixLength(9);
        js5.put("PatientZip", ZipCode);
        js2.put("PatientAddressLine2", CommonMethods.generateRandomAlphaNumeric(10));
        js2.put("PatientZip", ZipCode);

        JSONArray j3 = (JSONArray) js.get("Phones");
        JSONObject js3 = (JSONObject) j3.get(0);
        js3.put("PatientPhoneNumber", CommonMethods.generateRandomNumberOfFixLength(10));

        JSONArray j4 = (JSONArray) js.get("ResponsibleParty");
        JSONObject js4 = (JSONObject) j4.get(0);
        js4.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(10));
        js4.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(10));

        return j;

    }

    @SuppressWarnings("unchecked")
    public JSONArray ClientParams_AltEVV_Molina(String jsonnameclient) throws IOException, ParseException {

        JSONArray j = CommonMethods.LoadJSON_AltEVV_Molina(jsonnameclient);
        JSONObject js = (JSONObject) j.get(0);

        JSONObject jsonProvider = (JSONObject) js.get(globalVariables.ProviderIdentification);
        jsonProvider.put(ProviderID, stateInfo.get(ProviderID));
        jsonProvider.put(ProviderQualifier, stateInfo.get(ProviderQualifier));

        JSONArray jsonClientPayerInformation = (JSONArray) js.get(Client_Payer_Information);
        JSONObject clientPayerInfo = (JSONObject) jsonClientPayerInformation.get(0);
        clientPayerInfo.put(PayerID, stateInfo.get(PayerID));
        clientPayerInfo.put(PayerProgram, stateInfo.get(PayerProgram));
        clientPayerInfo.put(ProcedureCode, stateInfo.get(ProcedureCode));

        js.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(6));
        js.put("ClientIdentifier", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("ClientOtherID", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("ClientFirstName", "Auto" + CommonMethods.generateRandomStringOfFixLength(10));
        js.put("ClientLastName", "Auto" + CommonMethods.generateRandomStringOfFixLength(10));
        js.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("ClientEmailAddress", CommonMethods.generateEmailAddress_string(10));
        js.put("SequenceID", Long.parseLong(CommonMethods.generateUniqueID()));

        JSONArray jsAdd = (JSONArray) js.get("ClientAddress");
        JSONObject jsObj = (JSONObject) jsAdd.get(0);
        jsObj.put(ClientAddressLine1, CommonMethods.generateRandomStringOfFixLength(9));
        jsObj.put(ClientZip, CommonMethods.generateRandomNumberOfFixLength(9));
        jsObj.put(ClientState, CLIENTSTATE[new Random().nextInt(CLIENTSTATE.length)]);

        JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
        jsObj1.put(ClientAddressLine1, CommonMethods.generateRandomStringOfFixLength(9));
        jsObj1.put(ClientZip, CommonMethods.generateRandomNumberOfFixLength(9));
        jsObj1.put(ClientState, CLIENTSTATE[new Random().nextInt(CLIENTSTATE.length)]);

        JSONArray jsonarrayclientcontact = (JSONArray) js.get(ClientResponsibleParty);
        JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
        jsonObjectClientContact.put(ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(9));
        jsonObjectClientContact.put(ClientContactState, CLIENTSTATE[new Random().nextInt(CLIENTSTATE.length)]);

        return j;
    }

    @SuppressWarnings("unchecked")
    public JSONArray ClientParams_AltEVV(String jsonNameClient) throws IOException, ParseException {
        switch (state) {
            default:
                return loadAltEVVClientJson(jsonNameClient);
            case "Colorado":
                return ClientParams_AltEVV_Colorado(jsonNameClient);
        }
    }

    public JSONArray ClientParams_AltEVV_Colorado(String jsonNameClient) throws IOException, ParseException {
        JSONArray j = loadAltEVVClientJson(jsonNameClient);
        JSONObject js = (JSONObject) j.get(0);
        js.put(ClientTimezone, "US/Mountain");
        js.put(ClientQualifier, ClientMedicaidID);
        js.put(ClientIdentifier, RandomStringUtils.randomAlphabetic(1) + CommonMethods.generateRandomNumberOfFixLength(6));
        js.put(ClientMedicaidID, RandomStringUtils.randomAlphabetic(1) + CommonMethods.generateRandomNumberOfFixLength(6));

        return j;
    }

    public JSONArray loadAltEVVClientJson(String jsonNameClient) throws IOException, ParseException {
        JSONArray j = CommonMethods.LoadJSON_AltEVV(jsonNameClient);
        JSONObject js = (JSONObject) j.get(0);

        JSONObject jsonProvider = (JSONObject) js.get(globalVariables.ProviderIdentification);
        jsonProvider.put(ProviderID, stateInfo.get(ProviderID));
        jsonProvider.put(ProviderQualifier, stateInfo.get(ProviderQualifier));

        js.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(10));
        js.put("ClientIdentifier", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(10));
        js.put("ClientOtherID", CommonMethods.generateUniqueID());
        js.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("ClientFirstName", "Auto" + CommonMethods.generateRandomStringOfFixLength(10));
        js.put("ClientLastName", "Auto" + CommonMethods.generateRandomStringOfFixLength(10));
        js.put("ClientEmailAddress", "Auto" + CommonMethods.generateEmailAddress_string(10));
        js.put("SequenceID", CommonMethods.generateUniqueID());

        JSONArray jsonClientPayerInformation = (JSONArray) js.get(Client_Payer_Information);
        for (int i = 0; i < jsonClientPayerInformation.size(); i++) {
            JSONObject clientPayerInfo = (JSONObject) jsonClientPayerInformation.get(i);
            clientPayerInfo.put(PayerID, stateInfo.get(PayerID));
            clientPayerInfo.put(PayerProgram, stateInfo.get(PayerProgram));
            clientPayerInfo.put(ProcedureCode, stateInfo.get(ProcedureCode));
        }
        JSONArray jsAdd = (JSONArray) js.get("ClientAddress");
        JSONObject jsObj = (JSONObject) jsAdd.get(0);
        jsObj.put("ClientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
        jsObj.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(9));

        JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
        jsObj1.put("ClientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
        jsObj1.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(9));

        JSONArray jsonarrayclientcontact = (JSONArray) js.get("ClientResponsibleParty");
        JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
        jsonObjectClientContact.put("ClientContactZip", CommonMethods.generateRandomNumberOfFixLength(9));

        return j;
    }

    @SuppressWarnings("unchecked")
    public JSONArray ClientParams_AltEVV_requiredMissing(String jsonnameclient) throws InterruptedException, java.text.ParseException, IOException, ParseException {

        JSONArray j = CommonMethods.LoadJSON_AltEVV(jsonnameclient);
        JSONObject js = (JSONObject) j.get(0);

        js.put("ClientID", null);
        js.put("ClientIdentifier", null);
        js.put("ClientOtherID", null);
        js.put("ClientSSN", null);
        js.put("ClientFirstName", null);
        js.put("ClientLastName", null);
        js.put("ClientMedicaidID", null);
        js.put("ClientEmailAddress", null);

        JSONArray jsonArrayAuth = (JSONArray) js.get("ClientPayerInformation");
        JSONObject jsonObjectAuth = (JSONObject) jsonArrayAuth.get(0);
        jsonObjectAuth.put("PayerProgram", null);
        jsonObjectAuth.put("ProcedureCode", null);

        JSONArray jsAdd = (JSONArray) js.get("ClientAddress");
        JSONObject jsObj = (JSONObject) jsAdd.get(0);
        jsObj.put("ClientAddressLine1", null);
        jsObj.put("ClientZip", null);

        JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
        jsObj1.put("ClientAddressLine1", null);
        jsObj1.put("ClientZip", null);


        JSONArray jsonarrayclientcontact = (JSONArray) js.get("ClientResponsibleParty");
        JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
        jsonObjectClientContact.put("ClientContactZip", null);


        return j;
    }

    @SuppressWarnings("unchecked")
    public JSONArray patient_Ohio(String jsonnameclient) throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException {

        JSONArray j = CommonMethods.LoadJSON_Ohio(jsonnameclient);


        JSONObject js = (JSONObject) j.get(0);

        String businessEntityMedicaidIdentifier = stateInfo.get(ProviderID);
        String businessEntityID = stateInfo.get(ACCID);

        js.put("BusinessEntityID", businessEntityID);
        js.put("BusinessEntityMedicaidIdentifier", businessEntityMedicaidIdentifier);
        js.put("PatientOtherID", CommonMethods.generateUniqueID());
        js.put("SequenceID", CommonMethods.generateUniqueID());
        js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
        js.put("PatientLastName", "Auto" + CommonMethods.generateRandomStringOfFixLength(10));
        js.put("PatientFirstName", "Auto" + CommonMethods.generateRandomStringOfFixLength(10));

        JSONArray jsAdd = (JSONArray) js.get("Address");
        JSONObject jsObj = (JSONObject) jsAdd.get(0);
        jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
        jsObj.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

        JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
        jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
        jsObj1.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

//		JSONArray individualPayerInformationArray = (JSONArray) js.get(IndividualPayerInformation);
//		JSONObject individualPayerInformation = (JSONObject) individualPayerInformationArray.get(0);
//		individualPayerInformation.put(Payer, stateInfo.get(PayerID));
//		individualPayerInformation.put(PayerProgram, stateInfo.get(PayerProgram));
//		individualPayerInformation.put(ProcedureCode, stateInfo.get(ProcedureCode));

        JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
        JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
        jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
        jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));


        return j;
    }

    public JSONArray staff_Ohio() throws InterruptedException, IOException, ParseException {

        JSONArray j = CommonMethods.LoadJSON_Ohio(globalVariables.worker_v1_json);
        JSONObject js = (JSONObject) j.get(0);

        js.put("BusinessEntityID", stateInfo.get(ACCID));
        js.put("BusinessEntityMedicaidIdentifier", stateInfo.get(ProviderID));

        js.put("StaffOtherID", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("SequenceID", CommonMethods.generateUniqueID());
        js.put("StaffID", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("StaffSSN", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("StaffLastName", "Auto" + CommonMethods.generateRandomStringOfFixLength(9));
        js.put("StaffFirstName", "Auto" + CommonMethods.generateRandomStringOfFixLength(9));
        js.put("StaffEmail", CommonMethods.generateEmailAddress_alpha(9));

        return j;
    }

    public JSONArray visit_Ohio(String json) throws IOException, ParseException {
        Map<String, String> client = getRandomClient(Constant_SQL.random_ClientAltEVVGenericSql);
        Map<String, String> employee = getRandomEmployee(Constant_SQL.random_Worker_AltEVVGeneric);

        JSONArray jsonArrayVisit = CommonMethods.LoadJSON_Ohio(json);


        JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
        jsonObjectVisit.put("BusinessEntityID", stateInfo.get(ACCID));
        jsonObjectVisit.put("BusinessEntityMedicaidIdentifier", stateInfo.get(ProviderID));

        jsonObjectVisit.put("PatientMedicaidID", client.get("PATIENTMEDICAIDID"));
        jsonObjectVisit.put("PatientOtherID", client.get("PATIENTOTHERID"));
        jsonObjectVisit.put("StaffOtherID", employee.get("STAFFOTHERID"));

        String sequenceid = CommonMethods.generateUniqueID();
        jsonObjectVisit.put("SequenceID", sequenceid);
        jsonObjectVisit.put("VisitOtherID", sequenceid);


        ////////////putting value in Visit subarray detail from alt EVV visitjson//////////////

        JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
        JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);

        jsonObjectVisitChanges.put("SequenceID", sequenceid);

        return jsonArrayVisit;
    }

    @SuppressWarnings("unchecked")
    public JSONArray OpenEVV_auth(String jsonnameauth) throws IOException, ParseException {

        JSONArray jsobject = CommonMethods.LoadJSON_OpenEVV(jsonnameauth);


        JSONObject js = (JSONObject) jsobject.get(0);
        js.put(ProviderID, stateInfo.get(ProviderID));
        js.put(PayerID, stateInfo.get(PayerID));
        js.put(ClientQualifier, stateInfo.get(ClientQualifier));
        Map<String, String> client;
        switch (state) {
            case "VermontOpenEVV":
                client = getRandomClient(Constant_SQL.OpenEvvClientSql_Vermont);
                js.put(ClientIdentifier, client.get("CLIENT_ID_CUSTOM1"));
                break;
            default:
                client = getRandomClient(Constant_SQL.OpenEvvClientSql);
                js.put(ClientIdentifier, client.get("PATIENTOTHERID"));
                js.put(AuthorizationEndDate, "12/31/2019");
                js.put(AuthorizationStartDate, "01/01/2019");
                JSONArray array = (JSONArray) js.get(DiagnosisCode);
                JSONObject jsonObject = (JSONObject) array.get(0);
                jsonObject.put(ClientDiagnosisCodeBeginDate, "01/02/2019");
                jsonObject.put(ClientDiagnosisCodeEndDate, "01/01/2025");
                break;
        }

        js.put("AuthorizationReferenceNumber", CommonMethods.generateUniqueID());
        JSONArray array = (JSONArray) js.get(AuthorizationLimit);
        JSONObject jsonObject = (JSONObject) array.get(0);
        jsonObject.put(PayerProgram, stateInfo.get(PayerProgram));
        jsonObject.put(AuthorizationServiceID, stateInfo.get(ProcedureCode));

        return jsobject;

    }


    @SuppressWarnings("unchecked")
    public JSONArray ProviderParams_OpenEVV(String jsonnameclient) throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException {

        JSONArray j = CommonMethods.LoadJSON_OpenEVV(jsonnameclient);
        JSONObject js = (JSONObject) j.get(0);
        Map<String, String> DbMap = new HashMap<String, String>();

        js.put("ProviderID", CommonMethods.generateRandomNumberOfFixLength(7));
        js.put("ProviderName", CommonMethods.generateRandomStringOfFixLength(10));
        js.put("AddressLine1", CommonMethods.generateRandomStringOfFixLength(30));
        js.put("AddressCity", CommonMethods.generateRandomStringOfFixLength(15));
        js.put("AddressState", DataGeneratorClient.generateClientState());
        js.put("AddressZip", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("AgencyPhone", CommonMethods.generateRandomNumberOfFixLength(10));
        js.put("AgencyEmail", CommonMethods.generateEmailAddress_string(10));
        js.put("PrimaryContactLastName", CommonMethods.generateRandomStringOfFixLength(10));
        js.put("PrimaryContactFirstName", CommonMethods.generateRandomStringOfFixLength(10));


        return j;
    }

    @SuppressWarnings("unchecked")
    public JSONArray ProviderParams_OpenEVV_removing_nonmandatefields(String jsonnameclient) throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException {

        JSONArray j = CommonMethods.LoadJSON_OpenEVV(jsonnameclient);
        JSONObject js = (JSONObject) j.get(0);
        Map<String, String> DbMap = new HashMap<String, String>();

        js.put("ProviderID", CommonMethods.generateRandomNumberOfFixLength(7));
        js.put("ProviderName", CommonMethods.generateRandomStringOfFixLength(10));
        js.put("AddressLine1", CommonMethods.generateRandomStringOfFixLength(30));
        js.put("AddressCity", CommonMethods.generateRandomStringOfFixLength(15));
        js.put("AddressState", DataGeneratorClient.generateClientState());
        js.put("AddressZip", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("AgencyPhone", CommonMethods.generateRandomNumberOfFixLength(10));
        js.put("AgencyEmail", CommonMethods.generateEmailAddress_string(10));
        js.put("PrimaryContactLastName", CommonMethods.generateRandomStringOfFixLength(10));
        js.put("PrimaryContactFirstName", CommonMethods.generateRandomStringOfFixLength(10));

        js.remove(globalVariables.ProviderDoingBusinessAs);
        js.remove(globalVariables.AddressLine2);
        js.remove(globalVariables.County);
        js.remove(globalVariables.ProviderFax);
        js.remove(globalVariables.ProviderAPI);
        js.remove(globalVariables.ProviderNPI);
        js.remove(globalVariables.ProviderMedicaidID);
        js.remove(globalVariables.SSN);
        js.remove(globalVariables.TaxID);
        js.remove(globalVariables.ProviderRequireAuth);
        js.remove(globalVariables.ProviderDateBegin);
        js.remove(globalVariables.SuspensionDate);
        js.remove(globalVariables.TerminationDate);
        js.remove(globalVariables.providertaxonomy);
        return j;
    }

    @SuppressWarnings("unchecked")
    public JSONArray ProviderParams_OpenEVVupdateValue(String jsonnameclient) throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException {

        JSONArray j = CommonMethods.LoadJSON_OpenEVV(jsonnameclient);
        JSONObject js = (JSONObject) j.get(0);
        Map<String, String> DbMap;

        DbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount, CommonMethods.propertyfileReader("providerIndiana_accId")));

        System.out.println(DbMap.get("PROVIDER_ID"));
        System.out.println(DbMap.get("ACCOUNT"));

        js.put("ProviderID", DbMap.get("PROVIDER_ID"));
        js.put("ProviderName", CommonMethods.generateRandomStringOfFixLength(10));
        js.put("AddressLine1", CommonMethods.generateRandomStringOfFixLength(30));
        js.put("AddressCity", CommonMethods.generateRandomStringOfFixLength(15));
        js.put("AddressState", DataGeneratorClient.generateClientState());
        js.put("AddressZip", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("AgencyPhone", CommonMethods.generateRandomNumberOfFixLength(10));
        js.put("AgencyEmail", CommonMethods.generateEmailAddress_string(10));
        js.put("PrimaryContactLastName", CommonMethods.generateRandomStringOfFixLength(10));
        js.put("PrimaryContactFirstName", CommonMethods.generateRandomStringOfFixLength(10));


        return j;
    }

    @SuppressWarnings("unchecked")
    public JSONArray MemberParams_OpenEVV(String jsonnameclient) throws IOException, ParseException {

        JSONArray j = CommonMethods.LoadJSON_OpenEVV(jsonnameclient);
        JSONObject js = (JSONObject) j.get(0);
        js.put(ProviderID, stateInfo.get(ProviderID));
        js.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(5));
        js.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(10));
        js.put("ClientLastName", CommonMethods.generateRandomStringOfFixLength(10));
        js.put("ClientCustomID", CommonMethods.generateRandomNumberOfFixLength(10));
        js.put("ClientOtherID", CommonMethods.generateRandomNumberOfFixLength(10));
        js.put("ClientMedicalRecordNumber", CommonMethods.generateRandomNumberOfFixLength(10));
        js.put("ClientEmail", CommonMethods.generateEmailAddress_string(10));

        JSONArray jsonArrayElig = (JSONArray) js.get("ClientEligibility");
        JSONObject jsonObjectElig = (JSONObject) jsonArrayElig.get(0);
        jsonObjectElig.put(PayerID, stateInfo.get(PayerID));
        jsonObjectElig.put(PayerProgram, stateInfo.get(PayerProgram));
        jsonObjectElig.put(PayerService, stateInfo.get(ProcedureCode));
        jsonObjectElig.put("Modifier1", CommonMethods.generateRandomNumberOfFixLength(2));
        jsonObjectElig.put("Modifier2", CommonMethods.generateRandomNumberOfFixLength(2));
        jsonObjectElig.put("Modifier3", CommonMethods.generateRandomNumberOfFixLength(2));
        jsonObjectElig.put("Modifier4", CommonMethods.generateRandomNumberOfFixLength(2));

        JSONArray jsAdd = (JSONArray) js.get("ClientAddress");
        JSONObject jsObj = (JSONObject) jsAdd.get(0);
        jsObj.put("ClientState", DataGeneratorClient.generateClientState());
        jsObj.put("ClientCounty", CommonMethods.generateRandomStringOfFixLength(9));
        jsObj.put("ClientAddressLine2", CommonMethods.generateRandomStringOfFixLength(15));
        jsObj.put("ClientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
        jsObj.put("ClientAddressType", DataGeneratorClient.clientAddressType());
        jsObj.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(9));
        jsObj.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(9));

        JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
        jsObj1.put("ClientState", DataGeneratorClient.generateClientState());
        jsObj1.put("ClientCounty", CommonMethods.generateRandomStringOfFixLength(9));
        jsObj1.put("ClientAddressLine2", CommonMethods.generateRandomStringOfFixLength(15));
        jsObj1.put("ClientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
        jsObj1.put("ClientAddressType", DataGeneratorClient.clientAddressType());
        jsObj1.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(9));
        jsObj1.put("ClientZip", CommonMethods.generateRandomNumberOfFixLength(9));

        JSONArray jsContact = (JSONArray) js.get(globalVariables.ClientContact);
        JSONObject contact = (JSONObject) jsContact.get(0);
        contact.put(globalVariables.clientContactFirstName, CommonMethods.generateRandomStringOfFixLength(10));
        contact.put(globalVariables.clientContactLastName, CommonMethods.generateRandomStringOfFixLength(10));

        JSONArray jsonClientDesignee = (JSONArray) js.get(ClientDesignee);
        JSONObject clientDesignee = (JSONObject) jsonClientDesignee.get(0);
        clientDesignee.put("ClientDesigneeFirstName", CommonMethods.generateRandomStringOfFixLength(10));
        clientDesignee.put("ClientDesigneeLastName", CommonMethods.generateRandomStringOfFixLength(10));
        clientDesignee.put("ClientDesigneeStatus", "02");
        clientDesignee.put("ClientDesigneeEmail", DataGeneratorEmployee.generateEmpEmail(8));
        clientDesignee.put("ClientDesigneeStartDate", CommonMethods.generateTodayDate_YYYY_MM_dd());
        clientDesignee.put("ClientDesigneeEndDate", CommonMethods.generateTodayDate_YYYY_MM_dd());

        return j;

    }

    // ************** Unique Generator for pipe delimited *********************************//

    public Map<String, String> MemberParams_PipeDelimited() throws InterruptedException, java.text.ParseException, IOException, ParseException, ClassNotFoundException, SQLException {
        Map<String, String> mapdataByValue = new HashMap<>();

        mapdataByValue.put(globalVariables.molinaClientId, CommonMethods.generateRandomNumberOfFixLength(5));
        mapdataByValue.put(globalVariables.molinaClientSSN, CommonMethods.generateRandomNumberOfFixLength(9));
        mapdataByValue.put(globalVariables.molinaClientFirstName, CommonMethods.generateRandomStringOfFixLength(10));
        mapdataByValue.put(globalVariables.molinaClientLastName, CommonMethods.generateRandomStringOfFixLength(10));
        mapdataByValue.put(globalVariables.molinaClientCustomID, CommonMethods.generateRandomNumberOfFixLength(10));
        mapdataByValue.put(globalVariables.molinaClientOtherID, CommonMethods.generateRandomNumberOfFixLength(10));
        mapdataByValue.put(globalVariables.molinaClientMedicalRecordNum, CommonMethods.generateRandomNumberOfFixLength(10));
        mapdataByValue.put(globalVariables.molinaClientEmail, CommonMethods.generateEmailAddress_string(10));
        mapdataByValue.put(globalVariables.molinaAction, "A");
        mapdataByValue.put("ProviderID", dataBaseVerifier.executeQueryString(String.format(Constant_SQL.sql_GetProviderIdIndiana, "240")));

        return mapdataByValue;

    }

    public Map<String, String> providerParams_PipeDelimited() throws InterruptedException, java.text.ParseException, IOException, ParseException {
        Map<String, String> mapdataByValue = new HashMap<>();

        mapdataByValue.put(globalVariables.molinaproviderId, CommonMethods.generateRandomNumberOfFixLength(10));
        mapdataByValue.put(globalVariables.molinaprovider1FirstName, "Auto_" + CommonMethods.generateRandomStringOfFixLength(10));
        mapdataByValue.put(globalVariables.molinaprovider1LastName, "Auto_" + CommonMethods.generateRandomStringOfFixLength(10));
        mapdataByValue.put(globalVariables.molinaproviderEmail, "Auto_" + CommonMethods.generateEmailAddress_string(10));


        return mapdataByValue;

    }


    public Map<String, String> ohioclaim_PipeDelimited() throws InterruptedException, SQLException, ClassNotFoundException {
        Map<String, String> mapDataByValueohio = new HashMap<String, String>();
        Map<String, String> DbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.verified_Visit, "10011"));
        Map<String, String> providerInfo = dataBaseVerifier.executeQuery(String.format(Constant_SQL.getProviderID, "10011"));

        mapDataByValueohio.put(globalVariables.businnesmedicaidid, providerInfo.get("PROVIDER_ID"));
        mapDataByValueohio.put(globalVariables.RequestType, "Model1");
        mapDataByValueohio.put(globalVariables.batchid, CommonMethods.generateRandomNumberOfFixLength(10));
        mapDataByValueohio.put(globalVariables.transactionid, CommonMethods.generateRandomNumberOfFixLength(9));
        mapDataByValueohio.put(globalVariables.payer, DbMap.get("PAYOR_ID"));
        mapDataByValueohio.put(globalVariables.icnnumber, CommonMethods.generateRandomNumberOfFixLength(13));
        mapDataByValueohio.put(globalVariables.dlnnumber, CommonMethods.generateRandomNumberOfFixLength(2));
        mapDataByValueohio.put(globalVariables.ProviderQualifier, "MedicaidID");
        mapDataByValueohio.put(globalVariables.ProviderID, providerInfo.get("PROVIDER_ID"));
        mapDataByValueohio.put(globalVariables.PatientQualifier, "MedicaidID");
        mapDataByValueohio.put(globalVariables.PatientID, DbMap.get("MEDICAID_ID"));
        mapDataByValueohio.put(globalVariables.ServiceStartDate, DbMap.get("VISIT_DATE"));
        mapDataByValueohio.put(globalVariables.ServiceEndDate, DbMap.get("VISIT_EDATE"));
        mapDataByValueohio.put(globalVariables.ProcedureCode, DbMap.get("SERVICE"));
        mapDataByValueohio.put(globalVariables.UnitsRule, "AddUnits");
        mapDataByValueohio.put(globalVariables.dbModifier1, "HQ");
        mapDataByValueohio.put(globalVariables.dbModifier2, "HQ");
        mapDataByValueohio.put(globalVariables.dbModifier3, "HQ");
        mapDataByValueohio.put(globalVariables.dbModifier4, "HQ");
        mapDataByValueohio.put(globalVariables.Units, "7");
        mapDataByValueohio.put(globalVariables.MatchingRule, "ExcludeUnits");


        return mapDataByValueohio;

    }

    public Map<String, String> ohioclaim_PipeDelimited_maxlength() throws InterruptedException, java.text.ParseException, IOException, ParseException {
        Map<String, String> mapdataByValueohio = new HashMap<String, String>();

        mapdataByValueohio.put(globalVariables.businnesmedicaidid, "1234567");
        mapdataByValueohio.put(globalVariables.RequestType, "Model1");
        mapdataByValueohio.put(globalVariables.batchid, CommonMethods.generateRandomNumberOfFixLength(19));
        mapdataByValueohio.put(globalVariables.transactionid, CommonMethods.generateRandomNumberOfFixLength(19));
        mapdataByValueohio.put(globalVariables.payer, "ODM");
        mapdataByValueohio.put(globalVariables.icnnumber, CommonMethods.generateRandomNumberOfFixLength(13));
        mapdataByValueohio.put(globalVariables.dlnnumber, CommonMethods.generateRandomNumberOfFixLength(2));
        mapdataByValueohio.put(globalVariables.payer, "ODM");
        mapdataByValueohio.put(globalVariables.ProviderQualifier, "MedicaidID");
        mapdataByValueohio.put(globalVariables.ProviderID, "1234567");
        mapdataByValueohio.put(globalVariables.PatientQualifier, "MedicaidID");
        mapdataByValueohio.put(globalVariables.PatientID, "368726378263");
        mapdataByValueohio.put(globalVariables.ServiceStartDate, "2019-04-16");
        mapdataByValueohio.put(globalVariables.ServiceEndDate, "2019-04-16");
        mapdataByValueohio.put(globalVariables.ProcedureCode, "G0156");
        mapdataByValueohio.put(globalVariables.UnitsRule, "AddUnits");
        mapdataByValueohio.put(globalVariables.dbModifier1, "HQ");
        mapdataByValueohio.put(globalVariables.dbModifier2, "HQ");
        mapdataByValueohio.put(globalVariables.dbModifier3, "HQ");
        mapdataByValueohio.put(globalVariables.dbModifier4, "HQ");
        mapdataByValueohio.put(globalVariables.Units, "99999.90");
        mapdataByValueohio.put(globalVariables.MatchingRule, "ExcludeUnits");


        return mapdataByValueohio;

    }

    public Map<String, String> ohioclaim_outboundPipeDelimited() throws InterruptedException, java.text.ParseException, IOException, ParseException {
        Map<String, String> mapdataByValueohiooutbound = new HashMap<String, String>();

        mapdataByValueohiooutbound.put(globalVariables.processFileName, "tester");
        mapdataByValueohiooutbound.put(globalVariables.RecordCount, "1");
        mapdataByValueohiooutbound.put(globalVariables.StartDateTime, "2019-01-23T08:00:00Z");
        mapdataByValueohiooutbound.put(globalVariables.EndDateTime, "2019-01-23T11:00:00Z");
        mapdataByValueohiooutbound.put(globalVariables.Hash, "");


        return mapdataByValueohiooutbound;

    }

    public Map<String, String> MemberParams_PipeDelimited_RequiredField() {
        Map<String, String> mapdataByValue = new HashMap<>();


        mapdataByValue.put(globalVariables.molinaClientSSN, CommonMethods.generateRandomNumberOfFixLength(9));
        mapdataByValue.put(globalVariables.molinaClientFirstName, "Auto_" + CommonMethods.generateRandomStringOfFixLength(10));
        mapdataByValue.put(globalVariables.molinaClientLastName, "Auto_" + CommonMethods.generateRandomStringOfFixLength(10));
        mapdataByValue.put(globalVariables.molinaClientCustomID, CommonMethods.generateRandomNumberOfFixLength(10));
        mapdataByValue.put(globalVariables.molinaClientOtherID, CommonMethods.generateRandomNumberOfFixLength(10));
        mapdataByValue.put(globalVariables.molinaClientMedicalRecordNum, CommonMethods.generateRandomNumberOfFixLength(10));
        mapdataByValue.put(globalVariables.molinaClientEmail, "Auto_" + CommonMethods.generateEmailAddress_string(10));
        mapdataByValue.put(globalVariables.molinaAction, "A");
        mapdataByValue.put(globalVariables.molinaclientAddressType, DataGeneratorClient.clientAddressType());
        mapdataByValue.put(globalVariables.molinaclientAddressLine1, CommonMethods.generateRandomAlphaNumeric(25));
        mapdataByValue.put(globalVariables.molinaclientCity, CommonMethods.generateRandomAlphaNumeric(25));
        mapdataByValue.put(globalVariables.molinaclientState, DataGeneratorClient.generateClientState());
        mapdataByValue.put(globalVariables.molinaclientZip, CommonMethods.generateRandomNumberOfFixLength(9));
        mapdataByValue.put(globalVariables.molinaclientEligibilityDateBegin, CommonMethods.generateTodayDate_YYYY_MM_dd());


        return mapdataByValue;

    }

    public Map<String, String> MemberParams_PipeDelimited_RequiredFieldMax() {
        Map<String, String> mapdataByValue = new HashMap<>();


        mapdataByValue.put(globalVariables.molinaClientSSN, CommonMethods.generateRandomNumberOfFixLength(9));
        mapdataByValue.put(globalVariables.molinaClientFirstName, "Auto_" + CommonMethods.generateRandomStringOfFixLength(25));
        mapdataByValue.put(globalVariables.molinaClientLastName, "Auto_" + CommonMethods.generateRandomStringOfFixLength(25));
        mapdataByValue.put(globalVariables.molinaClientCustomID, CommonMethods.generateRandomNumberOfFixLength(24));
        mapdataByValue.put(globalVariables.molinaClientOtherID, CommonMethods.generateRandomNumberOfFixLength(24));
        mapdataByValue.put(globalVariables.molinaClientMedicalRecordNum, CommonMethods.generateRandomNumberOfFixLength(12));
        mapdataByValue.put(globalVariables.molinaAction, "A");
        mapdataByValue.put(globalVariables.molinaclientAddressLine1, CommonMethods.generateRandomAlphaNumeric(30));
        mapdataByValue.put(globalVariables.molinaclientCity, CommonMethods.generateRandomAlphaNumeric(30));
        mapdataByValue.put(globalVariables.molinaclientState, DataGeneratorClient.generateClientState());
        mapdataByValue.put(globalVariables.molinaclientZip, CommonMethods.generateRandomNumberOfFixLength(9));
        mapdataByValue.put(globalVariables.molinaclientEligibilityDateBegin, CommonMethods.generateTodayDate_YYYY_MM_dd());


        return mapdataByValue;

    }

    public List<String> MemberParams_PipeDelimited_Missing_RequiredField() throws InterruptedException, java.text.ParseException, IOException, ParseException {
        List<String> mapdataByValue = new ArrayList<String>();

        mapdataByValue.add(globalVariables.molinaClientSSN);
        mapdataByValue.add(globalVariables.molinaClientFirstName);
        mapdataByValue.add(globalVariables.molinaClientLastName);
        mapdataByValue.add(globalVariables.molinaClientCustomID);
        mapdataByValue.add(globalVariables.molinaClientOtherID);
        mapdataByValue.add(globalVariables.molinaClientMedicalRecordNum);
        mapdataByValue.add(globalVariables.molinaAction);
        mapdataByValue.add("ClientAddressType");
        mapdataByValue.add(globalVariables.molinaclientAddressLine1);
        mapdataByValue.add(globalVariables.molinaclientCity);
        mapdataByValue.add(globalVariables.molinaclientState);
        mapdataByValue.add(globalVariables.molinaclientZip);
        mapdataByValue.add(globalVariables.molinaclientEligibilityDateBegin);
        mapdataByValue.add("ClientStatus");
        mapdataByValue.add("PayerID");
        return mapdataByValue;

    }

    public List<String> authParamsPipeDelimitedOnlyRequiredField() {
        List<String> mapDataByValue = new ArrayList<>();

        mapDataByValue.add("payerid");
        mapDataByValue.add("payerProgram");
        mapDataByValue.add("clientQualifier");
        mapDataByValue.add("providerQualifier");
        mapDataByValue.add("providerId");
        mapDataByValue.add("authorizationReferenceNumber");
        mapDataByValue.add("authorizationServiceID");
        mapDataByValue.add("authorizationAmountType");
        mapDataByValue.add("authorizationStartDate");
        mapDataByValue.add("AuthorizationEndDate");
        mapDataByValue.add("authorizationLimitType");
        mapDataByValue.add("authorizationStatus");
        return mapDataByValue;

    }

    public List<String> authParamsPipeDelimitedNonRequiredField() {
        List<String> mapDataByValue = new ArrayList<>();

        mapDataByValue.add("payerRegion");
        mapDataByValue.add("authorizationComments");
        mapDataByValue.add("authorizationMaximum");
        mapDataByValue.add("authorizationEndDate");
        mapDataByValue.add("authorizationShared");
        mapDataByValue.add("serviceAuthorizedDate");
        mapDataByValue.add("authorizationBillingType");
        mapDataByValue.add("ClientDiagnosisCodeIsPrimary");
        mapDataByValue.add("ClientDiagnosisCode");
        mapDataByValue.add("ClientDiagnosisCodeBeginDate");
        mapDataByValue.add("ClientDiagnosisCodeEndDate");
        mapDataByValue.add("authorizationWeekStart");
        mapDataByValue.add("authorizationLimitDayOfWeek");
        mapDataByValue.add("authorizationLimitStartTime");
        mapDataByValue.add("authorizationLimitEndTime");
        mapDataByValue.add("modifier1");
        mapDataByValue.add("modifier2");
        mapDataByValue.add("modifier3");
        mapDataByValue.add("modifier4");
        return mapDataByValue;

    }

    public Map<String, String> MemberParams_PipeDelimited_RequiredFieldMin() {
        Map<String, String> mapdataByValue = new HashMap<>();
        mapdataByValue.put(globalVariables.molinaClientSSN, CommonMethods.generateRandomNumberOfFixLength(9));
        mapdataByValue.put(globalVariables.molinaClientFirstName, "Auto_" + CommonMethods.generateRandomStringOfFixLength(1));
        mapdataByValue.put(globalVariables.molinaClientLastName, "Auto_" + CommonMethods.generateRandomStringOfFixLength(1));
        mapdataByValue.put(globalVariables.molinaClientCustomID, CommonMethods.generateRandomNumberOfFixLength(1));
        mapdataByValue.put(globalVariables.molinaClientOtherID, CommonMethods.generateRandomNumberOfFixLength(1));
        mapdataByValue.put(globalVariables.molinaClientMedicalRecordNum, CommonMethods.generateRandomNumberOfFixLength(1));
        mapdataByValue.put(globalVariables.molinaAction, "A");
        mapdataByValue.put(globalVariables.molinaclientAddressLine1, CommonMethods.generateRandomAlphaNumeric(1));
        mapdataByValue.put(globalVariables.molinaclientCity, CommonMethods.generateRandomAlphaNumeric(1));
        mapdataByValue.put(globalVariables.molinaclientState, DataGeneratorClient.generateClientState());
        mapdataByValue.put(globalVariables.molinaclientZip, CommonMethods.generateRandomNumberOfFixLength(5));
        mapdataByValue.put(globalVariables.molinaclientEligibilityDateBegin, CommonMethods.generateTodayDate_YYYY_MM_dd());
        return mapdataByValue;

    }

    public Map<String, String> AuthParams_PipeDelimited() {
        Map<String, String> mapdataByValue = new HashMap<>();

        mapdataByValue.put("clientIdentifier", CommonMethods.generateRandomNumberOfFixLength(9));

        mapdataByValue.put("providerId", stateInfo.get(ProviderID));

        mapdataByValue.put("providerQualifier", stateInfo.get(ProviderQualifier));

        mapdataByValue.put("authorizationReferenceNumber", CommonMethods.generateRandomNumberOfFixLength(10));

        return mapdataByValue;

    }

    public Map<String, String> AuthParams_PipeDelimited_MaxValue() {
        Map<String, String> mapdataByValue = new HashMap<>();

        mapdataByValue.put("payerId", stateInfo.get(PayerID));
        mapdataByValue.put("payerProgram", stateInfo.get(PayerProgram));
        mapdataByValue.put("payerRegion", "VN");
        mapdataByValue.put("clientQualifier", "ClientOtherID");
        mapdataByValue.put("clientIdentifier", CommonMethods.generateRandomNumberOfFixLength(24));
        mapdataByValue.put("providerQualifier", stateInfo.get(ProviderQualifier));
        mapdataByValue.put("providerId", stateInfo.get(ProviderID));
        mapdataByValue.put("authorizationReferenceNumber", CommonMethods.generateRandomNumberOfFixLength(25));
        mapdataByValue.put("authorizationServiceID", CommonMethods.generateRandomNumberOfFixLength(5));
        mapdataByValue.put("authorizationBillingType", "USD");
        mapdataByValue.put("modifier1", CommonMethods.generateRandomNumberOfFixLength(2));
        mapdataByValue.put("modifier2", CommonMethods.generateRandomNumberOfFixLength(2));
        mapdataByValue.put("modifier3", CommonMethods.generateRandomNumberOfFixLength(2));
        mapdataByValue.put("modifier4", CommonMethods.generateRandomNumberOfFixLength(2));
        mapdataByValue.put("authorizationAmountType", "H");
        mapdataByValue.put("authorizationMaximum", "10");
        mapdataByValue.put("authorizationStartDate", CommonMethods.generatePastDate_YYYY_MM_dd());
        mapdataByValue.put("authorizationEndDate", CommonMethods.generateTodayDate_YYYY_MM_dd());
        mapdataByValue.put("authorizationShared", "Y");
        mapdataByValue.put("authorizationComments", CommonMethods.generateRandomStringOfFixLength(200));
        mapdataByValue.put("authorizationLimitType", "W");
        mapdataByValue.put("authorizationStatus", "A");
        mapdataByValue.put("authorizationLimit", "10");
        mapdataByValue.put("authorizationWeekStart", CommonMethods.AuthWeekStartType());
        mapdataByValue.put("authorizationLimitDayOfWeek", CommonMethods.AuthWeekStartType());
        mapdataByValue.put("authorizationLimitStartTime", "1000");
        mapdataByValue.put("authorizationLimitEndTime", "1200");
        mapdataByValue.put("clientDiagnosisCodeIsPrimary", "N");
        mapdataByValue.put("clientDiagnosisCode", CommonMethods.generateEmailAddress_alpha(1) + CommonMethods.generateRandomNumberOfFixLength(2) + "." + CommonMethods.generateEmailAddress_alpha(1));
        mapdataByValue.put("clientDiagnosisCodeBeginDate", CommonMethods.generatePastDate_YYYY_MM_dd());
        mapdataByValue.put("clientDiagnosisCodeEndDate", CommonMethods.generateTodayDate_YYYY_MM_dd());

        return mapdataByValue;

    }

    public Map<String, String> AuthParams_PipeDelimited_PositveValue() {
        Map<String, String> mapdataByValue = new HashMap<>();

        mapdataByValue.put("payerId", stateInfo.get(PayerID));
        mapdataByValue.put("payerProgram", stateInfo.get(PayerProgram));
        mapdataByValue.put("payerRegion", "VN");
        mapdataByValue.put("clientQualifier", "ClientOtherID");
        mapdataByValue.put("clientIdentifier", CommonMethods.generateRandomNumberOfFixLength(10));
        mapdataByValue.put("providerQualifier", stateInfo.get(ProviderQualifier));
        mapdataByValue.put("providerId", stateInfo.get(ProviderID));
        mapdataByValue.put("authorizationReferenceNumber", CommonMethods.generateRandomNumberOfFixLength(5));
        mapdataByValue.put("authorizationServiceID", CommonMethods.generateRandomNumberOfFixLength(3));
        mapdataByValue.put("authorizationBillingType", "USD");
        mapdataByValue.put("modifier1", CommonMethods.generateRandomNumberOfFixLength(2));
        mapdataByValue.put("modifier2", CommonMethods.generateRandomNumberOfFixLength(2));
        mapdataByValue.put("modifier3", CommonMethods.generateRandomNumberOfFixLength(2));
        mapdataByValue.put("modifier4", CommonMethods.generateRandomNumberOfFixLength(2));
        mapdataByValue.put("authorizationAmountType", "H");
        mapdataByValue.put("authorizationMaximum", "10");
        mapdataByValue.put("authorizationStartDate", CommonMethods.generatePastDate_YYYY_MM_dd());
        mapdataByValue.put("authorizationEndDate", CommonMethods.generateTodayDate_YYYY_MM_dd());
        mapdataByValue.put("authorizationShared", "Y");
        mapdataByValue.put("authorizationComments", CommonMethods.generateRandomStringOfFixLength(5));
        mapdataByValue.put("authorizationLimitType", "W");
        mapdataByValue.put("authorizationStatus", "A");
        mapdataByValue.put("authorizationLimit", "10");
        mapdataByValue.put("authorizationWeekStart", CommonMethods.AuthWeekStartType());
        mapdataByValue.put("authorizationLimitDayOfWeek", CommonMethods.AuthWeekStartType());
        mapdataByValue.put("authorizationLimitStartTime", "1000");
        mapdataByValue.put("authorizationLimitEndTime", "1200");
        mapdataByValue.put("clientDiagnosisCodeIsPrimary", "N");
        mapdataByValue.put("clientDiagnosisCodeBeginDate", CommonMethods.generatePastDate_YYYY_MM_dd());
        mapdataByValue.put("clientDiagnosisCodeEndDate", CommonMethods.generateTodayDate_YYYY_MM_dd());

        return mapdataByValue;
    }

    public Map<String, String> AuthParams_PipeDelimited_PositveValue_Pensyl() {
        Map<String, String> mapdataByValue = new HashMap<>();

        mapdataByValue.put("payerId", stateInfo.get(PayerID));
        mapdataByValue.put("payerProgram", stateInfo.get(PayerProgram));
        mapdataByValue.put("payerRegion", "VN");
        mapdataByValue.put("clientQualifier", "ClientCustomID");
        mapdataByValue.put("clientIdentifier", CommonMethods.generateRandomNumberOfFixLength(10));
        mapdataByValue.put("providerQualifier", stateInfo.get(ProviderQualifier));
        mapdataByValue.put("providerId", stateInfo.get(ProviderID));
        mapdataByValue.put("authorizationReferenceNumber", CommonMethods.generateRandomNumberOfFixLength(5));
        mapdataByValue.put("authorizationServiceID", CommonMethods.generateRandomNumberOfFixLength(3));
        mapdataByValue.put("authorizationBillingType", "USD");
        mapdataByValue.put("modifier1", CommonMethods.generateRandomNumberOfFixLength(2));
        mapdataByValue.put("modifier2", CommonMethods.generateRandomNumberOfFixLength(2));
        mapdataByValue.put("modifier3", CommonMethods.generateRandomNumberOfFixLength(2));
        mapdataByValue.put("modifier4", CommonMethods.generateRandomNumberOfFixLength(2));
        mapdataByValue.put("authorizationAmountType", "H");
        mapdataByValue.put("authorizationMaximum", "10");
        mapdataByValue.put("authorizationStartDate", CommonMethods.generatePastDate_YYYY_MM_dd());
        mapdataByValue.put("authorizationEndDate", CommonMethods.generateTodayDate_YYYY_MM_dd());
        mapdataByValue.put("authorizationShared", "Y");
        mapdataByValue.put("authorizationComments", CommonMethods.generateRandomStringOfFixLength(5));
        mapdataByValue.put("authorizationLimitType", "W");
        mapdataByValue.put("authorizationStatus", "A");
        mapdataByValue.put("authorizationLimit", "10");
        mapdataByValue.put("authorizationWeekStart", CommonMethods.AuthWeekStartType());
        mapdataByValue.put("authorizationLimitDayOfWeek", CommonMethods.AuthWeekStartType());
        mapdataByValue.put("authorizationLimitStartTime", "1000");
        mapdataByValue.put("authorizationLimitEndTime", "1200");
        mapdataByValue.put("clientDiagnosisCodeIsPrimary", "N");
        mapdataByValue.put("clientDiagnosisCodeBeginDate", CommonMethods.generatePastDate_YYYY_MM_dd());
        mapdataByValue.put("clientDiagnosisCodeEndDate", CommonMethods.generateTodayDate_YYYY_MM_dd());

        return mapdataByValue;
    }

    public Map<String, String> AuthParams_PipeDelimited_MinValue() {
        Map<String, String> mapdataByValue = new HashMap<>();

        mapdataByValue.put("payerId", stateInfo.get(PayerID));
        mapdataByValue.put("payerProgram", CommonMethods.generateRandomNumberOfFixLength(1));
        mapdataByValue.put("payerRegion", "VN");
        mapdataByValue.put("clientQualifier", "ClientOtherID");
        mapdataByValue.put("clientIdentifier", CommonMethods.generateRandomNumberOfFixLength(1));
        mapdataByValue.put("providerQualifier", stateInfo.get(ProviderQualifier));
        mapdataByValue.put("providerId", stateInfo.get(ProviderID));
        mapdataByValue.put("authorizationReferenceNumber", CommonMethods.generateRandomNumberOfFixLength(1));
        mapdataByValue.put("authorizationServiceID", CommonMethods.generateRandomNumberOfFixLength(1));
        mapdataByValue.put("authorizationBillingType", "USD");
        mapdataByValue.put("modifier1", CommonMethods.generateRandomNumberOfFixLength(1));
        mapdataByValue.put("modifier2", CommonMethods.generateRandomNumberOfFixLength(1));
        mapdataByValue.put("modifier3", CommonMethods.generateRandomNumberOfFixLength(1));
        mapdataByValue.put("modifier4", CommonMethods.generateRandomNumberOfFixLength(1));
        mapdataByValue.put("authorizationAmountType", "H");
        mapdataByValue.put("authorizationMaximum", "10");
        mapdataByValue.put("authorizationStartDate", CommonMethods.generatePastDate_YYYY_MM_dd());
        mapdataByValue.put("authorizationEndDate", CommonMethods.generateTodayDate_YYYY_MM_dd());
        mapdataByValue.put("authorizationShared", "Y");
        mapdataByValue.put("authorizationComments", CommonMethods.generateRandomStringOfFixLength(1));
        mapdataByValue.put("authorizationLimitType", "W");
        mapdataByValue.put("authorizationStatus", "A");
        mapdataByValue.put("authorizationLimit", "10");
        mapdataByValue.put("authorizationWeekStart", CommonMethods.AuthWeekStartType());
        mapdataByValue.put("authorizationLimitDayOfWeek", CommonMethods.AuthWeekStartType());
        mapdataByValue.put("authorizationLimitStartTime", "1000");
        mapdataByValue.put("authorizationLimitEndTime", "1200");
        mapdataByValue.put("clientDiagnosisCodeIsPrimary", "N");
        mapdataByValue.put("clientDiagnosisCode", CommonMethods.generateEmailAddress_alpha(1) + CommonMethods.generateRandomNumberOfFixLength(2) + "." + CommonMethods.generateEmailAddress_alpha(1));
        mapdataByValue.put("clientDiagnosisCodeBeginDate", CommonMethods.generatePastDate_YYYY_MM_dd());
        mapdataByValue.put("clientDiagnosisCodeEndDate", CommonMethods.generateTodayDate_YYYY_MM_dd());

        return mapdataByValue;

    }

    // ************** Unique Generator for Employee *********************************//

    @SuppressWarnings("unchecked")
    public JSONArray EmpParams_OpenEVV(String jsonnameemp) throws InterruptedException, java.text.ParseException, IOException, ParseException {

        JSONArray j = CommonMethods.LoadJSON_OpenEVV(jsonnameemp);

        JSONObject js = (JSONObject) j.get(0);
        js.put(Account, stateInfo.get(ACCID));

        js.put("EmployeePIN", DataGeneratorEmployee.generateEmpPIN(9));

        js.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(5));

        js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(5));

        js.put("EmployeePhone", CommonMethods.generateRandomNumberOfFixLength(10));

        js.put("EmployeeAltPhone", CommonMethods.generateRandomNumberOfFixLength(10));

        js.put("EmployeeAltPhone2", CommonMethods.generateRandomNumberOfFixLength(10));

        js.put("EmployeeEmailAddress", DataGeneratorEmployee.generateEmpEmail(8));

        if (state.equalsIgnoreCase("PA")) {
            js.put("EmployeeIdentifier", CommonMethods.generateRandomAlphaNumeric(6));
        }

        if (state.equalsIgnoreCase("Vermont")) {
            js.put("EmployeeID", "D" + CommonMethods.generateRandomNumberOfFixLength(6));

        } else {
            js.put("EmployeeID", CommonMethods.generateRandomNumberOfFixLength(5));
        }

        if (!state.equalsIgnoreCase("Connecticut")) {
            js.put("EmployeeHireDate", "2018-01-01");
            js.put("EmployeeEndDate", "2020-01-01");
            js.put("EmployeeBirthDate", "1990-01-01");
        }
        return j;

    }

    @SuppressWarnings("unchecked")
    public JSONArray EmpParams_Ohio_V1(String jsonnameemp) throws InterruptedException, IOException, ParseException {
        JSONArray j = CommonMethods.LoadJSON_ThreeP(jsonnameemp);

        String businessEntityMedicaidIdentifier = stateInfo.get(ProviderID);
        String businessEntityID = stateInfo.get(ACCID);

        JSONObject js = (JSONObject) j.get(0);

        js.put("BusinessEntityID", businessEntityID);
        js.put("BusinessEntityMedicaidIdentifier", businessEntityMedicaidIdentifier);

        js.put("StaffOtherID", CommonMethods.generateUniqueID());

        js.put("SequenceID", CommonMethods.generateUniqueID());

        js.put("StaffID", CommonMethods.generateRandomNumberOfFixLength(9));

        js.put("StaffSSN", CommonMethods.generateRandomNumberOfFixLength(9));

        js.put("StaffLastName", "Auto" + CommonMethods.generateRandomStringOfFixLength(20));

        js.put("StaffFirstName", "Auto" + CommonMethods.generateRandomStringOfFixLength(20));

        js.put("StaffEmail", DataGeneratorEmployee.generateEmpEmail(10));

        js.put("StaffPosition", DataGeneratorEmployee.generateStaffPosition());

        return j;

    }

    public JSONArray EmpParams_AltEVV(String jsonNameEmp) throws IOException, ParseException {
        JSONArray jsonArray = loadAltEVVEmployee(jsonNameEmp);
        switch (state) {
            case "PA":
                return EmpParams_AltEVV_PA(jsonArray);
            case "Colorado":
                return EmpParams_AltEVV_Colorado(jsonArray);
            case "Vermont":
                return EmpParams_AltEVV_Vermont(jsonArray);
            case "RI":
                return EmpParams_AltEVV_RhodeIsland(jsonArray);
            default:
                return jsonArray;
        }
    }

    private JSONArray loadAltEVVEmployee(String jsonName) throws IOException, ParseException {

        JSONArray j = CommonMethods.LoadJSON_AltEVV(jsonName);

        JSONObject js = (JSONObject) j.get(0);

        JSONObject jsonProvider = (JSONObject) js.get(globalVariables.ProviderIdentification);
        jsonProvider.put(ProviderID, stateInfo.get(ProviderID));
        jsonProvider.put(ProviderQualifier, stateInfo.get(ProviderQualifier));


        String empssn = CommonMethods.generateRandomNumberOfFixLength(9);

        js.put("EmployeeFirstName", "Auto" + CommonMethods.generateRandomStringOfFixLength(5));

        js.put("EmployeeLastName", "Auto" + CommonMethods.generateRandomStringOfFixLength(5));

        js.put("SequenceID", CommonMethods.generateUniqueID());

        js.put("EmployeeSSN", empssn);

        js.put("EmployeeEmail", DataGeneratorEmployee.generateEmpEmail(8));

        js.put("EmployeeIdentifier", empssn);

        return j;

    }

    public JSONArray EmpParams_AltEVV_PA(JSONArray jsonArray) throws IOException, ParseException {
        JSONObject js = (JSONObject) jsonArray.get(0);
        String empSSN = "0000" + CommonMethods.generateRandomNumberOfFixLength(5);
        js.put(EmployeeQualifier, EmployeeCustomID);
        js.put(EmployeeSSN, empSSN);
        String empCus1 = CommonMethods.generateRandomAlphaNumeric(6);
        js.put(EmployeeIdentifier, empCus1);

        return jsonArray;
    }

    public JSONArray EmpParams_AltEVV_Vermont(JSONArray jsonArray) throws IOException, ParseException {
        JSONObject js = (JSONObject) jsonArray.get(0);
        js.put(EmployeeQualifier, EmployeeCustomID);

        return jsonArray;
    }

    public JSONArray EmpParams_AltEVV_RhodeIsland(JSONArray jsonArray) {
        JSONObject js = (JSONObject) jsonArray.get(0);
        js.put(EmployeeQualifier, EmployeeSSN);

        return jsonArray;
    }

    public JSONArray UpdateEmpIdentifier(JSONArray jsonArray, String employeeIdentifier) throws ParseException {
        switch (state) {
            case "Colorado":
                return UpdateEmpIdentifier_Colorado(jsonArray.toJSONString(), employeeIdentifier);
            default:
                return jsonArray;
        }
    }

    public JSONArray UpdateEmpIdentifier_Colorado(String jsonnameemp, String employeeSSN) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONArray j = (JSONArray) parser.parse(jsonnameemp);
        JSONObject js = (JSONObject) j.get(0);
        String lastName = js.get(EmployeeLastName).toString();
        if (employeeSSN != null && !employeeSSN.isEmpty())
            js.put(EmployeeIdentifier, employeeSSN.substring(4) + lastName);
        return j;
    }

    private JSONArray EmpParams_AltEVV_Colorado(JSONArray jsonArray) {
        JSONObject js = (JSONObject) jsonArray.get(0);

        String empSSN = "0000" + CommonMethods.generateRandomNumberOfFixLength(5);
        js.put(EmployeeQualifier, EmployeeCustomID);
        js.put(EmployeeSSN, empSSN);
        js.put(EmployeeLastName, CommonMethods.generateRandomStringOfFixLength(4));
        String lastName = js.get(EmployeeLastName).toString();
        js.put(EmployeeIdentifier, empSSN.substring(4) + lastName);

        return jsonArray;
    }

    @SuppressWarnings("unchecked")
    public JSONArray EmpParams_AltEVV_molina(String jsonnameemp) throws IOException, ParseException {

        JSONArray j = CommonMethods.LoadJSON_AltEVV_Molina(jsonnameemp);

        JSONObject js = (JSONObject) j.get(0);

        JSONObject jsonProvider = (JSONObject) js.get(globalVariables.ProviderIdentification);
        jsonProvider.put(ProviderID, stateInfo.get(ProviderID));
        jsonProvider.put(ProviderQualifier, stateInfo.get(ProviderQualifier));

        String empssn = CommonMethods.generateRandomNumberOfFixLength(9);

        js.put("EmployeeFirstName", "Auto" + CommonMethods.generateRandomStringOfFixLength(10));

        js.put("EmployeeLastName", "Auto" + CommonMethods.generateRandomStringOfFixLength(10));

        js.put("SequenceID", CommonMethods.generateUniqueID());

        js.put("EmployeeSSN", empssn);

        js.put("EmployeeEmail", DataGeneratorEmployee.generateEmpEmail(8));

        js.put("EmployeeIdentifier", empssn);

        return j;

    }

    @SuppressWarnings("unchecked")
    public JSONObject updateJsonWithPrimaryFieldsEmployee(JSONArray jsonArray, HashMap<String, String> nonPrimaryField) {

        JSONObject jsobject = (JSONObject) jsonArray.get(0);
        primaryField = new String[]{"EmployeeFirstName", "EmployeeLastName", "EmployeeSSN", "ProviderID", "EmployeeEmail"};
        Iterator<String> keyset = nonPrimaryField.keySet().iterator();
        ArrayList<String> primaryList = new ArrayList<String>(Arrays.asList(primaryField));
        while (keyset.hasNext()) {
            primaryList.add(keyset.next());

        }

        for (int i = 0; i < primaryList.size(); i++) {
            switch (primaryList.get(i)) {
                case "EmployeeFirstName":
                    jsobject.put(primaryList.get(i), "Auto" + CommonMethods.generateRandomStringOfFixLength(5));
                    break;
                case "EmployeeLastName":
                    jsobject.put(primaryList.get(i), "Auto" + CommonMethods.generateRandomStringOfFixLength(5));
                    break;
                case "EmployeeSSN":
                    jsobject.put(primaryList.get(i), CommonMethods.generateRandomNumberOfFixLength(9));
                    break;
                case "ProviderID":
                    jsobject.put(primaryList.get(i), CommonMethods.generateRandomNumberOfFixLength(5));
                    break;
                case "EmployeeEmail":
                    jsobject.put(primaryList.get(i), DataGeneratorEmployee.generateEmpEmail(14));
                    break;
                default:
                    jsobject.put(primaryList.get(i), nonPrimaryField.get(primaryList.get(i)));
            }

        }
        return jsobject;

    }

    // ************** Unique Generator for Xref  *********************************//

    @SuppressWarnings("unchecked")
    public JSONArray XrefParams(String jsonnamexref) throws IOException, ParseException {


        logger.log(LogStatus.INFO, "Generating clientid to have existing value in Xref json");

        Map<String, String> client = getRandomClient(Constant_SQL.OpenEvvClientSql);
        Map<String, String> employee = getRandomEmployee(Constant_SQL.random_Worker_AltEVVGeneric);

        logger.log(LogStatus.INFO, "placing EmployeePin and clientID value in Xref json");

        JSONArray j = CommonMethods.LoadJSON_OpenEVV(jsonnamexref);

        JSONObject js = (JSONObject) j.get(0);

        js.put(Account, stateInfo.get(ACCID));
        js.put(EmployeePIN, employee.get("EMPLOYEEIDENTIFIER"));
        js.put(ClientID, client.get("CLIENTID"));

        return j;
    }

    // ************** Unique Generator for Visit *********************************//

    @SuppressWarnings({"unchecked", "unused"})
    public JSONArray VisitParam_3P() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException {

        JSONArray jsonArrayClient = ClientParams_3P(globalVariables.ThreeP_patientJson);
        JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);
        String bodyAsStringClient = CommonMethods.captureResponseOhio_v1(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v1));


        JSONArray jsonArrayEmp = EmpParams_Ohio_V1(globalVariables.ThreeP_Staff_Json);
        JSONObject jsonObjectEmp = (JSONObject) jsonArrayEmp.get(0);
        String bodyAsStringEmp = CommonMethods.captureResponseOhio_v1(jsonArrayEmp, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));

        JSONArray jsonArrayVisit = CommonMethods.LoadVisitJSON_3P(globalVariables.ThreeP_visit_Json);

        Map<String, String> DbMap;

        DbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount, CommonMethods.propertyfileReader(globalVariables.ohio_accid)));

        System.out.println(DbMap.get("PROVIDER_ID"));
        System.out.println(DbMap.get("ACCOUNT"));

        String BusinessEntityMedicaidIdentifier = DbMap.get("PROVIDER_ID");
        String BusinessEntityID = DbMap.get("ACCOUNT");

        JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

        jsonObjectVisit.put("BusinessEntityID", BusinessEntityID);
        jsonObjectVisit.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
        jsonObjectVisit.put("PatientMedicaidID", jsonObjectClient.get("PatientMedicaidID").toString());
        jsonObjectVisit.put("PatientOtherID", jsonObjectClient.get("PatientOtherID").toString());
        jsonObjectVisit.put("StaffOtherID", jsonObjectEmp.get("StaffOtherID").toString());

        String sequenceid = CommonMethods.generateRandomNumberOfFixLength(9);
        jsonObjectVisit.put("SequenceID", sequenceid);
        jsonObjectVisit.put("VisitOtherID", CommonMethods.generateRandomNumberOfFixLength(8));


        ////////////putting value in Visit subarray detail from alt EVV visitjson//////////////

        JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
        JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);

        jsonObjectVisitChanges.put("SequenceID", sequenceid);

        return jsonArrayVisit;
    }

    @SuppressWarnings({"unchecked"})
    public JSONArray VisitParam_3P_same(String jsonnamevisit, String PatientMid, String StaffOid, String PatientOid) throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException {


        JSONArray jsonArrayVisit = CommonMethods.LoadVisitJSON_3P(globalVariables.ThreeP_visit_Json);

        Map<String, String> DbMap = new HashMap<String, String>();

        DbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount, CommonMethods.propertyfileReader(globalVariables.ohio_accid)));

        System.out.println(DbMap.get("PROVIDER_ID"));
        System.out.println(DbMap.get("ACCOUNT"));

        String BusinessEntityMedicaidIdentifier = DbMap.get("PROVIDER_ID");
        String BusinessEntityID = DbMap.get("ACCOUNT");

        JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

        jsonObjectVisit.put("BusinessEntityID", BusinessEntityID);
        jsonObjectVisit.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
        jsonObjectVisit.put("PatientMedicaidID", PatientMid);
        jsonObjectVisit.put("PatientOtherID", PatientOid);
        jsonObjectVisit.put("StaffOtherID", StaffOid);

        String sequenceid = CommonMethods.generateRandomNumberOfFixLength(9);
        jsonObjectVisit.put("SequenceID", sequenceid);
        jsonObjectVisit.put("VisitOtherID", CommonMethods.generateRandomNumberOfFixLength(8));


        ////////////putting value in Visit subarray detail from alt EVV visitjson//////////////

        JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
        JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);

        jsonObjectVisitChanges.put("SequenceID", sequenceid);

        return jsonArrayVisit;
    }

    @SuppressWarnings({"unchecked"})
    private void addClientEmployeeToVisitByState(JSONArray jsonArrayVisit) {
        Map<String, String> client;
        Map<String, String> employee;
        for (Object o : jsonArrayVisit) {
            JSONObject jsonObjectVisit = (JSONObject) o;
            switch (state) {
                case "Vermont":
                    client = getRandomClient(Constant_SQL.random_ClientAltEVVGenericSql);
                    employee = getRandomEmployee(Constant_SQL.random_Worker_AltEVVGeneric);
                    jsonObjectVisit.put(ClientID, client.get("PATIENTOTHERID"));
                    jsonObjectVisit.put(EmployeeIdentifier, employee.get("STAFFOTHERID"));
                    jsonObjectVisit.put(EmployeeQualifier, EmployeeCustomID);
                    jsonObjectVisit.put(ClientIDQualifier, ClientCustomID);
                    break;

                case "PA":
                    client = getRandomClient(Constant_SQL.random_ClientAltEVVGenericSql);
                    employee = getRandomEmployee(Constant_SQL.random_Worker_AltEVVGeneric_PA);
                    jsonObjectVisit.put(EmployeeQualifier, EmployeeCustomID);
                    jsonObjectVisit.put(ClientIDQualifier, ClientCustomID);

                    jsonObjectVisit.put(ClientID, client.get("PATIENTOTHERID"));
                    jsonObjectVisit.put(EmployeeIdentifier, employee.get("CUSTOM1"));

                    JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
                    JSONObject jsonObjectVisitCallIn = (JSONObject) jsonArrayVisitCalls.get(0);
                    jsonObjectVisitCallIn.put(CallTypejson, "Other");
                    JSONObject jsonObjectVisitCallOut = (JSONObject) jsonArrayVisitCalls.get(1);
                    jsonObjectVisitCallOut.put(CallTypejson, "Other");
                    JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get(VisitChanges);
                    JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);
                    jsonObjectVisitChanges.put(ReasonCodejson, "70");
                    break;

                case "Colorado":
                    client = getRandomClient(Constant_SQL.random_ClientAltEVVGenericSql_Colorado);
                    employee = getRandomEmployee(Constant_SQL.random_Worker_AltEVVGeneric);
                    jsonObjectVisit.put(EmployeeQualifier, EmployeeCustomID);
                    jsonObjectVisit.put(ClientIDQualifier, ClientOtherID);
                    jsonObjectVisit.put(ClientID, client.get("CLIENT_ID_CUSTOM2"));
                    jsonObjectVisit.put(EmployeeIdentifier, employee.get("EMPLOYEEIDENTIFIER"));
                    jsonObjectVisit.put(VisitTimeZonejson, "US/Mountain");
                    break;
                case "Connecticut":
                    client = getRandomClient(Constant_SQL.random_ClientAltEVVGenericSql);
                    employee = getRandomEmployee(Constant_SQL.random_Worker_AltEVVGeneric);
                    jsonObjectVisit.put(ClientID, client.get("CLIENTID"));
                    jsonObjectVisit.put(EmployeeIdentifier, employee.get("EMPLOYEEIDENTIFIER"));
                    jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
                    jsonObjectVisitCallIn = (JSONObject) jsonArrayVisitCalls.get(0);
                    jsonObjectVisitCallIn.put(CallTypejson, "Other");
                    jsonObjectVisitCallOut = (JSONObject) jsonArrayVisitCalls.get(1);
                    jsonObjectVisitCallOut.put(CallTypejson, "Other");
                    break;

                default:
                    client = getRandomClient(Constant_SQL.random_ClientAltEVVGenericSql);
                    employee = getRandomEmployee(Constant_SQL.random_Worker_AltEVVGeneric);

                    jsonObjectVisit.put(EmployeeQualifier, EmployeeRegID);
                    jsonObjectVisit.put(ClientIDQualifier, ClientMedicaidID);
                    jsonObjectVisit.put(ClientID, client.get("PATIENTMEDICAIDID"));
                    jsonObjectVisit.put(EmployeeIdentifier, employee.get("EMPLOYEEIDENTIFIER"));
                    jsonObjectVisit.put(ReasonCodejson, "01");

                    jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
                    jsonObjectVisitCallIn = (JSONObject) jsonArrayVisitCalls.get(0);
                    jsonObjectVisitCallIn.put(CallTypejson, "OTHER");
                    jsonObjectVisitCallOut = (JSONObject) jsonArrayVisitCalls.get(1);
                    jsonObjectVisitCallOut.put(CallTypejson, "OTHER");
                    break;
            }
        }
    }

    public JSONArray VisitParams_AltEVV() throws IOException, ParseException {
        JSONArray jsonArrayVisit = CommonMethods.LoadJSON_AltEVV(globalVariables.visit_intake);
        loadAltEVV_VisitGeneric(jsonArrayVisit);
        addClientEmployeeToVisitByState(jsonArrayVisit);

        return jsonArrayVisit;
    }

    @SuppressWarnings({"unchecked"})
    public JSONArray multiVisitParams_AltEVV(int count) throws IOException, ParseException {
        JSONArray jsonArrayVisit = new JSONArray();
        for (int i = 0; i < count; i++) {
            JSONArray jsonArrayVisit1 = CommonMethods.LoadJSON_AltEVV(globalVariables.visit_intake);
            jsonArrayVisit.add(jsonArrayVisit1.get(0));
        }
        loadAltEVV_VisitGeneric(jsonArrayVisit);
        addClientEmployeeToVisitByState(jsonArrayVisit);

        return jsonArrayVisit;
    }

    @SuppressWarnings({"unchecked"})
    public JSONArray visitParams_AltEVV_WithNewClientAndEmployee() throws InterruptedException, IOException, ParseException {
        ////////////Generating Unique Client detail from  alt EVV client json//////////////
        JSONArray jsonArrayClient = ClientParams_AltEVV(globalVariables.client_intake);
        JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);
        CommonMethods.validateResponse(jsonArrayClient,
                CommonMethods.propertyfileReader(globalVariables.altevv_clients));

        Thread.sleep(30000);

        ////////////Generating Unique Employee detail from alt EVV employee json//////////////

        JSONArray jsonArrayEmp = EmpParams_AltEVV(globalVariables.Staff_intake);
        JSONObject jsonObjectEmp = (JSONObject) jsonArrayEmp.get(0);
        CommonMethods.validateResponse(jsonArrayEmp,
                CommonMethods.propertyfileReader(globalVariables.altevv_emp));

        Thread.sleep(30000);

        ////////////Generating Unique visit detail from alt EVV visitjson//////////////

        JSONArray jsonArrayVisit = CommonMethods.LoadVisitJSON(globalVariables.visit_intake);
        loadAltEVV_VisitGeneric(jsonArrayVisit);

        JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

        jsonObjectVisit.put("ClientID", jsonObjectClient.get("ClientID"));
        jsonObjectVisit.put("EmployeeIdentifier", jsonObjectEmp.get("EmployeeIdentifier"));

        return jsonArrayVisit;
    }

    @SuppressWarnings({"unchecked", "unused"})

    public JSONArray Scheduling_Openevv() throws IOException, ParseException {
        Map<String, String> client = getRandomClient(Constant_SQL.OpenEvvClientSql);
        Map<String, String> employee = getRandomEmployee(Constant_SQL.random_Worker_AltEVVGeneric);

        JSONArray jsonArrayschedule = CommonMethods.Schedule_OpenEVV("Schedule");

        String sequenceId = CommonMethods.generateUniqueID();

        JSONObject jsonObjectSchedule = (JSONObject) jsonArrayschedule.get(0);
        jsonObjectSchedule.put(Account, stateInfo.get(ACCID));

        jsonObjectSchedule.put("ClientIDQualifier", "ClientID");

        jsonObjectSchedule.put("ClientID", client.get("CLIENTID"));
        jsonObjectSchedule.put("EmployeePIN", employee.get("EMPLOYEEIDENTIFIER"));
        jsonObjectSchedule.put("ProcedureCode", stateInfo.get(ProcedureCode));
        jsonObjectSchedule.put("Service", stateInfo.get(ProcedureCode));
        jsonObjectSchedule.put(PayerProgram, stateInfo.get(PayerProgram));
        jsonObjectSchedule.put("Contract", stateInfo.get(PayerID));
        jsonObjectSchedule.put("ScheduleID", sequenceId);
        jsonObjectSchedule.put("ARNumber", CommonMethods.generateRandomNumberOfFixLength(10));
        jsonObjectSchedule.put("ScheduleStartTime", CommonMethods.getPastTime(10));
        jsonObjectSchedule.put("ScheduleEndTime", CommonMethods.getPastTime(5));


        return jsonArrayschedule;
    }

    @SuppressWarnings("unchecked")
    public JSONArray VisitParams_AltEVV_Molina() throws IOException, ParseException {
        JSONArray jsonArrayVisit = CommonMethods.LoadJSON_AltEVV_Molina(globalVariables.visit_intake_Molina);
        loadAltEVV_VisitGeneric(jsonArrayVisit);
        addClientEmployeeToVisitMolina(jsonArrayVisit);

        return jsonArrayVisit;
    }

    @SuppressWarnings("unchecked")
    public JSONArray multiVisitParams_AltEVV_Molina(int count) throws IOException, ParseException {
        JSONArray jsonArrayVisit = new JSONArray();
        for (int i = 0; i < count; i++) {
            JSONArray jsonArrayVisit1 = CommonMethods.LoadJSON_AltEVV_Molina(globalVariables.visit_intake_Molina);
            jsonArrayVisit.add(jsonArrayVisit1.get(0));
        }
        loadAltEVV_VisitGeneric(jsonArrayVisit);
        addClientEmployeeToVisitMolina(jsonArrayVisit);

        return jsonArrayVisit;
    }

    @SuppressWarnings("unchecked")
    private void addClientEmployeeToVisitMolina(JSONArray jsonArrayVisit) {
        for (Object o : jsonArrayVisit) {
            Map<String, String> client = getRandomClient(Constant_SQL.random_ClientAltEVVMolina_Sql);
            Map<String, String> employee = getRandomEmployee(Constant_SQL.random_Worker_AltEVVGeneric);
            JSONObject jsonObjectVisit = (JSONObject) o;
            jsonObjectVisit.put(EmployeeIdentifier, employee.get("WORKER_SSN"));
            jsonObjectVisit.put(ClientIdentifier, client.get("PATIENTMEDICAIDID"));
        }
    }

    @SuppressWarnings("unchecked")
    public JSONArray Staff_Params_3p_v2(String jsonnameemp) throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException {

        JSONArray j = CommonMethods.LoadJSON_Ohio(jsonnameemp);

        Map<String, String> DbMap = new HashMap<String, String>();

        DbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount, CommonMethods.propertyfileReader(globalVariables.ohio_accid)));

        System.out.println(DbMap.get("PROVIDER_ID"));
        System.out.println(DbMap.get("ACCOUNT"));

        String BusinessEntityMedicaidIdentifier = DbMap.get("PROVIDER_ID");
        String BusinessEntityID = DbMap.get("ACCOUNT");
        JSONObject js = (JSONObject) j.get(0);

        js.put("BusinessEntityID", BusinessEntityID);
        js.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);

        js.put("StaffOtherID", DataGeneratorEmployee.generateEmpPIN(9));

        js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(10));

        js.put("StaffID", CommonMethods.generateRandomNumberOfFixLength(9));

        js.put("StaffSSN", CommonMethods.generateRandomNumberOfFixLength(9));

        js.put("StaffLastName", CommonMethods.generateRandomStringOfFixLength(5));

        js.put("StaffFirstName", CommonMethods.generateRandomStringOfFixLength(5));

        js.put("StaffEmail", DataGeneratorEmployee.generateEmpEmail(10));

        js.put("StaffPosition", DataGeneratorEmployee.generateStaffPosition());

        return j;

    }

    // ************** Unique value generator for Visit v2 *********************************//

    @SuppressWarnings({"unchecked", "unused"})
    public JSONArray VisitParam_v2(String jsonnamevisit) throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException {


        ////////////Generating Unique patient detail using  Ohio v2 json//////////////
        JSONArray jsonArrayClient = patient_Ohio("patientIntake_v2");
        JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

        String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
        String bodyAsStringGet = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
        ////////////Generating Unique Employee detail from Ohio v2 employee json//////////////

        JSONArray jsonArrayEmp = Staff_Params_3p_v2("worker_v2");
        JSONObject jsonObjectEmp = (JSONObject) jsonArrayEmp.get(0);
        String bodyAsStringEmp = CommonMethods.captureResponseOhio_v2(jsonArrayEmp, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
        String bodyAsStringEmpGet = CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringEmp, CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1));
        ////////////Generating Unique visit detail from ohio v2 visitjson//////////////
        JSONArray jsonArrayVisit = CommonMethods.LoadJSON_Ohio(globalVariables.Ohio_visit_v2_json);

        Map<String, String> DbMap = new HashMap<String, String>();

        DbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount, CommonMethods.propertyfileReader("ohio_AccId_v2")));

        System.out.println(DbMap.get("PROVIDER_ID"));
        System.out.println(DbMap.get("ACCOUNT"));

        String BusinessEntityMedicaidIdentifier = DbMap.get("PROVIDER_ID");
        String BusinessEntityID = DbMap.get("ACCOUNT");

        JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

        jsonObjectVisit.put("BusinessEntityID", BusinessEntityID);
        jsonObjectVisit.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
        jsonObjectVisit.put("PatientMedicaidID", jsonObjectClient.get("PatientMedicaidID").toString());
        jsonObjectVisit.put("PatientOtherID", jsonObjectClient.get("PatientOtherID").toString());
        jsonObjectVisit.put("StaffOtherID", jsonObjectEmp.get("StaffOtherID").toString());

        String sequenceid = CommonMethods.generateRandomNumberOfFixLength(9);
        jsonObjectVisit.put("SequenceID", sequenceid);
        jsonObjectVisit.put("VisitOtherID", CommonMethods.generateRandomNumberOfFixLength(8));


        ////////////putting value in Visit subarray detail from alt EVV visitjson//////////////

        JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
        JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);

        jsonObjectVisitChanges.put("SequenceID", sequenceid);

        return jsonArrayVisit;

    }


    // *********************unique value generator for claim**********************************//

    public JSONArray restClaim_Model1(String jsonnameemp) throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException {

        JSONArray j = CommonMethods.LoadJSON_ThreeP_Rest(jsonnameemp);

        return j;

    }

    @SuppressWarnings("unchecked")
    public JSONArray ohioclaim_Rest_fail() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {

        JSONArray jsonArrrest = restClaim_Model1("restclaim_v2");

        JSONObject claimobject = (JSONObject) jsonArrrest.get(0);
        JSONArray claimSubArray = (JSONArray) claimobject.get("EVV_Request");
        JSONObject claimSubobject = (JSONObject) claimSubArray.get(0);

        claimSubobject.put(globalVariables.businnesmedicaidid, "0010010");
        claimSubobject.put(globalVariables.RequestType, "Model1");
        claimSubobject.put(globalVariables.batchid, CommonMethods.generateRandomNumberOfFixLength(10));
        claimSubobject.put(globalVariables.transactionid, CommonMethods.generateRandomNumberOfFixLength(9));
        claimSubobject.put(globalVariables.payer, "ODM");
        claimSubobject.put(globalVariables.icnnumber, CommonMethods.generateRandomNumberOfFixLength(13));
        claimSubobject.put(globalVariables.dlnnumber, CommonMethods.generateRandomNumberOfFixLength(2));
        claimSubobject.put(globalVariables.ProviderQualifier, "MedicaidID");
        claimSubobject.put(globalVariables.ProviderID, "0010010");
        claimSubobject.put(globalVariables.PatientQualifier, "MedicaidID");
        claimSubobject.put(globalVariables.PatientID, "123456789012");
        claimSubobject.put(globalVariables.ServiceStartDate, "2019-03-06");
        claimSubobject.put(globalVariables.ServiceEndDate, "2019-03-06");
        claimSubobject.put(globalVariables.ProcedureCode, "G0299");
        claimSubobject.put(globalVariables.UnitsRule, "AddUnits");
        claimSubobject.put(globalVariables.dbModifier1, "HQ");
        claimSubobject.put(globalVariables.dbModifier2, "HQ");
        claimSubobject.put(globalVariables.dbModifier3, "HQ");
        claimSubobject.put(globalVariables.dbModifier4, "HQ");
        claimSubobject.put(globalVariables.Units, "4");
        claimSubobject.put(globalVariables.MatchingRule, "ExactMatch");


        return jsonArrrest;

    }

    //method added after parallel execution....................//

    @SuppressWarnings("unchecked")
    public Map<String, JSONObject> ohioclaim_Rest() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException {

        JSONArray jsonArr = VisitParam_3P();
        JSONObject jsonobject = (JSONObject) jsonArr.get(0);
        jsonobject.put(globalVariables.ProcedureCode, globalVariables.procedurecodeValue);
        JSONArray jsonArrayVisitCalls = (JSONArray) jsonobject.get("Calls");
        JSONObject jsonObjectVisitCallIn = (JSONObject) jsonArrayVisitCalls.get(0);

        jsonObjectVisitCallIn.put(globalVariables.CallDateTimejson, CommonMethods.generatecurrentDate_YYYY_MM_dd() + "T01:17:00Z");

        JSONObject jsonObjectVisitCallout = (JSONObject) jsonArrayVisitCalls.get(1);

        jsonObjectVisitCallout.put(globalVariables.CallDateTimejson, CommonMethods.generatecurrentDate_YYYY_MM_dd() + "T02:07:00Z");

        jsonobject.put(globalVariables.AdjInDateTime, CommonMethods.generatecurrentDate_YYYY_MM_dd() + "T01:17:00Z");

        jsonobject.put(globalVariables.AdjOutDateTime, CommonMethods.generatecurrentDate_YYYY_MM_dd() + "T02:07:00Z");

        String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader("ohio_visit_v1"));

        Thread.sleep(30000);

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader("ohio_visit_get_v1"));
        String provider = dataBaseVerifier.executeQueryString(String.format(Constant_SQL.stxprovider, CommonMethods.propertyfileReader(globalVariables.ohio_accid)));


        float getunit = Assertion_DbVerifier.jsonAssert_Hourstobill_AltEVV_Visit_claim(bodyAsStringget, jsonobject);
        System.out.println("GetUnit " + getunit);
        int units = Math.round(getunit);
        System.out.println("Units " + units);

        String status = dataBaseVerifier.executeQueryString(String.format(Constant_SQL.visitclaimStatus, dataBaseVerifier.executeQueryString(String.format(Constant_SQL.inboxvisitkey, jsonobject.get("VisitOtherID").toString()))));


        JSONArray calldatetimein = (JSONArray) jsonobject.get("Calls");
        JSONObject calldatein = (JSONObject) calldatetimein.get(0);
        String[] dateinCall = ((String) calldatein.get(globalVariables.CallDateTimejson)).split("T", 2);
        String Datein = dateinCall[0];
        JSONObject calldateout = (JSONObject) calldatetimein.get(1);
        String[] dateinOut = ((String) calldateout.get(globalVariables.CallDateTimejson)).split("T", 2);
        String Dateout = dateinOut[0];


        JSONArray jsonArrrest = restClaim_Model1("restclaim_v2");

        JSONObject claimbobject = (JSONObject) jsonArrrest.get(0);

        JSONArray claimSubArray = (JSONArray) claimbobject.get("EVV_Request");
        JSONObject claimSubobject = (JSONObject) claimSubArray.get(0);
        claimSubobject.put(globalVariables.businnesmedicaidid, jsonobject.get("BusinessEntityID").toString());
        claimSubobject.put(globalVariables.RequestType, "Model1");
        claimSubobject.put(globalVariables.batchid, CommonMethods.generateRandomNumberOfFixLength(10));
        claimSubobject.put(globalVariables.transactionid, CommonMethods.generateRandomNumberOfFixLength(9));
        claimSubobject.put(globalVariables.payer, "ODM");
        claimSubobject.put(globalVariables.icnnumber, CommonMethods.generateRandomNumberOfFixLength(13));
        claimSubobject.put(globalVariables.dlnnumber, CommonMethods.generateRandomNumberOfFixLength(2));
        claimSubobject.put(globalVariables.ProviderQualifier, "MedicaidID");
        claimSubobject.put(globalVariables.ProviderID, provider);
        claimSubobject.put(globalVariables.PatientQualifier, "MedicaidID");
        claimSubobject.put(globalVariables.PatientID, jsonobject.get("PatientMedicaidID").toString());
        claimSubobject.put(globalVariables.ServiceStartDate, Datein);
        claimSubobject.put(globalVariables.ServiceEndDate, Dateout);
        claimSubobject.put(globalVariables.ProcedureCode, jsonobject.get("ProcedureCode").toString());
        claimSubobject.put(globalVariables.UnitsRule, "AddUnits");
        claimSubobject.put(globalVariables.dbModifier1, null);
        claimSubobject.put(globalVariables.dbModifier2, null);
        claimSubobject.put(globalVariables.dbModifier3, null);
        claimSubobject.put(globalVariables.dbModifier4, null);
        claimSubobject.put(globalVariables.Units, units);
        claimSubobject.put(globalVariables.MatchingRule, "ExcludeUnits");
        Map<String, JSONObject> returnObject = new HashMap<String, JSONObject>();


        returnObject.put("visit", jsonobject);
        returnObject.put("rest", claimbobject);

        return returnObject;


    }

    @SuppressWarnings("unchecked")
    public Map<String, JSONObject> ohioclaim_Rest_with_changes(String Procedure) throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException {

        JSONArray jsonArr = VisitParam_3P();

        JSONObject jsonobject = (JSONObject) jsonArr.get(0);
        jsonobject.put(globalVariables.ProcedureCode, Procedure);
        JSONArray jsonArrayVisitCalls = (JSONArray) jsonobject.get("Calls");
        JSONObject jsonObjectVisitCallIn = (JSONObject) jsonArrayVisitCalls.get(0);

        jsonObjectVisitCallIn.put(globalVariables.CallDateTimejson, CommonMethods.generatePastDate_YYYY_MM_dd_1day() + "T10:47:00Z");

        JSONObject jsonObjectVisitCallout = (JSONObject) jsonArrayVisitCalls.get(1);

        jsonObjectVisitCallout.put(globalVariables.CallDateTimejson, CommonMethods.generateTodayDate_YYYY_MM_dd() + "T01:07:00Z");

        jsonobject.put(globalVariables.AdjInDateTime, CommonMethods.generatePastDate_YYYY_MM_dd_1day() + "T10:30:00Z");

        jsonobject.put(globalVariables.AdjOutDateTime, CommonMethods.generateTodayDate_YYYY_MM_dd() + "T01:12:00Z");

        String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader("ohio_visit_v1"));

        Thread.sleep(2000);

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader("ohio_visit_get_v1"));
        String provider = dataBaseVerifier.executeQueryString(String.format(Constant_SQL.stxprovider, CommonMethods.propertyfileReader(globalVariables.ohio_accid)));


        float getunit = Assertion_DbVerifier.jsonAssert_Hourstobill_AltEVV_Visit_claim(bodyAsStringget, jsonobject);

        String status = dataBaseVerifier.executeQueryString(String.format(Constant_SQL.visitclaimStatus, dataBaseVerifier.executeQueryString(String.format(Constant_SQL.inboxvisitkey, jsonobject.get("VisitOtherID").toString()))));


        JSONArray calldatetimein = (JSONArray) jsonobject.get("Calls");
        JSONObject calldatein = (JSONObject) calldatetimein.get(0);
        String[] dateinCall = ((String) calldatein.get(globalVariables.CallDateTimejson)).split("T", 2);
        String Datein = dateinCall[0];
        JSONObject calldateout = (JSONObject) calldatetimein.get(1);
        String[] dateinOut = ((String) calldateout.get(globalVariables.CallDateTimejson)).split("T", 2);
        String Dateout = dateinOut[0];


        JSONArray jsonArrrest = restClaim_Model1("restclaim_v2");

        JSONObject claimbobject = (JSONObject) jsonArrrest.get(0);

        JSONArray claimSubArray = (JSONArray) claimbobject.get("EVV_Request");
        JSONObject claimSubobject = (JSONObject) claimSubArray.get(0);
        claimSubobject.put(globalVariables.businnesmedicaidid, jsonobject.get("BusinessEntityID").toString());
        claimSubobject.put(globalVariables.RequestType, "Model1");
        claimSubobject.put(globalVariables.batchid, CommonMethods.generateRandomNumberOfFixLength(10));
        claimSubobject.put(globalVariables.transactionid, CommonMethods.generateRandomNumberOfFixLength(9));
        claimSubobject.put(globalVariables.payer, "ODM");
        claimSubobject.put(globalVariables.icnnumber, CommonMethods.generateRandomNumberOfFixLength(13));
        claimSubobject.put(globalVariables.dlnnumber, CommonMethods.generateRandomNumberOfFixLength(2));
        claimSubobject.put(globalVariables.ProviderQualifier, "MedicaidID");
        claimSubobject.put(globalVariables.ProviderID, provider);
        claimSubobject.put(globalVariables.PatientQualifier, "MedicaidID");
        claimSubobject.put(globalVariables.PatientID, jsonobject.get("PatientMedicaidID").toString());
        claimSubobject.put(globalVariables.ServiceStartDate, Datein);
        claimSubobject.put(globalVariables.ServiceEndDate, Dateout);
        claimSubobject.put(globalVariables.ProcedureCode, jsonobject.get("ProcedureCode").toString());
        claimSubobject.put(globalVariables.UnitsRule, "AddUnits");
        claimSubobject.put(globalVariables.dbModifier1, "HQ");
        claimSubobject.put(globalVariables.dbModifier2, "HQ");
        claimSubobject.put(globalVariables.dbModifier3, "HQ");
        claimSubobject.put(globalVariables.dbModifier4, "HQ");
        claimSubobject.put(globalVariables.Units, "5");
        claimSubobject.put(globalVariables.MatchingRule, "ExcludeUnits");
        Map<String, JSONObject> returnObject = new HashMap<String, JSONObject>();


        returnObject.put("visit", jsonobject);
        returnObject.put("rest", claimbobject);

        return returnObject;


    }

    @SuppressWarnings("unchecked")
    public Map<String, JSONObject> ohioclaim_Rest_multiple(String pateintm, String staff, String patientO) throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException {

        JSONArray jsonArr = VisitParam_3P_same(globalVariables.ThreeP_visit_Json, pateintm, staff, patientO);

        JSONObject jsonobject = (JSONObject) jsonArr.get(0);
        jsonobject.put(globalVariables.ProcedureCode, globalVariables.procedurecodeValue);
        JSONArray jsonArrayVisitCalls = (JSONArray) jsonobject.get("Calls");
        JSONObject jsonObjectVisitCallIn = (JSONObject) jsonArrayVisitCalls.get(0);

        jsonObjectVisitCallIn.put(globalVariables.CallDateTimejson, CommonMethods.generatePastDate_YYYY_MM_dd_1day() + "T11:47:00Z");

        JSONObject jsonObjectVisitCallout = (JSONObject) jsonArrayVisitCalls.get(1);

        jsonObjectVisitCallout.put(globalVariables.CallDateTimejson, CommonMethods.generateTodayDate_YYYY_MM_dd() + "T02:07:00Z");

        jsonobject.put(globalVariables.AdjInDateTime, CommonMethods.generatePastDate_YYYY_MM_dd_1day() + "T11:30:00Z");

        jsonobject.put(globalVariables.AdjOutDateTime, CommonMethods.generateTodayDate_YYYY_MM_dd() + "T02:12:00Z");

        String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader("ohio_visit_v1"));

        Thread.sleep(2000);

        String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader("ohio_visit_get_v1"));
        String provider = dataBaseVerifier.executeQueryString(String.format(Constant_SQL.stxprovider, CommonMethods.propertyfileReader(globalVariables.ohio_AccId_v1)));


        float getunit = Assertion_DbVerifier.jsonAssert_Hourstobill_AltEVV_Visit_claim(bodyAsStringget, jsonobject);

        String procedurecode = jsonobject.get("ProcedureCode").toString();
        String Petientmedicaid = jsonobject.get("PatientMedicaidID").toString();
        String BusinessEntityID = jsonobject.get("BusinessEntityID").toString();
        JSONArray calldatetimein = (JSONArray) jsonobject.get("Calls");
        JSONObject calldatein = (JSONObject) calldatetimein.get(0);


        // String vsistid= jsonobject.get("VisitOtherID").toString();

        //String status=dataBaseVerifier.executeQueryString(String.format(Constant_SQL.visitclaimStatus,dataBaseVerifier.executeQueryString(String.format(Constant_SQL.inboxvisitkey,vsistid))));

        String[] dateinCall = ((String) calldatein.get(globalVariables.CallDateTimejson)).split("T", 2);
        String Datein = dateinCall[0];


        JSONObject calldateout = (JSONObject) calldatetimein.get(1);

        String[] dateinOut = ((String) calldateout.get(globalVariables.CallDateTimejson)).split("T", 2);


        String Dateout = dateinOut[0];

        //String numberAsString = new Long(getunit).toString();


        JSONArray jsonArrrest = restClaim_Model1("restclaim_v2");

        JSONObject claimbobject = (JSONObject) jsonArrrest.get(0);

        JSONArray claimSubArray = (JSONArray) claimbobject.get("EVV_Request");
        JSONObject claimSubobject = (JSONObject) claimSubArray.get(0);
        claimSubobject.put(globalVariables.businnesmedicaidid, BusinessEntityID);
        claimSubobject.put(globalVariables.RequestType, "Model1");
        claimSubobject.put(globalVariables.batchid, CommonMethods.generateRandomNumberOfFixLength(10));
        claimSubobject.put(globalVariables.transactionid, CommonMethods.generateRandomNumberOfFixLength(9));
        claimSubobject.put(globalVariables.payer, "ODM");
        claimSubobject.put(globalVariables.icnnumber, CommonMethods.generateRandomNumberOfFixLength(13));
        claimSubobject.put(globalVariables.dlnnumber, CommonMethods.generateRandomNumberOfFixLength(2));
        claimSubobject.put(globalVariables.ProviderQualifier, "MedicaidID");
        claimSubobject.put(globalVariables.ProviderID, provider);
        claimSubobject.put(globalVariables.PatientQualifier, "MedicaidID");
        claimSubobject.put(globalVariables.PatientID, Petientmedicaid);
        claimSubobject.put(globalVariables.ServiceStartDate, Datein);
        claimSubobject.put(globalVariables.ServiceEndDate, Dateout);
        claimSubobject.put(globalVariables.ProcedureCode, procedurecode);
        claimSubobject.put(globalVariables.UnitsRule, "AddUnits");
        claimSubobject.put(globalVariables.dbModifier1, "HQ");
        claimSubobject.put(globalVariables.dbModifier2, "HQ");
        claimSubobject.put(globalVariables.dbModifier3, "HQ");
        claimSubobject.put(globalVariables.dbModifier4, "HQ");
        claimSubobject.put(globalVariables.Units, "5");
        claimSubobject.put(globalVariables.MatchingRule, "ExcludeUnits");
        Map<String, JSONObject> returnObject = new HashMap<String, JSONObject>();


        returnObject.put("visit", jsonobject);
        returnObject.put("rest", claimbobject);

        return returnObject;


    }

    private String getUniqueEmployeeSSN() {
        try {
            List<String> list = DataBaseVerifier.executeQueryToListString(String.format(Constant_SQL.stxEmployeeSSN,
                    CommonMethods.propertyfileReader(globalVariables.altevv_accId)));
            String empSSN = CommonMethods.generateRandomNumberOfFixLength(9);
            while (list.contains(empSSN)) {
                empSSN = CommonMethods.generateRandomNumberOfFixLength(9);
            }
            return empSSN;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, String> getRandomClient(String query) {
        Map<String, String> client = null;
        try {
            List<Map<String, String>> list = dataBaseVerifier.getDataMap(String.format(query, stateInfo.get(ACCID)));
            int randomIndex = new Random().nextInt(list.size());
            client = list.get(randomIndex);
            System.out.println(client);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (client == null) {
            Assert.fail("Could Found Client from Database");
        }
        return client;
    }

    public Map<String, String> getRandomEmployee(String query) {
        Map<String, String> employee = null;

        try {
            List<Map<String, String>> list = dataBaseVerifier.getDataMap(String.format(query, stateInfo.get(ACCID)));
            int randomIndex = new Random().nextInt(list.size());
            employee = list.get(randomIndex);
            System.out.println(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (employee == null) {
            Assert.fail("Could Found Employee from Database");
        }
        return employee;
    }

    public String getDiffClient(String clientID) {
        return getRandomClient(String.format(random_Client_AltEVVGeneric_Not_Contain, stateInfo.get(ACCID), clientID))
                .get("PATIENTOTHERID");
    }

    public String getDiffEmployee(String employeeID) {
        return getRandomClient(String.format(random_Worker_AltEVVGeneric_PA_Not_Contain, stateInfo.get(ACCID), employeeID))
                .get("STAFFOTHERID");
    }

    private void loadAltEVV_VisitGeneric(JSONArray jsonArray) {
        String sequenceId = CommonMethods.generateUniqueID();
        String visitOtherID = CommonMethods.generateRandomAlphaNumeric(50);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObjectVisit = (JSONObject) jsonArray.get(i);

            JSONObject jsonProvider = (JSONObject) jsonObjectVisit.get(globalVariables.ProviderIdentification);
            jsonProvider.put(ProviderID, stateInfo.get(ProviderID));
            jsonProvider.put(ProviderQualifier, stateInfo.get(ProviderQualifier));

            jsonObjectVisit.put(PayerID, stateInfo.get(PayerID));
            jsonObjectVisit.put(PayerProgram, stateInfo.get(PayerProgram));
            jsonObjectVisit.put(ProcedureCode, stateInfo.get(ProcedureCode));

            jsonObjectVisit.put(SequenceID, sequenceId);
            jsonObjectVisit.put(VisitOtherID, visitOtherID);

            JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
            JSONObject jsonObjectVisitCallIn = (JSONObject) jsonArrayVisitCalls.get(0);
            jsonObjectVisitCallIn.put(globalVariables.CallDateTimejson, CommonMethods.getPastTime(50));
            jsonObjectVisitCallIn.put(globalVariables.CallExternalIDjson, CommonMethods.generateRandomNumberOfFixLength(8));
            jsonObjectVisitCallIn.put(ProcedureCode, stateInfo.get(ProcedureCode));
            JSONObject jsonObjectVisitCallOut = (JSONObject) jsonArrayVisitCalls.get(1);
            jsonObjectVisitCallOut.put(globalVariables.CallDateTimejson, CommonMethods.getPastTime(20));
            jsonObjectVisitCallOut.put(globalVariables.CallExternalIDjson, CommonMethods.generateRandomNumberOfFixLength(8));
            jsonObjectVisitCallOut.put(ProcedureCode, stateInfo.get(ProcedureCode));
            jsonObjectVisit.put(ScheduleStartTime, CommonMethods.getPastTime(60));
            jsonObjectVisit.put(ScheduleEndTime, CommonMethods.getPastTime(40));

            ////////////putting value in Visit subarray detail from alt EVV visitjson//////////////

            JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get(VisitChanges);
            JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);
            jsonObjectVisitChanges.put(SequenceID, sequenceId);
            jsonObjectVisitChanges.put(ChangeDateTimejson, CommonMethods.getPastTime(5));
        }
    }


    public Map<String, JSONObject> ohioclaim_Rest_V2() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {


        JSONArray jsonArrrest = restClaim_Model1("restclaim_v2");

        JSONObject claimbobject = (JSONObject) jsonArrrest.get(0);

        JSONArray claimSubArray = (JSONArray) claimbobject.get("EVV_Request");
        JSONObject claimSubobject = (JSONObject) claimSubArray.get(0);
        claimSubobject.put(globalVariables.RequestType, "Model2");
        claimSubobject.put(globalVariables.batchid, CommonMethods.generateRandomNumberOfFixLength(10));
        claimSubobject.put(globalVariables.transactionid, CommonMethods.generateRandomNumberOfFixLength(9));
        claimSubobject.put(globalVariables.payer, "ODM");
        claimSubobject.put(globalVariables.icnnumber, CommonMethods.generateRandomNumberOfFixLength(13));
        claimSubobject.put(globalVariables.dlnnumber, CommonMethods.generateRandomNumberOfFixLength(2));
        claimSubobject.put(globalVariables.ProviderQualifier, "MedicaidID");
        claimSubobject.put(globalVariables.PatientQualifier, "MedicaidID");
        claimSubobject.put(globalVariables.UnitsRule, "AddUnits");
        claimSubobject.put(globalVariables.dbModifier1, null);
        claimSubobject.put(globalVariables.dbModifier2, null);
        claimSubobject.put(globalVariables.dbModifier3, null);
        claimSubobject.put(globalVariables.dbModifier4, null);
        Map<String, JSONObject> returnObject = new HashMap<String, JSONObject>();

        returnObject.put("rest", claimbobject);

        return returnObject;


    }
}





