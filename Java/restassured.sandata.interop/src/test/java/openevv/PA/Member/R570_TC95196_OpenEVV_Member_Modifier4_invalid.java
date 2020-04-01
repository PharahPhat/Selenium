package openevv.PA.Member;

import Utills_ExtentReport_Log4j.BaseTest;
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
//OpenEVV Member: (Negative case)Verify that Modifier4 field is not accepting invalid values

public class R570_TC95196_OpenEVV_Member_Modifier4_invalid extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	@Test(groups = {"All"})
	public void R570_TC95196_OpenEVV_Member_Modifier4_spclchar() throws IOException, ParseException
	{
		// logger = extent.startTest("R570_TC95196_OpenEVV_Member_Modifier4_spclchar");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier4", CommonMethods.generateSpecialChar(2));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier4FormatError);

	}

	@Test(groups = {"All"})
	public void R570_TC95196_OpenEVV_Member_Modifier4_invalid_length() throws IOException, ParseException
	{
		// logger = extent.startTest("R570_TC95196_OpenEVV_Member_Modifier4_invalid_length");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier4", CommonMethods.generateRandomNumberOfFixLength(3));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier4Length);

	}

	@Test(groups = {"All"})
	public void R570_TC95196_OpenEVV_Member_Modifier4_blank() throws IOException, ParseException
	{
		// logger = extent.startTest("R570_TC95196_OpenEVV_Member_Modifier4_blank");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier4", "");	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R570_TC95196_OpenEVV_Member_Modifier4_null() throws IOException, ParseException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R570_TC95196_OpenEVV_Member_Modifier4_null");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier4", null);	
		jsonObjectProg.put("PayerService", CommonMethods.generateRandomNumberOfFixLength(5));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

}