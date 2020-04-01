package AltEVV_Molina.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

import com.globalMethods.core.Assertion_DbVerifier; 

public class SEVV2858_TC92993_AltEVV_EmployeeIdentifier extends BaseTest { 
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the valid  EmployeeIdentifier 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92993_AltEVV_EmployeeIdentifier_valid_string() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("SEVV2858_TC92993_AltEVV_EmployeeIdentifier_valid_string");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeIdentifier",CommonMethods.generateRandomStringOfFixLength(9));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC92993_AltEVV_EmployeeIdentifier_valid_numeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC92993_AltEVV_EmployeeIdentifier_valid_string");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeIdentifier",CommonMethods.generateRandomNumberOfFixLength(9));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}
	
	@Test(groups = {"All"})
	public void SEVV2858_TC92993_AltEVV_EmployeeIdentifier_valid_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException
	
	{
		// logger = extent.startTest("SEVV2858_TC92993_AltEVV_EmployeeIdentifier_valid_string");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeIdentifier",(CommonMethods.generateRandomAlphaNumeric(9)));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92993_AltEVV_EmployeeIdentifier_invalid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC92993_AltEVV_EmployeeIdentifier_invalid_length");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeIdentifier",CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The EmployeeIdentifier format is incorrect. The record should satisfy this regular expression");
	}

	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92993_AltEVV_EmployeeIdentifier_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC92993_AltEVV_EmployeeIdentifier_blank");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeIdentifier", "");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The EmployeeIdentifier format is incorrect. The record should satisfy this regular expression");
	}

	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92993_AltEVV_EmployeeIdentifier_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC92993_AltEVV_EmployeeIdentifier_invalid_length");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeIdentifier",null);

		String bodyAsString = 
				CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpIdentifierNullError);
	}

}

