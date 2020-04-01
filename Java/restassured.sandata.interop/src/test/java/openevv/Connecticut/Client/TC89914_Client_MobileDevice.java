package openevv.Connecticut.Client;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

//Test Case 89914:Open EVV-Client-Validate (mix) - MobileDevice field/format
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class TC89914_Client_MobileDevice extends BaseTest
{	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//case 1---- - valid value and format:- MobileDevice= Y|N  in caps (valid Case)
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	
	public void TC89914_OpenEVV_MobileDevice_valid_1() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89914_OpenEVV_MobileDevice_valid_1");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("MobileDevice", "Y");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//case 2---- - valid value and format:- MobileDevice= Y|N in caps (valid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89914_OpenEVV_MobileDevice_valid_2() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89914_OpenEVV_MobileDevice_valid_2");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("MobileDevice", "N");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//case 3---- - valid value and format:- MobileDevice= Y|N  in small(invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89914_OpenEVV_MobileDevice_invalid_1() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89914_OpenEVV_MobileDevice_invalid_1");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("MobileDevice", "y");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The MobileDevice format is incorrect. The record should satisfy this regular expression"));

	}

	//case 4---- - valid value and format:- MobileDevice= Y|N in small (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89914_OpenEVV_MobileDevice_invalid_2() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89914_OpenEVV_MobileDevice_invalid_2");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("MobileDevice", "n");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The MobileDevice format is incorrect. The record should satisfy this regular expression"));

	}

	//case 5---- - valid value with leading space and format:- MobileDevice= Y|N  in caps (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89914_OpenEVV_MobileDevice_invalid_3() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89914_OpenEVV_MobileDevice_invalid_3");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("MobileDevice", " Y");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The MobileDevice format is incorrect. The record should satisfy this regular expression"));

	}

	//case 6---- - valid value with trailing space and format:- MobileDevice= Y|N in caps (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89914_OpenEVV_MobileDevice_invalid_4() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89914_OpenEVV_MobileDevice_invalid_4");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("MobileDevice", "N ");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The MobileDevice format is incorrect. The record should satisfy this regular expression"));

	}
	//case 7---- -  dashes not allowed:- MobileDevice = ">1 digits"    (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89914_OpenEVV_MobileDevice_invalid_5() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89914_OpenEVV_MobileDevice_invalid_5");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("MobileDevice", "NOT");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The MobileDevice format is incorrect. The record should satisfy this regular expression"));

	}	
}