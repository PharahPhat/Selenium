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

/**
 * @author Anupam
 */
// Test Case 96795: OpenEVV employee- Validate EmployeeAPI field for positive values

public class R2154_TC96795_OpenEVV_EmployeeAPI_Valid extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	// Case2: EmployeeAPI = 25 (All digits)- Max Length

	@Test(groups = {"Smoke"})
	public void TC96795_OpenEVV_EmployeeAPI_numeric_maxlength() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("TC96795_OpenEVV_EmployeeAPI_numeric_maxlength");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeAPI, CommonMethods.generateRandomNumberOfFixLength(25));

		CommonMethods.validateResponse(jsonArr,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

	// Case3: EmployeeAPI- null 

	@Test(groups = {"All"})
	public void TC96795_OpenEVV_EmployeeAPI_with_null() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("TC96795_OpenEVV_EmployeeAPI_with_null");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeAPI, null);

		CommonMethods.validateResponse(jsonArr,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}
}
