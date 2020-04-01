package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
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
//Test Case 88333:Open EVV-Worker-Validate (mix) - EmployeeZipCode field formats/values

public class TC88333_EmpZipCode extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the valid numeric EmployeeZipCode 
	@Test(groups = {"All", "fixing"})
	public void TC88333_OpenEVV_Emp_valid_numeric_ZipCode() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC88333_OpenEVV_Emp_valid_numeric_ZipCode");

		//Using Reusable method to load employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode", CommonMethods.generateRandomNumberOfFixLength(5));

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

	}

	//To validate the valid dash EmployeeZipCode 
	@Test(groups = {"All", "fixing"})
	public void TC88333_OpenEVV_Emp_valid_dash_ZipCode() throws InterruptedException,  IOException, ParseException
	{
		// logger = extent.startTest("TC88333_OpenEVV_Emp_valid_dash_ZipCode");

		//Using Reusable method to load employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode", CommonMethods.generateRandomNumberOfFixLength(5)+ "-" + CommonMethods.generateRandomNumberOfFixLength(4));

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

	}

	//To validate the invalid EmployeeZipCode length
	@Test(groups = {"All", "fixing"})
	public void TC88333_OpenEVV_Emp_invalid_ZipCode_length() throws InterruptedException, IOException, ParseException
	{	
		// logger = extent.startTest("TC88333_OpenEVV_Emp_invalid_ZipCode_length");
	
		//Using Reusable method to load employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode", CommonMethods.generateRandomNumberOfFixLength(7));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeZipCode expected format is not correct."));
	}

	//To validate the EmployeeZipCode with alphanumeric value
	@Test(groups = {"All", "fixing"})
	public void TC88333_OpenEVV_Emp_invalid_alphanumeric_ZipCode() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88333_OpenEVV_Emp_invalid_alphanumeric_ZipCode");

		//Using Reusable method to load employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode", CommonMethods.generateRandomAlphaNumeric(5));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeZipCode expected format is not correct."));
	}

	//To validate the EmployeeZipCode with non numeric value
	@Test(groups = {"All", "fixing"})
	public void TC88333_OpenEVV_Emp_invalid_nonnumeric_ZipCode() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88333_OpenEVV_Emp_invalid_nonnumeric_ZipCode");

		//Using Reusable method to load employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode", CommonMethods.generateRandomStringOfFixLength(5));

		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeZipCode expected format is not correct."));
	}

	//To validate the EmployeeZipCode with leading space
	@Test(groups = {"All", "fixing"})
	public void TC88333_OpenEVV_Emp_invalid_leading_space_ZipCode() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88333_OpenEVV_Emp_invalid_leading_space_ZipCode");

		//Using Reusable method to load employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode", " " + CommonMethods.generateRandomNumberOfFixLength(4));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeZipCode expected format is not correct."));

	}

	//To validate the EmployeeZipCode with leading zero
	@Test(groups = {"All", "fixing"})
	public void TC88333_OpenEVV_Emp_valid_leading_zero_ZipCode() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88333_OpenEVV_Emp_valid_leading_zero_ZipCode");

		//Using Reusable method to load employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode", "0" + CommonMethods.generateRandomNumberOfFixLength(4));

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the EmployeeZipCode with trailing space
	@Test(groups = {"All", "fixing"})
	public void TC88333_OpenEVV_Emp_invalid_trailing_space_ZipCode() throws InterruptedException,  IOException, ParseException
	{
		// logger = extent.startTest("TC88333_OpenEVV_Emp_invalid_trailing_space_ZipCode");

		//Using Reusable method to load employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode", CommonMethods.generateRandomNumberOfFixLength(4) + " ");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeZipCode expected format is not correct."));

	}

	//To validate the EmployeeZipCode with special character
	@Test(groups = {"All", "fixing"})
	public void TC88333_OpenEVV_Emp_specialCharacter_ZipCode() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC88333_OpenEVV_Emp_specialCharacter_ZipCode");

		//Using Reusable method to load employee json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeZipCode","99999-33" );

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeZipCode expected format is not correct."));

	}

}