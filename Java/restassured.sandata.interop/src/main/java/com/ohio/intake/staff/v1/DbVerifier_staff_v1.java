package com.ohio.intake.staff.v1;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.globalMethods.core.Constant_SQL;
import com.globalMethods.core.DataBaseVerifier;
import com.globalMethods.core.ErrorCode_Verification;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import org.testng.Assert;

public class DbVerifier_staff_v1 extends BaseTest{

	DataBaseVerifier dataBaseVerifier=new DataBaseVerifier();
	Constant_SQL constantSQL=new Constant_SQL();
	DataGenerator_staff_v1 dataGenerator= new DataGenerator_staff_v1();
	Map<String,String> dbMap= new HashMap<>();
	ErrorCode_Verification ErrorCode_Verification=new ErrorCode_Verification();
	
	public void jsonAssert_StxStaffOhioV1(JSONObject jsonObjectMap) throws InterruptedException, java.text.ParseException, ClassNotFoundException, SQLException, ParseException
	{
//		logger.log(LogStatus.INFO, "Validating DB response "); 
//
	//
//		dbMap=dataBaseVerifier.executeQuery(String.format(constantSQL.StxWorker_3P,jsonObjectMap.get("SequenceID").toString(),jsonObjectMap.get("BusinessEntityID").toString()));		
//
//		dataBaseVerifier.compareMap(dbMap,jsonObjectMap);
		
		logger.log(LogStatus.INFO, "Validating DB response ");
		Map<String,String> DbMap;
		Map<String, String> DbValue=new HashMap<>();
		DbValue.put("stxSqlQuery", constantSQL.StxWorker_3P);
		DbValue.put("DbColumnName1",jsonObjectMap.get("SequenceID").toString());
		DbValue.put("DbColumnName2",jsonObjectMap.get("BusinessEntityID").toString());

		DataGenerator_staff_v1.objectCharTruncation(jsonObjectMap, GlobalVariable_staff_v1.staffLName, 30);
		DataGenerator_staff_v1.objectCharTruncation(jsonObjectMap, GlobalVariable_staff_v1.staffFName, 30);

		DbMap=dataBaseVerifier.executeQuery(String.format(constantSQL.inboxWorker_3P,jsonObjectMap.get("StaffSSN").toString(), 
				jsonObjectMap.get("BusinessEntityID").toString()));

		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObjectMap, DbMap, DbValue);	
	}

	public void jsonAssert_Smoke_Success(JSONObject bodyJson)
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");
		String bodyAsString  = bodyJson.toString();
		Assert.assertTrue(bodyAsString.contains("\"status\":null"));
		Assert.assertTrue(bodyAsString.contains("\"messageSummary\":\"All records uploaded successfully.\""));
	}
}
