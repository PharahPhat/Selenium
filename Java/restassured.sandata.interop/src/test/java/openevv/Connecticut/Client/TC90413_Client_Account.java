package openevv.Connecticut.Client;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

// Test Case 90413:Open EVV-Client-Validate (mix) - Weekend field formats/values

import com.globalMethods.core.Assertion_DbVerifier; public class TC90413_Client_Account extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	//To validate the invalid Account number "abcde/45492" show error message in response and in DB will not show data for this record
	@Test(groups = {"All", "Regression", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90413_OpenEVV_Client_Account_DB_Validation() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException 
	{
		// logger = extent.startTest("TC90413_OpenEVV_Client_Account_DB_Validation");
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		String invalidAcc= CommonMethods.generateRandomNumberOfFixLength(5);
		js.put("Account",invalidAcc);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);
		logger.log(LogStatus.INFO, "Validating Json response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));

		}
	}