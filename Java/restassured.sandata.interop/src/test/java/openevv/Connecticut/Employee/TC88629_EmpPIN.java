/**
 * 
 */
package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
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
 * @author RRohiteshwar
 */
//Test Case 88629:3P-Worker-Validate (mix) - EmployeePIN field formats/values

public class TC88629_EmpPIN extends BaseTest
{

	//To validate the valid EmployeePIN length min 4
	@Test(groups = {"All", "fixing"})
	public void TC88629_OpenEVV_valid_EmployeePIN_min_length_4() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88629_OpenEVV_valid_EmployeePIN_min_length_4");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", DataGeneratorEmployee.generateEmpPIN(4));

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the valid EmployeePIN length max 9
	@Test(groups = {"All", "fixing"})
	public void TC88629_OpenEVV_valid_EmployeePIN_max_length_9() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88629_OpenEVV_valid_EmployeePIN_max_length_9");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", DataGeneratorEmployee.generateEmpPIN(9));
		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the valid EmployeePIN leading zero
	@Test(groups = {"All", "fixing"})
	public void TC88629_OpenEVV_valid_EmployeePIN_leading_Zero() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88629_OpenEVV_valid_EmployeePIN_leading_Zero");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", "0" +DataGeneratorEmployee.generateEmpPIN(6));

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the invalid EmployeePIN Dash not allowed
	@Test(groups = {"All", "fixing"})
	public void TC88629_OpenEVV_EmployeePIN_invalid_Dash_not_allowed() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88629_OpenEVV_EmployeePIN_invalid_Dash_not_allowed");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", DataGeneratorEmployee.generateEmpPIN(2)
				+ "-" + DataGeneratorEmployee.generateEmpPIN(2)
				+ "-"+  DataGeneratorEmployee.generateEmpPIN(1));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN expected format is not correct. The record should satisfy this regular expression"));
	}
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88629_OpenEVV_Invalid_EmployeePIN_Blank() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88629_OpenEVV_valid_EmployeePIN_min_length_4");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", " ");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN expected format is not correct."));
	}
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88629_OpenEVV_Invalid_EmployeePIN_Null() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88629_OpenEVV_valid_EmployeePIN_min_length_4");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", null);

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN cannot be NULL."));
	}
	//To validate the invalid EmployeePIN  length more than 9
	@Test(groups = {"All", "fixing"})
	public void TC88629_OpenEVV_EmployeePIN_invalid_length_more_9() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88629_OpenEVV_EmployeePIN_invalid_length_more_9");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", DataGeneratorEmployee.generateEmpPIN(10));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN expected format is not correct."));

	}

	//To validate the invalid EmployeePIN having alpha numeric
	@Test(groups = {"All", "fixing"})
	public void TC88629_OpenEVV_EmployeePIN_invalid_length_alphanumeric() throws InterruptedException, IOException, ParseException
	{
		
		// logger = extent.startTest("TC88629_OpenEVV_EmployeePIN_invalid_length_alphanumeric");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", CommonMethods.generateRandomAlphaNumeric(7));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN expected format is not correct."));
		//			Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//			Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the invalid EmployeePIN having special character
	@Test(groups = {"All", "fixing"})
	public void TC88629_OpenEVV_EmployeePIN_invalid_length_special_char() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88629_OpenEVV_EmployeePIN_invalid_length_special_char");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", CommonMethods.generateSpecialChar(7));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN expected format is not correct."));
		//			Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//			Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the valid EmployeePIN leading space
	@Test(groups = {"All", "fixing"})
	public void TC88629_OpenEVV_EmployeePIN_valid_leading_space() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88629_OpenEVV_EmployeePIN_valid_leading_space");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", " " + DataGeneratorEmployee.generateEmpPIN(9));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN expected format is not correct."));
		//			Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//			Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the valid EmployeePIN trailing space
	@Test(groups = {"All", "fixing"})
	public void TC88629_OpenEVV_EmployeePIN_valid_trailing_space() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88629_OpenEVV_EmployeePIN_valid_trailing_space");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", DataGeneratorEmployee.generateEmpPIN(9) + " ");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN expected format is not correct."));
		//			Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//			Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}
}
