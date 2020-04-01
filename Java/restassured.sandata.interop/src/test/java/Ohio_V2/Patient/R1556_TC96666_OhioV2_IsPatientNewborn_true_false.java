package Ohio_V2.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.ohio.intake.patient.v2.GlobalVariable_V2;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class R1556_TC96666_OhioV2_IsPatientNewborn_true_false extends BaseTest { 
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Smoke"})
	public void R1556_TC96666_ohio_patient_v2MedicaidID_true() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96666_ohio_patient_v2MedicaidID_true");
		logger.log(LogStatus.INFO, "R1556_TC96666_ohio_patient_v2MedicaidID_true"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientMedicaidID", null);
		jsonObject.put("IsPatientNewborn", true);

		CommonMethods.verifyPostResponseOhio(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2),
				CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
	}

	@Test(groups = {"All"})
	public void R1556_TC96666_ohio_patient_v2MedicaidID_true_valid() throws java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96666_ohio_patient_v2MedicaidID_true_valid");
		logger.log(LogStatus.INFO, "R1556_TC96666_ohio_patient_v2MedicaidID_true_valid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
		jsonObject.put("IsPatientNewborn", false);

		CommonMethods.verifyPostResponseOhio(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2),
				CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
	}
	
	@Test(groups = {"All"})
	public void R1556_TC96666_ohio_patient_v2MedicaidID_false() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96666_ohio_patient_v2MedicaidID_false");
		logger.log(LogStatus.INFO, "R1556_TC96666_ohio_patient_v2MedicaidID_false"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(15));
		jsonObject.put("IsPatientNewborn", false);

		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));


		CommonMethods.verifyErrorMessage(bodyAsStringget, GlobalVariable_V2.NullErrorMessagePatientMedicaidID);
	}
	
	@Test(groups = {"All"})
	public void R1556_TC96666_ohio_patient_v2MedicaidID_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96666_ohio_patient_v2MedicaidID_null");
		logger.log(LogStatus.INFO, "R1556_TC96666_ohio_patient_v2MedicaidID_null"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(15));
		jsonObject.put("IsPatientNewborn", null);

		CommonMethods.captureResponseOhio_500(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

			
	}
}