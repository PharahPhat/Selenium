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

public class CR80983_TC88360_Client_DischargeDate_Update_Status_D extends BaseTest
{

	private Assertion_DbVerifier assertionDbVerifier=new Assertion_DbVerifier();
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R80983_TC88360_OpenEVV_Client_DischargeDate_ExsitingClient() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("R80983_TC88360_OpenEVV_Client_DischargeDate_ExsitingClient");

		logger.log(LogStatus.INFO, "Creating a new client");
		JSONArray jsonArray= GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonobject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonobject);	

		logger.log(LogStatus.INFO, "Sending request again with status D and discharge date for the exsiting client");
		jsonobject.put(globalVariables.jsonStatus, "D");
		jsonobject.put(globalVariables.dischargeDate, CommonMethods.generatePastDate_MMddYYYY());

		String bodyAsStringRe = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
	//	jsonobject.put("DischargeDate", CommonMethods.dateToDateTimeFormat(jsonobject.get("DischargeDate").toString()));
		
		assertionDbVerifier.jsonAssert_InboxClient_OpenEVV(bodyAsStringRe, jsonobject);	


	}

}