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

//Test Case 89026:Open EVV-Client-Validate (mix) - ClientEmailAddress field formats/values

public class OpenEVV_TC89026_ClientEmailAddress extends BaseTest
{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89026_OpenEVV_ClientEmailAddress_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89026_OpenEVV_ClientEmailAddress_valid");
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientEmailAddress","abcxyz@mail.com");
	        
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Validating the expected Result	
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89026_OpenEVV_ClientEmailAddress_valid_format() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89026_OpenEVV_ClientEmailAddress_valid_format");
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientEmailAddress","ABCDQWERT@mail.com");
	
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 
	     
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89026_OpenEVV_ClientEmailAddress_valid_combination() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89026_OpenEVV_ClientEmailAddress_valid_combination");
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientEmailAddress","testabc12@mailinator.com");
	
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 
		    
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
	
		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString1.contains( "\"reason\": \"Transaction Received.\","));
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
    public void TC89026_OpenEVV_ClientEmailAddress_invalidformat() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89026_OpenEVV_ClientEmailAddress_invalidformat");
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientEmailAddress","abctestgn12");
	
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 
		
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		//Assert.assertTrue(bodyAsString1.contains("\"statuscode\": \"200\","));
		//Assert.assertTrue(bodyAsString1.contains("\"ClientLastName\": \"Absjdsshfsfhsfkh\","));
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89026_OpenEVV_ClientEmailAddress_withoutcom_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89026_OpenEVV_ClientEmailAddress_withoutcom_invalid");
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientEmailAddress","testabc12@mailinator");
	
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
	
		//Validating the expected Result
		Assert.assertTrue(bodyAsString1.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString1.contains("ERROR: The ClientEmailAddress format is incorrect."));
	}


}
