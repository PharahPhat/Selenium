package Ohio.sandata.restclaim;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_4799_TC98404_TC_98402_TC98400_TC99664_validation_fields_formates extends BaseTest{
	
GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();


	@Test(groups = {"All", "Regression", "fixing"})
	public void TC98400_Rest_Claim_Unitrules_field_formats_validation_blank() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98400_Rest_Claim_Unitrules_field_formats_validation_blank");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.UnitsRule, "");
		claimSubobject.put(globalVariables.RequestType, "Model2");
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidunitrulerecord);

	}


	@Test(groups = {"All", "Regression", "fixing"})
	public void TC98400_Rest_Claim_Unitrules_field_formats_validation_null() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98400_Rest_Claim_Unitrules_field_formats_validation_null");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.UnitsRule, null);
		claimSubobject.put(globalVariables.RequestType, "Model2");
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.nullunitrulerecord);


	}

	@Test(groups = {"All", "Regression", "fixing"})
	public void TC98400_Rest_Claim_Unitrules_field_formats_validation_invalid() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98400_Rest_Claim_Unitrules_field_formats_validation_null");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.UnitsRule, CommonMethods.generateRandomStringOfFixLength(8));
		claimSubobject.put(globalVariables.RequestType, "Model2");
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidunitrulerecord);


	}

	@Test(groups = {"All", "Regression", "fixing"})
	public void TC98402_Rest_Claim_modifier1_field_formats_validation_morethanallwed_length() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98402_Rest_Claim_modifier1_field_formats_validation_morethanallwed_length");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.Modifier1, CommonMethods.generateRandomStringOfFixLength(3));
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.modifierinvalid);

	}



	@Test(groups = {"All", "Regression", "fixing"})
	public void TC98404_Rest_Claim_Servicestartdate_field_lessthan_enddate() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98404_Rest_Claim_Servicestartdate_field_lessthan_enddate");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.ServiceStartDate, CommonMethods.generatecurrentDate_YYYY_MM_dd());
		claimSubobject.put(globalVariables.ServiceEndDate, CommonMethods.generatePastDate_YYYY_MM_dd());
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidEnddate);


	}

	@Test(groups = {"All", "Regression", "fixing"})
	public void TC99664_Rest_Claim_Servicestartdate_enddate_morethan_31_days() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC99664_Rest_Claim_Servicestartdate_enddate_morethan_31_days");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.ServiceStartDate, "2019-01-16");
		claimSubobject.put(globalVariables.ServiceEndDate, "2019-02-18");
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.invalidgapdate);


	}
	
	
	

}
