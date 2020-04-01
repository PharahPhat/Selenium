package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

//Test Case 89805:Open EVV-Client-Validate (mix) - ClientDesigneeEndDate field formats/values

public class TC89805_ClientDesigneeEndDate extends BaseTest { 
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	// Case-1 Testing with valid combination of ClientDesigneeEndDate
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89805_OpenEVV_ClientDesigneeEndDate_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89805_OpenEVV_ClientDesigneeEndDate_valid");
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeEndDate", CommonMethods.generateTodayDate_YYYY_MM_dd()+ "T10:47:57Z");
		js.put("ClientDesigneeStartDate", CommonMethods.generatePastDate_YYYY_MM_dd()+ "T11:47:57Z");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));

	}

	// Case-2 Testing with invalid combination of ClientDesigneeEndDate
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89805_OpenEVV_ClientDesigneeEndDate_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89805_OpenEVV_ClientDesigneeEndDate_invalid");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeEndDate", "1999-15-15T22:20:00Z");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));

		//Assert.assertTrue(bodyAsString1.contains("\"ErrorCode\": \"001\","));

		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeEndDate format is incorrect."));
	}

	// Case-3 Testing with invalid format combination of ClientDesigneeEndDate
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89805_OpenEVV_ClientDesigneeEndDate_invalidformatcombination() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89805_OpenEVV_ClientDesigneeEndDate_invalidformatcombination");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeEndDate", "01-1999-15T22:20:00Z");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));

		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeEndDate format is incorrect."));
	}

	// Case-4 Testing with invalid format with "-"combination of ClientDesigneeEndDate
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89805_OpenEVV_ClientDesigneeEndDate_with_DDMMMYYYY_Time_formate() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89805_OpenEVV_ClientDesigneeEndDate_with_specialchar");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeEndDate", "15-01-1999T22:20:00Z");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));

		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeEndDate format is incorrect."));
	}

	// Case-5 Testing with invalid format with "-,-"combination of ClientDesigneeEndDate
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89805_OpenEVV_ClientDesigneeEndDate_invalid_combination_with_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89805_OpenEVV_ClientDesigneeEndDate_invalid_combination_with_specialchars");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeEndDate", "1999-01-1522:20:00@");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));

		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeEndDate format is incorrect. The record should satisfy the date format"));
	}

	// Case-6 Testing with invalid format with "-,-"combination of ClientDesigneeEndDate
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89805_OpenEVV_ClientDesigneeEndDate_date_combination() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89805_OpenEVV_ClientDesigneeEndDate_date_combination");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeEndDate", "1999-01-15T22:20:00");
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 


		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));

		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeEndDate format is incorrect. The record should satisfy the date format"));
	}

	// Case-7 Testing with invalid format with all combination of ClientDesigneeEndDate
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89805_OpenEVV_ClientDesigneeEndDate_invalid_combination() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89805_OpenEVV_ClientDesigneeEndDate_invalid_combination");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeEndDate", "1999-01-15");


		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));

		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeEndDate format is incorrect."));
	}

	// Case-8 Testing with invalid format with null combination of ClientDesigneeEndDate
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89805_OpenEVV_ClientDesigneeEndDate_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89805_OpenEVV_ClientDesigneeEndDate_null");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeEndDate", null);
		js.put("ClientDesigneeStatus", "02");
		
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}

	// Case-9 Testing format with >10 digits combination of ClientDesigneeEndDate  
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89805_OpenEVV_ClientDesigneeEndDate_multiplecombinations() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89805_OpenEVV_ClientDesigneeEndDate_multiplecombinations");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientDesigneeEndDate", "1999-01-15T");
		//	js.put("ClientLastName", "Absjdsshfsfhsfkh");
		//	js.put("ClientLastName", "Null");
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 


		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));

		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientDesigneeEndDate format is incorrect."));
	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89805_OpenEVV_ClientDesigneeEndDate_combinations() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89805_OpenEVV_ClientDesigneeStart_EndDate_combinations");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientDesigneeFirstName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("ClientDesigneeLastName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("ClientDesigneeStartDate", "2018-11-14T22:20:00Z");
		js.put("ClientDesigneeEndDate", "2018-11-13T22:21:00Z");
		js.put("ClientDesigneeStatus", null);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientDesigneeStartDate must always be less than the ClientDesigneeEndDate. The ClientDesigneeStartDate must be less than current date. The ClientDesigneeEndDate must be today.");
	}
}
