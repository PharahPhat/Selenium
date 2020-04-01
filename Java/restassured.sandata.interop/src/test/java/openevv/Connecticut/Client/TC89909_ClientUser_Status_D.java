/**
 * 
 */
package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

//Test Case 89909:Open EVV - Clients - Verify the Client User just after sending the Status 'D'


public class TC89909_ClientUser_Status_D extends BaseTest
{
	private Assertion_DbVerifier assertionDbVerifier=new Assertion_DbVerifier();
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the valid Clientjson with status as D in STX app user
	@Test(groups = {"All", "Regression", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	
	public void TC89909_OpenEVV_Client_valid_json_create_then_sent_with_Status_D__STXAPPUSER() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException{
		
		// logger = extent.startTest("TC89909_OpenEVV_Client_valid_json_create_then_sent_with_Status_D__STXAPPUSER");

		JSONArray jsonarray=GenerateUniqueParam.ClientParams_OpenEVV("client");

		CommonMethods.verifyPostResponseOPENEVV(jsonarray,
				CommonMethods.propertyfileReader(globalVariables.openevv_client_url),
				CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		Thread.sleep(5000);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("Status", "D");

		String bodyAsString = CommonMethods.verifyPostResponseOPENEVV(jsonarray,
				CommonMethods.propertyfileReader(globalVariables.openevv_client_url),
				CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		assertionDbVerifier.jsonAssert_InboxClient_OpenEVV(bodyAsString, jsonobject);
		
	}


}
