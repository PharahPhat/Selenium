package openevv.PA.Authorization;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

 public class SEVV_2228_TC95394_Validate_the_Shared_Authorization extends BaseTest {

 	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
 	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void TC95394_Validate_the_Shared_Authorization() throws Exception
	{

		// // logger = extent.startTest("TC95394_Validate_the_Shared_Authorization");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		System.out.println(jsonObject.get("AuthorizationServiceID"));
		String bodyAsString = CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));

		Thread.sleep(10000);
		jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("AuthorizationReferenceNumber", CommonMethods.generateRandomNumberOfFixLength(4));
		
		String bodyAsStringnew = CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		assertionDbVerifier.jsonAssertAuthorizations_OpenEVV(bodyAsStringnew, jsonObject);

		
}

}
