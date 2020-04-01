package Ohio_V1.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SEVV_2106_TC97058_Validate_messagesummary_case_warning_in_subsegment extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioPatient")
	public void SEVV_2106_TC97058_Validate_messagesummary_in_case_warning_in_get_due_to_subsegment() throws Exception
	{
		// logger = extent.startTest("SEVV_2106_TC97058_Validate_messagesummary_in_case_warning_in_get_due_to_subsegment");

		JSONArray jsonArr=GenerateUniqueParam.ClientParams_3P(globalVariables.ThreeP_patientJson);

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Phones");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("PatientPhoneNumber", "");

		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v1));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v1));
         
		Assert.assertTrue(bodyAsStringget.contains("\"messageSummary\": \"The uploaded record(s) has(have) been processed with some error or warning message(s). Please check individual record to see whether it was loaded successfully or rejected.\","));

	}

}
