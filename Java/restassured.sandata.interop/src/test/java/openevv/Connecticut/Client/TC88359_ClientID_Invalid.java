package openevv.Connecticut.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//TC88359:Open EVV- Verify error messages on uploading client with invalid input of ClientID

import com.globalMethods.core.Assertion_DbVerifier; public class TC88359_ClientID_Invalid extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88359_OpenEVV_ClientID_Valid_json_DB() throws InterruptedException, IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException{
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV(globalVariables.client_openevv);
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);
	}

	//case 1 checking with incorrect ClientID: "56781" (>5) populated with a correct value except the ClientID given field. 
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88359_OpenEVV_ClientID_Max_NV() throws InterruptedException,IOException, ParseException
	{
		String uniqueClientId= CommonMethods.generateRandomNumberOfFixLength(6);
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);
		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);
		
		JSONArray jsonArrAdd = (JSONArray) js.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd.put("ClientID", uniqueClientId);
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDFormatError);
	}

	//case 2 checking with incorrect ClientID: "56781" (<5) populated with a correct value except the ClientID given field. 
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88359_OpenEVV_ClientID_Min_NV() throws InterruptedException, IOException, ParseException
	{
		String uniqueClientId= CommonMethods.generateRandomNumberOfFixLength(4);
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);
		
		JSONArray jsonArrAdd = (JSONArray) js.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd.put("ClientID", uniqueClientId);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDFormatError);

	}

	//case 3 each tag, where every tag is included and is populated with a correct value except the below given field. ClientID: "5678hdhe11" (Alpha numeric)  
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88359_OpenEVV_ClientID_Max_Alphanum() throws InterruptedException, IOException, ParseException
	{
		String uniqueClientId= CommonMethods.generateRandomAlphaNumeric(5);
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString());
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		logger.log(LogStatus.INFO, "Validating Json response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));			

	}

	//Case 4 --- populated with a correct value except the below given field. ClientID: "dfhdheww" (Non numeric)  
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88359_OpenEVV_ClientID_Nonnum() throws InterruptedException, IOException, ParseException
	{
		String uniqueClientId= CommonMethods.generateRandomStringOfFixLength(5);
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString());
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		logger.log(LogStatus.INFO, "Validating Json response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));

	}

	//Case 5 --- populated with a correct value except the below given field. ClientID: "   8373738" (starting with space)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88359_OpenEVV_ClientID_LeadingSpace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		String uniqueClientId=  " " + CommonMethods.generateRandomNumberOfFixLength(5);

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));			
	}

	//Case 6 --- populated with a correct value except the below given field. ClientID: "12@373738" (With special character) 
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88359_OpenEVV_clientID_Special_character() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		String uniqueClientId= CommonMethods.generateSpecialChar(5);

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		logger.log(LogStatus.INFO, "Validating Json response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));			

	}

	//Case 7 --- populated with a correct value except the below given field. ClientID: "12-373738" (dashes, any combination) 
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88359_OpenEVV_ClientID_Dash_anycombination() throws InterruptedException, IOException, ParseException
	{
		String uniqueClientId= CommonMethods.generateSpecialChar(5);

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));			


	}

	//Case 8 --- populated with a correct value except the below given field. ClientID: "8373738 " (ending with space)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88359_OpenEVV_ClientID_TrailingSpace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88359_OpenEVV_ClientID_LeadingSpace");

		String uniqueClientId= CommonMethods.generateRandomNumberOfFixLength(5) + " ";

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		// To make the values in JSON dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", uniqueClientId);

		JSONArray j2 = (JSONArray) js.get("ClientPhone");
		JSONObject js2 = (JSONObject) j2.get(0);
		js2.put("ClientID", uniqueClientId);

		JSONArray j3 = (JSONArray) js.get("ClientAddress");
		JSONObject js3 = (JSONObject) j3.get(0);
		js3.put("ClientID", uniqueClientId);

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientID format is incorrect. The record should satisfy this regular expression"));			
	}

}