/**
 * 
 */
package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author Neeraj
 *
 */

public class TS89206_TC90995_ClientID_ClientIdQualifier_EmployeeID_EmployeeQualifier_DB extends BaseTest
{
	private Assertion_DbVerifier assertionDbVerifier=new Assertion_DbVerifier();
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TS89206_TC90995_ClientID_ClientIdQualifier_EmployeeID_EmployeeQualifier_Db() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		
		// logger = extent.startTest("TS89206_TC90995_ClientID_ClientIdQualifier_EmployeeID_EmployeeQualifier_Db");

		logger.log(LogStatus.INFO, "To validate valid TS89206_TC90995_ClientID_ClientIdQualifier_EmployeeID_EmployeeQualifier_Db");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
	
		//assertionDbVerifier.jsonAssertAuthorizations_OpenEVV(bodyAsString, js);


	}
}

	