/**
 * 
 */
package Ohio_V2.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Anupam
 */

public class SEVV_1556_Backwardcomp_TC96662_BusinessEntityMedicaidIdentifier_validations extends BaseTest {
	GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void TC96662_BusinessEntityMedicaidIdentifier_validations() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96662_AltEVV_BusinessEntityMedicaidIdentifier_validation");
		logger.log(LogStatus.INFO, "TC96662_AltEVV_BusinessEntityMedicaidIdentifier_validation"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("BusinessEntityMedicaidIdentifier", CommonMethods.generateRandomNumberOfFixLength(10));
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assert.assertTrue(bodyAsString.contains("\"Reason\": \"The BusinessEntityMedicaidID does not match with provider ID. Please check and try again.\""));
		
	}
	
	@Test(groups = {"All"})
	public void TC96662_AltEVV_BusinessEntityMedicaidIdentifier_with_validrecord() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96662_AltEVV_BusinessEntityMedicaidIdentifier_with_validrecord");
		logger.log(LogStatus.INFO, "TC96662_AltEVV_BusinessEntityMedicaidIdentifier_with_validrecord"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
		
	}
	
	@Test(groups = {"All"})
	public void TC96662_AltEVV_BusinessEntityMedicaidIdentifier_length_exceeds_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96662_AltEVV_BusinessEntityMedicaidIdentifier_length_exceeds_invalid");
		logger.log(LogStatus.INFO, "TC96662_AltEVV_BusinessEntityMedicaidIdentifier_length_exceeds_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("BusinessEntityMedicaidIdentifier", CommonMethods.generateRandomNumberOfFixLength(11));
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assert.assertTrue(bodyAsString.contains("\"Reason\": \"The BusinessEntityMedicaidID does not match with provider ID. Please check and try again.\""));
		
	}
	
	@Test(groups = {"All"})
	public void TC96662_AltEVV_BusinessEntityMedicaidIdentifier_NULL_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96662_AltEVV_BusinessEntityMedicaidIdentifier_NULL_invalid");
		logger.log(LogStatus.INFO, "TC96662_AltEVV_BusinessEntityMedicaidIdentifier_NULL_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("BusinessEntityMedicaidIdentifier", "NULL");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assert.assertTrue(bodyAsString.contains("\"Reason\": \"The BusinessEntityMedicaidID does not match with provider ID. Please check and try again.\""));
		
	}

	@Test(groups = {"All"})
	public void TC96662_AltEVV_BusinessEntityMedicaidIdentifier_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96662_AltEVV_BusinessEntityMedicaidIdentifier_invalid");
		logger.log(LogStatus.INFO, "TC96662_AltEVV_BusinessEntityMedicaidIdentifier_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("BusinessEntityMedicaidIdentifier", "");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));


		Assert.assertTrue(bodyAsString.contains("\"Reason\": \"The BusinessEntityMedicaidID does not match with provider ID. Please check and try again.\""));
		
	
	}
	@Test(groups = {"All"})
	public void TC96662_AltEVV_BusinessEntityMedicaidIdentifier_Alphanumeric_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96662_AltEVV_BusinessEntityMedicaidIdentifier_Alphanumeric_invalid");
		logger.log(LogStatus.INFO, "TC96662_AltEVV_BusinessEntityMedicaidIdentifier_Alphanumeric_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("BusinessEntityMedicaidIdentifier", CommonMethods.generateRandomAlphaNumeric(8));
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));


		Assert.assertTrue(bodyAsString.contains("\"Reason\": \"The BusinessEntityMedicaidID does not match with provider ID. Please check and try again.\""));
		
	}


}
