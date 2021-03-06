/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
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
//Test Case 92986:Alt EVV-Worker-Validate (Positive values) - EmployeeLastName field formats/values

public class TC92986_AltEVV_Emp_EmployeeLastName_field_formats extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	@Test(groups = {"All"})
	public void TC92986_AltEVV_Emp_EmployeeLastName_with_alphabet() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	
	// logger = extent.startTest("TC92986_AltEVV_Emp_EmployeeLastName_with_alphabet");
	logger.log(LogStatus.INFO, "Validating_EmployeeLastName_field_with_alphabets"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeLastName, CommonMethods.generateRandomStringOfFixLength(10));

	CommonMethods.validateResponse(jsonArray,
			CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
}
	
	@Test(groups = {"All"})
	public void TC92986_AltEVV_Emp_EmployeeLastName_with_space_alphabet() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	
	// logger = extent.startTest("TC92986_AltEVV_Emp_EmployeeLastName_with_space_alphabet");
	logger.log(LogStatus.INFO, "Validating_EmployeeLastName_field_with_space and alphabets"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeLastName, CommonMethods.generateRandomStringOfFixLength(5) +" " + CommonMethods.generateRandomStringOfFixLength(5));

	CommonMethods.validateResponse(jsonArray,
			CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
}
	
	@Test(groups = {"All"})
	public void TC92986_AltEVV_Emp_EmployeeLastName_with_leadingspace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	
	// logger = extent.startTest("TC92986_AltEVV_Emp_EmployeeLastName_with_leadingspace");
	logger.log(LogStatus.INFO, "TC92986_AltEVV_Emp_EmployeeLastName_with_leadingspace and alphabets"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeLastName, CommonMethods.generateRandomStringOfFixLength(10) +" " );

	CommonMethods.validateResponse(jsonArray,
			CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
}
	
	@Test(groups = {"All"})
	public void TC92986_AltEVV_Emp_EmployeeLastName_with_trailingspace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	
	// logger = extent.startTest("TC92986_AltEVV_Emp_EmployeeLastName_with_trailingspace");
	logger.log(LogStatus.INFO, "TC92986_AltEVV_Emp_EmployeeLastName_with_trailingspace and alphabets"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeLastName, " " + CommonMethods.generateRandomStringOfFixLength(10) );

	CommonMethods.validateResponse(jsonArray,
			CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
}
	
	@Test(groups = {"All"})
	public void TC92986_AltEVV_Emp_EmployeeLastName_with_dashes() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	
	// logger = extent.startTest("TC92986_AltEVV_Emp_EmployeeLastName_with_dashes");
	logger.log(LogStatus.INFO, "TC92986_AltEVV_Emp_EmployeeLastName_with_dashes and alphabets"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeLastName, CommonMethods.generateRandomStringOfFixLength(3) +"-" +CommonMethods.generateRandomStringOfFixLength(6));

	CommonMethods.validateResponse(jsonArray,
			CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
	}
}
