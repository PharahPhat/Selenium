package Ohio_V1.Patient;

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
import com.ohio.intake.patient.v1.DataGeneratorV1;
import com.ohio.intake.patient.v1.DbVerifier_OhioPatientV1;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest; 

public class Auto_V8_TC64412_Interface_Ohio_Patient_Validations_PatientPhoneType_fieldvalue extends BaseTest
{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	DbVerifier_OhioPatientV1 dbVerifier=new DbVerifier_OhioPatientV1();
	Map<String, String> jsonField =new HashMap<String,String>();


	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64412_Interface_Ohio_Patient_Validations_PatientPhoneType_Valid_Home() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.Staticlists_PatientPhoneType_Valid_Home_64412);
		logger.log(LogStatus.INFO, GlobalVariable_V1.Staticlists_PatientPhoneType_Valid_Home_64412);

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientPhoneType, GlobalVariable_V1.Home);

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArray(jsonField, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}	

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64412_Interface_Ohio_Patient_Validations_PatientPhoneType_Valid_Mobile() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.Staticlists_PatientPhoneType_Valid_Mobile_64412);
		logger.log(LogStatus.INFO, GlobalVariable_V1.Staticlists_PatientPhoneType_Valid_Mobile_64412);

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientPhoneType, GlobalVariable_V1.Mobile);

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArray(jsonField, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}	

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64412_Interface_Ohio_Patient_Validations_PatientPhoneType_Valid_Work() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.Staticlists_PatientPhoneType_Valid_Work_64412);
		logger.log(LogStatus.INFO, GlobalVariable_V1.Staticlists_PatientPhoneType_Valid_Work_64412);

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientPhoneType, GlobalVariable_V1.Work);

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArray(jsonField, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64412_Interface_Ohio_Patient_Validations_PatientPhoneType_Valid_Other() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.Staticlists_PatientPhoneType_Valid_Other_64412);
		logger.log(LogStatus.INFO, GlobalVariable_V1.Staticlists_PatientPhoneType_Valid_Other_64412);

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientPhoneType, GlobalVariable_V1.Other);

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArray(jsonField, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64412_Interface_Ohio_Patient_Validations_PatientPhoneType_Valid_Fax() throws Exception
	{	
		// logger = extent.startTest(GlobalVariable_V1.Staticlists_PatientPhoneType_Valid_Fax_64412);
		logger.log(LogStatus.INFO, GlobalVariable_V1.Staticlists_PatientPhoneType_Valid_Fax_64412);

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );
		jsonField.put(GlobalVariable_V1.PatientPhoneType, GlobalVariable_V1.Fax);

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArray(jsonField, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.DBVerify);
		CommonMethods.verifyJsonPassCase(returnObject.get("bodyAsStringGet").toString());

	}
}
