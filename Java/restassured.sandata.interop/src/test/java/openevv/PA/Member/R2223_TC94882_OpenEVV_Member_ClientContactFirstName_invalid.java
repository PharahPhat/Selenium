package openevv.PA.Member;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.ohio.intake.patient.v1.DataGeneratorV1;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class R2223_TC94882_OpenEVV_Member_ClientContactFirstName_invalid extends BaseTest { 
	
	DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void TC94882_OpenEVV_Member_Validate_invalid_value_for_ClientContactFirstName_with_special_character() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC94882_OpenEVV_Member_Validate_invalid_value_for_ClientContactFirstName_with_special_character");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);

		jsonObjectClientContact.put("ClientContactFirstName", "ravi@");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactFirstNameerror);

	}

	@Test(groups = {"All"})
	public void TC94882_OpenEVV_Member_Validate_invalid_value_for_ClientContactFirstName_with_numeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC94882_OpenEVV_Member_Validate_invalid_value_for_ClientContactFirstName_with_numeric");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);

		jsonObjectClientContact.put("ClientContactFirstName", "ravi1234");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactFirstNameerror);

	}
	
	@Test(groups = {"All"})
	public void TC94882_OpenEVV_Member_Validate_invalid_value_for_ClientContactFirstName_with_morethan_max_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC94882_OpenEVV_Member_Validate_invalid_value_for_ClientContactFirstName_with_morethan_max_length");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);

		jsonObjectClientContact.put("ClientContactFirstName", "sadgjdgsajdgsajhdgsajkdgsakjdgsajkdgsajkgdsjagdsjagdsakjgdsajhdgsajdgsajgdsajgdsajkgdjsagdsjadgasjgdjasgdjsagdjsagdjsagdjsagdjsagdjsagdjsagdjasgdjsagdj");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactFirstNamelengtherror);

	}
	
}
