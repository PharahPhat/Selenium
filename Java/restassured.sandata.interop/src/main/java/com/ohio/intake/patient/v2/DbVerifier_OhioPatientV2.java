package com.ohio.intake.patient.v2;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DbVerifier_OhioPatientV2 extends BaseTest{
	
	DataBaseVerifier dataBaseVerifier=new DataBaseVerifier();
	Constant_SQL Constant_SQL=new Constant_SQL();
	DataGeneratorV2 dataGenerator=new DataGeneratorV2();
	ErrorCode_Verification ErrorCode_Verification=new ErrorCode_Verification();
	
	public void jsonAssert_stxPatientOhioV2(JSONObject jsonObject_Map) throws InterruptedException, java.text.ParseException,  SQLException, InterruptedException, ClassNotFoundException, FileNotFoundException, IOException, ParseException
	{		
		logger.log(LogStatus.INFO, "Validating DB response ");
		
		Map<String,String> DbMap_inbox=new HashMap<String, String>();
		Map<String,String> DbMap_stx=new HashMap<String, String>();
		Map<String,String> DbMap_supp=new HashMap<String, String>();
		Map<String,String> DbMap_add=new HashMap<String, String>();
		Map<String,String> DbMap_auth=new HashMap<String, String>();
		
		Map<String, String> DbValue=new HashMap<String, String>();
		DbValue.put("stxSqlQuery", Constant_SQL.stxClientSql_Ohio);
		DbValue.put("DbColumnName1",jsonObject_Map.get("SequenceID").toString());
		DbValue.put("DbColumnName2",jsonObject_Map.get("BusinessEntityID").toString());

		JSONArray jsonArray_Sub = (JSONArray) jsonObject_Map.get("Address");
		JSONObject jsonObjectMap_Supp = (JSONObject) jsonArray_Sub.get(0);
		JSONObject jsonObjectMap_Address = (JSONObject) jsonArray_Sub.get(1);

		DataGeneratorClient.objectCharTruncation(jsonObject_Map, "PatientFirstName", 30);

		DbMap_inbox=dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientsql_Ohio,jsonObject_Map.get("PatientFirstName").toString(),
		jsonObject_Map.get("SequenceID").toString()));		
		
		ErrorCode_Verification.errorCodeVerificationOtherThanZeroOhio(jsonObject_Map, DbMap_inbox, DbValue);	
		
		DbMap_stx=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxClientSql_Ohio, jsonObject_Map.get("SequenceID").toString(), jsonObject_Map.get("BusinessEntityID").toString()));		
		
		jsonObject_Map.put("CLIENTKEY", DbMap_stx.get("CLIENTKEY").toString());	
		dataBaseVerifier.compareMap(DbMap_stx,jsonObject_Map);
		String ClientKey=DbMap_stx.get("CLIENTKEY");
		
		CommonMethods.ZipadditionfourZero(jsonObjectMap_Supp, "PatientZip");
		CommonMethods.ZipadditionfourZero(jsonObjectMap_Address, "PatientZip");

		DbMap_supp=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxClientSuppSql_Ohio,ClientKey));		
		dataBaseVerifier.compareMap(DbMap_supp,jsonObjectMap_Supp);

		jsonObjectMap_Address.put("ERROR_CODE", "0");		

		DbMap_add=dataBaseVerifier.executeQuery(String.format(Constant_SQL.clientAddressSql_Ohio3P,jsonObjectMap_Address.get("PatientAddressLine2").toString(),jsonObjectMap_Address.get("PatientAddressLine1").toString()));		
		dataBaseVerifier.compareMap(DbMap_add,jsonObjectMap_Address);
	}
	
}
