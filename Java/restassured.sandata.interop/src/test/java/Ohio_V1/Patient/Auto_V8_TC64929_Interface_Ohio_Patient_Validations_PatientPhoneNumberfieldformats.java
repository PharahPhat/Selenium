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

public class Auto_V8_TC64929_Interface_Ohio_Patient_Validations_PatientPhoneNumberfieldformats extends BaseTest
{
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private DbVerifier_OhioPatientV1 dbVerifier=new DbVerifier_OhioPatientV1();
	private Map<String, String> jsonField =new HashMap<>();


	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64929_OhioPatient_PatientPhoneNumberfield_Positve10Char() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.PatientPhoneNumber_positveCase_64929);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientPhoneNumber_positveCase_64929);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
			jsonField.put(GlobalVariable_V1.PatientPhoneNumber, CommonMethods.generateRandomNumberOfFixLength(10));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArray(jsonField, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64929_OhioPatient_PatientPhoneNumberfield_Invalidgreater10Char() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.PatientPhoneNumber_invalidGreaterCase_64929);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientPhoneNumber_invalidGreaterCase_64929);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientPhoneNumber, CommonMethods.generateRandomNumberOfFixLength(11));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArray(jsonField, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneNumber);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientPhoneNumber);

	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64929_OhioPatient_PatientPhoneNumberfield_InvalidLess10Char() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.PatientPhoneNumber_invalidLessCase_64929);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientPhoneNumber_invalidLessCase_64929);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientPhoneNumber, CommonMethods.generateRandomNumberOfFixLength(9));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArray(jsonField, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneNumber);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.formatErrorMessagePatientPhoneNumber);

	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64929_OhioPatient_PatientPhoneNumberfield_InvalidAlphaNum() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.PatientPhoneNumber_invalidAlphanum_64929);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientPhoneNumber_invalidAlphanum_64929);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientPhoneNumber, CommonMethods.generateRandomAlphaNumeric(10));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArray(jsonField, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneNumber );
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet)), GlobalVariable_V1.formatErrorMessagePatientPhoneNumber);

	}
}
