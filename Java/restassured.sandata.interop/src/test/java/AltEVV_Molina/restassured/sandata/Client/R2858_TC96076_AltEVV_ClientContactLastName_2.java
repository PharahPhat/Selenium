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

import java.io.IOException;
import java.sql.SQLException;

public class R2858_TC96076_AltEVV_ClientContactLastName_2 extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	//Case-1 Testing with ClientContactLastName more than 30
	@Test(groups = {"All"})
	public void R2858_TC96076_AltEVV_ClientContactLastName_MoreThan30() throws InterruptedException, java.text.ParseException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96076_AltEVV_ClientContactLastName_MoreThan30");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		
		altEVVJsonObjectAddress.put(globalVariables.clientContactLastName, CommonMethods.generateRandomStringOfFixLength(31));

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,"ERROR: The ClientContactLastName (Responsible Party) value is incorrect. The length should be between 1 and 30" );



	}
	
	// Case-2 Testing with alphabets starting with a space
	@Test(groups = {"All"})
	public void R2858_TC96076_AltEVV_ClientContactLastName_spacecombination() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96076_AltEVV_ClientContactLastName_spacecombination");



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactLastName, " Clientlname");


		CommonMethods.validateResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	@Test(groups = {"All"})
	public void R2858_TC96076_AltEVV_ClientContactLastName_Endspacecombination() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96076_AltEVV_ClientContactLastName_MoreThan30");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactLastName, "lastname ");

		CommonMethods.validateResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	// Case-4 Testing with valid special characters ("." or " '  " or  "-" ) 
	@Test(groups = {"All"})
	public void R2858_TC96076_AltEVV_ClientContactLastName_combination_with_specialcharpos() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96076_AltEVV_ClientContactLastName_combination_with_specialcharpos");



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactLastName, "Fnu.Neerajor-kam");



		CommonMethods.validateResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}
	
	// Case-5 Testing with special characters other than few special characters ("@" ) 
	@Test(groups = {"All"})
	public void R2858_TC96076_AltEVV_ClientContactLastName_withSpecialChar() throws InterruptedException, java.text.ParseException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96076_AltEVV_ClientContactLastName_withSpecialChar");



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactLastName, "Neeraj@Kumar");



		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientContactLastName (Responsible Party) format is incorrect. The record should satisfy this regular expression");



	}

	@Test(groups = {"All"})
	public void R2858_TC96076_AltEVV_ClientContactLastName_startwithNumber() throws InterruptedException, java.text.ParseException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96076_AltEVV_ClientContactLastName_startwithNumber");



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactLastName, "1NeerajKumar");

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientContacLastNameFormaterror);



	}


}
