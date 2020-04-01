package openevv.PA.Authorization;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; 

public class SEVV_2228_TC95397_Validate_Payerid_values_for_Invalid extends BaseTest {
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();



	
	@Test(groups = {"All"})
	public void TC95397_Validate_Payerid_values_for_Invalid_morethan_allowed_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95397_Validate_Payerid_values_for_Invalid_morethan_allowed_length");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PayerID", CommonMethods.generateRandomNumberOfFixLength(65));
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The PayerID format is incorrect.");
		
		
	
	
	}
	
	@Test(groups = {"All"})
	public void TC95392_Verify_AuthorizationStatus_Invalid_values_morethanallowedlength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95392_Verify_AuthorizationStatus_Invalid_values_morethanallowedlength");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationStatus", CommonMethods.generateRandomStringOfFixLength(3));
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.AuthorizationStatusformateerror);
		
	
	
	}
	
	@Test(groups = {"All"})
	public void TC95392_Verify_AuthorizationStatus_Invalid_char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95392_Verify_AuthorizationStatus_Invalid_values_char");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationStatus", "L");
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.AuthorizationStatusformateerror);
		
	
	
	}
	

}
