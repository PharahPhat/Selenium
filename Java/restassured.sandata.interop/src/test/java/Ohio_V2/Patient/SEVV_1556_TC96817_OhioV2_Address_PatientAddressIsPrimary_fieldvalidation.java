/**
 * 
 */
package Ohio_V2.Patient;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_1556_TC96817_OhioV2_Address_PatientAddressIsPrimary_fieldvalidation extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	
	@Test(groups = {"All"})
	public void TC96817_OhioV2_Address_PatientAddressIsPrimary_field_true() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96817_OhioV2_Address_PatientAddressIsPrimary_field_true");
		logger.log(LogStatus.INFO, "TC96817_OhioV2_Address_PatientAddressIsPrimary_field_true"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayAddress = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectAddress =  (JSONObject) jsonArrayAddress.get(0);
		jsonObjectAddress.put("PatientAddressIsPrimary", "true");
		
		JSONObject jsonObjectAddress1 =  (JSONObject) jsonArrayAddress.get(1);
		jsonObjectAddress1.put("PatientAddressIsPrimary", "true");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
		
	}
	
	@Test(groups = {"All"})
	public void TC96817_OhioV2_Address_PatientAddressIsPrimary_field_true_false() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96817_OhioV2_Address_PatientAddressIsPrimary_field_true_false");
		logger.log(LogStatus.INFO, "TC96817_OhioV2_Address_PatientAddressIsPrimary_field_true_false"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayAddress = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectAddress =  (JSONObject) jsonArrayAddress.get(0);
		jsonObjectAddress.put("PatientAddressIsPrimary", "true");
		
		JSONObject jsonObjectAddress1 =  (JSONObject) jsonArrayAddress.get(1);
		jsonObjectAddress1.put("PatientAddressIsPrimary", "false");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
		
	}
	
	@Test(groups = {"All"})
	public void TC96817_OhioV2_Address_PatientAddressIsPrimary_field_false() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96817_OhioV2_Address_PatientAddressIsPrimary_field_false");
		logger.log(LogStatus.INFO, "TC96817_OhioV2_Address_PatientAddressIsPrimary_field_false"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayAddress = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectAddress =  (JSONObject) jsonArrayAddress.get(0);
		jsonObjectAddress.put("PatientAddressIsPrimary", "false");
		
		JSONObject jsonObjectAddress1 =  (JSONObject) jsonArrayAddress.get(1);
		jsonObjectAddress1.put("PatientAddressIsPrimary", "false");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
		
	}
}
