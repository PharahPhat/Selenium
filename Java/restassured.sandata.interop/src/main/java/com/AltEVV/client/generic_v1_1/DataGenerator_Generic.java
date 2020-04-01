package com.AltEVV.client.generic_v1_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class DataGenerator_Generic extends BaseTest{

	UniqueJsonGenerator_Generic uniqueJsonGenerator=new UniqueJsonGenerator_Generic();
	
	public  JSONObject subArrayCreation(JSONObject jsonObject,  String subArrayname, int indexofSubArray) throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException
	{
		JSONArray jsonArrayAdd = 	(JSONArray) jsonObject.get(subArrayname);
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayAdd.get(indexofSubArray);

		return jsonObjectAdd;
	}

	public  JSONArray generateRandomJsonClientgeneric() throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException
	{
		JSONArray jsonArray=uniqueJsonGenerator.AltEvv_Client_generic(GlobalVariable_generic.client_intakeJson_generic);

		return jsonArray;
	}

	public  JSONObject mainArrayCreation(String TestCaseName, JSONArray jsonArray, int indexofArray) throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException
	{

		JSONObject jsonObject = (JSONObject) jsonArray.get(indexofArray);

		return jsonObject;
	}

	public Map<String, JSONObject> processAltEVVClientgeneric(Map<String, String> jsonField ) throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException
	{
		Map<String, JSONObject> retunObject=new HashMap<String, JSONObject>();

		JSONArray jsonArray = uniqueJsonGenerator.AltEvv_Client_generic(GlobalVariable_generic.client_intakeJson_generic);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.putAll(jsonField);

		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringget = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseAltEvvClientgeneric(jsonArray));

		retunObject.put( "bodyAsStringget", bodyAsStringget);
		retunObject.put("jsonObject", jsonObject);	

		return  retunObject;

	}
	
	public Map<String, JSONObject> processAltEVVClientgeneric_post(Map<String, String> jsonField ) throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException
	{
		Map<String, JSONObject> retunObject=new HashMap<String, JSONObject>();

		JSONArray jsonArray = uniqueJsonGenerator.AltEvv_Client_generic(GlobalVariable_generic.client_intakeJson_generic);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.putAll(jsonField);

		JSONParser parser = new JSONParser();

		JSONObject bodyAsString = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseAltEvvClientgeneric_post(jsonArray));   

		return  bodyAsString;

	}

	public Map<String, JSONObject> processAltEVVClientgenericWithSubArray(Map<String, String> jsonField, String SubArrayField, int subArrayIndex ) throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException
	{
		Map<String, JSONObject> retunObject=new HashMap<String, JSONObject>();
		JSONArray jsonArray = uniqueJsonGenerator.AltEvv_Client_generic(GlobalVariable_generic.client_intakeJson_generic);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObject_Sub=subArrayCreation(jsonObject, SubArrayField, subArrayIndex);
		jsonObject_Sub.putAll(jsonField);
		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringget = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseAltEvvClientgeneric(jsonArray));

		retunObject.put( "bodyAsStringget", bodyAsStringget);
		retunObject .put("jsonObject", jsonObject);	
		retunObject .put("jsonObject_Sub", jsonObject_Sub);	

		return  retunObject;

	}

	public Map<String, JSONObject> processAltEVVClientgenericWithSubArrayRemove(String jsonField, String SubArrayField, int subArrayIndex ) throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException
	{
		Map<String, JSONObject> retunObject=new HashMap<String, JSONObject>();
		JSONArray jsonArray = uniqueJsonGenerator.AltEvv_Client_generic(GlobalVariable_generic.client_intakeJson_generic);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObject_Sub=subArrayCreation(jsonObject, SubArrayField, subArrayIndex);
		jsonObject_Sub.remove(jsonField);
		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringget = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseAltEvvClientgeneric(jsonArray));

		retunObject.put( "bodyAsStringget", bodyAsStringget);
		retunObject .put("jsonObject", jsonObject);	
		retunObject .put("jsonObject_Sub", jsonObject_Sub);	

		return  retunObject;

	}

	public void assertFailErrorMessage(String bodyAsString, String Errormesssage )
	{
		logger.log(LogStatus.INFO, "Validating JSON response failed case");

	//	Assert.assertTrue(bodyAsString.contains("\"status\": FAILED,"));

		Assert.assertTrue(bodyAsString.contains(Errormesssage));


	}

	
	public void assertFailErrorMessage_status(String bodyAsString, String ErrorMesssage )
	{
		logger.log(LogStatus.INFO, "Validating JSON response failed case");

		Assert.assertTrue(bodyAsString.contains("\"status\":\"FAILED\""));

		Assert.assertTrue(bodyAsString.contains(ErrorMesssage));


	}

	public static  void jsonBodyPassVerification_AltEVVGenric(String bodyAsString )
	{
		logger.log(LogStatus.INFO, "Validating JSON response failed case");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

		logger.log(LogStatus.INFO, "Validating DB response ");
	}
	
	public static JSONObject MissingMedicaidIDJsonDB(JSONObject jsonObject_Map)
	{

		if(jsonObject_Map.get("MissingMedicaidID").equals(Boolean.toString(true)))
		{
			jsonObject_Map.put("MissingMedicaidID", "Y");	

		}
		else if (jsonObject_Map.get("MissingMedicaidID").equals(Boolean.toString(false)))
		{
			jsonObject_Map.put("MissingMedicaidID", "N");		
		}
		return jsonObject_Map;
	}
	
	public static void clientQualifierValueAssigned(JSONObject jsonObject_Map) 
	{
		//	if ClientQualifier is "ClientSSN", ClientSSN will be overwritten by ClientIdentifier.
		//	if ClientQualifier is "ClientOtherID", ClientOtherID will be overwritten by ClientIdentifier.
		//	if ClientCustomID is "ClientCustomID", ClientCustomID will be overwritten by ClientIdentifier.

		if(jsonObject_Map.get("ClientQualifier").toString().equals("ClientSSN"))
		{
			jsonObject_Map.put("ClientSSN", jsonObject_Map.get("ClientIdentifier").toString());
		}
		else if (jsonObject_Map.get("ClientQualifier").toString().equals("ClientOtherID")) 
		{
			jsonObject_Map.put("ClientOtherID",jsonObject_Map.get("ClientIdentifier").toString());
		}

		else if (jsonObject_Map.get("ClientQualifier").toString().equals("ClientCustomID")) 
		{
			jsonObject_Map.put("ClientCustomID", jsonObject_Map.get("ClientIdentifier").toString());
		}

	} 

}
