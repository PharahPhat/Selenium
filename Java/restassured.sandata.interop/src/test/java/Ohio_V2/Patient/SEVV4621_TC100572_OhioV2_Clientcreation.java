package Ohio_V2.Patient;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import junit.framework.Assert;

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV4621_TC100572_OhioV2_Clientcreation extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	

	@Test(groups = {"All" , "Regression"})
	public void TC100572_OhioV2_Clientcreation() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC100572_OhioV2_Clientcreation");
		logger.log(LogStatus.INFO, "TC100572_OhioV2_Clientcreation"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("PatientAlternateID", CommonMethods.generateRandomNumberOfFixLength(7));
		
		JSONArray jsonArrayAdd = 	(JSONArray) jsonObject.get("IndividualPayerInformation");
		JSONObject jsonObjectsub = (JSONObject) jsonArrayAdd.get(0);
		
		jsonObjectsub.put("Payer", CommonMethods.generatepayer());
		jsonObjectsub.put("PayerProgram", CommonMethods.generatepayerprogram());
		jsonObjectsub.put("ProcedureCode", CommonMethods.generateProcedurecode());
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
		
	}

}
