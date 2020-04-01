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

//Test Case 88383:Open EVV: Verify error messages on uploading client with invalid input of 'ARNumber'

public class TC88383_Client_ARNumber extends BaseTest

{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();


	//**************************  ArNumber: "56781234568" (>10)(invalid Case) ***************************

	//case 1---- where every tag is included and is populated with a correct value except the below given field. ArNumber: "56781234568" (>10) 

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88383_OpenEVV_ARNumber_max_10_invalid_case() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88383_OpenEVV_ARNumber_max_10_invalid_case");
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ARNumber", "56781232364");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		
		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ARNumber length is invalid. The length should be between 0 and 10."));


	}


	//case 2 each tag, where every tag is included and is populated with a correct value except the below given field. ArNumber: "5678hdhe11" (Alpha numeric) 
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88383_OpenEVV_ARNumber_Alpha_Num_valid_case() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88383_OpenEVV_ARNumber_Alpha_Num_valid_case");
		
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ARNumber", "5678hdhe11");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		
		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}


	//case 3 each tag, where every tag is included and is populated with a correct value except the below given field. ArNumber: "dfhdheww" (Non numeric)  
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88383_OpenEVV_ARNumber_Non_Num_valid_case() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88383_OpenEVV_ARNumber_Non_Num_valid_case");
		
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ARNumber", "dfhdheww");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		
		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Transaction Received.\","));

	}

	//********************************************"   8373738" (starting with space) (Invalid Case) *****************************************

	//case 4 each tag, where every tag is included and is populated with a correct value except the below given field. ArNumber: "   8373738" (starting with space) 
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88383_OpenEVV_ARNumber_Starting_Space_invalid_case() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88383_OpenEVV_ARNumber_Starting_Space_invalid_case");
		
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ARNumber", "   8373738");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		
		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ARNumber format is incorrect."));


	}

	//********************************************"   ArNumber: "12@373738" (With special character) (Invalid Case)  *****************************************

	//case 5 each tag, where every tag is included and is populated with a correct value except the below given field. ArNumber: ArNumber: "12@373738" (With special character) 
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88383_OpenEVV_ARNumber_Special_Char_invalid_case() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88383_OpenEVV_ARNumber_Special_Char_invalid_case");
		
		//use method (json_parser) to load the json file
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ARNumber", "12@373738");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ARNumber format is incorrect."));


	}

}
