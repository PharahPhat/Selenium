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
//Test Case 88852:Open EVV-Worker-Validate (mix) - EmployeeSocialSecurity field formats/values
public class TC88852_EmpSSN extends BaseTest {
	//To validate the valid emp ssn length
	@Test(groups = {"All", "fixing"})
	public void TC88852_OpenEVV_valid_EmpSSN_length() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88852_OpenEVV_valid_EmpSSN_length");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomNumberOfFixLength(9));

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the invalid emp ssn length more
	@Test(groups = {"All", "fixing"})
	public void TC88852_OpenEVV_invalid_exceeding_EmpSSN_length() throws InterruptedException,  IOException, ParseException
	{
		// logger = extent.startTest("TC88852_OpenEVV_invalid_exceeding_EmpSSN_length");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

				logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSocialSecurity value exceeds the maximum length of 9 characters.  The record is being rejected. The length should be between 0 and 9."));
	}

	//To validate the invalid emp ssn length less
	@Test(groups = {"All", "fixing"})
	public void TC88852_OpenEVV_invalid_less_EmpSSN_length() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88852_OpenEVV_invalid_less_EmpSSN_length");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomNumberOfFixLength(8));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

				logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSocialSecurity expected format is not correct."));
	}

	//To validate the ssn with alphanumeric value
	@Test(groups = {"All", "fixing"})
	public void TC88852_OpenEVV_invalid_alphanumeric_EmpSSN() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88852_OpenEVV_invalid_alphanumeric_EmpSSN");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomAlphaNumeric(9));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

			logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSocialSecurity expected format is not correct."));
	}

	//To validate the emp ssn with non numeric value
	@Test(groups = {"All", "fixing"})
	public void TC88852_OpenEVV_invalid_nonnumeric_EmpSSN() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88852_OpenEVV_invalid_nonnumeric_EmpSSN");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomStringOfFixLength(9));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

			logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSocialSecurity expected format is not correct."));
	}

	//To validate the emp ssn with leading whitespace
	@Test(groups = {"All", "fixing"})
	public void TC88852_OpenEVV_invalid_leading_space_EmpSSN() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88852_OpenEVV_invalid_leading_space_EmpSSN");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", " " + CommonMethods.generateRandomNumberOfFixLength(8));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSocialSecurity expected format is not correct."));
	}

	//To validate the emp ssn with trailing whitespace
	@Test(groups = {"All", "fixing"})
	public void TC88852_OpenEVV_invalid_trailing_space_EmpSSN() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88852_OpenEVV_invalid_trailing_space_EmpSSN");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomNumberOfFixLength(8) + " ");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSocialSecurity expected format is not correct."));
	}

	//To validate the emp ssn with leading whitespace
	@Test(groups = {"All", "fixing"})
	public void TC88852_OpenEVV_valid_leading_zero_EmpSSN() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88852_OpenEVV_valid_leading_zero_EmpSSN");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", "0" + CommonMethods.generateRandomNumberOfFixLength(8));

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the emp ssn with special character
	@Test(groups = {"All", "fixing"})
	public void TC88852_OpenEVV_invalid_specialCharacter_EmpSSN() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88852_OpenEVV_invalid_specialCharacter_EmpSSN");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomNumberOfFixLength(8) + CommonMethods.generateSpecialChar(1));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("The EmployeeSocialSecurity expected format is not correct."));
	}

	//To validate the emp ssn with dash character
	@Test(groups = {"All", "fixing"})
	public void TC88852_OpenEVV_dashCharacter_EmpSSN() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88852_OpenEVV_dashCharacter_EmpSSN");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeSocialSecurity", CommonMethods.generateRandomNumberOfFixLength(4) + "-" + CommonMethods.generateRandomNumberOfFixLength(4));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSocialSecurity expected format is not correct."));
	}

}