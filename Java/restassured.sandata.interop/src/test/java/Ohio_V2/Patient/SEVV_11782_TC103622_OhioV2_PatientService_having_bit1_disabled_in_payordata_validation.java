package Ohio_V2.Patient;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.ohio.intake.VisitV2.UniqueJsonGeneratorPatient;
import com.ohio.intake.patient.v1.DataGeneratorV1;
import com.ohio.intake.patient.v2.DataGeneratorV2;
import com.ohio.intake.patient.v2.DbVerifier_OhioPatientV2;
import com.ohio.intake.patient.v2.GlobalVariable_V2;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV_11782_TC103622_OhioV2_PatientService_having_bit1_disabled_in_payordata_validation extends BaseTest {

	Assertion_DbVerifier Assertion_DbVerifier = new Assertion_DbVerifier();
	UniqueJsonGeneratorPatient GenerateUniqueParam = new UniqueJsonGeneratorPatient();
	DataGeneratorV1 dataGenerator = new DataGeneratorV1();

	@Test(groups = { "All", "Regression" })
	@AdditionalInfo(module = "OhioPatientv2")
	public void TC103622_OhioV2_PatientService_having_bit1_disabled_in_payordata_validation_G0299()
			throws InterruptedException, IOException, ParseException, ConfigurationException, SQLException, Exception {

		// logger = extent.startTest("TC103622_OhioV2_PatientService_having_bit1_disabled_in_payordata_validation_G0299");
		logger.log(LogStatus.INFO, "TC103622_OhioV2_Patient_Service_having_bit1_disabled_in_payor_data_validation_G0299");

		logger.log(LogStatus.INFO, GlobalVariable_V2.GeneratingUniquePatientv2);

		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_G0299();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);
		jsonObjectClientPayerInformation.put(globalVariables.payer, "ODM");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);
		
	}
	@Test(groups = { "All", "Regression" })
	@AdditionalInfo(module = "OhioPatientv2")
	public void TC103622_OhioV2_PatientService_having_bit1_disabled_in_payordata_validation_G0156()
			throws InterruptedException, IOException, ParseException, ConfigurationException, SQLException, Exception {

		// logger = extent.startTest("TC103622_OhioV2_PatientService_having_bit1_disabled_in_payordata_G0156_validation");
		logger.log(LogStatus.INFO, "TC103622_OhioV2_Patient_Service_having_bit1_disabled_in_payordata_G0156_validation");

		logger.log(LogStatus.INFO, GlobalVariable_V2.GeneratingUniquePatientv2);

		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_G0156();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);
		
		jsonObjectClientPayerInformation.put(globalVariables.payer, "ODM");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);
		
	}
	@Test(groups = { "All", "Regression" })
	@AdditionalInfo(module = "OhioPatientv2")
	public void TC103622_OhioV2_PatientService_having_bit1_disabled_in_payordata_validation_G0300()
			throws InterruptedException, IOException, ParseException, ConfigurationException, SQLException, Exception {

		// logger = extent.startTest("TC103622_OhioV2_PatientService_having_bit1_disabled_in_payordata_G0300_validation");
		logger.log(LogStatus.INFO, "TC103622_OhioV2_Patient_Service_having_bit1_disabled_in_payordata_G0300_validation");

		logger.log(LogStatus.INFO, GlobalVariable_V2.GeneratingUniquePatientv2);

		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_G0300();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);
	
		jsonObjectClientPayerInformation.put(globalVariables.payer, "ODM");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);
		
	}
	
	
}
