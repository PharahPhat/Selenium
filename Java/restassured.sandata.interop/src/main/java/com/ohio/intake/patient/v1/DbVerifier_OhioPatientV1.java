package com.ohio.intake.patient.v1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import com.globalMethods.core.ErrorCode_Verification;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.Constant_SQL;
import com.globalMethods.core.DataBaseVerifier;
import com.globalMethods.core.DataGeneratorClient;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class DbVerifier_OhioPatientV1 extends BaseTest{
	
	DataBaseVerifier dataBaseVerifier=new DataBaseVerifier();
	Constant_SQL Constant_SQL=new Constant_SQL();
	DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	
	ErrorCode_Verification  ErrorCode_Verification=new ErrorCode_Verification();
	
	@SuppressWarnings("unchecked")
	public void jsonAssert_InboxPatientOhioV1(JSONObject jsonObject_Map) throws InterruptedException, java.text.ParseException,  SQLException, InterruptedException, ClassNotFoundException, FileNotFoundException, IOException, ParseException
	{

		logger.log(LogStatus.INFO, "Validating DB response ");
		Map<String,String> DbMap=new HashMap<String, String>();
		Map<String, String> DbValue=new HashMap<String, String>();
		DbValue.put("stxSqlQuery", Constant_SQL.stxClientSql_Ohio);
		DbValue.put("DbColumnName1",jsonObject_Map.get("SequenceID").toString());
		DbValue.put("DbColumnName2",jsonObject_Map.get("BusinessEntityID").toString());

		JSONArray jsonArray_Sub = (JSONArray) jsonObject_Map.get("Address");
		JSONObject jsonObjectMap_Supp = (JSONObject) jsonArray_Sub.get(0);
		JSONObject jsonObjectMap_Address = (JSONObject) jsonArray_Sub.get(1);

		DataGeneratorClient.objectCharTruncation(jsonObject_Map, GlobalVariable_V1.PatientLastName, 30);
		DataGeneratorClient.objectCharTruncation(jsonObject_Map, GlobalVariable_V1.PatientFirstName, 30);


		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientsql_Ohio,jsonObject_Map.get("PatientFirstName").toString(),
		jsonObject_Map.get("SequenceID").toString()));	
		
		jsonObject_Map.put("ClientID", DbMap.get("CLIENTID").toString());
		
		ErrorCode_Verification.errorCodeVerificationOtherThanZeroOhio(jsonObject_Map, DbMap, DbValue);	
		
		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxClientSql_Ohio, jsonObject_Map.get("SequenceID").toString(), jsonObject_Map.get("BusinessEntityID").toString()));		
		
		jsonObject_Map.put("CLIENTKEY", DbMap.get("CLIENTKEY").toString());	
		dataBaseVerifier.compareMap(DbMap,jsonObject_Map);
		String ClientKey=DbMap.get("CLIENTKEY");
		
		CommonMethods.ZipadditionfourZero(jsonObjectMap_Supp, "PatientZip");
		CommonMethods.ZipadditionfourZero(jsonObjectMap_Address, "PatientZip");

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxClientSuppSql_Ohio,ClientKey));		
		dataBaseVerifier.compareMap(DbMap,jsonObjectMap_Supp);

		jsonObjectMap_Address.put("ERROR_CODE", "0");		

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.clientAddressSql_Ohio3P,jsonObjectMap_Address.get("PatientAddressLine2").toString(),jsonObjectMap_Address.get("PatientAddressLine1").toString()));		
		dataBaseVerifier.compareMap(DbMap,jsonObjectMap_Address);

	}
	
	

}
