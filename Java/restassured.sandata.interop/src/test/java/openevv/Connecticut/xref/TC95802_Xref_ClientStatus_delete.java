/**
 * 
 */
package openevv.Connecticut.xref;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author RRohiteshwar
 *
 */

public class TC95802_Xref_ClientStatus_delete extends BaseTest
{
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate valid ClientAddressLine1_ClientAddressline2 accepts dash
	@SuppressWarnings("unused")
	@Test(groups = {"All"})
	public void TC95802_Xref_ClientStatus_delete_Valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{

		// logger = extent.startTest("TC95802_Xref_ClientStatus_delete_Valid");

		logger.log(LogStatus.INFO, "To validate valid TC95802_Xref_ClientStatus_delete_Valid");

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("ClientStatus", "06");

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.DeleteStatusFormatError);

	}

}


