package openevv.Connecticut.Client;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import java.io.IOException;
import java.sql.SQLException;

// Bug- 88401_Test Case 88862: OpenEVV: Validate ClientSuffix is storing in DB.

import com.globalMethods.core.Assertion_DbVerifier; public class Bug_88401_TC88862_ClientSuffix_DB extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = { "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void Bug_88401_TC88862_OpenEVV_ClientSuffix_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// adding method name info via logger
		// logger = extent.startTest("Bug_88401_TC88862_OpenEVV_ClientSuffix_DB");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating the valid ClientSuffix value"); 

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientSuffix", "Mr");
		
		String bodyAsString = CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));

		
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);	
	

	}
}