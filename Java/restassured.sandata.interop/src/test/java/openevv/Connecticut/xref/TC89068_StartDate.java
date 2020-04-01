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

//Test Case 89068:Inter-op-Open EVV-Xref- Xref start date should not be greater than Xref end date.

public class TC89068_StartDate extends BaseTest
{

	//To validate the valid Xref start date that is same as Xref end date.
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89068_OpenEVV_xrefStartDate_same_xrefEndDate_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89068_OpenEVV_xrefStartDate_same_xrefEndDate_valid");  // adding method name info via logger

		logger.log(LogStatus.INFO, "To validate the valid Xref start date that is same as Xref end date"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("XRefStartDate", CommonMethods.generateTodayDate_MMddyyyy());
		js.put("XRefEndDate", CommonMethods.generateTodayDate_MMddyyyy());

		logger.log(LogStatus.INFO, "Passing XRefStartDate and XRefEndDate  as Random ");
		CommonMethods.validateResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	}

	//To validate the valid Xref start date that is lower than Xref end date.
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89068_OpenEVV_xrefStartDate_lowerthan_Than_xrefEndDate_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89068_OpenEVV_xrefStartDate_lowerthan_Than_xrefEndDate_valid");  // adding method name info via logger

		logger.log(LogStatus.INFO, "To validate the valid Xref start date that is lower than Xref end date."); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("XRefStartDate", CommonMethods.generateTodayDate_MMddyyyy());
		js.put("XRefEndDate", CommonMethods.generateFutureDate_MMddyyyy());
		logger.log(LogStatus.INFO, "Passing XRefStartDate and XRefEndDate as Random ");
		CommonMethods.validateResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	}

	//To validate the valid Xref start date that is greater than Xref end date.
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89068_OpenEVV_xrefStartDate_Greater_Than_xrefEndDate_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89068_OpenEVV_xrefStartDate_Greater_Than_xrefEndDate_invalid");  // adding method name info via logger

		logger.log(LogStatus.INFO, "To validate the valid Xref start date that is greater than Xref end date."); // adding what you are verifing

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("XRefStartDate", CommonMethods.generateFutureDate_MMddyyyy());
		js.put("XRefEndDate",CommonMethods.generateTodayDate_MMddyyyy());
		logger.log(LogStatus.INFO, "Passing XRefStartDate and XRefEndDate as Random ");
		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The XRefStartDate cannot be greater than XRefEndDate."));

		//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

}
