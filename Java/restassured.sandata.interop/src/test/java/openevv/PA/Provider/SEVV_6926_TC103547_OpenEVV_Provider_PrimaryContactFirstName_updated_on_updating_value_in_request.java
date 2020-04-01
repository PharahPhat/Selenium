package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.ohio.intake.patient.v2.GlobalVariable_V2;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV_6926_TC103547_OpenEVV_Provider_PrimaryContactFirstName_updated_on_updating_value_in_request extends BaseTest{

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC103547_OpenEVV_Provider_PrimaryContactFirstName_updated_on_updating_value_in_request() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	
	// logger = extent.startTest("TC103547_OpenEVV_Provider_PrimaryContactFirstName_updated_on_updating_value_in_request");
	
	JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);

	jsonObject.put(globalVariables.PrimaryContactLastName, CommonMethods.generateRandomStringOfFixLength(8));
	
	jsonObject.put(globalVariables.PrimaryContactFirstName, null);

	String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));
	
	logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
	
	assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsString, jsonObject);
	
	jsonObject.put(globalVariables.PrimaryContactFirstName, "");
	
	jsonObject.put(globalVariables.PrimaryContactLastName, CommonMethods.generateRandomStringOfFixLength(12));
	
	String bodyAsStringupdated = CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	
	logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
	
	assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsStringupdated, jsonObject);
	
	jsonObject.put(globalVariables.PrimaryContactFirstName, CommonMethods.generateRandomStringOfFixLength(10));
	
	jsonObject.put(globalVariables.PrimaryContactLastName, CommonMethods.generateRandomStringOfFixLength(12));
	
	String bodyAsStringChanges = CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	
	logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
	
	assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsStringChanges, jsonObject);
	
	assertionDbVerifier.jsonAssert_stx_Accounts_info(bodyAsStringChanges, jsonObject);
	
	assertionDbVerifier.jsonAssert_stx_stxAccouts_interfaces(bodyAsStringChanges, jsonObject);
}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC103547_OpenEVV_Provider_PrimaryContactFirstName_updated_on_updating_value_with_sameLastname_in_request() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	String Lastname=CommonMethods.generateRandomStringOfFixLength(10);
	// logger = extent.startTest("TC103547_OpenEVV_Provider_PrimaryContactFirstName_updated_on_updating_value_with_sameLastname_in_request");
	
	JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);

	jsonObject.put(globalVariables.PrimaryContactLastName, Lastname);
	
	jsonObject.put(globalVariables.PrimaryContactFirstName, null);

	String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));
	
	logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
	
	assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsString, jsonObject);
	
	jsonObject.put(globalVariables.PrimaryContactFirstName, "");
	
	
	String bodyAsStringupdated = CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	
	logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
	
	assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsStringupdated, jsonObject);
	
	jsonObject.put(globalVariables.PrimaryContactFirstName, CommonMethods.generateRandomStringOfFixLength(10));
	
	
	String bodyAsStringChanges = CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	
	logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
	
	assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsStringChanges, jsonObject);
	
	assertionDbVerifier.jsonAssert_stx_Accounts_info(bodyAsStringChanges, jsonObject);
	
	assertionDbVerifier.jsonAssert_stx_stxAccouts_interfaces(bodyAsStringChanges, jsonObject);
}


}
