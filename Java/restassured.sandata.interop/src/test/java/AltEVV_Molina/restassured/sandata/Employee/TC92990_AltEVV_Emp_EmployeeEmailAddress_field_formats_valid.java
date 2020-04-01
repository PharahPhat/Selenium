/**
 * 
 */
package AltEVV_Molina.restassured.sandata.Employee;

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

/**
 * @author Anupam
 */

public class TC92990_AltEVV_Emp_EmployeeEmailAddress_field_formats_valid extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All"})
	public void TC92990_AltEVV_Emp_EmployeeEmailAddress_alphanumeric_valid() throws InterruptedException, IOException, ParseException
	{
	
	// logger = extent.startTest("TC92990_AltEVV_Emp_EmployeeEmailAddress_alphanumeric_valid");
	logger.log(LogStatus.INFO, "Validating_EmployeeEmailAddress_field_with_alphanumeric"); 
	
	
	 JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
	
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
	jsonObject.put(globalVariables.EmployeeEmail, CommonMethods.generateEmailAddress_string(8));

	 CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

	}
}
