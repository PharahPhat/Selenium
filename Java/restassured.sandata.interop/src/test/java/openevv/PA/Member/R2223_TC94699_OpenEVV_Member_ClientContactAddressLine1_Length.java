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
import java.sql.SQLException;

/**
 * @author MayankM
 */
//OpenEVV Member: Validate maximum length for ClientContactAddressLine1(30)

public class R2223_TC94699_OpenEVV_Member_ClientContactAddressLine1_Length extends BaseTest { 
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(enabled = false, groups = {"All"})
	public void R2223_TC94699_OpenEVV_Member_ClientContactAddressLine1_Length_max() throws IOException, ParseException
	{
		// logger = extent.startTest("R2223_TC94699_OpenEVV_Member_ClientContactAddressLine1_Length_max");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectProg=CommonMethods.subarrayAssertionVerifier(jsonObject, "ClientContact");
		jsonObjectProg.put("ClientContactAddressLine1", CommonMethods.generateRandomStringOfFixLength(30));	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94699_OpenEVV_Member_ClientContactAddressLine1_Length_min() throws IOException, ParseException
	{
		// logger = extent.startTest("R2223_TC94699_OpenEVV_Member_ClientContactAddressLine1_Length_min");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectProg=CommonMethods.subarrayAssertionVerifier(jsonObject, "ClientContact");
		jsonObjectProg.put("ClientContactAddressLine1", CommonMethods.generateRandomStringOfFixLength(1));	

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94699_OpenEVV_Member_ClientContactAddressLine1_Length_invalid() throws IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2223_TC94699_OpenEVV_Member_ClientContactAddressLine1_Length_invalid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectProg=CommonMethods.subarrayAssertionVerifier(jsonObject, "ClientContact");
		jsonObjectProg.put("ClientContactAddressLine1", CommonMethods.generateRandomStringOfFixLength(31));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactAddressLine1LengthError);

	}

	@Test(groups = {"All"})
	public void R2223_TC94699_OpenEVV_Member_ClientContactAddressLine1_Length_blank() throws IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2223_TC94699_OpenEVV_Member_ClientContactAddressLine1_Length_invalid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectProg=CommonMethods.subarrayAssertionVerifier(jsonObject, "ClientContact");
		jsonObjectProg.put("ClientContactAddressLine1", "");	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}
	
	@Test(groups = {"All"})
	public void R2223_TC94699_OpenEVV_Member_ClientContactAddressLine1_null() throws IOException, ParseException
	{
		// logger = extent.startTest("R2223_TC94699_OpenEVV_Member_ClientContactAddressLine1_Length_invalid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectProg=CommonMethods.subarrayAssertionVerifier(jsonObject, "ClientContact");
		jsonObjectProg.put("ClientContactAddressLine1", null);
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

}