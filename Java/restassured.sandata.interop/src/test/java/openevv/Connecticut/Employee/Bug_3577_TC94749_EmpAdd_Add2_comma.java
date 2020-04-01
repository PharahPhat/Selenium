package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

/**
 * @author MayankM
 */
// TC94749 : Inter-Op: Verifies if EmployeeAddress, EmployeeAddress2 & EmployeeCity fields are accepting values with ,

public class Bug_3577_TC94749_EmpAdd_Add2_comma extends BaseTest
{
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void TC94749_EmpAdd_Add2_City_comma_validation() throws Exception
	{
		// logger = extent.startTest("TC94749_EmpAdd_Add2_City_comma_validation");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject js = (JSONObject) jsonArr.get(0);

		js.put(globalVariables.EmployeeAddress1,CommonMethods.getSaltString(10) + "," + CommonMethods.generateRandomStringOfFixLength(5));
		js.put(globalVariables.EmployeeAddress2, CommonMethods.getSaltString(10) + "," + CommonMethods.generateRandomStringOfFixLength(5));

		js.put("EmployeeZipCode", "12345");
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

}
