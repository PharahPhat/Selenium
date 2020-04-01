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

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_1556_TC97393_PatientAddressLine2_field_formats_values extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	
	@Test(groups = {"All"})
	public void SEVV_1556_TC97393_PatientAddressLine2_field_formats_values_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("SEVV_1556_TC97393_PatientAddressLine2_field_formats_values_valid");
		logger.log(LogStatus.INFO, "SEVV_1556_TC97393_PatientAddressLine2_field_formats_values_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientAddressLine2", CommonMethods.generateRandomStringOfFixLength(30));
		
		JSONArray jsonArrPaynew = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew1 = (JSONObject) jsonArrPaynew.get(1);
		jsonObjectnew1.put("PatientAddressLine2", CommonMethods.generateRandomStringOfFixLength(29));
		
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}
	
	@Test(groups = {"All"})
	public void SEVV_1556_TC97393_PatientAddressLine2_field_formats_values_valid_with_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("SEVV_1556_TC97393_PatientAddressLine2_field_formats_values_valid_with_space");
		logger.log(LogStatus.INFO, "SEVV_1556_TC97393_PatientAddressLine2_field_formats_values_valid_with_space"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientAddressLine2", CommonMethods.generateRandomStringOfFixLength(10)+"  "+ CommonMethods.generateRandomStringOfFixLength(10));
		
		JSONArray jsonArrPaynew = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew1 = (JSONObject) jsonArrPaynew.get(1);
		jsonObjectnew1.put("PatientAddressLine2", CommonMethods.generateRandomStringOfFixLength(29));
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}
	
	@Test(groups = {"All"})
 	public void SEVV_1556_TC97393_PatientAddressLine2_field_formats_values_truncated() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("SEVV_1556_TC97393_PatientAddressLine2_field_formats_values_truncated");
		logger.log(LogStatus.INFO, "SEVV_1556_TC97393_PatientAddressLine2_field_formats_values_truncated"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientAddressLine2", CommonMethods.generateRandomStringOfFixLength(38));
		
		JSONArray jsonArrPaynew = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew1 = (JSONObject) jsonArrPaynew.get(1);
		jsonObjectnew1.put("PatientAddressLine2", CommonMethods.generateRandomStringOfFixLength(36));
		
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
		
		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.PatientAddressLine2formaterror);
	
		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.PatientAddressLine2lengtherror);
	}
	
	@Test(groups = {"All"})
 	public void SEVV_1556_TC97393_PatientAddressLine2_field_formats_values_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("SEVV_1556_TC97393_PatientAddressLine2_field_formats_values_null");
		logger.log(LogStatus.INFO, "SEVV_1556_TC97393_PatientAddressLine2_field_formats_values_null"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientAddressLine2", "NULL");
		
		JSONArray jsonArrPaynew = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew1 = (JSONObject) jsonArrPaynew.get(1);
		jsonObjectnew1.put("PatientAddressLine2", "NULL");
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
		
	}

	
	@Test(groups = {"All"})
 	public void SEVV_1556_TC97393_PatientAddressLine2_field_formats_values_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("SEVV_1556_TC97393_PatientAddressLine2_field_formats_values_blank");
		logger.log(LogStatus.INFO, "SEVV_1556_TC97393_PatientAddressLine2_field_formats_values_blank"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		

		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientAddressLine2", "");
		
		JSONArray jsonArrPaynew = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew1 = (JSONObject) jsonArrPaynew.get(1);
		jsonObjectnew1.put("PatientAddressLine2", "");
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringget, globalVariables.PatientAddressLine2formaterror);
	}
	
	

}
