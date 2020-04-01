package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

//Test Case 90277:Open EVV-Client-Validate (mix) - ClientState field/format under ClientAddress

public class TC90277_ClientState_Under_ClientAddress extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the valid ClientState
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90277_OpenEVV_ClientState_under_ClientAddress_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC90277_OpenEVV_ClientState_under_ClientAddress_valid");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientState", DataClient.generateClientState()); 

		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
	}

	//To validate the invalid ClientState
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90277_OpenEVV_ClientState_under_ClientAddress_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC90277_OpenEVV_ClientState_under_ClientAddress_invalid");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientState", "XY");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));

		logger.log(LogStatus.INFO, "Validating Json response ");

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientState format is incorrect.");
	}

	//To validate the invalid ClientState length
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90277_OpenEVV_ClientState_under_ClientAddress_invalid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC90277_OpenEVV_ClientState_under_ClientAddress_invalid_length");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientState", "ALM"); 

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientState length is invalid. The length should be between 2 and 2.");
	}

	//To validate the numeric value in ClientState
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90277_OpenEVV_ClientState_under_ClientAddress_Alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC90277_OpenEVV_ClientState_under_ClientAddress_Alphanumeric");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


        JSONObject js = (JSONObject) j.get(0);
		
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientState", "N1"); 

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientState format is incorrect.");
	}

	//To validate the ClientState with leading spaces
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90277_OpenEVV_ClientState_under_ClientAddress_leading_spaces() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC90277_OpenEVV_ClientState_under_ClientAddress_leading_spaces");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientState", " NY ");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientState length is invalid. The length should be between 2 and 2.");
	}

	//To validate the missing ClientState 
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90277_OpenEVV_ClientState_under_ClientAddress_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC90277_OpenEVV_ClientState_under_ClientAddress_null");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");


		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientState", null); 

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientState cannot be null.");
	}

}