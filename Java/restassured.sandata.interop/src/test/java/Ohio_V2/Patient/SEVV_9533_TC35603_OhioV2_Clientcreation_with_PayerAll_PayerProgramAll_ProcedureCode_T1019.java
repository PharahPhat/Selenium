package Ohio_V2.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import com.ohio.intake.VisitV2.UniqueJsonGeneratorPatient;
import com.ohio.intake.patient.v1.DataGeneratorV1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;


public class SEVV_9533_TC35603_OhioV2_Clientcreation_with_PayerAll_PayerProgramAll_ProcedureCode_T1019 extends BaseTest{

	Assertion_DbVerifier Assertion_DbVerifier=new Assertion_DbVerifier();
	UniqueJsonGeneratorPatient GenerateUniqueParam = new UniqueJsonGeneratorPatient();
	DataGeneratorV1 dataGenerator=new DataGeneratorV1();

	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_OHC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Aetna");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Aetna");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SPHH");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_SP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Aetna");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_DD() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Aetna");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "DD");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_MyC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Aetna");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "MyC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_PP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Aetna_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Aetna");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "PP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}


	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_OHC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Buckeye");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Buckeye");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SPHH");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_SP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Buckeye");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_DD() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Buckeye");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "DD");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_MyC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Buckeye");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "MyC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_PP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Buckeye_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Buckeye");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "PP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	

	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_OHC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "CareSource");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "CareSource");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SPHH");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_SP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "CareSource");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_DD() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "CareSource");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "DD");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_MyC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "CareSource");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "MyC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_PP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_CareSource_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "CareSource");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "PP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
		

	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_OHC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "DODD");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "DODD");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SPHH");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_SP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "DODD");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_DD() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "DODD");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "DD");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_MyC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "DODD");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "MyC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_PP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_DODD_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "DODD");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "PP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}


	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_OHC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Molina");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Molina");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SPHH");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_SP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Molina");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_DD() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Molina");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "DD");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_MyC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Molina");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "MyC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_PP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Molina_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Molina");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "PP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}


	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_OHC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "ODA");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "ODA");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SPHH");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_SP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "ODA");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_DD() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "ODA");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "DD");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_MyC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "ODA");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "MyC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_PP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODA_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "ODA");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "PP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODM_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODM_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODM_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "ODM");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SPHH");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODM_PayerProgram_SP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODM_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODM_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "ODM");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODM_PayerProgram_DD() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODM_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODM_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "ODM");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "DD");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODM_PayerProgram_MyC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODM_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODM_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "ODM");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "MyC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODM_PayerProgram_PP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODM_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_ODM_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "ODM");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "PP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	

	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_OHC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Paramount");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Paramount");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SPHH");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_SP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Paramount");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_DD() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Paramount");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "DD");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_MyC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Paramount");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "MyC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_PP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_Paramount_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "Paramount");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "PP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	

	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "UHC");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "OHC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_SPHH() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "UHC");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SPHH");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_SP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "UHC");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "SP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_DD() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "UHC");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "DD");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_MyC() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "UHC");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "MyC");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}
	
	@Test(groups = {"All","fixing"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_PP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "UHC");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "PP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assertion_DbVerifier.stxClientSql_OhioV2_SEVV9533(bodyAsStringClient, jsonObjectClient);

	}

	
	//Error message verification for payer, Program, ProcedureCode

	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_Invalid_Payer_UHC_PayerProgram_PP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "UHC");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "PP");
		jsonObjectClientPayerInformation.put("ProcedureCode",CommonMethods.generateRandomStringOfFixLength(3));

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2_Errormessage(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2),CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2) );

		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringClient, globalVariables.errorProcedureCodeClient);

	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_invalid_PayerProgram_PP() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, CommonMethods.generateRandomStringOfFixLength(3));
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, "PP");

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2_Errormessage(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2),CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2) );

		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringClient, globalVariables.errorPayerClient);

	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioVisit")
	public void OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC");
		logger.log(LogStatus.INFO, "OhioV2_TC35603_Clientcreation_with_Payer_ProcedureCode_T1019_Payer_UHC_PayerProgram_OHC"); 


		////////////Generating Unique patient detail using  Ohio v2 json//////////////
		JSONArray jsonArrayClient = GenerateUniqueParam.ClientParam_v2_SEVV9533_ProcedureCode_T1019();
		JSONObject jsonObjectClient = (JSONObject) jsonArrayClient.get(0);

		JSONObject jsonObjectClientPayerInformation = 	dataGenerator.subArrayCreation(jsonObjectClient, "IndividualPayerInformation", 0);

		jsonObjectClientPayerInformation.put(globalVariables.payer, "UHC");
		jsonObjectClientPayerInformation.put(globalVariables.PayerProgram, CommonMethods.generateRandomStringOfFixLength(3));

		String bodyAsStringClient = CommonMethods.captureResponseOhio_v2_Errormessage(jsonArrayClient, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2),CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2) );

		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringClient, globalVariables.errorPayerprogramClient);

	}
	
	

}