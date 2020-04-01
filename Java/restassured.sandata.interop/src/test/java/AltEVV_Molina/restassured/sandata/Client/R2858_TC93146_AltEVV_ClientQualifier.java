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

/**
 * @author MayankM
 *
 */

import com.globalMethods.core.Assertion_DbVerifier; public class R2858_TC93146_AltEVV_ClientQualifier extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//validating AltEVV clientQualifier = ClientSSN
	@Test(groups = {"All"})
	public void R2858_TC93146_AltEVV_ClientQualifier_ClientSSN() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC93146_AltEVV_ClientQualifier_ClientSSN");
		logger.log(LogStatus.INFO, "validating altEVV clientQualifier = ClientSSN"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientQualifier", "ClientSSN");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//validating AltEVV clientQualifier = ClientOtherID
	@Test(groups = {"All"})
	public void R2858_TC93146_AltEVV_ClientQualifier_ClientOtherID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC93146_AltEVV_ClientQualifier_ClientOtherID");
		logger.log(LogStatus.INFO, "validating altEVV clientQualifier = ClientOtherID"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientQualifier", "ClientOtherID");
	
		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//validating AltEVV clientQualifier = ClientCustomID
	@Test(groups = {"All"})
	public void R2858_TC93146_AltEVV_ClientQualifier_ClientCustomID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC93146_AltEVV_ClientQualifier_ClientCustomID");
		logger.log(LogStatus.INFO, "validating altEVV clientQualifier = ClientCustomID"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientQualifier", "ClientCustomID");
	
		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//validating AltEVV clientQualifier invalid length
	@Test(groups = {"All"})
	public void R2858_TC93146_AltEVV_ClientQualifier_invalid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC93146_AltEVV_ClientQualifier_invalid_length");
		logger.log(LogStatus.INFO, "validating ClientQualifier with invalid length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientQualifier", CommonMethods.generateRandomStringOfFixLength(21));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierLengthError);
	}

	//validating AltEVV clientQualifier invalid format
	@Test(groups = {"All"})
	public void R2858_TC93146_AltEVV_ClientQualifier_invalid_format() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC93146_AltEVV_ClientQualifier_invalid_format");
		logger.log(LogStatus.INFO, "validating ClientQualifier with invalid format"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientQualifier", CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierFormatError);
	}

	//validating AltEVV clientQualifier = null
	@Test(groups = {"All", "Smoke"})
	public void R2858_TC93146_AltEVV_ClientQualifier_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC93146_AltEVV_ClientQualifier_null");
		logger.log(LogStatus.INFO, "validating ClientQualifier = null"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientQualifier", null);

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientQualifierNullError_Molina);
	}



}