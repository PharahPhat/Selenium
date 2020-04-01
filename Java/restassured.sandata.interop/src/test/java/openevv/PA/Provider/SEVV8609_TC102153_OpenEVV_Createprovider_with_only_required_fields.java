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
public class SEVV8609_TC102153_OpenEVV_Createprovider_with_only_required_fields extends BaseTest{

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC102153_OpenEVV_Createprovider_with_only_required_fields() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC102153_OpenEVV_Createprovider_with_only_required_fields");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV_removing_nonmandatefields(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		
		// Required fields
		
		jsonObject.put(globalVariables.ProviderQualifier, CommonMethods.RandomProviderQualifier());
		
		jsonObject.put(globalVariables.PayerID, globalVariables.PayerIDValue);
		
		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		// INBOX.PROVIDER TABLE VALIDATION
		
		assertionDbVerifier.jsonAssert_inbox_Provider_without_nonmandate(bodyAsString, jsonObject);

		
		
	}


}
