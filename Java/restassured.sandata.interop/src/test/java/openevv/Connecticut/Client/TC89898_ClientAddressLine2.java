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

public class TC89898_ClientAddressLine2 extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the valid ClientAddressLine2
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC89898_OpenEVV_ClientAddressLine2() throws InterruptedException, IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException{
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", CommonMethods.generateRandomStringOfFixLength(10));
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, js);
	}

	//To validate the invalid ClientAddressLine2 length
	@Test(groups = {"All"})@AdditionalInfo(module = "OpenEVV")
	public void TC89898_OpenEVV_ClientAddressLine2_length() throws InterruptedException, IOException, ParseException
	{
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", "PYQUHBIJOEUFQDHPRUDSGORSGIQVOHMANHATTAN");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientAddressLine2 length is invalid. The length should be between 0 and 30."));
	}

	//To validate the ClientAddressLine2 with single space
	@Test(groups = {"All"})@AdditionalInfo(module = "OpenEVV")
	public void TC89898_OpenEVV_ClientAddressLine2_single_space() throws InterruptedException,IOException, ParseException
	{
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", "South Amboy");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the numeric value in ClientAddressLine2
	@Test(groups = {"All"})@AdditionalInfo(module = "OpenEVV")
	public void TC89898_OpenEVV_ClientAddressLine2_Numeric() throws InterruptedException,  IOException, ParseException
	{
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", "Man1hattan");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ClientAddressLine2 with trailing space
	@Test(groups = {"All"})@AdditionalInfo(module = "OpenEVV")
	public void TC89898_OpenEVV_ClientAddressLine2_trailing_space() throws InterruptedException, IOException, ParseException
	{
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", "Manhattan ");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ClientAddressLine2 with leading space
	@Test(groups = {"All"})@AdditionalInfo(module = "OpenEVV")
	public void TC89898_OpenEVV_ClientAddressLine2_leading_space() throws InterruptedException,IOException, ParseException
	{
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", " Manhattan");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ClientAddressLine2 with mid space and numeric
	@Test(groups = {"All"})@AdditionalInfo(module = "OpenEVV")
	public void TC89898_OpenEVV_ClientAddressLine2_multiple_spaces_Alphanumeric() throws InterruptedException, IOException, ParseException
	{
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", "Test Address qwert1 piou abc");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
	}

	//To validate the ClientAddressLine2 with special char
	@Test(groups = {"All"})@AdditionalInfo(module = "OpenEVV")
	public void TC89898_OpenEVV_ClientAddressLine2_special_char() throws InterruptedException, IOException, ParseException
	{
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientAddressLine2", "Manhatt@n");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientAddressLine2 format is incorrect."));
	}

}
