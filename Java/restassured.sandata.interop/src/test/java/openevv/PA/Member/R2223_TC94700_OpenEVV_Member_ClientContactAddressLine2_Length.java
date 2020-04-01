package openevv.PA.Member;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//OpenEVV Member: Validate maximum length for ClientContactAddressLine2(30)

import com.globalMethods.core.Assertion_DbVerifier;
import com.ohio.intake.patient.v1.DataGeneratorV1; 


public class R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length extends BaseTest { 
	
	DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_max() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_max");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);

		jsonObjectClientContact.put("ClientContactAddressLine2", CommonMethods.generateRandomStringOfFixLength(30));	

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
		
	}

	@Test(groups = {"All"})
	public void R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_min() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_min");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);

		jsonObjectClientContact.put("ClientContactAddressLine2", CommonMethods.generateRandomStringOfFixLength(1));	

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_invalid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);

		jsonObjectClientContact.put("ClientContactAddressLine2", CommonMethods.generateRandomStringOfFixLength(31));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactAddressLine2LengthError);

	}

	@Test(groups = {"All"})
	public void R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_invalid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);

		jsonObjectClientContact.put("ClientContactAddressLine2", "");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

	}
	
	@Test(groups = {"All"})
	public void R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94700_OpenEVV_Member_ClientContactAddressLine2_Length_invalid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);

		jsonObjectClientContact.put("ClientContactAddressLine2", null);	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

}