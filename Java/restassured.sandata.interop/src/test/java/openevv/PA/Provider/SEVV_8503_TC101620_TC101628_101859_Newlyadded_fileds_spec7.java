package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_8503_TC101620_TC101628_101859_Newlyadded_fileds_spec7 extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC101620_OpenEVV_Provider_with_new_fields() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC101620_OpenEVV_Provider_with_new_fields");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ProviderTaxonomy", CommonMethods.generateRandomNumberOfFixLength(9));
	    jsonObject.put("ProviderDateBegin", CommonMethods.generateFutureDate_YYYY_MM_dd());
	    jsonObject.put("SuspensionDate", CommonMethods.generatecurrentDate_YYYY_MM_dd());
	    jsonObject.put("TerminationDate", CommonMethods.generateFutureDate_YYYY_MM_dd());

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		assertionDbVerifier.jsonAssert_inbox_ProviderSpec7(bodyAsString, jsonObject);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC101628_OpenEVV_Provider_datebegin_validation_invalid_formate() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC101628_OpenEVV_Provider_datebegin_validation_invalid_formate");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

	    jsonObject.put("ProviderDateBegin", CommonMethods.generateFutureDate_MM_DD_YYYY());
	   

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ProviderDateBeginOpenevverror);
		
		
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC101859_OpenEVV_Provider_terminationdate_validation_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC101859_OpenEVV_Provider_terminationdate_validation_invalid");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

	    jsonObject.put("TerminationDate", CommonMethods.generateFutureDate_MM_DD_YYYY());

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.TerminationDateOpenevverror);
		
		
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC101859_OpenEVV_Provider_Suspensiondate_validation_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC101859_OpenEVV_Provider_Suspensiondate_validation_invalid");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
	    jsonObject.put("ProviderDateBegin", CommonMethods.generateFutureDate_YYYY_MM_dd());
	    jsonObject.put("SuspensionDate", CommonMethods.generateFutureDate_MM_DD_YYYY());

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.SuspensionDateOpenevverror);
		
		
	}

}
