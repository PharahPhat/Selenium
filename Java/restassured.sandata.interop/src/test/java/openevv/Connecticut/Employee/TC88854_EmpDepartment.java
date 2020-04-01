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
//Test Case 88854:Open EVV-Worker-Validate (mix) - Department field formats/values

public class TC88854_EmpDepartment extends BaseTest {
	//To validate the valid emp department length
	@Test(groups = {"All", "fixing"})
	public void TC88854_OpenEVV_valid_EmpDept_length() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88854_OpenEVV_valid_EmpDept_length");

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Department", DataGeneratorEmployee.generateEmpDept(3));

		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the invalid emp department length 
	@Test(groups = {"All", "fixing"})
	public void TC88854_OpenEVV_invalid_more_EmpDept_length() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88854_OpenEVV_invalid_more_EmpDept_length");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Department", DataGeneratorEmployee.generateEmpDept(5));

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The Department value exceeds the maximum length of 3 characters.  The record is being rejected. The length should be between 0 and 3."));
	}

	//To validate the emp department with non numeric value
	@Test(groups = {"All", "fixing"})
	public void TC88854_OpenEVV_nonnumeric_EmpDept() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88854_OpenEVV_nonnumeric_EmpDept");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Department", CommonMethods.generateRandomStringOfFixLength(1));

		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the emp department with numeric value
	@Test(groups = {"All", "fixing"})
	public void TC88854_OpenEVV_numeric_EmpDept() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88854_OpenEVV_numeric_EmpDept");

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Department", CommonMethods.generateRandomNumberOfFixLength(2));

		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the emp department with leading whitespace
	@Test(groups = {"All", "fixing"})
	public void TC88854_OpenEVV_leading_space_EmpDept() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88854_OpenEVV_leading_space_EmpDept");
		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Department", " " + DataGeneratorEmployee.generateEmpDept(2));

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The Department expected format is not correct."));
	}

	//To validate the emp department with trailing whitespace
	@Test(groups = {"All", "fixing"})
	public void TC88854_OpenEVV_trailing_space_EmpDept() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88854_OpenEVV_trailing_space_EmpDept");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Department", DataGeneratorEmployee.generateEmpDept(2) + " ");

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The Department expected format is not correct."));
	}

	//To validate the emp department with leading zero
	@Test(groups = {"All", "fixing"})
	public void TC88854_OpenEVV_leading_zero_EmpDept() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88854_OpenEVV_leading_zero_EmpDept");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Department", "0" + DataGeneratorEmployee.generateEmpDept(2));

		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

	}

	//To validate the emp department with special character
	@Test(groups = {"All", "fixing"})
	public void TC88854_OpenEVV_specialCharacter_EmpDept() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88854_OpenEVV_specialCharacter_EmpDept");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("Department", DataGeneratorEmployee.generateEmpDept(1) + "@");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("The Department expected format is not correct."));
	}


}