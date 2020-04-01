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

public class TC89931_Client_CaseNumber extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the valid numeric CaseNumber length
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	
	public void TC89931_OpenEVV_valid_numeric_CaseNumber() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89931_OpenEVV_valid_numeric_CaseNumber");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseNumber", CommonMethods.generateRandomNumberOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid CaseNumber length
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89931_OpenEVV_invalid_CaseNumber_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89931_OpenEVV_invalid_CaseNumber_length");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseNumber", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The CaseNumber length is invalid. The length should be between 0 and 9."));
	}

	//To validate the CaseNumber with alphanumeric value
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89931_OpenEVV_alphanumeric_CaseNumber() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89931_OpenEVV_alphanumeric_CaseNumber");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseNumber", CommonMethods.generateRandomAlphaNumeric(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the CaseNumber with non numeric value
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89931_OpenEVV_nonnumeric_CaseNumber() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89931_OpenEVV_nonnumeric_CaseNumber");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseNumber", CommonMethods.generateRandomStringOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the CaseNumber with leading space
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89931_OpenEVV_leading_space_CaseNumber() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89931_OpenEVV_leading_space_CaseNumber");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseNumber", " " + CommonMethods.generateRandomNumberOfFixLength(6));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		

	}

	//To validate the CaseNumber with trailing space
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89931_OpenEVV_trailing_space_CaseNumber() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89931_OpenEVV_trailing_space_CaseNumber");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseNumber", CommonMethods.generateRandomNumberOfFixLength(6) + " ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		

	}

	//To validate the CaseNumber with special character
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89931_OpenEVV_specialCharacter_CaseNumber() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89931_OpenEVV_specialCharacter_CaseNumber");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseNumber", "@#1212");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		

	}

}