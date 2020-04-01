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
public class SEVV_7755_TC101530_OhioV2_PatientGeneralinfo_IsPatientNewBorn_fieldformat extends BaseTest{
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	DataGeneratorV2 dataGenerator=new DataGeneratorV2();
	DbVerifier_OhioPatientV2 dbVerifier=new DbVerifier_OhioPatientV2();
	Map<String, String> jsonField =new HashMap<String,String>();
	DbVerifier_OhioPatientV2 inboxdbVerifier=new DbVerifier_OhioPatientV2();

	
//	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatientv2")
	public void TC101530_OhioV2_PatientGeneralinfo_IsPatientNewBorn_false() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{	
		
		// logger = extent.startTest("TC101530_OhioV2_PatientGeneralinfo_IsPatientNewBorn_false");
		logger.log(LogStatus.INFO, "TC101530_OhioV2_PatientGeneralinfo_IsPatientNewBorn_false");
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.generateFieldValue);
		
		jsonField.put(GlobalVariable_V2.IsPatientNewborn, Boolean.toString(false));
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV2(jsonField);

		inboxdbVerifier.jsonAssert_stxPatientOhioV2(returnObject.get(GlobalVariable_V2.jsonObject));
		dbVerifier.jsonAssert_stxPatientOhioV2(returnObject.get(GlobalVariable_V2.jsonObject));
	}

//	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatientv2")
	public void TC101530_OhioV2_PatientGeneralinfo_IsPatientNewBorn_true() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{	
		
		// logger = extent.startTest("TC101530_OhioV2_PatientGeneralinfo_IsPatientNewBorn_true");
		logger.log(LogStatus.INFO, "TC101530_OhioV2_PatientGeneralinfo_IsPatientNewBorn_true");
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.generateFieldValue);
		
		jsonField.put(GlobalVariable_V2.IsPatientNewborn, Boolean.toString(true));
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV2(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V2.errorVerify + GlobalVariable_V2.IsPatientNewborn);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V2.bodyAsStrinqagGet)), GlobalVariable_V2.IsPatient_Otherthan_truefalse);
	}
	
//	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatientv2")
	public void TC101530_OhioV2_PatientGeneralinfo_IsPatientNewBorn_otherthan_truefalse() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{	
		
		// logger = extent.startTest("TC101530_OhioV2_PatientGeneralinfo_IsPatientNewBorn_true");
		logger.log(LogStatus.INFO, "TC101530_OhioV2_PatientGeneralinfo_IsPatientNewBorn_true");
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.generateFieldValue);
		
		jsonField.put(GlobalVariable_V2.IsPatientNewborn, "True");
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV2(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V2.errorVerify + GlobalVariable_V2.IsPatientNewborn);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V2.bodyAsStrinqagGet)), GlobalVariable_V2.IsPatient_Otherthan_truefalse);
		
	}
	
//	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatientv2")
	public void TC101530_OhioV2_PatientGeneralinfo_IsPatientNewBorn_null_valueset_false() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		
		// logger = extent.startTest("TC101530_OhioV2_PatientGeneralinfo_IsPatientNewBorn_true");
		logger.log(LogStatus.INFO, "TC101530_OhioV2_PatientGeneralinfo_IsPatientNewBorn_true");
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.generateFieldValue);
		
		jsonField.put(GlobalVariable_V2.IsPatientNewborn, null);
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV2(jsonField);

		inboxdbVerifier.jsonAssert_stxPatientOhioV2(returnObject.get(GlobalVariable_V2.jsonObject));
		dbVerifier.jsonAssert_stxPatientOhioV2(returnObject.get(GlobalVariable_V2.jsonObject));
		
	}
}
