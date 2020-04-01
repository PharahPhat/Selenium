/**
 * 
 */
package AltEVV_Molina.restassured.sandata.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
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
// Test Case 91109: OpenEVV-altEVV- Client: Validate (mix) - ClientOtherID field formats/values

public class R2858_TC93135_AltEVV_ClientOtherID_Validations extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void R2858_TC93135_AltEVV_CreateClient_with_invalid_ClientOtherID_more_than_24chars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93135_AltEVV_CreateClient_with_invalid_ClientOtherID_more_than_24chars");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientOtherID", CommonMethods.generateRandomAlphaNumeric(25));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientOtherID value is incorrect. The length should be between 1 and 24.");
	}

	@Test(groups = {"All"})
	public void R2858_TC93135_AltEVV_CreateClient_with_valid_ClientOtherID_String_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93135_AltEVV_CreateClient_with_valid_ClientOtherID_String_DB");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientOtherID", CommonMethods.getSaltString(10));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	@Test(groups = {"All"})
	public void R2858_TC93135_AltEVV_CreateClient_with_valid_ClientOtherID_alpha_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93135_AltEVV_CreateClient_with_valid_ClientOtherID_String_DB");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientOtherID", CommonMethods.generateRandomNumberOfFixLength(20));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	@Test(groups = {"All"})
	public void R2858_TC93135_AltEVV_CreateClient_with_valid_ClientOtherID_alphanum_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93135_AltEVV_CreateClient_with_valid_ClientOtherID_String_DB");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientOtherID", CommonMethods.generateRandomAlphaNumeric(24));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}
}
