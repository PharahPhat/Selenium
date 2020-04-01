package openevv.PA.Authorization;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class SEVV_2228_TC95384_Verify_AuthorizationLimitType_for_Invalid extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void TC95384_Verify_AuthorizationLimitType_for_Invalid_values() throws Exception
	{
		// // logger = extent.startTest("TC95384_Verify_AuthorizationLimitType_for_Invalid_values");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", CommonMethods.generateRandomAlphaNumeric(3));
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Authorizationlimittypeerror);

	}
	
	@Test(groups = {"All"})
	public void TC95384_Verify_AuthorizationLimitType_for_Invalid_values_specialcharacter() throws Exception
	{
		// // logger = extent.startTest("TC95384_Verify_AuthorizationLimitType_for_Invalid_values_specialcharacter");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", CommonMethods.generateSpecialChar(1));
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Authorizationlimittypeerror);
		
	
	
	}
	
	@Test(groups = {"All"})
	public void TC95384_Verify_AuthorizationLimitType_for_Invalid_values_character_morethan_allowed() throws Exception
	{
		// // logger = extent.startTest("TC95384_Verify_AuthorizationLimitType_for_Invalid_values_character_morethan_allowed");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", CommonMethods.generateRandomStringOfFixLength(2));
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Authorizationlimittypeerror);
		
	
	
	}

}
