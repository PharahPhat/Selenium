/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Visit;

import java.io.IOException;

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

public class R2267_TC91272_AltEVV_Visit_rejected_without_Employeedetails extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
// Case1:	To validate if visit doesn't include EmployeeIdentifier complete visit will be rejected
		@Test(groups = {"All", "Regression"})
		public void R78152_TC91272_AltEVV_VisitCreation_Rejected_without_employeeIdentifier() throws InterruptedException, java.text.ParseException,  IOException, ParseException
		{
			// logger = extent.startTest("R78152_TC91272_AltEVV_VisitCreation_Rejected_without_employeeIdentifier");
			logger.log(LogStatus.INFO, "Validating_VisitCreation_Rejected_without_employeeIdentifier"); 

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.remove(globalVariables.EmployeeIdentifier);
			
			String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIdentifier_Error);
					
		}
		
// Case2:	To validate if visit doesn't include EmployeeQualifier complete visit will be rejected
				@Test(groups = {"All", "Regression"})
		public void R78152_TC91272_AltEVV_VisitCreation_Rejected_without_EmployeeQualifier() throws InterruptedException, java.text.ParseException,  IOException, ParseException
				{
					// logger = extent.startTest("R78152_TC91272_AltEVV_VisitCreation_Rejected_without_EmployeeQualifier");
					logger.log(LogStatus.INFO, "Validating_VisitCreation_Rejected_without_EmployeeQualifier"); 

					
					JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
					JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
					jsonObjectVisit.remove(globalVariables.EmployeeQualifier);
					
					String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifier_Error);
							
				}
}
