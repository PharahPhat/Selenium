package Ohio.sandata.restclaim;

import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_4799_scenario_to_check_response_for_time_zone_servicedate  extends BaseTest{

	
GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();


	@Test(groups = {"All", "Regression", "fixing"})
public void SEVV_4799_scenario_to_check_response_for_time_zone_servicedate_result() throws InterruptedException, java.text.ParseException,  Exception{
	
	// logger = extent.startTest("SEVV_4799_scenario_to_check_response_for_time_zone_servicedate");

Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();

	JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
	JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
	
	String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));
	
	logger.log(LogStatus.INFO,"Veirfying response in db");
	
	Assertion_DbVerifier.claim_assertion(bodyAsString, MapjsonObject);
	CommonMethods.CapterrestclaimResponse(bodyAsString,globalVariables.recordFound);
	JSONParser parser = new JSONParser(); 
	JSONObject json = (JSONObject) parser.parse(bodyAsString);
	JSONObject json1 = (JSONObject) parser.parse(json.get("data").toString());
	JSONArray json2= (JSONArray) json1.get("EVV_Response");
	JSONObject json2Object = (JSONObject) json2.get(0);
	System.out.println(json2Object.get("BatchID"));
	CommonMethods.CapterrestclaimResponse_value_pass(claimSubobject,json2Object);

}

}
