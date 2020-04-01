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
//OpenEVV Member: Validate maximum length for ClientGender(1) 

public class R2223_TC94520_OpenEVV_Member_ClientGender_Length extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void R2223_TC94520_OpenEVV_Member_ClientGender_M() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94520_OpenEVV_Member_ClientGender_M");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientGender", "M");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94520_OpenEVV_Member_ClientGender_F() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94520_OpenEVV_Member_ClientGender_F");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientGender", "F");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94520_OpenEVV_Member_ClientGender_O() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94520_OpenEVV_Member_ClientGender_O");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientGender", "O");
		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94520_OpenEVV_Member_ClientGender_invalid_length() throws InterruptedException, IOException, ParseException, java.text.ParseException {
		// logger = extent.startTest("R2223_TC94520_OpenEVV_Member_ClientGender_invalid_length");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientGender", CommonMethods.generateRandomStringOfFixLength(2));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientGenderLengthError);;
	}

	@Test(groups = {"All"})
	public void R2223_TC94520_OpenEVV_Member_ClientGender_length_blank() throws InterruptedException, IOException, ParseException, java.text.ParseException {
		// logger = extent.startTest("R2223_TC94520_OpenEVV_Member_ClientGender_invalid_blank");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientGender", "");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94520_OpenEVV_Member_ClientGender_null() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94520_OpenEVV_Member_ClientGender_null");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientGender", null);

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}
}

