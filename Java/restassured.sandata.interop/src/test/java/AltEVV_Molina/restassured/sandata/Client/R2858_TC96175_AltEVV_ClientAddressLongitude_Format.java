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

public class R2858_TC96175_AltEVV_ClientAddressLongitude_Format extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	//Case-1 Testing with longitude more than -180
	@Test(groups = {"All"})
	public void R2858_TC96175_AltEVV_ClientAddressLongitude_Format_minus180() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96175_AltEVV_ClientAddressLongitude_Format_MoreThan_100");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude, "-181.99");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put("ClientAddressLongitude", "-181.99");

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLongitude value cannot be less than -180.");

	}
 
	@Test(groups = {"All"})
	public void R2858_TC96175_AltEVV_ClientAddressLongitude_Format_plus180() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96175_AltEVV_ClientAddressLongitude_Format_MoreThan_100");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude, "181.99");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put("ClientAddressLongitude", "181.99");

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLongitude value cannot be greater than 180.");

	}

	//Case-1 Testing with longitude is null
	@Test(groups = {"All"})
	public void R2858_TC96175_AltEVV_ClientAddressLongitude_Format_Null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96175_AltEVV_ClientAddressLongitude_Format_Null");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put("ClientAddressLongitude", null);

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientAddressLongitude cannot be null");
	}


	//Case-3 Testing with longitude less than -180 
	@Test(groups = {"All"})
	public void R2858_TC96175_AltEVV_ClientAddressLongitude_Format_lessthan180() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96175_AltEVV_ClientAddressLongitude_Format_lessthan180");


		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	

		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude, "-79");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put("ClientAddressLongitude", "-179");


		CommonMethods.validateResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}


	//Case-1 Testing with longitude more than 100 character
	@Test(groups = {"All"})
	public void R2858_TC96175_AltEVV_ClientAddressLongitude_Format_MaxLengthplusone() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96175_AltEVV_ClientLongitude_Format_MaxLengthplusone");


		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	

		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put("ClientAddressLongitude",CommonMethods.generateRandomNumberOfFixLength(101));

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put("ClientAddressLongitude","181");


		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLongitude value cannot be greater than 180.");

	}
}
