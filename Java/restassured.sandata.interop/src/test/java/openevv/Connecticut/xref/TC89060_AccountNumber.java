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
 */
//Test Case 89060:Open EVV -xref -account number should be valid

public class TC89060_AccountNumber extends BaseTest {

	//To validate the valid Account number in between 4 to 10
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89060_OpenEVV_XRef_Acc_num_valid_between_4_10() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89060_OpenEVV_XRef_Acc_num_valid_between_4_10");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the valid Account number in between 4 to 10"); // adding what you are verifing

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", "14420");
		logger.log(LogStatus.INFO, "Passing Account as 14420 ");
		CommonMethods.validateResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	}

	//To validate the valid Account number more than  10
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89060_OpenEVV_XRef_Acc_num_valid_above_10() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89060_OpenEVV_XRef_Acc_num_valid_above_10");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the valid Account number more than  10"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateRandomNumberOfFixLength(11));
		logger.log(LogStatus.INFO, "Passing Account as Random ");
		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));
		Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Invalid PostRequestResponse ProcessID: [-1]\","));

		//		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the valid Account number less than 4
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89060_OpenEVV_XRef_Acc_num_valid_less_4() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		
		// logger = extent.startTest("TC89060_OpenEVV_XRef_Acc_num_valid_less_4");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the valid Account number less than  10"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("Account", CommonMethods.generateRandomNumberOfFixLength(3));
		logger.log(LogStatus.INFO, "Passing Account as Random ");
		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The Account for input record(s) does not match with given Account 14420. Please check and try again."));
		//Assert.assertTrue(bodyAsString.contains(" \"reason\": \"Invalid PostRequestResponse ProcessID: [-1]\","));
}
}
