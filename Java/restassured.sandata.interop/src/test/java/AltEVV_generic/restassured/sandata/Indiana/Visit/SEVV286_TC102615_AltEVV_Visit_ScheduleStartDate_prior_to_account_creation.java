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
public class SEVV286_TC102615_AltEVV_Visit_ScheduleStartDate_prior_to_account_creation extends BaseTest{
		
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
		@Test(enabled = false, groups = {"All"})
		public void TC102615_AltEVV_Visit_ScheduleStartDate_prior_to_account_creation() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

			// logger = extent.startTest("TC10450_AltEVV_Visit_ScheduleStartDate_prior_to_account_creation");

			logger.log(LogStatus.INFO, "Validating TC10450_AltEVV_Visit_ScheduleStartDate_prior_to_account_creation"); 

			Map<String,String> DbMap=new HashMap<String, String>();
			
			DbMap=assertionDbVerifier.accountdetails_Effectivedates();
			
			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			
			jsonObjectVisit.put(globalVariables.ScheduleStartTimejson,CommonMethods.ConvertDateAsOneDayBefore(DbMap.get("EFFECTIVE_BEG_DATE") ));
			
			jsonObjectVisit.put(globalVariables.ScheduleEndTimejson,CommonMethods.ConvertDate(DbMap.get("EFFECTIVE_BEG_DATE")) );
			
			String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
			String bodyAsStringget=CommonMethods.captureGetResponseWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.altevv_visit_get));
			
			CommonMethods.Assert_Visit_FailCase_errorcode(bodyAsStringget, globalVariables.visitDateOutOfRange_Error);
		      
		}

		@Test(enabled = false, groups = {"All"})
		public void TC102615_AltEVV_Visit_ScheduleStartDate_prior_to_accountenddate_with_pastdate() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

			// logger = extent.startTest("TC10450_AltEVV_Visit_ScheduleStartDate_prior_to_accountenddate_with_pastdate");

			logger.log(LogStatus.INFO, "Validating AltEVV_Visit_ScheduleStartDate_prior_to_accountenddate_with_pastdate");
			Map<String,String> DbMap=new HashMap<String, String>();
			
			DbMap=assertionDbVerifier.accountdetails_Effectivedates();
			
			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
			
			jsonObjectVisit.put(globalVariables.ScheduleStartTimejson,CommonMethods.ConvertDateAsOneDayBefore(DbMap.get("EFFECTIVE_END_DATE") ));
			
			jsonObjectVisit.put(globalVariables.ScheduleEndTimejson,CommonMethods.ConvertDateAsOneDayBefore(DbMap.get("EFFECTIVE_END_DATE") ));
			
			String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
			String bodyAsStringget=CommonMethods.captureGetResponseWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.altevv_visit_get));
			
			CommonMethods.Assert_Visit_FailCase_errorcode(bodyAsStringget, globalVariables.visitDateOutOfRange_Error);
			
		      
		}

}
