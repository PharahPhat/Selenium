package openevv.Connecticut.Client;

import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

// Test Case 90684:Inter-op - Open EVV- Client - Account field validation for any Random Value in Address Segment

import com.globalMethods.core.Assertion_DbVerifier; public class TC90684_Client_Address_Segment extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate Account number in Main Segment and Random value  in Address Segment
	@Test(groups = {"All", "Regression", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90684_OpenEVV_Client() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90684_OpenEVV_Client");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		//String invalidAcc= CommonMethods.generateRandomNumberOfFixLength(5);
		js.put("Account", "14420");
		JSONArray js2 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("Account",CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Accountformat);
	}
}