package AltEVV_generic.restassured.sandata.Indiana.Visit;


import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class R2267_TC91510_AltEVV_without_required_field extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Smoke"})
	public void R2267_TC91510_AltEVV_without_required_field_invalid() throws InterruptedException, IOException, ParseException{

		// logger = extent.startTest("R2267_TC91510_AltEVV_without_required_field_invalid");

		logger.log(LogStatus.INFO, "Validating R2267_TC91510_AltEVV_without_required_field_invalid");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCall1 = (JSONObject) jsonArrayVisitCalls.get(0);
		JSONObject jsonObjectVisitCall2 = (JSONObject) jsonArrayVisitCalls.get(1);

		jsonObjectVisit.put(globalVariables.VisitOtherIDjson, null);
		jsonObjectVisit.put(globalVariables.SequenceIDjson, null);
		jsonObjectVisit.put(globalVariables.EmployeeIdentifier, null);
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson, null);
		jsonObjectVisit.put(globalVariables.PayerIDjson, null);
		jsonObjectVisit.put(globalVariables.PayerProgramjson, null);
		jsonObjectVisit.put(globalVariables.ProcedureCodejson, null);
		jsonObjectVisitCall1.put(globalVariables.CallExternalIDjson, null);
		jsonObjectVisitCall1.put(globalVariables.CallAssignmentjson, null);
		jsonObjectVisitCall1.put(globalVariables.CallTypejson, null);
		jsonObjectVisitCall1.put(globalVariables.ClientIdentifierOnCalljson, null);
		jsonObjectVisit.put(globalVariables.VisitTimeZonejson, null);
		jsonObjectVisit.put(globalVariables.CallExternalIDjson, null);
		jsonObjectVisit.put(globalVariables.CallAssignmentjson, null);
		jsonObjectVisit.put(globalVariables.CallTypejson, null);
		jsonObjectVisit.put(globalVariables.ClientIdentifierOnCalljson, null);
		jsonObjectVisit.put(globalVariables.ChangeMadeByjson, null);
		jsonObjectVisit.put(globalVariables.ChangeDateTimejson,null);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get(globalVariables.VisitChanges);
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.ChangeDateTimejson, null);
		jsonObjectVisitChanges.put(globalVariables.ChangeReasonMemojson, null);


		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.VisitTimeZoneNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorVisitTimeZonelength);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.VisitCancelledIndicatorNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerProgramNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.VisitOtherIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.SequenceIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIdentifierNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ProcedureCodeError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallExternalIDNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallAssignmentNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallTypeNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIdentifierOnCallNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ChangeDateTimeNullError);
	}
}

