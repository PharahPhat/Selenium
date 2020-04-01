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
//Test Case 89760:Open EVV-Client-Validate (mix) - ContactZip field formats/values 

public class OpenEVV_TC89760_ContactZip extends BaseTest
{	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//case 1---- - ContactZip= "32121-4321"  (valid Case)
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89760_OpenEVV_ContactZip_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89760_OpenEVV_ContactZip_valid");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactZip", "32121-4321");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains( "\"reason\": \"Transaction Received.\","));

	}

	//case 2 ---- - - ContactZip= "02312-1234"  (valid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89760_OpenEVV_ContactZip_with_dash_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89760_OpenEVV_ContactZip_with_dash_valid");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactZip", "02312-1234");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains( "\"reason\": \"Transaction Received.\","));

	}

	//case 3 ---- - ContactZip= "00312-1234"  (valid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89760_OpenEVV_ContactZip_starting_with_0_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89760_OpenEVV_ContactZip_starting_with_0_valid");

		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactZip", "00312-1234");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains( "\"reason\": \"Transaction Received.\","));

	}

	//case 4---- -- ContactZip= "321214321""  (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89760_OpenEVV_ContactZip_length_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89760_OpenEVV_ContactZip_length_invalid");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactZip", "3212143219");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ContactZip format is incorrect. The record should satisfy this regular expression"));

	}

	//case 5 ---- --  dashes not allowed:- ContactZip= "321-21-4321"  (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89760_OpenEVV_ContactZip_with_number_dash_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89760_OpenEVV_ContactZip_with_number_dash_invalid");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactZip", "321-21-4321");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ContactZip format is incorrect. The record should satisfy this regular expression"));

	}

	//case 6---- -- less than 9 digits not allowed:- ContactZip= "87654321"  (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89760_OpenEVV_ContactZip_with_morelength_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89760_OpenEVV_ContactZip_with_morelength_invalid");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactZip", "87654321");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ContactZip format is incorrect. The record should satisfy this regular expression"));

	}	

	//case 7 ----alphabetics not allowed:- ContactZip=  "Z87654321"   (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89760_OpenEVV_ContactZip_starting_with_alpha_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89760_OpenEVV_ContactZip_starting_with_alpha_invalid");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactZip", "Z87654321");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ContactZip format is incorrect. The record should satisfy this regular expression"));

	}	

	//case 8---- -- embedded alphas not allowed:- ContactZip=  "098A21234"   (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89760_OpenEVV_ContactZip_starting_with_0_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89760_OpenEVV_ContactZip_starting_with_0_invalid");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactZip", "098A21234");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ContactZip format is incorrect. The record should satisfy this regular expression"));

	}	

	//case 9---- special characters not allowed:- ContactZip=  "11213@789"  (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89760_OpenEVV_ContactZip_with_specialchar_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89760_OpenEVV_ContactZip_with_specialchar_invalid");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactZip", "11213@789");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ContactZip format is incorrect. The record should satisfy this regular expression"));

	}	

	//case 10---- -- trailing spaces:- ContactZip=  "3121234  "    (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89760_OpenEVV_ContactZip_with_leadingspace_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89760_OpenEVV_ContactZip_with_leadingspace_invalid");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ContactZip", "3121234  ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ContactZip format is incorrect. The record should satisfy this regular expression"));

	}

}