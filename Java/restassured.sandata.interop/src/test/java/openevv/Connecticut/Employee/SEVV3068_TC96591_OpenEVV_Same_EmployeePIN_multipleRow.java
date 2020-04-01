package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV3068_TC96591_OpenEVV_Same_EmployeePIN_multipleRow extends BaseTest{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void TC96591_OpenEVV_Employee_Update_with_existing_ID_PIN_validation() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96591_OpenEVV_Employeeupdate_with_existing_ID_PIN_validation");

		String EmpSSN= CommonMethods.generateRandomNumberOfFixLength(9);
		String EmpPin= CommonMethods.generateRandomNumberOfFixLength(9);
		String EmployeeAddress1= CommonMethods.generateRandomStringOfFixLength(15);
		String EmpPhone= CommonMethods.generateRandomNumberOfFixLength(10);
		String EmpFirstname= CommonMethods.generateRandomStringOfFixLength(8);
		String EmpLastname= CommonMethods.generateRandomStringOfFixLength(8);
		String EmpEmailadd= CommonMethods.generateEmailAddress_string(8);

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeSocialSecurity", EmpSSN);
		jsonObject.put("EmployeePIN", EmpPin);
		jsonObject.put("EmployeeAddress1", EmployeeAddress1);
		jsonObject.put("EmployeePhone", EmpPhone);
		jsonObject.put("EmployeeFirstName", EmpFirstname );
		jsonObject.put("EmployeeLastName", EmpLastname);
		jsonObject.put("EmployeeEmailAddress", EmpEmailadd);

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		Thread.sleep(5000);
		jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeSocialSecurity", EmpSSN);
		jsonObject.put("EmployeePIN", EmpPin);
		jsonObject.put("EmployeeAddress1", EmployeeAddress1);
		jsonObject.put("EmployeePhone", EmpPhone);
		jsonObject.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(10));
		jsonObject.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(10));
		jsonObject.put("EmployeeEmailAddress", EmpEmailadd);

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}
}
