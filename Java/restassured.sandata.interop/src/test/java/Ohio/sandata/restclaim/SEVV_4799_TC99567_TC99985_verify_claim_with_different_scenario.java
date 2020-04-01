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

public class SEVV_4799_TC99567_TC99985_verify_claim_with_different_scenario extends BaseTest{
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();

	@Test(groups = {"All", "Regression","fixing"})
		public void TC99567_Rest_Claim_RequestType_verify_when_matchingrule_EqualOrGreaterThan() throws InterruptedException, java.text.ParseException,  Exception{
			
			// logger = extent.startTest("TC99567_Rest_Claim_RequestType_verify_when_matchingrule_EqualOrGreaterThan");

			Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
			
			JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
			JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
			claimSubobject.put(globalVariables.MatchingRule, "EqualOrGreaterThan");
			logger.log(LogStatus.INFO,"Veirfying the value in  response");
			String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
			
			logger.log(LogStatus.INFO,"Veirfying the database");
			
			Assertion_DbVerifier.claim_assertion(bodyAsString, MapjsonObject);
			CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.recordFound);

		}


	@Test(groups = {"All", "Regression","fixing"})
		public void TC99985_Rest_Claim_verify_cronologicaly_process_of_claim() throws InterruptedException, java.text.ParseException,  Exception{

			Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
		 
				JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
				JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
				String patinetMid=  MapjsonObject.get("visit").get("PatientMedicaidID").toString();
				String staffid=  MapjsonObject.get("visit").get("StaffOtherID").toString();
				String patientotherid=  MapjsonObject.get("visit").get("PatientOtherID").toString();
				
				//second visit creation
		        Map<String, JSONObject> MapjsonObjectsecond=GenerateUniqueParam.ohioclaim_Rest_multiple(patinetMid,staffid,patientotherid );
				
				JSONArray claimSubArraysecond= (JSONArray) MapjsonObjectsecond.get("rest").get("EVV_Request");
				JSONObject claimSubobjectsecond =  (JSONObject) claimSubArraysecond.get(0);
			
				logger.log(LogStatus.INFO,"Veirfying the value in  response");
				
				String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
				
				logger.log(LogStatus.INFO,"Veirfying first visit claim response");
				Assertion_DbVerifier.claim_assertion(bodyAsString, MapjsonObject);
				//Assertion_DbVerifier.claim_assertion_dual(bodyAsString, MapjsonObjectsecond);
				
				logger.log(LogStatus.INFO,"Verify Second visit claim");
				String bodyAsStringsecond= CommonMethods.captureResponseClaim(MapjsonObjectsecond.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
				Assertion_DbVerifier.claim_assertion(bodyAsStringsecond, MapjsonObjectsecond);
				
				CommonMethods.CapterrestclaimResponse(bodyAsStringsecond,globalVariables.recordFound);
		
				logger.log(LogStatus.INFO,"re claim first  visit");
				claimSubobject.put(globalVariables.batchid,CommonMethods.generateRandomNumberOfFixLength(10));
				
				String bodyAsStringthird= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
				logger.log(LogStatus.INFO,"Veirfying first  visit claim second time");
				Assertion_DbVerifier.claim_assertion(bodyAsStringthird, MapjsonObject);
				
				CommonMethods.CapterrestclaimResponse(bodyAsStringthird,globalVariables.recordFound);
				
				logger.log(LogStatus.INFO,"re claim second  visit");
				claimSubobjectsecond.put(globalVariables.batchid,CommonMethods.generateRandomNumberOfFixLength(10));
				String bodyAsStringfourth= CommonMethods.captureResponseClaim(MapjsonObjectsecond.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
				logger.log(LogStatus.INFO,"Veirfying socond  visit claim second time");
				Assertion_DbVerifier.claim_assertion(bodyAsStringfourth, MapjsonObjectsecond);
				
				CommonMethods.CapterrestclaimResponse(bodyAsStringfourth,globalVariables.recordFound);
		}
	

}
