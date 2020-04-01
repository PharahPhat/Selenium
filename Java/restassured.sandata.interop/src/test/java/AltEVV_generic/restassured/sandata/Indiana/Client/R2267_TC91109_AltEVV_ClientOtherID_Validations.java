package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
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
public class R2267_TC91109_AltEVV_ClientOtherID_Validations extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();

	@Test(groups = {"All", "fixing"})
	public void TC91109_AltEVV_CreateClient_with_invalid_ClientOtherID_more_than_24chars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, ClassNotFoundException, SQLException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC91109_AltEVV_CreateClient_with_invalid_ClientOtherID_more_than_24chars");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientOtherID", CommonMethods.generateRandomAlphaNumeric(25));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		assertionDbVerifier.verifyInboxClient_AltEVVGenreic(jsonObject);
	}

	@Test(groups = {"All", "fixing"})
	public void TC91109_AltEVV_CreateClient_with_valid_ClientOtherID_String_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC91109_AltEVV_CreateClient_with_valid_ClientOtherID_String_DB");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientOtherID", CommonMethods.getSaltString(10));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		assertionDbVerifier.verifyInboxClient_AltEVVGenreic(jsonObject);
	}

	@Test(groups = {"All", "fixing"})
	public void TC91109_AltEVV_CreateClient_with_valid_ClientOtherID_alpha_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC91109_AltEVV_CreateClient_with_valid_ClientOtherID_String_DB");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientOtherID", CommonMethods.generateRandomNumberOfFixLength(20));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		assertionDbVerifier.verifyInboxClient_AltEVVGenreic(jsonObject);
	}

	@Test(groups = {"All", "fixing"})
	public void TC91109_AltEVV_CreateClient_with_valid_ClientOtherID_alphanum_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC91109_AltEVV_CreateClient_with_valid_ClientOtherID_String_DB");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientOtherID", CommonMethods.generateRandomAlphaNumeric(24));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		assertionDbVerifier.verifyInboxClient_AltEVVGenreic(jsonObject);
	}
}
