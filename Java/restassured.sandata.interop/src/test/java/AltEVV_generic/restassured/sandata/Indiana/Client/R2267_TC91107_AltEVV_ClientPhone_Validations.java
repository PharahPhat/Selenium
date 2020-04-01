package AltEVV_generic.restassured.sandata.Indiana.Client;
/**
 * @author Anupam
 *
 */
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import java.io.IOException;
import java.sql.SQLException;

//Test Case 91107: OpenEVV-altEVV- Client: Validate (mix)- ClientPhone field format/values

import com.globalMethods.core.Assertion_DbVerifier; 

public class R2267_TC91107_AltEVV_ClientPhone_Validations extends BaseTest { 
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	public static String Phnum, Phonenumber= "ani", id="LOC", val1;

	//Case-1 Testing with ClientPhone: >12 characters 
	@Test(groups = {"All"})
	public void TC91098_AltEVV_CreateClient_with_ClientPhone_more_than_10chars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC91098_AltEVV_CreateClient_with_ClientPhone_more_than_10chars");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson ClientPhone with more than 10chars"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);
		
		JSONArray js2 = (JSONArray) js.get("ClientPhone");	
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhoneNumber", CommonMethods.generateRandomNumberOfFixLength(11));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//Case-2 Testing with ClientPhone: <10 characters 
	@Test(groups = {"All"})
	public void TC91098_AltEVV_CreateClient_with_ClientPhone_less_than_10chars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC91098_AltEVV_CreateClient_with_ClientPhone_less_than_10chars");


		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);
		
		JSONArray js2 = (JSONArray) js.get("ClientPhone");	
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhoneNumber", CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//Case-3 Testing with valid ClientPhone: 10 characters 
	@Test(groups = {"All"})
	public void TC91098_AltEVV_CreateClient_with_ClientPhone_10chars_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC91098_AltEVV_CreateClient_with_ClientPhone_10chars_DB");

		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);
		JSONArray js2 = (JSONArray) js.get("ClientPhone");	
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("ClientPhone", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		logger.log(LogStatus.INFO, "Validating JSON response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));





	}
}
