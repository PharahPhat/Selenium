package Ohio_V1.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.ohio.intake.patient.v1.DataGeneratorV1;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Auto_V8_TC64811_Interface_Ohio_Patient_Validations_BusinessEntityMedicaidIdentifier extends BaseTest
{

	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private Map<String, String> jsonField =new HashMap<>();

	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64811_Interface_Ohio_Patient_Validations_BusinessEntityMedicaidIdentifier_Invalid_LowerthenMAX() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64811_Interface_Ohio_Patient_Validations_BusinessEntityMedicaidIdentifier_Invalid_LowerthenMAX");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64811_Interface_Ohio_Patient_Validations_BusinessEntityMedicaidIdentifier_Invalid_LowerthenMAX");
			
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.BusinessEntityMedicaidIdentifier, CommonMethods.generateRandomAlphaNumeric(6));
	
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.BusinessEntityMedicaidIdentifier);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStringPost).toJSONString(), GlobalVariable_V1.BusinessEntityMedicaidIdentifierLengthError);
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64811_Interface_Ohio_Patient_Validations_BusinessEntityMedicaidIdentifier_Invalid_GreaterthenMAX() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64811_Interface_Ohio_Patient_Validations_BusinessEntityMedicaidIdentifier_Invalid_GreaterthenMAX");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64811_Interface_Ohio_Patient_Validations_BusinessEntityMedicaidIdentifier_Invalid_GreaterthenMAX");
			
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.BusinessEntityMedicaidIdentifier, CommonMethods.generateRandomAlphaNumeric(8));
	
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.BusinessEntityMedicaidIdentifier);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStringPost).toJSONString(), GlobalVariable_V1.BusinessEntityMedicaidIdentifierLengthError);


	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64811_Interface_Ohio_Patient_Validations_BusinessEntityMedicaidIdentifier_Invalid_SpacialAlpha() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64811_Interface_Ohio_Patient_Validations_BusinessEntityMedicaidIdentifier_Invalid_GreaterthenMAX");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64811_Interface_Ohio_Patient_Validations_BusinessEntityMedicaidIdentifier_values_InvalidMixAlphaNum");
			
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.BusinessEntityMedicaidIdentifier, CommonMethods.generateSpecialChar(4) + CommonMethods.generateRandomAlphaNumeric(3));
	
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.BusinessEntityMedicaidIdentifier);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStringPost).toJSONString(), GlobalVariable_V1.BusinessEntityMedicaidIdentifierLengthError);


	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64811_Interface_Ohio_Patient_Validations_BusinessEntityMedicaidIdentifier_values_InvalidStartingAlphaNum() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64811_Interface_Ohio_Patient_Validations_BusinessEntityMedicaidIdentifier_values_InvalidStartingAlphaNum");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64811_Interface_Ohio_Patient_Validations_BusinessEntityMedicaidIdentifier_values_InvalidStartingAlphaNum");
			
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.BusinessEntityMedicaidIdentifier, CommonMethods.generateRandomNumberOfFixLength(5)+CommonMethods.generateRandomStringOfFixLength(10));
	
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.BusinessEntityMedicaidIdentifier);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStringPost).toJSONString(), GlobalVariable_V1.BusinessEntityMedicaidIdentifierLengthError);


	}
	

}
