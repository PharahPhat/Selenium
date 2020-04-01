package Ohio.sandata.restclaim;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.Map;

public class SEVV_4799_TC98377_TC98376_TC98451_TC_98450_Verfiy_claim_processessing extends BaseTest{
	
GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();

	@Test(groups = {"All", "Regression", "fixing"})
    public void TC98377_Rest_Claim_RequestType_new_CN_DLN_service_T1001() throws Exception {
		
		// logger = extent.startTest("TC98377_Rest_Claim_RequestType_new_CN_DLN_service_T1001");

		Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest_with_changes("T1001");
		
		JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying the database");
		
		Assertion_DbVerifier.claim_assertion(bodyAsString, MapjsonObject);	

	}


    @Test(groups = {"All", "Regression", "fixing"})
    public void TC98450_Rest_Claim_RequestType_if_visit_not_processed_verfied() throws Exception {
		
		// logger = extent.startTest("TC98450_Rest_Claim_RequestType_if_visit_not_processed_verfied");

		
		Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
		
		JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying the database");
		
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.falseVisit);
		

	}

    @Test(groups = {"All", "Regression", "fixing"})
    public void TC98377_Rest_Claim_RequestType_new_CN_DLN_service_otherthan_T1001() throws Exception {
	
		// logger = extent.startTest("TC98377_Rest_Claim_RequestType_new_CN_DLN_service_otherthan_T1001");

	
		Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
		
		JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying the database");
		System.out.println("Body as string is:" + bodyAsString);

		Assertion_DbVerifier.claim_assertion(bodyAsString, MapjsonObject);	
		
		

	}


    @Test(groups = {"All", "Regression", "Uat", "fixing"})
    public void TC98451_Rest_Claim_visit_verfied_processed() throws Exception {
		
		// logger = extent.startTest("TC98397_Rest_Claim_RequestType_field_formats_validation_blank");

		Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();
		
		JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		
		String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying the database");
		
		Assertion_DbVerifier.claim_assertion(bodyAsString, MapjsonObject);	
		
		logger.log(LogStatus.INFO,"Sending same data to re-process the claim");
		
		JSONArray claimSubArrayrepeat= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobjectrepeat =  (JSONObject) claimSubArrayrepeat.get(0);
		claimSubobjectrepeat.put(globalVariables.batchid,CommonMethods.generateRandomNumberOfFixLength(10));
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsStringrepeat= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
		
		logger.log(LogStatus.INFO,"Veirfying the database");
		
		Assertion_DbVerifier.claim_assertion(bodyAsStringrepeat, MapjsonObject);	
		
		

	}
	

}
