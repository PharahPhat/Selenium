package AltEVV_generic.restassured.sandata.Indiana.Employee;

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
import java.sql.SQLException;

/**
 * @author RRohiteshwar
 */
//Test Case 91123: Alt EVV-Worker-Validate - Required Fields Missing [element and value]

public class R2267_TC91123_AltEVV_Emp_Required_Fields__missing_ElementandValue extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//Validate invalid employee required field is populated except EmployeeQualifier 
	@Test(groups = {"All"})
	public void R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeQualifier__missing_ElementandValue() throws InterruptedException, IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeQualifier__missing_ElementandValue ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeQualifier "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeQualifier");

		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifier_Error);
	}

	//Validate invalid employee required field is populated except EmployeeIdentifier 
	@Test(groups = {"All"})
	public void R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeIdentifier__missing_ElementandValue() throws InterruptedException, IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeIdentifier__missing_ElementandValue ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeIdentifier "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeIdentifier");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorEmployeeIdentifierNull);
	}

	//Validate invalid employee required field is populated except SequenceID 
	@Test(groups = {"All"})
	public void R2267_TC91123_AltEVV_Emp_Required_Fields_SequenceID__missing_ElementandValue() throws InterruptedException, IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2267_TC91123_AltEVV_Emp_Required_Fields_SequenceID__missing_ElementandValue ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except SequenceID "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("SequenceID");

		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorSequenceIdNull);
	}

	//Validate invalid employee required field is populated except EmployeeSSN 
	@Test(groups = {"All"})
	public void R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeSSN__missing_ElementandValue() throws InterruptedException, IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeSSN__missing_ElementandValue ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeSSN "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeSSN");

		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeSSN cannot be NULL."));

	}

	//Validate invalid employee required field is populated except EmployeeLastName 
	@Test(groups = {"All"})
	public void R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeLastName__missing_ElementandValue() throws InterruptedException, IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeLastName__missing_ElementandValue ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeLastName "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeLastName");

		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeLastName cannot be NULL."));

	}

	//Validate invalid employee required field is populated except EmployeeFirstName 
	@Test(groups = {"All"})
	public void R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeFirstName__missing_ElementandValue() throws InterruptedException, IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2267_TC91123_AltEVV_Emp_Required_Fields_EmployeeFirstName__missing_ElementandValue ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeFirstName "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("EmployeeFirstName");


		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeFirstName cannot be NULL."));

	}
}