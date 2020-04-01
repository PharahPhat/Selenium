package AltEVV_Molina.restassured.sandata.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- ProcedureCode field formats/values

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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class SEVV2858_TC96149_AltEVV_Visit_ChangeMadeBy extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96149_AltEVV_Visit_ChangeMadeBy_validValue() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("SEVV2858_TC96149_AltEVV_Visit_ChangeMadeBy_validValue");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson,CommonMethods.generateEmailAddress_string(10));
		
		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96149_AltEVV_Visit_ChangeMadeBy_greaterThan_Max() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
		// logger = extent.startTest("SEVV2858_TC96149_AltEVV_Visit_ChangeMadeBy_greaterThan_Max");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson,CommonMethods.generateRandomAlphaNumeric(66));
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorChangedMadeby);
		
	}
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96149_AltEVV_Visit_ChangeMadeBy_null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
		// logger = extent.startTest("SEVV2858_TC96149_AltEVV_Visit_ChangeMadeBy_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson,null);
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorChangeMadeByNull);
		
	}
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96149_AltEVV_Visit_ChangeMadeBy_specialChar() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		
		// logger = extent.startTest("SEVV2858_TC96149_AltEVV_Visit_ChangeMadeBy_specialChar");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson,"Null");
		
		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}
}
