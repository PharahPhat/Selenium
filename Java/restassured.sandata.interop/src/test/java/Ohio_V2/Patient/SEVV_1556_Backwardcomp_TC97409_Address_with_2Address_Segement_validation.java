/**
 * 
 */
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

/**
 * @author Anupam
 *
 */
import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_1556_Backwardcomp_TC97409_Address_with_2Address_Segement_validation extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	
	@Test(groups = {"All"})
	public void TC97409_Address_with_2Address_Segement_validation() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97409_Address_with_2Address_Segement_validation");
		logger.log(LogStatus.INFO, "TC97409_Address_with_2Address_Segement_validation"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
		jsonObjectnew.put("PatientCity", "Plano");
		jsonObjectnew.put("PatientAddressType", "Home");
		jsonObjectnew.put("PatientAddressIsPrimary", true);
		
		JSONArray jsonArrPay1 = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectnew1 = (JSONObject) jsonArrPay1.get(1);
		jsonObjectnew1.put("PatientCity", "Downtown");
		jsonObjectnew1.put("PatientAddressType", "Other");
		jsonObjectnew1.put("PatientAddressIsPrimary", false);
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}
	
}
