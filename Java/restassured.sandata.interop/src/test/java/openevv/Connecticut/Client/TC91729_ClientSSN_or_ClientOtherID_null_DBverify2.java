package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

//Test Case 91728:Inter-op : Open EVV - Client - Validate the Client creation with "null" ClientSSN and ClientOtherID

public class TC91729_ClientSSN_or_ClientOtherID_null_DBverify2 extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
		
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC91729_OpenEVV_invalid_ClientSSN_db_verify() throws InterruptedException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC91729_OpenEVV_invalid_ClientSSN_db_verify");

		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
	
		js.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));
		
		js.put("ClientOtherID", null);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
	
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);	


	}
	
}