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

//Test Case 88385: Open EVV: Verify error messages on uploading client with invalid input to 'ClientGender'

public class TC88385_ClientGender extends BaseTest

{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//**************************  ClientGender:"MF" (>1) (invalid Case) ***************************

	//case 1---- where every tag is included and is populated with a correct value except the below given field. ClientGender:"MF" (>1)

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88385_OpenEVV_ClientGender_max_invalid_case() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88385_OpenEVV_ClientGender_max_invalid_case");
		
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientGender", "MF");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		
		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "The ClientGender length is invalid. The length should be between 0 and 1"));


	}

	//**************************************   ClientGender:"K" (Other than allowable values) (inValid Case)  ********************************

	//case 2 each tag, where every tag is included and is populated with a correct value except the below given field. ClientGender:"K" (Other than allowable values)  

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88385_OpenEVV_ClientGender_other_than_valid_char_invalid_case() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88385_OpenEVV_ClientGender_other_than_valid_char_invalid_case");
		
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientGender", "K");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientGender format is incorrect. The record should satisfy this regular expression"));

	}

	//**************************************   ClientGender:"1" (Other than allowable values)  (inValid Case)  ********************************

	//case 3 each tag, where every tag is included and is populated with a correct value except the below given field. ClientGender:"1" (Other than allowable values)  

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88385_OpenEVV_ClientGender_other_than_valid_num_invalid_case() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88385_OpenEVV_ClientGender_other_than_valid_num_invalid_case");
		
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientGender", "1");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		
		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientGender format is incorrect. The record should satisfy this regular expression"));

	}
}