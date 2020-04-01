package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorEmployee;
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
//Test Case 89298:Open EVV - employee - Validate EmployeeState field/format

public class TC89298_EmpState extends BaseTest {
	//To validate the valid EmployeeState
	@Test(groups = {"All", "fixing"})
	public void TC89298_OpenEVV_valid_EmpState() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89298_OpenEVV_valid_EmpState");
		 
		logger.log(LogStatus.INFO, "//To validate the valid EmployeeState");// adding what you are verifing

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeState",DataGeneratorEmployee.generateEmpState());
		
		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the invalid EmployeeState
	@Test(groups = {"All", "fixing"})
	public void TC89298_OpenEVV_invalid_EmpState() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89298_OpenEVV_invalid_EmpState");
		 
		logger.log(LogStatus.INFO, "To validate the invalid EmployeeState");// adding what you are verifing

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeState", CommonMethods.getSaltString(2));
		logger.log(LogStatus.INFO, "Passing EmployeeState as salt string ");
  
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeState expected format is not correct."));

	}

	//To validate the invalid EmployeeState length
	@Test(groups = {"All", "fixing"})
	public void TC89298_OpenEVV_invalid_EmpState_length() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89298_OpenEVV_invalid_EmpState_length");
		 
		logger.log(LogStatus.INFO, "To validate the invalid EmployeeState length");// adding what you are verifing

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeState", CommonMethods.getSaltString(3));
		logger.log(LogStatus.INFO, "Passing EmployeeState as EmployeeState length");
 
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeState value exceeds the maximum length of 2 characters.  The record is being rejected. The length should be between 2 and 2."));
	}

	//To validate the alphanumeric value in EmployeeState
	@Test(groups = {"All", "fixing"})
	public void TC89298_OpenEVV_alphanumeric_EmpState() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89298_OpenEVV_alphanumeric_EmpState");
		 
		logger.log(LogStatus.INFO, "To validate the alphanumeric value in EmployeeState");// adding what you are verifing

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeState", CommonMethods.generateRandomAlphaNumeric(2));
		logger.log(LogStatus.INFO, "Passing EmployeeState as alphanumeric ");
  
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeState expected format is not correct."));
	}
 
	//To validate the EmployeeState with trailing spaces
	@Test(groups = {"All", "fixing"})
	public void TC89298_OpenEVV_EmpState_trailing_spaces() throws InterruptedException, IOException, ParseException
	{// logger = extent.startTest("TC89298_OpenEVV_EmpState_trailing_spaces");
	 
	logger.log(LogStatus.INFO, "To validate the EmployeeState with trailing spaces");// adding what you are verifing

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeState", DataGeneratorEmployee.generateEmpState() + " ");

		logger.log(LogStatus.INFO, "Passing EmployeeState as trailing spaces");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeState value exceeds the maximum length of 2 characters.  The record is being rejected. The length should be between 2 and 2."));
	}

	//To validate the EmployeeState with leading spaces
	@Test(groups = {"All", "fixing"})
	public void TC89298_OpenEVV_EmpState_leading_spaces() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89298_OpenEVV_EmpState_leading_spaces");
		 
		logger.log(LogStatus.INFO, "To validate the EmployeeState with leading spaces");// adding what you are verifing

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);

		logger.log(LogStatus.INFO, "Passing EmployeeState as leading spaces");
        logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		js.put("EmployeeState", " " + DataGeneratorEmployee.generateEmpState());

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeState value exceeds the maximum length of 2 characters.  The record is being rejected. The length should be between 2 and 2."));
	}

	//To validate the missing EmployeeState 
	@Test(groups = {"All", "fixing"})
	public void TC89298_OpenEVV_missing_EmpState() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89298_OpenEVV_missing_EmpState");
		 
		logger.log(LogStatus.INFO, "To validate the missing EmployeeState ");// adding what you are verifing

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeState", "");

		logger.log(LogStatus.INFO, "Passing EmployeeState as blank ");
  
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeState value exceeds the maximum length of 2 characters.  The record is being rejected. The length should be between 2 and 2."));
	}

}