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

public class TC89932_Client_BillRate extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the valid numeric BillRate length
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89932_OpenEVV_valid_numeric_BillRate() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89932_OpenEVV_valid_numeric_BillRate");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("BillRate", "1.2345");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid BillRate length
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89932_OpenEVV_invalid_BillRate_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89932_OpenEVV_invalid_BillRate_length");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("BillRate", "1.23456");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The BillRate length is invalid. The length should be between 0 and 6."));
	}

	//To validate the BillRate with comma
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89932_OpenEVV_BillRate_comma() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89932_OpenEVV_BillRate_comma");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("BillRate", "1,2345");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The BillRate format is incorrect"));

	}

	//To validate the BillRate with underscore
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89932_OpenEVV_BillRate_underscore() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89932_OpenEVV_BillRate_underscore");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("BillRate", "1_2345");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The BillRate format is incorrect"));
	}

	//To validate the BillRate with leading space
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89932_OpenEVV_leading_space_BillRate() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89932_OpenEVV_leading_space_BillRate");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("BillRate", " " + "1.234");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The BillRate format is incorrect"));
	}

	//To validate the BillRate with trailing space
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89932_OpenEVV_trailing_space_BillRate() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89932_OpenEVV_trailing_space_BillRate");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("BillRate", "1.234" + " ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The BillRate format is incorrect"));

	}

	//To validate the negative BillRate
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89932_OpenEVV_negative_BillRate() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89932_OpenEVV_negative_BillRate");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("BillRate", "-1.23");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");


		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The BillRate format is incorrect"));

	}

}