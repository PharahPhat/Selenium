package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author RRohiteshwar
 */
//Test Case 89635:Open EVV - Client - Client with Status 'D'

public class OpenEVV_TC89635_Client_with_Status_D extends BaseTest
{
	private Assertion_DbVerifier assertionDbVerifier=new Assertion_DbVerifier();
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(enabled = false, groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89635_OpenEVV_Client_Status_D() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC89635_OpenEVV_Client_Status_D");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("Status", "D");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_client_url),
				CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		assertionDbVerifier.jsonAssert_InboxClient_OpenEVV(bodyAsString, js);
	}

}
