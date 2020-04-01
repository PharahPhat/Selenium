package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV1292_TC9382_OpenEVV_Loadprovider_with_required_optionalfields extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96317_OpenEVV_Loadprovider_with_both_required_optionalfields() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96317_OpenEVV_Loadprovider_with_required_optionalfields");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ProviderQualifier", "Taxonomy");
		
		jsonObject.put("County", CommonMethods.generateRandomStringOfFixLength(30));

		jsonObject.put("PayerID", "PAODP");

		jsonObject.put("AddressLine2", CommonMethods.generateRandomStringOfFixLength(50));
		
		jsonObject.put("ProviderFax", CommonMethods.generateRandomNumberOfFixLength(10));
		
		jsonObject.put("ProviderNPI ", CommonMethods.generateRandomNumberOfFixLength(10));
		
		jsonObject.put("ProviderAPI ", CommonMethods.generateRandomNumberOfFixLength(30));
		
		jsonObject.put("TaxID ", CommonMethods.generateRandomNumberOfFixLength(9));
		
		jsonObject.put("SuspensionDate ", 01/19/2019);
		
		jsonObject.put("TerminationDate ", 01/29/2019);
		
		jsonObject.put("ProviderRequireAuth", 0);

		CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	}

}
