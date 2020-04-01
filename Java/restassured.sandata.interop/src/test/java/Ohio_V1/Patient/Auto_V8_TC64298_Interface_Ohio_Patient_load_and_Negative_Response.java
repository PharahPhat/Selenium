package Ohio_V1.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.ohio.intake.patient.v1.DataGeneratorV1;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
import com.ohio.intake.patient.v1.UniqueJsonGeneratorV1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Auto_V8_TC64298_Interface_Ohio_Patient_load_and_Negative_Response extends BaseTest
{
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private UniqueJsonGeneratorV1 uniqueJsonGenerator=new UniqueJsonGeneratorV1();
	// Main Array Required Field Missing
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_BusinessEntityID() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_BusinessEntityID");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_BusinessEntityID");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		JSONArray jsonArray = uniqueJsonGenerator.patient_Ohio(GlobalVariable_V1.Ohio_patientJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("BusinessEntityID");

		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Post(jsonArray));
		Map<String, JSONObject> returnObject = new HashMap<>();
		returnObject.put("bodyAsStringPost", bodyAsStringPost);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneType);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStringPost).toJSONString(), GlobalVariable_V1.BusinessEntityIDNullError);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_BusinessEntityMedicaidIdentifier() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_BusinessEntityMedicaidIdentifier");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_BusinessEntityMedicaidIdentifier");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1RequiredFieldRemove("BusinessEntityMedicaidIdentifier");

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneType);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStringPost).toJSONString(), GlobalVariable_V1.BusinessEntityMedicaidIDNullError);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientOtherID() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientOtherID");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientOtherID");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1RequiredFieldRemove("PatientOtherID");

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneType);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientOtherIDNullError);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_SequenceID() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_SequenceID");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_SequenceID");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1RequiredFieldRemove("SequenceID");

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneType);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.SequenceIDNullError);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientMedicaidID() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientMedicaidID");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientMedicaidID");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1RequiredFieldRemove("PatientMedicaidID");

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneType);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientMedicaidIDLengthError_Generic);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientLastName() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientLastName");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientLastName");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1RequiredFieldRemove("PatientLastName");

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneType);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientLastNameNullError);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientFirstName() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientFirstName");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientFirstName");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1RequiredFieldRemove("PatientFirstName");

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneType);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientFirstNameNullError);

	}

	// Sub-Array "Phones" Required Field Missing
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_Phonetype() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_Phonetype");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_Phonetype");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArrayRemove(GlobalVariable_V1.PatientPhoneType, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneNumber);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.nullErrorMessagePatientPhoneType);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_Phone() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_Phone");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_Phone");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArrayRemove(GlobalVariable_V1.PatientPhoneNumber, GlobalVariable_V1.Phones, 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneType);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.nullErrorMessagePatientPhoneNumber);

	}


	// Sub-Array "ResponsibleParty" Required Field Missing
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientResponsiblePartyFirstName() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientResponsiblePartyFirstName");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientResponsiblePartyFirstName");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArrayRemove("PatientResponsiblePartyFirstName", "ResponsibleParty", 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneNumber);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientResponsiblePartyFirstNameNullError);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientResponsiblePartyLastName() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientResponsiblePartyLastName");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientResponsiblePartyLastName");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1WithSubArrayRemove("PatientResponsiblePartyLastName", "ResponsibleParty", 0);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneType);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientResponsiblePartyLastNameNullError);

	}


	// Sub-Array "Address_2" Required Field Missing
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientAddressLine1() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientAddressLine1");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientAddressLine1");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_RemoveAddressSegment("PatientAddressLine1");

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneNumber);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientAddressLine1NullError);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientCity() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientCity");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientCity");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_RemoveAddressSegment("PatientCity");

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneNumber);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientCityNullError );

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientState() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientState");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientState");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_RemoveAddressSegment("PatientState");

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneNumber);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientStateNullError );

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioPatient")
	public void Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientZip() throws Exception
	{	

		// logger = extent.startTest("Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientZip");
		logger.log(LogStatus.INFO, "Auto_V8_TC_64298_Interface_Ohio_Patient_Required_Field_Blank_invalid_PatientZip");

		logger.log(LogStatus.INFO, GlobalVariable_V1.generateFieldValue );

		logger.log(LogStatus.INFO, GlobalVariable_V1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioPatientV1SubArray_RemoveAddressSegment("PatientZip");

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_V1.PatientPhoneNumber);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_V1.bodyAsStrinqagGet).toJSONString(), GlobalVariable_V1.PatientZipNullError);

	}


}
