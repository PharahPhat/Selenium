package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC88628_EmpFirstName extends BaseTest {
	
	//To validate the valid EmployeeFirstName length
	@Test(groups = {"All", "fixing"})
	public void TC88628_OpenEVV_valid_EmployeeFirstName() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88628_OpenEVV_valid_EmployeeFirstName");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(10));

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		
	}

	//To validate the invalid EmployeeFirstName length more than 30
	@Test(groups = {"All", "fixing"})
	public void TC88628_OpenEVV_invalid_EmployeeFirstName_length() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88628_OpenEVV_invalid_EmployeeFirstName_length");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(31));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeFirstName value exceeds the maximum length of 30 characters.  The record is being rejected. The length should be between 1 and 30."));
	}

	//To validate the EmployeeFirstName with alphanumeric value
	@Test(groups = {"All", "fixing"})
	public void TC88628_OpenEVV_invalid_alphanumeric_EmployeeFirstName() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88628_OpenEVV_invalid_alphanumeric_EmployeeFirstName");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", CommonMethods.generateRandomAlphaNumeric(10));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeFirstName expected format is not correct."));
	}

	//To validate the EmployeeFirstName with numeric value
	@Test(groups = {"All", "fixing"})
	public void TC88628_OpenEVV_invalid_numeric_EmployeeFirstName() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88628_OpenEVV_invalid_numeric_EmployeeFirstName");
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeFirstName expected format is not correct."));
	}

	//To validate the EmployeeFirstName with leading space
	@Test(groups = {"All", "fixing"})
	public void TC88628_OpenEVV_valid_leading_space_EmployeeFirstName() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88628_OpenEVV_valid_leading_space_EmployeeFirstName");
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", " " + CommonMethods.generateRandomStringOfFixLength(10));

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));


	}

	//To validate the EmployeeFirstName with trailing space
	@Test(groups = {"All", "fixing"})
	public void TC88628_OpenEVV_valid_trailing_space_EmployeeFirstName() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88628_OpenEVV_valid_trailing_space_EmployeeFirstName");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(10) + " ");

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the EmployeeFirstName with special character
	@Test(groups = {"All", "fixing"})
	public void TC88628_OpenEVV_valid_specialCharacter_EmployeeFirstName() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88628_OpenEVV_valid_specialCharacter_EmployeeFirstName");

		
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(10) + "." + "-" +"'");

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the EmployeeFirstName with special character other than dot,quote and dash
	@Test(groups = {"All", "fixing"})
	public void TC88628_OpenEVV_invalid_specialCharacter_EmployeeFirstName() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88628_OpenEVV_invalid_specialCharacter_EmployeeFirstName");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", CommonMethods.generateSpecialChar(10));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeFirstName expected format is not correct."));

	}
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88629_OpenEVV_Invalid_EmployeeFirstName_Blank() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88629_OpenEVV_valid_EmployeePIN_min_length_4");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", " ");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeFirstName expected format is not correct."));
	}
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88629_OpenEVV_Invalid_EmployeeFirstName_Null() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88629_OpenEVV_valid_EmployeePIN_min_length_4");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", null);

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeFirstName cannot be NULL."));
	}

}