package AltEVV_Molina.restassured.sandata.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorClient;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class R2858_TC96056_AltEVV_ClientAddressType extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	// Validating with valid ClientAddressType Under ClientAddress_BUSINESS
	@Test(groups = {"All"})
	public void R2858_TC96056_AltEVV_ClientAddressType_valid_AddressType_Under_ClientAddress_BUSINESS() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96056_AltEVV_ClientAddressType_valid_AddressType_Under_ClientAddress_BUSINESS");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.addressType,DataGeneratorClient.clientAddressType());

		JSONObject altEVVJsonObjectAddress_CA = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_CA.put(globalVariables.addressType,DataGeneratorClient.clientAddressType());

		CommonMethods.validateResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

	}

	//Validating with invalid ClientAddressType Under ClientAddress_AddressType other than Business|Home|Other
	@Test(groups = {"All"})
	public void R2858_TC96056_AltEVV_ClientAddressType_invalid_AddressType_Under_ClientAddress() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96056_AltEVV_ClientAddressType_invalid_AddressType_Under_ClientAddress");


		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.addressType,CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientAddressTypeFormaterror);


	}

	//Validating with invalid ClientAddressType Under ClientAddress_AddressType greater than 12
	@Test(groups = {"All"})
	public void R2858_TC96056_AltEVV_ClientAddressType_valid_AddressType_greterThan12() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96056_AltEVV_ClientAddressType_valid_AddressType_greterThan12");



		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.addressType,CommonMethods.generateRandomStringOfFixLength(14));

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientAddressTypeFormaterror);

	}

	//Validating with invalid ClientAddressType Under ClientAddress_AddressType with null
	@Test(groups = {"All"})
	public void R2858_TC96056_AltEVV_ClientAddressType_valid_AddressType_null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96056_AltEVV_ClientAddressType_valid_AddressType_Other_Trailingspace");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.addressType,null);

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressTypeNullError);


	}

	//Validating with invalid ClientAddressType Under ClientAddress_AddressType with blank
	@Test(groups = {"All"})
	public void R2858_TC96056_AltEVV_ClientAddressType_valid_AddressType_blank() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96056_AltEVV_ClientAddressType_valid_AddressType_blank");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.addressType," ");

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientAddressTypeFormaterror);


	}

}