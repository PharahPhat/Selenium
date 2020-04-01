/**
 * 
 */
package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorEmployee;
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
// Test Case 88848:Open EVV-Worker-Validate-Exceed Maximum Values > to be rejected

public class TC88848_Emp_Values_Exceeding_Max_length extends BaseTest {

	//To validate the the scenario with exceeding max length
	@Test(groups = {"All", "fixing"})
	public void TC88848_OpenEVV_valid_EmployeeFirstName() throws IOException, ParseException
	{
		// logger = extent.startTest("TC88848_OpenEVV_valid_EmployeeFirstName");

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", CommonMethods.generateRandomStringOfFixLength(31));
		js.put("EmployeeLastName", CommonMethods.generateRandomStringOfFixLength(31));
		js.put("EmployeePIN", DataGeneratorEmployee.generateEmpPIN(10));
		js.put("EmployeeEmailAddress", DataGeneratorEmployee.generateEmpEmail(39));

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeFirstName value exceeds the maximum length of 30 characters.  The record is being rejected. The length should be between 1 and 30."));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeLastName value exceeds the maximum length of 30 characters.  The record is being rejected. The length should be between 1 and 30."));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN value exceeds the maximum length of 9 characters.  The record is being rejected. The length should be between 4 and 9."));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeEmailAddress value exceeds the maximum length of 50 characters.  The record is being rejected. The length should be between 0 and 50."));
	}

}