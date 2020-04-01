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

//TC89955 Open EVV-Client-Validate (mix) - ProgramCode field formats/values
public class TC89955_Client_ProgramCode extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	// Case-1 Testing with valid format
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89955_OpenEVV_ProgramCode_validcombination() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89955_OpenEVV_ProgramCode_validcombination");
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ProgramCode", "T22323N");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));

	}

	// Case-2 Testing with invalid format
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89955_OpenEVV_ProgramCode_with_Alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89955_OpenEVV_ProgramCode_with_Alphanumeric");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ProgramCode", "T22323NPAMN");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ProgramCode length is invalid."));
	}

	// Case-3 Testing with invalid format and combinations
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89955_OpenEVV_ProgramCode_with_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89955_OpenEVV_ProgramCode_with_specialchars");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ProgramCode", "T22#23N");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ProgramCode format is incorrect."));
	}

	// Case-4 Testing with invalid format and space combinations. 
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89955_OpenEVV_ProgramCode_heading_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89955_OpenEVV_ProgramCode_heading_space");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ProgramCode", " T342N");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ProgramCode format is incorrect."));
	}
}
