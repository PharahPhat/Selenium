package AltEVV_Molina.restassured.sandata.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV4427_TC97933_ALTEVV_CTCDS_EmployeeSSN_invalidcases extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void TC97932_ALTEVV_CTCDS_EmployeeSSN_exceeds_max_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException
	{
		// logger = extent.startTest("TC97932_ALTEVV_CTCDS_EmployeeSSN_max_length_validation");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeSSN", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffSSNFormatError);
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC97932_ALTEVV_CTCDS_EmployeeSSN_Alphanumeric_max_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException
	{
		// logger = extent.startTest("TC97932_ALTEVV_CTCDS_EmployeeSSN_Alphanumeric_max_length");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeSSN", CommonMethods.generateRandomAlphaNumeric(9));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffSSNFormatError);
	}
}
