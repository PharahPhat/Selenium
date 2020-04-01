package AltEVV_generic.restassured.sandata.Indiana.Employee;

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

/**
 * @author MayankM
 */
//Test Case 91103: Alt EVV-Worker-Load-Required Fields Only

public class R2267_TC91103_AltEVV_Emp_Req_Fields_Only extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "fixing"})
	public void R2267_TC91103_AltEVV_Employee_Req_Fields_Validation() throws IOException, ParseException

	{
		// logger = extent.startTest("R2267_TC7398_AltEVV_Employee_Req_Fields_Validation ");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put ("EmployeeManagerEmail", null);
		jsonObject.put("EmployeeAPI", null);
		jsonObject.put("EmployeePosition", null);
		jsonObject.put("EmployeeOtherID", null);

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
	}
}