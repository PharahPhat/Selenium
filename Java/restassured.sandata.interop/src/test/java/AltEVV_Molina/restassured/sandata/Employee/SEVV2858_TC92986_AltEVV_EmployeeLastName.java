package AltEVV_Molina.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author RRohiteshwar
 *
 */

public class SEVV2858_TC92986_AltEVV_EmployeeLastName extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the valid  EmployeeLastName by passing the String Value of 30chars
	@Test(groups = {"All"})
	public void SEVV2858_TC92986_AltEVV_EmployeeLastName_valid_String_30char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC92986_AltEVV_EmployeeLastName_valid_String_30char");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("EmployeeLastName",CommonMethods.generateRandomStringOfFixLength(30));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the valid  EmployeeLastName by passing the String Value of less than 30chars
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92986_AltEVV_EmployeeLastName_valid_String_lessthan_30char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("SEVV2858_TC92986_AltEVV_EmployeeLastName_valid_String_lessthan_30char");

		logger.log(LogStatus.INFO, "To validate the valid  EmployeeLastName by passing the String Value of less than 30chars"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(29));
	
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the valid  EmployeeLastName by passing the String Value as mid value 15chars
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92986_AltEVV_EmployeeLastName_valid_String_midvalue_15char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("SEVV2858_TC92986_AltEVV_EmployeeLastName_valid_String_midvalue_15char");

		logger.log(LogStatus.INFO, "To validate the valid  EmployeeLastName by passing the String Value as mid value 15chars"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(15));

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the valid  EmployeeLastName by passing the String Value as min value as 1 chars
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92986_AltEVV_EmployeeLastName_valid_String_minvalue_1char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("SEVV2858_TC92986_AltEVV_EmployeeLastName_valid_String_minvalue_1char");

		logger.log(LogStatus.INFO, "To validate the valid  EmployeeLastName by passing the String Value as min value as 1 chars"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(1));

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the valid  EmployeeLastName by passing the String Value as mid space
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92986_AltEVV_EmployeeLastName_valid_String_with_midSpace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("SEVV2858_TC92986_AltEVV_EmployeeLastName_valid_String_with_midSpace");

		logger.log(LogStatus.INFO, "To validate the valid  EmployeeLastName by passing the String Value as mid space"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(5)+ " " + CommonMethods.generateRandomStringOfFixLength(5) + " " + CommonMethods.generateRandomStringOfFixLength(5));

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the valid  EmployeeLastName by passing the String Value as null quoted
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92986_AltEVV_EmployeeLastName_valid_String_with_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("SEVV2858_TC92986_AltEVV_EmployeeLastName_valid_String_with_null");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("EmployeeLastName", "null");

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the invalid  EmployeeLastName by passing the value as numeric
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92986_AltEVV_EmployeeLastName_invalid_numeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC92986_AltEVV_EmployeeLastName_invalid_numeric");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("EmployeeLastName", CommonMethods.generateRandomNumberOfFixLength(15));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The EmployeeLastName format is incorrect.");
	
	}

	//To validate the invalid  EmployeeLastName by passing the value as alphanumeric
	@Test(groups = {"All", "Regression", "fixing"})
	public void SEVV2858_TC92986_AltEVV_EmployeeLastName_invalid_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC92986_AltEVV_EmployeeLastName_invalid_alphanumeric");

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeLastName by passing the value as alphanumeric"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("EmployeeLastName", CommonMethods.generateRandomAlphaNumeric(16));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The EmployeeLastName format is incorrect.");
	}

	//To validate the invalid  EmployeeLastName by passing the value as special chars
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92986_AltEVV_EmployeeLastName_invalid_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC92986_AltEVV_EmployeeLastName_invalid_specialchars");

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeLastName by passing the value as special chars"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("EmployeeLastName", CommonMethods.generateSpecialChar(16));
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The EmployeeLastName format is incorrect.");

	}

	//To validate the invalid  EmployeeLastName by passing the value as blank
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92986_AltEVV_EmployeeLastName_invalid_blank() throws IOException, ParseException, InterruptedException, java.text.ParseException
	{  
		// logger = extent.startTest("SEVV2858_TC92986_AltEVV_EmployeeLastName_invalid_blank");
	
		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("EmployeeLastName", "");


		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The EmployeeLastName format is incorrect.");
	}

	//To validate the invalid  EmployeeLastName by passing the value as leading space
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92986_AltEVV_EmployeeLastName_invalid_leading_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException {
		// logger = extent.startTest("SEVV2858_TC92986_AltEVV_EmployeeLastName_invalid_leading_space");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeLastName", " " + CommonMethods.generateRandomStringOfFixLength(15));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the invalid  EmployeeLastName by passing the value as trailing space
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92986_AltEVV_EmployeeLastName_invalid_trailing_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("SEVV2858_TC92986_AltEVV_EmployeeLastName_invalid_trailing_space");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(15) + "  ");

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}
	//To validate the invalid  EmployeeLastName by passing the null 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92986_AltEVV_EmployeeLastName_invalid__null() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC92986_AltEVV_EmployeeLastName_invalid__null");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeLastName", null);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The EmployeeLastName cannot be NULL.");
	}

}