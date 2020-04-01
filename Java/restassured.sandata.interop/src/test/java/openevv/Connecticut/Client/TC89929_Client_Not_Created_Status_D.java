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
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author RRohiteshwar
 */

public class TC89929_Client_Not_Created_Status_D extends BaseTest
{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	private Assertion_DbVerifier assertionDbVerifier=new Assertion_DbVerifier();

	//To validate the valid Clientjson with status as D STX client user
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89929_OpenEVV_Client_valid_json_with_Status_D_STXCLIENT() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException 
	{
		// logger = extent.startTest("TC89929_OpenEVV_Client_valid_json_with_Status_D_STXCLIENT");

		JSONArray jsonarray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("Status", "D");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		//Assert.assertEquals(DataBaseVerifier_Client.UserStatus_appuser, "DELETED");
	}
}