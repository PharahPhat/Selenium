package AltEVV_generic.restassured.sandata.Indiana.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class R2267_TC95428_OpenEVV_altEVV_Validate_Visit_Changes_Positive_Values_Required_Fields extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	
	@Test(groups = {"All"})
	public void R2267_TC95428_OpenEVV_altEVV_Validate_Visit_Changes_Positive_Values_Required() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		
		// logger = extent.startTest("R2267_TC95428_OpenEVV_altEVV_Validate_Visit_Changes_Positive_Values_Required_with_change_details");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson, CommonMethods.generateEmailAddress_string(7));
		jsonObjectVisitChanges.put(globalVariables.ChangeDateTimejson, CommonMethods.generateTodayDate_YYYY_MM_dd()+ "T04:47:57Z");
		jsonObjectVisitChanges.put(globalVariables.ReasonCodejson, CommonMethods.generateRandomNumberOfFixLength(3));
		jsonObjectVisitChanges.put(globalVariables.ResolutionCodejson, CommonMethods.getSaltString(1));
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, CommonMethods.generateRandomNumberOfFixLength(15));

		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

}
