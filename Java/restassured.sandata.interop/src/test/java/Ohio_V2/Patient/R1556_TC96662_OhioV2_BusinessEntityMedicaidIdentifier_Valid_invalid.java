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

import com.globalMethods.core.Assertion_DbVerifier; public class R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_Valid_invalid extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	
	@Test(groups = {"All"})
	public void R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_Valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_Valid_invalid");
		logger.log(LogStatus.INFO, "R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_Valid_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}

	@Test(groups = {"All"})
	public void R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_inValid_morethan10() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_inValid_morethan10");
		logger.log(LogStatus.INFO, "R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_inValid_morethan10"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("BusinessEntityMedicaidIdentifier", CommonMethods.generateRandomNumberOfFixLength(11));
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessentitymedicatedformaterror));
		
	}
	
	@Test(groups = {"All"})
	public void R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_inValid_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_inValid_null");
		logger.log(LogStatus.INFO, "R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_inValid_null"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("BusinessEntityMedicaidIdentifier", null);
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessmedicatednullerror));
		
	}

	@Test(groups = {"All"})
	public void R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_inValid_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_inValid_blank");
		logger.log(LogStatus.INFO, "R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_inValid_blank"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("BusinessEntityMedicaidIdentifier", "");
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessmedicatednullerror));
		
	}
	
	@Test(groups = {"All"})
	public void R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_inValid_alphanum() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_inValid_alphanum");
		logger.log(LogStatus.INFO, "R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_inValid_alphanum"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("BusinessEntityMedicaidIdentifier", CommonMethods.generateRandomAlphaNumeric(9));
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessentitymedicatedformaterror));
		
	}
	
	@Test(groups = {"All"})
	public void R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_inValid_special() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_inValid_special");
		logger.log(LogStatus.INFO, "R1556_TC96662_OhioV2_BusinessEntityMedicaidIdentifier_inValid_special"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("BusinessEntityMedicaidIdentifier", CommonMethods.generateSpecialChar(9));
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessentitymedicatedformaterror));
		
	}

}