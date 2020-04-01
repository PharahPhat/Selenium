package AltEVV_generic.restassured.sandata.Indiana.Visit;

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
import java.sql.SQLException;

public class R2267_TC95246_AltEVV_Visit_CallExternalID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void R2267_TC95246_Visit_CallExternalID_valid_numeric() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("R2267_TC7482_Visit_CallExternalID_valid");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.CallExternalIDjson, CommonMethods.generateRandomNumberOfFixLength(16));

		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95246_Visit_CallExternalID_Invalid_length() throws InterruptedException, IOException, ParseException{

		// logger = extent.startTest("R2267_TC7482_Visit_CallExternalID_valid");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.CallExternalIDjson, CommonMethods.generateRandomNumberOfFixLength(17));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallExternalIDLength_Error);
	}

	@Test(groups = {"All"})
	public void R2267_TC95246_Visit_CallExternalID_letter() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("R2267_TC7482_Visit_CallExternalID_letter");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.CallExternalIDjson, CommonMethods.generateRandomNumberOfFixLength(12));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.CallExternalIDjson, CommonMethods.generateRandomNumberOfFixLength(12));

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95246_Visit_CallExternalID_alphanumeric() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("R2267_TC7482_Visit_CallExternalID_valid");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.CallExternalIDjson, CommonMethods.generateRandomAlphaNumeric(10));

		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95246_Visit_CallExternalID_null() throws InterruptedException, IOException, ParseException, SQLException{

		// logger = extent.startTest("R2267_TC7482_Visit_CallExternalID_valid");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.CallExternalIDjson, null);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallExternalIDNullError);
	}
}