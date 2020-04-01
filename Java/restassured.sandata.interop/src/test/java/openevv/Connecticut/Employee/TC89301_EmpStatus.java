package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author MayankM
 */
//Test Case 89301:Open EVV - employee - Validate Status field Format

public class TC89301_EmpStatus extends BaseTest {

	//To validate the valid employee status
	@Test(groups = {"All", "fixing"})
	public void TC89301_OpenEVV_valid_EmpStatus() throws InterruptedException, IOException, ParseException
	{

		// logger = extent.startTest("TC89301_OpenEVV_valid_EmpStatus");
		 
		logger.log(LogStatus.INFO, "To validate the valid employee status");// adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Status", "");
		

		logger.log(LogStatus.INFO, "Passing status as no value ");

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the null employee status
	@Test(groups = {"All", "fixing"})
	public void TC89301_OpenEVV_null_EmpStatus() throws InterruptedException, IOException, ParseException {
		// logger = extent.startTest("TC89301_OpenEVV_null_EmpStatus");

		logger.log(LogStatus.INFO, "To validate the null employee status");// adding what you are verifing


		//Using Reusable method to load client json
		JSONArray j = CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Status", null);
		logger.log(LogStatus.INFO, "Passing Status as  null");
		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}
	//To validate the missing employee status
	@Test(groups = {"All", "fixing"})
	public void TC89301_OpenEVV_missing_EmpStatus () throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89301_OpenEVV_missing_EmpStatus");

		logger.log(LogStatus.INFO, "To validate the missing employee status");// adding what you are verifing


		//Using Reusable method to load client json
		JSONArray j = CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Status", " ");
		logger.log(LogStatus.INFO, "Passing Status as blank ");
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The Status expected format is not correct."));
	}
}