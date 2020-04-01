/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Visit;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_Association extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate visit without employee, record is accepted but raises an exception.

	@Test(groups = {"All", "Regression"})
	public void R2267_TC91525_AltEVV_Visit_Cancelled_with_adj_time_Association_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_Association_invalid");
		logger.log(LogStatus.INFO, "Validating R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_Association_invalid"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson, true);

		jsonObjectVisit.put(globalVariables.AdjInDateTimejson, "");
		jsonObjectVisit.put(globalVariables.AdjOutDateTimejson, "");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "Request Failed With An Exception");
	}

	@Test(groups = {"All", "Regression"})
	public void R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_time_Association_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_time_Association_invalid");
		logger.log(LogStatus.INFO, "Validating R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_time_Association_invalid"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson, true);

		JSONArray jsonArrayVisitcall = (JSONArray) jsonObjectVisit.get("Calls");

		JSONObject jsonObjectVisitCallin =  (JSONObject) jsonArrayVisitcall.get(0);
		jsonObjectVisitCallin.put(globalVariables.CallDateTimejson, "");

		JSONObject jsonObjectVisitCallout =  (JSONObject) jsonArrayVisitcall.get(1);
		jsonObjectVisitCallout.put(globalVariables.CallDateTimejson, "");


		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "Request Failed With An Exception");
	}

	@Test(groups = {"All", "Regression"})
	public void R2267_TC91525_AltEVV_Visit_Cancelled_with_adj_time_Association_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_Association_invalid");
		logger.log(LogStatus.INFO, "Validating R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_Association_invalid"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson, false);

		jsonObjectVisit.put(globalVariables.AdjOutDateTimejson, CommonMethods.generateTodayDate_YYYY_MM_dd()+ "T06:47:57Z");
		jsonObjectVisit.put(globalVariables.AdjInDateTimejson, CommonMethods.generateTodayDate_YYYY_MM_dd()+ "T04:47:57Z");
		
		JSONArray jsonArrayVisitcall = (JSONArray) jsonObjectVisit.get("Calls");

		JSONObject jsonObjectVisitCallin =  (JSONObject) jsonArrayVisitcall.get(0);
		jsonObjectVisitCallin.put(globalVariables.CallDateTimejson, CommonMethods.generateTodayDate_YYYY_MM_dd()+ "T04:47:57Z");

		JSONObject jsonObjectVisitCallout =  (JSONObject) jsonArrayVisitcall.get(1);
		jsonObjectVisitCallout.put(globalVariables.CallDateTimejson, CommonMethods.generateTodayDate_YYYY_MM_dd()+ "T06:47:57Z");

		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	

	}

	@Test(groups = {"All", "Regression"})
	public void R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_time_Association_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_time_Association_invalid");
		logger.log(LogStatus.INFO, "Validating R2267_TC91525_AltEVV_Visit_Cancelled_with_Call_time_Association_invalid"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson, false);
		
		jsonObjectVisit.put(globalVariables.AdjOutDateTimejson, CommonMethods.generateTodayDate_YYYY_MM_dd()+ "T06:47:57Z");
		jsonObjectVisit.put(globalVariables.AdjInDateTimejson, CommonMethods.generateTodayDate_YYYY_MM_dd()+ "T04:47:57Z");

		JSONArray jsonArrayVisitcall = (JSONArray) jsonObjectVisit.get("Calls");

		JSONObject jsonObjectVisitCallin =  (JSONObject) jsonArrayVisitcall.get(0);
		jsonObjectVisitCallin.put(globalVariables.CallDateTimejson, CommonMethods.generatePastDate_YYYY_MM_dd()+ "T06:47:57Z");

		JSONObject jsonObjectVisitCallout =  (JSONObject) jsonArrayVisitcall.get(1);
		jsonObjectVisitCallout.put(globalVariables.CallDateTimejson, CommonMethods.generateTodayDate_YYYY_MM_dd()+ "T06:47:57Z");


		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
}
