package generic;

import com.sandata.entity.exportDWH.ClientMolinaModel;
import com.sandata.entity.exportDWH.ProviderIdentification;
import com.sandata.entity.ohio.exports.*;
import com.sandata.utilities.DbUtilsCon;
import com.sandata.ws.ClientWebService;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;

import static com.interop.sql.Sql.SQL_GET_CLIENT_ID_BY_NAME;
import static com.interop.sql.Sql.SQL_GET_CLIENT_KEY;
import static com.interop.sql.Sql.SQL_GET_CLIENT_PAYER_ID;

public class ClientGenericTest extends DWHGenericTest {

    public ClientWebService clientServices = new ClientWebService();

    /**
     * Author: @liem.chau
     * Execute a api create a client
     */
    public String CallCreateClientByApi()
    {
        String accountType = baseObj.readDataValue("AccountType");
        String providerId = baseObj.readDataValue("ProviderID");
        String providerQualifier = baseObj.readDataValue("ProviderQualifier");
        String clientFirstName = baseObj.readDataValue("ClientFirstName");
        String clientLastName = baseObj.readDataValue("ClientLastName");
        String clientQualifier = baseObj.readDataValue("ClientQualifier");
        String clientMedicaidID = baseObj.readDataValue("ClientMedicaidID");
        String clientIdentifier = baseObj.readDataValue("ClientIdentifier");
        String sequenceID = baseObj.readDataValue("SequenceID");

        ClientMolinaModel ClientMolinaModel = new ClientMolinaModel();
        ProviderIdentification providerIdentification = new ProviderIdentification();
        providerIdentification.setProviderID(providerId);
        providerIdentification.setProviderQualifier(providerQualifier);

        ClientMolinaModel.setClientFirstName(clientFirstName);
        ClientMolinaModel.setClientLastName(clientLastName);

        ClientMolinaModel.setProviderIdentification(providerIdentification);
        ClientMolinaModel.setClientQualifier(clientQualifier);

        ClientMolinaModel.setClientMedicaidID(clientMedicaidID);
        ClientMolinaModel.setClientIdentifier(clientIdentifier);
        ClientMolinaModel.setSequenceID(sequenceID);

        String username = baseObj.readDataValue("Username28005");
        String password = baseObj.readDataValue("Password28005");
        String account = baseObj.readDataValue("Account28005");

        return clientServices.callCreateClient(accountType, username,
                                            password, account,ClientMolinaModel,
                                            baseObj.getTestEnvironment());
    }

    /**
     * Author: @liem.chau
     * Execute a api create a client
     */
    public String generateRandomClientByApi(String clientFName, String clientLName, String clientOtherId)
    {
        String accountType = baseObj.readDataValue("AccountType");
        String providerId = baseObj.readDataValue("ProviderID");
        String providerQualifier = baseObj.readDataValue("ProviderQualifier");
        String clientQualifier = baseObj.readDataValue("ClientQualifier");
        String clientId = commons.generateRandomNumberOfFixLength(10);
        String clientMedicaidID = commons.generateRandomNumberOfFixLength(10);
        String clientIdentifier = commons.generateRandomNumberOfFixLength(9);
        String sequenceID = commons.generateRandomNumberOfFixLength(12);

        ClientMolinaModel clientMolinaWithConfigurationModel = new ClientMolinaModel();
        ProviderIdentification providerIdentification = new ProviderIdentification();
        providerIdentification.setProviderID(providerId);
        providerIdentification.setProviderQualifier(providerQualifier);

        clientMolinaWithConfigurationModel.setClientFirstName(clientFName);
        clientMolinaWithConfigurationModel.setClientLastName(clientLName);

        clientMolinaWithConfigurationModel.setProviderIdentification(providerIdentification);
        clientMolinaWithConfigurationModel.setClientQualifier(clientQualifier);

        clientMolinaWithConfigurationModel.setClientMedicaidID(clientMedicaidID);
        clientMolinaWithConfigurationModel.setClientIdentifier(clientIdentifier);
        clientMolinaWithConfigurationModel.setSequenceID(sequenceID);

        String username = baseObj.getEnvironment("Username28005");
        String password = baseObj.getEnvironment("Password28005");
        String account = baseObj.getEnvironment("Account28005");

        return clientServices.callCreateClient(accountType, username,
                password, account,clientMolinaWithConfigurationModel,
                baseObj.getTestEnvironment());
    }

    /**
     * Query to DB then get clientId by accountId & clientFirstName & clientLastName
     * @param accountId
     * @param clientFName
     * @param clientLName
     * @return {String} visitKey
     */
    public String getClientIdBy(String accountId, String clientFName, String clientLName) {
        String sql = String.format(SQL_GET_CLIENT_ID_BY_NAME, clientFName, clientLName, accountId);
        Object clientId = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("LOC");
        return String.valueOf(clientId);
    }

    public String getClientKeyBy(String clientId) {
        String sql = String.format(SQL_GET_CLIENT_KEY, clientId);
        Object payerId = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("CLIENTKEY");
        return String.valueOf(payerId);
    }

    public String getClientPayerIdBy(String clientKey) {
        String sql = String.format(SQL_GET_CLIENT_PAYER_ID, clientKey);
        Object payerId = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("CLIENTPAYERID");
        return String.valueOf(payerId);
    }

    public void verifyPatientTimeZone(String patientOtherID, String timezone)
    {
        List<Individual> patientList = jsonOhioExportEntities[0].getIndividual();

        Individual patient = patientList.stream().
                filter(Individual -> patientOtherID.equals(Individual.getPatientOtherID())).findFirst().orElse(null);

        logStepInfo(String.format("Patient.getPatientTimezone() = %s", patient.getPatientTimezone()));
        Assert.assertTrue( patient.getPatientTimezone().equals(timezone),
                String.format("Patient time zone should be ''%s",timezone));
    }

    public void verifyPatientZip(String patientOtherID,
                                  String expectedResult, String patientZipMaxLength){
        List<Individual> patientList = jsonOhioExportEntities[0].getIndividual();
        Individual patient = patientList.stream().
                filter(Individual -> patientOtherID.equals(Individual.getPatientOtherID())).findFirst().orElse(null);
        List<Address> addresses = patient.getAddress();
        Address foundPatientZip = addresses.stream().filter(Address -> expectedResult.equals(Address.getPatientZip())).findFirst().orElse(null);
        Assert.assertTrue( foundPatientZip != null, String.format("Patient Zip should be expected result"));

        Address foundPatientZipMaxLength = addresses.stream().filter(Address -> patientZipMaxLength.equals(Address.getPatientZip())).findFirst().orElse(null);
        Assert.assertTrue( foundPatientZipMaxLength != null, String.format("Patient Zip should be expected result for max length 9"));
    }

    public void verifyPatientCity(String patientOtherID,
                                          String expectedResult,
                                          String maxLengthPatientCity){
        List<Individual> patientList = jsonOhioExportEntities[0].getIndividual();
        Individual patient = patientList.stream().
                filter(Individual -> patientOtherID.equals(Individual.getPatientOtherID())).findFirst().orElse(null);
        List<Address> addresses = patient.getAddress();

        Address foundPatientCity = addresses.stream().filter(Address -> expectedResult.equals(Address.getPatientCity())).findFirst().orElse(null);
        Assert.assertTrue( foundPatientCity != null, String.format("Patient City should be expected result"));

        Address foundPatientCityMaxLength = addresses.stream().filter(Address -> maxLengthPatientCity.equals(Address.getPatientCity())).findFirst().orElse(null);
        Assert.assertTrue( foundPatientCityMaxLength != null, String.format("Patient City should be display with length 50"));

    }

    public void verifyPatientAddressLine1(String patientOtherID,
                                          String expectedResult,
                                          String maxLengthPatientAddressLine1){
        List<Individual> patientList = jsonOhioExportEntities[0].getIndividual();
        Individual patient = patientList.stream().
                filter(Individual -> patientOtherID.equals(Individual.getPatientOtherID())).findFirst().orElse(null);
        List<Address> addresses = patient.getAddress();

        Address addLine1 = addresses.stream().filter(Address -> expectedResult.equals(Address.getPatientAddressLine1())).findFirst().orElse(null);
        Assert.assertTrue( addLine1 != null, String.format("Patient Address line 1 should be expected result"));
        Address addLine1MaxLength = addresses.stream().filter(Address -> maxLengthPatientAddressLine1.equals(Address.getPatientAddressLine1())).findFirst().orElse(null);
        Assert.assertTrue( addLine1MaxLength != null, String.format("Patient Address line 1 should be expected result with max length"));

    }

    public void verifyTheGeneralSegmentPatientFields(String patientOtherID)
    {
        List<Individual> patientList = jsonOhioExportEntities[0].getIndividual();

        Individual patient = patientList.stream().
                filter(Individual -> patientOtherID.equals(Individual.getPatientOtherID())).findFirst().orElse(null);

        List<PatientPayerInformation> patientPayerInformations =  patient.getPatientPayerInformation();
        PatientPayerInformation  patientPayerInformation =  patientPayerInformations.get(0);
        Assert.assertTrue( patient.isPatientNewborn != null, "isPatientNewborn is not existed");
        Assert.assertTrue(patientPayerInformation.Payer != null, "Payer is not existed");
        Assert.assertTrue(patientPayerInformation.PayerProgram != null, "PayerProgram is not existed");
        Assert.assertTrue(patientPayerInformation.ProcedureCode != null, "ProcedureCode is not existed");
    }

    public void verifyPatientState(String patientOtherID, String state){
        List<Individual> patientList = jsonOhioExportEntities[0].getIndividual();
        Individual patient = patientList.stream().
                filter(Individual -> patientOtherID.equals(Individual.getPatientOtherID())).findFirst().orElse(null);
        List<Address> Address = patient.getAddress();
        Assert.assertTrue( Address.get(0).PatientState.equals(state), String.format("State should be '%s'", state));
    }

    public void verifyPatientMedicaidID(String patientOtherID, String patientMedicaidID){
        List<Individual> patientList = jsonOhioExportEntities[0].getIndividual();
        Individual patient = patientList.stream().
                filter(Individual -> patientOtherID.equals(Individual.getPatientOtherID())).findFirst().orElse(null);
        Assert.assertTrue( patient.getPatientMedicaidID().equals(patientMedicaidID), String.format("Medicaid should be '%s'", state));
    }

    public void verifyPatientPatientAlternateIDNotNull(String patientOtherID)
    {
        List<Individual> patientList = jsonOhioExportEntities[0].getIndividual();
        Individual patient = patientList.stream().
                filter(Individual -> patientOtherID.equals(Individual.getPatientOtherID())).findFirst().orElse(null);
        Assert.assertTrue( patient.getPatientAlternateID() != null, String.format("State should be '%s'", state));
    }

    public void verifyTheGeneralSegmentVisit(String visitMemo){
        List<Visit> visits = jsonOhioExportEntities[0].getVisits();
        Visit visit = visits.stream().
                filter(Visit -> visitMemo.equals(Visit.getVisitMemo())).findFirst().orElse(null);
        Assert.assertTrue(visit.getGroupVisitCode() != null, "GroupVisitCode is not exist");
        Assert.assertTrue(visit.getIsGroupVisitIndicator() == true || visit.getIsGroupVisitIndicator() == false, "GroupVisitIndicator is not exist");
        Assert.assertTrue(visit.getGroupVisitCode().length() <=6, "Max length is 6");
        Assert.assertTrue(isNumeric(visit.getGroupVisitCode()), "GroupVisitCode should is a digit");
    }

    public boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public void verifyResponseErrorMessage(Response r, String expectedErrorMessage){
        String status = r.getBody().jsonPath().get("status").toString();
        String errorMessage = r.getBody().jsonPath().get("data.ErrorMessage").toString().toLowerCase();
        Assert.assertEquals(status.toUpperCase(),"FAILED");
        Assert.assertTrue(errorMessage.contains(expectedErrorMessage.toLowerCase()),"Error message does not contain text : "+expectedErrorMessage);
    }

    public Individual filterIndividualInExportedFilesBy(String clientFName, String clientLName)
    {
        List<Individual> individualList = jsonOhioExportEntities[0].getIndividual();

        return individualList.stream().
                filter(patient -> clientFName.equals(patient.getPatientFirstName())).filter(patient -> clientLName.equals(patient.getPatientLastName())).findFirst().orElse(null);

    }

    public void verifyPatientAddressType(List<String> AddressTypes){
        List<Individual> individualList = jsonOhioExportEntities[0].getIndividual();
        individualList.forEach(i->{
            List<com.sandata.entity.ohio.exports.Address> addresses = i.getAddress();
            addresses.forEach(a->{
                Assert.assertTrue(AddressTypes.contains(a.getPatientAddressType()),String.format("PatientAddressType of %s does not match %s",a.getPatientID(),AddressTypes.toString()));
            });
        });
    }

    public void verifyPatientIdentifierOnCall(){
        List<com.sandata.entity.ohio.exports.Visit> visitList = jsonOhioExportEntities[0].getVisits();
        visitList.forEach(v->{
            List<com.sandata.entity.ohio.exports.Call> calls = v.getCalls();
            calls.forEach(c->{
                Assert.assertTrue(c.getPatientIdentifierOnCall().matches("^\\w{0,10}$"));
            });
        });
    }

    public void verifyPatientPayerInformation(){
        List<Individual> individualList = jsonOhioExportEntities[0].getIndividual();
        individualList.forEach(i->{
            List<PatientPayerInformation> patientPayerInformationList = i.getPatientPayerInformation();
            Assert.assertEquals(patientPayerInformationList.size(),1,"There is no PayerInformation on this Patient");
            patientPayerInformationList.forEach(p->{
                Assert.assertEquals("ODM",p.getPayer());
            });
        });
    }


}
