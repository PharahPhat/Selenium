package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class BUG_SEVV_2267_TC94010_Validate_Response_when_StaffSSN_and_SequenceID_changed extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_2267_TC94010_Validate_the_response_when_StaffSSN_and_SequenceID_is_changed_while_the_other_fields_remains_the_same() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC94010_Validate_the_response_when_StaffSSN_and_SequenceID_is_changed_while_the_other_fields_remains_the_same");
		logger.log(LogStatus.INFO, "Validate_the_response_when_StaffSSN_and_SequenceID_is_changed_while_the_other_fields_remains_the_same");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.EmpSSN,CommonMethods.generateRandomNumberOfFixLength(9));
		jsonObject.put(globalVariables.SequenceID, CommonMethods.generateRandomNumberOfFixLength(5));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
	}
}
