package AltEVV_generic.restassured.sandata.Indiana.Client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.Assertion_DbVerifier; 

public class R2267_TC91238_AltEVV_ClientAddressLatitude extends BaseTest { 
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All" , "Regression"})
	public void R2267_TC91238_AltEVV_ClientAddressLatitudetude_Format_MoreThan_90() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2267_TC91238_AltEVV_ClientAddressLatitudetude_Format_MoreThan_90");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude, "91.23");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLatitude, "91.23");

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLatitude value cannot be greater than 90.");
	}


	@Test(groups = {"All", "Regression"})
	public void R2267_TC91238_AltEVV_ClientAddressLatitude_Format_lessthan90() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2267_TC91238_AltEVV_ClientAddressLatitude_Format_lessthan90");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude, "79");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLatitude, "79");
		
		CommonMethods.validateResponse(altEVVJsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	@Test(groups = {"All"})
	public void R2267_TC91238_AltEVV_ClientAddressLatitude_Format_MaxLengthplusone() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2267_TC91238_AltEVV_ClientAddressLatitude_Format_MaxLengthplusone");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude,CommonMethods.generateRandomNumberOfFixLength(101));

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLatitude,CommonMethods.generateRandomNumberOfFixLength(101));
		
		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLatitude value cannot be greater than 90.");
	}
	
	@Test(groups = {"All"})
	public void R2267_TC91238_AltEVV_ClientAddressLatitude_Format_Minus90() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2267_TC91238_AltEVV_ClientAddressLatitude_Format_MaxLengthplusone");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude,"-91");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLatitude,"-91");
		
		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLatitude value cannot be less than -90.");
	}
	
	@SuppressWarnings("unused")
	@Test(groups = {"All"})
	public void R2267_TC91238_AltEVV_ClientAddressLatitude_Format_specialchar() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2267_TC91238_AltEVV_ClientAddressLatitude_Format_specialchar");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLatitude,CommonMethods.generateSpecialChar(10));

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLatitude,CommonMethods.generateSpecialChar(10));
		
		CommonMethods.capturePostResponse_400(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

}



