/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
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
//Test Case 92989:Alt EVV-Worker-Validate (Positive) - EmployeeSocialSecurity field formats/values

public class TC92989_AltEVV_Emp_EmployeeSocialSecurity_field_formats_valid extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void TC92989_AltEVV_Emp_EmployeeSocialSecurity_numeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	
	// logger = extent.startTest("TC92989_AltEVV_Emp_EmployeeSocialSecurity_numeric");
	logger.log(LogStatus.INFO, "TC92989_AltEVV_Emp_EmployeeSocialSecurity_numeric"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeSocialSecurity, CommonMethods.generateRandomNumberOfFixLength(9));

	CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
	}
}
