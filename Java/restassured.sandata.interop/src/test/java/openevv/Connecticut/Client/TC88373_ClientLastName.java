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

//Test Case 88373:Open EVV- Client-Validate (mix) - ClientLastName field formats/values

public class TC88373_ClientLastName extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	//test case with invalid client last name
	public void TC88373_OpenEVV_ClientLastName_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88373_OpenEVV_ClientLastName_invalid");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientLastName", "*123");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Asserting that result of client data .
		//Assert.assertEquals(bodyAsString.contains(val1) Expected value, true Actual Value, "Response body contains Accout");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		

	}

	//test case with valid last name
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88373_OpenEVV_ClientLastName_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{

		// logger = extent.startTest("TC88373_OpenEVV_ClientLastName_valid");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientLastName", "babaraja");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Asserting that result of client data .
		//Assert.assertEquals(bodyAsString.contains(val1) Expected value, true Actual Value, "Response body contains Accout");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		Assert.assertTrue(bodyAsString.contains("\"account\": \"14420\","));



	}




}


