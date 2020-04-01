/**
 * 
 */
package Ohio_V2.Patient;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; 


public class SEVV_1556_TC96664_Client_GeneralInformation_PatientMedicaidID_format extends BaseTest { 
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void TC96663_ohio_patient_v2MedicaidID_Exceeds_Maxlength_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96663_ohio_patient_v2MedicaidID_validation");
		logger.log(LogStatus.INFO, "TC96663_ohio_patient_v2MedicaidID_validation"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(15));
		
		CommonMethods.captureResponseOhio_500(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		
		
	}
	
	@Test(groups = {"All"})
	public void TC96663_ohio_patient_v2MedicaidID_NULL_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96663_ohio_patient_v2MedicaidID_NULL_invalid");
		logger.log(LogStatus.INFO, "TC96663_ohio_patient_v2MedicaidID_NULL_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PatientMedicaidID", "NULL");
		
		CommonMethods.captureResponseOhio_500(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

				
	}

	@Test(groups = {"All"})
	public void TC96663_ohio_patient_v2MedicaidID_Alphanumeric_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96663_ohio_patient_v2MedicaidID_Alphanumeric_invalid");
		logger.log(LogStatus.INFO, "TC96663_ohio_patient_v2MedicaidID_Alphanumeric_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PatientMedicaidID", CommonMethods.generateRandomAlphaNumeric(8));
		
		CommonMethods.captureResponseOhio_500(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

	
	}
	
	@Test(groups = {"All"})
	public void TC96663_ohio_patient_v2MedicaidID_Maxlength_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96663_ohio_patient_v2MedicaidID_Maxlength_valid");
		logger.log(LogStatus.INFO, "TC96663_ohio_patient_v2MedicaidID_Maxlength_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
		
	}

}
