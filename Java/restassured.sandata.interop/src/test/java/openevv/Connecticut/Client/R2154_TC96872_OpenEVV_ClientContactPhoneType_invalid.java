package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Anupam
 */
//Test Case 96872: Open EVV Client- Validate the client Json for invalid case of ClientContactPhoneType (Refer the steps for scenario)
public class R2154_TC96872_OpenEVV_ClientContactPhoneType_invalid extends BaseTest { 
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96872_OpenEVV_ClientContactPhoneType_Numeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2154_TC96872_OpenEVV_ClientContactPhoneType_Numeric");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactPhoneType", CommonMethods.generateRandomNumberOfFixLength(13));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeformat);

	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96872_OpenEVV_ClientContactPhoneType_Alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2154_TC96872_OpenEVV_ClientContactPhoneType_Alphanumeric");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactPhoneType", CommonMethods.generateRandomAlphaNumeric(13));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeformat);

	}

	@Test(groups = {"All"})	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96872_OpenEVV_ClientContactPhoneType_NULL() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2154_TC96872_OpenEVV_ClientContactPhoneType_NULL");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactPhoneType", "NULL");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeformat);

	}
	
	@Test(groups = {"All"})	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96872_OpenEVV_ClientContactPhoneType_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2154_TC96872_OpenEVV_ClientContactPhoneType_specialchars");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactPhoneType", CommonMethods.generateSpecialChar(13));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeformat);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypelength);
	}

	@Test(groups = {"All"})	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96872_OpenEVV_ClientContactPhoneType_null_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2154_TC96872_OpenEVV_ClientContactPhoneType_null_invalid");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactPhoneType", "null");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeformat);

	}

	@Test(groups = {"All"})	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96872_OpenEVV_ClientContactPhoneType_otherthan_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2154_TC96872_OpenEVV_ClientContactPhoneType_otherthan_valid");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactPhoneType", "Homee");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeformat);

	}

	@Test(groups = {"All"})	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96872_OpenEVV_ClientContactPhoneType_with_spaceinvalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2154_TC96872_OpenEVV_ClientContactPhoneType_with_spaceinvalid");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactPhoneType", "Hom ee");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhoneTypeformat);

	}

}