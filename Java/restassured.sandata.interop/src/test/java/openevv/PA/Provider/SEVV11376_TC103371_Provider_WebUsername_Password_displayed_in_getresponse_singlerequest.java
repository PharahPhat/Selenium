package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV11376_TC103371_Provider_WebUsername_Password_displayed_in_getresponse_singlerequest extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "ProviderImport")
	public void TC103371_Provider_WebUsername_Password_displayed_in_getresponse_singlerequest() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC103371_Provider_WebUsername_Password_displayed_in_getresponse_singlerequest");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put(globalVariables.providertaxonomy, CommonMethods.generateRandomNumberOfFixLength(9));
		
		jsonObject.put(globalVariables.TerminationDate, CommonMethods.generateFutureDate_YYYY_MM_dd());
		
		jsonObject.put(globalVariables.SSN, CommonMethods.generateRandomNumberOfFixLength(9));
		
		jsonObject.put(globalVariables.ProviderMedicaidID , CommonMethods.generateRandomNumberOfFixLength(9));
		
		jsonObject.put(globalVariables.ProviderFax , CommonMethods.generateRandomNumberOfFixLength(10));
		
		jsonObject.put(globalVariables.ProviderAPI, CommonMethods.generateRandomNumberOfFixLength(10));
		
		jsonObject.put(globalVariables.ProviderNPI, CommonMethods.generateRandomNumberOfFixLength(10));
		
		jsonObject.put(globalVariables.AddressLine2, CommonMethods.generateRandomAlphaNumeric(8));
		
		jsonObject.put(globalVariables.ProviderDoingBusinessAs, CommonMethods.generateRandomStringOfFixLength(8));
		
		jsonObject.put(globalVariables.County, CommonMethods.generateRandomStringOfFixLength(7));
		
		jsonObject.put(globalVariables.TaxID, CommonMethods.generateRandomNumberOfFixLength(9));
		
		jsonObject.put(globalVariables.ProviderDateBegin, "");
		
		jsonObject.put(globalVariables.SuspensionDate, null);

		
		String bodyAsString = CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
		
		
		// INBOX.PROVIDER TABLE VALIDATION
		assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsString, jsonObject);
		
		
		// STX ACCOUNT WEB TABLE VALIDATION
		assertionDbVerifier.jsonAssert_stx_Accounts_Webuser(bodyAsString, jsonObject);
	}
}
