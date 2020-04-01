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

/**
 * @author Anupam
 *
 */
import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_1556_TC96816_AltEVV_Address_PatientAddressType_format extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void TC96816_AltEVV_Address_PatientAddressType() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96816_AltEVV_Address_PatientAddressType");
		logger.log(LogStatus.INFO, "TC96816_AltEVV_Address_PatientAddressType"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayAddress = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectAddress =  (JSONObject) jsonArrayAddress.get(0);
		jsonObjectAddress.put("PatientAddressType", "Home");
		
		JSONObject jsonObjectAddress1 =  (JSONObject) jsonArrayAddress.get(1);
		jsonObjectAddress1.put("PatientAddressType", "School");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}
	
	@Test(groups = {"All"})
	public void TC96816_AltEVV_Address_PatientAddressType_validvalues() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96816_AltEVV_Address_PatientAddressType_valid");
		logger.log(LogStatus.INFO, "TC96816_AltEVV_Address_PatientAddressType_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayAddress = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectAddress =  (JSONObject) jsonArrayAddress.get(0);
		jsonObjectAddress.put("PatientAddressType", "Business");
		
		JSONObject jsonObjectAddress1 =  (JSONObject) jsonArrayAddress.get(1);
		jsonObjectAddress1.put("PatientAddressType", "Other");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}

	@Test(groups = {"All"})
	public void TC96816_AltEVV_Address_PatientAddressType_invalidvalues() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96816_AltEVV_Address_PatientAddressType_invalid");
		logger.log(LogStatus.INFO, "TC96816_AltEVV_Address_PatientAddressType_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayAddress = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectAddress =  (JSONObject) jsonArrayAddress.get(0);
		jsonObjectAddress.put("PatientAddressType", "NULL");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientAddressTypeerror);
	
	}

	
	@Test(groups = {"All"})
	public void TC96816_AltEVV_Address_PatientAddressType_invalidformat() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96816_AltEVV_Address_PatientAddressType_invalidformat");
		logger.log(LogStatus.INFO, "TC96816_AltEVV_Address_PatientAddressType_invalidformat"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayAddress = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectAddress =  (JSONObject) jsonArrayAddress.get(0);
		jsonObjectAddress.put("PatientAddressType", "Testcode");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientAddressTypeerror);
	
	}
	
	@Test(groups = {"All"})
	public void TC96816_AltEVV_Address_PatientAddressType_invalidblank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96816_AltEVV_Address_PatientAddressType_invalidblank");
		logger.log(LogStatus.INFO, "TC96816_AltEVV_Address_PatientAddressType_invalidblank"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayAddress = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectAddress =  (JSONObject) jsonArrayAddress.get(0);
		jsonObjectAddress.put("PatientAddressType", "");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.patientAddressTypeerror);
	
	}
	
}
