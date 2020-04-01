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
import com.globalMethods.core.Assertion_DbVerifier; public class SEVV_1556_TC97314_AltEVV_ODM_without_MedicaidID extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void TC97314_AltEVV_ODM_without_MedicaidID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97314_AltEVV_ODM_without_MedicaidID");
		logger.log(LogStatus.INFO, "TC97314_AltEVV_ODM_without_MedicaidID"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.remove("PatientMedicaidID");
		
		CommonMethods.captureResponseOhio_500(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));


}
		
		
	}

