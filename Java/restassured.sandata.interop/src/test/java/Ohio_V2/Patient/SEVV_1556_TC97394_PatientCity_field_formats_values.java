package Ohio_V2.Patient;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorClient;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_1556_TC97394_PatientCity_field_formats_values extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void TC97394_PatientCity_field_formats_values_valid_character() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97394_PatientCity_field_formats_values_valid_character");
		logger.log(LogStatus.INFO, "TC97394_PatientCity_field_formats_values_valid_character"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientCity", CommonMethods.generateRandomStringOfFixLength(20));
		
		JSONArray jsonArrPaynew = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew1 = (JSONObject) jsonArrPaynew.get(1);
		jsonObjectnew1.put("PatientCity", CommonMethods.generateRandomStringOfFixLength(20));
		
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}
	
	@Test(groups = {"All"})
	public void TC97394_PatientCity_field_formats_values_valid_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97394_PatientCity_field_formats_values_valid_alphanumeric");
		logger.log(LogStatus.INFO, "TC97394_PatientCity_field_formats_values_valid_alphanumeric"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientCity", CommonMethods.generateRandomAlphaNumeric(28));
		
		JSONArray jsonArrPaynew = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew1 = (JSONObject) jsonArrPaynew.get(1);
		jsonObjectnew1.put("PatientCity", CommonMethods.generateRandomAlphaNumeric(30));
		
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}
	
	@Test(groups = {"All"})
	public void TC97394_PatientCity_field_formats_values_valid_as_trimmed() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97394_PatientCity_field_formats_values_valid_as_trimmed");
		logger.log(LogStatus.INFO, "TC97394_PatientCity_field_formats_values_valid_as_trimmed"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientCity", CommonMethods.generateRandomStringOfFixLength(32));
		
		JSONArray jsonArrPaynew = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew1 = (JSONObject) jsonArrPaynew.get(1);
		jsonObjectnew1.put("PatientCity", CommonMethods.generateRandomStringOfFixLength(38));
		
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.truncatedrecorderror);
		//assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}

	@Test(groups = {"All"})
 	public void TC97394_PatientCity_field_formats_values_invalid_as_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97394_PatientCity_field_formats_values_invalid_as_null");
		logger.log(LogStatus.INFO, "TC97394_PatientCity_field_formats_values_invalid_as_null"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientCity", null);
		
		JSONArray jsonArrPaynew = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew1 = (JSONObject) jsonArrPaynew.get(1);
		jsonObjectnew1.put("PatientCity", null);
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.Patientcitynullrror);
	}
	
	
}
