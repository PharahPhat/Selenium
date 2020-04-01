package openevv.PA.Authorization;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;

import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_2228_TC95396_Validate_Shared_Authorization_with_different_AuthorizationStartDate extends BaseTest {

	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void TC95396_Validate_Shared_Authorization_with_different_AuthorizationStartDate() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{

		// // logger = extent.startTest("TC95396_Validate_Shared_Authorization_with_different_AuthorizationStartDate");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("AuthorizationStartDate", CommonMethods.generatePastDate_MMddYYYY_slash());
		jsonObject.put("AuthorizationEndDate", CommonMethods.generateTodayDate_MMddYYYY_slash());


		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));


		Thread.sleep(10000);

		jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("AuthorizationReferenceNumber", CommonMethods.generateRandomNumberOfFixLength(4));
		jsonObject.put("AuthorizationStartDate", CommonMethods.generatePastDate_MMddYYYY_slash());
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
	}

}
