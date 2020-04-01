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

public class R2267_TC91273_Visit_Call_In_greater_than_Callout_Otherwise_record_rejected extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	//To validate Call_In_greater_than_Callout_Otherwise_record_rejected
	
		@Test(groups = {"All", "Regression"})
		public void R78152_TC91273_AltEVV_VisitCreation_Rejected_Call_In_greater_than_Callout() throws InterruptedException, java.text.ParseException,  IOException, ParseException
		{
			// logger = extent.startTest("R78152_TC91273_AltEVV_VisitCreation_Rejected_Call_In_greater_than_Callout");
			logger.log(LogStatus.INFO, "Validating_VisitCreation_Rejected_Call_In_greater_than_Callout"); 

			
			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, "2018-10-18T19:02:26Z");
			
			JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges1.put(globalVariables.CallDateTimejson, "2018-10-10T19:02:26Z");
			
			jsonObjectVisit.put(globalVariables.AdjInDateTime, "2018-10-03T19:02:26Z");
			jsonObjectVisit.put(globalVariables.AdjOutDateTime, "2018-10-18T20:02:26Z");
			
			String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallInOutDateTime_Error);
					
		}
}
