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
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author RRohiteshwar
 */

public class SEVV2858_TC95974_AltEVV_EmployeeOtherID extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	//To validate the valid  EmployeeOtherID by passing the String Value of 64char with correct format
	@Test(groups = {"All"})
	public void SEVV2858_TC95974_AltEVV_EmployeeOtherID_valid_String_64char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC95974_AltEVV_EmployeeOtherID_valid_String_64char");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeOtherID", CommonMethods.generateRandomStringOfFixLength(64));


		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

}

	//To validate the valid  EmployeeOtherID by passing the String Value less than 64char with correct format
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC95974_AltEVV_EmployeeOtherID_valid_String_lessthan_64char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("SEVV2858_TC95974_AltEVV_EmployeeOtherID_valid_String_lessthan_64char");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeOtherID", CommonMethods.generateRandomStringOfFixLength(1));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the valid  EmployeeOtherID by passing the String Value as null in DB
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC95974_AltEVV_EmployeeOtherID_valid_String_null_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("SEVV2858_TC95974_AltEVV_EmployeeOtherID_valid_String_null_DB");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeOtherID", null);

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}


	//To validate the invalid  EmployeeOtherID by passing the String Value having no value
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC95974_AltEVV_EmployeeOtherID_invalid_String_withnovalue() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC95974_AltEVV_EmployeeOtherID_invalid_String_withnovalue");

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeOtherID by passing the String Value having no value"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeOtherID", "");

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,"ERROR: The EmployeeOtherID value is greater than 64 characters. The length should be between 1 and 64.");
	}

	//To validate the invalid  EmployeeOtherID by passing the String Value of  more than 64char
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC95974_AltEVV_EmployeeOtherID_invalid_String_morethan_64() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC95974_AltEVV_EmployeeOtherID_invalid_String_morethan_64");

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeOtherID by passing the String Value of  more than 64char"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeOtherID", CommonMethods.generateRandomNumberOfFixLength(65));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The EmployeeOtherID value is greater than 64 characters.");
	}

	//To validate the invalid  EmployeeOtherID by passing the String Value as special character and numr
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC95974_AltEVV_EmployeeOtherID_invalid_String_specialchar_num() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC95974_AltEVV_EmployeeOtherID_invalid_String_specialchar_num");

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeOtherID by passing the String Value as special character and numr"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeOtherID", CommonMethods.generateRandomNumberOfFixLength(10)+ CommonMethods.generateSpecialChar(5)+ CommonMethods.generateRandomNumberOfFixLength(3));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,"The EmployeeOtherID format is incorrect.");
	}

	//To validate the invalid  EmployeeOtherID by passing the String Value of  more than 64char including special char
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC95974_AltEVV_EmployeeOtherID_invalid_String_specialchar_num_morethan_64() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC95974_AltEVV_EmployeeOtherID_invalid_String_specialchar_num_morethan_64");

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeOtherID by passing the String Value of  more than 64char including special char"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeOtherID", CommonMethods.generateRandomNumberOfFixLength(30)+ CommonMethods.generateSpecialChar(20)+ CommonMethods.generateRandomNumberOfFixLength(20));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The EmployeeOtherID value is greater than 64 characters.");
	}


}