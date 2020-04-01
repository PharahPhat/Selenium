package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- VisitOtherID field formats/values

*/

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class R2267_TC94315_AltEVV_Visit_ClientOtherId extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	@Test(groups = {"All"})
	public void R2267_TC94315_AltEVV_ClientOtherId_validValue() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("R2267_TC7459_AltEVV_ClientOtherId_validValue");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		jsonObjectVisit.put(globalVariables.ClientOtherIDjson,CommonMethods.generateRandomNumberOfFixLength(23));
		String mLogin=CommonMethods.generateRandomNumberOfFixLength(10);
		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.MobileLoginjson, mLogin);

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.MobileLoginjson, mLogin);

		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
	
	@Test(groups = {"All"})
	public void R2267_TC94315_AltEVV_ClientOtherId_greaterThan_Max() throws InterruptedException, IOException, ParseException{
		// logger = extent.startTest("R2267_TC7459_AltEVV_ClientOtherId_greaterThan_Max");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientOtherIDjson,CommonMethods.generateRandomNumberOfFixLength(26));
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorClientOtherIdLength);
	}

	@Test(groups = {"All"})
	public void R2267_TC94315_AltEVV_ClientOtherId_AlphaNumeric() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("R2267_TC7459_AltEVV_ClientOtherId_AlphaNumeric");
		String MobileLogin=CommonMethods.generateRandomNumberOfFixLength(10);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.ClientOtherIDjson,CommonMethods.generateRandomAlphaNumeric(23));
		String mLogin=CommonMethods.generateRandomNumberOfFixLength(10);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.MobileLoginjson, mLogin);

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.MobileLoginjson, mLogin);

		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

	}
	
	@Test(groups = {"All"})
	public void R2267_TC94315_AltEVV_ClientOtherId_null() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("R2267_TC7459_AltEVV_ClientOtherId_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		String mLogin=CommonMethods.generateRandomNumberOfFixLength(10);
		jsonObjectVisit.put(globalVariables.ClientOtherIDjson, null);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.MobileLoginjson, mLogin);

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.MobileLoginjson, mLogin);

		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
	
	@Test(groups = {"All"})
	public void R2267_TC94315_AltEVV_ClientOtherId_specialChar() throws InterruptedException, IOException, ParseException{
		
		// logger = extent.startTest("R2267_TC7459_AltEVV_ClientOtherId_specialChar");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientOtherIDjson,CommonMethods.generateSpecialChar(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorClientOtherIdFormat);
	}
}
