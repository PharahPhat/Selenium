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
public class SEVV8609_TC1040_OpenEVV_Loadprovider_without_non_required_fields extends BaseTest{

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC102155_OpenEVV_Loadprovider_without_non_required_fields() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC102155_OpenEVV_Loadprovider_without_non_required_fields");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		
		// Removing Non required fields
		
		jsonObject.remove(globalVariables.ProviderDoingBusinessAs);
		jsonObject.remove(globalVariables.AddressLine2);
		jsonObject.remove(globalVariables.County);
		jsonObject.remove(globalVariables.ProviderFax);
		jsonObject.remove(globalVariables.ProviderAPI);
		jsonObject.remove(globalVariables.ProviderNPI);
		jsonObject.remove(globalVariables.ProviderMedicaidID);
		jsonObject.remove(globalVariables.SSN);
		jsonObject.remove(globalVariables.TaxID);
		jsonObject.remove(globalVariables.ProviderRequireAuth);
		jsonObject.remove(globalVariables.ProviderDateBegin);
		jsonObject.remove(globalVariables.SuspensionDate);
		jsonObject.remove(globalVariables.TerminationDate);
		jsonObject.remove(globalVariables.providertaxonomy);
		
		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		// INBOX.PROVIDER TABLE VALIDATION
		
		assertionDbVerifier.jsonAssert_inbox_Provider_without_nonmandate(bodyAsString, jsonObject);
		
	}


}
