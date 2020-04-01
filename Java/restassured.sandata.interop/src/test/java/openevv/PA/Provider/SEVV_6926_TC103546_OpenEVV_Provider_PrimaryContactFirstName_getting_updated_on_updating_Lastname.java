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
public class SEVV_6926_TC103546_OpenEVV_Provider_PrimaryContactFirstName_getting_updated_on_updating_Lastname extends BaseTest{

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC103546_OpenEVV_Provider_PrimaryContactFirstName_null_getting_updated_on_updating_Lastname() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	// logger = extent.startTest("TC103546_OpenEVV_Provider_PrimaryContactFirstName_null_getting_updated_on_updating_Lastname_multiple_times");
	
	JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);

	jsonObject.put(globalVariables.PrimaryContactLastName, CommonMethods.generateRandomStringOfFixLength(11));
	
	jsonObject.remove(globalVariables.PrimaryContactFirstName);

	String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));
	
	logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
	
	assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsString, jsonObject);
	
	jsonObject.put(globalVariables.PrimaryContactFirstName, CommonMethods.generateRandomStringOfFixLength(10));
	
	jsonObject.put(globalVariables.PrimaryContactLastName, CommonMethods.generateRandomStringOfFixLength(12));
	
	String bodyAsStringupdated = CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
			CommonMethods.propertyfileReader(globalVariables.provider_post_url),
			CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	
	logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
	
	assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsStringupdated, jsonObject);
	
	assertionDbVerifier.jsonAssert_stx_Accounts_info(bodyAsStringupdated, jsonObject);
	
	assertionDbVerifier.jsonAssert_stx_stxAccouts_interfaces(bodyAsStringupdated, jsonObject);
	
}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC103546_OpenEVV_Provider_PrimaryContactFirstName_blank_getting_updated_on_updating_Lastname() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	// logger = extent.startTest("TC103546_OpenEVV_Provider_PrimaryContactFirstName_blank_getting_updated_on_updating_Lastname");
	
	JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);

	jsonObject.put(globalVariables.PrimaryContactLastName, CommonMethods.generateRandomStringOfFixLength(8));
	
	jsonObject.put(globalVariables.PrimaryContactFirstName, "");

	String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));
	
	logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
	
	assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsString, jsonObject);
	
	jsonObject.put(globalVariables.PrimaryContactFirstName, CommonMethods.generateRandomStringOfFixLength(9));
	
	jsonObject.put(globalVariables.PrimaryContactLastName, CommonMethods.generateRandomStringOfFixLength(12));
	
	String bodyAsStringupdated = CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
			CommonMethods.propertyfileReader(globalVariables.provider_post_url),
			CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	
	logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
	
	assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsStringupdated, jsonObject);
	
	assertionDbVerifier.jsonAssert_stx_Accounts_info(bodyAsStringupdated, jsonObject);
	
	assertionDbVerifier.jsonAssert_stx_stxAccouts_interfaces(bodyAsStringupdated, jsonObject);
	
}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC103546_OpenEVV_Provider_PrimaryContactFirstName_blank_getting_updated_with_same_Lastname() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	// logger = extent.startTest("TC103546_OpenEVV_Provider_PrimaryContactFirstName_blank_getting_updated_with_same_Lastname");
	
	JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);

	jsonObject.put(globalVariables.PrimaryContactLastName, CommonMethods.generateRandomStringOfFixLength(8));
	
	jsonObject.put(globalVariables.PrimaryContactFirstName, "");

	String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));
	
	logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
	
	assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsString, jsonObject);
	
	jsonObject.put(globalVariables.PrimaryContactFirstName, CommonMethods.generateRandomStringOfFixLength(9));
	
	
	String bodyAsStringupdated = CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
			CommonMethods.propertyfileReader(globalVariables.provider_post_url),
			CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	
	logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
	
	assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsStringupdated, jsonObject);
	
	assertionDbVerifier.jsonAssert_stx_Accounts_info(bodyAsStringupdated, jsonObject);
	
	assertionDbVerifier.jsonAssert_stx_stxAccouts_interfaces(bodyAsStringupdated, jsonObject);
	
}
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC103546_OpenEVV_Provider_PrimaryContactFirstName_null_getting_updated_with_same_Lastname() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{

	// logger = extent.startTest("TC103546_OpenEVV_Provider_PrimaryContactFirstName_null_getting_updated_with_same_Lastname");
	
	JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);

	jsonObject.put(globalVariables.PrimaryContactLastName, CommonMethods.generateRandomStringOfFixLength(10));
	
	jsonObject.put(globalVariables.PrimaryContactFirstName, null);

	String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));
	
	logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
	
	assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsString, jsonObject);
	
	jsonObject.put(globalVariables.PrimaryContactFirstName, CommonMethods.generateRandomStringOfFixLength(10));
	
	String bodyAsStringupdated = CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
			CommonMethods.propertyfileReader(globalVariables.provider_post_url),
			CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	
	logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
	
	assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsStringupdated, jsonObject);
	
	assertionDbVerifier.jsonAssert_stx_Accounts_info(bodyAsStringupdated, jsonObject);
	
	assertionDbVerifier.jsonAssert_stx_stxAccouts_interfaces(bodyAsStringupdated, jsonObject);
	
}



}
