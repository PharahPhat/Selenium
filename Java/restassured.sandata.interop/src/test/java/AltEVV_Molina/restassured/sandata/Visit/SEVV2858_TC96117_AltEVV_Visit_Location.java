package AltEVV_Molina.restassured.sandata.Visit;

/*
@MayankM

OpenEVV-altEVV- Visits- Location field formats/values

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

import static com.globalMethods.core.globalVariables.LocationFormatError;
import static com.globalMethods.core.globalVariables.LocationLengthError;

public class SEVV2858_TC96117_AltEVV_Visit_Location extends BaseTest { 
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void SEVV2858_TC96117_AltEVV_Location_numeric() throws IOException, ParseException {
		
		// logger = extent.startTest("SEVV2858_TC96117_AltEVV_Location_numeric");

		String Location=CommonMethods.generateRandomNumberOfFixLength(10);
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.Locationjson,Location);

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.Locationjson, Location);

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96117_AltEVV_Location_greaterThan_Max() throws IOException, ParseException {

		// logger = extent.startTest("SEVV2858_TC96117_Location_greaterThan_Max");
 
		String Location= CommonMethods.generateRandomNumberOfFixLength(26);
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.Locationjson,Location);

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.Locationjson,Location);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, LocationLengthError);

	
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96117_AltEVV_Location_AlphaNumeric() throws IOException, ParseException {
		// logger = extent.startTest("SEVV2858_TC96117_Location_AlphaNumeric");

		String Location= CommonMethods.generateRandomAlphaNumeric(10);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.Locationjson,Location);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.Locationjson,Location);

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.Locationjson, Location);

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96117_AltEVV_Location_null() throws IOException, ParseException {
		// logger = extent.startTest("SEVV2858_TC96117_Location_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.Locationjson, "NULL");

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.Locationjson, "NULL");

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96117_AltEVV_Location_specialChar() throws IOException, ParseException {
 
		String Location=CommonMethods.generateRandomStringOfFixLength(10) + "'" + "." + "'";
		
		// logger = extent.startTest("SEVV2858_TC96117_Location_specialChar");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.Locationjson,Location);

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.Locationjson,Location);

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96117_AltEVV_Location_optional() throws IOException, ParseException {

		// logger = extent.startTest("SEVV2858_TC96117_AltEVV_Location_optional");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.Locationjson,"");

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.Locationjson,"");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, LocationFormatError);

	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96117_AltEVV_Location_letters() throws IOException, ParseException {
		// logger = extent.startTest("SEVV2858_TC96117_AltEVV_Location_letters");

		String Location=CommonMethods.generateRandomStringOfFixLength(10);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.Locationjson,Location);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.Locationjson,Location);

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.Locationjson,Location);

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

}
