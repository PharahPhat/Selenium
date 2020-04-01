package openevv.PA.Authorization;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_2228_TC95404_Validate_ProviderID_field_for_Invalid extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void TC95404_Validate_ProviderID_field_for_Invalid_null() throws InterruptedException, java.text.ParseException, IOException, ParseException, ConfigurationException, SQLException, Exception {
		// // logger = extent.startTest("TC95404_Validate_ProviderID_field_for_Invalid_null");

		JSONArray jsonArray = GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ProviderID", null);


		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.provideridformatnullerror);


	}

	@Test(groups = {"All"})
	public void TC95404_Validate_ProviderID_field_for_Invalid_other_than_valid() throws InterruptedException, java.text.ParseException, IOException, ParseException, ConfigurationException, SQLException, Exception {
		// // logger = extent.startTest("TC95404_Validate_ProviderID_field_for_Invalid_other_than_valid");

		JSONArray jsonArray = GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ProviderID", CommonMethods.generateSpecialChar(8));


		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ProviderID format is incorrect.");


	}

	@Test(groups = {"All"})
	public void TC95404_Validate_ProviderID_field_for_Invalid_blank() throws InterruptedException, java.text.ParseException, IOException, ParseException, ConfigurationException, SQLException, Exception {
		// // logger = extent.startTest("TC95404_Validate_ProviderID_field_for_Invalid_blank");

		JSONArray jsonArray = GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ProviderID", "");


		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ProviderID format is incorrect.");

	}

	@Test(groups = {"All"})
	public void TC95404_Validate_ProviderID_field_for_Invalid_more_than_allowed_length() throws InterruptedException, java.text.ParseException, IOException, ParseException, ConfigurationException, SQLException, Exception {
		// // logger = extent.startTest("TC95404_Validate_ProviderID_field_for_Invalid_more_than_allowed_length");

		JSONArray jsonArray = GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ProviderID", CommonMethods.generateRandomStringOfFixLength(65));


		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ProviderID format is incorrect.");
	}
}
