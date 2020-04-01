package AltEVV_Molina.restassured.sandata.Visit;

/*
@MayankM

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

public class SEVV2858_TC96058_AltEVV_Visit_SequenceID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	public void TC96058_AltEVV_Visit_SequenceID() throws InterruptedException,
			IOException, ParseException {

		// logger = extent.startTest("SEVV2858_TC96058_AltEVV_Visit_SeqID_Equal_PrevSeqID_validation");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObject = (JSONObject) jsonArrayVisit.get(0);
		long sequenceId = Long.parseLong(jsonObject.get(globalVariables.SequenceID).toString());

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

		Thread.sleep(30000);

		String bodyAsStringGet = CommonMethods.captureGetResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit),
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit_get));

		CommonMethods.verifyErrorMessage(bodyAsStringGet, globalVariables.SequenceIDDuplicateError);

		jsonObject.put(globalVariables.SequenceID, sequenceId - 1);

		bodyAsStringGet = CommonMethods.captureGetResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit),
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit_get));

		CommonMethods.verifyErrorMessage(bodyAsStringGet, globalVariables.SequenceIDDuplicateError);

		jsonObject.put(globalVariables.SequenceID, sequenceId + 1);

		CommonMethods.verifyPostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit),
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit_get));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96058_AltEVV_Visit_SequenceID_Validation() throws IOException, ParseException {

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.SequenceIDjson, CommonMethods.generateRandomNumberOfFixLength(17));
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.SequenceLengthError);

		jsonObjectVisit.put(globalVariables.SequenceIDjson, null);
		bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorSequenceIdNull);

		jsonObjectVisit.put(globalVariables.SequenceIDjson, CommonMethods.generateSpecialChar(16));
		bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.SequenceIDFormatError);

		jsonObjectVisit.put(globalVariables.SequenceIDjson, CommonMethods.generateRandomAlphaNumeric(16));
		bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.SequenceIDFormatError);

	}
}
