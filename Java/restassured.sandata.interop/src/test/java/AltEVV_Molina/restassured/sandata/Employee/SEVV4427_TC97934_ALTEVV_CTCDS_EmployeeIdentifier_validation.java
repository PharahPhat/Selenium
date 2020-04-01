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

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; 

public class SEVV4427_TC97934_ALTEVV_CTCDS_EmployeeIdentifier_validation extends BaseTest { 
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
		@Test(groups = {"All"})
		public void TC97934_ALTEVV_CTCDS_EmployeeIdentifier_validation() throws InterruptedException, IOException, ParseException, java.text.ParseException

		{
			// logger = extent.startTest("TC97934_ALTEVV_CTCDS_EmployeeIdentifier_validation");

			JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
			JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

			jsonObject.put("EmployeeIdentifier",CommonMethods.generateRandomStringOfFixLength(9));

			CommonMethods.validateResponse(jsonArray,
					CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
		}
		
		@Test(groups = {"All"})
		public void TC97934_ALTEVV_CTCDS_EmployeeIdentifier_leading_zero() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException

		{
			// logger = extent.startTest("TC97934_ALTEVV_CTCDS_EmployeeIdentifier_leading_zero");

			JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
			JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

			jsonObject.put("EmployeeIdentifier",  CommonMethods.generateRandomNumberOfFixLength(5));

			CommonMethods.validateResponse(jsonArray,
					CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
		}

		@Test(groups = {"All"})
		public void TC97934_ALTEVV_CTCDS_EmployeeIdentifier_length_validation() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException

		{
			// logger = extent.startTest("TC97934_ALTEVV_CTCDS_EmployeeIdentifier_length_validation");

			JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
			JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

			jsonObject.put("EmployeeIdentifier", CommonMethods.generateRandomNumberOfFixLength(8));

			CommonMethods.validateResponse(jsonArray,
					CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		}

		@Test(groups = {"All"})
		public void TC97934_ALTEVV_CTCDS_EmployeeIdentifier_single_digit() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException

		{
			// logger = extent.startTest("TC97934_ALTEVV_CTCDS_EmployeeIdentifier_single_digit");

			JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
			JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

			jsonObject.put("EmployeeIdentifier", CommonMethods.generateRandomNumberOfFixLength(1));

			CommonMethods.validateResponse(jsonArray,
					CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		}

}
