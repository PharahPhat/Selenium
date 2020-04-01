package openevv.Connecticut.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

// Test Case 91584:Inter-op - Open EVV - CLient - Validate Client creation with Same SSN

import com.globalMethods.core.Assertion_DbVerifier;
public class TC91584_ExistingSSN_DBverify extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

   String Val1= CommonMethods.generateRandomNumberOfFixLength(9);
	//case-1 To validate the invalid ClientSSN in database error code should be 0
	@Test (priority=1, groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC91584_OpenEVV_ClientSSN_new_dberrorcode() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC91584_OpenEVV_ClientSSN_new_dberrorcode");

		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientSSN", Val1);
		// js.put("ClientSSN", "992723210");
		//val1=  js.get("ClientSSN").toString();
		System.out.println(Val1);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);	

	}

	//Case-2 To validate the Client ssn if duplicate the in database error code should be -1043
	@Test(priority=2, groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC91584_OpenEVV_Client_ssn_duplicate_dberrorcode() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC91584_OpenEVV_Client_ssn_duplicate_dberrorcode");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);

	}

}