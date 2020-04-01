package AltEVV_Molina.restassured.sandata.Visit;

/*
@MayankM

OpenEVV-altEVV- Visits- ClientIdentifierOnCall field formats/values

 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.*;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV2858_TC96117_AltEVV_ClientIdentifierOnCall extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void SEVV2858_TC96117_AltEVV_ClientIdentifierOnCall_numeric() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		
		// logger = extent.startTest("SEVV2858_TC96117_AltEVV_ClientIdentifierOnCall_numeric");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.ClientIdentifierOnCalljson, CommonMethods.generateRandomNumberOfFixLength(9));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.ClientIdentifierOnCalljson, CommonMethods.generateRandomNumberOfFixLength(9));

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96117_AltEVV_ClientIdentifierOnCall_greaterThan_Max() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("SEVV2858_TC96117_ClientIdentifierOnCall_greaterThan_Max");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.ClientIdentifierOnCalljson, CommonMethods.generateRandomNumberOfFixLength(11));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.ClientIdentifierOnCalljson, CommonMethods.generateRandomNumberOfFixLength(11));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIdentifierOnCallLengthError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIdentifierOnCallformatError);
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96117_AltEVV_ClientIdentifierOnCall_AlphaNumeric() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("SEVV2858_TC96117_ClientIdentifierOnCall_AlphaNumeric");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.ClientIdentifierOnCalljson, CommonMethods.generateRandomAlphaNumeric(10));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.ClientIdentifierOnCalljson, CommonMethods.generateRandomAlphaNumeric(10));

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96117_AltEVV_ClientIdentifierOnCall_null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("SEVV2858_TC96117_ClientIdentifierOnCall_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.ClientIdentifierOnCalljson, null);

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.ClientIdentifierOnCalljson, null);

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96117_AltEVV_ClientIdentifierOnCall_specialChar() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("SEVV2858_TC96117_ClientIdentifierOnCall_specialChar");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.ClientIdentifierOnCalljson, CommonMethods.generateSpecialChar(5));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.ClientIdentifierOnCalljson, CommonMethods.generateSpecialChar(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIdentifierOnCallFormatError);
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96117_AltEVV_ClientIdentifierOnCall_optional() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("SEVV2858_TC96117_AltEVV_ClientIdentifierOnCall_optional");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.ClientIdentifierOnCalljson, "");

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.ClientIdentifierOnCalljson, "");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIdentifierOnCallFormatError);


	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96117_AltEVV_ClientIdentifierOnCall_letters() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("SEVV2858_TC96117_AltEVV_ClientIdentifierOnCall_letters");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.ClientIdentifierOnCalljson,CommonMethods.generateRandomStringOfFixLength(10));

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.ClientIdentifierOnCalljson,CommonMethods.generateRandomStringOfFixLength(10));

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

}
