package openevv.PA.Authorization;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

import static com.globalMethods.core.globalVariables.*;

public class SEVV_8617_TC102272_Mandatory_NonmandatoryField extends BaseTest {
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier=new Assertion_DbVerifier();
	@Test(groups = {"All"})
	public void TC95398_Validate_PayerProgram_field_for_Invalid_specialcharacter() throws InterruptedException, java.text.ParseException,   Exception
	{
		// // logger = extent.startTest("TC95398_Validate_PayerProgram_field_for_Invalid_specialcharacter");
	
		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray authorizationLimitArray = (JSONArray) jsonObject.get(AuthorizationLimit);
		JSONObject authorizationLimit = (JSONObject) authorizationLimitArray.get(0);
		authorizationLimit.put(PayerProgram, CommonMethods.generateSpecialChar(5));
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, payerProgramFormatError);
	}
}

