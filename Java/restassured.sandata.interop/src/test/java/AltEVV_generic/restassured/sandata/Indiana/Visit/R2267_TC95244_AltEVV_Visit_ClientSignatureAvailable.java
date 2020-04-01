package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@MayankM

OpenEVV-altEVV- Visits- VisitOtherID field formats/values

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

public class R2267_TC95244_AltEVV_Visit_ClientSignatureAvailable extends BaseTest {
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void R2267_TC95244_Visit_ClientSignatureAvailable_true() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("R2267_TC7480_Visit_ClientSignatureAvailable_true");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientSignatureAvailablejson,true);

		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

	}
	
	@Test(groups = {"All"})
	public void R2267_TC95244_Visit_ClientSignatureAvailable_false() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("R2267_TC7480_Visit_ClientSignatureAvailable_false");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientSignatureAvailablejson, false);

		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95244_Visit_ClientSignatureAvailable_optional() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("R2267_TC7480_Visit_ClientSignatureAvailable_optional");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientSignatureAvailablejson, "NULL");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientSignatureAvailableError);
	}
	
	@Test(groups = {"All"})
	public void R2267_TC95244_Visit_ClientSignatureAvailable_numeric() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("R2267_TC7480_Visit_ClientSignatureAvailable_numeric");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientSignatureAvailablejson, CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientSignatureAvailableError);
	}
	
	@Test(groups = {"All"})
	public void R2267_TC95244_Visit_ClientSignatureAvailable_invalid_length() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("R2267_TC7480_Visit_ClientSignatureAvailable_true");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientSignatureAvailablejson, CommonMethods.getSaltString(6));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientSignatureAvailableError);
	}

	public void R2267_TC95244_Visit_ClientSignatureAvailable_null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("R2267_TC7480_Visit_ClientSignatureAvailable_true");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientSignatureAvailablejson, null);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientSignatureAvailableError);
	}

	public void R2267_TC95244_Visit_ClientSignatureAvailable_spcl_char() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("R2267_TC7480_Visit_ClientSignatureAvailable_spcl_char");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientSignatureAvailablejson, CommonMethods.generateSpecialChar(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientSignatureAvailableError);
	}

	
}
