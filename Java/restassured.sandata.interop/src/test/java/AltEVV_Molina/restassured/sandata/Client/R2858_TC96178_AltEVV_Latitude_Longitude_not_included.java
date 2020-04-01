package AltEVV_Molina.restassured.sandata.Client;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import java.io.IOException;

import com.globalMethods.core.Assertion_DbVerifier; public class R2858_TC96178_AltEVV_Latitude_Longitude_not_included extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Case-1 Testing with least 1 address without a latitude and longitude
	@Test(groups = {"All"})
	public void R2858_TC96178_AltEVV_CreateClient_without_ClientAddressLatitude_ClientAddressLongitude_sub() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96178_AltEVV_CreateClient_without_ClientAddressLatitude_ClientAddressLongitude");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientAddressLatitude_ClientAddressLongitude"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) altEVVJsonArray.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");	
		JSONObject js3 = (JSONObject) js2.get(0);

		js3.remove("ClientAddressLatitude");
		js3.remove("ClientAddressLongitude");


		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		//Validating the expected Result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientAddressLongitude cannot be null");
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientAddressLatitude cannot be null.");

	}

	@Test(groups = {"All"})
	public void R2858_TC96178_AltEVV_CreateClient_without_ClientAddressLatitude_ClientAddressLongitude_address() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96178_AltEVV_CreateClient_without_ClientAddressLatitude_ClientAddressLongitude");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientAddressLatitude_ClientAddressLongitude"); 

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) altEVVJsonArray.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientAddress");	
		JSONObject js3 = (JSONObject) js2.get(1);

		js3.remove("ClientAddressLatitude");
		js3.remove("ClientAddressLongitude");


		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		//Validating the expected Result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientAddressLongitude cannot be null");
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientAddressLatitude cannot be null.");


	}

}