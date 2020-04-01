package Ohio_V2.Patient;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;

import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_1556_TC97397_Address_PatientZip_validate extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	@Test(groups = {"All"})
	public void TC97397_PatientZip_validate_is_the_last_four_digits_are_not_provided() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		String Patzip= CommonMethods.generateRandomNumberOfFixLength(5);
		// logger = extent.startTest("TC97397_PatientZip_validate_is_the_last_four_digits_are_not_provided");
		logger.log(LogStatus.INFO, "TC97397_PatientZip_validate_is_the_last_four_digits_are_not_provided"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonobject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonobject.get(globalVariables.Address);
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientZip", Patzip);
		
		JSONArray jsonArrPaynew = (JSONArray) jsonobject.get(globalVariables.Address);
		JSONObject jsonObjectnew1 = (JSONObject) jsonArrPaynew.get(1);
		jsonObjectnew1.put("PatientZip", Patzip);
			
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonobject);
		
		
	}
	
}
