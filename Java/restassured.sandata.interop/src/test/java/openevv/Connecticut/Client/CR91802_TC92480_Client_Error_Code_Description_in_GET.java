package openevv.Connecticut.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

//Test Case 92480: Inter-op -Open EVV - Client - Validate the Error Code and Description in GET Response
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest; 

public class CR91802_TC92480_Client_Error_Code_Description_in_GET extends BaseTest
{	
	private Assertion_DbVerifier assertionDbVerifier=new Assertion_DbVerifier();
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC92480_openEVV_Client_creation_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC92480_openEVV_Client_creation_valid");
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_OpenEVV("client");
	
		String clientssn = CommonMethods.generateRandomNumberOfFixLength(9);
		
		JSONObject js = (JSONObject) jsonArray.get(0);
		js.put("ClientSSN", clientssn);
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		js.put("ClientSSN", clientssn);
		String bodyAsStringRe = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
	
		String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsStringRe, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		Assert.assertTrue(bodyAsStringGet.contains("\"message\": \"All records updated successfully.\","));
		
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);
		
	}

}