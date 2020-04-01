package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

/**
 * @author MayankM
 */
// TC94750 : Inter-Op: Verifies if EmployeeAddress1 & EmployeeAddress2 fields are accepting values with ' / ' 

public class Bug_3577_TC94750_EmpAdd_Add2_slash extends BaseTest
{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void TC94750_EmpAdd_Add2_slash_validation() throws Exception
	{
		// logger = extent.startTest("TC94750_EmpAdd_Add2_slash_validation");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject js = (JSONObject) jsonArr.get(0);

		js.put(globalVariables.EmployeeAddress1,CommonMethods.getSaltString(10) + "/" + CommonMethods.generateRandomStringOfFixLength(5));
		js.put(globalVariables.EmployeeAddress2, CommonMethods.getSaltString(10) + "/" + CommonMethods.generateRandomStringOfFixLength(5));

		CommonMethods.validateResponse(jsonArr,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}
}
