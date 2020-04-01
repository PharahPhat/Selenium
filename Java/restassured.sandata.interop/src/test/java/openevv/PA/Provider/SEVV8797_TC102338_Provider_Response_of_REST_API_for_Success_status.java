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

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV8797_TC102338_Provider_Response_of_REST_API_for_Success_status extends BaseTest{

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC102338_Provider_Response_of_REST_API_for_Success_status() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC102338_Provider_Response_of_REST_API_for_Success_status");
		List<String> Errormessage = new ArrayList<String>();
		JSONArray JsonArrayMultiple =new JSONArray();
		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONArray jsonArrayprovider = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JsonArrayMultiple.add(jsonObject);
		JSONObject jsonObjectprovider = (JSONObject) jsonArrayprovider.get(0);
		
		jsonObjectprovider.put(globalVariables.TaxID, CommonMethods.generateRandomNumberOfFixLength(8));
		jsonObject.remove(globalVariables.ProviderID);
		jsonObjectprovider.remove(globalVariables.ProviderID);
		Errormessage.add(globalVariables.provideridlengtherror);
		
		JsonArrayMultiple.add(jsonObjectprovider);
		
		String bodyAsString = CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
		
		CommonMethods.Assert_Provider_FailCase(bodyAsString);
		
		
		Errormessage.add(globalVariables.provideridformatnullerror);
		Errormessage.add(globalVariables.TaxIDFormaterror);
		Errormessage.add(globalVariables.provideridlengtherror);
		
		CommonMethods.verifyjsonassertFailcaseList(bodyAsString, Errormessage);
		
	}

}
