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

public class TC88335_EmpPhone extends BaseTest {

	//To validate the valid numeric EmployeePhone length
	@Test(groups = {"All", "fixing"})
	public void TC88335_OpenEVV_valid_numeric_EmployeePhone() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88335_OpenEVV_valid_numeric_EmployeePhone");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", CommonMethods.generateRandomNumberOfFixLength(10));

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the invalid EmployeePhone length more than 10
	@Test(groups = {"All", "fixing"})
	public void TC88335_OpenEVV_invalid_EmployeePhone_exceeding_length() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88335_OpenEVV_invalid_EmployeePhone_exceeding_length");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", CommonMethods.generateRandomNumberOfFixLength(12));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePhone expected format is not correct."));
	}

	//To validate the invalid EmployeePhone length less than 10
	@Test(groups = {"All", "fixing"})
	public void TC88335_OpenEVV_EmployeePhone_less_than_min_length() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88335_OpenEVV_EmployeePhone_less_than_min_length");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", CommonMethods.generateRandomNumberOfFixLength(8));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePhone expected format is not correct."));
	}

	//To validate the EmployeePhone with alphanumeric value
	@Test(groups = {"All", "fixing"})
	public void TC88335_OpenEVV_alphanumeric_EmployeePhone() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88335_OpenEVV_alphanumeric_EmployeePhone");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", CommonMethods.generateRandomAlphaNumeric(10));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePhone expected format is not correct."));
	}

	//To validate the EmployeePhone with non numeric value
	@Test(groups = {"All", "fixing"})
	public void TC88335_OpenEVV_nonnumeric_EmployeePhone() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88335_OpenEVV_nonnumeric_EmployeePhone");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePhone expected format is not correct."));
	}

	//To validate the EmployeePhone with leading space
	@Test(groups = {"All", "fixing"})
	public void TC88335_OpenEVV_leading_space_EmployeePhone() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88335_OpenEVV_leading_space_EmployeePhone");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", " " + CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePhone expected format is not correct."));

	}

	//To validate the EmployeePhone with trailing space
	@Test(groups = {"All", "fixing"})
	public void TC88335_OpenEVV_trailing_space_EmployeePhone() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88335_OpenEVV_trailing_space_EmployeePhone");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", CommonMethods.generateRandomNumberOfFixLength(9) + " ");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePhone expected format is not correct."));

	}

	//To validate the EmployeePhone with leading zero
	@Test(groups = {"All", "fixing"})
	public void TC88335_OpenEVV_leading_zero_EmployeePhone() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88335_OpenEVV_leading_zero_EmployeePhone");

		//Using Reusable method to load employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", "0" + CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//To validate the EmployeePhone with special character
	@Test(groups = {"All", "fixing"})
	public void TC88335_OpenEVV_specialCharacter_EmployeePhone() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88335_OpenEVV_specialCharacter_EmployeePhone");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePhone", CommonMethods.generateSpecialChar(10));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePhone expected format is not correct."));

	}

}