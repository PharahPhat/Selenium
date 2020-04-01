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

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_5560_TC100005_OhioV2_Clientfailed_without_Payerfields extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void TC100005_OhioV2_Clientcreation_without_Payer() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC100005_OhioV2_Clientcreation_without_Payer");
		logger.log(LogStatus.INFO, "TC100005_OhioV2_Clientcreation_without_Payer"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayAdd = (JSONArray) jsonObject.get("IndividualPayerInformation");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayAdd.get(0);
		
		jsonObjectAdd.remove("Payer");
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		Assert.assertTrue(bodyAsStringget.contains("\"messageSummary\": \"The uploaded record(s) has(have) been processed with some error or warning message(s). Please check individual record to see whether it was loaded successfully or rejected.\","));
		
	    Assert.assertTrue(bodyAsStringget.contains( "ERROR: The Payer cannot be null.  The record for the responsible party is being rejected."));
	}
	@Test(groups = {"All"})
	public void TC100005_OhioV2_Clientcreation_without_Payerprogram() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC100005_OhioV2_Clientcreation_without_Payerprogram");
		logger.log(LogStatus.INFO, "TC100005_OhioV2_Clientcreation_without_Payerprogram"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayAdd = (JSONArray) jsonObject.get("IndividualPayerInformation");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayAdd.get(0);
		
		jsonObjectAdd.remove("PayerProgram");
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		Assert.assertTrue(bodyAsStringget.contains("\"messageSummary\": \"The uploaded record(s) has(have) been processed with some error or warning message(s). Please check individual record to see whether it was loaded successfully or rejected.\","));
		
	    Assert.assertTrue(bodyAsStringget.contains( "ERROR: The PayerProgram cannot be null.  The record for the responsible party is being rejected."));
	}
	
	@Test(groups = {"All"})
	public void TC100005_OhioV2_Clientcreation_without_ProcedureCode() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC100005_OhioV2_Clientcreation_without_ProcedureCode");
		logger.log(LogStatus.INFO, "TC100005_OhioV2_Clientcreation_without_ProcedureCode"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayAdd = (JSONArray) jsonObject.get("IndividualPayerInformation");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayAdd.get(0);
		
		jsonObjectAdd.remove("ProcedureCode");
	
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		Assert.assertTrue(bodyAsStringget.contains("\"messageSummary\": \"The uploaded record(s) has(have) been processed with some error or warning message(s). Please check individual record to see whether it was loaded successfully or rejected.\","));
		
	    Assert.assertTrue(bodyAsStringget.contains( "ERROR: The ProcedureCode cannot be null.  The record for the responsible party is being rejected."));
	}


}
