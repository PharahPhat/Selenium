package openevv.Connecticut.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV10285_TC103158_SEVV10286_TC102985_ClientIntake_Supervisor_Coordinator_value_Stored_in_DB extends BaseTest{
	
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(enabled = false, groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC103158_ClientIntake_Supervisor_Coordinator_value_Stored_in_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
	// logger = extent.startTest("TC103158_ClientIntake_Supervisor_Coordinator_value_Stored_in_DB");
	logger.log(LogStatus.INFO, "TC103158_ClientIntake_Supervisor_Coordinator_value_Stored_in_DB");

	JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV(globalVariables.client_openevv);
	JSONObject jsonobject = (JSONObject) jsonArray.get(0);
	
//	jsonobject.put(globalVariables.coordinator, CommonMethods.generateRandomStringOfFixLength(3));
	
	String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
	
	logger.log(LogStatus.INFO, globalVariables.DBVerify);
	
	assertionDbVerifier.jsonAssert_InboxClient_OpenEVV(bodyAsString, jsonobject);	
	
	assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonobject);	
	
	assertionDbVerifier.stxaccount_spvClientSql_OpenEvv(bodyAsString, jsonobject);	
	

}

}
