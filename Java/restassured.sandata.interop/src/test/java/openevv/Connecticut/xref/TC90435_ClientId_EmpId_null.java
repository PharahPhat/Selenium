/**
 * 
 */
package openevv.Connecticut.xref;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author RRohiteshwar
 *
 */

//Test Case 90435:Open EVV - xref - Validate xref relation for null Client ID and employee ID

public class TC90435_ClientId_EmpId_null extends BaseTest
{

	//To validate the invalid ClientID & EmpPin with null only
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90435_OpenEVV_XRef_ClientID_empPin_invalid_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90435_OpenEVV_XRef_ClientID_empPin_invalid_null");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the invalid ClientID & EmpPin with null only"); // adding what you are verifing

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", null);
		js.put("EmployeePIN", null);
		logger.log(LogStatus.INFO, "Passing ClientID as null and EmployeePIN as null ");
    
		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID cannot be null."));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN cannot be null."));
	}


}
