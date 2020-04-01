package com.ohio.intake.patient.v2;

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

public class DbVerifier_Ohio_InboxPatientV2 extends BaseTest{

	DataBaseVerifier dataBaseVerifier=new DataBaseVerifier();
	Constant_SQL Constant_SQL=new Constant_SQL();
	DataGeneratorV2 dataGenerator=new DataGeneratorV2();

	@SuppressWarnings("unchecked")
	public void jsonAssert_InboxPatientOhioV2(JSONObject jsonObject_Map) throws InterruptedException, java.text.ParseException,  SQLException, InterruptedException, ClassNotFoundException, FileNotFoundException, IOException, ParseException
	{

		logger.log(LogStatus.INFO, "Validating DB response"); 

		JSONObject jsonObjectMap_Supp =dataGenerator.subArrayCreation(jsonObject_Map, "Address", 0);
		JSONObject jsonObjectMap_Address = dataGenerator.subArrayCreation(jsonObject_Map, "Address", 1);
		
		Map<String,String> DbMap=new HashMap<String, String>();

		dataGenerator.patientZipScenario(jsonObjectMap_Supp, jsonObjectMap_Address);

		DataGeneratorClient.objectCharTruncation(jsonObject_Map, "PatientFirstName", 30);

		jsonObject_Map=dataGenerator.IsPatientNewbornJsonDB(jsonObject_Map);

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientsql_Ohio,jsonObject_Map.get("PatientFirstName").toString(), 
				jsonObject_Map.get("SequenceID").toString()));		
		
		dataBaseVerifier.compareMap(DbMap,jsonObject_Map);

	}
	
	
}