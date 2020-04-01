package openevv.PA.Authorization;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_2228_TC95432_Verify_Authorization_limit_section_not_raising_error extends BaseTest {

	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95432_Verify_Authorization_limit_section_not_raising_error_with_null_value_of_limits() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95432_Verify_Authorization_limit_section_not_raising_error_with_null_value_of_limits");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", "N");
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("AuthorizationLimit");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("AuthorizationLimit", null);	
		jsonObjectPay.put("AuthorizationWeekStart", null);
		jsonObjectPay.put("AuthorizationLimitDayOfWeek", null);
		jsonObjectPay.put("AuthorizationLimitStartTime", null);
		jsonObjectPay.put("AuthorizationLimitEndTime", null);
		
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));


}

}
