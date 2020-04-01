package com.AltEVV.client.generic_v1_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.globalMethods.core.CommonMethods;

import com.globalMethods.core.DataBaseVerifier;
import com.globalMethods.core.DataGeneratorClient;
import com.globalMethods.core.ErrorCode_Verification;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class DbVerifier_AltEVV_ClientGeneric extends BaseTest{
	
	ErrorCode_Verification ErrorCode_Verification=new ErrorCode_Verification();
	DataBaseVerifier dataBaseVerifier=new DataBaseVerifier();
	Constant_SQL_AltEVV_Generic Constant_SQL=new Constant_SQL_AltEVV_Generic();
	DataGenerator_Generic dataGenerator=new DataGenerator_Generic();
	
	@SuppressWarnings("unchecked")
	public void jsonAssert_InboxClient_AltEVVGeneric(JSONObject jsonObject_Map) throws InterruptedException, java.text.ParseException,  SQLException, InterruptedException, ClassNotFoundException, FileNotFoundException, IOException, ParseException
	{
		
		logger.log(LogStatus.INFO, "Validating DB response ");  
		Map<String,String> DbMap=new HashMap<String, String>();
		Map<String, String> DbValue=new HashMap<String, String>();
		DbValue.put("stxSqlQuery", Constant_SQL.stxClientAltEVVGenericSql);
		DbValue.put("DbColumnName1",jsonObject_Map.get("ClientID").toString());
		DbValue.put("DbColumnName2",jsonObject_Map.get("ClientFirstName").toString());
	
		dataGenerator.clientQualifierValueAssigned(jsonObject_Map);
	
		DataGeneratorClient.missingMedicatedIDValueasTrue(jsonObject_Map);
	
		DataGeneratorClient.objectCharTruncation(jsonObject_Map, "ClientFirstName", 30);
		DataGeneratorClient.objectCharTruncation(jsonObject_Map, "ClientLastName", 30);
		DataGeneratorClient.objectCharTruncation(jsonObject_Map, "ClientCustomID", 24);
		DataGeneratorClient.objectCharTruncation(jsonObject_Map, "ClientOtherID", 24);

		DataGeneratorClient.objectCharTruncation(jsonObject_Map, globalVariables.jsonProcedureCode, 5);

		jsonObject_Map=dataGenerator.MissingMedicaidIDJsonDB(jsonObject_Map);
		
		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientAltEVVGenericSql_TC,jsonObject_Map.get("ClientID").toString(),jsonObject_Map.get("ClientFirstName").toString()));		
		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObject_Map, DbMap, DbValue);	
}  
	

}
