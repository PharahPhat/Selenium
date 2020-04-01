package openevv.PA.Member;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class R2223_TC94926_MemberStatusDate_format_YYYY_MM_DD extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
@Test(groups = {"Smoke"})
	public void TC94926_ClientStatusDate_MemberStatusDate_fields_YYYYMMDD() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC94926_ClientStatusDate_MemberStatusDate_fields_YYYYMMDD");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("ClientStatusDate", "20181128");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStatusDateerror);

	}

@Test(groups = {"All"})
public void TC94926_ClientStatusDate_MemberStatusDate_fields_DDMMYYYY() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
{
	// logger = extent.startTest("TC94926_ClientStatusDate_MemberStatusDate_fields_DDMMYYYY");

	JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
	JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

	jsonObjectProg.put("ClientStatusDate", "12-23-2018");	

	String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStatusDateerror);

}

@Test(groups = {"All"})
public void TC94926_ClientStatusDate_MemberStatusDate_fields_MMDDYYYY() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
{
	// logger = extent.startTest("TC94926_ClientStatusDate_MemberStatusDate_fields_MMDDYYYY");

	JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
	JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

	jsonObjectProg.put("ClientStatusDate", "23-12-2018");	

	String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStatusDateerror);

}
@Test(groups = {"All"})
public void TC94926_ClientStatusDate_MemberStatusDate_fields_dateascaharcter() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
{
	// logger = extent.startTest("TC94926_ClientStatusDate_MemberStatusDate_fields_dateascaharcter");

	JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
	JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

	jsonObjectProg.put("ClientStatusDate", "aaaa-bb-cc");	

	String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStatusDateerror);

}
@Test(groups = {"All"})
public void TC94926_ClientStatusDate_MemberStatusDate_fields_invalid_slash() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
{
	// logger = extent.startTest("TC94926_ClientStatusDate_MemberStatusDate_fields_(-20181912)");

	JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
	JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

	jsonObjectProg.put("ClientStatusDate", "2018/12/12");	

	String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStatusDateerror);

}
}
