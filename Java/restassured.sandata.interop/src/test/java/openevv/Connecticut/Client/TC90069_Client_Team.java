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

//To validate the valid Team field formats/values

public class TC90069_Client_Team extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	// Case-1 Testing with invalid Team field formats/values
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90069_OpenEVV_Client_Team_invalidformat() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90069_OpenEVV_Client_Team_invalidformat");
		//json_parser("client") used to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		//js.put("Borough",CommonMethods.generateRandomNumberOfFixLength(2));
		js.put("Team", "14A24");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Team length is invalid. The length should be between 0 and 4."));

	}
	// Case-2 Testing with valid Team field formats/values
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90069_OpenEVV_Client_Team_validfieldcombination() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90069_OpenEVV_Client_Team_validfieldcombination");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Team", "ABCD");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	// Case-3 Testing with valid numeric Team field formats/values
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90069_OpenEVV_Client_Team_validcombinationswithnumber() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90069_OpenEVV_Client_Team_validcombinationswithnumber");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Team", "1122");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	// Case-4 Testing with invalid format with space and numeric Team field formats/values
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90069_OpenEVV_Client_Team_invalidformatwith_heading_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90069_OpenEVV_Client_Team_invalidformatwith_heading_space");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Team", " 1122");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Team length is invalid. The length should be between 0 and 4."));
	}
	// Case-5 Testing with invalid format with space and numeric team field formats/values
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90069_OpenEVV_Client_Team_leading_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90069_OpenEVV_Client_Team_leading_space");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Team", "1122 ");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Team length is invalid. The length should be between 0 and 4."));
	}
	// Case-6 Testing with invalid format with space and numeric team field formats/values
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90069_OpenEVV_Client_Team_invalidformatwithspecialchar() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90069_OpenEVV_Client_Team_invalidformatwithspecialchar");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Team", "11#2");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Team format is incorrect."));
	}
	// Case-7 Testing with invalid format with space and numeric Team field formats/values
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90069_OpenEVV_Client_Team_invalidformatwithspecialcharscombination() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90069_OpenEVV_Client_Team_invalidformatwithspecialcharscombination");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		js.put("Team", "AA#2");

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The Team format is incorrect."));
	}
}
