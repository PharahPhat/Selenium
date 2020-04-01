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

public class R2267_TC95245_AltEVV_Visit_ClientVoiceRecording extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void R2267_TC95245_Visit_ClientVoiceRecording_false() throws InterruptedException, IOException,
			ParseException{

		// logger = extent.startTest("R2267_TC7481_Visit_ClientVoiceRecording_false");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVoiceRecordingjson,false);

		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95245_Visit_ClientVoiceRecording_optional() throws InterruptedException, IOException,
			ParseException {

		// logger = extent.startTest("R2267_TC7481_Visit_ClientVoiceRecording_optional");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVoiceRecordingjson, "NULL");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientVoiceRecordingError);
	}

	@Test(groups = {"All"})
	public void R2267_TC95245_Visit_ClientVoiceRecording_numeric() throws InterruptedException, IOException,
			ParseException {

		// logger = extent.startTest("R2267_TC7481_Visit_ClientVoiceRecording_numeric");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVoiceRecordingjson, CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientVoiceRecordingError);
	}

	@Test(groups = {"All"})
	public void R2267_TC95245_Visit_ClientVoiceRecording_invalid_length() throws InterruptedException, IOException,
			ParseException {

		// logger = extent.startTest("R2267_TC7481_Visit_ClientVoiceRecording_invalid_length");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVoiceRecordingjson, CommonMethods.getSaltString(6));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientVoiceRecordingError);
	}

	@Test(groups = {"All"})
	public void R2267_TC95245_Visit_ClientVoiceRecording_null() throws InterruptedException, IOException,
			ParseException, java.text.ParseException, SQLException, ClassNotFoundException {

		// logger = extent.startTest("R2267_TC7481_Visit_ClientVoiceRecording_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ClientVoiceRecordingjson, null);

		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
}
