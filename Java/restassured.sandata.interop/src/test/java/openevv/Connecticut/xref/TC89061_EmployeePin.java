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
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author RRohiteshwar
 *
 */

//Test Case 89061:open evv-Xref- employee pin should be valid

public class TC89061_EmployeePin extends BaseTest
{

	//To validate the valid EmployeePIN in between 4 to 9
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89061_OpenEVV_XRef_EmployeePIN_valid_digit_min_4() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		
		// logger = extent.startTest("TC89061_OpenEVV_XRef_EmployeePIN_valid_digit_min_4");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the valid EmployeePIN in between 4 to 9"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(4));
		logger.log(LogStatus.INFO, "Passing EmployeePIN as Random ");
		CommonMethods.validateResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	}
	
	//To validate the valid EmployeePIN in between 4 to 9
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89061_OpenEVV_XRef_EmployeePIN_valid_between_4_9() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89061_OpenEVV_XRef_EmployeePIN_valid_between_4_9");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the valid EmployeePIN in between 4 to 9"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(6));
		logger.log(LogStatus.INFO, "Passing EmployeePIN as Random ");
		CommonMethods.validateResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	}
	
	//To validate the valid EmployeePIN in between 4 to 9
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89061_OpenEVV_XRef_EmployeePIN_valid_digint_MAX_9() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89061_OpenEVV_XRef_EmployeePIN_valid_digint_MAX_9");  // adding method name info via logger
		 
		logger.log(LogStatus.INFO, "To validate the valid EmployeePIN in between 4 to 9"); // adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(9));
		logger.log(LogStatus.INFO, "Passing Account as Random ");
		CommonMethods.validateResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

	}

}