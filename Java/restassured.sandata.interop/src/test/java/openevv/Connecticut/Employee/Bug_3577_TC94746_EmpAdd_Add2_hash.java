package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

/**
 * @author MayankM
 */
// TC94743 : Inter-Op: Verifies if EmployeeAddress, EmployeeAddress2 & EmployeeCity fields are accepting values with letters

public class Bug_3577_TC94746_EmpAdd_Add2_hash extends BaseTest
{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void TC94746_EmpAdd_Add2_hash_validation() throws Exception
	{
		// logger = extent.startTest("TC94746_EmpAdd_Add2_hash_validation");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject js = (JSONObject) jsonArr.get(0);

		js.put(globalVariables.EmployeeAddress1, CommonMethods.generateRandomAlphaNumeric(15) +"#" +
				CommonMethods.generateRandomAlphaNumeric(5));
		js.put(globalVariables.EmployeeAddress2, CommonMethods.generateRandomAlphaNumeric(15) + "#" +
				CommonMethods.generateRandomAlphaNumeric(5));

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

	}

}
