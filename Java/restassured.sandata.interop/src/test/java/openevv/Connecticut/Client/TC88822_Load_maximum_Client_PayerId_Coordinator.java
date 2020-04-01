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

public class TC88822_Load_maximum_Client_PayerId_Coordinator extends BaseTest
{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	Assertion_DbVerifier assertionDbVerifier=new Assertion_DbVerifier();
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88822_Load_maximum_Client_PayerId_Coordinator_Valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC88822_Load_maximum_Client_PayerId_Coordinator_Valid");
	
		logger.log(LogStatus.INFO, "To validate valid TC88822_Load_maximum_Client_PayerId_Coordinator_Valid");
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV(globalVariables.client_openevv);
		JSONObject js = (JSONObject) j.get(0);
		js.put(globalVariables.coordinator, "333");

	
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);	

	}

}
