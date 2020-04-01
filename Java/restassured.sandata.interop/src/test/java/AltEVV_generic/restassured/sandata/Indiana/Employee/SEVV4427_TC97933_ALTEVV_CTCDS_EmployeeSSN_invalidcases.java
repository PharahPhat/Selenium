package AltEVV_generic.restassured.sandata.Indiana.Employee;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV4427_TC97933_ALTEVV_CTCDS_EmployeeSSN_invalidcases extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void TC97932_ALTEVV_CTCDS_EmployeeSSN_exceeds_max_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException
	{
		// logger = extent.startTest("TC97932_ALTEVV_CTCDS_EmployeeSSN_max_length_validation");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeSSN", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffSSNFormatError);
	}
	
	@Test(groups = {"All"})
	public void TC97932_ALTEVV_CTCDS_EmployeeSSN_Alphanumeric_max_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException
	{
		// logger = extent.startTest("TC97932_ALTEVV_CTCDS_EmployeeSSN_Alphanumeric_max_length");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeSSN", CommonMethods.generateRandomAlphaNumeric(9));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffSSNFormatError);
	}
}
