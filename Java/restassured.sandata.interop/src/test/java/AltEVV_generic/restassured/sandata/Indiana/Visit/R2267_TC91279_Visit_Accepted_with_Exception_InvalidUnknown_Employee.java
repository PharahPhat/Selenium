/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Anupam
 */

public class R2267_TC91279_Visit_Accepted_with_Exception_InvalidUnknown_Employee extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	//To validate Invalid or Unknown employee Provided, record is accepted but raises an exception.
	
		@Test(groups = {"All", "Regression", "fixing"})
		public void TC91279_AltEVV_Visit_Accepted_with_Exception_InvalidUnknown_Employee() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException {
			// logger = extent.startTest("R2267_TC91279_AltEVV_Visit_Accepted_with_Exception");
			logger.log(LogStatus.INFO, "Validating_VisitAccepted_with_Exception_Passing_InvalidUnknown_Employee_Provided"); 

			String Employee_Detail =CommonMethods.generateRandomAlphaNumeric(9);
			
			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			
			jsonObjectVisit.put(globalVariables.EmployeeIdentifier, Employee_Detail);
			
			String bodyPost = CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
			String bodyGet = CommonMethods.captureGetResponseWithUID(bodyPost,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit_get));
			CommonMethods.verifyErrorMessage(bodyGet, "-1031");
			CommonMethods.verifyErrorMessage(bodyGet, "Worker not found");
		}
}
