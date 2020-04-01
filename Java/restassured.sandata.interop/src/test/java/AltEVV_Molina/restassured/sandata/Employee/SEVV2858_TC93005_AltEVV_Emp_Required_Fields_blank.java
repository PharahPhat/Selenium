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

public class SEVV2858_TC93005_AltEVV_Emp_Required_Fields_blank extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Validate invalid employee required field is populated except EmployeeQualifier 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeQualifier_Blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeQualifier_Blank ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeQualifier "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeQualifier", null);

		String resp = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(resp.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(resp.contains("ERROR: The EmployeeQualifier cannot be NULL."));
	}

	//Validate invalid employee required field is populated except EmployeeIdentifier 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeIdentifier_Blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeIdentifier_Blank ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeIdentifier "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeIdentifier", null);


		String resp = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(resp.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(resp.contains("ERROR: The EmployeeIdentifier cannot be NULL."));

	}

	//Validate invalid employee required field is populated except SequenceID 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93005_AltEVV_Emp_Required_Fields_SequenceID_Blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Emp_Required_Fields_SequenceID_Blank ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except SequenceID "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("SequenceID", null);

		String resp = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(resp.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(resp.contains("ERROR: The SequenceID cannot be NULL."));

	}

	//Validate invalid employee required field is populated except EmployeeSSN 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeSSN_Blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeSSN_Blank ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeSSN "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeSSN");

		String bodystring = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(bodystring.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodystring.contains("ERROR: The EmployeeSSN cannot be NULL."));

	}

	//Validate invalid employee required field is populated except EmployeeLastName 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeLastName_Blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeLastName_Blank ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeLastName "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeLastName", null);

		String bodystring = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(bodystring.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodystring.contains("ERROR: The EmployeeLastName cannot be NULL."));

	}

	//Validate invalid employee required field is populated except EmployeeFirstName 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeFirstName_Blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeFirstName_Blank ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeFirstName "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeFirstName", null);

		String bodystring = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(bodystring.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodystring.contains("ERROR: The EmployeeFirstName cannot be NULL."));

	}

	//Validate invalid employee required field is populated except EmployeeEmail 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeEmail_Blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Emp_Required_Fields_EmployeeEmail_Blank ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeEmail "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeEmail", null);

		String bodystring = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));


		Assert.assertTrue(bodystring.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodystring.contains("ERROR: The EmployeeEmail cannot be NULL."));

	}

	
}