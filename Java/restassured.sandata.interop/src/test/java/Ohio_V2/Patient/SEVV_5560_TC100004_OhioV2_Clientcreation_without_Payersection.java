package Ohio_V2.Patient;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import junit.framework.Assert;

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_5560_TC100004_OhioV2_Clientcreation_without_Payersection extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void TC100004_OhioV2_Clientcreation_without_Payersection() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC100004_OhioV2_Clientcreation_without_Payersection");
		logger.log(LogStatus.INFO, "TC100004_OhioV2_Clientcreation_without_Payersection"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayAdd = 	(JSONArray) jsonObject.get("IndividualPayerInformation");
		jsonArrayAdd.remove(0);
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		Assert.assertTrue(bodyAsStringget.contains("\"messageSummary\": \"Records rejected, please review error and try again.\","));
		
	    Assert.assertTrue(bodyAsStringget.contains( "ERROR: The IndividualPayerInformation list cannot be empty. The record is being rejected."));
	}
}
