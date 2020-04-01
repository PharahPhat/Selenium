package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@MayankM

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

public class R2267_TC95241_AltEVV_Visit_ClientVerifiedTimes extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void R2267_TC95241_Visit_ClientVerifiedTimes_true() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("R2267_TC7477_Visit_ClientVerifiedTimes_true");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTimesjson,true);

		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95241_Visit_ClientVerifiedTimes_false() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("R2267_TC7477_Visit_ClientVerifiedTimes_false");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTimesjson,false);

		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	
	}

	@Test(groups = {"All"})
	public void R2267_TC95241_Visit_ClientVerifiedTimes_optional() throws IOException, ParseException {

		// logger = extent.startTest("R2267_TC7477_Visit_ClientVerifiedTimes_optional");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTimesjson,"");

		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95241_Visit_ClientVerifiedTimes_numeric() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("R2267_TC7477_Visit_ClientVerifiedTimes_numeric");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTimesjson, CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientVerifiedTimesError);

	}

	@Test(groups = {"All"})
	public void R2267_TC95241_Visit_ClientVerifiedTimes_invalid_length() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("R2267_TC7477_Visit_ClientVerifiedTimes_invalid_length");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTimesjson, CommonMethods.getSaltString(6));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientVerifiedTimesError);
	}

	@Test(groups = {"All"})
	public void R2267_TC95241_Visit_ClientVerifiedTimes_null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("R2267_TC7477_Visit_ClientVerifiedTimes_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTimesjson, "NULL");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientVerifiedTimesError);
	
	}

	@Test(groups = {"All"})
	public void R2267_TC95241_Visit_ClientVerifiedTimes_specialchar() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("R2267_TC7477_Visit_ClientVerifiedTimes_specialchar");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTimesjson, CommonMethods.generateSpecialChar(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientVerifiedTimesError);
	}

	@Test(groups = {"All"})
	public void R2267_TC95241_Visit_ClientVerifiedTimes_zero() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("R2267_TC7477_Visit_ClientVerifiedTimes_zero");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTimesjson, "0");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientVerifiedTimesError);
	}

	@Test(groups = {"All"})
	public void R2267_TC95241_Visit_ClientVerifiedTimes_one() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("R2267_TC7477_Visit_ClientVerifiedTimes_one");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTimesjson, "1");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientVerifiedTimesError);
	}
}
