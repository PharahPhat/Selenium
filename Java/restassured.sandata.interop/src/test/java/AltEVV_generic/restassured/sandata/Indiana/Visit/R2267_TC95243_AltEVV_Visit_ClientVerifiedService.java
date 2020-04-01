package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@MayankM

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

public class R2267_TC95243_AltEVV_Visit_ClientVerifiedService extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "fixing"})
	public void R2267_TC95243_Visit_ClientVerifiedService_false() throws InterruptedException, IOException, ParseException {

		// logger = extent.startTest("R2267_TC7479_Visit_ClientVerifiedService_false");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedServicejson,false);

		CommonMethods.verifyPostAltEVVSuccessfully(jsonArrayVisit, 
				CommonMethods.propertyfileReader(globalVariables.altevv_visit), 
				CommonMethods.propertyfileReader(globalVariables.altevv_visit_get));
	}

	@Test(groups = {"All"})
	public void R2267_TC95243_Visit_ClientVerifiedService_optional() throws IOException, ParseException{

		// logger = extent.startTest("R2267_TC7479_Visit_ClientVerifiedService_optional");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedServicejson, "");

		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
	
	@Test(groups = {"All"})
	public void R2267_TC95243_Visit_ClientVerifiedService_numeric() throws IOException, ParseException {

		// logger = extent.startTest("R2267_TC7479_Visit_ClientVerifiedService_numeric");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedServicejson, CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientVerifiedServiceError);
	}
	
	@Test(groups = {"All"})
	public void R2267_TC95243_Visit_ClientVerifiedService_invalid_length() throws InterruptedException, IOException, ParseException {

		// logger = extent.startTest("R2267_TC7479_Visit_ClientVerifiedService_invalid_length");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedServicejson, CommonMethods.getSaltString(6));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientVerifiedServiceError);
	}
	
	@Test(groups = {"All"})
	public void R2267_TC95243_Visit_ClientVerifiedService_null() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException{

		// logger = extent.startTest("R2267_TC7479_Visit_ClientVerifiedService_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVerifiedServicejson, null);

		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));

	}

}
