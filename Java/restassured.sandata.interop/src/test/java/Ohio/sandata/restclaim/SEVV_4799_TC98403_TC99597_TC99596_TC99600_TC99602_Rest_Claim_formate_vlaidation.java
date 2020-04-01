package Ohio.sandata.restclaim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_4799_TC98403_TC99597_TC99596_TC99600_TC99602_Rest_Claim_formate_vlaidation  extends BaseTest{

	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	

	@Test(groups = {"All", "Regression","fixing"})
	public void TC98403_Rest_Claim_MatchingRule_field_formats_validation() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98403_Rest_Claim_MatchingRule_field_formats_validation");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.MatchingRule, "");
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidmatchingrulerecord);


	}

	@Test(groups = {"All", "Regression","fixing"})
	public void TC98403_Rest_Claim_MatchingRule_field_formats_validation_null() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98403_Rest_Claim_MatchingRule_field_formats_validation_null");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.MatchingRule, null);
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.nullmatchingrulerecord);


	}

	@Test(groups = {"All", "Regression","fixing"})
	public void TC98403_Rest_Claim_MatchingRule_field_formats_validation_otherthanvalid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98403_Rest_Claim_MatchingRule_field_formats_validation_otherthanvalid");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.MatchingRule, CommonMethods.generateRandomStringOfFixLength(10));
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidmatchingrulerecord);

	}
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC99597_Rest_Claim_transactionid_field_formats_validation_morethan_allowed_length() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99597_Rest_Claim_transactionid_field_formats_validation_morethan_allowed_length");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.transactionid, CommonMethods.generateRandomNumberOfFixLength(20));
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);
		
	}
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC99597_Rest_Claim_transactionid_field_formats_validation_alphanumeric() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99597_Rest_Claim_transactionid_field_formats_validation_alphanumeric");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.transactionid, CommonMethods.generateRandomAlphaNumeric(12));
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);
		
	}
	@Test(groups = {"All", "Regression","fixing"})
	public void TC99597_Rest_Claim_transactionid_field_formats_validation_blank() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99597_Rest_Claim_transactionid_field_formats_validation_blank");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.transactionid, " ");
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);
		
	}
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC99597_Rest_Claim_transactionid_field_formats_validation_null() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99597_Rest_Claim_transactionid_field_formats_validation_null");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.transactionid, null);
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);
		
	}
	@Test(groups = {"All", "Regression","fixing"})
	public void TC99597_Rest_Claim_transactionid_field_formats_validation_leading_space() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99597_Rest_Claim_transactionid_field_formats_validation");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.transactionid, " " +CommonMethods.generateRandomNumberOfFixLength(15));

		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);
		
	}
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC99597_Rest_Claim_transactionid_field_formats_validation_tariling_space() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99597_Rest_Claim_transactionid_field_formats_validation_tariling_space");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.transactionid, CommonMethods.generateRandomNumberOfFixLength(12)+ " ");
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);
		
	}

	@Test(groups = {"All", "Regression","fixing"})
	public void TC99596_Rest_Claim_Batchid_field_formats_validation() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99596_Rest_Claim_Batchid_field_formats_validation");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.batchid, CommonMethods.generateRandomNumberOfFixLength(51));
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidMaxlengthBatchID);
		

	}


	@Test(groups = {"All", "Regression","fixing"})
	public void TC99596_Rest_Claim_Batchid_field_formats_validation_null() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99596_Rest_Claim_Batchid_field_formats_validation_null");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.batchid, null);
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidbatchrecord);
		

	}

	@Test(groups = {"All", "Regression","fixing"})
	public void TC99596_Rest_Claim_Batchid_field_formats_validation_blank() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99596_Rest_Claim_Batchid_field_formats_validation_blank");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.batchid, "");
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidbatchrecord);
		

	}

	@Test(groups = {"All", "Regression","fixing"})
	public void TC99596_Rest_Claim_Batchid_field_formats_validation_string() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99596_Rest_Claim_Batchid_field_formats_validation");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.batchid, CommonMethods.generateRandomAlphaNumeric(13));
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.batchid);
		

	}

	@Test(groups = {"All", "Regression","fixing"})
	public void TC99596_Rest_Claim_Batchid_field_formats_leading_space() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99596_Rest_Claim_Batchid_field_formats_validation");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.batchid, " " +CommonMethods.generateRandomNumberOfFixLength(12));
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.batchid);
		

	}
	

	@Test(groups = {"All", "Regression","fixing"})
	public void TC99600_Rest_Claim_ICN_field_formats_validation_morethan_allowed() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99600_Rest_Claim_ICN_field_formats_validation_morethan_allowed");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.icnnumber,CommonMethods.generateRandomNumberOfFixLength(14) );
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.ICNerrorrecord);


	}
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC99600_Rest_Claim_ICN_field_formats_blank() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99600_Rest_Claim_ICN_field_formats_blank");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.icnnumber,"" );
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);


	}
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC99600_Rest_Claim_ICN_field_formats_null() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99600_Rest_Claim_ICN_field_formats_null");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.icnnumber, null);
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);


	}
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC99600_Rest_Claim_ICN_field_formats_otherthan_numeric() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99600_Rest_Claim_ICN_field_formats_otherthan_numeric");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.icnnumber, CommonMethods.generateRandomStringOfFixLength(13));
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.icnnumber);


	}
	
	@Test(groups = {"All", "Regression"})
	public void TC99600_Rest_Claim_DLN_field_formats_validation_morethan_allowed() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99600_Rest_Claim_ICN_field_formats_validation_morethan_allowed");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.dlnnumber,CommonMethods.generateRandomNumberOfFixLength(3) );
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.Dlnerrorrecord);


	}
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC99600_Rest_Claim_DLN_field_formats_blank() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99600_Rest_Claim_ICN_field_formats_blank");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.dlnnumber,"" );
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);


	}
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC99600_Rest_Claim_DLN_field_formats_null() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99600_Rest_Claim_ICN_field_formats_null");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.dlnnumber, null);
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);


	}
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC99600_Rest_Claim_DLN_field_formats_otherthan_numeric() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99600_Rest_Claim_ICN_field_formats_otherthan_numeric");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.dlnnumber, CommonMethods.generateRandomStringOfFixLength(2));
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.Dlnerrorrecord);


	}

}
