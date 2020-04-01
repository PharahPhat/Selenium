package openevv.PA.Member;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author MayankM
 */
//OpenEVV Member: (Negative case)Verify that Modifier1 field is not accepting invalid values

public class R570_TC95199_OpenEVV_Member_Modifier1_invalid extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void R570_TC95199_OpenEVV_Member_Modifier1_spclchar() throws IOException, ParseException
	{
		// logger = extent.startTest("R570_TC95199_OpenEVV_Member_Modifier1_spclchar");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier1", CommonMethods.generateSpecialChar(2));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier1FormatError);

	}

	@Test
	public void R570_TC95199_OpenEVV_Member_Modifier1_invalid_length() throws IOException, ParseException
	{
		// logger = extent.startTest("R570_TC95199_OpenEVV_Member_Modifier1_invalid_length");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier1", CommonMethods.generateRandomNumberOfFixLength(3));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier1Length);

	}

	@Test
	public void R570_TC95199_OpenEVV_Member_Modifier1_blank() throws IOException, ParseException
	{
		// logger = extent.startTest("R570_TC95199_OpenEVV_Member_Modifier1_blank");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier1", "");

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test
	public void R570_TC95199_OpenEVV_Member_Modifier1_null() throws IOException, ParseException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R570_TC95199_OpenEVV_Member_Modifier1_null");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier1", null);	
		jsonObjectProg.put("PayerService", CommonMethods.generateRandomNumberOfFixLength(5));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));



	}

}