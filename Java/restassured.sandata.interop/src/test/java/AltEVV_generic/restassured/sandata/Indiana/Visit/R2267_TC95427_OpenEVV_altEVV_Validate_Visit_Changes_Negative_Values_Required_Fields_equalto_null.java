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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/*Ravi Ranjan*/

public class R2267_TC95427_OpenEVV_altEVV_Validate_Visit_Changes_Negative_Values_Required_Fields_equalto_null extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	

		@Test(groups = {"All"})
		public void R2267_TC95427_AltEVV_Visit_Changes_Negative_Values_Required_Fields_blank() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
			// logger = extent.startTest("R2267_TC95427_AltEVV_Visit_Changes_Negative_Values_Required_Fields_blank");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
			jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson, "");
			jsonObjectVisitChanges.put(globalVariables.ChangeDateTimejson, "");
			jsonObjectVisitChanges.put(globalVariables.ReasonCodejson, "");
			jsonObjectVisitChanges.put(globalVariables.ResolutionCodejson, "");
			jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, "");

			CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		}
		
		@Test(groups = {"All"})
		public void R2267_TC95427_AltEVV_VisitChanges_blank_sequenceid() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
			// logger = extent.startTest("TC95427_AltEVV_VisitChanges_blank_sequenceid");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);

			jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, "");

			CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		}
		
		@Test(groups = {"All"})
		public void R2267_TC95427_AltEVV_VisitChanges_blank_changedatetime() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
			// logger = extent.startTest("R2267_TC95427_AltEVV_Visit Change_blank_changedatetime");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
			JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);

			jsonObjectVisitChanges.put(globalVariables.ChangeDateTimejson, "");

			CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		}
		


}
