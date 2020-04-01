package Ohio_V1.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.ohio.intake.patient.v1.DataGeneratorV1;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Auto_V8_TC68871_Interface_OhioPatient_Load_Exceed_Maximum_Values extends BaseTest
{
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private Map<String, String> jsonField =new HashMap<>();
	private List<String> errorMessage = new ArrayList<>();

	//Message is out of date
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_68871_Interface_OhioPatient_Load_Exceed_Maximum_Values_invalid() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_68871_Interface_OhioPatient_Load_Exceed_Maximum_Values_invalid");
		logger.log(LogStatus.INFO, "Auto_V8_TC_68871_Interface_OhioPatient_Load_Exceed_Maximum_Values_invalid");
			
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1MoreThanAllowedLength(jsonField);

		errorMessage=DataGeneratorV1.getErrorMessageForMoreThanSpecifiedLength();
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientLongitude);
		dataGenerator.assertFailErrorMessageList(returnObject.get(GlobalVariable_V1.bodyAsStringPost).toJSONString(), errorMessage);
		
	}
	
	
}
