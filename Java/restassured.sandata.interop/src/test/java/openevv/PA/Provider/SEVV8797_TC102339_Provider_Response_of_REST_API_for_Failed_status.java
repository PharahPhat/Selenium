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
public class SEVV8797_TC102339_Provider_Response_of_REST_API_for_Failed_status extends BaseTest{

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC102339_Provider_Response_of_REST_API_for_FAILED_status() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC102339_Provider_Response_of_REST_API_for_FAILED_status");
		
		JSONArray JsonArray =new JSONArray();
		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.remove(globalVariables.ProviderID);
		jsonObject.remove(globalVariables.ProviderQualifier);
		
		JsonArray.add(jsonObject);
		JsonArray.add(jsonObject);
		
		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ProviderIDFormaterror);
			
		
	}

}
