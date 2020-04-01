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
import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_1556_TC97313_AltEVV_ODM_Address_without_latitude_longitude extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void TC97313_AltEVV_ODM_Address_without_atleastone_latitudelongitude() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97313_AltEVV_ODM_Address_without_atleastone_latitudelongitude");
		logger.log(LogStatus.INFO, "TC97313_AltEVV_ODM_Address_without_atleastone_latitudelongitude"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayAddress = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectAddress =  (JSONObject) jsonArrayAddress.get(0);
		jsonObjectAddress.remove("PatientLongitude");
		jsonObjectAddress.remove("PatientLatitude");
		jsonObjectAddress.put("PatientAddressIsPrimary", "true");
		
		JSONObject jsonObjectAddress1 =  (JSONObject) jsonArrayAddress.get(1);
		jsonObjectAddress1.put("PatientLongitude", "170.23");
		jsonObjectAddress1.put("PatientLatitude", "89.23");
		jsonObjectAddress1.put("PatientAddressIsPrimary", "false");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);

}
	
	@Test(groups = {"All"})
	public void TC97313_AltEVV_ODM_Address_without_latitude_longitude() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97313_Address_without_latitude_longitude");
		logger.log(LogStatus.INFO, "TC97313_Address_without_latitude_longitude"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayAddress = (JSONArray) jsonObject.get("Address");
		JSONObject jsonObjectAddress =  (JSONObject) jsonArrayAddress.get(0);
		jsonObjectAddress.remove("PatientLongitude");
		jsonObjectAddress.remove("PatientLatitude");
		
		JSONObject jsonObjectAddress1 =  (JSONObject) jsonArrayAddress.get(1);
		jsonObjectAddress1.remove("PatientLongitude");
		jsonObjectAddress1.remove("PatientLatitude");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

		assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);

}
}
