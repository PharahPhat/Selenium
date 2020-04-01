package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV1292_TC96313_OpenEVV_Provider_Requiredfields_optional_nullvalidation extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96313_OpenEVV_Provider_Requiredfields_optionalnull() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96313_OpenEVV_Provider_Requiredfields_optionalnull");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ProviderQualifier", "Legacy");
		
		jsonObject.put("County", null);

		jsonObject.put("AddressLine2", null);
		
		jsonObject.put("ProviderFax", null);
		
		jsonObject.put("ProviderNPI", null);
		
		jsonObject.put("ProviderAPI", null);
		
		jsonObject.put("TaxID", null);
		
		jsonObject.put("SuspensionDate", null);
		
		jsonObject.put("TerminationDate", null);
		
		jsonObject.put("ProviderRequireAuth", null);
		
		CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	}
}
