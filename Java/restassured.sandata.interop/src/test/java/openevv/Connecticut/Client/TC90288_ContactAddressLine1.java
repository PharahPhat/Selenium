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
import java.sql.SQLException;

// Test Case 90288:Open EVV-Client-Validate (mix) - ContactAddressLine1 field formats/values under ClientAddress

public class TC90288_ContactAddressLine1 extends BaseTest { 
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	// Case-1 To validate the valid ContactAddressLine1 with string
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90288_OpenEVV_Valid_ContactAddressLine1_with_string() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC90288_OpenEVV_Valid_ContactAddressLine1_with_string");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactAddressLine1", CommonMethods.generateRandomStringOfFixLength(3) + " " +CommonMethods.generateRandomStringOfFixLength(4));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);	
	}

	//case-2 To validate the ContactAddressLine1 without spaces
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90288_OpenEVV_Valid_ContactAddressLine1_without_spaces() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC90288_OpenEVV_Valid_ContactAddressLine1_without_spaces");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));

		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);	
	}

	//case-3 To validate the valid ContactAddressLine1 heading space
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90288_OpenEVV_Valid_ContactAddressLine1_heading_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC90288_OpenEVV_Valid_ContactAddressLine1_heading_space");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactAddressLine1", " " + CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);	
	}

	//case-4 To validate the valid ContactAddressLine1 leading space
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90288_OpenEVV_Valid_ContactAddressLine1_leading_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC90288_OpenEVV_Valid_ContactAddressLine1_leading_space");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactAddressLine1", CommonMethods.generateRandomStringOfFixLength(4) +" ");

		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);	
	}

	//case-5 To validate the invalid ContactAddressLine1 length exceeds
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC90288_OpenEVV_invalid_ContactAddressLine1_length_exceeds() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90288_OpenEVV_invalid_ContactAddressLine1_length_exceeds");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactAddressLine1", CommonMethods.generateRandomStringOfFixLength(29) +" " +CommonMethods.generateRandomStringOfFixLength(6));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ContactAddressLine1 length is invalid. The length should be between 0 and 30."));
	}

	//case-6 To validate the invalid ContactAddressLine1 with special chars
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90288_OpenEVV_invalid_ContactAddressLine1_with_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90288_OpenEVV_invalid_ContactAddressLine1_with_specialchars");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactAddressLine1",CommonMethods.generateSpecialChar(20));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ContactAddressLine1 format is incorrect."));
	}

	//case-7 To validate the invalid ContactAddressLine1 with >30
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90288_OpenEVV_invalid_ContactAddressLine1_with_length_exceeds() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90288_OpenEVV_invalid_ContactAddressLine1_with_length_exceeds");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactAddressLine1", CommonMethods.generateRandomStringOfFixLength(34));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ContactAddressLine1 length is invalid. The length should be between 0 and 30."));
	}

	//case-8 To validate the valid ContactAddressLine1 with null
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90288_OpenEVV_valid_ContactAddressLine1_with_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC90288_OpenEVV_valid_ContactAddressLine1_with_null");

		//Using Reusable method to load client json
		//	JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactAddressLine1", null);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);	
	}

}