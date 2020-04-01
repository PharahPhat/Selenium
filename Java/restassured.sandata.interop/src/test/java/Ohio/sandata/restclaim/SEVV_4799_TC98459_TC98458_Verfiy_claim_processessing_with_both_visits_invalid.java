package Ohio.sandata.restclaim;

import static org.junit.Assert.assertEquals;

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

public class SEVV_4799_TC98459_TC98458_Verfiy_claim_processessing_with_both_visits_invalid extends BaseTest{
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();


	@Test(groups = {"All", "Regression", "fixing"})
	public void TC98459_Rest_Claim_verify_record_count_if_mutiple_visit() throws InterruptedException, java.text.ParseException,  Exception{

		
		// logger = extent.startTest("TC98459_Rest_Claim_verify_record_count_if_mutiple_visit");

		Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
		
		JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
		JSONArray claimSubArraynew= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobjectnew =  (JSONObject) claimSubArray.get(0);
		

		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying response");
		Assertion_DbVerifier.claim_assertion(bodyAsString, MapjsonObject);
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.recordFound);	

	}


	@Test(groups = {"All", "Regression", "fixing"})
	public void TC98458_Rest_Claim_verify_for_sequential_claim_if_already_processed() throws InterruptedException, java.text.ParseException,  Exception{
		String Callin="c",  callout="a",valuecallin="b",valuecallout = "a";
		
		// logger = extent.startTest("TC98458_Rest_Claim_verify_for_sequential_claim_if_already_processed");

		Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
		
		JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
	//	String vsistidclaim=  MapjsonObject.get("VisitKey").toString();
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying response");
		Assertion_DbVerifier.claim_assertion(bodyAsString, MapjsonObject);
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.recordFound);
		
		
		//create and process second visit
        Map<String, JSONObject> MapjsonObjectsecond=GenerateUniqueParam.ohioclaim_Rest();
		
		JSONArray claimSubArraysecond= (JSONArray) MapjsonObjectsecond.get("rest").get("EVV_Request");
		JSONObject claimSubobjectsecond =  (JSONObject) claimSubArraysecond.get(0);
		claimSubobjectsecond.put(globalVariables.batchid,CommonMethods.generateRandomNumberOfFixLength(10));	

		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsStringsecond= CommonMethods.captureResponseClaim(MapjsonObjectsecond.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying response");
		Assertion_DbVerifier.claim_assertion(bodyAsStringsecond, MapjsonObjectsecond);
		CommonMethods.CapterrestclaimResponse(bodyAsStringsecond,globalVariables.recordFound);
		
		//create and process third visit
		 Map<String, JSONObject> MapjsonObjectthird=GenerateUniqueParam.ohioclaim_Rest();
			
			JSONArray claimSubArraythird= (JSONArray) MapjsonObjectthird.get("rest").get("EVV_Request");
			JSONObject claimSubobjectthird =  (JSONObject) claimSubArraythird.get(0);
			
			logger.log(LogStatus.INFO,"Veirfying the value in  response");
			String bodyAsStringthird= CommonMethods.captureResponseClaim(MapjsonObjectthird.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
			logger.log(LogStatus.INFO,"Veirfying response");
			Assertion_DbVerifier.claim_assertion(bodyAsStringthird, MapjsonObjectthird);
			CommonMethods.CapterrestclaimResponse(bodyAsStringthird,globalVariables.recordFound);
			
			//process claim again for processed visit.
			
			claimSubArraythird= (JSONArray) MapjsonObjectthird.get("rest").get("EVV_Request");
			claimSubobjectthird =  (JSONObject) claimSubArraythird.get(0);
				
			System.out.println(claimSubobjectthird.put(globalVariables.batchid,CommonMethods.generateRandomNumberOfFixLength(10)));
			
			
			logger.log(LogStatus.INFO,"Veirfying the value in  response");
			String bodyAsStringfourth= CommonMethods.captureResponseClaim(MapjsonObjectthird.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
			//String vsistidclaim1=  MapjsonObjectthird.get("rest").get("VisitKey").toString();
			
			logger.log(LogStatus.INFO,"Veirfying response");
			Assertion_DbVerifier.claim_assertion(bodyAsStringfourth, MapjsonObjectthird);
			CommonMethods.CapterrestclaimResponse(bodyAsStringfourth,globalVariables.recordFound);
			
			
			

	}

}
