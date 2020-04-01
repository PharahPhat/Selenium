package Ohio_V2.Patient;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_1556_Backwardcomp_TC96661_OhioV2_BusinessEntityID_validation extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void TC96661_OhioV2_BusinessEntityID_validation() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96661_OhioV2_BusinessEntityID_validation");
		logger.log(LogStatus.INFO, "TC96661_OhioV2_BusinessEntityID_validation");

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("BusinessEntityID", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		CommonMethods.verifyjsonassertFailcase_statusbadrequest(bodyAsString, "The account ID (BusinessEntityID) for some of input records is invalid. Please check and try again");
	}

	@Test(groups = {"All"})
	public void TC96661_OhioV2_BusinessEntityID_with_validrecord() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96661_OhioV2_BusinessEntityID_with_validrecord");
		logger.log(LogStatus.INFO, "TC96661_OhioV2_BusinessEntityID_with_validrecord");

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		

		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);

	}

	@Test(groups = {"All"})
	public void TC96661_OhioV2_BusinessEntityID_length_exceeds_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96661_OhioV2_BusinessEntityID_length_exceeds_invalid");
		logger.log(LogStatus.INFO, "TC96661_OhioV2_BusinessEntityID_length_exceeds_invalid");

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("BusinessEntityID", CommonMethods.generateRandomNumberOfFixLength(11));

		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		CommonMethods.verifyjsonassertFailcase_statusbadrequest(bodyAsString, "The account ID (BusinessEntityID) for some of input records is invalid. Please check and try again.");

	}

	@Test(groups = {"All"})
	public void TC96661_OhioV2_BusinessEntityID_NULL_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96661_OhioV2_BusinessEntityID_NULL_invalid");
		logger.log(LogStatus.INFO, "TC96661_OhioV2_BusinessEntityID_NULL_invalid");

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("BusinessEntityID", "NULL");

		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));


		CommonMethods.verifyjsonassertFailcase_statusbadrequest(bodyAsString, "The account ID (BusinessEntityID) for some of input records is invalid. Please check and try again.");
	}

	@Test(groups = {"All"})
	public void TC96661_OhioV2_BusinessEntityID_Blank_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96661_OhioV2_BusinessEntityID_Blank_invalid");
		logger.log(LogStatus.INFO, "TC96661_OhioV2_BusinessEntityID_Blank_invalid");

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("BusinessEntityID", "");

		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		CommonMethods.verifyjsonassertFailcase_statusbadrequest(bodyAsString, "The account ID (BusinessEntityID) for some of input records is invalid. Please check and try again.");
	}
	@Test(groups = {"All"})
	public void TC96661_OhioV2_BusinessEntityID_Alphanumeric_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96661_OhioV2_BusinessEntityID_Alphanumeric_invalid");
		logger.log(LogStatus.INFO, "TC96661_OhioV2_BusinessEntityID_Alphanumeric_invalid");

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("BusinessEntityID", CommonMethods.generateRandomAlphaNumeric(8));

		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));


		CommonMethods.verifyjsonassertFailcase_statusbadrequest(bodyAsString, "The account ID (BusinessEntityID) for some of input records is invalid. Please check and try again.");

	}

}
