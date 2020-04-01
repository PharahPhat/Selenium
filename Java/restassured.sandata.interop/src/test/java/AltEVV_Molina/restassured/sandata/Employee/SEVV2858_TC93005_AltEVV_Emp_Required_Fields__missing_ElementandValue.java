package AltEVV_Molina.restassured.sandata.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
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
import java.sql.SQLException;

/**
 * @author RRohiteshwar
 */

public class SEVV2858_TC93005_AltEVV_Emp_Required_Fields__missing_ElementandValue extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	String field = "worker_ssn";
	//Validate valid employee with fully populated required value in JSON
	@Test(groups = {"All"})
	public void SEVV2858_TC93005_AltEVV_Emp_Required_Fields_Json_Validation() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Emp_Required_Fields_Json_Validation");

		logger.log(LogStatus.INFO, "Validate valid employee with fully populated required value in JSON"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeOtherID", null);

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//Validate valid employee with fully populated required value in DB
	@Test(groups = {"All"})
	public void SEVV2858_TC93005_AltEVV_Emp_Required_Fields_DB_Validation() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Emp_Required_Fields_DB_Validation ");

		logger.log(LogStatus.INFO, "// validate the Staff Intake JSON with max value  only"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeOtherID", null);
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//Validate invalid employee required field is populated except EmployeeQualifier 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeQualifier__missing_ElementandValue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeQualifier__missing_ElementandValue ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeQualifier "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeQualifier");

		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeQualifier cannot be NULL."));
	}

	//Validate invalid employee required field is populated except EmployeeIdentifier 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeIdentifier__missing_ElementandValue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeIdentifier__missing_ElementandValue ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeIdentifier "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeIdentifier");

		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeIdentifier cannot be NULL."));

	}

	//Validate invalid employee required field is populated except SequenceID 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93005_AltEVV_Emp_Required_Fields_SequenceID__missing_ElementandValue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Emp_Required_Fields_SequenceID__missing_ElementandValue ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except SequenceID "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("SequenceID");

		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The SequenceID cannot be NULL."));

	}

	//Validate invalid employee required field is populated except EmployeeSSN 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeSSN__missing_ElementandValue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeSSN__missing_ElementandValue ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeSSN "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeSSN");

		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSSN cannot be NULL."));

	}

	//Validate invalid employee required field is populated except EmployeeLastName 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeLastName__missing_ElementandValue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeLastName__missing_ElementandValue ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeLastName "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeLastName");

		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeLastName cannot be NULL."));

	}

	//Validate invalid employee required field is populated except EmployeeFirstName 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeFirstName__missing_ElementandValue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeFirstName__missing_ElementandValue ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeFirstName "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeFirstName");


		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeFirstName cannot be NULL."));

	}

	//Validate invalid employee required field is populated except EmployeeEmail 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeEmail__missing_ElementandValue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeEmail__missing_ElementandValue ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeEmail "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeEmail");


		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeEmail cannot be NULL."));

	}

}