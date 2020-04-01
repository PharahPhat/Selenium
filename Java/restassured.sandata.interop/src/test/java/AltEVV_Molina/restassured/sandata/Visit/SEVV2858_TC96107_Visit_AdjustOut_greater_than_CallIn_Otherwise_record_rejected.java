/**
 * 
 */
package AltEVV_Molina.restassured.sandata.Visit;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
import com.globalMethods.core.Assertion_DbVerifier; public class SEVV2858_TC96107_Visit_AdjustOut_greater_than_CallIn_Otherwise_record_rejected extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	//To validate Visit_AdjustOut_greater_than_CallIn_Otherwise_record_rejected
	
		@Test(groups = {"All", "Regression"})
		public void SEVV2858_TC96107_AltEVV_VisitCreation_Rejected_AdjustOut_greater_than_CallIn() throws InterruptedException, java.text.ParseException,  IOException, ParseException
		{
			// logger = extent.startTest("SEVV2858_TC96107_AltEVV_VisitCreation_Rejected_AdjustOut_greater_than_CallIn");
			logger.log(LogStatus.INFO, "Validating_VisitCreation_Rejected_CallIn_greater_than_Adjustout"); 

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.AdjOutDateTime, "2018-10-04T19:02:26Z");
			
			JSONArray jsonArrayVisit1 = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisit1 =  (JSONObject) jsonArrayVisit1.get(0);
			jsonObjectVisit1.put(globalVariables.CallDateTimejson, "2018-10-08T19:02:26Z");
			

			String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.AdjOutCallInDateTime_Error);
		}
}
