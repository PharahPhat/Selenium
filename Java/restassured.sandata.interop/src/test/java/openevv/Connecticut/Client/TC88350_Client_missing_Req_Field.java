/**
 * 
 */
package openevv.Connecticut.Client;

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

/**
 * @author RRohiteshwar

 *
 */
//Test Case 88350:Open EVV - Upload Client - Missing Required Values

public class TC88350_Client_missing_Req_Field extends BaseTest

{

	public static String val1, val2;

	//To validate the -invalid _Client-Load-missing-Required Field
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC88273_OpenEVV_Client_Invalid_RequiredField_account_missing_oneplace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88273_OpenEVV_Client_Invalid_RequiredField_account_missing_oneplace");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("Client_RequireField");
		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", "");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"message\": \"The Account for input record(s) does not match with given Account 14420. Please check and try again.\","));

	}

	//To validate the -invalid _Client-Load-missing-Required Field
	@Test(groups = {"All", "Regression", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88273_OpenEVV_Client_Invalid_RequiredField_account_missing_allplace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88273_OpenEVV_Client_Invalid_RequiredField_account_missing_allplace");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("Client_RequireField");

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateRandomNumberOfFixLength(6));
		////////
		JSONArray js2 = (JSONArray) js.get("ClientPhone");
		JSONObject js3 = (JSONObject) js2.get(0);
		js3.put("Account",CommonMethods.generateRandomNumberOfFixLength(5));
		////////

		js2 = (JSONArray) js.get("ClientAddress");
		js3 = (JSONObject) js2.get(0);
		js3.put("Account", CommonMethods.generateRandomNumberOfFixLength(7));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		// assert validation to verify the outcome
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"message\": \"The Account for input record(s) does not match with given Account 14420. Please check and try again.\","));

	}


}
