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

public class Auto_V8_TC64412_Interface_Ohio_Patient_Validations_PatientPhone_Mulitiplenumbers extends BaseTest
{

	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private DbVerifier_OhioPatientV1 dbVerifier=new DbVerifier_OhioPatientV1();
	private Map<String, String> jsonField =new HashMap<>();


	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64412_Interface_Ohio_Patient_Validations_PatientPhoneType_Valid_Home() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.Staticlists_PatientPhoneType_Valid_Home_64412);
		logger.log(LogStatus.INFO, GlobalVariable_V1.Staticlists_PatientPhoneType_Valid_Home_64412);

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientPhoneType, GlobalVariable_V1.Home);
		jsonField.put(GlobalVariable_V1.PatientPhoneNumber, CommonMethods.generateRandomNumberOfFixLength(10));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArray(jsonField, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}	

}
