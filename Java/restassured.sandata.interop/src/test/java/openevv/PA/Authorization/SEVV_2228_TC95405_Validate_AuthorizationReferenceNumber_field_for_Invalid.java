package openevv.PA.Authorization;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

import static com.globalMethods.core.globalVariables.AuthorizationReferenceNumberLength;

public class SEVV_2228_TC95405_Validate_AuthorizationReferenceNumber_field_for_Invalid extends BaseTest {
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95405_Validate_AuthorizationReferenceNumber_field_for_Invalid_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95405_Validate_AuthorizationReferenceNumber_field_for_Invalid_null");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationReferenceNumber", null);
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.AuthorizationReferenceNumbenullrerror);
	
	
	}
	
	@Test(groups = {"All"})
	public void TC95405_Validate_AuthorizationReferenceNumber_field_for_Invalid_other_than_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95404_Validate_ProviderID_field_for_Invalid_other_than_valid");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationReferenceNumber", CommonMethods.generateSpecialChar(8));
		
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		
	
	
	}
	
	@Test(groups = {"All"})
	public void TC95405_Validate_AuthorizationReferenceNumber_field_for_Invalid_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95404_Validate_ProviderID_field_for_Invalid_blank");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationReferenceNumber", "");
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.AuthorizationReferenceNumbenullrerror);
		
	
	
	}
	
	@Test(groups = {"All"})
	public void TC95405_Validate_AuthorizationReferenceNumber_field_for_Invalid_more_than_allowed_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95404_Validate_ProviderID_field_for_Invalid_more_than_allowed_length");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AuthorizationReferenceNumber", CommonMethods.generateRandomNumberOfFixLength(31));
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, AuthorizationReferenceNumberLength);
	}

}
