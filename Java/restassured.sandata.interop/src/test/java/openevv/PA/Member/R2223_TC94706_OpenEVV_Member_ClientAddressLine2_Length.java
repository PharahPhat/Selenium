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

// Test Case 94706:OpenEVV Member: Validate maximum length for ClientAddressLine2 (MemberAddressLine2)(30)


public class R2223_TC94706_OpenEVV_Member_ClientAddressLine2_Length extends BaseTest { 
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Case-1: Validate ClientAddressLine2 length MemberAddressLine2(30) and type String

	@Test(groups = {"All"})
	public void R2223_TC94706_OpenEVV_Member_ClientAddressLine2_MaxLength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94706_OpenEVV_Member_ClientAddressLine2_MaxLength");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientAddressLine2, CommonMethods.generateRandomNumberOfFixLength(6) +" " +CommonMethods.generateRandomStringOfFixLength(10) +" " +CommonMethods.generateRandomAlphaNumeric(12));	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	//Case-2: Validate ClientAddressLine2 Max length exceeds MemberAddressLine2(35)  and type String
	@Test(groups = {"All"})
	public void R2223_TC94706_OpenEVV_Member_ClientAddressLine2_MaxLengthExceeds() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2223_TC94706_OpenEVV_Member_ClientAddressLine2_MaxLengthExceeds");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientAddressLine2, CommonMethods.generateRandomNumberOfFixLength(6) +" " +CommonMethods.generateRandomStringOfFixLength(10) +" " +CommonMethods.generateRandomAlphaNumeric(20));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine2LengthError);
	}

	//Case-3: Validate ClientAddressLine2 <30 length MemberAddressLine2 and type String		
	@Test(groups = {"All"})
	public void R2223_TC94706_OpenEVV_Member_ClientAddressLine2_validLength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94706_OpenEVV_Member_ClientAddressLine2_validLength");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientAddressLine2, CommonMethods.generateRandomNumberOfFixLength(4) +" " +CommonMethods.generateRandomStringOfFixLength(7) +" " +CommonMethods.generateRandomAlphaNumeric(4));	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

}
