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

public class Auto_V8_TC69046_Interface_Ohio_Patient_Validations_PatientMedicaidID extends BaseTest
{
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private DbVerifier_OhioPatientV1 dbVerifier=new DbVerifier_OhioPatientV1();
	private Map<String, String> jsonField =new HashMap<>();


	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_Invalid_LowerthenMAX() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_Invalid_LowerthenMAX");
		logger.log(LogStatus.INFO, "Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_Invalid_LowerthenMAX");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientMedicaidID, CommonMethods.generateRandomAlphaNumeric(11));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientMedicaidID);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientMedicaidIDLengthError_Generic);
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_valid() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_valid");
		logger.log(LogStatus.INFO, "Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_valid");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientMedicaidID, CommonMethods.generateRandomNumberOfFixLength(12));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());
	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_Invalid_GreaterthenMAX() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_Invalid_GreaterthenMAX");
		logger.log(LogStatus.INFO, "Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_Invalid_GreaterthenMAX");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientMedicaidID, CommonMethods.generateRandomAlphaNumeric(13));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientMedicaidID);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientMedicaidIDLengthError_Generic);


	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_Invalid_SpacialAlpha() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_Invalid_SpacialAlpha");
		logger.log(LogStatus.INFO, "Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_Invalid_SpacialAlpha");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientMedicaidID, CommonMethods.generateSpecialChar(6) + CommonMethods.generateRandomAlphaNumeric(6));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientMedicaidID);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientMedicaidIDLengthError_Generic);


	}

	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_values_Valid_leadingZero1() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_values_Valid_leadingZero1");
		logger.log(LogStatus.INFO, "Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_values_Valid_leadingZero1");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientMedicaidID, "0" + CommonMethods.generateRandomNumberOfFixLength(11));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);


		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_values_Valid_leadingZero2() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_values_Valid_leadingZero2");
		logger.log(LogStatus.INFO, "Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_values_Valid_leadingZero2");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientMedicaidID, "00" + CommonMethods.generateRandomNumberOfFixLength(10));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);


		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_values_Valid_leadingZero3() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_values_Valid_leadingZero3");
		logger.log(LogStatus.INFO, "Auto_V8_TC_69046_Interface_Ohio_Patient_Validations_PatientMedicaidID_values_Valid_leadingZero3");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientMedicaidID, "000" + CommonMethods.generateRandomNumberOfFixLength(9));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);


		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}
	
	


}
