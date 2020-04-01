

package AltEVV_Molina.restassured.sandata.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;

/*Ravi Ranjan*/

import Utills_ExtentReport_Log4j.BaseTest; public class SEVV2858_TC96223_OpenEVV_altEVV_Visits_CallLongitude_field_formats_values extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	

		@Test(groups = {"All"})
		public void SEVV2858_TC96223_OpenEVV_altEVV_Visits_CallLongitude_field_formats_max_minus() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
			
			// logger = extent.startTest("SEVV2858_TC96223_OpenEVV_altEVV_Visits_CallLongitude_field_formats_max_minus");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLongitudejson, "-180");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLongitudejson, "-180");

			CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		}

		@Test(groups = {"All"})
		public void SEVV2858_TC96223_OpenEVV_altEVV_Visits_CallLongitude_field_formats_max_plus() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

			// logger = extent.startTest("SEVV2858_TC96223_OpenEVV_altEVV_Visits_CallLongitude_field_formats_max_plus");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLongitudejson, "180");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLongitudejson, "180");

			CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

		@Test(groups = {"All"})
		public void SEVV2858_TC96223_OpenEVV_altEVV_Visits_CallLongitude_field_formats_blank() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
			// logger = extent.startTest("SEVV2858_TC96223_OpenEVV_altEVV_Visits_CallLongitude_field_formats_blank");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLongitudejson, "");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLongitudejson, "");

			CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		}

		@Test(groups = {"All"})
		public void SEVV2858_TC96223_OpenEVV_altEVV_Visits_CallLongitude_field_formats_null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
			// logger = extent.startTest("SEVV2858_TC96223_OpenEVV_altEVV_Visits_CallLongitude_field_formats_null");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			;
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallTypejson, "Mobile");
			jsonObjectVisitChanges.put(globalVariables.CallLongitudejson, null);

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallTypejson, "Mobile");
			jsonObjectVisitChanges_call.put(globalVariables.CallLongitudejson,null);

			String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallMobileError);

		}

		@Test(groups = {"All"})
		public void SEVV2858_TC96223_OpenEVV_altEVV_Visits_CallLongitude_field_formats_space() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

			// logger = extent.startTest("SEVV2858_TC96223_OpenEVV_altEVV_Visits_CallLongitude_field_formats_space");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLongitudejson, " ");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLongitudejson, " ");

			CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));



		}
		@Test(groups = {"All"})
		public void SEVV2858_TC96223_OpenEVV_altEVV_Visits_CallLongitude_field_formats_morethanmax() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

			// logger = extent.startTest("SEVV2858_TC96223_OpenEVV_altEVV_Visits_CallLongitude_field_formats_morethanmax");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLongitudejson, "+200");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLongitudejson, "+200");

			String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.longitudeMaxErrorLength);
		}

	@Test(groups = {"All"})
		public void SEVV2858_TC96223_OpenEVV_altEVV_Visits_CallLongitude_field_formats_lessthanmin() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

			// logger = extent.startTest("SEVV2858_TC96223_OpenEVV_altEVV_Visits_CallLongitude_field_formats_lessthanmin");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.CallLongitudejson, "-200");

			JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
			jsonObjectVisitChanges_call.put(globalVariables.CallLongitudejson, "-200");

			String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.longitudeMinErrorLength);
		}
		

	}



