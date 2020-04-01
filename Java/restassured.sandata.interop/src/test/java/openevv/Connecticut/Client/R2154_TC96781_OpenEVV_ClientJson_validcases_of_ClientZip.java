/**
 * 
 */
package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class R2154_TC96781_OpenEVV_ClientJson_validcases_of_ClientZip extends BaseTest { private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96781_OpenEVV_ContactZip_validations_with_maxlength_9digits() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ContactZip", CommonMethods.generateRandomNumberOfFixLength(9));
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		Assert.assertTrue(bodyAsStringGet.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsStringGet.contains("\"reason\": \"Transaction Received.\","));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96781_OpenEVV_ContactZip_validations_maxlength_9digits_with_dashes() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC96781_OpenEVV_ContactZip_validations_maxlength_9digits_with_dashes");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ContactZip", CommonMethods.generateRandomNumberOfFixLength(5) +"-" +CommonMethods.generateRandomNumberOfFixLength(4));	

		CommonMethods.captureResponseOPENEVV(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.openevv_client_url),
				CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
	}
	
	


}
