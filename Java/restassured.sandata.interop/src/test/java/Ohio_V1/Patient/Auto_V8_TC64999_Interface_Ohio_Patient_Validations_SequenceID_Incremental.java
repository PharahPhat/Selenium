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

public class Auto_V8_TC64999_Interface_Ohio_Patient_Validations_SequenceID_Incremental extends BaseTest
{
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private DbVerifier_OhioPatientV1 dbVerifier=new DbVerifier_OhioPatientV1();
	private Map<String, String> jsonField =new HashMap<>();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64999_Interface_Ohio_Patient_Validations_SequenceID_Incremental_Valid() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64999_Interface_Ohio_Patient_Validations_SequenceID_Incremental_Valid");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64999_Interface_Ohio_Patient_Validations_SequenceID_Incremental_Valid");
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);
		
		String SequenceID=(String) returnObject.get(GlobalVariable_V1.jsonObject).get("SequenceID");
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.incrementalSequenceIdMessage);

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put("SequenceID", String.valueOf(Long.parseLong(SequenceID) +1) );

		Thread.sleep(5000);

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		returnObject=dataGenerator.processOhioPatientV1(jsonField);
				
		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneType);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());
	}
	
	
	
	
}
