
package openevv.PA.Member;


import Utills_ExtentReport_Log4j.BaseTest;
import bsh.ParseException;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

public class SEVV1292_TC96254_OpenEVV_Member_PayerID_Length_validation extends BaseTest { 
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	
	@Test(groups = {"All"})
	public void TC96254_OpenEVV_Member_PayerID_Length_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, org.json.simple.parser.ParseException
	{
		// logger = extent.startTest("TC96254_OpenEVV_Member_PayerID_Length_null");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);


		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObjectPay.put("PayerID", null);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerIDNullError_OpenEVV);
	}
	
	@Test(groups = {"All"})
	public void TC96254_OpenEVV_Member_PayerID_Length_exceeds() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, org.json.simple.parser.ParseException
	{
		// logger = extent.startTest("TC96254_OpenEVV_Member_PayerID_Length_exceeds");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObjectPay.put("PayerID", CommonMethods.generateRandomNumberOfFixLength(65));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerIDLengthError_Eligibility);
	}
}
