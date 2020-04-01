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
//Test Case 89302:Open EVV - employee - Validate EmployeeGender field/format

public class TC89302_EmpGender extends BaseTest {
	//To validate the 'M' employee gender
	@Test(groups = {"All", "fixing"})
	public void TC89302_OpenEVV_valid_EmpGender_M() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89302_OpenEVV_valid_EmpGender_M");
		 
		logger.log(LogStatus.INFO, "To validate the 'M' employee gender");
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);


		logger.log(LogStatus.INFO, "Passing EmployeeGender as Male ");
        logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		js.put("EmployeeGender", DataGeneratorEmployee.gender[0]);

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the 'F' employee gender
	@Test(groups = {"All", "fixing"})
	public void TC89302_OpenEVV_valid_EmpGender_F() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89302_OpenEVV_valid_EmpGender_F");
		 
		logger.log(LogStatus.INFO, "To validate the 'F' employee gender");// adding what you are verifing

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);

		logger.log(LogStatus.INFO, "Passing EmployeeGender as F ");
        logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		js.put("EmployeeGender", DataGeneratorEmployee.gender[1]);

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the 'O' employee gender
	@Test(groups = {"All", "fixing"})
	public void TC89302_OpenEVV_valid_EmpGender_O() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89302_OpenEVV_valid_EmpGender_O");
		 
		logger.log(LogStatus.INFO, "To validate the 'O' employee gender");// adding what you are verifing

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);

		logger.log(LogStatus.INFO, "Passing EmployeeGender as 0");
        logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		js.put("EmployeeGender", DataGeneratorEmployee.gender[2]);

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the numeric employee gender
	@Test(groups = {"All", "fixing"})
	public void TC89302_OpenEVV_invalid_numeric_Gender() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89302_OpenEVV_invalid_numeric_Gender");
		 
		logger.log(LogStatus.INFO, "To validate the numeric employee gender");// adding what you are verifing

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeGender",CommonMethods.generateRandomNumberOfFixLength(1));
		logger.log(LogStatus.INFO, "Passing EmployeeGender as number ");
  
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");


		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeGender expected format is not correct."));
	}

	//To validate the special char employee gender
	@Test(groups = {"All", "fixing"})
	public void TC89302_OpenEVV_invalid_special_char_EmpGender() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89302_OpenEVV_invalid_special_char_EmpGender");
		 
		logger.log(LogStatus.INFO, "To validate the special char employee gender");
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeGender", CommonMethods.generateSpecialChar(1));
		logger.log(LogStatus.INFO, "Passing EmployeeGender as special character");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeGender expected format is not correct."));
	}


}