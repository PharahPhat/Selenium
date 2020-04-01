package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author MayankM
 */
//Test Case 88630:Inter-Op-Open EVV- Client- Update the discharge date when status=D is sent

public class CR80983_TC89126_Client_Designee_Reference_Delete_Status_D extends BaseTest
{
	private Assertion_DbVerifier assertionDbVerifier=new Assertion_DbVerifier();
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the updation of Discharge date when status D is sent

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void CR80983_TC89126_OpenEVV_Client_DischargeDate_newClient() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("CR80983_TC89126_OpenEVV_Client_DischargeDate_newClient");
	
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonobject = (JSONObject) jsonArray.get(0);

		logger.log(LogStatus.INFO, "Sending request again with status D and discharge date while creating new client");
		jsonobject.put(globalVariables.jsonStatus, "D");
		jsonobject.put(globalVariables.ClientSSN, CommonMethods.generateRandomNumberOfFixLength(9));
		jsonobject.put(globalVariables.dischargeDate, CommonMethods.generatePastDate_MMddYYYY());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		//assertionDbVerifier.jsonAssert_InboxClient_OpenEVV_statusD(bodyAsString, jsonobject);	
		

	}
}