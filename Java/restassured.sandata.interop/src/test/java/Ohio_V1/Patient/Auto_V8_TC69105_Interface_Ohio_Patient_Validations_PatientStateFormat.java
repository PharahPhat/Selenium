package Ohio_V1.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.ohio.intake.patient.v1.DataGeneratorV1;
import com.ohio.intake.patient.v1.DbVerifier_OhioPatientV1;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Auto_V8_TC69105_Interface_Ohio_Patient_Validations_PatientStateFormat extends BaseTest
{
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private DbVerifier_OhioPatientV1 dbVerifier=new DbVerifier_OhioPatientV1();
	private Map<String, String> jsonField =new HashMap<>();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69105_Ohio_Patient_Validations_PatientStateFormat_valid() throws Exception
	{	
		
		// logger = extent.startTest(GlobalVariable_V1.PatientState_positveCase_69105);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientState_positveCase_69105);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue);
		jsonField.put(GlobalVariable_V1.PatientState, GlobalVariable_V1.NY);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69105_Ohio_Patient_Validations_PatientStateFormat_invalidotherthanCode() throws Exception
	{	
		String patientState=CommonMethods.generateRandomStringOfFixLength(2);
		
		// logger = extent.startTest(GlobalVariable_V1.PatientState_InvalidOtherThanCode_69105);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientState_InvalidOtherThanCode_69105);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue);
		jsonField.put(GlobalVariable_V1.PatientState, patientState);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_AddressSegment(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientState);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientState);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientAdd);


	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69105_Ohio_Patient_Validations_PatientStateFormat_invalidotherthanCodeNum() throws Exception
	{	
		String patientState=CommonMethods.generateRandomNumberOfFixLength(2);
		
		// logger = extent.startTest(GlobalVariable_V1.PatientState_InvalidOtherThanCodeNum_69105);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientState_InvalidOtherThanCodeNum_69105);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue);
		jsonField.put(GlobalVariable_V1.PatientState, patientState);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_AddressSegment(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientState);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientState);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientAdd);


	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69105_Ohio_Patient_Validations_PatientStateFormat_invalidotherthanCodeAlphaNum() throws Exception
	{	
		String patientState= "3A";
		
		// logger = extent.startTest(GlobalVariable_V1.PatientState_InvalidOtherThanCodeAlphaNum_69105);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientState_InvalidOtherThanCodeAlphaNum_69105);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue);
		jsonField.put(GlobalVariable_V1.PatientState, patientState);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_AddressSegment(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientState);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientState);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientAdd);


	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69105_Ohio_Patient_Validations_PatientStateFormat_invalidotherthanCodeDot() throws Exception
	{	
		String patientState=CommonMethods.generateRandomStringOfFixLength(1) + "." + CommonMethods.generateRandomStringOfFixLength(1);
		
		// logger = extent.startTest(GlobalVariable_V1.PatientState_InvalidOtherThanCodeDot_69105);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientState_InvalidOtherThanCodeDot_69105);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue);
		jsonField.put(GlobalVariable_V1.PatientState, patientState);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_AddressSegment(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientState);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientState);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientAdd);


	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69105_Ohio_Patient_Validations_PatientStateFormat_invalidotherthanCodeLessthan2() throws Exception
	{	
		String patientState=CommonMethods.generateRandomStringOfFixLength(1);
		
		// logger = extent.startTest(GlobalVariable_V1.PatientState_InvalidOtherThanCodeLessthan_69105);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientState_InvalidOtherThanCodeLessthan_69105);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue);
		jsonField.put(GlobalVariable_V1.PatientState, patientState);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_AddressSegment(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientState);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientState);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientAdd);


	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69105_Ohio_Patient_Validations_PatientStateFormat_invalidotherthanCodeGreaterthan2() throws Exception
	{	
		String patientState=CommonMethods.generateRandomStringOfFixLength(3);
		
		// logger = extent.startTest(GlobalVariable_V1.PatientState_InvalidOtherThanCodeGreaterthan_69105);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientState_InvalidOtherThanCodeGreaterthan_69105);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue);
		jsonField.put(GlobalVariable_V1.PatientState, patientState);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_AddressSegment(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientState);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientState);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientAdd);


	}
	
}
