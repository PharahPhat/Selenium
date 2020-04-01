package com.ohio.intake.patient.v1;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.Constant_SQL;
import com.globalMethods.core.DataBaseVerifier;
import com.globalMethods.core.globalVariables;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;

import static com.globalMethods.core.globalVariables.ACCID;
import static io.restassured.RestAssured.given;

public class UniqueJsonGeneratorV1 extends BaseTest {

    DataBaseVerifier dataBaseVerifier = new DataBaseVerifier();
    Constant_SQL Constant_SQL = new Constant_SQL();

    @SuppressWarnings("unchecked")
    public JSONArray patient_Ohio(String jsonnameclient) throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException {

        JSONArray j = CommonMethods.LoadJSON_Ohio(jsonnameclient);

        JSONObject js = (JSONObject) j.get(0);
        js.put("BusinessEntityID", stateInfo.get(ACCID));
        js.put("BusinessEntityMedicaidIdentifier", stateInfo.get(globalVariables.ProviderID));
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

        JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
        JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
        jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
        jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));


        return j;
    }

    @SuppressWarnings("unchecked")
    public JSONArray patient_Ohio_RequiredFiledMissing(String jsonnameclient) throws IOException, ParseException {

        JSONArray j = CommonMethods.LoadJSON_Ohio(jsonnameclient);

        JSONObject js = (JSONObject) j.get(0);

        js.put("BusinessEntityID", stateInfo.get(ACCID));
        js.put("BusinessEntityMedicaidIdentifier", stateInfo.get(globalVariables.ProviderID));
        js.put("PatientOtherID", null);
        js.put("SequenceID", null);
        js.put("PatientMedicaidID", null);
        js.put("PatientLastName", null);
        js.put("PatientFirstName", null);


        JSONArray jsAdd = (JSONArray) js.get("Address");
        JSONObject jsObj = (JSONObject) jsAdd.get(0);
        jsObj.put("PatientAddressLine1", null);
        jsObj.put("PatientZip", null);
        jsObj.put("PatientState", null);
        jsObj.put("PatientCity", null);


        JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
        jsObj1.put("PatientAddressLine1", null);
        jsObj1.put("PatientZip", null);
        jsObj1.put("PatientState", null);
        jsObj1.put("PatientCity", null);


        JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
        JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
        jsonObjectClientContact.put("PatientResponsiblePartyLastName", null);
        jsonObjectClientContact.put("PatientResponsiblePartyFirstName", null);


        JSONArray jsonarrayPhone = (JSONArray) js.get("Phones");
        JSONObject jsonObjectPhone = (JSONObject) jsonarrayPhone.get(0);
        jsonObjectPhone.put("PatientPhoneType", null);
        jsonObjectPhone.put("PatientPhoneNumber", null);


        return j;
    }

    @SuppressWarnings("unchecked")
    public JSONArray patient_OhioFullPopulated(String jsonnameclient) throws IOException, ParseException {

        JSONArray j = CommonMethods.LoadJSON_Ohio(jsonnameclient);

        JSONObject js = (JSONObject) j.get(0);

        js.put("BusinessEntityID", stateInfo.get(ACCID));
        js.put("BusinessEntityMedicaidIdentifier", stateInfo.get(globalVariables.ProviderID));
        js.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(10));
        js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
        js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
        js.put("PatientFirstName", CommonMethods.generateRandomStringOfFixLength(10));

        JSONArray jsAdd = (JSONArray) js.get("Address");
        JSONObject jsObj = (JSONObject) jsAdd.get(0);
        jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
        jsObj.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

        JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
        jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
        jsObj1.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));


        JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
        JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
        jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
        jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));


        return j;
    }

    @SuppressWarnings("unchecked")
    public JSONArray patient_OhioV1Required(String jsonnameclient) throws IOException, ParseException {

        JSONArray j = CommonMethods.LoadJSON_Ohio(jsonnameclient);

        JSONObject js = (JSONObject) j.get(0);

        js.put("BusinessEntityID", stateInfo.get(ACCID));
        js.put("BusinessEntityMedicaidIdentifier", stateInfo.get(globalVariables.ProviderID));
        js.put("PatientOtherID", CommonMethods.generateUniqueID());
        js.put("SequenceID", CommonMethods.generateUniqueID());
        js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
        js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
        js.put("PatientFirstName", CommonMethods.generateRandomStringOfFixLength(10));

        JSONArray jsAdd = (JSONArray) js.get("Address");
        JSONObject jsObj = (JSONObject) jsAdd.get(0);
        jsObj.put("PatientAddressType", "Business");
        jsObj.put("PatientAddressIsPrimary", true);
        jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
        jsObj.put("PatientAddressLine2", CommonMethods.generateRandomStringOfFixLength(9));
        jsObj.put("PatientCity", CommonMethods.generateRandomStringOfFixLength(9));

        JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
        jsObj1.put("PatientAddressType", "Business");
        jsObj1.put("PatientAddressIsPrimary", true);
        jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
        jsObj1.put("PatientAddressLine2", CommonMethods.generateRandomStringOfFixLength(9));
        jsObj1.put("PatientCity", CommonMethods.generateRandomStringOfFixLength(9));


        JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
        JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
        jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
        jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));

        JSONArray jsonarrayclientPhone = (JSONArray) js.get("Phones");
        JSONObject jsonObjectClientPhone = (JSONObject) jsonarrayclientPhone.get(0);
        jsonObjectClientPhone.put("PatientPhoneType", "Home");
        jsonObjectClientPhone.put("PatientPhoneNumber", CommonMethods.generateRandomNumberOfFixLength(10));


        return j;
    }

    @SuppressWarnings("unchecked")
    public JSONArray patient_OhioV1maximumAllowedLength(String jsonnameclient) throws IOException, ParseException {

        String patientZip = CommonMethods.generateRandomNumberOfFixLength(9);

        JSONArray j = CommonMethods.LoadJSON_Ohio(jsonnameclient);

        JSONObject js = (JSONObject) j.get(0);

        js.put("BusinessEntityID", stateInfo.get(ACCID));
        js.put("BusinessEntityMedicaidIdentifier", stateInfo.get(globalVariables.ProviderID));
        js.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(64));
        js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(16));
        js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
        js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(30));
        js.put("PatientFirstName", CommonMethods.generateRandomStringOfFixLength(30));

        JSONArray jsAdd = (JSONArray) js.get("Address");
        JSONObject jsObj = (JSONObject) jsAdd.get(0);
        jsObj.put("PatientAddressType", "Business");
        jsObj.put("PatientAddressIsPrimary", true);
        jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(30));
        jsObj.put("PatientAddressLine2", CommonMethods.generateRandomStringOfFixLength(30));
        jsObj.put("PatientCity", CommonMethods.generateRandomStringOfFixLength(30));
        jsObj.put("PatientZip", patientZip);

        JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
        jsObj1.put("PatientAddressType", "Business");
        jsObj1.put("PatientAddressIsPrimary", true);
        jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(30));
        jsObj1.put("PatientAddressLine2", CommonMethods.generateRandomStringOfFixLength(30));
        jsObj1.put("PatientCity", CommonMethods.generateRandomStringOfFixLength(30));
        jsObj1.put("PatientZip", patientZip);


        JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
        JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
        jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(30));
        jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(30));

        JSONArray jsonarrayclientPhone = (JSONArray) js.get("Phones");
        JSONObject jsonObjectClientPhone = (JSONObject) jsonarrayclientPhone.get(0);
        jsonObjectClientPhone.put("PatientPhoneType", "Home");
        jsonObjectClientPhone.put("PatientPhoneNumber", CommonMethods.generateRandomNumberOfFixLength(10));


        return j;
    }

    @SuppressWarnings("unchecked")
    public JSONArray patient_OhioV1MoreThanAllowedLength(String jsonnameclient) throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException {

        String patientZip = CommonMethods.generateRandomNumberOfFixLength(9);

        JSONArray j = CommonMethods.LoadJSON_Ohio(jsonnameclient);

        JSONObject js = (JSONObject) j.get(0);

        js.put("BusinessEntityID", stateInfo.get(ACCID));
        js.put("BusinessEntityMedicaidIdentifier", stateInfo.get(globalVariables.ProviderID));
        js.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(65));
        js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(17));
        js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(13));
        js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(31));
        js.put("PatientFirstName", CommonMethods.generateRandomStringOfFixLength(31));

        JSONArray jsAdd = (JSONArray) js.get("Address");
        JSONObject jsObj = (JSONObject) jsAdd.get(0);
        jsObj.put("PatientAddressType", "Business");
        jsObj.put("PatientAddressIsPrimary", true);
        jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(31));
        jsObj.put("PatientAddressLine2", CommonMethods.generateRandomStringOfFixLength(31));
        jsObj.put("PatientCity", CommonMethods.generateRandomStringOfFixLength(31));
        jsObj.put("PatientZip", patientZip);

        JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
        jsObj1.put("PatientAddressType", "Business");
        jsObj1.put("PatientAddressIsPrimary", true);
        jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(31));
        jsObj1.put("PatientAddressLine2", CommonMethods.generateRandomStringOfFixLength(31));
        jsObj1.put("PatientCity", CommonMethods.generateRandomStringOfFixLength(31));
        jsObj1.put("PatientZip", patientZip);


        JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
        JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
        jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(31));
        jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(31));

        JSONArray jsonarrayclientPhone = (JSONArray) js.get("Phones");
        JSONObject jsonObjectClientPhone = (JSONObject) jsonarrayclientPhone.get(0);
        jsonObjectClientPhone.put("PatientPhoneType", "Home");
        jsonObjectClientPhone.put("PatientPhoneNumber", CommonMethods.generateRandomNumberOfFixLength(11));


        return j;
    }

    public String captureResponseOhioPatientV1_Post(JSONArray JsonArray) throws InterruptedException {
        RestAssured.useRelaxedHTTPSValidation();
        Response resp;
        do {
            resp = sentPostIntakeOhioPatientV1(JsonArray);
            Thread.sleep(10000);
        } while (resp.getStatusCode() == 404);
        return resp.asString();
    }

    private Response sentPostIntakeOhioPatientV1(JSONArray JsonArray) {
        return RestAssured.given().body(JsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).contentType(ContentType.JSON).
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(CommonMethods.propertyfileReader(globalVariables.ohio_patient_v1));
    }

    public String captureResponseOhioPatientV1_Get(String bodyAsStringPost) throws InterruptedException {
        JsonPath jp = new JsonPath(bodyAsStringPost);
        Thread.sleep(3000);
        String UID = jp.get("id");
        RestAssured.useRelaxedHTTPSValidation();
        Response getResp;
        String getResponseBody;
        do {
            getResp = sentGetIntakeOhioPatientV1(UID);
            getResponseBody = getResp.asString();
        } while (getResp.getStatusCode() == 404 || getResponseBody.contains("UUID is not ready yet"));
        System.out.println(getResponseBody);
        return getResponseBody;
    }

    private Response sentGetIntakeOhioPatientV1(String UID) {
        return given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).
                contentType(ContentType.JSON).
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).
                when().log().all().get(CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v1) + '?' + "uuid" + '=' + UID);
    }

}
