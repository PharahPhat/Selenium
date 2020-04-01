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
import java.sql.SQLException;

import com.globalMethods.core.Assertion_DbVerifier; public class R2858_TC93137_AltEVV_ClientID_field_DB extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void R2858_TC93137_AltEVV_ClientID_more_than_10chars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93137_AltEVV_ClientID_more_than_10chars");

		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", "92292345789");   // ---------->Case-1 (ClientID: >10 characters)

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientID value is incorrect. The length should be between 1 and 10.");

	}

	//Case-2 Testing with ClientID_String
	@Test(groups = {"All"})
	public void R2858_TC93137_AltEVV_ClientID_with_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93137_AltEVV_ClientID_with_String");

		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", CommonMethods.generateRandomAlphaNumeric(10));   

		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//Case-3 Testing with ClientID_null
	@Test(groups = {"All"})
	public void R2858_TC93137_AltEVV_ClientID_with_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93137_AltEVV_ClientID_with_null");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientID_with_null"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", null);  

		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}
}