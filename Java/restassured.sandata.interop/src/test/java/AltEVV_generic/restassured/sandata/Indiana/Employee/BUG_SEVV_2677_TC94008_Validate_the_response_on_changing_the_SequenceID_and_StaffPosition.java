package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorEmployee;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class BUG_SEVV_2677_TC94008_Validate_the_response_on_changing_the_SequenceID_and_StaffPosition extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void SEVV_2677_TC94008_Validate_the_response_on_changing_the_SequenceID_and_StaffPosition() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC94008_Validate_the_response_on_changing_the_SequenceID_and_StaffPosition");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.SequenceID,CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObject.put(globalVariables.EmployeePosition, DataGeneratorEmployee.generateStaffPosition());

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
	}


}
