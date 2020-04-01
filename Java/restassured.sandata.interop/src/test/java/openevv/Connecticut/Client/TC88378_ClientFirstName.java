package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

//Test Case 88378:Open EVV - Client-Validate (mix) - ClientFirstName field formats/values

public class TC88378_ClientFirstName extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();



	//To validate the ClientFirstName any combination of alphabets
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void OpenEVV_ClientFirstName_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException

	{
		// logger = extent.startTest("OpenEVV_ClientFirstName_valid");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		
		//JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName",CommonMethods.generateRandomStringOfFixLength(30));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		
		//Assert.assertEquals(bodyAsString.contains(val1) Expected value, true Actual Value, "Response body contains Accout");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ClientFirstName = any combination of alphabets with leading space
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void OpenEVV_ClientFirstName_valid_LeadingSpace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException

	{
		// logger = extent.startTest("OpenEVV_ClientFirstName_valid_LeadingSpace");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", " "+ CommonMethods.generateRandomStringOfFixLength(28));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		
		//Assert.assertEquals(bodyAsString.contains(val1) Expected value, true Actual Value, "Response body contains Accout");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ClientFirstName = any combination of alphabets with Trailing space
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88378_OpenEVV_ClientFirstName_valid_any_com_alpha_TrailingSpace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException

	{
		
		// logger = extent.startTest("TC88378_OpenEVV_ClientFirstName_valid_any_com_alpha_TrailingSpace");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(28) + " ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Assert.assertEquals(bodyAsString.contains(val1) Expected value, true Actual Value, "Response body contains Accout");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ClientFirstName with Special character
	@Test(groups = {"All"})	@AdditionalInfo(module = "OpenEVV")
	public void TC88378_OpenEVV_ClientFirstName_valid_Special_char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic
		// logger = extent.startTest("TC88378_OpenEVV_ClientFirstName_valid_Special_char");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName",CommonMethods.generateRandomStringOfFixLength(5)  + "." + CommonMethods.generateRandomStringOfFixLength(5) + "'"+ CommonMethods.generateRandomStringOfFixLength(5) + "-" );

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//To validate the ClientFirstName with Special character other than these("." or " '  " or  "-" ) 
	@Test(groups = {"All"})	@AdditionalInfo(module = "OpenEVV")
	public void TC88378_OpenEVV_ClientFirstName_invalid_Special_char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic
		// logger = extent.startTest("TC88378_OpenEVV_ClientFirstName_invalid_Special_char");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", CommonMethods.generateSpecialChar(25));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains(" \"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientFirstName format is incorrect. The record should satisfy this regular expression"));

	}

	//To validate the ClientFirstName with invalid alphanumeric starting with alphabet
	@Test(groups = {"All"})	@AdditionalInfo(module = "OpenEVV")
	public void TC88378_OpenEVV_ClientFirstName_invalid_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic
		// logger = extent.startTest("TC88378_OpenEVV_ClientFirstName_invalid_alphanumeric");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", "alpha" +CommonMethods.generateRandomAlphaNumeric(12));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains(" \"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientFirstName format is incorrect. The record should satisfy this regular expression"));
	}

	//To validate the ClientFirstName with alphanumeric starting with number
	@Test(groups = {"All"})	@AdditionalInfo(module = "OpenEVV")
	public void TC88378_OpenEVV_ClientFirstName_invalid_alphanumeric_num() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic
		// logger = extent.startTest("TC88378_OpenEVV_ClientFirstName_invalid_alphanumeric_num");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", "1212" + CommonMethods.generateRandomAlphaNumeric(12));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains(" \"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientFirstName format is incorrect. The record should satisfy this regular expression"));
	}

	@Test(groups = {"All"})	@AdditionalInfo(module = "OpenEVV")
	public void TC88378_OpenEVV_ClientFirstName_invalid_alphabetic_30() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException

	{
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic
		// logger = extent.startTest("TC88378_OpenEVV_ClientFirstName_invalid_alphabetic_30");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", "1212" + CommonMethods.generateRandomStringOfFixLength(30));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains(" \"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientFirstName format is incorrect. The record should satisfy this regular expression"));
	}



}

