/**
 * 
 */
package AltEVV_Molina.restassured.sandata.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Anupam
 */

public class R2858_TC96063_AltEVV_ClientAddress_ClientCity_validations extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	//Case1- ClientAddress_ClientCity max length should be less than or equals to 30 and type = string 
	@Test(groups = {"All"})
	public void R2858_TC96063_AltEVV_CreateClient_with_valid_ClientCity() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// logger = extent.startTest("R2858_TC96063_AltEVV_CreateClient_with_valid_ClientCity");
		logger.log(LogStatus.INFO, "Validating ClientJson valid ClientCity should be less than or equals to 30 and type = string"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray_sub = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
	
		JSONObject jsonObject3 = (JSONObject) jsonArray_sub.get(0);
		jsonObject3.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(14));

		JSONObject jsonObject3_add = (JSONObject) jsonArray_sub.get(1);
		jsonObject3_add.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(14));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//Case2- ClientAddress_ClientCity more than 30 length 
	@Test(groups = {"All"})
	public void R2858_TC96063_AltEVV_CreateClient_with_invalid_ClientCity_with_more_than_30length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// logger = extent.startTest("R2858_TC96063_AltEVV_CreateClient_with_valid_ClientCity");
		logger.log(LogStatus.INFO, "Validating ClientJson valid ClientCity should be less than or equals to 30 and type = string"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray_sub = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
		
		JSONObject jsonObject3 = (JSONObject) jsonArray_sub.get(0);
		jsonObject3.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(31));

		JSONObject jsonObject3_add = (JSONObject) jsonArray_sub.get(1);
		jsonObject3_add.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(31));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientCity value is incorrect. The length should be between 1 and 30");

	}

	//Case3- ClientAddress_ClientCity max length equals to 30 and type = string 
	@Test(groups = {"All"})
	public void R2858_TC96063_AltEVV_CreateClient_with_valid_Max_ClientCity_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// logger = extent.startTest("R2858_TC96063_AltEVV_CreateClient_with_valid_Max_ClientCity_length");
		logger.log(LogStatus.INFO, "Validating ClientJson valid ClientAddress_ClientCity max length equals to 30 and type = string"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray_sub = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
		
		JSONObject jsonObject3 = (JSONObject) jsonArray_sub.get(0);
		jsonObject3.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(30));

		JSONObject jsonObject3_add = (JSONObject) jsonArray_sub.get(1);
		jsonObject3_add.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(30));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//Case4- ClientAddress_ClientCity max length should be more than 30 and type not equals to the string 
	@Test(groups = {"All"})
	public void R2858_TC96063_AltEVV_CreateClient_with_invalid_ClientCity_as_not_String() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// logger = extent.startTest("R2858_TC96063_AltEVV_CreateClient_with_invalid_ClientCity_as_not_String");
		logger.log(LogStatus.INFO, "Validating ClientJson valid ClientAddress_ClientCity type = string"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray_sub = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
		
		JSONObject jsonObject3 = (JSONObject) jsonArray_sub.get(0);
		jsonObject3.put(globalVariables.ClientCity, CommonMethods.generateSpecialChar(36));

		JSONObject jsonObject3_add = (JSONObject) jsonArray_sub.get(1);
		jsonObject3_add.put(globalVariables.ClientCity, CommonMethods.generateSpecialChar(36));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientCity value is incorrect. The length should be between 1 and 30");


	}

	//Case5- ClientAddress_ClientCity less than 30 length and not a string 
	@Test(groups = {"All"})
	public void R2858_TC96063_AltEVV_CreateClient_with_invalid_ClientCity_with_less_than_30length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// logger = extent.startTest("R2858_TC96063_AltEVV_CreateClient_with_invalid_ClientCity_with_less_than_30length");
		logger.log(LogStatus.INFO, "Validating ClientJson valid ClientCity should be less than 30 and type = not a string"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonObject2 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);

		jsonObject3.put(globalVariables.ClientCity, CommonMethods.generateSpecialChar(20));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientCity format is incorrect. The record should satisfy this regular expression");

	}

	//Case6- ClientAddress_ClientCity value null 
	@Test(groups = {"All"})
	public void R2858_TC96063_AltEVV_CreateClient_with_invalid_ClientCity_Null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// logger = extent.startTest("R2858_TC96063_AltEVV_CreateClient_with_invalid_ClientCity_Null");
		logger.log(LogStatus.INFO, "Validating ClientJson invalid ClientCity value null"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonObject2 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);
		jsonObject3.put(globalVariables.ClientCity, null);

		JSONObject jsonObject3_add = (JSONObject) jsonObject2.get(1);
		jsonObject3_add.put(globalVariables.ClientCity, null);

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientCity cannot be null");
	}

	//Case7- ClientAddress_ClientCity 30 length with heading spaces 
	@Test(groups = {"All"})
	public void R2858_TC96063_AltEVV_CreateClient_with_valid_ClientCity_with_30length_headingspaces() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// logger = extent.startTest("R2858_TC96063_AltEVV_CreateClient_with_valid_ClientCity_with_30length_headingspaces");
		logger.log(LogStatus.INFO, "Validating ClientJson valid_ClientCity_with_30length_headingspaces"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray_sub = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
		JSONObject jsonObject3 = (JSONObject) jsonArray_sub.get(0);

		jsonObject3.put(globalVariables.ClientCity, ' '+ CommonMethods.generateRandomStringOfFixLength(29));

		JSONObject jsonObject3_add = (JSONObject) jsonArray_sub.get(1);
		jsonObject3_add.put(globalVariables.ClientCity, ' '+ CommonMethods.generateRandomStringOfFixLength(29));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//Case8- ClientAddress_ClientCity 30 length with leading spaces 
	@Test(groups = {"All"})
	public void R2858_TC96063_AltEVV_CreateClient_with_valid_ClientCity_with_30length_leadingspaces() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// logger = extent.startTest("R2858_TC96063_AltEVV_CreateClient_with_valid_ClientCity_with_30length_leadingspaces");
		logger.log(LogStatus.INFO, "Validating ClientJson valid_ClientCity_with_30length_leadingspaces"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
		
		JSONObject jsonObject3 = (JSONObject) jsonArray1.get(0);
		jsonObject3.put(globalVariables.ClientCity,  CommonMethods.generateRandomStringOfFixLength(29) +' ');
	
		JSONObject jsonObject3_add = (JSONObject) jsonArray1.get(1);
		jsonObject3_add.put(globalVariables.ClientCity,  CommonMethods.generateRandomStringOfFixLength(29) +' ');
	
		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
		}
}

