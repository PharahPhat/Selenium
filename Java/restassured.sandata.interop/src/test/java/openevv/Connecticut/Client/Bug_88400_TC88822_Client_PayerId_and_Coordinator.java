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

// Bug- 88400_Test Case 88822: Open EVV: Client- Load maximum Values in Client-PayerId & Coordinator

public class Bug_88400_TC88822_Client_PayerId_and_Coordinator extends BaseTest 

{
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	// case-1 Validate ClientSuffix is storing in DB
	private String payerid = CommonMethods.generateRandomNumberOfFixLength(64);
	private String coordinator =  CommonMethods.generateRandomStringOfFixLength(3);
	
	@Test(groups = {"All", "Regression", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void Bug_88400_TC88822_OpenEVV_ClientPayerID_Coordinator() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// adding method name info via logger
		// logger = extent.startTest("Bug_88400_TC88822_OpenEVV_ClientPayerID_Coordinator");
				
		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson OpenEVV_ClientPayerID_Coordinator"); 
		//Using Reusable method to load client json
	
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		JSONArray array = (JSONArray) js.get(globalVariables.Client_Payer_Information);
		JSONObject clientPayerInformation = (JSONObject) array.get(0);

		clientPayerInformation.put("PayerID",payerid);
	    js.put("Coordinator", coordinator);

		String bodyAsString = CommonMethods.verifyPostResponseOPENEVV(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_client_url), 
				CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);
	}
}