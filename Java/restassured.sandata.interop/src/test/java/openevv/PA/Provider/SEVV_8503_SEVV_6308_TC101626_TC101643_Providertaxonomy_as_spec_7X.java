package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Utills_ExtentReport_Log4j.BaseTest;
 
public class SEVV_8503_SEVV_6308_TC101626_TC101643_Providertaxonomy_as_spec_7X  extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC101626_OpenEVV_Provider_with_new_fields() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC89277_OpenEVV_Provider_ProviderName_maxlength");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ProviderTaxonomy", CommonMethods.generateRandomNumberOfFixLength(9));
	    jsonObject.put("ProviderDateBegin", CommonMethods.generateFutureDate_YYYY_MM_dd());
	    jsonObject.put("SuspensionDate", "");
	    jsonObject.put("TerminationDate", CommonMethods.generateFutureDate_YYYY_MM_dd());

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		assertionDbVerifier.jsonAssert_inbox_ProviderTaxonomy(bodyAsString, jsonObject);
		
		
		
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC101626_OpenEVV_Provider_Providertaxonomy_maxlength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC89277_OpenEVV_Provider_ProviderName_maxlength");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ProviderTaxonomy", CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		assertionDbVerifier.jsonAssert_inbox_ProviderTaxonomy(bodyAsString, jsonObject);
		
		
		
	}
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC101643_OpenEVV_Provider_Providertaxonomy_lessthanmaxlength_db() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC89277_OpenEVV_Provider_ProviderName_maxlength");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ProviderTaxonomy", CommonMethods.generateRandomNumberOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		assertionDbVerifier.jsonAssert_inbox_ProviderTaxonomy(bodyAsString, jsonObject);
		
		
		
	}
	
	@Test(groups = {"All", })
	@AdditionalInfo(module = "OpenEVV")
	public void TC101626_OpenEVV_Provider_Providertaxonomy_morethanmaxlength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC89277_OpenEVV_Provider_ProviderName_maxlength");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ProviderTaxonomy", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		assertionDbVerifier.jsonAssert_inbox_ProviderTaxonomy(bodyAsString, jsonObject);
		
		
	}
	
	@Test(groups = {"All", })
	@AdditionalInfo(module = "OpenEVV")
	public void TC101626_OpenEVV_Provider_Providertaxonomy_withcharacter() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC89277_OpenEVV_Provider_ProviderName_maxlength");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ProviderTaxonomy", CommonMethods.generateRandomAlphaNumeric(9));

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		assertionDbVerifier.jsonAssert_inbox_ProviderTaxonomy(bodyAsString, jsonObject);
		
		
	}
	

	@Test(groups = {"All", })
	@AdditionalInfo(module = "OpenEVV")
	public void TC101626_OpenEVV_Provider_Providertaxonomy_withspecialcharacter() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC89277_OpenEVV_Provider_ProviderName_maxlength");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ProviderTaxonomy", CommonMethods.generateRandomAlphaNumeric(8)+'@');

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		assertionDbVerifier.jsonAssert_inbox_ProviderTaxonomy(bodyAsString, jsonObject);
			
	}
	



	
	

}
