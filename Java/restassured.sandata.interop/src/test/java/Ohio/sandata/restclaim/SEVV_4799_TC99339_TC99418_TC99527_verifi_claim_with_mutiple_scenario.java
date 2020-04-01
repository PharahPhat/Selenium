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

public class SEVV_4799_TC99339_TC99418_TC99527_verifi_claim_with_mutiple_scenario extends BaseTest{
	
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();

	@Test(groups = {"All", "Regression","fixing"})
	public void TC99339_Rest_Claim_RequestType_verify_records_found() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("TC99339_Rest_Claim_RequestType_verify_records_found");

		Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
		
		JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
		claimSubobject.put(globalVariables.MatchingRule, "EqualOrGreaterThan");
		claimSubobject.put(globalVariables.payer,"ODMRTYUSWERTY");
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying the database");
		
		Assertion_DbVerifier.claim_assertion(bodyAsString, MapjsonObject);
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.recordFound);

	}

	@Test(groups = {"All", "Regression","fixing"})
	public void TC99418_Rest_Claim_RequestType_verify_service_start_end_date_not_null() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("TC99418_Rest_Claim_RequestType_verify_service_start_end_date_not_null");

		Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
		
		JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
		claimSubobject.put(globalVariables.MatchingRule, "EqualOrGreaterThan");
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying the database");
		
		Assertion_DbVerifier.claim_assertion(bodyAsString, MapjsonObject);
		CommonMethods.CapterrestclaimResponse_invalid(bodyAsString,globalVariables.nullservicestartdate);
		CommonMethods.CapterrestclaimResponse_invalid(bodyAsString,globalVariables.nullserviceenddate);
	

	}

	@Test(groups = {"All", "Regression","fixing"})
	public void TC99339_Rest_Claim_RequestType_withsame_ICN_DLN() throws InterruptedException, java.text.ParseException,  Exception{
		
		// logger = extent.startTest("TC99339_Rest_Claim_RequestType_withsame_ICN_DLN");

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
	

	}
		

}
