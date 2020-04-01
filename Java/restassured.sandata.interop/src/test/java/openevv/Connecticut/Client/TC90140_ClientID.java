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

public class TC90140_ClientID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	// Case-1 Testing with invalid null ClientID field
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90140_OpenEVV_invalid_ClientID_field_with_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90140_OpenEVV_invalid_ClientID_field_with_null");
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID",null);

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		CommonMethods.verifyjsonassertFailcase(bodyAsString1, globalVariables.ClientIDNullError);
	}

	// Case-2 Testing with invalid ClientID field with number >10
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90140_OpenEVV_invalid_ClientID_more_than_10_numbers() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90140_OpenEVV_invalid_ClientID_more_than_10_numbers");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(11));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		CommonMethods.verifyjsonassertFailcase(bodyAsString1, globalVariables.ClientIDformaterror);
	}

	// Case-3 Testing with valid ClientID field with Alphanumeric
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90140_OpenEVV_invalid_ClientID_with_alpha_numeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90140_OpenEVV_invalid_ClientID_with_alpha_numeric");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", CommonMethods.generateRandomAlphaNumeric(10));
		
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));


		logger.log(LogStatus.INFO, "Validating Json response ");

		CommonMethods.verifyjsonassertFailcase(bodyAsString1, globalVariables.ClientIDformaterror);
	}

	// Case-4 Testing with valid ClientID field with Non numeric
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90140_OpenEVV_invalid_ClientID_with_non_numeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90140_OpenEVV_invalid_ClientID_with_non_numeric");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", CommonMethods.generateRandomStringOfFixLength(7));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		CommonMethods.verifyjsonassertFailcase(bodyAsString1, globalVariables.ClientIDformaterror);

	}

	// Case-5 Testing with valid ClientID field with number and heading space
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90140_OpenEVV_invalid_ClientID_with_number_and_heading_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90140_OpenEVV_invalid_ClientID_with_number_and_heading_space");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", " " + CommonMethods.generateRandomNumberOfFixLength(6));

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientID is inconsistent across record. The ClientID should be the same between EvvClient, ClientAddress and ClientPhone."));
		CommonMethods.verifyjsonassertFailcase(bodyAsString1, globalVariables.ClientIDformaterror);
	}

	// Case-6 Testing with valid ClientID field with special char
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90140_OpenEVV_invalid_ClientID_with_specialchar() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90140_OpenEVV_invalid_ClientID_with_specialchar");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", "23" + CommonMethods.generateRandomStringOfFixLength(2) + "@");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));


		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientID format is incorrect."));
	}

}
