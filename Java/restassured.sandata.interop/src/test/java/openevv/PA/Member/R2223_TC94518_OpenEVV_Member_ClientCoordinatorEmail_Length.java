package openevv.PA.Member;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;


import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//OpenEVV Member: Validate maximum length for ClientCoordinatorEmail(50)

import com.globalMethods.core.Assertion_DbVerifier;

public class R2223_TC94518_OpenEVV_Member_ClientCoordinatorEmail_Length extends BaseTest { 
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void R2223_TC94518_OpenEVV_Member_ClientCoordinatorEmail_Length_max() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94518_OpenEVV_Member_ClientCoordinatorEmail_Length_max");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientCoordinatorEmail", CommonMethods.generateRandomAlphaNumeric(35) +"@mailinator.com");	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

	}

	@Test(groups = {"All"})
	public void R2223_TC94518_OpenEVV_Member_ClientCoordinatorEmail_Length_min() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94518_OpenEVV_Member_ClientCoordinatorEmail_Length_min");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientCoordinatorEmail", CommonMethods.generateRandomAlphaNumeric(1) +"@mailinator.com");	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94518_OpenEVV_Member_ClientCoordinatorEmail_Length_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2223_TC94518_OpenEVV_Member_ClientCoordinatorEmail_Length_invalid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientCoordinatorEmail", CommonMethods.generateEmailAddress_string(51));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCoordinatorEmailLengthError);;

	}

	@Test(groups = {"All"})
	public void R2223_TC94518_OpenEVV_Member_ClientCoordinatorEmail_Length_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94518_OpenEVV_Member_ClientCoordinatorEmail_Length_invalid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientCoordinatorEmail", "");	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94518_OpenEVV_Member_ClientCoordinatorEmail_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94518_OpenEVV_Member_ClientCoordinatorEmail_Length_max");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientCoordinatorEmail", null);	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

}