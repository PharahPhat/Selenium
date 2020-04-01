package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author MayankM
 */
// Test Case 90105:Open EVV-Client-Validate (mix) - RecipientIDCustom2 field formats/values

public class TC90105_Client_RecipientIDCustom1 extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	public static String val2="client_id_custom1";

	// Case-1 To validate the valid RecipientIDCustom1 with Alphanumeric
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90105_OpenEVV_Valid_RecipientIDCustom1_Alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC90105_OpenEVV_Valid_RecipientIDCustom1_Alphanumeric");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("RecipientIDCustom1", CommonMethods.generateRandomStringOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);

	}

	// Case-2 To validate the invalid RecipientIDCustom1 with space combinations
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90105_OpenEVV_invalid_RecipientIDCustom1_with_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90105_OpenEVV_invalid_RecipientIDCustom1_with_space");
		//Using Reusable method to load client json
		//JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("RecipientIDCustom1", CommonMethods.generateRandomStringOfFixLength(3) +" " +CommonMethods.generateRandomStringOfFixLength(8));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The RecipientIDCustom1 format is incorrect."));
	}

	// Case-3 To validate the invalid RecipientIDCustom1 with >24 digits
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90105_OpenEVV_invalid_RecipientIDCustom1_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90105_OpenEVV_invalid_RecipientIDCustom1_length");
		//Using Reusable method to load client json
		//JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		//DataGeneratorClient DataClient = new DataGeneratorClient();
		JSONObject js = (JSONObject) j.get(0);
		js.put("RecipientIDCustom1", CommonMethods.generateRandomStringOfFixLength(25));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The RecipientIDCustom1 format is incorrect."));
	}

	//case-4 To validate the invalid RecipientIDCustom1 format with special chars
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC90105_OpenEVV_invalid_RecipientIDCustom1_specialchar() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90105_OpenEVV_invalid_RecipientIDCustom1_specialchar");
		//Using Reusable method to load client json

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("RecipientIDCustom1", "19@Z" +CommonMethods.generateRandomStringOfFixLength(6));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The RecipientIDCustom1 format is incorrect."));
	}

	//case-5 To validate the invalid RecipientIDCustom1 DB verification 
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90105_OpenEVV_valid_RecipientIDCustom1_DB_Validation() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC90105_OpenEVV_valid_RecipientIDCustom1_DB_Validation");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		String rcpntidcustom1 = CommonMethods.generateRandomStringOfFixLength(8);
		js.put("RecipientIDCustom1", rcpntidcustom1);

		System.out.println(rcpntidcustom1);

		// Providing parameter, passing the resource and validating the API status code and then extracting the response in RAw format

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);

	}

}