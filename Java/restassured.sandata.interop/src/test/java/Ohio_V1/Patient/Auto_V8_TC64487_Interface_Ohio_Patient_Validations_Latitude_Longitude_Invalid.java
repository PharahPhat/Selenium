package Ohio_V1.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.GenerateUniqueParam;
import com.ohio.intake.patient.v1.DataGeneratorV1;
import com.ohio.intake.patient.v1.DbVerifier_OhioPatientV1;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Auto_V8_TC64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_Invalid extends BaseTest
{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	DbVerifier_OhioPatientV1 dbVerifier=new DbVerifier_OhioPatientV1();
	Map<String, String> jsonField =new HashMap<String,String>();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_ValidPOsitive() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_ValidPOsitive");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_ValidPOsitive");
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLatitude, String.valueOf(dataGenerator.generateRandomIntegerInRange(0, 90)));
		jsonField.put(GlobalVariable_V1.PatientLongitude, String.valueOf(dataGenerator.generateRandomIntegerInRange(0, 180)));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_ValidDifferent() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_ValidDifferent");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_ValidDifferent");
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLatitude, "0");
		jsonField.put(GlobalVariable_V1.PatientLongitude, String.valueOf(dataGenerator.generateRandomIntegerInRange(0, 180)));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_DifferentValid() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_DifferentValid");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_DifferentValid");
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLatitude, String.valueOf(dataGenerator.generateRandomIntegerInRange(0, 90)));
		jsonField.put(GlobalVariable_V1.PatientLongitude, "0");

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_Valid_Null() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_Valid_Null");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_Valid_Null");
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLatitude, null);
		jsonField.put(GlobalVariable_V1.PatientLongitude, null);

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_Valid_Zero() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_Valid_Zero");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_Valid_Zero");
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLatitude, "0");
		jsonField.put(GlobalVariable_V1.PatientLongitude, "0");

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_InvalidNegative() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_InvalidNegative");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_InvalidNegative");
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLatitude, "-91");
		jsonField.put(GlobalVariable_V1.PatientLongitude, "-181");

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_AddressSegment(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientLatitude);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.patientLatitudeLowerLengthError);
	
		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientLongitude);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.patientLongitudeLowerLengthError);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_InvalidPositive() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_InvalidPositive");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_InvalidPositive");
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLatitude, "91");
		jsonField.put(GlobalVariable_V1.PatientLongitude, "181");

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_AddressSegment(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientLatitude);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.patientLatitudeGreaterLengthError);
	
		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientLongitude);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.patientLongitudeGreaterLengthError);

	}
}

