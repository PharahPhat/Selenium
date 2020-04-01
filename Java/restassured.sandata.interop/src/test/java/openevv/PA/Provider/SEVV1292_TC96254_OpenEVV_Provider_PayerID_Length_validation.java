package openevv.PA.Provider;

import Utills_ExtentReport_Log4j.BaseTest;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*; 

public class SEVV1292_TC96254_OpenEVV_Provider_PayerID_Length_validation extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96254_OpenEVV_Provider_PayerID_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96254_OpenEVV_Provider_PayerID_null");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("PayerID", null);

		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerIDnullError);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96254_OpenEVV_Provider_PayerID_exceeds_maxlength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96254_OpenEVV_Provider_PayerID_exceeds_maxlength");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("PayerID", CommonMethods.generateRandomNumberOfFixLength(65));

		String bodyAsString = CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerIDlengthError);
	}

	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96254_OpenEVV_Provider_PayerID_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96254_OpenEVV_Provider_PayerID_valid");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("PayerID", CommonMethods.generateRandomNumberOfFixLength(63));

		CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	}
	
}
