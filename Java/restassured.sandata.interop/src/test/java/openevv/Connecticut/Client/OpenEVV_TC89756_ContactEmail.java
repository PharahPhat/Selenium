package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

//Test Case 89756:Open EVV-Client-Validate (mix) - ContactEmail field formats/values

public class OpenEVV_TC89756_ContactEmail extends BaseTest
{	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//case 1---- - ContactEmail = "ClientLoginFN@mailinator.com"  (valid Case)
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89756_OpenEVV_ContactEmail_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89756_OpenEVV_ContactEmail_valid");
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ContactEmail", "ClientLoginFN@mailinator.com");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
	Assert.assertTrue(bodyAsString.contains( "\"reason\": \"Transaction Received.\","));
		
	}
	
	//case 2 ---- - ContactEmail = "ClientLoginFN12@mailinator.com"   (valid Case)
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89756_OpenEVV_ContactEmail_with_Aplhanumric_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89756_OpenEVV_ContactEmail_with_Aplhanumric_valid");
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ContactEmail", "ClientLoginFN12@mailinator.com");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
	Assert.assertTrue(bodyAsString.contains( "\"reason\": \"Transaction Received.\","));
		
	}
	
	//case 3 ---- - - ContactEmail  = "ClientLoginFN12"    (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89756_OpenEVV_ContactEmail_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89756_OpenEVV_ContactEmail_invalid");
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ContactEmail", "ClientLoginFN12");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	
	Assert.assertTrue(bodyAsString.contains( "ERROR: The ContactEmail format is incorrect. The record should satisfy this regular expression"));
	
	}
	
	//case 4 ---- -- ContactEmail  = "ClientLoginFN12@mailinator"   (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89756_OpenEVV_ContactEmail_with_number_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89756_OpenEVV_ContactEmail_with_number_invalid");
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ContactEmail", "ClientLoginFN12@mailinator");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	
	Assert.assertTrue(bodyAsString.contains( "ERROR: The ContactEmail format is incorrect. The record should satisfy this regular expression "));
	
	}
	
	//case 5 ---- -- - ContactEmail  = ">64 digits"   (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89756_OpenEVV_ContactEmail_with_string_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89756_OpenEVV_ContactEmail_with_string_invalid");
	//use method (json_parser) to load the json file
	// To make the values in JSON dynamic
	
	JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
	JSONObject js = (JSONObject) j.get(0);
	js.put("ContactEmail", "ClientLoginlfdkfdkfdalfhd32ewrwrwrewrfdsfdsgdftertet4534534543dfdsf43ewrwer432434dsrsdfsfdsfsfeFN@mailinator.com");
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
	
	// assert validation to verify the outcome
	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	
	Assert.assertTrue(bodyAsString.contains( "ERROR: The ContactEmail length is invalid. The length should be between 0 and 64."));
	
	}
	
}