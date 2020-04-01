/**
 * 
 */
package AltEVV_Molina.restassured.sandata.Client;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */

public class R2858_TC93138_AltEVV_ClientCustomID_Validations extends BaseTest

{
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	//Case-1 Testing with ClientCustomID: >24 characters 
	@Test(groups = {"All"})
	public void R2858_TC93138_AltEVV_CreateClient_with_ClientCustomID_more_than_24charslength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93138_AltEVV_CreateClient_with_ClientCustomID_more_than_24charslength");

		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientCustomID", CommonMethods.generateRandomAlphaNumeric(25));

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CLIENTCUSTOMIDERROR);
	}

	@Test(groups = {"All"})
	public void R2858_TC93138_AltEVV_CreateClient_with_valid_ClientCustomID_alphanum_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93138_AltEVV_CreateClient_with_valid_ClientCustomID_String_DB");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientCustomID", CommonMethods.generateRandomAlphaNumeric(10));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	@Test(groups = {"All"})
	public void R2858_TC93138_AltEVV_CreateClient_with_valid_ClientCustomID_num_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93138_AltEVV_CreateClient_with_valid_ClientCustomID_String_DB");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientCustomID", CommonMethods.generateRandomNumberOfFixLength(13));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	@Test(groups = {"All"})
	public void R2858_TC93138_AltEVV_CreateClient_with_valid_ClientCustomID_String_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93138_AltEVV_CreateClient_with_valid_ClientCustomID_String_DB");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientCustomID", CommonMethods.generateRandomStringOfFixLength(10));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}
}
