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

// Test Case 90275:Open EVV -Client-Validate (mix) - ClientPhone field formats/values under ClientPhone

public class TC90275_ClientPhone extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	// case-1 To validate the valid ClientPhone having numeric value equal to 10
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90275_OpenEVV_ClientPhone_valid_numeric_equal_10() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90275_OpenEVV_ClientPhone_valid_numeric_equal_10");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhone", "8923462310"); 

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));


		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//case-2 To validate the ClientPhone having numeric <10 digits
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90275_OpenEVV_ClientPhone_invalid_numeric_9digits() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90275_OpenEVV_ClientPhone_invalid_numeric_9digits");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhone", CommonMethods.generateRandomNumberOfFixLength(9)); 

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));


		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientPhone format is incorrect."));
	}

	//case-3 To validate the invalid ClientPhone having numeric >10 digits 
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90275_OpenEVV_ClientPhone_invalid_numeric_11digit() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90275_OpenEVV_ClientPhone_invalid_numeric_11digit");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhone", CommonMethods.generateRandomNumberOfFixLength(11));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientPhone length is invalid. The length should be between 1 and 10."));
	}

	//case-4 To validate the valid ClientPhone having numeric value 10digits with heading 0
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90275_OpenEVV_ClientPhone_valid_numeric_heading_0() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90275_OpenEVV_ClientPhone_valid_numeric_heading_0");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhone", "000" +CommonMethods.generateRandomNumberOfFixLength(7));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));


		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//case-5 To validate the valid ClientPhone having numeric value with heading space
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90275_OpenEVV_invalid_ClientPhone_numeric_with_headingspace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90275_OpenEVV_invalid_ClientPhone_numeric_with_headingspace");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhone", " " +CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));


		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientPhone format is incorrect."));
	}

	//case-6 To validate the valid ClientPhone having numeric value  with Leading space
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90275_OpenEVV_invalid_ClientPhone_numeric_with_leadingspace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90275_OpenEVV_invalid_ClientPhone_numeric_with_leadingspace");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhone", CommonMethods.generateRandomNumberOfFixLength(9) + " ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));


		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientPhone format is incorrect."));
	}

	//case-7 To validate the invalid ClientPhone having special chars
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90275_OpenEVV_invalid_ClientPhone_with_Specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90275_OpenEVV_invalid_ClientPhone_with_Specialchars");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhone", "#@" +CommonMethods.generateRandomNumberOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));


		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientPhone format is incorrect."));
	}

	//case-8 To validate the invalid ClientPhone having Alphanumeric
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90275_OpenEVV_invalid_ClientPhone_Alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90275_OpenEVV_invalid_ClientPhone_Alphanumeric");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhone", CommonMethods.generateRandomAlphaNumeric(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientPhone format is incorrect."));
	}

	//Case-9	 To validate the invalid ClientPhone with null
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90275_OpenEVV_invalid_ClientPhone_with_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90275_OpenEVV_invalid_ClientPhone_with_null");
		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhone", null);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));


		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientPhone cannot be null."));
	}
}