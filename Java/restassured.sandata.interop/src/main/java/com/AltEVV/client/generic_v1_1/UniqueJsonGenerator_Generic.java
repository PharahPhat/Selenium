package com.AltEVV.client.generic_v1_1;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

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

public class UniqueJsonGenerator_Generic extends BaseTest{
	
	DataBaseVerifier dataBaseVerifier=new DataBaseVerifier();
	Constant_SQL Constant_SQL=new Constant_SQL();
	public  String primaryField[];
	
	@SuppressWarnings("unchecked")
	public JSONArray AltEvv_Client_generic(String jsonnameclient) throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {

		JSONArray j= CommonMethods.LoadJSON_AltEVV(jsonnameclient);
		Map<String,String> DbMap=new HashMap<String, String>();

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader("altevv_accId")));

		System.out.println(DbMap.get("PROVIDER_ID"));
		System.out.println(DbMap.get("ACCOUNT"));

		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");

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

	public String captureResponseAltEvvClientgeneric(JSONArray JsonArray) throws InterruptedException{


		logger.log(LogStatus.INFO, "request body generated is " +JsonArray.toJSONString()); 

		RestAssured.useRelaxedHTTPSValidation();

		Response resp = RestAssured.given().body(JsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("altevv_user"),CommonMethods.propertyfileReader("altevv_pass")).
				header(globalVariables.Account, CommonMethods.propertyfileReader("altevv_accId")).log().all().
				when().post(CommonMethods.propertyfileReader("altevv_clients")).
				then().assertThat().statusCode(200).and().extract().response();

		String bodyAsString = resp.asString();
		System.out.println("Response Body is: " + bodyAsString);

		logger.log(LogStatus.INFO, "response body extracted is " +bodyAsString);
		String bodyAsStringGet=captureResponseAltEvvClientgeneric_Get(bodyAsString);
		return bodyAsStringGet;

	}
	
	public String captureResponseAltEvvClientgeneric_post(JSONArray JsonArray) throws InterruptedException{


		logger.log(LogStatus.INFO, "request body generated is " +JsonArray.toJSONString()); 

		RestAssured.useRelaxedHTTPSValidation();

		Response resp = RestAssured.given().body(JsonArray.toJSONString()).config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("altevv_user"),CommonMethods.propertyfileReader("altevv_pass")).
				header(globalVariables.Account, CommonMethods.propertyfileReader("altevv_accId")).log().all().
				when().post(CommonMethods.propertyfileReader("altevv_clients")).
				then().assertThat().statusCode(200).and().extract().response();

		String bodyAsString = resp.asString();
		System.out.println("Response Body is: " + bodyAsString);

		return bodyAsString;

	}
	
	public String captureResponseAltEvvClientgeneric_Get(String bodyAsString) throws InterruptedException{

		JsonPath jp = new JsonPath(bodyAsString);
		Thread.sleep(3000);
		String UID = jp.get("id");
		RestAssured.useRelaxedHTTPSValidation();

		Response getResp = given().config(RestAssured.config().sslConfig(
				new SSLConfig().relaxedHTTPSValidation())).header("Content-Type","application/json").
				header("Content-Type","application/json").
				auth().preemptive().
				basic(CommonMethods.propertyfileReader("altevv_user"),CommonMethods.propertyfileReader("altevv_pass")).
				header(globalVariables.Account, CommonMethods.propertyfileReader("altevv_accId")).log().all().

				when().get(CommonMethods.propertyfileReader("altevv_clients_get")+  '?' + "uuid" + '=' + UID).
				then().assertThat().statusCode(200).and().extract().response();

		String getresponse = getResp.asString();
		System.out.println("Response Body is: " + getresponse);
		System.out.println(CommonMethods.propertyfileReader("altevv_clients_get")+ UID);
		return getresponse;

	}
	
	@SuppressWarnings("unchecked")
	public  JSONObject AltEvv_clientgenericRequired(JSONArray jsonArray,HashMap<String, String> nonPrimaryField){

		JSONObject jsobject = (JSONObject) jsonArray.get(0);

		primaryField=new String[]{"ClientID","ClientSSN","ClientFirstName","ClientLastName","ClientMedicaidID"};


		Iterator<String> keyset=nonPrimaryField.keySet().iterator();
		ArrayList<String> primaryList = new ArrayList<String>(Arrays.asList(primaryField));
		while(keyset.hasNext()){


			primaryList.add(keyset.next().toString());
		}


		for(int i =0;i<primaryList.size();i++)
		{
			switch(primaryList.get(i)) {
			case "ClientID" :
				jsobject.put(primaryList.get(i), CommonMethods.generateRandomNumberOfFixLength(5));
				break;
			case "ClientSSN" :
				jsobject.put(primaryList.get(i), CommonMethods.generateRandomNumberOfFixLength(9));
				break;
			case "ClientFirstName" :
				jsobject.put(primaryList.get(i), CommonMethods.generateRandomStringOfFixLength(10));
				break;
			case "ClientLastName" :
				jsobject.put(primaryList.get(i), CommonMethods.generateRandomStringOfFixLength(10));
				break;
			case "ClientMedicaidID" :
				jsobject.put(primaryList.get(i), CommonMethods.generateRandomNumberOfFixLength(10));
				break;
			default :
				jsobject.put(primaryList.get(i), nonPrimaryField.get(primaryList.get(i))); 
			}
		}
		return jsobject;
	}

}
