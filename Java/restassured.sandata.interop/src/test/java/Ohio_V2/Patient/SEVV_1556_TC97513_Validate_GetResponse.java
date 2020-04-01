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

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_1556_TC97513_Validate_GetResponse extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	//validating AltEVV with no value of MissingMedicaidID
			@Test(groups = {"All"})
			public void TC97513_Validate_GetResponse_with_multiple_valueof_ResponsibleParty() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
			{
				// logger = extent.startTest("TC97513_Validate_GetResponse_with_multiple_valueof_ResponsibleParty");
				logger.log(LogStatus.INFO, "TC97513_Validate_GetResponse_with_multiple_valueof_ResponsibleParty"); 

				JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
				JSONObject jsonObject = (JSONObject) jsonArray.get(0);
				
				JSONArray jsonArrPay = (JSONArray) jsonObject.get("ResponsibleParty");
				JSONObject jsonObjectnew = (JSONObject) jsonArrPay.get(0);
				jsonObjectnew.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(8));
				jsonObjectnew.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(8));
				
				String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

				String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

				assertionDbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
			}

}
