package Ohio_V1.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SEVV_2106_TC96557_Visit_Validate_message_in_Get_case_of_rejection extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioVisit")
		public void SEVV_2106_TC96557_Validate_visit_response_message_in_Get_case_of_rejection() throws Exception
	{
		String seqid= CommonMethods.generateRandomNumberOfFixLength(15);

		// logger = extent.startTest("SEVV_2106_TC96557_Validate_visit_response_message_in_Get_case_of_rejection");

		JSONArray jsonArr = GenerateUniqueParam.VisitParam_3P();
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		jsonObject.put("SequenceID", seqid);

		CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v1));


		Thread.sleep(30000);

		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v1));

		String bodyAsStringget = CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_get_v1));

		Assert.assertTrue(bodyAsStringget.contains("\"messageSummary\": \"Records rejected, please review error and try again.\","));

		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, "Version number is duplicated or older than current");

	}

}
