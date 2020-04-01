package com.ohio.intake.VisitV2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.globalMethods.core.Constant_SQL;
import com.globalMethods.core.DataBaseVerifier;
import com.globalMethods.core.DataGeneratorClient;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;
import org.testng.Assert;

/**
 * @author Anupam
 *
 */
public class DbVerifier_Ohio_Visit_v2 extends BaseTest{

	
	DataBaseVerifier dataBaseVerifier=new DataBaseVerifier();
	Constant_SQL Constant_SQL=new Constant_SQL();
	DataGenerator_Ohio_Visit_v2 dataGenerator=new DataGenerator_Ohio_Visit_v2();

	@SuppressWarnings("unchecked")
	public void jsonAssert_OhioInboxPatientv2(JSONObject jsonObject_Map) throws InterruptedException, java.text.ParseException,  SQLException, InterruptedException, ClassNotFoundException, FileNotFoundException, IOException, ParseException
	{

		logger.log(LogStatus.INFO, "Validating DB response "); 

		JSONArray jsonArray_Sub = (JSONArray) jsonObject_Map.get("Address");
		JSONObject jsonObjectMap_Supp = (JSONObject) jsonArray_Sub.get(0);
		JSONObject jsonObjectMap_Address = (JSONObject) jsonArray_Sub.get(1);

		Map<String,String> DbMap=new HashMap<String, String>();

		dataGenerator.patientZipScenario(jsonObjectMap_Supp, jsonObjectMap_Address);

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxClientSql_Ohio,jsonObject_Map.get("SequenceID").toString(),jsonObject_Map.get("BusinessEntityID").toString()));		
		String Clientkey=DbMap.get("CLIENTKEY");
		String PatientID=DbMap.get("PATIENTID");

		System.out.println(Clientkey);
		jsonObject_Map.put("CLIENTKEY", Clientkey);
		jsonObject_Map.put("PatientID", PatientID);

		DataGeneratorClient.objectCharTruncation(jsonObject_Map, "PatientFirstName", 30);

		dataBaseVerifier.compareMap(DbMap,jsonObject_Map);

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxClientSuppSql_Ohio, Clientkey));		
		dataBaseVerifier.compareMap(DbMap,jsonObjectMap_Supp);

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.clientAddressSql_Ohio3P,PatientID,jsonObjectMap_Address.get("PatientAddressLine1").toString()));		
		dataBaseVerifier.compareMap(DbMap,jsonObjectMap_Address);

	}

	public void jsonAssert_OhioStxStaffv2(JSONObject jsonObject_Map) throws InterruptedException, java.text.ParseException, ClassNotFoundException, SQLException
	{
		logger.log(LogStatus.INFO, "Validating DB response "); 

		Map<String,String> DbMap=new HashMap<String, String>();

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.StxWorker_3P,jsonObject_Map.get("SequenceID").toString(),jsonObject_Map.get("BusinessEntityID").toString()));		

		dataBaseVerifier.compareMap(DbMap,jsonObject_Map);
	}

	public void jsonAssert_Smoke_Success(JSONObject bodyJson)
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");
		String bodyAsString  = bodyJson.toString();
		Assert.assertTrue(bodyAsString.contains("\"status\":null"));
		Assert.assertTrue(bodyAsString.contains("\"messageSummary\":\"All records uploaded successfully.\""));
	}

	@SuppressWarnings("unchecked")
	public void jsonAssert_OhioinboxVisitv2(JSONObject jsonobject) throws InterruptedException, java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException
	{

		logger.log(LogStatus.INFO, "Validating DB response ");

		Map<String,String> DbMap=new HashMap<String, String>();

		jsonobject.put("error_code", "0");

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitOhio_11604,jsonobject.get("VisitOtherID").toString(), 
				jsonobject.get("SequenceID").toString()));

		jsonobject.put("VISITKEY", DbMap.get("VISITKEY"));
		DbMap.put("PROCEDURECODE",DbMap.get("PROCEDURECODE").split("_")[0]);

		System.out.println(DbMap.get("PROCEDURECODE"));
		
		dataGenerator.Ohiov2_PayerID_PayerLogic(jsonobject);
		
		dataBaseVerifier.compareMap(DbMap,jsonobject);
		
		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxVisitOhio_11604,jsonobject.get("VisitOtherID").toString(), jsonobject.get("SequenceID").toString()));		
		
		DbMap.put("PROCEDURECODE",DbMap.get("PROCEDURECODE").split("_")[0]);
		dataBaseVerifier.compareMap(DbMap,jsonobject);


	}

	public void jsonAssertInboxVisitCallsGeneric(JSONObject jsonObject, JSONObject jsonobject_CallIn, JSONObject jsonobject_CallOut) throws InterruptedException, java.text.ParseException,  SQLException, 
	InterruptedException, ClassNotFoundException
		{

			logger.log(LogStatus.INFO, "Validating DB response for Inbox.visits");
			jsonAssert_OhioinboxVisitv2(jsonObject);

			logger.log(LogStatus.INFO, "Validating DB response for VisitCalls");
			
			final String callType = "CallType";

			Map<String,String> dbMapCallIn=dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitCallsOhio,jsonObject.get("VisitOtherID").toString(),
					jsonobject_CallIn.get("CallAssignment").toString()));

			String callInType = String.valueOf(jsonobject_CallIn.get(callType));

			switch(callInType){  
			case "Other":  
				jsonobject_CallIn.put(callType,"O");
				break; 
			case "Manual":  
				jsonobject_CallIn.put(callType,"M");
				break; 
			case "Telephony":  
				jsonobject_CallIn.put(callType,"T");
				break; 
			case "Mobile":  
				jsonobject_CallIn.put(callType,"G");
				break; 
			case "":  
				jsonobject_CallIn.put(callType,"O");
				break; 
			}

			dataBaseVerifier.compareMap(dbMapCallIn,jsonobject_CallIn);


			Map<String,String> dbMapCallOut=dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitCallsOhio,jsonObject.get("VisitOtherID").toString(),
					jsonobject_CallOut.get("CallAssignment").toString()));

			String callOutType = String.valueOf(jsonobject_CallOut.get(callType));
			
			switch(callOutType){  
			case "Other":  
				jsonobject_CallOut.put(callType,"O");
				break; 
			case "Manual":  
				jsonobject_CallOut.put(callType,"M");
				break; 
			case "Telephony":  
				jsonobject_CallOut.put(callType,"T");
				break; 
			case "Mobile":  
				jsonobject_CallOut.put(callType,"G");
				break;
			case "":  
				jsonobject_CallOut.put(callType,"O");
				break; 
			}

			dataBaseVerifier.compareMap(dbMapCallOut,jsonobject_CallOut);

		}

}
