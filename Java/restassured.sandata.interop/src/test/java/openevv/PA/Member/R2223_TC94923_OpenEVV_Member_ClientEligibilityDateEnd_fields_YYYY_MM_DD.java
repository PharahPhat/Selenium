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

//Ravi


public class R2223_TC94923_OpenEVV_Member_ClientEligibilityDateEnd_fields_YYYY_MM_DD extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void R2223_TC94923_ClientEligibilityDateEnd_fields_accept_YYYY_MM_DD() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("TC94923_ClientEligibilityDateEnd_fields_will_accept_YYYY-MM-DD");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		JSONArray jsonArrayElig = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectElig = (JSONObject) jsonArrayElig.get(0);
		jsonObjectElig.put("ClientEligibilityDateEnd", CommonMethods.generatePastDate_YYYY_MM_dd());	
		jsonObjectElig.put("ClientStartOfCareDate", null);
		jsonObjectElig.put("ClientEndOfCareDate", null);

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void TC94923_ClientEligibilityDateEnd_fields_invalid_YYYYMMDD() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC94923_ClientEligibilityDateEnd_fields_invalid_YYYYMMDD");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("ClientEligibilityDateEnd", "20181213");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateEnderror);
	}

	@Test(groups = {"All"})
	public void TC94923_ClientEligibilityDateEnd_fields_invalid_DDMMYYYY() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC94923_ClientEligibilityDateEnd_fields_invalid_DDMMYYYY");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("ClientEligibilityDateEnd", "12122018");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateEnderror);
	}

	@Test(groups = {"All"})
	public void TC94923_ClientEligibilityDateEnd_fields_invalid_MMDDYYYY() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC94923_ClientEligibilityDateEnd_fields_invalid_MMDDYYYY");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("ClientEligibilityDateEnd", "11282019");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateEnderror);
	}

	@Test(groups = {"All"})
	public void TC94923_ClientEligibilityDateEnd_fields_invalid_dateascaharcter() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC94923_ClientEligibilityDateEnd_fields_invalid_dateascaharcter");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("ClientEligibilityDateEnd", "aaaa-bb-ccc");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateEnderror);

	}

	@Test(groups = {"All"})
	public void TC94923_ClientEligibilityDateEnd_fields__invalid_hiphen() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC94923_ClientEligibilityDateEnd_fields_invalid_(-20181912)");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("ClientEligibilityDateEnd", "-20181912");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateEnderror);

	}

	@Test(groups = {"All"})
	public void TC94923_ClientEligibilityDateEnd_fields__invalid_slash() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC94923_ClientEligibilityDateEnd_invalid(2018/19/12)");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("ClientEligibilityDateEnd", "2018/19/12");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateEnderror);
	}
}
