package DSV.Indiana.provider;


import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_6308_TC101626_providertaxonomy_pansolvania_rest  extends BaseTest {
	
		
		GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
		Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

		@Test(enabled = false, groups = {"All"})
		public void TC101626_OpenEVV_Provider_with_new_fields() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
		{
			// logger = extent.startTest("TC89277_OpenEVV_Provider_ProviderName_maxlength");

			JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.PA_provider_json);
			JSONObject jsonObject = (JSONObject) jsonArray.get(0);

			jsonObject.put("ProviderTaxonomy", CommonMethods.generateRandomNumberOfFixLength(9));
			jsonObject.put("PayerID", "PADHS");
		    jsonObject.put("ProviderDateBegin", "");
		    jsonObject.put("SuspensionDate", "");
		    jsonObject.put("TerminationDate", "");
		    //CommonMethods.generateFutureDate_YYYY_MM_dd()
		    //CommonMethods.generateFutureDate_YYYY_MM_dd()

			String bodyAsString = CommonMethods.captureResponsePensolvania_Provider(jsonArray, CommonMethods.propertyfileReader(globalVariables.provider_post_url));

			assertionDbVerifier.jsonAssert_inbox_ProviderTaxonomy(bodyAsString, jsonObject);
			
			
			
		}
		
		@Test(enabled = false, groups = {"All"})
		public void TC101626_OpenEVV_Provider_Providertaxonomy_maxlength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
		{
			// logger = extent.startTest("TC89277_OpenEVV_Provider_ProviderName_maxlength");

			JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.PA_provider_json);
			JSONObject jsonObject = (JSONObject) jsonArray.get(0);

			jsonObject.put("ProviderTaxonomy", CommonMethods.generateRandomNumberOfFixLength(10));

			String bodyAsString = CommonMethods.captureResponsePensolvania_Provider(jsonArray, CommonMethods.propertyfileReader(globalVariables.provider_post_url));

			assertionDbVerifier.jsonAssert_inbox_ProviderTaxonomy(bodyAsString, jsonObject);
			assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsString, jsonObject);
			
			
			
		}
		@Test(enabled = false, groups = {"All", "Regression"})
		public void TC101643_OpenEVV_Provider_Providertaxonomy_lessthanmaxlength_db() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
		{
			// logger = extent.startTest("TC89277_OpenEVV_Provider_ProviderName_maxlength");

			JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.PA_provider_json);
			JSONObject jsonObject = (JSONObject) jsonArray.get(0);

			jsonObject.put("ProviderTaxonomy", CommonMethods.generateRandomNumberOfFixLength(8));

			String bodyAsString = CommonMethods.captureResponsePensolvania_Provider(jsonArray, CommonMethods.propertyfileReader(globalVariables.provider_post_url));

			assertionDbVerifier.jsonAssert_inbox_ProviderTaxonomy(bodyAsString, jsonObject);
			
			
			
		}
		
		@Test(enabled = false, groups = {"All", })
		public void TC101626_OpenEVV_Provider_Providertaxonomy_morethanmaxlength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
		{
			// logger = extent.startTest("TC89277_OpenEVV_Provider_ProviderName_maxlength");

			JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.PA_provider_json);
			JSONObject jsonObject = (JSONObject) jsonArray.get(0);

			jsonObject.put("ProviderTaxonomy", CommonMethods.generateRandomNumberOfFixLength(80));

			String bodyAsString = CommonMethods.captureResponsePensolvania_Provider(jsonArray, CommonMethods.propertyfileReader(globalVariables.provider_post_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.providerTaxonomyOpenevverror);
			
			
		}
		
		@Test(enabled = false, groups = {"All", })
		public void TC101626_OpenEVV_Provider_Providertaxonomy_withcharacter() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
		{
			// logger = extent.startTest("TC89277_OpenEVV_Provider_ProviderName_maxlength");

			JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.PA_provider_json);
			JSONObject jsonObject = (JSONObject) jsonArray.get(0);

			jsonObject.put("ProviderTaxonomy", CommonMethods.generateRandomAlphaNumeric(9));

			String bodyAsString = CommonMethods.captureResponsePensolvania_Provider(jsonArray, CommonMethods.propertyfileReader(globalVariables.provider_post_url));

			assertionDbVerifier.jsonAssert_inbox_ProviderTaxonomy(bodyAsString, jsonObject);
			assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsString, jsonObject);
			
			
		}
		

		@Test(enabled = false, groups = {"All", })
		public void TC101626_OpenEVV_Provider_Providertaxonomy_withspecialcharacter() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
		{
			// logger = extent.startTest("TC89277_OpenEVV_Provider_ProviderName_maxlength");

			JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.PA_provider_json);
			JSONObject jsonObject = (JSONObject) jsonArray.get(0);

			jsonObject.put("ProviderTaxonomy", CommonMethods.generateRandomAlphaNumeric(8)+'@');

			String bodyAsString = CommonMethods.captureResponsePensolvania_Provider(jsonArray, CommonMethods.propertyfileReader(globalVariables.provider_post_url));

			assertionDbVerifier.jsonAssert_inbox_ProviderTaxonomy(bodyAsString, jsonObject);
			assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsString, jsonObject);
			
			
		}
		

	}


