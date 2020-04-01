package Ohio_V1.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.ohio.intake.patient.v1.DataGeneratorV1;
import com.ohio.intake.patient.v1.DbVerifier_OhioPatientV1;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
import com.ohio.intake.staff.v1.DataGenerator_staff_v1;
import com.ohio.intake.staff.v1.GlobalVariable_staff_v1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Auto_V8_TC64151_Interface_Ohio_Patient_Validations_MultipleAddress extends BaseTest
{
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private DbVerifier_OhioPatientV1 dbVerifier=new DbVerifier_OhioPatientV1();
	private Map<String, String> jsonField =new HashMap<>();
	private static String[] PatientAddressType = {"Business", "Home", "School", "Other" };

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64151_Interface_Ohio_Patient_Validations_MultipleAddressSegment_2() throws Exception
	{	
		// logger = extent.startTest("Auto_V8_TC_64151_Interface_Ohio_Patient_Validations_MultipleAddressSegment_2");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64151_Interface_Ohio_Patient_Validations_MultipleAddressSegment_2");

		
			logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
			jsonField.put(GlobalVariable_V1.PatientAddressType, GlobalVariable_V1.Business);
			jsonField.put(GlobalVariable_V1.PatientAddressIsPrimary, Boolean.toString(true));
			jsonField.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
			jsonField.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

			logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
			dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}


	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64151_Interface_Ohio_Patient_Validations_MultipleAddressSegment() throws Exception
	{
		// logger = extent.startTest("Auto_V8_TC_64151_Interface_Ohio_Patient_Validations_MultipleAddressSegment_2");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64151_Interface_Ohio_Patient_Validations_MultipleAddressSegment_2");

		for (int i = 0; i<PatientAddressType.length; i++){

			logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
			jsonField.put(GlobalVariable_V1.PatientAddressType, PatientAddressType[i]);
			jsonField.put(GlobalVariable_V1.PatientAddressIsPrimary, Boolean.toString(true));

			jsonField.put(GlobalVariable_staff_v1.staffPosition, DataGenerator_staff_v1.generateStaffPosition(i));


			logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
			dataGenerator.processOhioPatientV1PositiveCase(jsonField);

		}
	}
}
	
	
