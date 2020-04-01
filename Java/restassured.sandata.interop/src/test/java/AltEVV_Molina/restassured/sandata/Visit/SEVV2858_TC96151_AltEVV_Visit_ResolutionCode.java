package AltEVV_Molina.restassured.sandata.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV2858_TC96151_AltEVV_Visit_ResolutionCode extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void SEVV2858_TC96151_Visit_ResolutionCode_valid_numeric() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("SEVV2858_TC96151_Visit_ResolutionCode_valid");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.ResolutionCodejson, CommonMethods.generateRandomNumberOfFixLength(4));

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96151_Visit_ResolutionCode_invalid_length() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("SEVV2858_TC96151_Visit_ResolutionCode_valid");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.ResolutionCodejson, CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ResolutionCodeLengthError);
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96151_Visit_ResolutionCode_alphanumeric() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("SEVV2858_TC96151_Visit_ResolutionCode_valid");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.ResolutionCodejson, CommonMethods.generateRandomAlphaNumeric(4));

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96151_Visit_ResolutionCode_null() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("SEVV2858_TC96151_Visit_ResolutionCode_valid");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.ResolutionCodejson, null);

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}
}