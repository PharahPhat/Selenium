package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@RaviRanjan

OpenEVV_altEVV_Visits_ProcedureCode_field_formats_values

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

public class R2267_TC95304_AltEVV_Visits_ProcedureCode extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
		

		//validating procedure code less than min length
		@Test(groups = {"All"})
		public void R2267_TC95304_OpenEVV_altEVV_Visits_ProcedureCode_field_invalid_lessthanminlength() throws InterruptedException, IOException, ParseException, SQLException{
			
			// logger = extent.startTest("R2267_TC7486_OpenEVV_altEVV_Visits_ProcedureCode_field_lessthan_minimum_lenghth");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.ProcedureCodejson,"G");
			
			CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
	

		
		//validating procedure code with blank values
		@Test(groups = {"All"})
		public void R2267_TC95304_OpenEVV_altEVV_Visits_ProcedureCode_field_blank() throws InterruptedException, IOException, ParseException, SQLException{
			
			// logger = extent.startTest("R2267_TC7486_OpenEVV_altEVV_Visits_ProcedureCode_field_with_blank");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			jsonObjectVisit.put(globalVariables.ProcedureCodejson," ");
				
			String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ProcedureCodeFormatError);
	}
}



