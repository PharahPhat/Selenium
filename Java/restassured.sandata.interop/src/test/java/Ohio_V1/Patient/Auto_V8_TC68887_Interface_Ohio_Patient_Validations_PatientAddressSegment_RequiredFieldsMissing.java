package Ohio_V1.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.ohio.intake.patient.v1.DataGeneratorV1;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class Auto_V8_TC68887_Interface_Ohio_Patient_Validations_PatientAddressSegment_RequiredFieldsMissing extends BaseTest
{
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	// Sub-Array "Address_2" Required Field Missing
		@Test(groups = {"All", "Regression"})
		@AdditionalInfo(module = "OhioPatient")
		public void Auto_V8_TC_68887_Interface_Ohio_Patient_Validations_PatientAddressSegment_RequiredFieldsMissing_PatientAddressLine1() throws Exception
		{	

			// logger = extent.startTest("Auto_V8_TC_68887_Interface_Ohio_Patient_Validations_PatientAddressSegment_RequiredFieldsMissing_PatientAddressLine1");
			logger.log(LogStatus.INFO, "Auto_V8_TC_68887_Interface_Ohio_Patient_Validations_PatientAddressSegment_RequiredFieldsMissing_PatientAddressLine1");

			logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

			logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
			Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_RemoveAddressSegment("PatientAddressLine1");

			logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneNumber);
			dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), "The PatientAddressLine1 cannot be null.");

		}

		@Test(groups = {"All", "Regression"})
		@AdditionalInfo(module = "OhioPatient")
		public void Auto_V8_TC_68887_Interface_Ohio_Patient_Validations_PatientAddressSegment_RequiredFieldsMissing_PatientCity() throws Exception
		{	

			// logger = extent.startTest("Auto_V8_TC_68887_Interface_Ohio_Patient_Validations_PatientAddressSegment_RequiredFieldsMissing_PatientCity");
			logger.log(LogStatus.INFO, "Auto_V8_TC_68887_Interface_Ohio_Patient_Validations_PatientAddressSegment_RequiredFieldsMissing_PatientCity");

			logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

			logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
			Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_RemoveAddressSegment("PatientCity");

			logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneNumber);
			dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), "The PatientCity cannot be null.");

		}

		@Test(groups = {"All", "Regression"})
		@AdditionalInfo(module = "OhioPatient")
		public void Auto_V8_TC_68887_Interface_Ohio_Patient_Validations_PatientAddressSegment_RequiredFieldsMissing_PatientState() throws Exception
		{	

			// logger = extent.startTest("Auto_V8_TC_68887_Interface_Ohio_Patient_Validations_PatientAddressSegment_RequiredFieldsMissing_PatientState");
			logger.log(LogStatus.INFO, "Auto_V8_TC_68887_Interface_Ohio_Patient_Validations_PatientAddressSegment_RequiredFieldsMissing_PatientState");

			logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

			logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
			Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_RemoveAddressSegment("PatientState");

			logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneNumber);
			dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), "The PatientState cannot be null.");

		}

		@Test(groups = {"All", "Regression"})
		@AdditionalInfo(module = "OhioPatient")
		public void Auto_V8_TC_68887_Interface_Ohio_Patient_Validations_PatientAddressSegment_RequiredFieldsMissing_PatientZip() throws Exception
		{	

			// logger = extent.startTest("Auto_V8_TC_68887_Interface_Ohio_Patient_Validations_PatientAddressSegment_RequiredFieldsMissing_PatientZip");
			logger.log(LogStatus.INFO, "Auto_V8_TC_68887_Interface_Ohio_Patient_Validations_PatientAddressSegment_RequiredFieldsMissing_PatientZip");

			logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

			logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
			Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_RemoveAddressSegment("PatientZip");

			logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneNumber);
			dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), "The PatientZip cannot be null.");

		}


	
}
