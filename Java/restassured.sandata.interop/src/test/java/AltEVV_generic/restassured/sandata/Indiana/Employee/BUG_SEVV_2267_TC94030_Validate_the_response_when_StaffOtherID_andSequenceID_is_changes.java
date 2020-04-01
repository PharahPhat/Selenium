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

public class BUG_SEVV_2267_TC94030_Validate_the_response_when_StaffOtherID_andSequenceID_is_changes extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void SEVV_2267_TC94030_Validate_the_response_when_StaffOtherID_andSequenceID_is_changes_while_the_other_fields_remains_the_same () throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC94030_Validate_the_response_when_StaffOtherID_andSequenceID_is_changes_while_the_other_fields_remains_the_same");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		Thread.sleep(5000);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.SequenceID,CommonMethods.generateUniqueID());
		jsonObject.put(globalVariables.EmployeeOtherID, CommonMethods.generateRandomNumberOfFixLength(5));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
	}
}


