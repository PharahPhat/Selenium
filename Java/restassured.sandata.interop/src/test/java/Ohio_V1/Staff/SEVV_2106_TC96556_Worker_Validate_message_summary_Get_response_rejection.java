package Ohio_V1.Staff;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SEVV_2106_TC96556_Worker_Validate_message_summary_Get_response_rejection extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void SEVV_2106_TC96556_Worker_Validate_message_summary_Get_response_in_case_of_rejection() throws Exception
	{
		String Staffssn= CommonMethods.generateRandomNumberOfFixLength(9);
		// logger = extent.startTest("SEVV_2106_TC96556_Worker_Validate_message_summary_Get_response_in_case_of_rejection");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_Ohio_V1(globalVariables.ThreeP_Staff_Json);

		JSONObject js = (JSONObject) jsonArr.get(0);
		js.put("StaffSSN", Staffssn);

		CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));


		JSONObject js1 = (JSONObject) jsonArr.get(0);

		js1.put("StaffSSN", Staffssn);

		String bodyAsString1 = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
		Thread.sleep(2000);

		String bodyAsStringget1=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString1, CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1));

		Assert.assertTrue(bodyAsStringget1.contains("\"messageSummary\": \"Records rejected, please review error and try again.\","));

		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget1, "Version number is duplicated or older than current");



	}

}
