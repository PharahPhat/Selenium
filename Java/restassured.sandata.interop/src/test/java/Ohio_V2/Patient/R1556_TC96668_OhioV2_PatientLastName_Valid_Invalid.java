package Ohio_V2.Patient;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 91088: OpenEVV-altEVV- Client: Validate (mix) - MissingMedicaidID field formats/values

import com.globalMethods.core.Assertion_DbVerifier; public class R1556_TC96668_OhioV2_PatientLastName_Valid_Invalid extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	
	@Test(groups = {"All"})
	public void R1556_TC96668_ohio_patient_v2LastName_Valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96668_ohio_patient_v2LastName_Valid");
		logger.log(LogStatus.INFO, "R1556_TC96668_ohio_patient_v2LastName_Valid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(30));
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}
	
	@Test(groups = {"All"})
	public void R1556_TC96668_ohio_patient_v2LastName_Valid_maxminus1() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96668_ohio_patient_v2LastName_Valid_max");
		logger.log(LogStatus.INFO, "R1556_TC96668_ohio_patient_v2LastName_Valid_max"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(29));
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
		
		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}
	
	@Test(groups = {"All"})
	public void R1556_TC96668_ohio_patient_v2LastName_invalid_maxmplus1() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96668_ohio_patient_v2LastName_invalid_maxmplus1");
		logger.log(LogStatus.INFO, "R1556_TC96668_ohio_patient_v2LastName_invalid_maxmplus1"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientLastName", CommonMethods.generateRandomNumberOfFixLength(31));
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
		
		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.PatientLastNamelengtherror);
	}
	
	@Test(groups = {"All"})
	public void R1556_TC96668_ohio_patient_v2LastName_Valid_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96668_ohio_patient_v2LastName_Valid_null");
		logger.log(LogStatus.INFO, "R1556_TC96668_ohio_patient_v2LastName_Valid_null"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientLastName", null);
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
	
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.PatientLastNamenullerror);

	}
	
	@Test(groups = {"All"})
	public void R1556_TC96668_ohio_patient_v2LastName_inValid_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96668_ohio_patient_v2LastName_inValid_blank");
		logger.log(LogStatus.INFO, "R1556_TC96668_ohio_patient_v2LastName_inValid_blank"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientLastName", "");
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
		
		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.PatientLastNamelengtherror);

	}
	
	@Test(groups = {"All"})
	public void R1556_TC96668_ohio_patient_v2LastName_inValid_specialchar() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96668_ohio_patient_v2LastName_inValid_morethan64");
		logger.log(LogStatus.INFO, "R1556_TC96668_ohio_patient_v2LastName_inValid_morethan64"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientLastName", CommonMethods.generateSpecialChar(24));
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
	
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.PatientLastNameformaterror);
	}

	@Test(groups = {"All"})
	public void R1556_TC96668_ohio_patient_v2LastName_inValid_Alphanum() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96668_ohio_patient_v2LastName_inValid_Alphanum");
		logger.log(LogStatus.INFO, "R1556_TC96668_ohio_patient_v2LastName_inValid_Alphanum"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientLastName", CommonMethods.generateRandomAlphaNumeric(24));
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
	
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, globalVariables.PatientLastNameformaterror);
	}

}