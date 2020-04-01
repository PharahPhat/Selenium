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

public class TC89943_ClientPrimaryDiagnosisCode extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the valid ClientPrimaryDiagnosisCode 
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89943_OpenEVV_valid_ClientPrimaryDiagnosisCode() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC89943_OpenEVV_valid_ClientPrimaryDiagnosisCode");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientPrimaryDiagnosisCode", "E32.92A");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);	
	}

	//To validate the invalid ClientPrimaryDiagnosisCode length
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89943_OpenEVV_invalid_ClientPrimaryDiagnosisCode_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89943_OpenEVV_invalid_ClientPrimaryDiagnosisCode_length");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientPrimaryDiagnosisCode", "T"+ CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientPrimaryDiagnosisCode length is invalid. The length should be between 0 and 10.");
	}

	//To validate the ClientPrimaryDiagnosisCode with leading space
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89943_OpenEVV_leading_space_ClientPrimaryDiagnosisCode() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89943_OpenEVV_leading_space_ClientPrimaryDiagnosisCode");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientPrimaryDiagnosisCode", " " + "T"+ CommonMethods.generateRandomNumberOfFixLength(5));
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientPrimaryDiagnosisCode format is incorrect"));
	}

	//To validate the ClientPrimaryDiagnosisCode with trailing space
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89943_OpenEVV_trailing_space_ClientPrimaryDiagnosisCode() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89943_OpenEVV_trailing_space_ClientPrimaryDiagnosisCode");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientPrimaryDiagnosisCode", "T"+ CommonMethods.generateRandomNumberOfFixLength(5) + " ");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientPrimaryDiagnosisCode format is incorrect"));

	}

	//To validate the ClientPrimaryDiagnosisCode with special character
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89943_OpenEVV_specialCharacter_ClientPrimaryDiagnosisCode() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC89943_OpenEVV_specialCharacter_ClientPrimaryDiagnosisCode");
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientPrimaryDiagnosisCode", CommonMethods.generateSpecialChar(6));

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientPrimaryDiagnosisCode format is incorrect"));
	}

}