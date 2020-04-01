/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class R2267_TC91417_Visit_Validate_VisitExceptionID extends BaseTest { 
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	// Case1: Verify all exception ID in one visit
	@Test(groups = {"All"})
	public void R2267_TC91417_Validate_VisitExceptionID() throws InterruptedException, java.text.ParseException,
			IOException, ParseException, SQLException, ClassNotFoundException
	{

		// logger = extent.startTest("R2267_TC91417_Validate_VisitExceptionID");
		logger.log(LogStatus.INFO, "Validating_VisitExceptionID"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitException = (JSONArray) jsonObjectVisit.get("VisitExceptionAcknowledgement");
		JSONObject jsonObjectVisitException =  (JSONObject) jsonArrayVisitException.get(0);

		jsonObjectVisitException.put(globalVariables.ExceptionAcknowledgedjson, true);
		jsonObjectVisitException.put(globalVariables.ExceptionIDjson, CommonMethods.generateRandomNumberOfFixLength(2));
				
		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));

	}
	// Case2: Validating exception ID with valid entry in one visit
	@Test(groups = {"All"})
	public void R2267_TC91417_Validate_VisitExceptionID_invalid() throws InterruptedException, IOException,
			ParseException {

		// logger = extent.startTest("R2267_TC91417_Validate_VisitExceptionID_valid");
		logger.log(LogStatus.INFO, "Validating_VisitExceptionID with valid value"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitException = (JSONArray) jsonObjectVisit.get("VisitExceptionAcknowledgement");
		JSONObject jsonObjectVisitException =  (JSONObject) jsonArrayVisitException.get(0);

		jsonObjectVisitException.put(globalVariables.ExceptionAcknowledgedjson, true);
		jsonObjectVisitException.put(globalVariables.ExceptionIDjson, CommonMethods.generateRandomNumberOfFixLength(3));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ExceptionIDformaterror);
	}

	// Case3: Validating exception ID with NULL
	@Test(groups = {"All"})
	public void R2267_TC91417_Validate_VisitExceptionID_with_NULL() throws InterruptedException, IOException,
			ParseException
	{

		// logger = extent.startTest("R2267_TC91417_Validate_VisitExceptionID_with_NULL");
		logger.log(LogStatus.INFO, "Validating_VisitExceptionID_with_nullvalue"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitException = (JSONArray) jsonObjectVisit.get("VisitExceptionAcknowledgement");
		JSONObject jsonObjectVisitException =  (JSONObject) jsonArrayVisitException.get(0);

		jsonObjectVisitException.put(globalVariables.ExceptionAcknowledgedjson, true);
		jsonObjectVisitException.put(globalVariables.ExceptionIDjson, "NULL");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ExceptionIDformaterror);
	}

	// Case4: Validating exception ID with "null"
	@Test(groups = {"All"})
	public void R2267_TC91417_Validate_VisitExceptionID_with_null() throws InterruptedException, IOException,
			ParseException
	{

		// logger = extent.startTest("R2267_TC91417_Validate_VisitExceptionID_with_null");
		logger.log(LogStatus.INFO, "Validating_VisitExceptionID_with_null"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitException = (JSONArray) jsonObjectVisit.get("VisitExceptionAcknowledgement");
		JSONObject jsonObjectVisitException =  (JSONObject) jsonArrayVisitException.get(0);

		jsonObjectVisitException.put(globalVariables.ExceptionAcknowledgedjson, true);
		jsonObjectVisitException.put(globalVariables.ExceptionIDjson, "null");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ExceptionIDError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ExceptionIDformaterror);
	}
}
