package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest; 

public class SEVV8605_TC101722_OpenEVV_Provider_Update_Field_Provider_Sent_Null extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC101722_OpenEVV_Provider_Update_Field_Provider_Sent_Null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC101722_OpenEVV_Provider_Update_Field_Provider_Sent_Null");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ProviderDoingBusinessAs", null);
		jsonObject.put("AddressLine2", null);
		jsonObject.put("County", null);
		jsonObject.put("ProviderFax", null);
		jsonObject.put("ProviderNPI", null);
		jsonObject.put("ProviderAPI", null);
		jsonObject.put("TaxID", null);
		jsonObject.put("ProviderTaxonomy", null);
		
		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		assertionDbVerifier.jsonAssert_stx_Accounts_info(bodyAsString, jsonObject);
		assertionDbVerifier.jsonAssert_stx_stxAccouts_interfaces(bodyAsString, jsonObject);
		assertionDbVerifier.jsonAssert_stxAccounts_TaxID(bodyAsString, jsonObject);
		
		logger.log(LogStatus.INFO, "Updating values to fields whch were sent null");
		
		jsonObject.put("ProviderDoingBusinessAs", CommonMethods.generateRandomStringOfFixLength(9));
		jsonObject.put("AddressLine2", CommonMethods.generateRandomStringOfFixLength(10));
		jsonObject.put("County", CommonMethods.generateRandomStringOfFixLength(10));
		jsonObject.put("ProviderFax", CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObject.put("ProviderNPI", CommonMethods.generateRandomNumberOfFixLength(9));
		jsonObject.put("ProviderAPI", CommonMethods.generateRandomNumberOfFixLength(9));
		jsonObject.put("TaxID", CommonMethods.generateRandomNumberOfFixLength(9));
		jsonObject.put("ProviderTaxonomy", CommonMethods.generateRandomNumberOfFixLength(7));
		
		bodyAsString = CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));

		assertionDbVerifier.jsonAssert_stx_Accounts_info(bodyAsString, jsonObject);
		assertionDbVerifier.jsonAssert_stx_stxAccouts_interfaces(bodyAsString, jsonObject);
		assertionDbVerifier.jsonAssert_stxAccounts_TaxID(bodyAsString, jsonObject);
		
	}
	
}