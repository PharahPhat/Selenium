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

public class SEVV_2228_TC95400_Validate_ClientIdentifier_field_for_Invalid extends BaseTest {
	
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

		
	
	@Test(groups = {"Smoke", "fixing"})
	public void TC95400_Validate_ClientIdentifier_field_for_Invalid_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95400_Validate_ClientIdentifier_field_for_Invalid_blank");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("ClientIdentifier", "");
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientIdentifier cannot be null nor empty");
		
	
	
	}
	
	@Test(groups = {"All"})
	public void TC95400_Validate_ClientIdentifier_field_for_Invalid_more_than_allowed_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95400_ClientIdentifier_field_for_Invalid_more_than_allowed_length");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("ClientIdentifier", CommonMethods.generateRandomNumberOfFixLength(65));
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		String BodyAsStringGet=CommonMethods.captureResponseAuthrizationGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openEVV_auth_get));
		CommonMethods.verifyjsonassertFailcase(BodyAsStringGet, "");
		
	
	
	}

}
