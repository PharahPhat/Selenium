package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC88376_EmpLastName extends BaseTest { 
	
	//To validate the valid EmployeeLastName length
	@Test(groups = {"All", "fixing"})
	public void TC88376_OpenEVV_valid_EmployeeLastName() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88376_OpenEVV_valid_EmployeeLastName");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(10));

		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());
	
		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	
	}

	//To validate the invalid EmployeeLastName length more than 30
	@Test(groups = {"All", "fixing"})
	public void TC88376_OpenEVV_invalid_EmployeeLastName_length() throws InterruptedException, IOException, ParseException
	{
		
		// logger = extent.startTest("TC88376_OpenEVV_invalid_EmployeeLastName_length");
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(31));
		
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The EmployeeLastName value exceeds the maximum length of 30 characters");
	}

	//To validate the EmployeeLastName with alphanumeric value
	@Test(groups = {"All", "fixing"})
	public void TC88376_OpenEVV_invalid_alphanumeric_EmployeeLastName() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88376_OpenEVV_invalid_alphanumeric_EmployeeLastName");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateRandomAlphaNumeric(10));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The EmployeeLastName expected format is not correct");
	}

	//To validate the EmployeeLastName with numeric value
	@Test(groups = {"All", "fixing"})
	public void TC88376_OpenEVV_invalid_numeric_EmployeeLastName() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88376_OpenEVV_invalid_numeric_EmployeeLastName");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The EmployeeLastName expected format is not correct");
	}

	//To validate the EmployeeLastName with leading space
	@Test(groups = {"All", "fixing"})
	public void TC88376_OpenEVV_valid_leading_space_EmployeeLastName() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88376_OpenEVV_valid_leading_space_EmployeeLastName");
	
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", " " + CommonMethods.generateRandomStringOfFixLength(10));

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the EmployeeLastName with trailing space
	@Test(groups = {"All", "fixing"})
	public void TC88376_OpenEVV_valid_trailing_space_EmployeeLastName() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88376_OpenEVV_valid_trailing_space_EmployeeLastName");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(10) + " ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//To validate the EmployeeLastName with special character
	@Test(groups = {"All", "fixing"})
	public void TC88376_OpenEVV_valid_specialCharacter_EmployeeLastName() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88376_OpenEVV_valid_specialCharacter_EmployeeLastName");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(10) + "." + "-" +"'");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

	}

	//To validate the EmployeeLastName with special character other than dot,quote and dash
	@Test(groups = {"All", "fixing"})
	public void TC88376_OpenEVV_invalid_specialCharacter_EmployeeLastName() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88376_OpenEVV_invalid_specialCharacter_EmployeeLastName");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateSpecialChar(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeLastName expected format is not correct."));

	}
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88629_OpenEVV_Invalid_EmployeeLastName_Blank() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88629_OpenEVV_valid_EmployeePIN_min_length_4");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", " ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeLastName expected format is not correct."));
	}
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88629_OpenEVV_Invalid_EmployeeLastName_Null() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88629_OpenEVV_valid_EmployeePIN_min_length_4");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", null);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeLastName cannot be NULL."));
	}

}