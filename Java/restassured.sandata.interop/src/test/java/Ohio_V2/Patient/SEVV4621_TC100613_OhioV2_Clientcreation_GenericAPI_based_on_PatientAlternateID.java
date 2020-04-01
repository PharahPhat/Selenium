package Ohio_V2.Patient;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV4621_TC100613_OhioV2_Clientcreation_GenericAPI_based_on_PatientAlternateID extends BaseTest{
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();
	@Test(groups = {"All" , "Regression"})
	public void TC100613_OhioV2_Clientcreation_GenericAPI_without_PatientAlternateID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC100613_OhioV2_Clientcreation_GenericAPI_without_PatientAlternateID");
		logger.log(LogStatus.INFO, "TC100613_OhioV2_Clientcreation_GenericAPI_without_PatientAlternateID"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_patient_v2"));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader("ohio_patient_get_v2"));

		jsonObject.remove("PatientAlternateID");
		
		String bodyAsStringnew = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_patient_v2"));

		String bodyAsStringgetnew=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringnew, CommonMethods.propertyfileReader("ohio_patient_get_v2"));

		//CommonMethods.Assert_Visit_FailCase(bodyAsStringgetnew, "Version number is duplicated or older than current");
		
		
	}
	
	@Test(groups = {"All"})
	public void TC100613_OhioV2_Clientcreation_GenericAPI_resend_PatientAlternateID_v2() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC100613_OhioV2_Clientcreation_GenericAPI_resend_PatientAlternateID_v2");
		logger.log(LogStatus.INFO, "TC100613_OhioV2_Clientcreation_GenericAPI_resend_PatientAlternateID_v2"); 
		
		String PatientAltID= CommonMethods.generateRandomNumberOfFixLength(7);
		
		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_patient_v2"));
		
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader("ohio_patient_get_v2"));
		
		jsonObject.put("PatientAlternateID", PatientAltID);
		
		String bodyAsStringnew = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_patient_v2"));

		String bodyAsStringgetnew=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsStringnew, CommonMethods.propertyfileReader("ohio_patient_get_v2"));

		CommonMethods.Assert_Visit_FailCase(bodyAsStringgetnew, "Version number is duplicated or older than current");
			
	}
	
//	@Test(groups = {"All"})
	public void TC100613_OhioV2_Clientcreation_GenericAPI_resend_PatientAlternateID_v1() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC100613_OhioV2_Clientcreation_GenericAPI_resend_PatientAlternateID_v1");
		logger.log(LogStatus.INFO, "TC100613_OhioV2_Clientcreation_GenericAPI_resend_PatientAlternateID_v1"); 
		
		String PatientAltID= CommonMethods.generateRandomNumberOfFixLength(7);
		
		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader("ohio_patient_v2"));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader("ohio_patient_get_v2"));
		
		jsonObject.put("PatientAlternateID", PatientAltID);
		
		String bodyAsStringnew = CommonMethods.captureResponseOhio_v1(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v1));

		CommonMethods.verifyjsonassertFailcase(bodyAsStringnew, "ERROR: The IndividualPayerInformation list cannot be null. The record is being rejected.");
			
	}


}
