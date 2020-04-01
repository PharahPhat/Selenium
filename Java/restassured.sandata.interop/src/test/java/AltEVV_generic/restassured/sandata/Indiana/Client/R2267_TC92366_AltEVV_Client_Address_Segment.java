package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class R2267_TC92366_AltEVV_Client_Address_Segment extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	//Case-1 Testing without ClientOtherID field
	@Test(groups = {"All"})
	public void TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clientstate() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clientstate");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientState"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(0);
		js_s.remove("ClientState");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//Validating the expected Result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.memberClientStateNullError);
	}

	@Test(groups = {"All"})
	public void TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clientZIP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clientZIP");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientState"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(0);
		js_s.remove("ClientZip");


		logger.log(LogStatus.INFO, "Passing all parameters without ClientState");
		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientZip cannot be null.");
	}

	@Test(groups = {"All"})
	public void TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_cliencity() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_cliencity");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientState"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(0);
		js_s.remove("ClientCity");

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientCity cannot be null.");
	}

	@Test(groups = {"All"})
	public void TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clienaddress1() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clienaddress1");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientState"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(0);
		js_s.remove("ClientAddressLine1");

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1NullError);
	}

	@Test(groups = {"All"})
	public void TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clientstate_add() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC92366_OpenEVV_altEVV_Client_Validations_Address_Segment_without_clientstate_add");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientState"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(1);
		js_s.remove("ClientState");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//Validating the expected Result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientState cannot be null.");
	}
}
