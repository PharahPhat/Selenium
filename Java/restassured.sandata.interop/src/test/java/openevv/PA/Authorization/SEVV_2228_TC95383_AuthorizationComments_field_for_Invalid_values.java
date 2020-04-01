package openevv.PA.Authorization;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;

import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_2228_TC95383_AuthorizationComments_field_for_Invalid_values extends BaseTest {
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All", "fixing"})
	public void TC95383_AuthorizationComments_field_for_Invalid_values() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95383_AuthorizationComments_field_for_Invalid_values");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		 jsonObject.put("AuthorizationComments", CommonMethods.generateRandomStringOfFixLength(1000));

		
		
		String bodyAsString = CommonMethods.captureGetResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.openEVV_auth),
				CommonMethods.propertyfileReader(globalVariables.openEVV_auth_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString);
	}

	@Test(groups = {"All"})
	public void TC95383_AuthorizationComments_field_for_Invalid_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95383_AuthorizationComments_field_for_Invalid_null");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationComments", null);
		
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
	}
}
