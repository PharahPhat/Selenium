package Ohio_V1.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.ohio.intake.patient.v1.DataGeneratorV1;
import com.ohio.intake.patient.v1.DbVerifier_OhioPatientV1;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Auto_V8_TC69046_Interface_Ohio_Patient_Validations_PatientLastName_values extends BaseTest
{
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private DbVerifier_OhioPatientV1 dbVerifier=new DbVerifier_OhioPatientV1();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_Valid() throws Exception
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_Valid");
		logger.log(LogStatus.INFO, "Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_Valid");
			
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLastName, CommonMethods.generateRandomStringOfFixLength(30));
	
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_invalidGreaterValue() throws Exception
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_Valid");
		logger.log(LogStatus.INFO, "Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_Valid");
			
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLastName, CommonMethods.generateRandomStringOfFixLength(31));
	
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(),
				GlobalVariable_V1.ValueNotMeetValidationPattern);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_InvalidSpecialChar() throws Exception
	{	
		Map<String, String> jsonField =new HashMap<String,String>();
		
		// logger = extent.startTest("Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_InvalidSpecialChar");
		logger.log(LogStatus.INFO, "Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_InvalidSpecialChar");
			
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLastName, CommonMethods.generateSpecialChar(30));
	
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientLastName);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientLastNameLengthError);


	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_InvalidMixAlphaNum() throws Exception
	{	
		
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_InvalidMixAlphaNum");
		logger.log(LogStatus.INFO, "Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_InvalidMixAlphaNum");
			
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLastName, CommonMethods.generateRandomAlphaNumeric(30));
	
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientLastName);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientLastNameLengthError);


	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_InvalidStartingAlphaNum() throws Exception
	{	
		
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_InvalidStartingAlphaNum");
		logger.log(LogStatus.INFO, "Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_InvalidStartingAlphaNum");
			
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLastName, CommonMethods.generateRandomNumberOfFixLength(5)+CommonMethods.generateRandomStringOfFixLength(10));
	
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientLastName);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientLastNameLengthError);


	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_InvalidEndingAlphaNum() throws Exception
	{	
		Map<String, String> jsonField =new HashMap<String,String>();
		
		// logger = extent.startTest("Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_InvalidEndingAlphaNum");
		logger.log(LogStatus.INFO, "Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientLastName_values_InvalidEndingAlphaNum");
			
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLastName, CommonMethods.generateRandomStringOfFixLength(10) + CommonMethods.generateRandomNumberOfFixLength(5));
	
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientLastName);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientLastNameLengthError);


	}
}
