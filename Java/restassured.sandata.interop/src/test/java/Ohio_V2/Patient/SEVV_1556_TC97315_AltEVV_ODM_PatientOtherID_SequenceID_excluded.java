/**
 * 
 */
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

/**
 * @author Anupam
 *
 */
import com.globalMethods.core.Assertion_DbVerifier; 

public class SEVV_1556_TC97315_AltEVV_ODM_PatientOtherID_SequenceID_excluded extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void TC97315_PatientOtherID_SequenceID_excluded() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException {
			
		{
			// logger = extent.startTest("TC97315_PatientOtherID_SequenceID_excluded");
			logger.log(LogStatus.INFO, "TC97315_PatientOtherID_SequenceID_excluded"); 

			JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
			JSONObject jsonObject = (JSONObject) jsonArray.get(0);
			
			jsonObject.remove("PatientOtherID");
			jsonObject.remove("SequenceID");
			
			String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

			String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));

			CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, "The SequenceID  cannot be null. The record is being rejected.");
			CommonMethods.Assert_nullstatus_FailCase(bodyAsStringget, "The PatientOtherID is null. The record is being rejected.");

	}	
	}

}
