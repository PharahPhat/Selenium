package Ohio_V1.Patient;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.ohio.intake.patient.v1.DataGeneratorV1;
import com.ohio.intake.patient.v1.DbVerifier_OhioPatientV1;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest; 

public class Auto_V8_TC64932_Interface_Ohio_Patient_Validations_PatientZipfieldformats_values extends BaseTest
{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	DbVerifier_OhioPatientV1 dbVerifier=new DbVerifier_OhioPatientV1();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64932_Ohio_Patient_Validations_PatientZipfieldformats_valid9() throws Exception
	{	
		Map<String, String> jsonField =new HashMap<>();

		String patientZip=CommonMethods.generateRandomNumberOfFixLength(9);
		
		// logger = extent.startTest(GlobalVariable_V1.PatientZip_positveCase_64932);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientZip_positveCase_64932);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientZip, patientZip);
		
		System.out.println(jsonField.get(GlobalVariable_V1.PatientZip));
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64932_Ohio_Patient_Validations_PatientZipfieldformats_valid10Space() throws Exception
	{	
		Map<String, String> jsonField =new HashMap<>();

		String patientZip=CommonMethods.generateRandomNumberOfFixLength(5) + "-"+ CommonMethods.generateRandomNumberOfFixLength(4);
		
		// logger = extent.startTest(GlobalVariable_V1.PatientZip_positveCaseSpace_64932);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientZip_positveCaseSpace_64932);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientZip, patientZip);
		
		System.out.println(jsonField.get(GlobalVariable_V1.PatientZip));
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64932_Ohio_Patient_Validations_PatientZipfieldformats_Invalid() throws Exception
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		String patientZip=CommonMethods.generateRandomNumberOfFixLength(8);
		
		// logger = extent.startTest(GlobalVariable_V1.PatientZip_negativeCase_64932);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientZip_negativeCase_64932);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientZip, patientZip);
		
		System.out.println(jsonField.get(GlobalVariable_V1.PatientZip));
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_AddressSegment(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientZip);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientZip);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64932_Ohio_Patient_Validations_PatientZipfieldformats_InvalidNum4() throws Exception
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		String patientZip=CommonMethods.generateRandomNumberOfFixLength(4);
		
		// logger = extent.startTest(GlobalVariable_V1.PatientZip_negativeCaseNum4_64932);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientZip_negativeCaseNum4_64932);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientZip, patientZip);
		
		System.out.println(jsonField.get(GlobalVariable_V1.PatientZip));
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_AddressSegment(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientZip);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientZip);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64932_Ohio_Patient_Validations_PatientZipfieldformats_InvalidAlphaNum8() throws Exception
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		String patientZip=CommonMethods.generateRandomAlphaNumeric(8);
		
		// logger = extent.startTest(GlobalVariable_V1.PatientZip_negativeCaseAlphaNum8_64932);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientZip_negativeCaseAlphaNum8_64932);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientZip, patientZip);
		
		System.out.println(jsonField.get(GlobalVariable_V1.PatientZip));
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_AddressSegment(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientZip);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientZip);

	}
		
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64932_Ohio_Patient_Validations_PatientZipfieldformats_InvalidAlphaNum10() throws Exception
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		String patientZip=CommonMethods.generateRandomAlphaNumeric(5) + "-" + CommonMethods.generateRandomAlphaNumeric(4);
		
		// logger = extent.startTest(GlobalVariable_V1.PatientZip_negativeCaseAlphaNum10_64932);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientZip_negativeCaseAlphaNum10_64932);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientZip, patientZip);
		
		System.out.println(jsonField.get(GlobalVariable_V1.PatientZip));
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_AddressSegment(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientZip);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientZip);

	}
	
}
