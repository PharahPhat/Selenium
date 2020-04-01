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

//Test Case 88377:Open EVV - Verify error message on uploading client with null ClientFirstName

public class TC88377_ClientFirstName_null extends BaseTest
{	

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//case 1---- - "ClientFirstName": null (invalid Case)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88377_OpenEVV_ClientFirstName_invalid_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic
		// logger = extent.startTest("TC88377_OpenEVV_ClientFirstName_invalid_null");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", null);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		
		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientFirstName cannot be null."));

	}


}