package Ohio.sandata.restclaim;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_4799_TC98982_TC98981_TC98980_Rest_Claim_formate_vlaidation_modifier extends BaseTest{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	

	@Test(groups = {"All", "Regression","fixing"})
	public void TC98980_Rest_Claim_modifier2_field_formats_validation_morethanallwed_length() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98402_Rest_Claim_modifier1_field_formats_validation_morethanallwed_length");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.Modifier2, CommonMethods.generateRandomStringOfFixLength(3));
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.modifierinvalid);

	}
	
	
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC98981_Rest_Claim_modifier3_field_formats_validation_morethanallwed_length() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98402_Rest_Claim_modifier1_field_formats_validation_morethanallwed_length");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.Modifier3, CommonMethods.generateRandomStringOfFixLength(3));
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.modifierinvalid);

	}
	
	@Test(groups = {"All", "Regression","fixing"})
	public void TC98982_Rest_Claim_modifier4_field_formats_validation_morethanallwed_length() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98402_Rest_Claim_modifier1_field_formats_validation_morethanallwed_length");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);

		claimSubobject.put(globalVariables.Modifier4, CommonMethods.generateRandomStringOfFixLength(3));
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.modifierinvalid);

	}
	

}
