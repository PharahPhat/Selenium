package Ohio.sandata.restclaim;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_4799_TC98397_TC98398_TC98399_validation_fields_formates extends BaseTest{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC98397_Rest_Claim_RequestType_field_formats_validation_blank() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98397_Rest_Claim_RequestType_field_formats_validation_blank");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.RequestType, "");
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.InvlaidRequesttypeerror);

	}
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC98397_Rest_Claim_RequestType_field_formats_validation_null() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98397_Rest_Claim_RequestType_field_formats_validation_null");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.RequestType, null);
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);

	}
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC98397_Rest_Claim_RequestType_field_formats_validation_invalid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98397_Rest_Claim_RequestType_field_formats_validation_invalid");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.RequestType, CommonMethods.generateRandomStringOfFixLength(7));
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.InvlaidRequesttypeerror);

	}
	
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC98398_Rest_Claim_ServiceStartDate_field_formats_validation_invalid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98398_Rest_Claim_ServiceStartDate_field_formats_validation_invalid");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.ServiceStartDate, CommonMethods.generatecurrentDate_YYYYMMdd());
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.dateformateerror);

	}
	
	
	@Test(groups = {"All", "Regression"})
	public void TC98398_Rest_Claim_ServiceStartDate_blank() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98398_Rest_Claim_ServiceStartDate_blank");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.ServiceStartDate, "");
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);

	}
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC98398_Rest_Claim_ServiceStartDate_null() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98398_Rest_Claim_ServiceStartDate_null");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.ServiceStartDate, null);
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidrecord);

	}
	

	@Test(groups = {"All", "Regression","fixing"})
	public void TC98399_Rest_Claim_ServiceEndDate_field_formats_validation_invalid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98399_Rest_Claim_ServiceEndDate_field_formats_validation_invalid");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.ServiceEndDate, CommonMethods.generatecurrentDate_YYYYMMdd());
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.dateformateerror);

	}
	
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC98398_Rest_Claim_ServiceEndDate_blank() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98398_Rest_Claim_ServiceEndDate_blank");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.ServiceEndDate, "");
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.dateformateerror);

	}
	
	
	

}
