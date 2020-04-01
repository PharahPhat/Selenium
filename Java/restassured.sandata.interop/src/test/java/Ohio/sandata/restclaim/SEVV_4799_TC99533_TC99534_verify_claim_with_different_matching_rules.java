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

public class SEVV_4799_TC99533_TC99534_verify_claim_with_different_matching_rules extends BaseTest{
	
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();

	@Test(groups = {"All", "Regression","fixing"})
		public void TC98408_Rest_Claim_RequestType_visit_based_claims() throws InterruptedException, java.text.ParseException,  Exception{
		
			// logger = extent.startTest("TC98408_Rest_Claim_RequestType_visit_based_claims");

			Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
			
			JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
			JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
			claimSubobject.put(globalVariables.MatchingRule, "EqualOrGreaterThan");
			logger.log(LogStatus.INFO,"Veirfying the value in  response");
			String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
			
			logger.log(LogStatus.INFO,"Veirfying the database");
			
			Assertion_DbVerifier.claim_assertion(bodyAsString, MapjsonObject);	

		}

	@Test(groups = {"All", "Regression","fixing"})
		public void TC98407_Rest_Claim_RequestType_unit_based_claims() throws InterruptedException, java.text.ParseException,  Exception{

			// logger = extent.startTest("TC98407_Rest_Claim_RequestType_unit_based_claims");

			Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
			
			JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
			JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
			claimSubobject.put(globalVariables.MatchingRule, "ExactMatch");
			logger.log(LogStatus.INFO,"Veirfying the value in  response");
			String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
			
			logger.log(LogStatus.INFO,"Veirfying the database");
			
			Assertion_DbVerifier.claim_assertion(bodyAsString, MapjsonObject);	

		}
		
		

}
