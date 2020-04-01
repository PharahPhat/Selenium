package Ohio_V1.Staff;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.ohio.intake.staff.v1.DbVerifier_staff_v1;
import com.ohio.intake.staff.v1.GlobalVariable_staff_v1;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class BUG_TC94008_Validate_the_response_on_changing_the_SequenceID_and_StaffPosition extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private DbVerifier_staff_v1 dbVerifier=new DbVerifier_staff_v1();

	@Test(groups = {"All"})
	public void BUG_TC94008_Validate_the_response_on_changing_the_SequenceID_and_StaffPosition() throws InterruptedException, IOException, ParseException, java.text.ParseException, SQLException, ClassNotFoundException {
		JSONArray jsonArray = GenerateUniqueParam.staff_Ohio();
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		CommonMethods.validateResponse_Ohio(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));

		Thread.sleep(5000);

		jsonObject.put(globalVariables.SequenceID,CommonMethods.generateUniqueID());
		jsonObject.put(globalVariables.StaffPosition, "HCA");

		CommonMethods.validateResponse_Ohio(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));

		dbVerifier.jsonAssert_StxStaffOhioV1(jsonObject);
	}
}
