/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Client;

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

public class R2267_TC91182_AltEVV_ClientAddress_ClientCity_validations extends BaseTest { 
	private GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();

	//Case1- ClientAddress_ClientCity max length should be less than or equals to 30 and type = string 
	@Test(groups = {"All", "fixing"})
	public void TC91182_AltEVV_CreateClient_with_valid_ClientCity() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// logger = extent.startTest("TC91182_AltEVV_CreateClient_with_valid_ClientCity");
		logger.log(LogStatus.INFO, "Validating ClientJson valid ClientCity should be less than or equals to 30 and type = string"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray_sub = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	

		JSONObject jsonObject3 = (JSONObject) jsonArray_sub.get(0);
		jsonObject3.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(30));

		JSONObject jsonObject3_add = (JSONObject) jsonArray_sub.get(1);
		jsonObject3_add.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(30));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		assertionDbVerifier.verifyInboxClientAddress_ALtEVVGeneric(jsonObject, jsonObject3_add);
	}

	//Case2- ClientAddress_ClientCity more than 30 length 
	@Test(groups = {"All", "fixing"})
	public void TC91182_AltEVV_CreateClient_with_invalid_ClientCity_with_more_than_30length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, ClassNotFoundException, SQLException
	{   
		// logger = extent.startTest("TC91182_AltEVV_CreateClient_with_valid_ClientCity");
		logger.log(LogStatus.INFO, "Validating ClientJson valid ClientCity should be less than or equals to 30 and type = string"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray_sub = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	

		JSONObject jsonObject3_add = (JSONObject) jsonArray_sub.get(1);
		jsonObject3_add.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(31));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		assertionDbVerifier.verifyInboxClientAddress_ALtEVVGeneric(jsonObject, jsonObject3_add);
	}

	//Case6- ClientAddress_ClientCity value null 
	@Test(groups = {"All"})
	public void TC91182_AltEVV_CreateClient_with_invalid_ClientCity_Null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// logger = extent.startTest("TC91182_AltEVV_CreateClient_with_invalid_ClientCity_Null");
		logger.log(LogStatus.INFO, "Validating ClientJson invalid ClientCity value null"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonObject2 = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);
		jsonObject3.put(globalVariables.ClientCity, null);

		JSONObject jsonObject3_add = (JSONObject) jsonObject2.get(1);
		jsonObject3_add.put(globalVariables.ClientCity, null);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCity_nullerror);
	}
}

