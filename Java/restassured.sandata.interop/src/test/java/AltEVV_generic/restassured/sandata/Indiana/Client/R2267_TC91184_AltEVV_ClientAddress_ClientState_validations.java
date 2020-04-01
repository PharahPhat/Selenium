/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Client;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
 
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorClient;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 91184: OpenEVV-altEVV- Client Address -ClientState validation field formats/values
/**
 * @author Anupam
 *
 */

public class R2267_TC91184_AltEVV_ClientAddress_ClientState_validations extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Case1- ClientAddress_ClientState max length should be 2 and type = string
	@Test(groups = {"All"})
	public void TC91184_AltEVV_CreateClient_with_valid_ClientState_with_2chars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException 
	{   
		// logger = extent.startTest("TC91184_AltEVV_CreateClient_with_valid_ClientState_with_2chars");
		logger.log(LogStatus.INFO, "Validating ClientJson valid ClientState equals to 2 and type = string"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonObject2 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	

		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);
		jsonObject3.put(globalVariables.ClientState, DataGeneratorClient.generateClientState());

		JSONObject jsonObject3_add = (JSONObject) jsonObject2.get(1);
		jsonObject3_add.put(globalVariables.ClientState, DataGeneratorClient.generateClientState());


		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	}

	//Case2- ClientAddress_ClientState more than 2 length and type = string 
	@Test(groups = {"All"})
	public void TC91184_AltEVV_CreateClient_with_invalid_ClientState_with_more_than_2length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// logger = extent.startTest("TC91184_AltEVV_CreateClient_with_invalid_ClientState_with_more_than_2length");
		logger.log(LogStatus.INFO, "Validating ClientJson valid ClientState more than 2 and type = string"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonObject2 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	

		JSONObject jsonObject3_add = (JSONObject) jsonObject2.get(1);
		jsonObject3_add.put(globalVariables.ClientState, CommonMethods.getSaltString(3));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientState format is incorrect. The record should satisfy this regular expression");

	}

	//Case3- ClientAddress_ClientState validation with special chars(string)
	@Test(groups = {"All"})
	public void TC91184_AltEVV_CreateClient_with_valid_Max_ClientCity_length_with_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, 
	ConfigurationException, SQLException, ClassNotFoundException
	{   
		// logger = extent.startTest("TC91184_AltEVV_CreateClient_with_valid_Max_ClientCity_length");
		logger.log(LogStatus.INFO, "Validating ClientJson valid ClientAddress_ClientCity max length equals to 30 and type = string"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArraysub = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
		
		JSONObject jsonObject_sub1 = (JSONObject) jsonArraysub.get(0);
		jsonObject_sub1.put(globalVariables.ClientState, "MN");

		JSONObject jsonObject_sub = (JSONObject) jsonArraysub.get(1);
		jsonObject_sub.put(globalVariables.ClientState, "MN");

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	//Case4- ClientAddress_ClientState value as null
	@Test(groups = {"All"})
	public void TC91184_AltEVV_CreateClient_with_invalid_ClientState_as_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// logger = extent.startTest("TC91184_AltEVV_CreateClient_with_invalid_ClientState_as_null");
		logger.log(LogStatus.INFO, "Validating ClientJson valid ClientAddress_ClientState value =null"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray2 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
		JSONObject jsonObject3 = (JSONObject) jsonArray2.get(0);
		jsonObject3.put(globalVariables.ClientState, null);

		JSONObject jsonObject3_add = (JSONObject) jsonArray2.get(1);
		jsonObject3_add.put(globalVariables.ClientState, null);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientState cannot be null.");


	}

	//Case5- ClientAddress_ClientState value as "null"
	@Test(groups = {"All"})
	public void TC91184_AltEVV_CreateClient_with_invalid_ClientState_as_string_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// logger = extent.startTest("TC91184_AltEVV_CreateClient_with_invalid_ClientState_as_string_null");
		logger.log(LogStatus.INFO, "Validating ClientJson valid ClientAddress_ClientState as string null"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonObject2 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
		
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);
		jsonObject3.put(globalVariables.ClientState, null);

		JSONObject jsonObject3_add = (JSONObject) jsonObject2.get(1);
		jsonObject3_add.put(globalVariables.ClientState, null);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientState cannot be null.");


	}

	//Case6- ClientAddress_ClientState value as ""
	@Test(groups = {"All"})
	public void TC91184_AltEVV_CreateClient_with_invalid_ClientState_in_doublequotes() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// logger = extent.startTest("TC91184_AltEVV_CreateClient_with_invalid_ClientState_in_doublequotes");
		logger.log(LogStatus.INFO, "Validating ClientJson valid ClientAddress_ClientState as string null"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonObject2 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);

		jsonObject3.put(globalVariables.ClientState, "");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientState format is incorrect. The record should satisfy this regular expression");

	}

	//Case7- ClientAddress_ClientState value with Heading spaces
	@Test(groups = {"All"})
	public void TC91184_AltEVV_CreateClient_with_invalid_ClientState_with_Heading_spaces() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// logger = extent.startTest("TC91184_AltEVV_CreateClient_with_invalid_ClientState_with_Heading_spaces");
		logger.log(LogStatus.INFO, "Validating ClientJson with invalid ClientState with Heading_spaces"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonObject2 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);

		jsonObject3.put(globalVariables.ClientState, " F");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateFormatError);


	}

	//Case8- ClientAddress_ClientState value with Leading spaces
	@Test(groups = {"All"})
	public void TC91184_AltEVV_CreateClient_with_invalid_ClientState_with_Leading_spaces() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// logger = extent.startTest("TC91184_AltEVV_CreateClient_with_invalid_ClientState_with_Leading_spaces");
		logger.log(LogStatus.INFO, "Validating ClientJson with invalid ClientState with leading_spaces"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonObject2 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);

		jsonObject3.put(globalVariables.ClientState, "F ");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateFormatError);


	}

}

