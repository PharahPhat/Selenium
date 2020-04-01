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

public class SEVV4427_TC97934_ALTEVV_CTCDS_EmployeeIdentifier_validation extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void TC97934_ALTEVV_CTCDS_EmployeeIdentifier_leading_zero() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC97934_ALTEVV_CTCDS_EmployeeIdentifier_leading_zero");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("EmployeeIdentifier", "0000" + CommonMethods.generateRandomNumberOfFixLength(5));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

	}
}
