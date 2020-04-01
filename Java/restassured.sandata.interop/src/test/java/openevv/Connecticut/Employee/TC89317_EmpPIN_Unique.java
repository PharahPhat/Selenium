/**
 * 
 */
package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorEmployee;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author MayankM
 */
// Test Case 89317:Open-EVV : employee Pin filed should be unique for every worker.

public class TC89317_EmpPIN_Unique extends BaseTest
{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	//To validate the valid EmployeePIN length max 9
	@Test(groups = {"All"})
	public void TC89317_OpenEVV_EmployeePIN_valid_length_9() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		String emppin=DataGeneratorEmployee.generateEmpPIN(9);
		
		// logger = extent.startTest("TC89317_OpenEVV_EmployeePIN_valid_length_9");

		logger.log(LogStatus.INFO, "To validate the valid EmployeePIN length max 9");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV("employee");

		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", emppin);
	
		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	//To validate the valid EmployeePIN length max 4
	@Test(groups = {"All"})
	public void TC89317_OpenEVV_EmployeePIN_valid_length_4() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		String emppin1= DataGeneratorEmployee.generateEmpPIN(4);

		// logger = extent.startTest("TC89317_OpenEVV_EmployeePIN_valid_length_4");

		logger.log(LogStatus.INFO, "To validate the valid EmployeePIN length max 4 duplicate");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV("employee");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePIN", emppin1 );

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

}
