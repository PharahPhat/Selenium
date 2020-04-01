package openevv.PA.Authorization;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.ohio.intake.patient.v1.DataGeneratorV1;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_2228_TC95431_Verify_AuthorizationLimitEndTime_field_Invalid extends BaseTest {
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	List<String> Errormessage = new ArrayList<String>();

	
	@Test(groups = {"All"})
	public void TC95431_Verify_AuthorizationLimitEndTime_field_Invalid_time() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95431_Verify_AuthorizationLimitEndTime_field_Invalid_time");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", "D");
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("AuthorizationLimit");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("AuthorizationLimitEndTime", "22:53");	
		
			
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: AuthorizationLimitEndTime optional if AuthorizationLimitType is S or D. Does not apply for other AuthorizationLimitTypes. The record should satisfy this format HHmm assuming a 24 hour clock.");
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: (AuthorizationEndDate + AuthorizationLimitEndTime) must be after (AuthorizationLimitStartDate + AuthorizationStartTime).");

}
	
	
	
	@Test(enabled = false, groups = {"All"})
	public void TC95431_Verify_AuthorizationLimitEndTime_field_Invalid_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95431_Verify_AuthorizationLimitEndTime_field_Invalid_null");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationLimitType", "D");
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("AuthorizationLimit");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("AuthorizationLimitEndTime", null);	
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Authorizationweekstartnullerror);
		
    }
}


