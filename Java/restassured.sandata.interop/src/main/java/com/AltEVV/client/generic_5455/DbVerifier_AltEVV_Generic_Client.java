package com.AltEVV.client.generic_5455;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.Constant_SQL;
import com.globalMethods.core.DataBaseVerifier;
import com.globalMethods.core.DataGeneratorClient;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class DbVerifier_AltEVV_Generic_Client extends BaseTest{
	
	DataBaseVerifier dataBaseVerifier=new DataBaseVerifier();
	Constant_SQL Constant_SQL=new Constant_SQL();
	DataGenerator_AltEVV_Generic_Client dataGenerator=new DataGenerator_AltEVV_Generic_Client();
	

	@SuppressWarnings("unchecked")
	public void stxClientSql_Member(String bodyAsString, JSONObject jsonObject_Map) throws InterruptedException, java.text.ParseException,  SQLException, InterruptedException, ClassNotFoundException
	{
		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

		logger.log(LogStatus.INFO, "Validating DB response ");
		jsonObject_Map.put("Account", CommonMethods.propertyfileReader("altevv_accId_10010"));
		Map<String,String> DbMap=new HashMap<String, String>();

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxClientSql_OpenEvv,jsonObject_Map.get("ClientID").toString(),jsonObject_Map.get("ClientLastName").toString()));		
		Thread.sleep(2000);
		
		dataBaseVerifier.compareMap(DbMap,jsonObject_Map);

	}
	
	public void assertFailErrorMessage(String bodyAsString, String Errormesssage )
	{
		logger.log(LogStatus.INFO, "Validating JSON response failed case");

	//	Assert.assertTrue(bodyAsString.contains("\"status\": FAILED,"));

		Assert.assertTrue(bodyAsString.contains(Errormesssage));


	}
}
