/**
 * 
 */
package Ohio_V2.Patient;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_1556_Backwardcomp_TC96663_OhioV2_ClientGeneral_PatientOtherID_validation extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void TC96663_ohiov2_patientOtherID_Maxlength_validation() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96663_ohiov2_patientOtherID_validation");
		logger.log(LogStatus.INFO, "TC96663_ohiov2_patientOtherID_validation"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(64));
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
		
	}
	
	@Test(groups = {"All"})
	public void TC96663_ohio_patient_v2OtherID_with_validrecord() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96663_ohio_patientOtherID_with_validrecord");
		logger.log(LogStatus.INFO, "TC96663_ohio_patientOtherID_with_validrecord"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(10));
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
		
	}
	
	@Test(groups = {"All"})
	public void TC96663_ohio_patient_v2OtherID_length_exceeds_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96663_ohio_patientOtherID_length_exceeds_invalid");
		logger.log(LogStatus.INFO, "TC96663_ohio_patientOtherID_length_exceeds_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(65));
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientotherlengtherror);
		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientotherformaterror);
			
	}
	
	@Test(groups = {"All"})
	public void TC96663_ohio_patient_v2OtherID_NULL_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96663_ohio_patientOtherID_NULL_invalid");
		logger.log(LogStatus.INFO, "TC96663_ohio_patientOtherID_NULL_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PatientOtherID", "NULL");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		
	}

	@Test(groups = {"All"})
	public void TC96663_ohiov2_patientOtherID_Blank_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96663_ohio_patientOtherID_Blank_invalid");
		logger.log(LogStatus.INFO, "TC96663_ohio_patientOtherID_Blank_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PatientOtherID", "");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientotherlengtherror);
		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientotherformaterror);
	
	}
	@Test(groups = {"All"})
	public void TC96663_ohiov2_patientOtherID_Alphanumeric_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96663_ohio_patientOtherID_Alphanumeric_valid");
		logger.log(LogStatus.INFO, "TC96663_ohio_patientOtherID_Alphanumeric_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PatientOtherID", CommonMethods.generateRandomAlphaNumeric(8));
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
		
	}

}
