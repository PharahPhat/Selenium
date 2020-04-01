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

public class Auto_V8_TC64297_Interface_OhioPatient_Load_Maximum_Values extends BaseTest
{
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private Map<String, String> jsonField =new HashMap<String,String>();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64297_Interface_OhioPatient_Load_Maximum_Values_Valid() throws Exception
	{	
		
		// logger = extent.startTest("Auto_V8_TC_64297_Interface_OhioPatient_Load_Maximum_Values_Valid");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64297_Interface_OhioPatient_Load_Maximum_Values_Valid");
			
	
		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1MaximumAllowedLength(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());
	}
}
