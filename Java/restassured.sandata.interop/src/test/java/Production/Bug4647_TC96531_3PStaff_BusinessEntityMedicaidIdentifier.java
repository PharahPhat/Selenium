package Production;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

/**
 * @author rahul Rohit
 */

public class Bug4647_TC96531_3PStaff_BusinessEntityMedicaidIdentifier extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void Bug4647_TC96531_3PStaff_BusinessEntityMedicaidIdentifier_valid_10010() throws Exception
	{
		// logger = extent.startTest("Bug4647_TC96531_3PStaff_BusinessEntityMedicaidIdentifier_valid_10010");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_Ohio_V1(globalVariables.ThreeP_Staff_Json);

		JSONObject js = (JSONObject) jsonArr.get(0);

		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
		
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1));
	
		assertionDbVerifier.jsonAssert_InboxWorker_Ohio(bodyAsStringget, js);
	
	}

	@Test(groups = {"All"})
	public void Bug4647_TC96531_3PStaff_BusinessEntityMedicaidIdentifier_valid_010010() throws Exception
	{
		// logger = extent.startTest("Bug4647_TC96531_3PStaff_BusinessEntityMedicaidIdentifier_valid_10010");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_Ohio_V1(globalVariables.ThreeP_Staff_Json);

		JSONObject js = (JSONObject) jsonArr.get(0);

		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
	
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1));
	
		assertionDbVerifier.jsonAssert_InboxWorker_Ohio(bodyAsStringget, js);
	
	}

	@Test(groups = {"All"})
	public void Bug4647_TC96531_3PStaff_BusinessEntityMedicaidIdentifier_valid_0010010() throws Exception
	{
		// logger = extent.startTest("Bug4647_TC96531_3PStaff_BusinessEntityMedicaidIdentifier_valid_0010010");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_Ohio_V1(globalVariables.ThreeP_Staff_Json);

		JSONObject js = (JSONObject) jsonArr.get(0);

		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
	
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1));

		assertionDbVerifier.jsonAssert_InboxWorker_Ohio(bodyAsStringget, js);
	
	}

}
