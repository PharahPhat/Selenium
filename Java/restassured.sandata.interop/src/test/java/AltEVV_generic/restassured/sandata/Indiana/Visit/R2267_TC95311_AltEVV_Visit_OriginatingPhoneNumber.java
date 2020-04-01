package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@MayankM

OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_formats_values

 */

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

public class R2267_TC95311_AltEVV_Visit_OriginatingPhoneNumber extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//validating OriginatingPhoneNumber invalid length
	@Test(groups = {"All"})
	public void R2267_TC95311_OpenEVV_AltEVV_Visits_OriginatingPhoneNumber_invalid_length() throws InterruptedException, IOException, ParseException {

		// logger = extent.startTest("R2267_TC95311_OpenEVV_AltEVV_Visits_OriginatingPhoneNumber_invalid_length");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.OriginatingPhoneNumberjson,
				CommonMethods.generateRandomNumberOfFixLength(20));
	
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.OriginatingPhoneNumberLengthError);
	}
	
	@Test(groups = {"All"})
	public void R2267_TC95311_OpenEVV_AltEVV_Visits_OriginatingPhoneNumber_invalid_length_multiple() throws InterruptedException, IOException, ParseException{

		// logger = extent.startTest("R2267_TC95311_OpenEVV_AltEVV_Visits_OriginatingPhoneNumber_invalid_length_multiple");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.OriginatingPhoneNumberjson, CommonMethods.generateRandomNumberOfFixLength(11));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.OriginatingPhoneNumberjson,
				CommonMethods.generateRandomNumberOfFixLength(11));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.OriginatingPhoneNumberLengthError);

	}

	//validating OriginatingPhoneNumber with blank value
	@Test(groups = {"All"})
	public void R2267_TC95311_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_blank() throws InterruptedException, IOException, ParseException{

		// logger = extent.startTest("R2267_TC95311_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_with_blank");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.CallTypejson, "Telephony");
		jsonObjectVisitCalls.put(globalVariables.OriginatingPhoneNumberjson, "");

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.CallTypejson, "Telephony");
		jsonObjectVisitCalls1.put(globalVariables.OriginatingPhoneNumberjson, "");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallTelephonenyError);
	}

	//validating OriginatingPhoneNumber with letters
	@Test(groups = {"All"})
	public void R2267_TC95311_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_letters() throws InterruptedException, IOException, ParseException{

		// logger = extent.startTest("R2267_TC95311_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_with_blank");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.OriginatingPhoneNumberjson, CommonMethods.generateRandomStringOfFixLength(10));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.OriginatingPhoneNumberjson, CommonMethods.generateRandomStringOfFixLength(10));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.OriginatingPhoneNumberFormatError);

	}

	//validating OriginatingPhoneNumber with alphanumeric
	@Test(groups = {"All"})
	public void R2267_TC95311_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_alphanumeric() throws InterruptedException, IOException, ParseException{

		// logger = extent.startTest("R2267_TC95311_OpenEVV_altEVV_Visits_OriginatingPhoneNumber_field_with_blank");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.OriginatingPhoneNumberjson, CommonMethods.generateRandomAlphaNumeric(10));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.OriginatingPhoneNumberjson, CommonMethods.generateRandomAlphaNumeric(10));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.OriginatingPhoneNumberFormatError);

	}
}



