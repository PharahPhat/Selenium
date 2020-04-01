package openevv.Connecticut.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

/**
 * @author MayankM
 *
 */

import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest; 

public class CR80983_TC89518_Client_Designee_Update_Status_D extends BaseTest
{		
	private Assertion_DbVerifier assertionDbVerifier=new Assertion_DbVerifier();
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	

	//To validate the updation of Client Designee when status D is sent
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void R80983_TC89518_OpenEVV_Client_Designee_Update() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		
		// logger = extent.startTest("R80983_TC89518_OpenEVV_Client_Designee_Update");
		String clientdesigneeEmail = CommonMethods.generateEmailAddress_string(5);
		String clientEmail = CommonMethods.generateEmailAddress_string(5);
		
		JSONArray jsonArray= GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jSONObject = (JSONObject) jsonArray.get(0);

		jSONObject.put(globalVariables.clientDesigneeEmail, clientdesigneeEmail);
		jSONObject.put(globalVariables.clientEmailAddress,clientEmail);


		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jSONObject);	

	}
	
	@Test( groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void R80983_TC89518_OpenEVV_Client_Designee_Update_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		String uniqueClientId = "67163";

		// logger = extent.startTest("R80983_TC89518_OpenEVV_Client_Designee_Update_DB");

		// Send request again with status= D, dischargeDate = valid value
		JSONArray J= CommonMethods.LoadJSON_OpenEVV("client");

		JSONObject js = (JSONObject) J.get(0);
		//js.put("ClientDesigneeEmail", CommonMethods.generateEmailAddress_alpha(10));
		js.put("ClientID", uniqueClientId);
		
		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);

		JSONArray j4 = (JSONArray) js.get("ClientAddress");
		JSONObject js4 = (JSONObject) j4.get(1);
		js4.put("ClientID", uniqueClientId);
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV_getError(J, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		Assert.assertTrue(bodyAsString.contains("Another client exists with the passed unique client identifier\"")); 


	}
}