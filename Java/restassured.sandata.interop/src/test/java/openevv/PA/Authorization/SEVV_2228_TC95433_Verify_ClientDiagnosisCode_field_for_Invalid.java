package openevv.PA.Authorization;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.ohio.intake.patient.v1.DataGeneratorV1;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; 

public class SEVV_2228_TC95433_Verify_ClientDiagnosisCode_field_for_Invalid extends BaseTest {

	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	DataGeneratorV1 dataGenerator=new DataGeneratorV1();

	@Test(groups = {"All", "Regression", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95433_Verify_ClientDiagnosisCode_field_for_Invalid_value() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception {

		// // logger = extent.startTest("TC95433_Verify_ClientDiagnosisCode_field_for_Invalid_value");

		JSONArray jsonArray = GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObjectAuthorizationLimit = dataGenerator.subArrayCreation(jsonObject, "AuthorizationLimit", 0);
		jsonObjectAuthorizationLimit.put("AuthorizationLimitDayOfWeek", "Mon");

		JSONObject jsonObjectDiagnosisCode = dataGenerator.subArrayCreation(jsonObject, "DiagnosisCode", 0);

		jsonObjectDiagnosisCode.put("ClientDiagnosisCode", CommonMethods.generateRandomAlphaNumeric(4));


		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));

		String BodyAsStringGet = CommonMethods.captureResponseAuthrizationGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openEVV_auth_get));
		CommonMethods.verifyjsonassertFailcase(BodyAsStringGet, "");
	}

	@Test(groups = {"All"})
	public void TC95433_Verify_ClientDiagnosisCode_field_for_Invalid_value_morethan_allowed_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95433_Verify_ClientDiagnosisCode_field_for_Invalid_value_morethan_allowed_length");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONObject jsonObjectAuthorizationLimit=dataGenerator.subArrayCreation(jsonObject,"AuthorizationLimit", 0);
		jsonObjectAuthorizationLimit.put("AuthorizationLimitDayOfWeek", "Mon");
		
		JSONObject jsonObjectDiagnosisCode=dataGenerator.subArrayCreation(jsonObject,"DiagnosisCode", 0);
		jsonObjectDiagnosisCode.put("ClientDiagnosisCode", CommonMethods.generateRandomStringOfFixLength(11));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientDiagnosisCodeformaterror);

	}

	@Test(groups = {"All"})
	public void TC95433_Verify_ClientDiagnosisCode_field_for_valid_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// // logger = extent.startTest("TC95433_Verify_ClientDiagnosisCode_field_for_valid_null");

		JSONArray jsonArray=GenerateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONObject jsonObjectAuthorizationLimit=dataGenerator.subArrayCreation(jsonObject,"AuthorizationLimit", 0);
		jsonObjectAuthorizationLimit.put("AuthorizationLimitDayOfWeek", "Mon");
		
		JSONObject jsonObjectDiagnosisCode=dataGenerator.subArrayCreation(jsonObject,"DiagnosisCode", 0);

		jsonObjectDiagnosisCode.put("ClientDiagnosisCode", null);		

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openEVV_auth));



	}


}
