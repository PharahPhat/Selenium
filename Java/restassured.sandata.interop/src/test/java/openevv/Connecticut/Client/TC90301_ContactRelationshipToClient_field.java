package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC90301_ContactRelationshipToClient_field extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the invalid Service length
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90301_OpenEVV_Client_ContactRelationshipToClient() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		
		// logger = extent.startTest("TC90301_OpenEVV_Client_ContactRelationshipToClient");

		
		System.out.println("**************Started executing positive scenario*************");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		
		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		System.out.println("Positive scenario Completed successfully");
		
		System.out.println("***************Started executing invalid value scenario**********");
		//Making json values dynamic		
		js.put("ContactRelationshipToClient", CommonMethods.generateRandomStringOfFixLength(4));

		bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ContactRelationshipToClient format is incorrect." ));
		System.out.println("Invalid Value scenario Completed successfully");
		//To validate the ContactRelationshipToClient with exceeding length
		
		js.put("ContactRelationshipToClient", CommonMethods.generateRandomStringOfFixLength(21));
		
		bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ContactRelationshipToClient length is invalid. The length should be between 0 and 20." ));
		System.out.println("Invalid length scenario Completed successfully");
		
			
		
	}
}
	

