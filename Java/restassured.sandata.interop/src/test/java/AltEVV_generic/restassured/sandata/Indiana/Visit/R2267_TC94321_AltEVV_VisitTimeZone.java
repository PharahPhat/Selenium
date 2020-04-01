package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- ProcedureCode field formats/values

*/
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC94321_AltEVV_VisitTimeZone extends BaseTest {

	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void R2267_TC94321_AltEVV_VisitTimeZone_validValue() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("R2267_TC7465_AltEVV_VisitTimeZone_validValue");

		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitTimeZonejson, "US/Eastern");

		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

	}
	
	@Test(groups = {"All"})
	public void R2267_TC94321_AltEVV_VisitTimeZone_greaterThan_Max() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
		// logger = extent.startTest("R2267_TC7465_AltEVV_VisitTimeZone_greaterThan_Max");


		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitTimeZonejson,CommonMethods.generateRandomAlphaNumeric(65));
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorVisitTiemZoneFormat);
	}

	@Test(groups = {"All"})
	public void R2267_TC94321_AltEVV_VisitTimeZone_AlphaNumeric() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
		// logger = extent.startTest("R2267_TC7465_AltEVV_VisitTimeZone_AlphaNumeric");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);		
		
		jsonObjectVisit.put(globalVariables.VisitTimeZonejson,CommonMethods.generateRandomAlphaNumeric(5));
				
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorVisitTimeZonelength);
		
		
	}
	
	@Test(groups = {"All"})
	public void R2267_TC94321_AltEVV_VisitTimeZone_null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
		// logger = extent.startTest("R2267_TC7465_AltEVV_VisitTimeZone_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
	
		jsonObjectVisit.put(globalVariables.VisitTimeZonejson,null);
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorVisitTimeZoneNull);
		
	}

}
