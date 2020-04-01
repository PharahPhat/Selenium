package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@Neeraj

OpenEVV-altEVV- Visits- SequenceID field formats/values

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

public class R2267_TC94311_AltEVV_VisitSequenceID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression", "fixing"})
	public void TC94311_AltEVV_Visit_SequenceID() throws InterruptedException,
			IOException, ParseException {

		// logger = extent.startTest("SEVV2858_TC96058_AltEVV_Visit_SeqID_Equal_PrevSeqID_validation");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObject = (JSONObject) jsonArrayVisit.get(0);
		long sequenceId = Long.parseLong(jsonObject.get(globalVariables.SequenceID).toString());

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		Thread.sleep(30000);

		String bodyAsStringGet = CommonMethods.captureGetResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit),
				CommonMethods.propertyfileReader(globalVariables.altevv_visit_get));

		CommonMethods.verifyErrorMessage(bodyAsStringGet, globalVariables.SequenceIDDuplicateError);

		jsonObject.put(globalVariables.SequenceID, sequenceId - 1);

		bodyAsStringGet = CommonMethods.captureGetResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit),
				CommonMethods.propertyfileReader(globalVariables.altevv_visit_get));

		CommonMethods.verifyErrorMessage(bodyAsStringGet, globalVariables.SequenceIDDuplicateError);

		jsonObject.put(globalVariables.SequenceID, sequenceId + 1);

		CommonMethods.verifyPostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit),
				CommonMethods.propertyfileReader(globalVariables.altevv_visit_get));
	}
	
	@Test(groups = {"All"})
	public void RR2267_TC94311_AltEVV_VisitSequenceID_Validation() throws IOException, ParseException, InterruptedException {
		// logger = extent.startTest("RR2267_TC94311_AltEVV_VisitSequenceID_greaterThan_Max");
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.SequenceIDjson, CommonMethods.generateRandomNumberOfFixLength(17));
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.SequenceIDLengthError);

		jsonObjectVisit.put(globalVariables.SequenceIDjson, null);
		bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorSequenceIdNull);

		jsonObjectVisit.put(globalVariables.SequenceIDjson, CommonMethods.generateSpecialChar(16));
		CommonMethods.capturePostResponse_400(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		jsonObjectVisit.put(globalVariables.SequenceIDjson, CommonMethods.generateRandomAlphaNumeric(16));
		CommonMethods.capturePostResponse_400(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
}
