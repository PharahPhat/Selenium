package Ohio_V1.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.ohio.intake.patient.v1.DataGeneratorV1;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Auto_V8_TC64401_64574_Interface_Ohio_Patient_Required_Field_Missing extends BaseTest
{
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private Map<String, String> jsonField =new HashMap<>();
	private List<String> errorMessage =new ArrayList<>();


	// Main Array Required Field Missing
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64401_64574_Interface_Ohio_Patient_Required_Field_Missing_otherthan_BusinessEntityID_BusinessEntityMedicaidID() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_64401_64574_Interface_Ohio_Patient_Required_Field_Missing_otherthan_BusinessEntityID_BusinessEntityMedicaidID");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64401_64574_Interface_Ohio_Patient_Required_Field_Missing_otherthan_BusinessEntityID_BusinessEntityMedicaidID");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1RequiredFieldMissing(jsonField);

		errorMessage=dataGenerator.getErrorMessageRequiredFieldMissing();
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneType);
		dataGenerator.assertFailErrorMessageList(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), errorMessage );
	}
}
