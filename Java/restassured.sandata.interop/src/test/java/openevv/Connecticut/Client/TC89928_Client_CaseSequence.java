package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

//Test Case 89928:Open EVV-Client-Validate (mix) - CaseSequence field formats/values

public class TC89928_Client_CaseSequence extends BaseTest
{	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//case 1---- - valid value and format:- CaseSequence= "1234"   (invalid Case)
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89928_OpenEVV_CaseSequence_valid_case_1() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89928_OpenEVV_CaseSequence_valid_case_1");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseSequence", "1234");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		//	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//	
		//	Assert.assertTrue(bodyAsString.contains( "The ClientMedicalRecordNumber length is invalid. The length should be between 0 and 12."));
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//case 2---- - valid value and format:- CaseSequence= "1e23"   (valid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89928_OpenEVV_CaseSequence_valid_case_2() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89928_OpenEVV_CaseSequence_valid_case_2");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseSequence", "1234");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		//	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//	
		//	Assert.assertTrue(bodyAsString.contains( "The ClientMedicalRecordNumber length is invalid. The length should be between 0 and 12."));
		Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//case 3---- - valid value and format:- - CaseSequence= ">4 digits"  (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89928_OpenEVV_CaseSequence_invalid_case_1() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89928_OpenEVV_CaseSequence_invalid_case_1");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseSequence", "121223");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The CaseSequence length is invalid. The length should be between 0 and 4."));
		//	Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		//	Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//case 4---- - valid value and format:- - CaseSequence= "121##"   (Any Combination)  (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89928_OpenEVV_CaseSequence_invalid_case_2() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89928_OpenEVV_CaseSequence_invalid_case_2");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseSequence", "12@@##1223");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The CaseSequence length is invalid. The length should be between 0 and 4."));
		//	Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		//	Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//case 5---- - leading spaces:- CaseSequence = "  1234"    (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89928_OpenEVV_CaseSequence_invalid_case_3() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89928_OpenEVV_CaseSequence_invalid_case_2");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseSequence", " 1234");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The CaseSequence length is invalid. The length should be between 0 and 4."));
		//	Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		//	Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//case 6---- - trailing spaces:- CaseSequence = "1234 "    (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89928_OpenEVV_CaseSequence_invalid_case_4() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89928_OpenEVV_CaseSequence_invalid_case_4");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("CaseSequence", "1234 ");

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The CaseSequence length is invalid. The length should be between 0 and 4."));
		//	Assert.assertTrue(bodyAsString.contains(" \"status\": \"SUCCESS\","));
		//	Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}
}
