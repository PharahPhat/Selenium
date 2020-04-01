/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author Anupam
 */

public class R2267_TC91281_AltEVV_Visit_Rejected_without_Employee extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	//To validate visit without employee, record is accepted but raises an exception.
	
		@Test(groups = {"All", "Regression", "Smoke"})
		public void R2267_TC91281_AltEVV_VisitCreation_without_Employee() throws InterruptedException, IOException, ParseException
		{
			// logger = extent.startTest("R2267_TC91281_AltEVV_VisitCreation_without_Employee");
			logger.log(LogStatus.INFO, "Validating_VisitCreation_without_Employee"); 

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.remove(globalVariables.EmployeeOtherID);
			jsonObjectVisit.remove(globalVariables.EmployeeIdentifier);
			jsonObjectVisit.remove(globalVariables.EmployeeQualifier);
			
			String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
			
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeDetails_Error);
		}
}
