package AltEVV_Molina.restassured.sandata.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- PayorID field formats/values

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

import static com.globalMethods.core.globalVariables.PayerID;

public class SEVV2858_TC96070_AltEVV_Visit_PayerID extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96070_AltEVV_PayerID_greaterThan_Max() throws InterruptedException, java.text.ParseException, IOException, ParseException {
		// logger = extent.startTest("SEVV2858_TC96070_AltEVV_PayerID_greaterThan_Max");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit .put(PayerID, CommonMethods.generateRandomStringOfFixLength(65));
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorIdLength);
		
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96070_AltEVV_PayerID_AlphaNumeric() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("SEVV2858_TC96070_AltEVV_PayerID_AlphaNumeric");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(PayerID, CommonMethods.generateRandomAlphaNumeric(5));
				
		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96070_AltEVV_PayerID_null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
		// logger = extent.startTest("SEVV2858_TC96070_AltEVV_PayerID_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);	
		
		jsonObjectVisit.put(PayerID,null);
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorIDNull_AltEVV);
		
	}
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96070_AltEVV_PayerID_specialChar() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
		
		// logger = extent.startTest("SEVV2858_TC96070_AltEVV_PayerID_specialChar");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		
		jsonObjectVisit.put(PayerID,CommonMethods.generateSpecialChar(5));
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorIDFormat_AltEVV);
	}
}
