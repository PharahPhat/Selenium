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
import java.io.IOException;

//Test Case 88368:Open EVV-Client-Validate (mix) - ClientZip field formats/values

import com.globalMethods.core.Assertion_DbVerifier; public class TC88368_ClientZip extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88368_OpenEVV_ClientZip_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88368_OpenEVV_ClientZip_valid");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientZip", "123456789");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));


		logger.log(LogStatus.INFO, "Validating Json response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains( "\"reason\": \"Transaction Received.\","));
	}

	//******************************************************************
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88368_OpenEVV_ClientZip_with_dash_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88368_OpenEVV_ClientZip_with_dash_valid");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		//js.put("ClientLastName", DataClient.generatePatientLastName());
		js.put("ClientZip", "32111-1232");
		//	js.put("ClientLastName", "Null");
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));


		logger.log(LogStatus.INFO, "Validating Json response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88368_OpenEVV_ClientZip_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88368_OpenEVV_ClientZip_null");
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");

		new DataGeneratorClient();
		JSONObject js = (JSONObject) jsonArray.get(0);
		js.put("ClientZip", null);
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
	
		logger.log(LogStatus.INFO, "Validating Json response ");
		System.out.println("failed");
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientZip cannot be null."));
	}

	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88368_OpenEVV_ClientZip_invalid_starting_with_0() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88368_OpenEVV_ClientZip_invalid_starting_with_0");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientZip", "023121234");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88368_OpenEVV_ClientZip_invalid_combinations() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88368_OpenEVV_ClientZip_invalid_combinations");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientZip", 003121234);
	
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));


		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validate with expected result	
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientZip format is incorrect."));
	}
}