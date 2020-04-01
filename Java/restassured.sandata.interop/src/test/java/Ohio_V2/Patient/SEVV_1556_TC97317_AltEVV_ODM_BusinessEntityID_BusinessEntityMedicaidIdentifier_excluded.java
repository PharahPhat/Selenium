/**
 * 
 */
package Ohio_V2.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Anupam
 */

public class SEVV_1556_TC97317_AltEVV_ODM_BusinessEntityID_BusinessEntityMedicaidIdentifier_excluded extends BaseTest {
    GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();
    Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();
	
	
	@Test(groups = {"All"})
	public void TC97317_AltEVV_ODM_BusinessEntityID_BusinessEntityMedicaidIdentifier_excluded() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC97317_AltEVV_ODM_BusinessEntityID_BusinessEntityMedicaidIdentifier_excluded");
		logger.log(LogStatus.INFO, "TC97317_AltEVV_ODM_BusinessEntityID_BusinessEntityMedicaidIdentifier_excluded"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.remove("BusinessEntityID");
		jsonObject.remove("BusinessEntityMedicaidIdentifier");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2));

		Assert.assertTrue(bodyAsString.contains("\"Reason\": \"The account ID (BusinessEntityID) for some of input records is invalid. Please check and try again.\""));
	
		

}
}
