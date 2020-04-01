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

public class Auto_V8_TC64149_Interface_Ohio_Patient_Validations_PatientAddressTypeFieldValues extends BaseTest
{
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private DbVerifier_OhioPatientV1 dbVerifier=new DbVerifier_OhioPatientV1();
	private Map<String, String> jsonField =new HashMap<>();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64149_Ohio_Patient_Validations__PatientAddressType_valid_Business() throws Exception
	{	
		
		// logger = extent.startTest(GlobalVariable_V1.PatientAddressType_positveCaseBusiness_64149);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientAddressType_positveCaseBusiness_64149);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientAddressType, GlobalVariable_V1.Business);
		jsonField.put(GlobalVariable_V1.PatientAddressIsPrimary, Boolean.toString(true));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64149_Ohio_Patient_Validations__PatientAddressType_valid_Home() throws Exception
	{	
		
		// logger = extent.startTest(GlobalVariable_V1.PatientAddressType_positveCaseHome_64149);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientAddressType_positveCaseHome_64149);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientAddressType, GlobalVariable_V1.Home);
		jsonField.put(GlobalVariable_V1.PatientAddressIsPrimary, Boolean.toString(true));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64149_Ohio_Patient_Validations__PatientAddressType_valid_School() throws Exception
	{	
		
		// logger = extent.startTest(GlobalVariable_V1.PatientAddressType_positveCaseSchool_64149);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientAddressType_positveCaseSchool_64149);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientAddressType, GlobalVariable_V1.School);
		jsonField.put(GlobalVariable_V1.PatientAddressIsPrimary, Boolean.toString(true));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64149_Ohio_Patient_Validations__PatientAddressType_valid_Other() throws Exception
	{	
		
		// logger = extent.startTest(GlobalVariable_V1.PatientAddressType_positveCaseOther_64149);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientAddressType_positveCaseOther_64149);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientAddressType, GlobalVariable_V1.Other);
		jsonField.put(GlobalVariable_V1.PatientAddressIsPrimary, Boolean.toString(true));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
}
