package Production;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Bug_5182_TC97692_Logs_IODATA_for_Patient_intake extends BaseTest {
	
GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test
	public void Bug_5182_TC97692_Logs_IODATA_for_Patient_intake_valid_case() throws Exception
	{
		// logger = extent.startTest("Bug_5182_TC97692_Logs_IODATA_for_Patient_intake_valid_case");

		JSONArray jsonArr=GenerateUniqueParam.ClientParams_3P(globalVariables.ThreeP_patientJson);

		JSONObject jsonobject = (JSONObject) jsonArr.get(0);
		jsonobject.put("BusinessEntityMedicaidIdentifier", "10010");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v1));

		assertionDbVerifier.jsonAssert_iodata(bodyAsString, CommonMethods.capturegetIDonly(bodyAsString));
		
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v1));

		assertionDbVerifier.jsonAssert_iodata(bodyAsStringget, CommonMethods.capturegetIDonly(bodyAsStringget));
	}


}
