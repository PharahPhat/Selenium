/**
 * 
 */
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
 *
 */

public class SEVV3795_TC96522_OpenEVV_EmployeeHireDate_with_Pastdate_valid extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void TC96522_OpenEVV_EmployeeHireDate_with_Pastdate_valid() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("TC96522_OpenEVV_EmployeeHireDate_with_Pastdate_valid");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeHireDate, "08011991");

		CommonMethods.validateResponse(jsonArr,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}
}
