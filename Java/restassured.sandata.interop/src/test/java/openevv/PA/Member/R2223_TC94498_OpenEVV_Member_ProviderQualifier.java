package openevv.PA.Member;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class R2223_TC94498_OpenEVV_Member_ProviderQualifier extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"Smoke"})
	public void R2223_TC94498_OpenEVV_Member_Validate_invalid_value_for_ProviderQualifier() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC94498_OpenEVV_Member_Validate_invalid_value_for_ProviderQualifier");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
	
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ProviderQualifier", CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Providerqualifiererror);
	}

}

