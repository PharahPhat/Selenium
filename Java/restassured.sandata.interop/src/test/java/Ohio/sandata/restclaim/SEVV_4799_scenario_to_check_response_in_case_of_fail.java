package Ohio.sandata.restclaim;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_4799_scenario_to_check_response_in_case_of_fail extends BaseTest {
	
GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression", "fixing"})
	public void SEVV_4799_scenario_to_check_response_in_case_of_fail_claim() throws InterruptedException, java.text.ParseException,  Exception{
		// logger = extent.startTest("TC98397_Rest_Claim_RequestType_field_formats_validation_blank");

		JSONArray jsonArray=GenerateUniqueParam.ohioclaim_Rest_fail();
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray claimSubArray= (JSONArray) jsonObject.get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);	
		claimSubobject.put(globalVariables.RequestType, "");
		
		logger.log(LogStatus.INFO,"Veirfying the value in  response");
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObject, CommonMethods.propertyfileReader("Rest_claim"));
		CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.InvlaidRequesttypeerror);
	
		
		JSONParser parser = new JSONParser(); 
		JSONObject json = (JSONObject) parser.parse(bodyAsString);
		JSONObject json1 = (JSONObject) parser.parse(json.get("data").toString());
		JSONArray json2= (JSONArray) json1.get("EVV_Response");
		JSONObject json2Object = (JSONObject) json2.get(0);
		System.out.println(json2Object.get("BatchID"));
		CommonMethods.CapterrestclaimResponse_value(claimSubobject,json2Object,json1);
		

	}

}
