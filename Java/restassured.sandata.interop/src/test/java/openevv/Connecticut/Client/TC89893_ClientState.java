package openevv.Connecticut.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 89893:Open EVV-Client-Validate (mix) - ClientState field/format
import com.globalMethods.core.Assertion_DbVerifier; public class TC89893_ClientState extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the valid ClientState
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89893_OpenEVV_ClientState_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC89893_OpenEVV_ClientState_valid");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject jsonObject = (JSONObject) j.get(0);
		jsonObject.put("ClientState", DataGeneratorClient.generateClientState());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		logger.log(LogStatus.INFO, "Validating Json response ");

	assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject);
	}

	//To validate the invalid ClientState
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89893_OpenEVV_ClientState_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89893_OpenEVV_ClientState_invalid");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientState", "AP");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState format is incorrect."));

	}

	//To validate the invalid ClientState length
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89893_OpenEVV_ClientState_invalid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89893_OpenEVV_ClientState_invalid_length");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientState", "ALM");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState length is invalid. The length should be between 0 and 2."));
	}

	//To validate the numeric value in ClientState
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89893_OpenEVV_ClientState_Alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89893_OpenEVV_ClientState_Alphanumeric");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientState", "N1");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState format is incorrect."));
	}

	//To validate the ClientState with trailing spaces
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89893_OpenEVV_ClientState_trailing_spaces() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89893_OpenEVV_ClientState_trailing_spaces");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientState", "NY ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState length is invalid. The length should be between 0 and 2."));
	}

	//To validate the ClientState with leading spaces
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89893_OpenEVV_ClientState_leading_spaces() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89893_OpenEVV_ClientState_leading_spaces");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientState", " NY");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState length is invalid. The length should be between 0 and 2."));
	}

	//To validate the missing ClientState 
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89893_OpenEVV_ClientState_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89893_OpenEVV_ClientState_null");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientState", "");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientState format is incorrect."));
	}

}