package com.ohio.intake.Visit.v1;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
import com.ohio.intake.staff.v1.DataGenerator_staff_v1;
import com.ohio.intake.staff.v1.GlobalVariable_staff_v1;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static com.globalMethods.core.globalVariables.ACCID;
import static io.restassured.RestAssured.given;

public class UniqueJsonGenerator_Ohio_Visit_v1 extends BaseTest {

    DataBaseVerifier dataBaseVerifier = new DataBaseVerifier();
    Constant_SQL Constant_SQL = new Constant_SQL();

    private static String captureResponse_Visit_Ohio_V1_Post(JSONArray Ohiov1JsonArray) throws InterruptedException {
        RestAssured.useRelaxedHTTPSValidation();
        Response resp;
        do {
            resp = sendPostVisitOhioV1(Ohiov1JsonArray);
            Thread.sleep(10000);
        } while (resp.getStatusCode() == 404);
        return resp.asString();
    }

    private static Response sendPostVisitOhioV1(JSONArray Ohiov1JsonArray) {
        return RestAssured.given().body(Ohiov1JsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).contentType(ContentType.JSON).
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(CommonMethods.propertyfileReader("ohio_visit_v1"));
    }

    private static String captureGetResponseOhio_Visit_V1_Get(String bodyAsString) throws InterruptedException {
        JsonPath jp = new JsonPath(bodyAsString);
        Thread.sleep(3000);
        String UID = jp.get("id");
        RestAssured.useRelaxedHTTPSValidation();
        Response getResp;
        String bodyAsStringGet;
        do {
            getResp = sendGetVisitOhioV1(UID);
            bodyAsStringGet = getResp.asString();
        } while (getResp.getStatusCode() == 404 || bodyAsStringGet.contains("UUID is not ready yet"));
        return bodyAsStringGet;
    }

    private static Response sendGetVisitOhioV1(String UID) {
        return given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).contentType(ContentType.JSON).
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().get(CommonMethods.propertyfileReader("ohio_visit_get_v1") + '?' + "uuid" + '=' + UID);
    }

    @SuppressWarnings("unchecked")
    public JSONArray patient_Ohio(String jsonnameclient) throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException {

        JSONArray j = CommonMethods.LoadJSON_Ohio(jsonnameclient);

        JSONObject js = (JSONObject) j.get(0);

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

    private Map<String, JSONObject> processOhioPatientV1Array() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {
        Map<String, JSONObject> retunObject = new HashMap<String, JSONObject>();
        JSONArray jsonArray = patient_Ohio(GlobalVariable_V1.Ohio_patientJson_v1);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        JSONParser parser = new JSONParser();
        JSONObject bodyAsStringget = (JSONObject) parser.parse(captureResponseOhioPatientV1(jsonArray));

        retunObject.put("bodyAsStringGet", bodyAsStringget);
        retunObject.put("jsonObject", jsonObject);

        return retunObject;

    }

    private String captureResponseOhioPatientV1(JSONArray JsonArray) throws InterruptedException {


        logger.log(LogStatus.INFO, "request body generated is " + JsonArray.toJSONString());

        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(JsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(CommonMethods.propertyfileReader("ohio_patient_v1")).
                then().assertThat().statusCode(200).and().extract().response();

        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);
        Thread.sleep(2000);
        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);
        String bodyAsStringGet = captureResponseOhioPatientV1_Get(bodyAsString);
        return bodyAsStringGet;

    }

    private String captureResponseOhioPatientV1_Get(String bodyAsString) throws InterruptedException {

        JsonPath jp = new JsonPath(bodyAsString);
        Thread.sleep(3000);
        String UID = jp.get("id");
        RestAssured.useRelaxedHTTPSValidation();

        Response getResp = given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().get(CommonMethods.propertyfileReader("ohio_patient_get_v1") + '?' + "uuid" + '=' + UID).
                then().assertThat().statusCode(200).and().extract().response();

        String getresponse = getResp.asString();
        System.out.println("Response Body is: " + getresponse);
        System.out.println(CommonMethods.propertyfileReader("ohio_patient_get_v1") + UID);
        return getresponse;

    }

    public Map<String, JSONObject> processOhioStaffV1() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {
        Map<String, JSONObject> retunObject = new HashMap<String, JSONObject>();

        JSONArray jsonArray = staff_Ohio(GlobalVariable_staff_v1.Ohio_StaffJson_v1);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        JSONParser parser = new JSONParser();

        JSONObject bodyAsStringget = (JSONObject) parser.parse(captureResponseOhiostaffV1(jsonArray));

        retunObject.put("bodyAsStringGet", bodyAsStringget);
        retunObject.put("jsonObject", jsonObject);

        return retunObject;

    }

    private JSONArray staff_Ohio(String StaffJson) throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException {

        JSONArray j = CommonMethods.LoadJSON_Ohio(StaffJson);
        Map<String, String> DbMap = new HashMap<String, String>();

        DbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount, CommonMethods.propertyfileReader("ohio_AccId_v1")));

        JSONObject js = (JSONObject) j.get(0);

        js.put("BusinessEntityID", DbMap.get("ACCOUNT"));
        js.put("BusinessEntityMedicaidIdentifier", DbMap.get("PROVIDER_ID"));
        js.put("StaffOtherID", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("StaffID", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("StaffSSN", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("StaffLastName", CommonMethods.generateRandomStringOfFixLength(9));
        js.put("StaffFirstName", CommonMethods.generateRandomStringOfFixLength(9));
        js.put("StaffEmail", CommonMethods.generateEmailAddress_alpha(9));
        js.put("StaffPosition", DataGenerator_staff_v1.generateStaffPosition(1));

        return j;
    }

    private String captureResponseOhiostaffV1(JSONArray JsonArray) throws InterruptedException {


        logger.log(LogStatus.INFO, "request body generated is " + JsonArray.toJSONString());

        RestAssured.useRelaxedHTTPSValidation();

        Response resp = RestAssured.given().body(JsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                auth().preemptive().
                basic(CommonMethods.propertyfileReader(globalVariables.ohio_user_v1), CommonMethods.propertyfileReader(globalVariables.ohio_pass_v1)).
                header(globalVariables.Account, CommonMethods.propertyfileReader(globalVariables.ohio_AccId_v1)).log().all().
                when().post(CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1)).
                then().assertThat().statusCode(200).and().extract().response();

        String bodyAsString = resp.asString();
        System.out.println("Response Body is: " + bodyAsString);

        logger.log(LogStatus.INFO, "response body extracted is " + bodyAsString);
        String bodyAsStringGet = captureResponseOhiostaffV1_Get(bodyAsString);
        return bodyAsStringGet;

    }

    private String captureResponseOhiostaffV1_Get(String bodyAsString) throws InterruptedException {

        JsonPath jp = new JsonPath(bodyAsString);
        Thread.sleep(3000);
        String UID = jp.get("id");
        RestAssured.useRelaxedHTTPSValidation();

        Response getResp = given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).header("Content-Type", "application/json").
                header("Content-Type", "application/json").
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().get(CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1) + '?' + "uuid" + '=' + UID).
                then().assertThat().statusCode(200).and().extract().response();

        String getresponse = getResp.asString();
        System.out.println("Response Body is: " + getresponse);
        System.out.println(CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1) + UID);
        return getresponse;

    }

    public JSONArray Visit_Ohio_V1() throws IOException, ParseException {

        GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();
        Map<String, String> client = generateUniqueParam.getRandomClient(Constant_SQL.random_ClientAltEVVGenericSql);
        Map<String, String> employee = generateUniqueParam.getRandomEmployee(Constant_SQL.random_Worker_AltEVVGeneric);

        JSONArray jsonArrayVisit = CommonMethods.LoadJSON_Ohio("visits_v1");


        JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

        jsonObjectVisit.put("BusinessEntityID", stateInfo.get(ACCID));
        jsonObjectVisit.put("BusinessEntityMedicaidIdentifier", stateInfo.get(globalVariables.ProviderID));
        jsonObjectVisit.put("PayerID", stateInfo.get(globalVariables.PayerID));
        jsonObjectVisit.put("ProcedureCode", stateInfo.get(globalVariables.ProcedureCode));
        jsonObjectVisit.put("PayerProgram", stateInfo.get(globalVariables.PayerProgram));

        jsonObjectVisit.put("PatientMedicaidID", client.get("PATIENTMEDICAIDID"));
        jsonObjectVisit.put("PatientOtherID", client.get("PATIENTOTHERID"));
        jsonObjectVisit.put("StaffOtherID", employee.get("STAFFOTHERID"));

        String sequenceid = CommonMethods.generateUniqueID();
        jsonObjectVisit.put("SequenceID", sequenceid);
        jsonObjectVisit.put("VisitOtherID", CommonMethods.generateUniqueID());
        jsonObjectVisit.put("PayerProgram", "Ohio Home Care Waiver");


        ////////////putting value in Visit subarray detail from alt EVV visitjson//////////////

        JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
        JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);

        jsonObjectVisitChanges.put("SequenceID", sequenceid);

        return jsonArrayVisit;
    }

    public Map<String, JSONObject> processOhioVisitV1Array(Map<String, String> jsonField) throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {
        Map<String, JSONObject> retunObject = new HashMap<String, JSONObject>();
        JSONArray jsonArray = Visit_Ohio_V1();
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        jsonObject.putAll(jsonField);

        JSONParser parser = new JSONParser();
        JSONObject bodyAsStringPost = (JSONObject) parser.parse(captureResponse_Visit_Ohio_V1_Post(jsonArray));
        JSONObject bodyAsStringget = (JSONObject) parser.parse(captureGetResponseOhio_Visit_V1_Get(String.valueOf(bodyAsStringPost)));

        retunObject.put("bodyAsStringPost", bodyAsStringPost);
        retunObject.put("bodyAsStringGet", bodyAsStringget);
        retunObject.put("jsonObject", jsonObject);

        return retunObject;

    }

    public Map<String, JSONObject> processOhioVisitV1SubArrayCalls(Map<String, String> jsonField1, Map<String, String> jsonField2) throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {
        Map<String, JSONObject> retunObject = new HashMap<>();
        JSONArray jsonArray = Visit_Ohio_V1();
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        jsonObject.putAll(jsonField1);

        JSONObject jsonObjectCallIn = subArrayCreation(jsonObject, GlobalVariable_Ohio_Visit_v1.callsjson, 0);
        jsonObjectCallIn.putAll(jsonField1);
        JSONObject jsonObjectCallOut = subArrayCreation(jsonObject, GlobalVariable_Ohio_Visit_v1.callsjson, 1);
        jsonObjectCallOut.putAll(jsonField2);

        JSONParser parser = new JSONParser();
        JSONObject bodyAsStringPost = (JSONObject) parser.parse(captureResponse_Visit_Ohio_V1_Post(jsonArray));
        Thread.sleep(5000);
        JSONObject bodyAsStringGet = (JSONObject) parser.parse(captureGetResponseOhio_Visit_V1_Get(String.valueOf(bodyAsStringPost)));

        retunObject.put("bodyAsStringPost", bodyAsStringPost);
        retunObject.put("bodyAsStringGet", bodyAsStringGet);
        retunObject.put("jsonObject", jsonObject);
        retunObject.put("jsonObject_callIn", jsonObjectCallIn);
        retunObject.put("jsonObject_callOut", jsonObjectCallOut);

        return retunObject;

    }

    public Map<String, JSONObject> processOhioVisitV1SubArrayCalls_SameVaue(Map<String, String> jsonField) throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {
        Map<String, JSONObject> retunObject = new HashMap<>();
        JSONArray jsonArray = Visit_Ohio_V1();
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        jsonObject.putAll(jsonField);

        JSONObject jsonObjectCallIn = subArrayCreation(jsonObject, GlobalVariable_Ohio_Visit_v1.callsjson, 0);
        jsonObjectCallIn.putAll(jsonField);
        JSONObject jsonObjectCallOut = subArrayCreation(jsonObject, GlobalVariable_Ohio_Visit_v1.callsjson, 1);
        jsonObjectCallOut.putAll(jsonField);

        JSONParser parser = new JSONParser();
        JSONObject bodyAsStringPost = (JSONObject) parser.parse(captureResponse_Visit_Ohio_V1_Post(jsonArray));
        JSONObject bodyAsStringget = (JSONObject) parser.parse(captureGetResponseOhio_Visit_V1_Get(String.valueOf(bodyAsStringPost)));

        retunObject.put("bodyAsStringPost", bodyAsStringPost);
        retunObject.put("bodyAsStringGet", bodyAsStringget);
        retunObject.put("jsonObject", jsonObject);
        retunObject.put("jsonObject_callIn", jsonObjectCallIn);
        retunObject.put("jsonObject_callOut", jsonObjectCallOut);

        return retunObject;

    }

    public JSONObject subArrayCreation(JSONObject jsonObject, String subArrayname, int indexofSubArray) {
        JSONArray jsonArrayAdd = (JSONArray) jsonObject.get(subArrayname);
        return (JSONObject) jsonArrayAdd.get(indexofSubArray);

    }

}
