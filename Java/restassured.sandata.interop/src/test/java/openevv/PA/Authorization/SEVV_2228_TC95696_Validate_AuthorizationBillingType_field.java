package openevv.PA.Authorization;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier;

import static com.globalMethods.core.globalVariables.AuthorizationLimit;

public class SEVV_2228_TC95696_Validate_AuthorizationBillingType_field extends BaseTest { 
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95696_Validate_AuthorizationBillingType_field_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{

		// // logger = extent.startTest("TC95696_Validate_AuthorizationBillingType_field_null");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayAuthorizationLimit = (JSONArray) jsonObject.get(AuthorizationLimit);
		JSONObject jsonObjectAuthorizationLimit = (JSONObject) jsonArrayAuthorizationLimit.get(0);

		jsonObjectAuthorizationLimit.put("AuthorizationBillingType", null);
		
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));

}

	@Test(groups = {"All"})
	public void TC95696_Validate_AuthorizationBillingType_field_morethan_allowed_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95696_Validate_AuthorizationBillingType_field_morethan_allowed_length");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayAuthorizationLimit = (JSONArray) jsonObject.get(AuthorizationLimit);
		JSONObject jsonObjectAuthorizationLimit = (JSONObject) jsonArrayAuthorizationLimit.get(0);

		jsonObjectAuthorizationLimit.put("AuthorizationBillingType", CommonMethods.generateRandomAlphaNumeric(65));
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	

}
	@Test(groups = {"All"})
	public void TC95696_Validate_AuthorizationBillingType_field_specialcharacter() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95696_Validate_AuthorizationBillingType_field_specialcharacter");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayAuthorizationLimit = (JSONArray) jsonObject.get(AuthorizationLimit);
		JSONObject jsonObjectAuthorizationLimit = (JSONObject) jsonArrayAuthorizationLimit.get(0);

		jsonObjectAuthorizationLimit.put("AuthorizationBillingType", CommonMethods.generateRandomStringOfFixLength(5)+'@');
		
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));


}
	
	

}
