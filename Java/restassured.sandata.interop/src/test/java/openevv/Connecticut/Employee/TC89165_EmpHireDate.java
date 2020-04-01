/**
 * 
 */
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
//Test Case 89165:Open EVV-Worker-Validate (mix) - EmployeeHireDate field formats/values

public class TC89165_EmpHireDate extends BaseTest {
	//To validate the valid Emp hire date- mmddyyyy
	@Test(groups = {"All", "fixing"})
	public void TC89165_OpenEVV_valid_EmpHireDate() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89165_OpenEVV_valid_EmpHireDate");

		logger.log(LogStatus.INFO, "To validate the valid Emp hire date- mmddyyyy");
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);

		js.put("EmployeeHireDate",DataGeneratorEmployee.generateEmpHireDate());

		logger.log(LogStatus.INFO, "Passing EmployeeHireDate as random ");
		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the invalid Emp hire date- mm-dd-yyyy
	@Test(groups = {"All", "fixing"})
	public void TC89165_OpenEVV_invalid_EmpHireDate_dash() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89165_OpenEVV_invalid_EmpHireDate_dash");

		logger.log(LogStatus.INFO, "To validate the invalid Emp hire date- mm-dd-yyyy");
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeHireDate","08-22-2018");

		logger.log(LogStatus.INFO, "Passing EmployeeHireDate as 08-22-2018 ");
		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeHireDate expected format is not correct."));
	}

	//To validate the invalid Emp hire date- mm/dd/yyyy
	@Test(groups = {"All", "fixing"})
	public void TC89165_OpenEVV_invalid_EmpHireDate_slash() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89165_OpenEVV_invalid_EmpHireDate_slash");

		logger.log(LogStatus.INFO, "To validate the invalid Emp hire date- mm/dd/yyyy");// adding what you are verifing


		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeHireDate","08/22/2018");
		logger.log(LogStatus.INFO, "Passing EmployeeHireDate as 08/22/2018 ");
		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeHireDate expected format is not correct."));
	}

	//To validate the invalid Emp hire date- ddmmyyyy
	@Test(groups = {"All", "fixing"})
	public void TC89165_OpenEVV_invalid_EmpHireDate_date() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89165_OpenEVV_invalid_EmpHireDate_date");

		logger.log(LogStatus.INFO, "To validate the invalid Emp hire date- ddmmyyyy");// adding what you are verifing


		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeHireDate","22082018");
		logger.log(LogStatus.INFO, "Passing EmployeeHireDate as 22082018");
		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeHireDate expected format is not correct."));
	}

	//To validate the invalid Emp hire date- dd-mm-yyyy
	@Test(groups = {"All", "fixing"})
	public void TC89165_OpenEVV_invalid_EmpHireDate_date_dash() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89165_OpenEVV_invalid_EmpHireDate_date_dash");

		logger.log(LogStatus.INFO, "To validate the invalid Emp hire date- dd-mm-yyyy");// adding what you are verifing




		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeHireDate","22-08-2018");
		logger.log(LogStatus.INFO, "Passing EmployeeHireDate as 22-08-2018");
		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeHireDate expected format is not correct."));
	}

	//To validate the invalid Emp hire date- dd/mm/yyyy
	@Test(groups = {"All", "fixing"})
	public void TC89165_OpenEVV_invalid_EmpHireDate_date_slash() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89165_OpenEVV_invalid_EmpHireDate_date_slash");

		logger.log(LogStatus.INFO, "To validate the invalid Emp hire date- dd/mm/yyyy");// adding what you are verifing


		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeHireDate","22/08/2018");
		logger.log(LogStatus.INFO, "Passing EmployeeHireDate as 22/08/2018");
		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeHireDate expected format is not correct."));
	}

	//To validate the invalid Emp hire date- yyyymmdd
	@Test(groups = {"All", "fixing"})
	public void TC89165_OpenEVV_invalid_EmpHireDate_year() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89165_OpenEVV_invalid_EmpHireDate_year");

		logger.log(LogStatus.INFO, "To validate the invalid Emp hire date- yyyymmdd");// adding what you are verifing

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeHireDate","20180822");

		logger.log(LogStatus.INFO, "Passing EmployeeHireDate as 20180822 ");
		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeHireDate expected format is not correct."));
	}

	//To validate the invalid Emp hire date- yyyy-mm-dd
	@Test(groups = {"All", "fixing"})
	public void TC89165_OpenEVV_invalid_EmpHireDate_year_dash() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89165_OpenEVV_invalid_EmpHireDate_year_dash");

		logger.log(LogStatus.INFO, "To validate the invalid Emp hire date- yyyy-mm-dd");// adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeHireDate","2018-08-22");


		logger.log(LogStatus.INFO, "Passing EmployeeHireDate as 2018-08-22");
		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeHireDate expected format is not correct."));
	}

	//To validate the invalid Emp hire date- yyyy/mm/dd
	@Test(groups = {"All", "fixing"})
	public void TC89165_OpenEVV_invalid_EmpHireDate_year_slash() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89165_OpenEVV_invalid_EmpHireDate_year_slash");

		logger.log(LogStatus.INFO, "To validate the invalid Emp hire date- yyyy/mm/dd");// adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeHireDate","2018/08/22");


		logger.log(LogStatus.INFO, "Passing EmployeeHireDate as 2018/08/22");
		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeHireDate expected format is not correct."));
	}

	//To validate the null Emp hire date
	@Test(groups = {"All", "fixing"})
	public void TC89165_OpenEVV_null_EmpHireDate() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC89165_OpenEVV_null_EmpHireDate");

		logger.log(LogStatus.INFO, "To validate the null Emp hire date");// adding what you are verifing
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeHireDate",null);


		logger.log(LogStatus.INFO, "Passing EmployeeHireDate as null");
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeHireDate expected format is not correct."));
	}

}
