package Ohio_V2.Patient;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.ohio.intake.patient.v2.DataGeneratorV2;
import com.ohio.intake.patient.v2.DbVerifier_OhioPatientV2;
import com.ohio.intake.patient.v2.GlobalVariable_V2;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV_7755_TC101528_OhioV2_PatientGenInfo_IsPatientNewBorn_false_with_PatientMedID extends BaseTest{
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	DataGeneratorV2 dataGenerator=new DataGeneratorV2();
	DbVerifier_OhioPatientV2 dbVerifier=new DbVerifier_OhioPatientV2();
	DbVerifier_OhioPatientV2 inboxdbVerifier=new DbVerifier_OhioPatientV2();
	Map<String, String> jsonField =new HashMap<String,String>();
	
//	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatientv2")
	public void TC101528_OhioV2_PatientGenInfo_IsPatientNewBorn_false_with_PatientMedID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{	
		
		// logger = extent.startTest("TC101528_OhioV2_PatientGenInfo_IsPatientNewBorn_false_with_PatientMedID");
		logger.log(LogStatus.INFO, "TC101528_OhioV2_PatientGenInfo_IsPatientNewBorn_false_with_PatientMedID");
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.generateFieldValue);
		jsonField.put(GlobalVariable_V2.IsPatientNewborn, Boolean.toString(false));
		
		jsonField.put(GlobalVariable_V2.PatientMedicaidID, CommonMethods.generateRandomNumberOfFixLength(12));
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV2(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
		dbVerifier.jsonAssert_stxPatientOhioV2(returnObject.get(GlobalVariable_V2.jsonObject));


	}
	
//	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatientv2")
	public void TC101528_OhioV2_PatientGenInfo_IsPatientNewBorn_true_with_PatientMedID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{	
		
		// logger = extent.startTest("TC101528_OhioV2_PatientGenInfo_IsPatientNewBorn_true_with_PatientMedID");
		logger.log(LogStatus.INFO, "TC101528_OhioV2_PatientGenInfo_IsPatientNewBorn_true_with_PatientMedID");
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.generateFieldValue);
		jsonField.put(GlobalVariable_V2.IsPatientNewborn, Boolean.toString(true));
		
		jsonField.put(GlobalVariable_V2.PatientMedicaidID, CommonMethods.generateRandomNumberOfFixLength(12));
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV2(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V2.errorVerify + GlobalVariable_V2.PatientMedicaidID);
		
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V2.bodyAsStrinqagGet)), GlobalVariable_V2.IsPatient_Otherthan_truefalse);

	}
	
//	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatientv2")
	public void TC101528_OhioV2_PatientGenInfo_PatientMedID_with_PatientAlternateID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{	
		
		// logger = extent.startTest("TC101528_OhioV2_PatientGenInfo_PatientMedID_with_PatientAlternateID");
		logger.log(LogStatus.INFO, "TC101528_OhioV2_PatientGenInfo_PatientMedID_with_PatientAlternateID");
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.generateFieldValue);
		jsonField.put(GlobalVariable_V2.IsPatientNewborn, Boolean.toString(false));
		
		// As per Latest document Max and Min Length of patientMedicaidID to be 12
		jsonField.put(GlobalVariable_V2.PatientMedicaidID, CommonMethods.generateRandomNumberOfFixLength(12));
		
		// Length of this field is 64; the pattern only allows this field to be 7 digits long.
		jsonField.put(GlobalVariable_V2.PatientAlternateID, CommonMethods.generateRandomNumberOfFixLength(7));
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV2(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
		
		inboxdbVerifier.jsonAssert_stxPatientOhioV2(returnObject.get(GlobalVariable_V2.jsonObject));
		dbVerifier.jsonAssert_stxPatientOhioV2(returnObject.get(GlobalVariable_V2.jsonObject));
		
	}

}
