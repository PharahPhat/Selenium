package com.ohio.intake.patient.v2;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
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

import static io.restassured.RestAssured.given;

public class UniqueJsonGeneratorV2 extends BaseTest {

	@SuppressWarnings("unchecked")
	public JSONArray patient_Ohio_V2(String jsonClient) throws IOException, ParseException {

		JSONArray j = CommonMethods.LoadJSON_Ohio(jsonClient);

		JSONObject clientObject = (JSONObject) j.get(0);

		clientObject.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(10));
		clientObject.put("SequenceID", CommonMethods.generateUniqueID());
		clientObject.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
		clientObject.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
		clientObject.put("PatientFirstName", "SVAMAUTOMATION" + CommonMethods.generateRandomStringOfFixLength(10));

		JSONArray multiAddress = (JSONArray) clientObject.get("Address");
		JSONObject jsObj = (JSONObject) multiAddress.get(0);
		jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

		JSONObject jsObj1 = (JSONObject) multiAddress.get(1);
		jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj1.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

		JSONArray multiClientContact = (JSONArray) clientObject.get("ResponsibleParty");
		JSONObject jsonObjectClientContact = (JSONObject) multiClientContact.get(0);
		jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
		jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));

		return j;
	}

	public String captureResponseOhioPatientV2(JSONArray jsonArray) throws InterruptedException {
		Response resp;
		do {
			resp = sendPostRequest(jsonArray);
			Thread.sleep(10000);
		} while (resp.getStatusCode() == 404);
		return waitForTheRecordProcessed(resp.asString());
	}

	private Response sendPostRequest(JSONArray jsonArray) {
		RestAssured.useRelaxedHTTPSValidation();
		return RestAssured.given().body(jsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).contentType(ContentType.JSON).
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("ohio_user_v2"), CommonMethods.propertyfileReader("ohio_pass_v2")).
				header(globalVariables.Account, CommonMethods.propertyfileReader("ohio_AccId_v2")).log().all().
				when().post(CommonMethods.propertyfileReader("ohio_patient_v2"));
	}

	private String waitForTheRecordProcessed(String bodyAsString) throws InterruptedException {
		JsonPath jp = new JsonPath(bodyAsString);
		Thread.sleep(3000);
		String id = jp.get("id");
		Response getResp;
		String body;
		do {
			getResp = sendGetRequest(id);
			body = getResp.asString();
			Thread.sleep(10000);
		} while (getResp.getStatusCode() == 404 || body.contains("UUID is not ready yet"));
		return body;
	}

	private Response sendGetRequest(String uid) {
		RestAssured.useRelaxedHTTPSValidation();
		return given().config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).
				contentType(ContentType.JSON).
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("ohio_user_v2"), CommonMethods.propertyfileReader("ohio_pass_v2")).
				header(globalVariables.Account, CommonMethods.propertyfileReader("ohio_AccId_v2")).log().all().
				when().get(CommonMethods.propertyfileReader("ohio_patient_get_v2") + '?' + "uuid" + '=' + uid);
	}
}
