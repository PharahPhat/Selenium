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
 *
 */
public class R2267_TC91108_AltEVV_ClientCustomID_Validations extends BaseTest 
{
	private GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();
	
	//Case-1 Testing with ClientCustomID: >24 characters 
	@Test(groups = {"All", "fixing"})
	public void TC91108_AltEVV_CreateClient_with_ClientCustomID_more_than_24charslength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, ClassNotFoundException, SQLException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC91108_AltEVV_CreateClient_with_ClientCustomID_more_than_24charslength");

		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientCustomID", CommonMethods.generateRandomAlphaNumeric(25));

		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		assertionDbVerifier.verifyInboxClient_AltEVVGenreic(js);
	}

	@Test(groups = {"All"})
	public void TC91108_AltEVV_CreateClient_with_valid_ClientCustomID_alphanum_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC91108_AltEVV_CreateClient_with_valid_ClientCustomID_String_DB");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientCustomID", CommonMethods.generateRandomAlphaNumeric(10));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	}

	@Test(groups = {"All"})
	public void TC91108_AltEVV_CreateClient_with_valid_ClientCustomID_num_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC91108_AltEVV_CreateClient_with_valid_ClientCustomID_String_DB");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientCustomID", CommonMethods.generateRandomNumberOfFixLength(13));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	}

	@Test(groups = {"All"})
	public void TC91108_AltEVV_CreateClient_with_valid_ClientCustomID_String_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC91108_AltEVV_CreateClient_with_valid_ClientCustomID_String_DB");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientCustomID", CommonMethods.generateRandomStringOfFixLength(10));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	}
}
