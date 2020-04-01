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
import junit.framework.Assert;

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_5560_TC100259_OhioV2_Clientcreation_with_PatientAlternateID_validation extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void TC100259_OhioV2_Clientcreation_with_PatientAlternateID_Num() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC100259_OhioV2_Clientcreation_with_PatientAlternateID_Num");
		logger.log(LogStatus.INFO, "TC100259_OhioV2_Clientcreation_with_PatientAlternateID_Num"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PatientAlternateID", CommonMethods.generateRandomNumberOfFixLength(7));
		
		jsonObject.put("IsPatientNewborn", false);
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}
	
	@Test(groups = {"All"})
	public void TC100259_OhioV2_Clientcreation_with_PatientAlternateID_lengthinvalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC100259_OhioV2_Clientcreation_with_PatientAlternateID_invalid");
		logger.log(LogStatus.INFO, "TC100259_OhioV2_Clientcreation_with_PatientAlternateID_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PatientAlternateID", CommonMethods.generateRandomNumberOfFixLength(6));
		
		jsonObject.put("IsPatientNewborn", false);
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		Assert.assertTrue(bodyAsStringget.contains("\"messageSummary\": \"Records rejected, please review error and try again.\","));
		
	    Assert.assertTrue(bodyAsStringget.contains( "ERROR: The PatientAlternateID format is incorrect. It should be 7 digits only."));
	}
	
	@Test(groups = {"All"})
	public void TC100259_OhioV2_Clientcreation_with_PatientAlternateID_maxlength_exceeds() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC100259_OhioV2_Clientcreation_with_PatientAlternateID_maxlength_exceeds");
		logger.log(LogStatus.INFO, "TC100259_OhioV2_Clientcreation_with_PatientAlternateID_maxlength_exceeds"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PatientAlternateID", CommonMethods.generateRandomNumberOfFixLength(8));
		
		jsonObject.put("IsPatientNewborn", false);
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		Assert.assertTrue(bodyAsStringget.contains("\"messageSummary\": \"Records rejected, please review error and try again.\","));
		
	    Assert.assertTrue(bodyAsStringget.contains( "ERROR: The PatientAlternateID format is incorrect. It should be 7 digits only."));
	}

	@Test(groups = {"All"})
	public void TC100259_OhioV2_Clientcreation_with_PatientAlternateID_String() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC100259_OhioV2_Clientcreation_with_PatientAlternateID_maxlength_exceeds");
		logger.log(LogStatus.INFO, "TC100259_OhioV2_Clientcreation_with_PatientAlternateID_maxlength_exceeds"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PatientAlternateID", CommonMethods.generateRandomStringOfFixLength(7));
		
		jsonObject.put("IsPatientNewborn", false);
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		Assert.assertTrue(bodyAsStringget.contains("\"messageSummary\": \"Records rejected, please review error and try again.\","));
		
	    Assert.assertTrue(bodyAsStringget.contains( "ERROR: The PatientAlternateID format is incorrect. It should be 7 digits only."));
	}
}
