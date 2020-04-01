package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author MayankM
 */
//Test Case 88268:Open EVV - employee - Only Required Field

public class TC88268_Emp_Required_Field_Only extends BaseTest { 
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void TC88268_OpenEVV_Employee_Required_Field_Validation() throws InterruptedException, IOException, ParseException, java.text.ParseException 
	{
		// logger = extent.startTest("TC88268_OpenEVV_Employee_Required_Field_Validation");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.openevv_emp_req_json);

		JSONObject jsobject = (JSONObject) jsonArr.get(0);
		
		jsobject.put("EmployeePhone", null);

		jsobject.put("EmployeeAltPhone",null);

		jsobject.put("EmployeeAltPhone2", null);

		jsobject.put("EmployeeID", null);

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}
}


