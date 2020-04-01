package AltEVV_Molina.restassured.sandata.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- VisitOtherID field formats/values

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

public class SEVV2858_TC96054_AltEVV_VisitOtherId extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96054_AltEVV_VisitOtherId_validValue() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("SEVV2858_TC96054_VisitOtherId");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitOtherIDjson,CommonMethods.generateRandomNumberOfFixLength(50));
		
		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96054_AltEVV_VisitOtherId_greaterThan_Max() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
		// logger = extent.startTest("SEVV2858_TC96054_VisitOtherId_greaterThan_Max");


		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitOtherIDjson,CommonMethods.generateRandomNumberOfFixLength(51));
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorVisitOtherIdLength);
		
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96054_AltEVV_VisitOtherID_AlphaNumeric() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("SEVV2858_TC96054_VisitOtherID_AlphaNumeric");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.VisitOtherIDjson,CommonMethods.generateRandomAlphaNumeric(50));
				
		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96054_AltEVV_VisitOtherId_null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
		// logger = extent.startTest("SEVV2858_TC96054_VisitOtherId_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		
		
		jsonObjectVisit.put(globalVariables.VisitOtherIDjson,null);
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorVisitOtherIDNull);
		
	}
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96054_AltEVV_VisitOtherId_specialChar() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
		
		// logger = extent.startTest("SEVV2858_TC96054_VisitOtherId_specialChar");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		
		jsonObjectVisit.put(globalVariables.VisitOtherIDjson,CommonMethods.generateSpecialChar(5));
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorVisitOtherIdFormat);
		
		
	}

}
