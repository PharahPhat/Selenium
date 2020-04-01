package Ohio_V1.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.ohio.intake.patient.v1.DataGeneratorV1;
import com.ohio.intake.patient.v1.DbVerifier_OhioPatientV1;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Auto_V8_TC64487_Interface_Ohio_Patient_Validations_Latitude_Longitude extends BaseTest
{
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private DbVerifier_OhioPatientV1 dbVerifier=new DbVerifier_OhioPatientV1();
	private Map<String, String> jsonField =new HashMap<>();

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
	public void Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_ValidNegative() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_ValidNegative");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_ValidNegative");
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLatitude, String.valueOf(dataGenerator.generateRandomIntegerInRange(-90, 0)));
		jsonField.put(GlobalVariable_V1.PatientLongitude, String.valueOf(dataGenerator.generateRandomIntegerInRange(-180, 0)));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_ValidPositiveNegative() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_ValidPositiveNegative");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_ValidPositiveNegative");
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLatitude, String.valueOf(dataGenerator.generateRandomIntegerInRange(-90, 90)));
		jsonField.put(GlobalVariable_V1.PatientLongitude, String.valueOf(dataGenerator.generateRandomIntegerInRange(-180, 180)));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_StaticPositve() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_StaticPositve");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_StaticPositve");
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLatitude, "90");
		jsonField.put(GlobalVariable_V1.PatientLongitude, "180");

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_StaticNegative() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_StaticNegative");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64487_Interface_Ohio_Patient_Validations_Latitude_Longitude_StaticNegative");
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientLatitude, "-90");
		jsonField.put(GlobalVariable_V1.PatientLongitude, "-180");

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
}

