package openevv.PA.Provider;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier;

public class SEVV1292_TC96258_OpenEVV_Provider_AddressCity_validation extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96258_OpenEVV_Provider_AddressCity_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96258_OpenEVV_Provider_AddressCity_null");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("AddressCity", null);

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.AddressCityNullError);
	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96258_OpenEVV_Provider_AddressCity_length_exceeds() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96258_OpenEVV_Provider_AddressCity_length_exceeds");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("AddressCity", CommonMethods.generateRandomStringOfFixLength(31));

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.AddresscitylengthError);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96258_OpenEVV_Provider_AddressCity_length_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96258_OpenEVV_Provider_AddressCity_length_valid");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("AddressCity", CommonMethods.generateRandomStringOfFixLength(30));

		CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96258_OpenEVV_Provider_AddressCity_validlength_less_than_30char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96258_OpenEVV_Provider_AddressCity_length_less_than_30char_valid");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("AddressCity", CommonMethods.generateRandomStringOfFixLength(20));
		
		CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
}
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96258_OpenEVV_Provider_AddressCity_integer() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96258_OpenEVV_Provider_AddressCity_integer");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("AddressCity", CommonMethods.generateRandomNumberOfFixLength(10));
		
		CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
}

}
