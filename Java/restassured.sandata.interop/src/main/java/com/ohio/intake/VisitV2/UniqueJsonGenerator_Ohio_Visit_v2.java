package com.ohio.intake.VisitV2;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.Constant_SQL;
import com.globalMethods.core.DataBaseVerifier;
import com.globalMethods.core.globalVariables;
import com.ohio.intake.staff.v1.DataGenerator_staff_v1;
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

/**
 * @author Anupam
 */
public class UniqueJsonGenerator_Ohio_Visit_v2 extends BaseTest {

    private DataBaseVerifier dataBaseVerifier = new DataBaseVerifier();
    private Constant_SQL constantSql = new Constant_SQL();

    public static String captureResponse_Visit_Ohio_V2_Post(JSONArray Ohiov1JsonArray) throws InterruptedException {
        logger.log(LogStatus.INFO, "request body generated is " + Ohiov1JsonArray.toJSONString());
        RestAssured.useRelaxedHTTPSValidation();
        Response resp;
        do {
            resp = sendPostOhioVisitV2(Ohiov1JsonArray);
            System.out.println("Wait for the service running");
            Thread.sleep(20000);
        } while (resp.getStatusCode() == 404);
        return resp.getBody().asString();
    }

    public static Response sendPostOhioVisitV2(JSONArray Ohiov1JsonArray) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .auth().preemptive()
                .basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass))
                .body(Ohiov1JsonArray.toJSONString())
                .header(globalVariables.Account, stateInfo.get(ACCID))
                .when().log().headers()
                .post(CommonMethods.propertyfileReader("ohio_visit_v2"));
    }

    public static String captureGetResponseOhio_Visit_V2_Get(String bodyAsString) throws InterruptedException {
        JsonPath jp = new JsonPath(bodyAsString);
        Thread.sleep(3000);
        String uid = jp.get("id");
        RestAssured.useRelaxedHTTPSValidation();
        Response getResp;
        String body;
        do {
            getResp = sendGetOhioVisitV2(uid);
            Thread.sleep(20000);
            body = getResp.getBody().asString();
        } while (getResp.getStatusCode() == 404 || body.contains("The result for the input UUID is not ready yet"));

        return body;
    }

    public static Response sendGetOhioVisitV2(String UID) {
        return given()
                .contentType(ContentType.JSON)
                .auth().preemptive()
                .basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass))
                .header(globalVariables.Account, stateInfo.get(ACCID))
                .when().log().headers().log().parameters().get(CommonMethods.propertyfileReader("ohio_visit_get_v2") + '?' + "uuid" + '=' + UID);
    }

    @SuppressWarnings("unchecked")
    public JSONArray patient_Ohio(String jsonNameClient) throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException {

        JSONArray j = CommonMethods.LoadJSON_Ohio(jsonNameClient);
        Map<String, String> DbMap = new HashMap<String, String>();

        DbMap = dataBaseVerifier.executeQuery(String.format(constantSql.stxAccount, CommonMethods.propertyfileReader("ohio_AccId_v2")));

        System.out.println(DbMap.get("PROVIDER_ID"));
        System.out.println(DbMap.get("ACCOUNT"));

        String BusinessEntityMedicaidIdentifier = DbMap.get("PROVIDER_ID");
        String BusinessEntityID = DbMap.get("ACCOUNT");

        JSONObject js = (JSONObject) j.get(0);

        js.put("BusinessEntityID", BusinessEntityID);
        js.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
        js.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(10));
        js.put("SequenceID", CommonMethods.generateUniqueID());
        js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
        js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
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

    public Map<String, JSONObject> processOhioPatientV2Array() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {
        Map<String, JSONObject> returnObject = new HashMap<>();
        JSONArray jsonArray = patient_Ohio(GlobalVariable_Ohio_Visit_v2.Ohio_patientJson_v2);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        JSONParser parser = new JSONParser();
        JSONObject bodyAsStringget = (JSONObject) parser.parse(preparePatientToCreateVisit(jsonArray));

        returnObject.put("bodyAsStringGet", bodyAsStringget);
        returnObject.put("jsonObject", jsonObject);

        return returnObject;

    }

    //TODO PREPARE PATIENT TEST DATA TO CREATE VISIT
    private String preparePatientToCreateVisit(JSONArray jsonArray) throws InterruptedException {
        logger.log(LogStatus.INFO, "request body generated is " + jsonArray.toJSONString());
        String bodyRepsPost;
        Response resp;
        do {
            resp = sendPostPatientV2(jsonArray);
            Thread.sleep(10000);
            bodyRepsPost = resp.asString();
        } while (resp.getStatusCode() == 404);
        return waitTheDataIsProcessed(bodyRepsPost);
    }

    private Response sendPostPatientV2(JSONArray jsonArray) {
        RestAssured.useRelaxedHTTPSValidation();
        return RestAssured.given().body(jsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation()))
                .contentType(ContentType.JSON)
                .auth().preemptive().
                        basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                        header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                        when().post(CommonMethods.propertyfileReader("ohio_patient_v2"));
    }

    private String waitTheDataIsProcessed(String bodyAsString) throws InterruptedException {
        JsonPath jp = new JsonPath(bodyAsString);
        Thread.sleep(3000);
        String id = jp.get("id");
        Response getResp;
        String getResponse;
        do {
            getResp = sendGetPatientV2(id);
            getResponse = getResp.asString();
            Thread.sleep(10000);
        } while (getResp.getStatusCode() == 404 || getResponse.contains("The result for the input UUID is not ready yet"));
        return getResponse;
    }

    private Response sendGetPatientV2(String id) {
        RestAssured.useRelaxedHTTPSValidation();
        return RestAssured.given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).
                contentType(ContentType.JSON).
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().get(CommonMethods.propertyfileReader("ohio_patient_get_v2") + '?' + "uuid" + '=' + id);
    }

    //TODO PREPARE STAFF TEST DATA TO CREATE VISIT
    private Map<String, JSONObject> prepareStaffToCreateVisit() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException {
        Map<String, JSONObject> returnObject = new HashMap<>();
        JSONArray jsonArray = generateStaffOhio(GlobalVariable_Ohio_Visit_v2.Ohio_StaffJson_v2);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        JSONParser parser = new JSONParser();
        JSONObject bodyStringGet = (JSONObject) parser.parse(captureResponseOhioStaffV2(jsonArray));
        returnObject.put("bodyAsStringGet", bodyStringGet);
        returnObject.put("jsonObject", jsonObject);
        return returnObject;

    }

    private JSONArray generateStaffOhio(String StaffJson) throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException {
        JSONArray jsonArray = CommonMethods.LoadJSON_Ohio(StaffJson);
        Map<String, String> dbMap = new HashMap<>();
        dbMap = dataBaseVerifier.executeQuery(String.format(constantSql.stxAccount, CommonMethods.propertyfileReader("ohio_AccId_v2")));
        JSONObject js = (JSONObject) jsonArray.get(0);
        js.put("BusinessEntityID", dbMap.get("ACCOUNT"));
        js.put("BusinessEntityMedicaidIdentifier", dbMap.get("PROVIDER_ID"));
        js.put("StaffOtherID", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("SequenceID", CommonMethods.generateUniqueID());
        js.put("StaffID", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("StaffSSN", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("StaffLastName", CommonMethods.generateRandomStringOfFixLength(9));
        js.put("StaffFirstName", CommonMethods.generateRandomStringOfFixLength(9));
        js.put("StaffEmail", CommonMethods.generateEmailAddress_alpha(9));
        js.put("StaffPosition", DataGenerator_staff_v1.generateStaffPosition(1));
        return jsonArray;
    }

    private String captureResponseOhioStaffV2(JSONArray jsonArray) throws InterruptedException {
        logger.log(LogStatus.INFO, "request body generated is " + jsonArray.toJSONString());
        Response resp;
        do {
            resp = sendPostStaffV2(jsonArray);
        } while (resp.getStatusCode() == 404);
        return waitForTheStaffIsStoredIntoOracle(resp.asString());
    }

    private Response sendPostStaffV2(JSONArray jsonArray) {
        RestAssured.useRelaxedHTTPSValidation();
        return RestAssured.given().body(jsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation()))
                .contentType(ContentType.JSON)
                .auth().preemptive().
                        basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                        header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                        when().post(CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
    }

    private String waitForTheStaffIsStoredIntoOracle(String bodyAsString) throws InterruptedException {
        JsonPath jsonPath = new JsonPath(bodyAsString);
        Thread.sleep(3000);
        String id = jsonPath.get("id");
        Response getResp;
        String getResponse;
        do {
            getResp = sendGetStaffV2(id);
            Thread.sleep(10000);
            getResponse = getResp.asString();
        } while (getResp.getStatusCode() == 404 || getResponse.contains("The result for the input UUID is not ready yet"));
        return getResponse;
    }

    private Response sendGetStaffV2(String id) {
        RestAssured.useRelaxedHTTPSValidation();
        return RestAssured.given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).
                contentType(ContentType.JSON).
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().get(CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1) + '?' + "uuid" + '=' + id);
    }

    public JSONArray Visit_Ohio_V2() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException {

        Map<String, JSONObject> returnObject_Client = processOhioPatientV2Array();
        Map<String, JSONObject> returnObject_emp = prepareStaffToCreateVisit();

        JSONArray jsonArrayVisit = CommonMethods.LoadJSON_Ohio("visits_v2");

        JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

        jsonObjectVisit.put("PatientMedicaidID", returnObject_Client.get("jsonObject").get("PatientMedicaidID").toString());
        jsonObjectVisit.put("PatientOtherID", returnObject_Client.get("jsonObject").get("PatientOtherID").toString());
        jsonObjectVisit.put("StaffOtherID", returnObject_emp.get("jsonObject").get("StaffOtherID").toString());

        String sequenceid = CommonMethods.generateUniqueID();
        jsonObjectVisit.put("SequenceID", sequenceid);
        jsonObjectVisit.put("VisitOtherID", CommonMethods.generateUniqueID());


        ////////////putting value in Visit subarray detail from alt EVV visitjson//////////////

        JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
        JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);

        jsonObjectVisitChanges.put("SequenceID", sequenceid);

        return jsonArrayVisit;
    }

    public Map<String, JSONObject> processOhioVisitV2Array(Map<String, String> jsonField) throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {
        Map<String, JSONObject> retunObject = new HashMap<String, JSONObject>();
        JSONArray jsonArray = Visit_Ohio_V2();
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        jsonObject.putAll(jsonField);

        JSONParser parser = new JSONParser();
        JSONObject bodyAsStringPost = (JSONObject) parser.parse(captureResponse_Visit_Ohio_V2_Post(jsonArray));
        JSONObject bodyAsStringget = (JSONObject) parser.parse(captureGetResponseOhio_Visit_V2_Get(String.valueOf(bodyAsStringPost)));

        retunObject.put("bodyAsStringPost", bodyAsStringPost);
        retunObject.put("bodyAsStringGet", bodyAsStringget);
        retunObject.put("jsonObject", jsonObject);

        return retunObject;
    }


    public JSONObject subArrayCreation(JSONObject jsonObject, String subArrayname, int indexofSubArray) {
        JSONArray jsonArrayAdd = (JSONArray) jsonObject.get(subArrayname);
        return (JSONObject) jsonArrayAdd.get(indexofSubArray);

    }
}
