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

public class R2223_TC94717_Validate_invalid_value_for_ClientStartOfCareDate extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	//ClientEligibilityDateBegin  validation
	
		@Test(groups = {"All"})
	public void R2223_TC94716_Validate_invalid_value_for_ClientEligibilityDateEnd_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC94716_Validate_invalid_value_for_ClientEligibilityDateEnd_invalid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);


		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObjectPay.put("ClientStartOfCareDate", "18-12-31");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStartOfCareDateerror);
	}

}
