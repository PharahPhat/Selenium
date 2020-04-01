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
public class SEVV_7755_TC101532_OhioV2_PatientOtherID_Negative_Field_Format extends BaseTest{
	
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	DataGeneratorV2 dataGenerator=new DataGeneratorV2();
	DbVerifier_OhioPatientV2 dbVerifier=new DbVerifier_OhioPatientV2();
	Map<String, String> jsonField =new HashMap<String,String>();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatientv2")
	public void TC101532_OhioV2_PatientOtherID_Negative_Maxlength_exceeds() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{			
		// logger = extent.startTest("TC101532_OhioV2_PatientOtherID_Negative_Maxlength_exceeds");
		logger.log(LogStatus.INFO, "OhioV2_PatientOtherID_Negative_Maxlength_exceeds");
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.generateFieldValue);
		jsonField.put(GlobalVariable_V2.PatientOtherID, CommonMethods.generateRandomNumberOfFixLength(65));
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV2(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V2.errorVerify + GlobalVariable_V2.PatientOtherID);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V2.bodyAsStrinqagGet)), GlobalVariable_V2.LengthErrorMessagePatientOtherID);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V2.bodyAsStrinqagGet)), GlobalVariable_V2.formatErrorMessagePatientOtherID);


	}
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioPatientv2")
	public void TC101532_OhioV2_PatientOtherID_Invalid_Null_with_IsPatientNewborn_True() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{	
		
		// logger = extent.startTest("TC101532_OhioV2_PatientOtherID_Invalid_Null_with_IsPatientNewborn_True");
		logger.log(LogStatus.INFO, "TC101532_OhioV2_PatientOtherID_Invalid_Null_with_IsPatientNewborn_True");
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.generateFieldValue);
		jsonField.put(GlobalVariable_V2.PatientOtherID, null);
		
		jsonField.put(GlobalVariable_V2.IsPatientNewborn, Boolean.toString(true));
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV2(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V2.errorVerify + GlobalVariable_V2.PatientOtherID);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V2.bodyAsStrinqagGet)), GlobalVariable_V2.NullErrorMessagePatientOtherID);
		


	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatientv2")
	public void TC101532_OhioV2_PatientOtherID_Blank_Invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{	
		
		// logger = extent.startTest("TC101532_OhioV2_PatientOtherID_Blank_Invalid");
		logger.log(LogStatus.INFO, "TC101532_OhioV2_PatientOtherID_Blank_Invalid");
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.generateFieldValue);
		jsonField.put(GlobalVariable_V2.PatientOtherID, " ");
		
		
		logger.log(LogStatus.INFO, GlobalVariable_V2.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV2(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V2.errorVerify + GlobalVariable_V2.PatientOtherID);
		dataGenerator.assertFailErrorMessage(String.valueOf(returnObject.get(GlobalVariable_V2.bodyAsStrinqagGet)), GlobalVariable_V2.formatErrorMessagePatientOtherID);


	}
	

}
