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

public class R2267_TC91274_Visit_AdjOut_greater_AdjIn_Otherwise_record_rejected extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	//To validate visit-  Adj. Out must be > Adj. In  Otherwise record rejected
		@Test(groups = {"All", "Regression"})
		public void R2267_TC91274_AltEVV_Visit_AdjOut_greater_AdjIn_Otherwise_recordrejected() throws InterruptedException, java.text.ParseException,  IOException, ParseException
		{
			// logger = extent.startTest("R2267_TC91274_AltEVV_Visit_AdjOut_greater_AdjIn_Otherwise_recordrejected");
			logger.log(LogStatus.INFO, "Validating_VisitCreation_Rejected_Adjust_In_greater_than_Adjustout"); 

			
			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
			jsonObjectVisit.put(globalVariables.AdjInDateTime, "2018-10-03T19:02:26Z");
			jsonObjectVisit.put(globalVariables.AdjOutDateTime, "2018-10-02T19:02:26Z");
		
			String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.aDjtimeformaterror);
		}
}
