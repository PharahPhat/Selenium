package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- PayorID field formats/values

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

public class R2267_TC94318_AltEVV_Visit_PayerID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "fixing"})
	public void R2267_TC94318_AltEVV_PayerID_greaterThan_Max() throws IOException, ParseException {
		// logger = extent.startTest("R2267_TC7462_AltEVV_PayerID_greaterThan_Max");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.PayerID, "ODafsafdsfdsgsg");
		switch (state) {
			case "Indiana":
				String postResponseAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
						CommonMethods.propertyfileReader(globalVariables.altevv_visit));
				String getResponseAsString = CommonMethods.captureGetResponseWithUID(postResponseAsString,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit_get));
				CommonMethods.verifyErrorMessage(getResponseAsString, globalVariables.errorPayerID);
				break;
			default:
				String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
						CommonMethods.propertyfileReader(globalVariables.altevv_visit));
				CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerIdIncorrectFormatError);
				break;
		}

	}
	
	@Test(groups = {"All"})
	public void R2267_TC94318_AltEVV_PayerID_null() throws IOException, ParseException {
		// logger = extent.startTest("R2267_TC7462_AltEVV_PayerID_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.PayerID,null);
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayoraltevvGeneric);
	}
	
	@Test(groups = {"All"})
	public void R2267_TC94318_AltEVV_PayerID_specialChar() throws IOException, ParseException {
		
		// logger = extent.startTest("R2267_TC7462_AltEVV_PayerID_specialChar");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.PayerID,CommonMethods.generateSpecialChar(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorIDFormat_AltEVV);
	}
}
