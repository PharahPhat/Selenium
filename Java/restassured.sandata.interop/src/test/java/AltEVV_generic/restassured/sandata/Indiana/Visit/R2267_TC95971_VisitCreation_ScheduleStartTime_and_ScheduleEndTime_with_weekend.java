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

/**
 * @author Anupam
 */

public class R2267_TC95971_VisitCreation_ScheduleStartTime_and_ScheduleEndTime_with_weekend extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//Case1: Validating VisitCreation_with_ScheduleStartTime_and_ScheduleEndTime_passed_with_weekend_holidays_in_CalenderDays
	@Test(groups = {"All"})
	public void R2267_TC95971_AltEVV_VisitCreation_ScheduleStartTime_and_ScheduleEndTime_with_weekends() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

		// logger = extent.startTest("R2267_TC95971_AltEVV_VisitCreation_ScheduleStartTime_and_ScheduleEndTime_with_weekends");

		logger.log(LogStatus.INFO, "Validating R2267_TC95971_AltEVV_VisitCreation_ScheduleStartTime_and_ScheduleEndTime_with_weekends"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson, "2018-09-07T10:02:26Z");
		

		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson, "2018-09-07T22:02:20Z");

		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	//Case2: Validating ScheduleStartTime_and_ScheduleEndTime dates which fall under Holidays (ClientEligibilityDateBegin,ClientEligibilityDateEnd,ScheduleStartTime,ScheduleEndTime (EndTime),AdjInDateTime,AdjOutDateTime,ChangeDateTime(visit changes))
	@Test(groups = {"All"})
	public void R2267_TC95971_AltEVV_VisitCreation_with_ScheduleStartTime_ScheduleEndTime_in_Holidays() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

		// logger = extent.startTest("R2267_TC95971_AltEVV_VisitCreation_with_ScheduleEndTime_Holidays_in_CalenderDays");

		logger.log(LogStatus.INFO, "Validating VisitCreation_with_ScheduleStartTime_and_ScheduleEndTime_Holidays_in_CalenderDays"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson, "2018-12-25T10:02:26Z");

		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson, "2018-12-25T22:02:20Z");

		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	//Case3: Validating ScheduleStartTime_and_ScheduleEndTime dates which fall in leap year (visit creation successful) (ClientEligibilityDateBegin,ClientEligibilityDateEnd,ScheduleStartTime,ScheduleEndTime (EndTime),AdjInDateTime,AdjOutDateTime,ChangeDateTime(visit changes))
	@Test(groups = {"All"})
	public void R2267_TC95971_AltEVV_VisitCreation_ScheduleStartTime_ScheduleEndTime_in_leap_year() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

		// logger = extent.startTest("R2267_TC95971_AltEVV_VisitCreation_ScheduleStartTime_ScheduleEndTime_in_leap_year");

		logger.log(LogStatus.INFO, "Validating VisitCreation with ScheduleStartTime_and_ScheduleEndTime_in_leap_year_Calender"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson, "2016-02-29T10:02:26Z");

		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson, "2016-02-29T22:02:20Z");

		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
}
