package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV1292_TC89268_OpenEVV_Provider_ProviderID_validation extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89268_OpenEVV_Provider_ProviderID_Length_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC89268_OpenEVV_Provider_ProviderID_Length_null");
		logger.log(LogStatus.INFO, "TC89268_OpenEVV_Provider_ProviderID_Length_null");
		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.ProviderID, null);

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ProviderIDNullError);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89268_OpenEVV_Provider_ProviderID_exceeds_maxlength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC89268_OpenEVV_Provider_ProviderID_exceeds_maxlength");
		logger.log(LogStatus.INFO, "TC89268_OpenEVV_Provider_ProviderID_exceeds_maxlength");
		
		List<String> Errormessage = new ArrayList<String>();
		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.ProviderID, CommonMethods.generateRandomNumberOfFixLength(65));

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		Errormessage.add(globalVariables.provideridlengtherror_QA);
		
		CommonMethods.verifyjsonassertFailcaseList(bodyAsString, Errormessage);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	// Only validating field not data, Picked from DB
	public void TC89268_OpenEVV_Provider_ProviderID_Maxlength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC89268_OpenEVV_Provider_ProviderID_Maxlength");
		logger.log(LogStatus.INFO, "TC89268_OpenEVV_Provider_ProviderID_Maxlength");
		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put(globalVariables.ProviderID, CommonMethods.generateRandomNumberOfFixLength(13));

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));
		String bodyAsStringGet=CommonMethods.captureResponseIndiana_Provider_get(bodyAsString, 
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	
		assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsStringGet, jsonObject);
		
	}
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")// provider id valid value passed dynamically from DB.
	public void TC89268_OpenEVV_Provider_ProviderID_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC89268_OpenEVV_Provider_ProviderID_valid");
		logger.log(LogStatus.INFO, "TC89268_OpenEVV_Provider_ProviderID_with_boundaryvalue_valid");

		
		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.ProviderID, CommonMethods.generateRandomNumberOfFixLength(49));
		
		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));
		String bodyAsStringGet=CommonMethods.captureResponseIndiana_Provider_get(bodyAsString, 
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));

		assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsStringGet, jsonObject);

	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89268_OpenEVV_Provider_ProviderID_invalid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC89268_OpenEVV_Provider_ProviderID_invalid_length");
		logger.log(LogStatus.INFO, "TC89268_OpenEVV_Provider_ProviderID_invalid_length");
		List<String> Errormessage = new ArrayList<String>();
		
		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.ProviderID, CommonMethods.generateRandomStringOfFixLength(51));

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));
		
		Errormessage.add(globalVariables.provideridlengtherror_QA);
		
		CommonMethods.verifyjsonassertFailcaseList(bodyAsString, Errormessage);
	}

	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89268_OpenEVV_Provider_ProviderID_blank_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC89268_OpenEVV_Provider_ProviderID_blank_invalid");
		logger.log(LogStatus.INFO, "TC89268_OpenEVV_Provider_ProviderID_blank_invalid");
		List<String> Errormessage = new ArrayList<String>();
		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.ProviderID, "");

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));
		
		Errormessage.add(globalVariables.provideridformatnullerror);
		Errormessage.add(globalVariables.provideridlengtherror_QA);
		
		CommonMethods.verifyjsonassertFailcaseList(bodyAsString, Errormessage);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89268_OpenEVV_Provider_ProviderID_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC89268_OpenEVV_Provider_ProviderID_specialchars");
		logger.log(LogStatus.INFO, "TC89268_OpenEVV_Provider_ProviderID_specialchars");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.ProviderID, CommonMethods.generateSpecialChar(10));

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));
		
		String bodyAsStringGet=CommonMethods.captureResponseIndiana_Provider_get(bodyAsString, 
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));

		assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsStringGet, jsonObject);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89268_OpenEVV_Provider_ProviderID_leadingspaces() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC89268_OpenEVV_Provider_ProviderID_leadingspaces");
		logger.log(LogStatus.INFO, "TC89268_OpenEVV_Provider_ProviderID_leadingspaces");
	
		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.ProviderID, "" +CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));
		
		String bodyAsStringGet=CommonMethods.captureResponseIndiana_Provider_get(bodyAsString, 
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));

		assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsStringGet, jsonObject);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89268_OpenEVV_Provider_ProviderID_trailingspaces() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC89268_OpenEVV_Provider_ProviderID_trailingspaces");
		logger.log(LogStatus.INFO, "TC89268_OpenEVV_Provider_ProviderID_trailingspaces");
	
		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.ProviderID, CommonMethods.generateRandomNumberOfFixLength(5)+ "");

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));
		
		String bodyAsStringGet=CommonMethods.captureResponseIndiana_Provider_get(bodyAsString, 
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));

		assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsStringGet, jsonObject);
	}
}
