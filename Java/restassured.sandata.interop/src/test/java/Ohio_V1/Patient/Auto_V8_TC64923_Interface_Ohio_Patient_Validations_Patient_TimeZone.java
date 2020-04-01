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

public class Auto_V8_TC64923_Interface_Ohio_Patient_Validations_Patient_TimeZone extends BaseTest
{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	DbVerifier_OhioPatientV1 dbVerifier=new DbVerifier_OhioPatientV1();
	Map<String, String> jsonField =new HashMap<String,String>();


	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64923_Interface_Ohio_Patient_Validations_Patient_TimeZone_Valid() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.PatientTimeZone_positveCase_64923);
		logger.log(LogStatus.INFO, GlobalVariable_V1.PatientTimeZone_positveCase_64923);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientTimezone, GlobalVariable_V1.Eastern);

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
}
