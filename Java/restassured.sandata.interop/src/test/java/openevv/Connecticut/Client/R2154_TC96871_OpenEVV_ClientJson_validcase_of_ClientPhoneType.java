/**
 * 
 */
package openevv.Connecticut.Client;
import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2154_TC96871_OpenEVV_ClientJson_validcase_of_ClientPhoneType extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96871_OpenEVV_ClientPhoneType_validvalues_Home() throws InterruptedException,IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException{

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientPhoneType", "Home");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		Assert.assertTrue(bodyAsStringGet.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsStringGet.contains("\"reason\": \"Transaction Received.\","));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96871_OpenEVV_ClientPhoneType_validvalues_Mobile() throws InterruptedException, IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientPhoneType", "Mobile");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96871_OpenEVV_ClientPhoneType_validvalues_Work() throws InterruptedException, IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientPhoneType", "Work");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96871_OpenEVV_ClientPhoneType_validvalues_Other() throws InterruptedException, IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientPhoneType", "Other");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject);

	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96871_OpenEVV_ClientPhoneType_validvalues_Fax() throws InterruptedException,IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientPhoneType", "Fax");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96871_OpenEVV_ClientPhoneType_validvalues_optional() throws InterruptedException, IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientPhoneType", "");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject);

	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96871_OpenEVV_ClientPhoneType_maxlength_randomvalue() throws InterruptedException, IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientPhoneType", CommonMethods.generateRandomAlphaNumeric(12));
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96871_OpenEVV_ClientPhoneType_validvalues_with_trailingspaces() throws InterruptedException, IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientPhoneType", " Home");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96871_OpenEVV_ClientPhoneType_validvalues_with_leadingspaces() throws InterruptedException, IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException{

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientPhoneType", "Mobile ");	
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject);
	}
}
