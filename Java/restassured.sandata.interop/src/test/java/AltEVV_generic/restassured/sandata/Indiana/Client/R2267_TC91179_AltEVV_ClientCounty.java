package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author MayankM
 */
//Test Case 91175:Open EVV- altEVV- Client- Validate (mix) - ClientCounty field formats/values

public class R2267_TC91179_AltEVV_ClientCounty extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//validating  altEVV client having ClientCounty with 25 char
	@Test(groups = {"All", "fixing"})
	public void R2267_TC91179_AltEVV_ClientCounty_valid_with_25char_asstring() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91179_AltEVV_ClientCounty_valid_with_30char_asstring");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientAddress");
	
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientCounty", CommonMethods.getSaltString(25));

		JSONObject jsonObject1_add = (JSONObject) jsonArray1.get(1);
		jsonObject1_add.put("ClientCounty", CommonMethods.getSaltString(25));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		assertionDbVerifier.verifyInboxClientAddress_ALtEVVGeneric(jsonObject, jsonObject1_add);
	}

	//validating  altEVV client having ClientCounty length more than 25 char 
	@Test(groups = {"All", "fixing"})
	public void R2267_TC91179_AltEVV_ClientCounty_invalid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ClassNotFoundException, SQLException
	{
		// logger = extent.startTest("R2267_TC91179_AltEVV_ClientCounty_invalid_length");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientAddress");
		
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientCounty", CommonMethods.getSaltString(26));

		JSONObject jsonObject1_add = (JSONObject) jsonArray1.get(1);
		jsonObject1_add.put("ClientCounty", CommonMethods.getSaltString(26));
		
		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		assertionDbVerifier.verifyInboxClientAddress_ALtEVVGeneric(jsonObject, jsonObject1_add);
	}

	//validating  altEVV client having ClientCounty with numeric
	@Test(groups = {"All"})
	public void R2267_TC91179_AltEVV_ClientCounty_invalid_numeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91179_AltEVV_ClientCounty_numeric");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientAddress");
		
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientCounty", CommonMethods.generateRandomNumberOfFixLength(15));

		JSONObject jsonObject1_add = (JSONObject) jsonArray1.get(1);
		jsonObject1_add.put("ClientCounty", CommonMethods.generateRandomNumberOfFixLength(15));
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCountyFormatError);


	}

	//validating  altEVV client having ClientCounty with alphanumeric
	@Test(groups = {"All"})
	public void R2267_TC91179_AltEVV_ClientCounty_invalid_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91179_AltEVV_ClientCounty_alphanumeric");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientCounty", CommonMethods.generateRandomAlphaNumeric(8));

		JSONObject jsonObject1_add = (JSONObject) jsonArray1.get(1);
		jsonObject1_add.put("ClientCounty", CommonMethods.generateRandomAlphaNumeric(8));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCountyFormatError);


	}

	//validating  altEVV client having ClientCounty with special char
	@Test(groups = {"All"})
	public void R2267_TC91179_AltEVV_ClientCounty_spcl_char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2267_TC91179_AltEVV_ClientCounty_spcl_char");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put("ClientCounty", CommonMethods.generateSpecialChar(5));

		JSONObject jsonObject1_add = (JSONObject) jsonArray1.get(1);
		jsonObject1_add.put("ClientCounty", CommonMethods.generateSpecialChar(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientCounty format is incorrect. The record should satisfy this regular expression");

	}

}

