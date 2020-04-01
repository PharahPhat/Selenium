package AltEVV_generic.restassured.sandata.Indiana.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV286_TC102589_AltEVV_Visit_Existing_CallinDate_prior_to_account_enddate_Callout_after_accountenddate extends BaseTest{
	
	GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();
	

	@Test(enabled = false, groups = { "All" })
	public void TC102589_AltEVV_Visit_Existing_CallinDate_prior_to_account_enddate_Callout_after_accountenddate_invalid() throws InterruptedException, java.text.ParseException, FileNotFoundException, IOException, ParseException,
			SQLException, java.text.ParseException, ClassNotFoundException {

		// logger = extent.startTest("TC10438_AltEVV_Visit_Existing_CallinDate_prior_to_account_enddate_Callout_after_accountenddate");

		logger.log(LogStatus.INFO, "AltEVV_Visit_Existing_CallinDate_prior_to_account_enddate_Callout_after_accountenddate");
		Map<String,String> DbMap=new HashMap<String, String>();
			
		DbMap=assertionDbVerifier.accountdetails_Effectivedates();
		
		JSONArray jsonArrayVisit = GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
	
		jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, CommonMethods.ConvertDateAsOneDayBefore(DbMap.get("EFFECTIVE_END_DATE") ));
		jsonObjectVisitChanges1.put(globalVariables.CallDateTimejson, CommonMethods.ConvertDateAsOneDayAfter(DbMap.get("EFFECTIVE_END_DATE") ));
		
		jsonObjectVisit.put(globalVariables.AdjInDateTime, null);
		jsonObjectVisit.put(globalVariables.AdjOutDateTime, null);
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.TotalVisitTimerror);

	}
	
	@Test(enabled = false, groups = { "All" })
	public void TC102589_AltEVV_Visit_Existing_CallinDate_prior_to_account_enddate_Callout_after_accountcreationdate() throws InterruptedException, java.text.ParseException, FileNotFoundException, IOException, ParseException,
			SQLException, java.text.ParseException, ClassNotFoundException {

		// logger = extent.startTest("TC10438_AltEVV_Visit_Existing_CallinDate_prior_to_account_enddate_Callout_after_accountcreation");

		logger.log(LogStatus.INFO, "TC10438_AltEVV_Visit_Existing_CallinDate_prior_to_account_enddate_Callout_after_accountcreation");
		Map<String,String> DbMap=new HashMap<String, String>();
			
		DbMap=assertionDbVerifier.accountdetails_Effectivedates();
		
		JSONArray jsonArrayVisit = GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
	
		jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, CommonMethods.ConvertDateAsOneDayBefore(DbMap.get("EFFECTIVE_END_DATE") ));
		jsonObjectVisitChanges1.put(globalVariables.CallDateTimejson, CommonMethods.ConvertDateAsOneDayAfter(DbMap.get("EFFECTIVE_BEG_DATE") ));
		
		jsonObjectVisit.put(globalVariables.AdjInDateTime, null);
		jsonObjectVisit.put(globalVariables.AdjOutDateTime, null);
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CallInCallOutError);
	}


	

}
