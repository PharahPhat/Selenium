/**
 * 
 */
package AltEVV_Molina.restassured.sandata.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class SEVV2858_TC96106_TC96107_AltEVV_Visit_AdjInDateTime_AdjOutDateTime_Weekend_Holiday_LeapYear extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

//Case1: Validating AdjInDateTime and AdjOutDateTime dates which fall under Weekends(Saturday/Sunday) (ClientEligibilityDateBegin,ClientEligibilityDateEnd,ScheduleStartTime,ScheduleEndTime (EndTime),AdjInDateTime,AdjOutDateTime,ChangeDateTime(visit changes))
@Test(groups = {"All"})
public void SEVV2858_TC96106_TC96107_AltEVV_VisitCreation_in_Weekends_in_CalenderDays() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

	// logger = extent.startTest("SEVV2858_TC96106_TC96107_AltEVV_VisitCreation_with_Weekends_in_CalenderDays");

	logger.log(LogStatus.INFO, "Validating SEVV2858_TC96106_TC96107_AltEVV_VisitCreation_with_Weekends_in_CalenderDays"); 

	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

	jsonObjectVisit.put(globalVariables.AdjInDateTime, "2018-12-30T10:02:26Z");
	//jsonObjectVisit.put(globalVariables.AdjInDateTime, DataGeneratorVisit.AdjInDateTime("YYYY-MM-DD")+ "T06:47:57Z");

	jsonObjectVisit.put(globalVariables.AdjOutDateTime, "2018-12-30T22:02:20Z");


	JSONArray jsonArrayVisitcall = (JSONArray) jsonObjectVisit.get("Calls");

	JSONObject jsonObjectVisitCallin =  (JSONObject) jsonArrayVisitcall.get(0);
	jsonObjectVisitCallin.put(globalVariables.CallDateTimejson,  "2018-12-30T01:47:57Z"); 

	JSONObject jsonObjectVisitCallout =  (JSONObject) jsonArrayVisitcall.get(1);
	jsonObjectVisitCallout.put(globalVariables.CallDateTimejson, "2018-12-30T16:47:57Z");

	CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
}

//Case2: Validating AdjInDateTime and AdjOutDateTime dates which fall under Holidays (ClientEligibilityDateBegin,ClientEligibilityDateEnd,ScheduleStartTime,ScheduleEndTime (EndTime),AdjInDateTime,AdjOutDateTime,ChangeDateTime(visit changes))
@Test(groups = {"All"})
public void SEVV2858_TC96106_TC96107_AltEVV_VisitCreation_with_Holidays_in_CalenderDays() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

	// logger = extent.startTest("SEVV2858_TC96106_TC96107_AltEVV_VisitCreation_with_Holidays_in_CalenderDays");

	logger.log(LogStatus.INFO, "Validating SEVV2858_TC96106_TC96107_AltEVV_VisitCreation_with_Holidays_in_CalenderDays"); 

	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
	jsonObjectVisit.put(globalVariables.AdjInDateTime, "2018-12-25T10:02:26Z");

	jsonObjectVisit.put(globalVariables.AdjOutDateTime, "2018-12-25T22:02:20Z");

	JSONArray jsonArrayVisitcall = (JSONArray) jsonObjectVisit.get("Calls");

	JSONObject jsonObjectVisitCallin =  (JSONObject) jsonArrayVisitcall.get(0);
	jsonObjectVisitCallin.put(globalVariables.CallDateTimejson,  "2018-12-25T01:47:57Z"); 

	JSONObject jsonObjectVisitCallout =  (JSONObject) jsonArrayVisitcall.get(1);
	jsonObjectVisitCallout.put(globalVariables.CallDateTimejson, "2018-12-25T16:47:57Z");

	CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
}

//Case3: Validating AdjInDateTime and AdjOutDateTime dates which fall in leap year (visit creation successful) (ClientEligibilityDateBegin,ClientEligibilityDateEnd,ScheduleStartTime,ScheduleEndTime (EndTime),AdjInDateTime,AdjOutDateTime,ChangeDateTime(visit changes))
@Test(enabled = false, groups = {"All"})
public void SEVV2858_TC96106_TC96107_AltEVV_VisitCreation_in_leap_year_Calender() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

	// logger = extent.startTest("SEVV2858_TC96106_TC96107_AltEVV_VisitCreation_in_leap_year_Calender");

	logger.log(LogStatus.INFO, "Validating SEVV2858_TC96106_TC96107_AltEVV_VisitCreation_in_leap_year_Calender"); 

	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
	jsonObjectVisit.put(globalVariables.AdjInDateTime, "2016-02-29T10:02:26Z");
	//jsonObjectVisit.put(globalVariables.AdjInDateTime, DataGeneratorVisit.AdjInDateTime("yyyy-MM-dd HH:mm:ss"));
	jsonObjectVisit.put(globalVariables.AdjOutDateTime, "2016-02-29T22:02:20Z");
	//DataGeneratorVisit.AdjInDateTime("yyyy-MM-dd HH:mm:ss")

	JSONArray jsonArrayVisitcall = (JSONArray) jsonObjectVisit.get("Calls");

	JSONObject jsonObjectVisitCallin =  (JSONObject) jsonArrayVisitcall.get(0);
	jsonObjectVisitCallin.put(globalVariables.CallDateTimejson,  "2016-02-28T01:47:57Z"); 

	JSONObject jsonObjectVisitCallout =  (JSONObject) jsonArrayVisitcall.get(1);
	jsonObjectVisitCallout.put(globalVariables.CallDateTimejson, "2016-02-29T23:47:57Z");

	CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

}
