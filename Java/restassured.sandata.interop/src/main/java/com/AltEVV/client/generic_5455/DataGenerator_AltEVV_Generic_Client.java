package com.AltEVV.client.generic_5455;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

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

public class DataGenerator_AltEVV_Generic_Client extends BaseTest{

	UniqueJsonGenerator_AltEVV_Generic_Client uniqueJsonGenerator=new UniqueJsonGenerator_AltEVV_Generic_Client();

	public void assertFailErrorMessage(String bodyAsString, String Errormesssage )
	{
		logger.log(LogStatus.INFO, "Validating JSON response failed case");

		//Assert.assertTrue(bodyAsString.contains("\"status\": null,"));

		Assert.assertTrue(bodyAsString.contains(Errormesssage));


	}
	
	public  JSONObject subArrayCreation(JSONObject jsonObject,  String subArrayname, int indexofSubArray) throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException
	{
		JSONArray jsonArrayAdd = 	(JSONArray) jsonObject.get(subArrayname);
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayAdd.get(indexofSubArray);

		return jsonObjectAdd;
	}
}
