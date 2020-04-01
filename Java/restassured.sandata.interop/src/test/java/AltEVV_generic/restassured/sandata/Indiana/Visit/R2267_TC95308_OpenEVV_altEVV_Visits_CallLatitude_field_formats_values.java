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

/*Ravi Ranjan*/

public class R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
		@Test(groups = {"All"})
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_90() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
			
			// logger = extent.startTest("R2267_TC7490_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_90");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			

			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLatitudejson, "-90");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLatitudejson, "-90");

			CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		}

		@Test(groups = {"All"})
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_90() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

			// logger = extent.startTest("R2267_TC7490_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_90");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLatitudejson, "90");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLatitudejson, "90");

			CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		}

		@Test(groups = {"All"})
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_plus() throws InterruptedException, IOException, ParseException, SQLException{
			// logger = extent.startTest("R2267_TC7490_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_plus");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLatitudejson, "200");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLatitudejson, "200");

			String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallLatitudeMaxLengthError);
		}

		@Test(groups = {"All"})
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_minus() throws InterruptedException, IOException, ParseException, SQLException{
			// logger = extent.startTest("R2267_TC7490_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_minus");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLatitudejson, "-200");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLatitudejson, "-200");

			String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallLatitudeMinLengthError);
		}

		@Test(groups = {"All"})
		public void R2267_TC95308_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_blank() throws InterruptedException, IOException, ParseException, SQLException{
			// logger = extent.startTest("R2267_TC7490_OpenEVV_altEVV_Visits_CallLatitude_field_formats_values_plus_negative_blank");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLatitudejson, "");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLatitudejson, "");

			CommonMethods.capturePostResponse_400(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		}
	}






