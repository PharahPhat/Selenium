package Ohio_V1.Staff;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class BUG_TC94009_Validate_response_EmployeeOtherId_and_SequenceID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	@Test(groups = {"All", "Regression"})
	public void BUG_TC94009_Validate_the_response_when_EmployeeOtherId_and_SequenceID_is_changed_rest_other_fields_remains_sames() throws InterruptedException, IOException, ParseException
	{
		JSONArray jsonArray = GenerateUniqueParam.staff_Ohio();
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		CommonMethods.validateResponse_Ohio(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));

		Thread.sleep(5000);
		jsonObject.put(globalVariables.SequenceID,CommonMethods.generateUniqueID());
		jsonObject.put(globalVariables.StaffOtherID, CommonMethods.generateRandomNumberOfFixLength(9));

		CommonMethods.validateResponse_Ohio(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
	}
}
