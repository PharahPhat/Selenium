package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV1292_TC96260_OpenEVV_Provider_AddressZip_validation extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96260_OpenEVV_Provider_AddressZip_Length_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96260_OpenEVV_Provider_AddressZip_Length_null");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("AddressZip", null);

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.AddressZipNullError);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96260_OpenEVV_Provider_AddressZip_Length_exceeds() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96260_OpenEVV_Provider_AddressZip_Length_exceeds");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("AddressZip", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.AddressZipformaterror);
	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96260_OpenEVV_Provider_AddressZip_Length_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96260_OpenEVV_Provider_AddressZip_Length_valid");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("AddressZip", CommonMethods.generateRandomNumberOfFixLength(9));

		CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
		
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96260_OpenEVV_Provider_AddressZip_Length_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96260_OpenEVV_Provider_AddressZip_Length_invalid");

	JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("AddressZip", CommonMethods.generateRandomAlphaNumeric(10));

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.AddressZipformaterror);
				
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96260_OpenEVV_Provider_AddressZip_Length_5char_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96260_OpenEVV_Provider_AddressZip_Length_5char_valid");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("AddressZip", "0000" +CommonMethods.generateRandomNumberOfFixLength(5));

		CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
		
	}

}
