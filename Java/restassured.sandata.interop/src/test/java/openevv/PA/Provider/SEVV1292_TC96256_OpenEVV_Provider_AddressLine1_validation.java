package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;


import com.globalMethods.core.Assertion_DbVerifier;

public class SEVV1292_TC96256_OpenEVV_Provider_AddressLine1_validation extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96256_OpenEVV_Provider_AddressLine1_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96256_OpenEVV_Provider_AddressLine1_null");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("AddressLine1", null);

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.AddressLine1null_error);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96256_OpenEVV_Provider_AddressLine1_exceeds_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96256_OpenEVV_Provider_AddressLine1_exceeds_length");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("AddressLine1", CommonMethods.generateRandomStringOfFixLength(51));
		
		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.AddressLine1LengthError);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96256_OpenEVV_Provider_AddressLine1_max_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96256_OpenEVV_Provider_AddressLine1_max_length");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("AddressLine1", CommonMethods.generateRandomStringOfFixLength(30));
		
		CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96256_OpenEVV_Provider_AddressLine1_valid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96256_OpenEVV_Provider_AddressLine1_valid_length");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
	
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("AddressLine1", CommonMethods.generateRandomStringOfFixLength(15) + CommonMethods.generateRandomAlphaNumeric(5));

		CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	}

}
