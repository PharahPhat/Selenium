package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@Rahul

OpenEVV-altEVV- visit : Fields with Boolean values, check all combinations

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

public class R2267_TC91421_AltEVV_Visit_JsonBooleanFields extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void R2267_TC91421_AltEVV_JsonBooleanFields_True() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("R2267_TC91421_AltEVV_JsonBooleanFields_True");

		// create Json for visit
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.BillVisitjson,true);
		jsonObjectVisit.put(globalVariables.ClientSignatureAvailablejson,true);
		jsonObjectVisit.put(globalVariables.ClientVerifiedServicejson,true);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTasksjson,true);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTimesjson,true);
		jsonObjectVisit.put(globalVariables.ClientVoiceRecordingjson,true);
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson,true);

		// create Json for VisitExceptionAcknowledgement
		JSONArray jsonArrayVisitExceptionAcknowledgement = (JSONArray) jsonObjectVisit.get("VisitExceptionAcknowledgement");
		JSONObject jsonObjectVisitVisitExceptionAcknowledgement =  (JSONObject) jsonArrayVisitExceptionAcknowledgement.get(0);
		jsonObjectVisitVisitExceptionAcknowledgement.put(globalVariables.ExceptionAcknowledgedjson, true);
		//post Json for visit
		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC91421_AltEVV_JsonBooleanFields_False() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("R2267_TC91421_AltEVV_JsonBooleanFields_False");

		// create Json for visit
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.BillVisitjson,false);
		jsonObjectVisit.put(globalVariables.ClientSignatureAvailablejson,false);
		jsonObjectVisit.put(globalVariables.ClientVerifiedServicejson,false);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTasksjson,false);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTimesjson,false);
		jsonObjectVisit.put(globalVariables.ClientVoiceRecordingjson,false);
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson,true);
		// create Json for VisitExceptionAcknowledgement
		JSONArray jsonArrayVisitExceptionAcknowledgement = (JSONArray) jsonObjectVisit.get("VisitExceptionAcknowledgement");
		JSONObject jsonObjectVisitVisitExceptionAcknowledgement =  (JSONObject) jsonArrayVisitExceptionAcknowledgement.get(0);
		jsonObjectVisitVisitExceptionAcknowledgement.put(globalVariables.ExceptionAcknowledgedjson, true);
		
		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));

	}

	@Test(groups = {"All"})
	public void R2267_TC91421_AltEVV_JsonBooleanFields_False_True() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		// logger = extent.startTest("R2267_TC91421_AltEVV_JsonBooleanFields_False_True");


		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.BillVisitjson,true);
		jsonObjectVisit.put(globalVariables.ClientSignatureAvailablejson,false);
		jsonObjectVisit.put(globalVariables.ClientVerifiedServicejson,true);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTasksjson,true);
		jsonObjectVisit.put(globalVariables.ClientVerifiedTimesjson,false);
		jsonObjectVisit.put(globalVariables.ClientVoiceRecordingjson,false);
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson,true);
		// create Json for VisitExceptionAcknowledgement
		JSONArray jsonArrayVisitExceptionAcknowledgement = (JSONArray) jsonObjectVisit.get("VisitExceptionAcknowledgement");
		JSONObject jsonObjectVisitVisitExceptionAcknowledgement =  (JSONObject) jsonArrayVisitExceptionAcknowledgement.get(0);
		jsonObjectVisitVisitExceptionAcknowledgement.put(globalVariables.ExceptionAcknowledgedjson, true);
		//post Json for visit
		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

}
