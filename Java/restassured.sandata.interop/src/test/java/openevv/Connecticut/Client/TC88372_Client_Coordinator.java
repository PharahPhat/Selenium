package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

//Test Case 88372:Open EVV: Verify error message on uploading client with incorrect value of Coordinator

public class TC88372_Client_Coordinator extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//verify invalid coordinator 
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void OpenEVV_Client_Coordinator_invalid_length() throws InterruptedException, java.text.ParseException,  JSONException,InterruptedException, SQLException, FileNotFoundException, IOException, ParseException, ConfigurationException
	{	
		// logger = extent.startTest("OpenEVV_Client_Coordinator_invalid_length");
		//Calling Json 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//changing json key based on test case.
		JSONObject js = (JSONObject) j.get(0);
		js.put("Coordinator", CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));


logger.log(LogStatus.INFO, "Validating Json response ");
		//Asserting that result of client data .

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		



	}

}
