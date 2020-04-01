package AltEVV_Molina.restassured.sandata.Visit;

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

public class SEVV2858_TC96150_AltEVV_Visit_ReasonCode extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void SEVV2858_TC96150_Visit_ReasonCode_valid_numeric() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("SEVV2858_TC96150_Visit_ReasonCode_valid");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put("ReasonCode", CommonMethods.generateRandomStringOfFixLength(4));

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96150_Visit_ReasonCode_invalid_length() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("TC96150_Visit_ReasonCode_invalid_length");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put("ReasonCode", CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ReasonCodeLengthError);
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96150_Visit_ReasonCode_alphanumeric() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException {

		// logger = extent.startTest("SEVV2858_TC96150_Visit_ReasonCode_valid");

		JSONArray jsonArrayVisit = GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges = (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put("ReasonCode", CommonMethods.generateRandomAlphaNumeric(4));

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96150_Visit_ReasonCode_null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("SEVV2858_TC96150_Visit_ReasonCode_valid");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put("ReasonCode", null);

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

}