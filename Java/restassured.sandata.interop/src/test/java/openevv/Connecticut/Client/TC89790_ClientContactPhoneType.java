package openevv.Connecticut.Client;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import static io.restassured.RestAssured.given;
import java.io.IOException;

//Test Case 89790:Open EVV-Client-Validate (mix) - ClientContactPhoneType field/format

import com.globalMethods.core.Assertion_DbVerifier;
public class TC89790_ClientContactPhoneType extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	// Case-1 Testing with valid value and format
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89790_OpenEVV_ClientContactPhoneType_Business() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89790_OpenEVV_ClientContactPhoneType_Business");
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientContactPhoneType", "Business");


		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));


		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));

	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89790_OpenEVV_ClientContactPhoneType_Home() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89790_OpenEVV_ClientContactPhoneType_Home");
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientContactPhoneType", "Home");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));

	}//Case-1b

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89790_OpenEVV_ClientContactPhoneType_Mobile() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89790_OpenEVV_ClientContactPhoneType_Mobile");
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientContactPhoneType", "Mobile");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));

	}//Case-1c

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89790_OpenEVV_ClientContactPhoneType_others() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89790_OpenEVV_ClientContactPhoneType_others");
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientContactPhoneType", "Other");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));

	}

	// Case-2 Testing with invalid value and format
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89790_OpenEVV_ClientContactPhoneType_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89790_OpenEVV_ClientContactPhoneType_invalid");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientContactPhoneType", "C67hyu");
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString());   

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientContactPhoneType format is incorrect."));
	}

	// Case-3 Testing with dashes not allowed
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89790_OpenEVV_ClientContactPhoneType_with_space_dash() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89790_OpenEVV_ClientContactPhoneType_with_space_dash");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientContactPhoneType", "C----a_lientfname");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientContactPhoneType length is invalid."));
	}

	// Case-4 Testing with leading spaces in front
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89790_OpenEVV_ClientContactPhoneType_specialchar() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89790_OpenEVV_ClientContactPhoneType_specialchar");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientContactPhoneType", " Home");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientContactPhoneType format is incorrect."));
	}

	// Case-5 Testing with leading spaces in end
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89790_OpenEVV_ClientContactPhoneType_with_spaces() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89790_OpenEVV_ClientContactPhoneType_with_spaces");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientContactPhoneType", "Home ");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientContactPhoneType format is incorrect."));
	}

}
