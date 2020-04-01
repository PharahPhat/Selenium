package AltEVV_Molina.restassured.sandata.Visit;

/*
@MayankM

OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_formats_values

 */

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SEVV2858_TC96224_AltEVV_Visit_OriginatingPhoneNumber extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//validating OriginatingPhoneNumber invalid length
	@Test(groups = {"All"})
	public void SEVV2858_TC96224_OpenEVV_AltEVV_Visits_OriginatingPhoneNumber_invalid_length() throws IOException, ParseException {

		// logger = extent.startTest("SEVV2858_TC96224_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put("CallType", "Telephony");
		jsonObjectVisitCalls.put(globalVariables.OriginatingPhoneNumberjson, CommonMethods.generateRandomNumberOfFixLength(11));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.OriginatingPhoneNumberjson, CommonMethods.generateRandomNumberOfFixLength(11));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.OriginatingPhoneNumberLengthError);

	}

	//validating OriginatingPhoneNumber with blank value
	@Test(groups = {"All"})
	public void SEVV2858_TC96224_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_blank() throws IOException, ParseException {

		// logger = extent.startTest("SEVV2858_TC96224_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_with_blank");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put("CallType", "Telephony");
		jsonObjectVisitCalls.put(globalVariables.OriginatingPhoneNumberjson, "");

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.OriginatingPhoneNumberjson, "");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.OriginatingPhoneNumberNullError);
	}

	//validating OriginatingPhoneNumber with letters
	@Test(groups = {"All"})
	public void SEVV2858_TC96224_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_letters() throws IOException, ParseException {

		// logger = extent.startTest("SEVV2858_TC96224_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_with_blank");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put("CallType", "Telephony");
		jsonObjectVisitCalls.put(globalVariables.OriginatingPhoneNumberjson, CommonMethods.generateRandomStringOfFixLength(10));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.OriginatingPhoneNumberjson, CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.OriginatingPhoneNumberFormatError);

	}

	//validating OriginatingPhoneNumber with alphanumeric
	@Test(groups = {"All"})
	public void SEVV2858_TC96224_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_alphanumeric() throws IOException, ParseException {

		// logger = extent.startTest("SEVV2858_TC96224_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_with_blank");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put("CallType", "Telephony");
		jsonObjectVisitCalls.put(globalVariables.OriginatingPhoneNumberjson, CommonMethods.generateRandomAlphaNumeric(10));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.OriginatingPhoneNumberjson, CommonMethods.generateRandomAlphaNumeric(10));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.OriginatingPhoneNumberFormatError);

	}

	//validating OriginatingPhoneNumber with null
	@Test(groups = {"All"})
	public void SEVV2858_TC96224_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_null() throws IOException, ParseException {

		// logger = extent.startTest("SEVV2858_TC96224_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_with_blank");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);

		jsonObjectVisitCalls.put("CallType", "Telephony");
		jsonObjectVisitCalls.put(globalVariables.OriginatingPhoneNumberjson, null);

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.OriginatingPhoneNumberjson, null);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.OriginatingPhoneNumberNullError);
	}
}



