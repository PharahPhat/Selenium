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
import com.ohio.intake.patient.v1.DataGeneratorV1;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; 

public class R2223_TC94889_OpenEVV_Member_ClientContactPhone_invalid extends BaseTest { 
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	
	@Test(groups = {"All"})
	public void TC94889_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhone_with_special_character() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC94889_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhone_with_special_character");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);

		jsonObjectClientContact.put("ClientContactPhone", "123456789@");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneerror);

	}

	@Test(groups = {"All"})
	public void TC94889_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhone_with_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC94889_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhone_with_space");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);

		jsonObjectClientContact.put("ClientContactPhone", "12345 567890");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneerror);

	}
	
	@Test(groups = {"All"})
	public void TC94889_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhone_with_character() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC94889_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhone_with_character");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);

		jsonObjectClientContact.put("ClientContactPhone", "123456789a");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneerror);

	}
	
	@Test(groups = {"All"})
	public void TC94889_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhone_with_lessthan_allowed() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC94889_OpenEVV_Member_Validate_invalid_value_for_ClientContactPhone_with_lessthan_allowed");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);

		jsonObjectClientContact.put("ClientContactPhone", "1234567");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneerror);

	}
	

	

}
