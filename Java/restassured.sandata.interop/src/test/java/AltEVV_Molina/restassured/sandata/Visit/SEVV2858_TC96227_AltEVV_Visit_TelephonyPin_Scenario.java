package AltEVV_Molina.restassured.sandata.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SEVV2858_TC96227_AltEVV_Visit_TelephonyPin_Scenario extends BaseTest { 
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void SEVV2858_TC96227_Visit_TelephonyPin_valid_numeric_between_4_9() throws IOException, ParseException {

		// logger = extent.startTest("SEVV2858_TC96227_Visit_TelephonyPin_valid_numeric_between_4_9");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCall = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCall =  (JSONObject) jsonArrayVisitCall.get(0);
		jsonObjectVisitCall.put("CallType", "Telephony");

		jsonObjectVisitCall.put(globalVariables.TelephonyPinjson, CommonMethods.generateRandomNumberOfFixLength(6));

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96227_Visit_TelephonyPin_blank() throws IOException, ParseException, InterruptedException {

		// logger = extent.startTest("SEVV2858_TC96227_Visit_TelephonyPin_blank");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCall =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitCall.put("CallType", "Telephony");
		jsonObjectVisitCall.put(globalVariables.TelephonyPinjson, "");

		 CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96227_Visit_TelephonyPin_null() throws IOException, ParseException {

		// logger = extent.startTest("SEVV2858_TC96227_Visit_TelephonyPin_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCall =  (JSONObject) jsonArrayVisitCalls.get(0);

		jsonObjectVisitCall.put(globalVariables.TelephonyPinjson, null);
		jsonObjectVisitCall.put("CallType", "Telephony");
		JSONObject jsonObjectVisitCall1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCall1.put("CallType", "Telephony");
		jsonObjectVisitCall1.put(globalVariables.TelephonyPinjson, null);
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.OriginatingPhoneNumberNullError);
	
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96227_Visit_TelephonyPin_alphanumeric() throws IOException, ParseException, InterruptedException {

		// logger = extent.startTest("SEVV2858_TC96227_Visit_TelephonyPin_alphanumeric");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCall =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitCall.put("CallType", "Telephony");
		jsonObjectVisitCall.put(globalVariables.TelephonyPinjson, CommonMethods.generateRandomAlphaNumeric(9));

		CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}
}