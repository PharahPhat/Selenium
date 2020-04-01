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

public class SEVV_2228_TC95438_Verify_Modifier2_field_value extends BaseTest {
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All", "fixing"})
	public void TC95438_Verify_Modifier2_field_value_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{

		// // logger = extent.startTest("TC95438_Verify_Modifier2_field_value_invalid");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("Modifier2", CommonMethods.generateSpecialChar(2));


		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		String BodyAsStringGet = CommonMethods.captureResponseAuthrizationGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openEVV_auth_get));
		CommonMethods.verifyjsonassertFailcase(BodyAsStringGet, "");

}

	@Test(groups = {"All", "fixing"})
	public void TC95438_Verify_Modifier2_field_value_invalid_morethan_allowed_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95438_Verify_Modifier2_field_value_invalid_morethan_allowed_length");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
        jsonObject.put("Modifier2", CommonMethods.generateRandomAlphaNumeric(4));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		String BodyAsStringGet = CommonMethods.captureResponseAuthrizationGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openEVV_auth_get));
		CommonMethods.verifyjsonassertFailcase(BodyAsStringGet, "Modifier2");


}
	@Test(groups = {"All"})
	public void TC95438_Verify_Modifier2_field_value_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95438_Verify_Modifier2_field_value_valid");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("Modifier2", "A");
		
		
		
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));

		

}
	@Test(groups = {"All"})
	public void TC95438_Verify_Modifier2_field_value_valid_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95438_Verify_Modifier2_field_value_valid_null");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("Modifier2", null);
		
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));

		

}

}
