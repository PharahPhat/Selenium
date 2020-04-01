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

public class Auto_V8_TC65004_Interface_Ohio_Patient_Validations_SequenceID_Same_or_Prior_Values_previously_received extends BaseTest
{
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private DbVerifier_OhioPatientV1 dbVerifier=new DbVerifier_OhioPatientV1();
	private Map<String, String> jsonField =new HashMap<>();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_65004_Interface_Ohio_Patient_Validations_SequenceID_Same_or_Prior_Values_previously_received_Validinvalid() throws Exception
	{
		// logger = extent.startTest("Auto_V8_TC_65004_Interface_Ohio_Patient_Validations_SequenceID_Same_or_Prior_Values_previously_received_Validinvalid");
		logger.log(LogStatus.INFO, "Auto_V8_TC_65004_Interface_Ohio_Patient_Validations_SequenceID_Same_or_Prior_Values_previously_received_Validinvalid");
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1(jsonField);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.incrementalSequenceIdMessageProcessedbefore);

		Thread.sleep(5000);

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		returnObject=dataGenerator.processOhioPatientV1(returnObject.get("jsonObject"));
				
		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneType);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(),
				GlobalVariable_V1.sequenceIDErrorMessage);

		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(),
				GlobalVariable_V1.MessageSummaryRejected);

		jsonField = returnObject.get("jsonObject");
		Long sequenceId = Long.parseLong(jsonField.get("SequenceID")) - 1;
		jsonField.put("SequenceID", String.valueOf(sequenceId));

		returnObject=dataGenerator.processOhioPatientV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneType);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(),
				GlobalVariable_V1.sequenceIDErrorMessage);
	}
	
}
