package AltEVV_Molina.restassured.sandata.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.apache.commons.lang.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author MayankM
 */
//Test Case 91391: OpenEVV-altEVV- employee - EmployeeFirstName validation field formats/values.

public class SEVV2858_TC92987_AltEVV_EmployeeFirstName extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the valid  EmployeeFirstName by passing the String Value of 30chars
	@Test(groups = {"All"})
	public void SEVV2858_TC92987_AltEVV_EmployeeFirstName_valid_String_30char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC92987_AltEVV_EmployeeFirstName_valid_String_30char");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",CommonMethods.generateRandomStringOfFixLength(30));
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the valid  EmployeeFirstName by passing the String Value of less than 30chars
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92987_AltEVV_EmployeeFirstName_valid_String_exceeding_30char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC92987_AltEVV_EmployeeFirstName_valid_String_lessthan_30char");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",CommonMethods.generateRandomStringOfFixLength(31));
		
		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpFNameLengthError);
	}

	//To validate the valid  EmployeeFirstName by passing the String Value as min value as 1 chars
	@Test(groups = {"All"})
	public void SEVV2858_TC92987_AltEVV_EmployeeFirstName_valid_String_minvalue_1char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC92987_AltEVV_EmployeeFirstName_valid_String_minvalue_1char");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",CommonMethods.generateRandomStringOfFixLength(1));
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the valid  EmployeeFirstName by passing the String Value as whitespace
	@Test(groups = {"All"})
	public void SEVV2858_TC92987_AltEVV_EmployeeFirstName_valid_String_with_whiteSpace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC92987_AltEVV_EmployeeFirstName_valid_String_with_whiteSpace");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",CommonMethods.generateRandomStringOfFixLength(5) + " " +CommonMethods.generateRandomStringOfFixLength(5) );
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the valid  EmployeeFirstName by passing the String Value as null 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92987_AltEVV_EmployeeFirstName_valid_String_with_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC92987_AltEVV_EmployeeFirstName_valid_String_with_null");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",null);
		
		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpFNameNullError);
	}

	//To validate the invalid  EmployeeFirstName by passing the value as numeric
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92987_AltEVV_EmployeeFirstName_invalid_numeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC92987_AltEVV_EmployeeFirstName_invalid_numeric");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",CommonMethods.generateRandomNumberOfFixLength(5));
		
		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpFNameFormatError);
	}

	//To validate the invalid  EmployeeFirstName by passing the value as alphanumeric
	@Test(groups = {"All", "Regression", "fixing"})
	public void SEVV2858_TC92987_AltEVV_EmployeeFirstName_invalid_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC92987_AltEVV_EmployeeFirstName_invalid_alphanumeric");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName", RandomStringUtils.randomAlphanumeric(5));
		
		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpFNameFormatError);
	}

	//To validate the invalid  EmployeeFirstName by passing the value as special chars
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92987_AltEVV_EmployeeFirstName_invalid_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC92987_AltEVV_EmployeeFirstName_invalid_specialchars");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",CommonMethods.generateSpecialChar(10));
		
		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpFNameFormatError);
	}

	//To validate the invalid  EmployeeFirstName by passing the value as blank
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92987_AltEVV_EmployeeFirstName_invalid_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC92987_AltEVV_EmployeeFirstName_invalid_blank");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName","");
		
		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpFNameFormatError);
	}

	//To validate the invalid  EmployeeFirstName by passing the value as leading space
	@Test(groups = {"All"})
	public void SEVV2858_TC92987_AltEVV_EmployeeFirstName_invalid_leading_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC92987_AltEVV_EmployeeFirstName_invalid_leading_space");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName"," " + CommonMethods.generateRandomStringOfFixLength(10));
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the invalid  EmployeeFirstName by passing the value as trailing space
	@Test(groups = {"All"})
	public void SEVV2858_TC92987_AltEVV_EmployeeFirstName_invalid_trailing_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC92987_AltEVV_EmployeeFirstName_invalid_trailing_space");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeFirstName",CommonMethods.generateRandomStringOfFixLength(10)+ " ");
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	
}