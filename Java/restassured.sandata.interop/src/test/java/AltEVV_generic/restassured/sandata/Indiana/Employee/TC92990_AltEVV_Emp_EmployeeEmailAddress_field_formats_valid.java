/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Employee;

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
 * @author Anupam
 */

public class TC92990_AltEVV_Emp_EmployeeEmailAddress_field_formats_valid extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void TC92990_AltEVV_Emp_EmployeeEmailAddress_without_dashes_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	
	// logger = extent.startTest("TC92990_AltEVV_Emp_EmployeeEmailAddress_without_dashes_valid");
	logger.log(LogStatus.INFO, "Validating_EmployeeEmailAddress_field_without_dashes"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeEmail, CommonMethods.generateEmailAddress_alpha(6));

	CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
	
	
		
   }
	
	@Test(groups = {"All"})
	public void TC92990_AltEVV_Emp_EmployeeEmailAddress_alphanumeric_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	
	// logger = extent.startTest("TC92990_AltEVV_Emp_EmployeeEmailAddress_alphanumeric_valid");
	logger.log(LogStatus.INFO, "Validating_EmployeeEmailAddress_field_with_alphanumeric"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeEmail, CommonMethods.generateEmailAddress_string(8));

	CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
}

	@Test(groups = {"All"})
	public void TC92990_AltEVV_Emp_EmployeeEmailAddress_alphabet() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	
	// logger = extent.startTest("TC92990_AltEVV_Emp_EmployeeEmailAddress_alphabet");
	logger.log(LogStatus.INFO, "TC92990_AltEVV_Emp_EmployeeEmailAddress_alphabet"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeEmail, CommonMethods.generateEmailAddress_alpha(20));

	CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
}
	
	@Test(groups = {"All"})
	public void TC92990_AltEVV_Emp_EmployeeEmailAddress_numeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	
	// logger = extent.startTest("TC92990_AltEVV_Emp_EmployeeEmailAddress_numeric");
	logger.log(LogStatus.INFO, "TC92990_AltEVV_Emp_EmployeeEmailAddress_numeric"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeEmail, CommonMethods.generateEmailAddress_num(6));

	CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
	
	
		
}
}
