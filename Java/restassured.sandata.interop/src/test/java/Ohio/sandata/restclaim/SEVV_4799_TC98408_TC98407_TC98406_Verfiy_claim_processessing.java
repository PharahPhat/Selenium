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

public class SEVV_4799_TC98408_TC98407_TC98406_Verfiy_claim_processessing extends BaseTest{
	
	
GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();
	
	@Test(groups = {"All", "Regression", "fixing"})
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

	@Test(groups = {"All", "Regression", "fixing"})
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

	@Test(groups = {"All", "Regression", "fixing"})
	public void TC98406_Rest_Claim_RequestType_when_payer_not_match() throws InterruptedException, java.text.ParseException,  Exception{

		// logger = extent.startTest("TC98406_Rest_Claim_RequestType_when_payer_not_match");

		Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
		
		JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
		claimSubobject.put(globalVariables.MatchingRule, "EqualOrGreaterThan");
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying response");
		
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.falseVisit);	

	}

	@Test(groups = {"All", "Regression", "fixing"})
	public void TC98406_Rest_Claim_RequestType_when_provider_not_match() throws InterruptedException, java.text.ParseException,  Exception{

		// logger = extent.startTest("TC98406_Rest_Claim_RequestType_when_payer_not_match");

		Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
		
		JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
		claimSubobject.put(globalVariables.ProviderID, CommonMethods.generateRandomNumberOfFixLength(7));
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying response");
		
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.falseVisit);	

	}

	@Test(groups = {"All", "Regression", "fixing"})
	public void TC98406_Rest_Claim_RequestType_when_Service_not_match() throws InterruptedException, java.text.ParseException,  Exception{
	
		// logger = extent.startTest("TC98406_Rest_Claim_RequestType_when_payer_not_match");

		Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
		
		JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
		claimSubobject.put(globalVariables.ProcedureCode, CommonMethods.generateRandomAlphaNumeric(5));
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying response");
		
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.falseVisit);	

	}

	@Test(groups = {"All", "Regression", "fixing"})
	public void TC98406_Rest_Claim_RequestType_when_units_not_match() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("TC98406_Rest_Claim_RequestType_when_payer_not_match");

		Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
		
		JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
		claimSubobject.put(globalVariables.Units, CommonMethods.generateRandomAlphaNumeric(1));
		claimSubobject.put(globalVariables.MatchingRule, "ExactMatch");
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying response");
		
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.falseVisit);	

	}
	
}
