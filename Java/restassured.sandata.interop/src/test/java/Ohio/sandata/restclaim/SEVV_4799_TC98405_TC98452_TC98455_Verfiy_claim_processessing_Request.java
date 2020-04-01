package Ohio.sandata.restclaim;

import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_4799_TC98405_TC98452_TC98455_Verfiy_claim_processessing_Request extends BaseTest {
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();

	@Test(groups = {"All", "Regression", "fixing"})
		public void TC98452_Rest_Claim_when_visit_not_verfied() throws InterruptedException, java.text.ParseException,  Exception{
			String Callin="c",  callout="a",valuecallin="b",valuecallout = "a";
			// logger = extent.startTest("TC98452_Rest_Claim_when_visit_not_verfied");

			Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
			
			JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
			JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
			claimSubobject.put(globalVariables.MatchingRule, "EqualOrGreaterThan");
			logger.log(LogStatus.INFO,"Veirfying the value in  response");
			String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
			
			logger.log(LogStatus.INFO,"Veirfying the response");
			
			CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.falseVisit);	

		}



	@Test(groups = {"All", "Regression", "fixing"})
		public void TC98405_Rest_Claim_verify_record_count_if_single_visit() throws InterruptedException, java.text.ParseException,  Exception{

			// logger = extent.startTest("TC98405_Rest_Claim_verify_record_count_if_single_visit");

			Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
			
			JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
			JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
	
			logger.log(LogStatus.INFO,"Veirfying the value in  response");
			String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
			
			logger.log(LogStatus.INFO,"Veirfying response");
			Assertion_DbVerifier.claim_assertion(bodyAsString, MapjsonObject);
			CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.recordFound);	

		}

	@Test(groups = {"All", "Regression", "fixing"})
		public void TC98455_Rest_Claim_visit_false_when_more_than_1_identical_visits() throws InterruptedException, java.text.ParseException,  Exception{

			// logger = extent.startTest("TC98455_Rest_Claim_visit_false_when_more_than_1_identical_visits");

			Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
			Map<String, JSONObject> MapjsonObjectnew=GenerateUniqueParam.ohioclaim_Rest();
			
			JSONArray claimSubArray= (JSONArray) MapjsonObjectnew.get("rest").get("EVV_Request");
			JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
			
			//claimSubobject.put(globalVariables.Units, CommonMethods.generateRandomAlphaNumeric(1));
			claimSubobject.put(globalVariables.MatchingRule, "ExcludeUnits");
			
			logger.log(LogStatus.INFO,"Veirfying the value in  response");
			String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObjectnew.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
			
			logger.log(LogStatus.INFO,"Veirfying db response");
			
			CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.recordFoundblank);	
			CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.noVisitFound);
			CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.falseVisit);
		}

}
