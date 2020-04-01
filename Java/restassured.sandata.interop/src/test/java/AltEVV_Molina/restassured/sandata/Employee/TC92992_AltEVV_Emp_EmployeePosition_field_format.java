/**
 * 
 */
package AltEVV_Molina.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */

// Test Case 92992:Alt EVV-Worker-Validate (Negative) - EmployeePosition field formats/values

	import com.globalMethods.core.Assertion_DbVerifier; public class TC92992_AltEVV_Emp_EmployeePosition_field_format extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All", "Regression"})
	public void TC92992_AltEVV_Emp_EmployeePosition_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
	
	// logger = extent.startTest("TC92992_AltEVV_Emp_EmployeePosition_invalid");
	logger.log(LogStatus.INFO, "Validating_EmployeePosition_field_invalid"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeePosition, CommonMethods.generateRandomAlphaNumeric(4));

	String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	
	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePositionLengthError);
   }
	
	@Test(groups = {"All", "Regression"})
	public void TC92992_AltEVV_Emp_EmployeePosition_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
	
	// logger = extent.startTest("TC92992_AltEVV_Emp_EmployeePosition_specialchars");
	logger.log(LogStatus.INFO, "TC92992_AltEVV_Emp_EmployeePosition_specialchars"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeePosition, CommonMethods.generateRandomAlphaNumeric(2) +CommonMethods.generateSpecialChar(1));

	String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	
	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePositionformaterrorMolina);
}

	@Test(groups = {"All", "Regression"})
	public void TC92992_AltEVV_Emp_EmployeePosition_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
	
	// logger = extent.startTest("TC92992_AltEVV_Emp_EmployeePosition_alphanumeric");
	logger.log(LogStatus.INFO, "TC92992_AltEVV_Emp_EmployeePosition_alphanumeric"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeePosition, CommonMethods.generateRandomAlphaNumeric(2));

	String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	
	
	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePositionformaterrorMolina);
}
	@Test(groups = {"All", "Regression"})
	public void TC92992_AltEVV_Emp_EmployeePosition_alphabet() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
	
	// logger = extent.startTest("TC92992_AltEVV_Emp_EmployeePosition_alphabet");
	logger.log(LogStatus.INFO, "TC92992_AltEVV_Emp_EmployeePosition_alphabet"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeePosition, CommonMethods.generateRandomStringOfFixLength(1));

	String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	
	
	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePositionformaterrorMolina);
}
}
