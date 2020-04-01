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

public class Auto_V8_TC68777_Interface_Ohio_PatientFieldMapping_SchemaSTX_FullyPopulated extends BaseTest
{
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private DbVerifier_OhioPatientV1 dbVerifier=new DbVerifier_OhioPatientV1();
	private Map<String, String> jsonField =new HashMap<>();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_68777_Interface_Ohio_PatientFieldMapping_SchemaSTX_FullyPopulated_Valid() throws Exception
	{	
		
		// logger = extent.startTest(GlobalVariable_V1.SchemaSTX_FullyPopulated_68777);
		logger.log(LogStatus.INFO, GlobalVariable_V1.SchemaSTX_FullyPopulated_68777);
			
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1FullyPopulated(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}

}
