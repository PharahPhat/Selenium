package Ohio.sandata.restclaim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_4799_TC98978_TC99338_TC99598_Rest_validation_formate__fileds_values extends BaseTest {
	
	
GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();


	@Test(groups = {"All", "Regression", "fixing"})
	public void TC98978_Rest_Claim_Units_field_formats_validation_blank() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98978_Rest_Claim_Units_field_formats_validation_blank");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.Units, "");
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);

	}

	@Test(groups = {"All", "Regression", "fixing"})
	public void TC98978_Rest_Claim_Units_field_null() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98978_Rest_Claim_Units_field_null");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.Units, null);
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);

	}

	@Test(groups = {"All", "Regression", "fixing"})
	public void TC99338_Rest_Claim_ServiceEndDate_null() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99338_Rest_Claim_ServiceEndDate_null");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.ServiceEndDate, null);
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.noVisitError);

	}


	@Test(groups = {"All", "Regression", "fixing"})
	public void TC99598_Rest_Claim_payer_null() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99598_Rest_Claim_payer_null");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.payer, null);
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);

	}


	@Test(groups = {"All", "Regression", "fixing"})
	public void TC99598_Rest_Claim_payer_morethanallowed_length() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99598_Rest_Claim_payer_morethanallowed_length");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.payer, CommonMethods.generateRandomStringOfFixLength(65));
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse_invalid(bodyAsString,globalVariables.PayerLengthError);
	}

	@Test(groups = {"All", "Regression", "fixing"})
	public void TC99598_Rest_Claim_payer_blank() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99598_Rest_Claim_payer_blank");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.payer, "");
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);

	}
}
