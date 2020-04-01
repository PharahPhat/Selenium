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

public class SEVV_4799_TC98456_TC98457_Verfiy_claim_processessing_in_case_of_multiple_record extends BaseTest{
	
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();


	@Test(groups = {"All", "Regression", "fixing"})
	public void TC98456_Rest_Claim_verify_record_count_if_mutiple_visit() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("TC98456_Rest_Claim_verify_record_count_if_mutiple_visit");

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
	public void TC98457_Rest_Claim__when_more_than_2_visits_founds() throws InterruptedException, java.text.ParseException,  Exception{

		// logger = extent.startTest("TC98457_Rest_Claim__when_more_than_2_visits_founds");

		Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
		Map<String, JSONObject> MapjsonObjectnew=GenerateUniqueParam.ohioclaim_Rest();
		
		JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
		
		//claimSubobject.put(globalVariables.Units, CommonMethods.generateRandomAlphaNumeric(1));
		claimSubobject.put(globalVariables.MatchingRule, "ExcludeUnits");
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObjectnew.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying response");
		
		Assertion_DbVerifier.claim_assertion(bodyAsString, MapjsonObject);
	}

}
