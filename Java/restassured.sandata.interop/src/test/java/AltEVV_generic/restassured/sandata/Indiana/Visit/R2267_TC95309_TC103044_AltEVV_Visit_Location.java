package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@MayankM

OpenEVV-altEVV- Visits- Location field formats/values

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
import java.sql.SQLException;

public class R2267_TC95309_TC103044_AltEVV_Visit_Location extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void R2267_TC95309_AltEVV_Location_numeric() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		
		// logger = extent.startTest("R2267_TC95309_AltEVV_Location_numeric");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		String location = CommonMethods.generateRandomNumberOfFixLength(25);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.CallTypejson,"MVV");
		jsonObjectVisitChanges.put(globalVariables.Locationjson,location);

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges.put(globalVariables.CallTypejson,"MVV");
		jsonObjectVisitChanges_call.put(globalVariables.Locationjson,location);

		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95309_AltEVV_Location_greaterThan_Max() throws InterruptedException, IOException, ParseException{

		// logger = extent.startTest("R2267_TC95309_Location_greaterThan_Max");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		String location = CommonMethods.generateRandomNumberOfFixLength(26);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.CallTypejson,"MVV");
		jsonObjectVisitChanges.put(globalVariables.Locationjson, location);

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges.put(globalVariables.CallTypejson,"MVV");
		jsonObjectVisitChanges_call.put(globalVariables.Locationjson, location);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.LocationLengthError);
	}

	@Test(groups = {"All"})
	public void R2267_TC95309_AltEVV_Location_specialChar() throws InterruptedException, IOException, ParseException {

		// logger = extent.startTest("R2267_TC95309_Location_specialChar");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		String location = CommonMethods.generateRandomStringOfFixLength(10) + "'" + "." + "'";
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.CallTypejson,"MVV");
		jsonObjectVisitChanges.put(globalVariables.Locationjson, location);

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges.put(globalVariables.CallTypejson,"MVV");
		jsonObjectVisitChanges_call.put(globalVariables.Locationjson, location);

		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95309_AltEVV_Location_Invalid_Blank() throws InterruptedException, IOException, ParseException{

		// logger = extent.startTest("R2267_TC95309_AltEVV_Location_optional");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.CallTypejson,"MVV");
		jsonObjectVisitChanges.put(globalVariables.Locationjson,"");

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.CallTypejson,"MVV");
		jsonObjectVisitChanges_call.put(globalVariables.Locationjson,"");

		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		}
}
