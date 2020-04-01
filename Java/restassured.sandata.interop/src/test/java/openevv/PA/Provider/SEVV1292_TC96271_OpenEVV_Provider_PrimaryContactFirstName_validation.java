package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV1292_TC96271_OpenEVV_Provider_PrimaryContactFirstName_validation extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96271_OpenEVV_Provider_PrimaryContactFirstName_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96271_OpenEVV_Provider_PrimaryContactFirstName_null");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("PrimaryContactFirstName", null);

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));
		//Based on new requirement this field is not mandatory.
		//CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PrimaryContactFirstNameNullError);
		assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsString, jsonObject);
	}
	//Based on requirement spec, OpenEVV-Provider1.9 PrimaryContactFirstName is not a mandatory field.Override with Lastname when passed Firstname=null
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96271_OpenEVV_Provider_PrimaryContactFirstName_exceeds_maxlength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96271_OpenEVV_Provider_PrimaryContactFirstName_exceeds_maxlength");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("PrimaryContactFirstName", CommonMethods.generateRandomStringOfFixLength(31));
		jsonObject.put("PrimaryContactLastName", CommonMethods.generateRandomStringOfFixLength(31));

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PrimaryContactLastNameLengthError);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96271_OpenEVV_Provider_PrimaryContactFirstName_Maxlength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96271_OpenEVV_Provider_PrimaryContactFirstName_Maxlength");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("PrimaryContactFirstName", CommonMethods.generateRandomStringOfFixLength(30));

		CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96271_OpenEVV_Provider_PrimaryContactFirstName_valid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96271_OpenEVV_Provider_PrimaryContactFirstName_valid_length");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("PrimaryContactFirstName", CommonMethods.generateRandomStringOfFixLength(15));

		CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	}
	
}