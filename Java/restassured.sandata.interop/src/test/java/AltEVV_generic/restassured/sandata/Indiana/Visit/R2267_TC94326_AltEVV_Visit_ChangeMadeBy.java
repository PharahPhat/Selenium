package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- ProcedureCode field formats/values

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

public class R2267_TC94326_AltEVV_Visit_ChangeMadeBy extends BaseTest { 
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All"})
	public void R2267_TC94326_AltEVV_Visit_ChangeMadeBy_MaxLength() throws InterruptedException, IOException,
			ParseException {
		// logger = extent.startTest("R2267_TC94326_AltEVV_Visit_ChangeMadeBy_validValue");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson,CommonMethods.generateRandomAlphaNumeric(64));
		
		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
	
	@Test(groups = {"All"})
	public void R2267_TC94326_AltEVV_Visit_ChangeMadeBy_greaterThan_Max() throws InterruptedException, IOException,
			ParseException{
		// logger = extent.startTest("R2267_TC94326_AltEVV_Visit_ChangeMadeBy_greaterThan_Max");
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson,CommonMethods.generateEmailAddress_alpha(50));
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorChangedMadeby);
	}

	@Test(groups = {"All"})
	public void R2267_TC94326_AltEVV_Visit_ChangeMadeBy_validvalue() throws InterruptedException, IOException,
			ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("R2267_TC94326_AltEVV_Visit_ChangeMadeBy_validvalue");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson, CommonMethods.generateEmailAddress_string(49));
		
		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
	
	@Test(groups = {"All"})
	public void R2267_TC94326_AltEVV_Visit_ChangeMadeBy_null() throws InterruptedException, IOException, ParseException{
		// logger = extent.startTest("R2267_TC94326_AltEVV_Visit_ChangeMadeBy_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson,null);
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorChangeMadeByNull);
	}

	@Test(groups = {"All"})
	public void R2267_TC94326_AltEVV_Visit_ChangeMadeBy_Invalid_Blank() throws InterruptedException, IOException, ParseException{
		// logger = extent.startTest("R2267_TC94326_AltEVV_Visit_ChangeMadeBy_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);

		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson, "");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorChangedMadeby);
	}
}
