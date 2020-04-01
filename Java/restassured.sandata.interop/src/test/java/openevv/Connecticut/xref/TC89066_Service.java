/**
 * 
 */
package openevv.Connecticut.xref;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author RRohiteshwar
 *
 */

//Test Case 89066:Inter-op-Open EVV-Xref- Services description should be valid.

public class TC89066_Service extends BaseTest
{

	//To validate the valid Service as 12 alpha numeric value
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89066_OpenEVV_XRef_Service_valid_equal_12() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89060_OpenEVV_XRef_Acc_num_valid_less_4");  // adding method name info via logger

		logger.log(LogStatus.INFO, "To validate the valid Account number less than  10"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Service", CommonMethods.generateRandomStringOfFixLength(12));
		logger.log(LogStatus.INFO, "Passing Service as Random ");
		CommonMethods.validateResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	}

	//To validate the invalid Service alphanumeric value more than 12
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89066_OpenEVV_XRef_Service_invalid_more_than_12() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89066_OpenEVV_XRef_Service_invalid_more_than_12");  // adding method name info via logger

		logger.log(LogStatus.INFO, "To validate the invalid Service alphanumeric value more than 12"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Service", CommonMethods.generateRandomStringOfFixLength(13));
		logger.log(LogStatus.INFO, "Passing Service as Random ");

		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The Service format is incorrect. The record should satisfy this regular expression"));

		//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid Service alphanumeric value less than 1	
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89066_OpenEVV_XRef_Service_invalid_less_than_1() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89066_OpenEVV_XRef_Service_invalid_less_than_1");  // adding method name info via logger

		logger.log(LogStatus.INFO, "To validate the invalid Service alphanumeric value less than 1"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Service", "");

		logger.log(LogStatus.INFO, "Passing Service as Random ");

		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The Service format is incorrect. The record should satisfy this regular expression"));

		//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid Service with special character
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89066_OpenEVV_XRef_Service_invalid_special_char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89066_OpenEVV_XRef_Service_invalid_special_char");  // adding method name info via logger

		logger.log(LogStatus.INFO, "To validate the invalid Service with special character"); // adding what you are verifing


		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Service", CommonMethods.generateSpecialChar(6));

		logger.log(LogStatus.INFO, "Passing Service as Random ");
		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The Service format is incorrect."));

		//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid Service with leading space
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89066_OpenEVV_XRef_Service_invalid_leading_Space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89066_OpenEVV_XRef_Service_invalid_leading_Space");  // adding method name info via logger

		logger.log(LogStatus.INFO, "To validate the invalid Service with leading space"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Service"," " + CommonMethods.generateRandomNumberOfFixLength(6));
		logger.log(LogStatus.INFO, "Passing Service as Random ");
		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The Service format is incorrect. The record should satisfy this regular expression"));

		//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid Service with trailing space
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89066_OpenEVV_XRef_Service_invalid_trailing_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89066_OpenEVV_XRef_Service_invalid_trailing_space");  // adding method name info via logger

		logger.log(LogStatus.INFO, "To validate the invalid Service with trailing space"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Service",CommonMethods.generateRandomNumberOfFixLength(6)+" ");
		logger.log(LogStatus.INFO, "Passing Service as Random ");
		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The Service format is incorrect. The record should satisfy this regular expression"));

		//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}


}
