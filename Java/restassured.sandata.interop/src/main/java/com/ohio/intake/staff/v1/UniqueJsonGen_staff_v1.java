package com.ohio.intake.staff.v1;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorEmployee;
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

import static com.globalMethods.core.globalVariables.ACCID;
import static com.globalMethods.core.globalVariables.ProviderID;
import static io.restassured.RestAssured.given;

public class UniqueJsonGen_staff_v1 extends BaseTest {

    public JSONArray staff_Ohio(String StaffJson) throws InterruptedException, IOException, ParseException {

        String businessEntityMedicaidIdentifier = stateInfo.get(ProviderID);
        String businessEntityID = stateInfo.get(ACCID);
        JSONArray j = CommonMethods.LoadJSON_Ohio(StaffJson);
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

    public JSONArray staff_OhioV1Required(String StaffJson) throws InterruptedException, IOException, ParseException {

        JSONArray j = CommonMethods.LoadJSON_Ohio(StaffJson);

        JSONObject js = (JSONObject) j.get(0);
        js.put("BusinessEntityID", stateInfo.get(ACCID));
        js.put("BusinessEntityMedicaidIdentifier", stateInfo.get(globalVariables.ProviderID));

        js.put("StaffOtherID", CommonMethods.generateUniqueID());
        js.put("SequenceID", CommonMethods.generateUniqueID());
        js.put("StaffID", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("StaffSSN", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("StaffLastName", "Auto" + CommonMethods.generateRandomStringOfFixLength(9));
        js.put("StaffFirstName", "Auto" + CommonMethods.generateRandomStringOfFixLength(9));

        return j;
    }

    public JSONArray staff_OhioV1maximumAllowedLength(String StaffJson) throws InterruptedException, IOException,
            ParseException {

        JSONArray j = CommonMethods.LoadJSON_Ohio(StaffJson);

        JSONObject js = (JSONObject) j.get(0);

        js.put("BusinessEntityID", stateInfo.get(ACCID));
        js.put("BusinessEntityMedicaidIdentifier", stateInfo.get(globalVariables.ProviderID));
        js.put("StaffOtherID", CommonMethods.generateRandomNumberOfFixLength(64));
        js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(16));
        js.put("StaffID", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("StaffSSN", CommonMethods.generateRandomNumberOfFixLength(9));
        js.put("StaffLastName", CommonMethods.generateRandomStringOfFixLength(30));
        js.put("StaffFirstName", CommonMethods.generateRandomStringOfFixLength(30));
        js.put("StaffEmail", CommonMethods.generateEmailAddress_alpha(49));
        js.put("StaffPosition", DataGenerator_staff_v1.generateStaffPosition(2));

        return j;
    }

    public String captureResponseOhioStaffV1(JSONArray JsonArray) throws InterruptedException {
        RestAssured.useRelaxedHTTPSValidation();
        Response resp;
        do {
            resp = sentPostIntakeStaffV1(JsonArray);
            Thread.sleep(10000);
        } while (resp.getStatusCode() == 404);
        return resp.asString();
    }

    private Response sentPostIntakeStaffV1(JSONArray JsonArray) {
        return RestAssured.given().body(JsonArray.toJSONString()).config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).contentType(ContentType.JSON).
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().post(CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
    }

    public String captureResponseOhioStaffV1_Get(String bodyAsString) throws InterruptedException {
        JsonPath jp = new JsonPath(bodyAsString);
        Thread.sleep(3000);
        String UID = jp.get("id");
        RestAssured.useRelaxedHTTPSValidation();
        Response getResp;
        String bodyAsStringGet;
        do {
            getResp = sendGetIntakeStaffV1(UID);
            bodyAsStringGet = getResp.asString();
        } while (getResp.getStatusCode() == 404 || bodyAsString.contains("UUID is not ready yet"));
        return bodyAsStringGet;
    }

    private Response sendGetIntakeStaffV1(String UID) {
        return given().config(RestAssured.config().sslConfig(
                new SSLConfig().relaxedHTTPSValidation())).
                contentType(ContentType.JSON).
                auth().preemptive().
                basic(stateInfo.get(globalVariables.user), stateInfo.get(globalVariables.pass)).
                header(globalVariables.Account, stateInfo.get(ACCID)).log().all().
                when().get(CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1) + '?' + "uuid" + '=' + UID);
    }
}
