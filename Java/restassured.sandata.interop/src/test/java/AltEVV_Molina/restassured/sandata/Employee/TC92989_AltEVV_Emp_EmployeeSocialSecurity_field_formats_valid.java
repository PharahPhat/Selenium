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

//Test Case 92989:Alt EVV-Worker-Validate (Positive) - EmployeeSocialSecurity field formats/values
import com.globalMethods.core.Assertion_DbVerifier; public class TC92989_AltEVV_Emp_EmployeeSocialSecurity_field_formats_valid extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	@Test(groups = {"All", "Regression"})
	public void TC92989_AltEVV_Emp_EmployeeSocialSecurity_numeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	
	// logger = extent.startTest("TC92989_AltEVV_Emp_EmployeeSocialSecurity_numeric");
	logger.log(LogStatus.INFO, "TC92989_AltEVV_Emp_EmployeeSocialSecurity_numeric"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeSocialSecurity, CommonMethods.generateRandomNumberOfFixLength(9));

	CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
}
	
	@Test(groups = {"All", "Regression"})
	public void TC92989_AltEVV_Emp_EmployeeSocialSecurity_leadingzeros() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	
	// logger = extent.startTest("TC92989_AltEVV_Emp_EmployeeSocialSecurity_leadingzeros");
	logger.log(LogStatus.INFO, "TC92989_AltEVV_Emp_EmployeeSocialSecurity_leadingzeros"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeSocialSecurity,  "0" + CommonMethods.generateRandomNumberOfFixLength(8));

	CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
}
	
	@Test(groups = {"All"})
	public void TC92989_AltEVV_Emp_EmployeeSocialSecurity_headingzeros() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException

	{
	
	// logger = extent.startTest("TC92989_AltEVV_Emp_EmployeeSocialSecurity_headingzeros");
	logger.log(LogStatus.INFO, "TC92989_AltEVV_Emp_EmployeeSocialSecurity_headingzeros"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeSocialSecurity, CommonMethods.generateRandomNumberOfFixLength(8) +"0" );

	CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}
	
}
