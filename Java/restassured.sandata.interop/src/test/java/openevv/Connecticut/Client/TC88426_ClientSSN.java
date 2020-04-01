package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

//Test Case 88426:Open EVV: Verify error messages on uploading client with invalid input of 'ClientSSN'

public class TC88426_ClientSSN extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the valid ssn length
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88426_OpenEVV_ClientSSN_length_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC88426_OpenEVV_ClientSSN_length_invalid");

		//Using Reusable method to load client json
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) jsonArray.get(0);
		js.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);	
		
	}

	//To validate the invalid ssn length
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88426_OpenEVV_ClientSSN_length_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88426_OpenEVV_ClientSSN_length_invalid");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientSSN", "21314234561");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientSSN length is invalid. The length should be between 0 and 9."));
	}

	//To validate the ssn with alphanumeric value
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC88426_OpenEVV_ClientSSN_Alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88426_OpenEVV_ClientSSN_Alphanumeric");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientSSN", "21364havca");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientSSN format is incorrect."));
	}

	//To validate the ssn with non numeric value
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC88426_OpenEVV_ClientSSN_nonnumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88426_OpenEVV_ClientSSN_nonnumeric");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientSSN", "mayanknst");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientSSN format is incorrect."));
	}

	//To validate the ssn with whitespace
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC88426_OpenEVV_ClientSSN_with_heading_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88426_OpenEVV_ClientSSN_with_heading_space");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientSSN", " 987654321");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientSSN format is incorrect."));
	}

	//To validate the ssn with special character
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC88426_OpenEVV_ClientSSN_specialCharacter() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88426_OpenEVV_ClientSSN_specialCharacter");

		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientSSN", "14420@234");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("The ClientSSN format is incorrect."));
	}

	//To validate the ssn with dash character
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")

	public void OpenEVV_ClientSSN_with_dashCharacter_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("OpenEVV_ClientSSN_with_dashCharacter_invalid");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientSSN", "2442-9234");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientSSN format is incorrect."));
	}

}