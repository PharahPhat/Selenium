package AltEVV_Molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
 
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class R2858_TC96047_AltEVV_ClientSSN extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	@Test(groups = {"All"})
	public void R2858_TC96047_AltEVV_ClientSSN_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96047_AltEVV_ClientSSN_valid");
		logger.log(LogStatus.INFO, "Validate valid Client SSN"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	@Test(groups = {"All"})
	public void R2858_TC96047_AltEVV_ClientSSN_invalid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96047_AltEVV_ClientSSN_invalid_length");
		logger.log(LogStatus.INFO, "Validate invalid Client SSN length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientSSN length is invalid. The length should be between 1 and 9.");
	}

	@Test(groups = {"All"})
	public void R2858_TC96047_AltEVV_ClientSSN_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96047_AltEVV_ClientSSN_alphanumeric");
		logger.log(LogStatus.INFO, "Validate invalid Client SSN alphanumeric"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		String clientssn = CommonMethods.generateRandomAlphaNumeric(9);
		jsonObject.put("ClientSSN",clientssn );

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientSSN format is incorrect.");

	}

	@Test(groups = {"All"})
	public void R2858_TC96047_AltEVV_ClientSSN_nonnumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96047_AltEVV_ClientSSN_nonumeric");
		logger.log(LogStatus.INFO, "Validate invalid Client SSN length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		String clientssn = CommonMethods.generateRandomStringOfFixLength(9);
		jsonObject.put("ClientSSN",clientssn );

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientSSN format is incorrect.");

	}

	@Test(groups = {"All"})
	public void R2858_TC96047_AltEVV_ClientSSN_dash() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96047_AltEVV_ClientSSN_nonumeric");
		logger.log(LogStatus.INFO, "Validate invalid Client SSN length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		String clientssn = CommonMethods.generateRandomStringOfFixLength(4) + "-" + CommonMethods.generateRandomStringOfFixLength(4);
		jsonObject.put("ClientSSN",clientssn);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientSSN format is incorrect.");

	}

	@Test(groups = {"All"})
	public void R2858_TC96047_AltEVV_ClientSSN_leading_zeros() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96047_AltEVV_ClientSSN_leading_zeros");
		logger.log(LogStatus.INFO, "Validate invalid Client SSN with leading zeros"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		String clientssn = "00" + CommonMethods.generateRandomStringOfFixLength(7);
		jsonObject.put("ClientSSN",clientssn);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientSSN format is incorrect.");

	}

	@Test(groups = {"All"})
	public void R2858_TC96047_AltEVV_ClientSSN_Empty() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96047_AltEVV_ClientSSN_valid");
		logger.log(LogStatus.INFO, "Validate valid Client SSN"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientSSN", "");

		String clientotherid = CommonMethods.generateRandomNumberOfFixLength(9);
		jsonObject.put("ClientOtherID", clientotherid);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "");
	}


}