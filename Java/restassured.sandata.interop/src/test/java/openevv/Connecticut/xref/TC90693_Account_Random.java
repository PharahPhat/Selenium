/**
 * 
 */
package openevv.Connecticut.xref;

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

/**
 * @author MayankM
 *
 */
//Test Case 89060:Open EVV -xref -account number should be valid

public class TC90693_Account_Random extends BaseTest
{

	//To validate the invalid Account number 
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90693_OpenEVV_XRef_invalid_Account_Number() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90693_OpenEVV_XRef_invalid_Account_Number");  // adding method name info via logger

		logger.log(LogStatus.INFO, "To validate the invalid Account number"); // adding what you are verifing

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateRandomNumberOfFixLength(5));

		logger.log(LogStatus.INFO, "Passing  invalid Account  ");

		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Invalid PostRequestResponse ProcessID: [-1]\","));
	}

}
