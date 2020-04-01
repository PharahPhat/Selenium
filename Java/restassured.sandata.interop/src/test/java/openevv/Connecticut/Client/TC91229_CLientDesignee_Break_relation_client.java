/**
 * 
 */
package openevv.Connecticut.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

/**
 * @author RRohiteshwar
 *
 */
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

public class TC91229_CLientDesignee_Break_relation_client extends BaseTest
{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	public static String clientid = CommonMethods.generateRandomNumberOfFixLength(5);
	public static String clientssn =CommonMethods.generateRandomNumberOfFixLength(9);

	//To validate the invalid ClientDesigneeEndDate today Date
	@Test(groups = {"All", "Regression", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC91229_OpenEVV_Client_valid_json_without_CLientDesigneeDetails() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js= (JSONObject) j.get(0);
		js.remove("ClientDesigneeFirstName");
		js.remove("ClientDesigneeLastName");
		js.remove("ClientDesigneeEmail");
		js.remove("ClientDesigneeStatus");
		js.remove("ClientDesigneeStartDate");
		js.remove("ClientDesigneeEndDate");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);
	}



}