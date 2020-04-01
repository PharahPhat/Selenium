package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class R2267_TC95302_AltEVV_Visit_CallAssignment extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void R2267_TC95302_Visit_CallAssignment_TimeIn_TimeOut() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("R2267_TC7484_Visit_CallAssignment_TimeIn_TimeOut");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);	

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.CallAssignmentjson, "Time In");

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.CallAssignmentjson, "Time Out");

		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95302_Visit_CallAssignment_invalid_format() throws InterruptedException, IOException, ParseException{

		// logger = extent.startTest("R2267_TC7484_Visit_CallAssignment_TimeIn_TimeOut");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");

		JSONObject jsonObjectVisitChangesOt =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChangesOt.put(globalVariables.CallAssignmentjson, CommonMethods.getSaltString(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallAssignmentError);
	}

	@Test(groups = {"All"})
	public void R2267_TC95302_Visit_CallAssignment_invalid_length() throws InterruptedException, IOException, ParseException{

		// logger = extent.startTest("R2267_TC7484_Visit_CallAssignment_TimeIn_TimeOut");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");

		JSONObject jsonObjectVisitChangesOt =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChangesOt.put(globalVariables.CallAssignmentjson, CommonMethods.getSaltString(11));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallAssignmentError);
	}
}

