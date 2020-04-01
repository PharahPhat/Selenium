
package Ohio.sandata.restclaim;

import java.util.ArrayList;
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

public class SEVV_4799_TC98460_TC98461_Verfiy_claim_processessing_with_mutiple_visits extends BaseTest {
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();


	@Test(groups = {"All", "Regression", "fixing"})
	public void TC98460_Rest_Claim_verify_send_1_request_2_visits_found() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("TC98460_Rest_Claim_verify_send_1_request_2_visits_found");

	Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
 
		JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
				//second visit creation
		
		
        Map<String, JSONObject> MapjsonObjectsecond=GenerateUniqueParam.ohioclaim_Rest_multiple(MapjsonObject.get("visit").get("StaffOtherID").toString(),
        		MapjsonObject.get("visit").get("PatientMedicaidID").toString(), MapjsonObject.get("visit").get("PatientOtherID").toString() );
		
		JSONArray claimSubArraysecond= (JSONArray) MapjsonObjectsecond.get("rest").get("EVV_Request");
		JSONObject claimSubobjectsecond =  (JSONObject) claimSubArraysecond.get(0);
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		
		String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying response");
		Assertion_DbVerifier.claim_assertion(bodyAsString, MapjsonObject);
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.recordFound);	

	}

	@Test(groups = {"All", "Regression", "fixing"})
	public void TC98460_Rest_Claim_request_with_one_valid_one_invalid_visits() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("TC98457_Rest_Claim__when_more_than_2_visits_founds");

		Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
		Map<String, JSONObject> MapjsonObjectnew=GenerateUniqueParam.ohioclaim_Rest();
		
		JSONArray claimSubArraySecond= (JSONArray) MapjsonObjectnew.get("rest").get("EVV_Request");
		
		JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		
		claimSubArray.add(claimSubArraySecond.get(0));
		
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
		
		claimSubobject.put(globalVariables.MatchingRule, "abcd");
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(claimSubobject, CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying response");
		
		Assertion_DbVerifier.claim_assertion(bodyAsString, claimSubobject);
	}


}

