package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- GroupCode field formats/values

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

public class R2267_TC94328_TC103247_AltEVV_Visit_GroupCode extends BaseTest {

	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void R2267_TC94328_AltEVV_Visit_GroupCode_validValue() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("R2267_TC94326_AltEVV_Visit_ChangeMadeBy_validValue");


		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);

		jsonObjectVisitChanges.put(globalVariables.VisitGroupCodejson,CommonMethods.generateRandomAlphaNumeric(5));

		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC94328_AltEVV_Visit_GroupCode_greaterThan_Max() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("R2267_TC94326_AltEVV_Visit_ChangeMadeBy_greaterThan_Max");
		
//		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
//		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
//		
//		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
//		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
//
//		jsonObjectVisitChanges.put(globalVariables.VisitGroupCodejson,CommonMethods.generateRandomAlphaNumeric(7));
//
//		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit);
//
//		assertionDbVerifier.jsonAssert_inboxVisitChanges_Generic(bodyAsString, jsonObjectVisit, jsonObjectVisitChanges);

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.VisitGroupCodejson,CommonMethods.generateRandomAlphaNumeric(7));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.GroupCodeLengthError);

	}

	@Test(groups = {"All"})
	public void R2267_TC94328_AltEVV_Visit_GroupCode_Integer() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("R2267_TC94326_AltEVV_Visit_ChangeMadeBy_Integer");


		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);

		jsonObjectVisitChanges.put(globalVariables.VisitGroupCodejson,CommonMethods.generateRandomNumberOfFixLength(5));

		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC94328_AltEVV_Visit_GroupCode_null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("R2267_TC94326_AltEVV_Visit_ChangeMadeBy_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);

		jsonObjectVisitChanges.put(globalVariables.VisitGroupCodejson,null);

		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC94328_AltEVV_Visit_GroupCode_specialChar() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("R2267_TC94326_AltEVV_Visit_ChangeMadeBy_specialChar");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);

		jsonObjectVisitChanges.put(globalVariables.VisitGroupCodejson,CommonMethods.generateSpecialChar(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.GroupCodeFormatError);
	}
}
