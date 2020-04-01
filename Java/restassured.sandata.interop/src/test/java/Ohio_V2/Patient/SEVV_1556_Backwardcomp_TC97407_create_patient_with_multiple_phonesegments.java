/**
 * 
 */
package Ohio_V2.Patient;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
import com.globalMethods.core.Assertion_DbVerifier; 
public class SEVV_1556_Backwardcomp_TC97407_create_patient_with_multiple_phonesegments extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


@Test(groups = {"All"})
public void R1556_TC97407_create_patient_with_multiple_phonesegments() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
{
	String Phnnum=CommonMethods.generateRandomNumberOfFixLength(10);
	// logger = extent.startTest("TC97407_create_patient_with_multiple_phonesegments");
	logger.log(LogStatus.INFO, "TC97407_create_patient_with_multiple_phonesegments"); 

	Map<String ,String> mapValuePhone =new HashMap<String,String>();
	mapValuePhone.put("PatientPhoneType", "Other");
	mapValuePhone.put("PatientPhoneNumber", Phnnum);

	JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);

	JSONArray jsonArrPay = (JSONArray) jsonObject.get("Phones");
	jsonArrPay.add(mapValuePhone);

	JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
	jsonObjectnew.put("PatientPhoneType", "Home");
	jsonObjectnew.put("PatientPhoneNumber", Phnnum);

	String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

	String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

	assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);

}


}
