package Production;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Bug_5182_TC97691_Logs_IODATA_Patient_request_DB extends BaseTest{
	
  GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test
	public void Bug_5182_TC97691_Logs_IODATA_for_Patient_intake_invalid_DB_rejected_case() throws Exception
	{
		// logger = extent.startTest("Bug_5182_TC97691_Logs_IODATA_for_Patient_intake_invalid_DB_rejected_case");

		JSONArray jsonArr=GenerateUniqueParam.ClientParams_3P(globalVariables.ThreeP_patientJson);

		JSONObject js = (JSONObject) jsonArr.get(0);

		CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v1));

		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v1));

			String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v1));
		
			assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, js);

		assertionDbVerifier.jsonAssert_iodata(bodyAsStringget, CommonMethods.capturegetIDonly(bodyAsStringget));

	}
}
