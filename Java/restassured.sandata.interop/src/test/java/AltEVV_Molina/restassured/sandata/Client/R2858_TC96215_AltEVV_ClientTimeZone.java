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

//TC91118: OpenEVV-altEVV- Client: Validate If the ClientSSN field is left empty

import com.globalMethods.core.Assertion_DbVerifier; public class R2858_TC96215_AltEVV_ClientTimeZone extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	// Validating valid altEVV ClientTimeZone field with 50chars
	@Test(groups = {"All"})
	public void R2858_TC96215_AltEVV_ClientTimeZone_valid_50chars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2858_TC96215_AltEVV_ClientTimeZone_valid_5");
		logger.log(LogStatus.INFO, "Validating valid altEVV ClientTimeZone field with 50chars"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientTimezone, "qa");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientTimeZone value is invalid.");

	}

	// Validating valid altEVV ClientTimeZone field with min 1chars
	@Test(groups = {"All"})
	public void R2858_TC96215_AltEVV_ClientTimeZone_valid_min_1char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2858_TC96215_AltEVV_ClientTimeZone_valid_5");
		logger.log(LogStatus.INFO, "Validating valid altEVV ClientTimeZone field min 1chars"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientTimezone, CommonMethods.generateRandomStringOfFixLength(1));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientTimeZone value is invalid.");

	}

	// Validating valid altEVV ClientTimeZone field having EST_otherthanallowedvalue
	@Test(groups = {"All"})
	public void R2858_TC96215_AltEVV_ClientTimeZone_valid_EST_otherthanallowedvalue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96215_AltEVV_ClientTimeZone_valid_blank_value");
		logger.log(LogStatus.INFO, "Validating valid altEVV ClientTimeZone field having EST_otherthanallowedvalue"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientTimezone, "EST");

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	// Validating invalid altEVV ClientTimeZone field with blank value
	@Test(groups = {"All"})
	public void R2858_TC96215_AltEVV_ClientTimeZone_invalid_blank_value() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2858_TC96215_AltEVV_ClientTimeZone_invalid_blank_value");
		logger.log(LogStatus.INFO, "Validating invalid altEVV ClientTimeZone field with blank value"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientTimezone, CommonMethods.generateRandomStringOfFixLength(0));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientTimezonesizeError);

	}

	// Validating invalid altEVV ClientTimeZone field with null value
	@Test(groups = {"All"})
	public void R2858_TC96215_AltEVV_ClientTimeZone_invalid_null_value() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2858_TC96215_AltEVV_ClientTimeZone_invalid_null_value");
		logger.log(LogStatus.INFO, "Validating invalid altEVV ClientTimeZone field with null value"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientTimezone, null);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientTimezonenullerror);

	}

	// Validating invalid altEVV ClientTimeZone field haivng all_otherthanallowedvalue
	@Test(groups = {"All"})
	public void R2858_TC96215_AltEVV_ClientTimeZone_invalid_all_otherthanallowedvalue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2858_TC96215_AltEVV_ClientTimeZone_invalid_blank_value");
		logger.log(LogStatus.INFO, "Validating invalid altEVV ClientTimeZone field having all_otherthanallowedvalue"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.ClientTimezone, "ALL");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientTimeZone value is invalid.");

	}

}