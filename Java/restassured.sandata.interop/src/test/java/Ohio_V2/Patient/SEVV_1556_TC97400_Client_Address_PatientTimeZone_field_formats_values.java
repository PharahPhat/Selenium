package Ohio_V2.Patient;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_1556_TC97400_Client_Address_PatientTimeZone_field_formats_values extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	

	@Test(groups = {"All"})
	public void TC97400_Client_Address_PatientTimeZone_field_formats_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97400_Client_Address_PatientTimeZone_field_formats_valid");
		logger.log(LogStatus.INFO, "TC97400_Client_Address_PatientTimeZone_field_formats_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientTimezone", "US/Eastern");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}
	

	@Test(groups = {"All"})
 	public void TC97400_Client_Address_PatientTimeZone_field_formats_morethan_allowed_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97400_Client_Address_PatientTimeZone_field_formats_morethan_allowed_length");
		logger.log(LogStatus.INFO, "TC97400_Client_Address_PatientTimeZone_field_formats_morethan_allowed_length"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientTimezone", CommonMethods.generateRandomStringOfFixLength(33));
		
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.PatientTimeZoneformaterror);
	}
	
	@Test(groups = {"All"})
 	public void TC97400_Client_Address_PatientTimeZone_field_formats_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97400_Client_Address_PatientTimeZone_field_formats_null");
		logger.log(LogStatus.INFO, "TC97400_Client_Address_PatientTimeZone_field_formats_null"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientTimezone", null);
		
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}
	
	@Test(groups = {"All"})
 	public void TC97400_Client_Address_PatientTimeZone_field_formats_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97400_Client_Address_PatientTimeZone_field_formats_blank");
		logger.log(LogStatus.INFO, "TC97400_Client_Address_PatientTimeZone_field_formats_blank"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientTimezone", "");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.PatientTimeZoneformaterror);
	}
	
	@Test(groups = {"All"})
 	public void TC97400_Client_Address_PatientTimeZone_field_formats_NULL() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97400_Client_Address_PatientTimeZone_field_formats_NULL");
		logger.log(LogStatus.INFO, "TC97400_Client_Address_PatientTimeZone_field_formats_NULL"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientTimezone", "NULL");
		
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.PatientTimeZoneformaterror);
	}
}
