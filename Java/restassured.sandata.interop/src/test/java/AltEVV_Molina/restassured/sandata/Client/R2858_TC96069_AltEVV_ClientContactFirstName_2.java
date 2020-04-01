package AltEVV_Molina.restassured.sandata.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class R2858_TC96069_AltEVV_ClientContactFirstName_2 extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	//Case-1 Testing with ClientContactFirstName more than 30
	@Test(groups = {"All"})
	public void R2858_TC96069_AltEVV_ClientContactFisrtName_MoreThan30() throws InterruptedException, java.text.ParseException, IOException, ParseException
	{
		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactFirstName, CommonMethods.generateRandomStringOfFixLength(31));



		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientContacFirstNameMaxLengthError);
	}

	// Case-2 Testing with alphabets starting with a space
	@Test(groups = {"All"})
	public void R2858_TC96069_AltEVV_ClientContactFirstName_spacecombination() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96069_AltEVV_ClientContactFirstName_spacecombination");



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactFirstName, " Clientfname");



		CommonMethods.validateResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	@Test(groups = {"All"})
	public void R2858_TC96069_AltEVV_ClientContactFirstName_Endspacecombination() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96069_AltEVV_ClientContactFirstName_Endspacecombination");



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactFirstName, "lastname ");

		CommonMethods.validateResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	// Case-4 Testing with valid special characters ("." or " '  " or  "-" ) 
	@Test(groups = {"All"})
	public void R2858_TC96069_AltEVV_ClientContactFirstName_combination_with_specialcharpos() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96069_AltEVV_ClientContactFirstName_combination_with_specialcharpos");



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactFirstName, "Fnu.Neerajor-kam");



		CommonMethods.validateResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	// Case-5 Testing with special characters other than few special characters ("@" ) 
	@Test(groups = {"All"})
	public void R2858_TC96069_AltEVV_ClientContactFirstName_withSpecialChar() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96069_AltEVV_ClientContactFirstName_withSpecialChar");



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactFirstName, "Neeraj@Kumar");

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientContacFirstNameFormaterror);

	}

	@Test(groups = {"All"})
	public void R2858_TC96069_AltEVV_ClientContactFirstName_startwithNumber() throws InterruptedException, IOException, ParseException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96069_AltEVV_ClientContactFirstName_startwithNumber");



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactFirstName, "1NeerajKumar");

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientContacFirstNameFormaterror);
	}
}
