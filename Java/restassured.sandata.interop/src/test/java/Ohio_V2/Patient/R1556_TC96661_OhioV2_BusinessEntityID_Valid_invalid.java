package Ohio_V2.Patient;

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

import com.globalMethods.core.Assertion_DbVerifier; 

public class R1556_TC96661_OhioV2_BusinessEntityID_Valid_invalid extends BaseTest { 
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	
	@Test(groups = {"All"})


	public void R1556_TC96661_OhioV2_BusinessEntityID_Valid() throws java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException

	{
		// logger = extent.startTest("R1556_TC96661_OhioV2_BusinessEntityID_Valid_invalid");
		logger.log(LogStatus.INFO, "R1556_TC96661_OhioV2_BusinessEntityID_Valid_invalid"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}

	@Test(groups = {"All"})
	public void R1556_TC96661_OhioV2_BusinessEntityID_inValid_morethan10() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96661_OhioV2_BusinessEntityID_inValid_morethan10");
		logger.log(LogStatus.INFO, "R1556_TC96661_OhioV2_BusinessEntityID_inValid_morethan10"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("BusinessEntityID", CommonMethods.generateRandomNumberOfFixLength(11));
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessentityformaterror));
		
	}
	
	@Test(groups = {"All"})
	public void R1556_TC96661_OhioV2_BusinessEntityID_inValid_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96661_OhioV2_BusinessEntityID_inValid_null");
		logger.log(LogStatus.INFO, "R1556_TC96661_OhioV2_BusinessEntityID_inValid_null"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("BusinessEntityID", null);
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		
		CommonMethods.verifyjsonassertFailcase_statusbadrequest(bodyAsString, "The account ID (BusinessEntityID) for some of input records is invalid. Please check and try again.");
		
	}

	@Test(groups = {"All"})
	public void R1556_TC96661_OhioV2_BusinessEntityID_inValid_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96661_OhioV2_BusinessEntityID_inValid_blank");
		logger.log(LogStatus.INFO, "R1556_TC96661_OhioV2_BusinessEntityID_inValid_blank"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("BusinessEntityID", "");
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		
		CommonMethods.verifyjsonassertFailcase_statusbadrequest(bodyAsString, "The account ID (BusinessEntityID) for some of input records is invalid. Please check and try again.");
		
	}
	
	@Test(groups = {"All"})
	public void R1556_TC96661_OhioV2_BusinessEntityID_inValid_alphanum() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96661_OhioV2_BusinessEntityID_inValid_alphanum");
		logger.log(LogStatus.INFO, "R1556_TC96661_OhioV2_BusinessEntityID_inValid_alphanum"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("BusinessEntityID", CommonMethods.generateRandomAlphaNumeric(9));
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessentityformaterror));
		
	}
	
	@Test(groups = {"All"})
	public void R1556_TC96661_OhioV2_BusinessEntityID_inValid_special() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R1556_TC96661_OhioV2_BusinessEntityID_inValid_special");
		logger.log(LogStatus.INFO, "R1556_TC96661_OhioV2_BusinessEntityID_inValid_special"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("BusinessEntityID", CommonMethods.generateSpecialChar(9));
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));
		
		Assert.assertTrue(bodyAsString.contains(globalVariables.businessentityformaterror));
		
	}

}