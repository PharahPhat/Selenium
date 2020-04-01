package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV8609_TC102154_OpenEVV_Createprovider_with_required_non_required_fields extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC102154_OpenEVV_Createprovider_with_required_non_required_fields() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC102154_OpenEVV_Createprovider_with_required_non_required_fields");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		// Passing required fields
		
		jsonObject.put(globalVariables.ProviderQualifier, CommonMethods.RandomProviderQualifier());
		
		jsonObject.put(globalVariables.PayerID, globalVariables.PayerIDValue);
		
		// Passing Non required fields
		
		jsonObject.put(globalVariables.ProviderDoingBusinessAs,CommonMethods.generateRandomStringOfFixLength(7) );
		jsonObject.put(globalVariables.AddressLine2, CommonMethods.generateRandomStringOfFixLength(4) +" " +CommonMethods.generateRandomAlphaNumeric(3));
		jsonObject.put(globalVariables.County, CommonMethods.generateRandomStringOfFixLength(7));
		jsonObject.put(globalVariables.ProviderFax , CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObject.put(globalVariables.ProviderAPI, CommonMethods.generateRandomNumberOfFixLength(30));
		jsonObject.put(globalVariables.ProviderNPI, CommonMethods.generateRandomNumberOfFixLength(10) );
		jsonObject.put(globalVariables.ProviderMedicaidID , CommonMethods.generateRandomNumberOfFixLength(9));
		jsonObject.put(globalVariables.SSN, CommonMethods.generateRandomNumberOfFixLength(9));
		jsonObject.put(globalVariables.TaxID, CommonMethods.generateRandomNumberOfFixLength(9));
		jsonObject.put(globalVariables.ProviderRequireAuth, '0');
		jsonObject.put(globalVariables.ProviderDateBegin, CommonMethods.generatecurrentDate_YYYY_MM_dd());
		jsonObject.put(globalVariables.SuspensionDate, CommonMethods.generatecurrentDate_YYYY_MM_dd());
		jsonObject.put(globalVariables.TerminationDate, CommonMethods.generateFutureDate_YYYY_MM_dd());
		jsonObject.put(globalVariables.providertaxonomy, CommonMethods.generateRandomNumberOfFixLength(3));
		
		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		// INBOX.PROVIDER TABLE VALIDATION
		assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsString, jsonObject);
		
		// STX.ACCOUNT INTERFACE TABLE VALIDATION
		assertionDbVerifier.jsonAssert_stx_stxAccouts_interfaces(bodyAsString, jsonObject);
		
	}


}
