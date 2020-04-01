package Ohio_V1.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.ohio.intake.patient.v1.DataGeneratorV1;
import com.ohio.intake.patient.v1.DbVerifier_OhioPatientV1;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Auto_V8_TC64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues extends BaseTest
{
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private DbVerifier_OhioPatientV1 dbVerifier=new DbVerifier_OhioPatientV1();
	private Map<String, String> jsonField =new HashMap<>();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case1() throws Exception
	{	
		
		// logger = extent.startTest(GlobalVariable_V1.Staticlists_InvalidValues_Case1_6468);
		logger.log(LogStatus.INFO, GlobalVariable_V1.Staticlists_InvalidValues_Case1_6468);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientAddressType, GlobalVariable_V1.OTHER);
		jsonField.put(GlobalVariable_V1.PatientAddressIsPrimary, Boolean.toString(true));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
		
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case2() throws Exception
	{	
		
		// logger = extent.startTest(GlobalVariable_V1.Staticlists_InvalidValues_Case2_6468);
		logger.log(LogStatus.INFO, GlobalVariable_V1.Staticlists_InvalidValues_Case2_6468);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientAddressType, GlobalVariable_V1.SCHOOL);
		jsonField.put(GlobalVariable_V1.PatientAddressIsPrimary, Boolean.toString(true));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case3() throws Exception
	{	
		
		// logger = extent.startTest(GlobalVariable_V1.Staticlists_InvalidValues_Case3_6468);
		logger.log(LogStatus.INFO, GlobalVariable_V1.Staticlists_InvalidValues_Case3_6468);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientAddressType, GlobalVariable_V1.HOME);
		jsonField.put(GlobalVariable_V1.PatientAddressIsPrimary, Boolean.toString(true));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case4() throws Exception
	{	
		
		// logger = extent.startTest(GlobalVariable_V1.Staticlists_InvalidValues_Case4_6468);
		logger.log(LogStatus.INFO, GlobalVariable_V1.Staticlists_InvalidValues_Case4_6468);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientAddressType, GlobalVariable_V1.BUSINESS);
		jsonField.put(GlobalVariable_V1.PatientAddressIsPrimary, Boolean.toString(true));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case5() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.Staticlists_InvalidValues_Case5_6468);
		logger.log(LogStatus.INFO, GlobalVariable_V1.Staticlists_InvalidValues_Case5_6468);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
			jsonField.put(GlobalVariable_V1.PatientPhoneType, GlobalVariable_V1.FAX);

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArray(jsonField, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case6() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.Staticlists_InvalidValues_Case6_6468);
		logger.log(LogStatus.INFO, GlobalVariable_V1.Staticlists_InvalidValues_Case6_6468);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
			jsonField.put(GlobalVariable_V1.PatientPhoneType, GlobalVariable_V1.HOME);

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArray(jsonField, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case7() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.Staticlists_InvalidValues_Case7_6468);
		logger.log(LogStatus.INFO, GlobalVariable_V1.Staticlists_InvalidValues_Case7_6468);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
			jsonField.put(GlobalVariable_V1.PatientPhoneType, GlobalVariable_V1.MOBILE);

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArray(jsonField, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case8() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.Staticlists_InvalidValues_Case8_6468);
		logger.log(LogStatus.INFO, GlobalVariable_V1.Staticlists_InvalidValues_Case8_6468);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
			jsonField.put(GlobalVariable_V1.PatientPhoneType, GlobalVariable_V1.WORK);

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArray(jsonField, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case9() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.Staticlists_InvalidValues_Case9_6468);
		logger.log(LogStatus.INFO, GlobalVariable_V1.Staticlists_InvalidValues_Case9_6468);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
			jsonField.put(GlobalVariable_V1.PatientPhoneType, GlobalVariable_V1.OTHER);

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArray(jsonField, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case10() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.Staticlists_InvalidValues_Case10_6468);
		logger.log(LogStatus.INFO, GlobalVariable_V1.Staticlists_InvalidValues_Case10_6468);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientAddressIsPrimary, Boolean.toString(false));

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		dataGenerator.processOhioPatientV1PositiveCase(jsonField);

	}
}
