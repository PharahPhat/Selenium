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

//Open EVV-Client-Validate (mix) - Area field formats/values

public class TC89964_Client_Area extends BaseTest 
{ 

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	// Case-1 Testing with invalid Area field formats/values
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89964_OpenEVV_Area_morecharlength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89964_OpenEVV_Area_morecharlength");
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Area","1234");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));

		Assert.assertTrue(bodyAsString1.contains("ERROR: The Area length is invalid. The length should be between 0 and 2."));

	}

	// Case-2 Testing with invalid Area field formats/values using spaces
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89964_OpenEVV_Area_Leadingspace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89964_OpenEVV_Area_Leadingspace");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Area", "123 ");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString1.contains("The Area format is incorrect. The record should satisfy this regular expression"));
	}

	// Case-3 Testing with invalid Area field formats/values using spaces at End
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89964_OpenEVV_Area_invalidcombinations_with_headingspace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89964_OpenEVV_Area_invalidcombinations_with_headingspace");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Area", " 123");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));

		Assert.assertTrue(bodyAsString1.contains("The Area format is incorrect. The record should satisfy this regular expression"));
	}

	// Case-4 Testing with valid format 
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89964_OpenEVV_Area_validformat() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, ClassNotFoundException, SQLException, java.text.ParseException
	{
		// logger = extent.startTest("TC89964_OpenEVV_Area_validformat");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("Area", "2A");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		assertionDbVerifier.jsonAssert_InboxClient_OpenEVV(bodyAsString1, js);

	}
}
