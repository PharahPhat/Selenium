package com.AltEVV.client.generic_5455;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.Constant_SQL;
import com.globalMethods.core.DataBaseVerifier;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UniqueJsonGenerator_AltEVV_Generic_Client extends BaseTest{

	DataBaseVerifier dataBaseVerifier=new DataBaseVerifier();
	Constant_SQL Constant_SQL=new Constant_SQL();
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@SuppressWarnings("unchecked")
	public  JSONArray ClientParams_AltEVV_10010(String jsonnameclient) throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException {

		JSONArray j= CommonMethods.LoadJSON_AltEVV(jsonnameclient);
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("ClientIdentifier", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("ClientOtherID", CommonMethods.generateRandomNumberOfFixLength(10)); 
		js.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("ClientLastName",  CommonMethods.generateRandomStringOfFixLength(10));
		js.put("ClientMedicaidID",CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("ClientEmailAddress",  CommonMethods.generateEmailAddress_string(10));
		js.put("SequenceID",  CommonMethods.generateRandomNumberOfFixLength(14));

		
		return j;
	}
	
	@SuppressWarnings("unchecked")
	public  JSONArray ClientParams_OpenEVV(String jsonnameclient) throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException {

		String uniqueClientId = CommonMethods.generateRandomNumberOfFixLength(5);

		JSONArray j= CommonMethods.LoadJSON_OpenEVV(jsonnameclient);

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);
		js.put("Account",  CommonMethods.propertyfileReader("altevv_accId_10010"));
		js.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("ClientLastName",  CommonMethods.generateRandomStringOfFixLength(10));
		js.put("ClientMedicaidID",CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("ClientEmailAddress",  CommonMethods.generateEmailAddress_string(10));

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);
		js2.put("Account",  CommonMethods.propertyfileReader("altevv_accId_10010"));

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);
		js3.put("Account",  CommonMethods.propertyfileReader("altevv_accId_10010"));

		JSONArray j4 = (JSONArray) js.get("ClientAddress");
		JSONObject js4 = (JSONObject) j4.get(1);
		js4.put("ClientID", uniqueClientId);
		js4.put("Account",  CommonMethods.propertyfileReader("altevv_accId_10010"));
		
		return j;

	}
	
	@SuppressWarnings("unchecked")
	public  JSONArray ClientParams_OpenEVV_AltEVV(String jsonnameclient) throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException {

		JSONArray j= CommonMethods.LoadJSON_AltEVV(jsonnameclient);
		JSONObject js = (JSONObject) j.get(0);

		JSONArray jsonArrayAuth = (JSONArray) js.get("ClientPayerInformation");
		JSONObject jsonObjectAuth = (JSONObject) jsonArrayAuth.get(0);
		jsonObjectAuth.put("PayerProgram", CommonMethods.generateRandomStringOfFixLength(5));	
		jsonObjectAuth.put("ProcedureCode", CommonMethods.generateRandomStringOfFixLength(5));	

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

	public String captureResponseAltEVV(JSONArray altEVVJsonArray,String Url) throws InterruptedException{

		RestAssured.useRelaxedHTTPSValidation();
		Thread.sleep(3000);
		Response resp = RestAssured.given().body(altEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("altevv_user_10010"),CommonMethods.propertyfileReader("altevv_pass_10010")).
				header(globalVariables.Account, CommonMethods.propertyfileReader("altevv_accId_10010")).log().all().
				when().post(Url).
				then().assertThat().statusCode(200).and().extract().response();

		String bodyAsString = resp.asString();
		System.out.println("Response Body is: " + bodyAsString);

		return bodyAsString;

	}
	public static String captureResponseAltEVVWithOutGet(JSONArray altEVVJsonArray,String Url) throws InterruptedException{

		RestAssured.useRelaxedHTTPSValidation();
		Thread.sleep(3000);
		Response resp = RestAssured.given().body(altEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("altevv_user_10010"),CommonMethods.propertyfileReader("altevv_pass_10010")).
				header(globalVariables.Account, CommonMethods.propertyfileReader("altevv_accId_10010")).log().all().
				when().post(Url).
				then().assertThat().statusCode(200).and().extract().response();

		String bodyAsString = resp.asString();
		System.out.println("Response Body is: " + bodyAsString);



		return bodyAsString;

	}
	public static String captureResponseAltEVVGetWithUID(String bodyAsString, String Url) throws InterruptedException{

		JsonPath jsonPath = new JsonPath(bodyAsString);
		String UID = jsonPath.get("id");
		System.out.println(UID);

		RestAssured.useRelaxedHTTPSValidation();
		Thread.sleep(3000);
		Response getResp = given().config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("altevv_user_10010"),CommonMethods.propertyfileReader("altevv_pass_10010")).
				header(globalVariables.Account, CommonMethods.propertyfileReader("altevv_accId_10010")).log().all().
				when().get(Url+  '?' + "uuid" + '=' + UID).
				then().extract().response();

		String resstring = getResp.asString();

		System.out.println(resstring);

		logger.log(LogStatus.INFO, "response body extracted is " +resstring);

		return resstring;

	}
	
	public static String captureResponseOPENEVV(JSONArray OpenEVVJsonArray,String Url, String urlGet) throws InterruptedException{


		logger.log(LogStatus.INFO, "request body generated is " +OpenEVVJsonArray.toJSONString()); 

		RestAssured.useRelaxedHTTPSValidation();

		Response resp = RestAssured.given().body(OpenEVVJsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("altevv_user_10010"),CommonMethods.propertyfileReader("altevv_pass_10010")).
				header(globalVariables.Account, CommonMethods.propertyfileReader("altevv_accId_10010")).log().all().
				when().post(Url).
				then().assertThat().statusCode(200).and().extract().response();

		String bodyAsString = resp.asString();
		System.out.println("Response Body is: " + bodyAsString);

		logger.log(LogStatus.INFO, "response body extracted is " +bodyAsString);

		CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, urlGet);

		Thread.sleep(2000);
		return bodyAsString;

	}
	
	public  JSONObject openEvvSameValueIntoAltEVV(JSONArray jsonArray_AltEVV, JSONObject jsonObject_OpenEVV)
	{
	JSONObject jsonObject_AltEVV = (JSONObject) jsonArray_AltEVV.get(0);
	
	jsonObject_AltEVV.put("ClientID", jsonObject_OpenEVV.get("ClientID"));
	jsonObject_AltEVV.put("ClientSSN", jsonObject_OpenEVV.get("ClientSSN"));
	jsonObject_AltEVV.put("ClientFirstName", jsonObject_OpenEVV.get("ClientFirstName"));
	jsonObject_AltEVV.put("ClientLastName", jsonObject_OpenEVV.get("ClientLastName"));
	jsonObject_AltEVV.put("ClientMedicaidID", jsonObject_OpenEVV.get("ClientMedicaidID"));
	jsonObject_AltEVV.put("SequenceID",  CommonMethods.generateRandomNumberOfFixLength(14));
	
	return jsonObject_AltEVV ;
	}
	
	public JSONObject ClientCreation5455() throws InterruptedException, IOException, ParseException, ClassNotFoundException, SQLException, java.text.ParseException
	{
		JSONArray jsonArray=ClientParams_OpenEVV("client");
		JSONObject jsonObject_OpenEVV = (JSONObject) jsonArray.get(0);
		
		String bodyAsString = UniqueJsonGenerator_AltEVV_Generic_Client.captureResponseOPENEVV(jsonArray,
				CommonMethods.propertyfileReader("clients"),
				CommonMethods.propertyfileReader("Client_get"));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject_OpenEVV);

		return jsonObject_OpenEVV;
	}
	
	
}
