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

//Test Case 91204:OpenEVV-altEVV- Responsible Party/Designated Signer: Validate If the ClientContactLastName should contains maximum characters.

import com.globalMethods.core.Assertion_DbVerifier; public class R2858_TC96076_AltEVV_ClientContactLastName extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	String clntid,clintid_db="LOC", clntcontctLstname_db = "L_NAME";

	//validating valid altEVV client  having ClientContactFirstname with Max_minus_one_Length
	@Test(groups = {"All"})
	public void R2858_TC96076_AltEVV_ClientContactFirstname_valid_Max_minus_one_Length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96076_AltEVV_ClientContactFirstname_valid_Max_minus_one_Length");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Max_minus_one_Length"); 
		String clntcontactfstname=CommonMethods.generateRandomStringOfFixLength(30);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactLastName, clntcontactfstname);
		clntid=jsonObject.get(globalVariables.ClientID).toString();

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//validating valid altEVV client  having ClientContactFirstname with Mid_Length
	@Test(groups = {"All"})
	public void R2858_TC96076_AltEVV_ClientContactFirstname_valid_Mid_Length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96076_AltEVV_ClientContactFirstname_valid_Mid_Length");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Mid_Length"); 
		String clntcontactfstname=CommonMethods.generateRandomStringOfFixLength(15);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactLastName, clntcontactfstname);
		clntid=jsonObject.get(globalVariables.ClientID).toString();

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//validating valid altEVV client  having ClientContactFirstname with Min_Length
	@Test(groups = {"All"})
	public void R2858_TC96076_AltEVV_ClientContactFirstname_valid_Min_Length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96076_AltEVV_ClientContactFirstname_valid_Min_Length");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Min_Length"); 
		String clntcontactfstname=CommonMethods.generateRandomStringOfFixLength(1);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactLastName, clntcontactfstname);
		clntid=jsonObject.get(globalVariables.ClientID).toString();

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//validating valid altEVV client  having ClientContactFirstname with Max_plus_one_Length
	@Test(groups = {"All"})
	public void R2858_TC96076_AltEVV_ClientContactFirstname_invalid_Max_plus_one_Length() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96076_AltEVV_ClientContactFirstname_invalid_Max_plus_one_Length");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Max_plus_one_Length"); 


		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactLastName, CommonMethods.generateRandomStringOfFixLength(31));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientContactLastName (Responsible Party) value is incorrect. The length should be between 1 and 30.");

	}

	//validating valid altEVV client  having ClientContactFirstname with Max_minus_specialString
	@Test(groups = {"All"})
	public void R2858_TC96076_AltEVV_ClientContactFirstname_invalid_Max_minus_specialString() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96076_AltEVV_ClientContactFirstname_invalid_Max_minus_specialString");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Max_minus_specialString"); 


		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactLastName, CommonMethods.generateSpecialChar(15));
		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientContactLastName (Responsible Party) format is incorrect. The record should satisfy this regular expression");

	}

	//validating valid altEVV client  having ClientContactFirstname with Max_plus_specialString
	@Test(groups = {"All"})
	public void R2858_TC96076_AltEVV_ClientContactFirstname_invalid_Max_plus_specialString() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96076_AltEVV_ClientContactFirstname_invalid_Max_plus_specialString");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Max_plus_specialString"); 


		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactLastName, CommonMethods.generateSpecialChar(31));
		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientContactLastName (Responsible Party) format is incorrect. The record should satisfy this regular expression");

	}



}