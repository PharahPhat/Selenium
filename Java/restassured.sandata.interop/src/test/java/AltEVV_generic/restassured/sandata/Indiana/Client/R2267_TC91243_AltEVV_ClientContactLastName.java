package AltEVV_generic.restassured.sandata.Indiana.Client;

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

public class R2267_TC91243_AltEVV_ClientContactLastName extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();

	//Case-1 Testing with ClientContactLastName more than 30
	@Test(groups = {"All", "fixing"})
	public void R2267_TC91243_AltEVV_ClientContactLastName_MoreThan30() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, ClassNotFoundException, SQLException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2267_TC91243_AltEVV_ClientContactLastName_MoreThan30");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		
		altEVVJsonObjectAddress.put(globalVariables.clientContactLastName, CommonMethods.generateRandomStringOfFixLength(31));

		CommonMethods.validateResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		assertionDbVerifier.verifyInboxClientContactAltEVVGeneric(altEVVJsonObject, altEVVJsonObjectAddress);
	}

	// Case-4 Testing with valid special characters ("." or " '  " or  "-" ) 
	@Test(groups = {"All"})
	public void R2267_TC91243_AltEVV_ClientContactLastName_combination_with_specialcharpos() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2267_TC91243_AltEVV_ClientContactLastName_combination_with_specialcharpos");



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactLastName, "Fnu.Neerajor-kam");

		CommonMethods.validateResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}
	
	// Case-5 Testing with special characters other than few special characters ("@" ) 
	@Test(groups = {"All"})
	public void R2267_TC91243_AltEVV_ClientContactLastName_withSpecialChar() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2267_TC91243_AltEVV_ClientContactLastName_withSpecialChar");



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactLastName, "Neeraj@Kumar");

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientContacLastNameFormaterror);
	}

	@Test(groups = {"All"})
	public void R71852_TC91243_AltEVV_ClientContactLastName_startwithNumber() throws InterruptedException, java.text.ParseException, IOException, ParseException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2267_TC91243_AltEVV_ClientContactLastName_startwithNumber");



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.ClientResponsibleParty);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.clientContactLastName, "1NeerajKumar");

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientContacLastNameFormaterror);
	}


}
