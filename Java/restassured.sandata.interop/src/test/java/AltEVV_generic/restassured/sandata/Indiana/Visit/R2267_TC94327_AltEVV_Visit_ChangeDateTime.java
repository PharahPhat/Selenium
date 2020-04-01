package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- ChangeDateTime field formats/values

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

import java.io.IOException;

public class R2267_TC94327_AltEVV_Visit_ChangeDateTime extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void R2267_TC94327_AltEVV_Visit_ChangeDateTime_validValue() throws IOException, ParseException {
		// logger = extent.startTest("R2267_TC94327_AltEVV_Visit_ChangeDateTime_validValue");
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.ChangeDateTimejson,CommonMethods.generateTodayDate_YYYY_MM_dd()+ "T06:47:57Z");
		
		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}	
	
	@Test(groups = {"All"})
	public void R2267_TC94327_AltEVV_Visit_ChangeDateTime_null() throws IOException, ParseException {
		// logger = extent.startTest("R2267_TC94327_AltEVV_Visit_ChangeDateTime_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put(globalVariables.ChangeDateTimejson,null);
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ChangeDateTimeNullError);
		
	}
	
	@Test(groups = {"All"})
	public void R2267_TC94327_AltEVV_Visit_ChangeDateTime_InvalidFormat() throws InterruptedException, IOException, ParseException {
		
		// logger = extent.startTest("R2267_TC94327_AltEVV_Visit_ChangeDateTime_InvalidFormat");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put(globalVariables.ChangeDateTimejson,CommonMethods.generateRandomStringOfFixLength(8));

		CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
}
