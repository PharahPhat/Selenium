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

public class R2858_TC96177_AltEVV_ClientAddressLatitude extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	@Test(groups = {"All"})
	public void R2858_TC96177_AltEVV_ClientAddressLatitudetude_Format_MoreThan_90() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96177_AltEVV_ClientAddressLatitudetude_Format_MoreThan_90");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put("ClientAddressLatitude", "91.23");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put("ClientAddressLatitude", "91.23");

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLatitude value cannot be greater than 90.");
	}

	@Test(groups = {"All"})
	public void R2858_TC96177_AltEVV_ClientAddressLatitude_Format_Null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96177_AltEVV_ClientAddressLatitude_Format_Null");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put("ClientAddressLatitude", null);

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLatitude cannot be null.");
	}

	@Test(groups = {"All"})
	public void R2858_TC96177_AltEVV_ClientAddressLatitude_Format_lessthan90() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96177_AltEVV_ClientAddressLatitude_Format_lessthan90");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put("ClientAddressLatitude", "79");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put("ClientAddressLatitude", "79");
		
		CommonMethods.validateResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	@Test(groups = {"All"})
	public void R2858_TC96177_AltEVV_ClientAddressLatitude_Format_MaxLengthplusone() throws InterruptedException, IOException, ParseException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96177_AltEVV_ClientAddressLatitude_Format_MaxLengthplusone");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put("ClientAddressLatitude",CommonMethods.generateRandomNumberOfFixLength(101));

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put("ClientAddressLatitude",CommonMethods.generateRandomNumberOfFixLength(101));
		
		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLatitude value cannot be greater than 90.");
	}
	
	@Test(groups = {"All"})
	public void R2858_TC96177_AltEVV_ClientAddressLatitude_Format_Minus90() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96177_AltEVV_ClientAddressLatitude_Format_MaxLengthplusone");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put("ClientAddressLatitude","-91");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put("ClientAddressLatitude","-91");
		
		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLatitude value cannot be less than -90.");
	}
	
	@Test(groups = {"All"})
	public void R2858_TC96177_AltEVV_ClientAddressLatitude_Format_speciale() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96177_AltEVV_ClientAddressLatitude_Format_MaxLengthplusone");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put("ClientAddressLatitude",CommonMethods.generateSpecialChar(10));

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put("ClientAddressLatitude",CommonMethods.generateSpecialChar(10));
		
		String body = CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(body, "NumberFormatException");
	}

}



