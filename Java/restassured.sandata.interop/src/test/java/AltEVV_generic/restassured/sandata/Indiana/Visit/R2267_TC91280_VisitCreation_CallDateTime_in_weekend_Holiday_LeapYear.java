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

public class R2267_TC91280_VisitCreation_CallDateTime_in_weekend_Holiday_LeapYear extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	//Total visit time can not exceeds 24hrs as per specification 7.2x
	//Case1: Validating visit should be created successfully when CallDateTime passed with "weekend" in calendar days
	@Test(enabled = false, groups = {"All"})
	public void R2267_TC91280_AltEVV_VisitCreation_CallDateTime_in_weekend_Holiday_LeapYear() throws InterruptedException,
			IOException, ParseException {


		// logger = extent.startTest("R2267_TC91280_AltEVV_VisitCreation_CallDateTime_in_weekend_Holiday_LeapYear");

		logger.log(LogStatus.INFO, "Validating VisitCreation_with_CallDateTime_falls_in_weekend_in_CalenderDays"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisit.put(globalVariables.AdjInDateTime, "2016-12-25T19:02:26Z");
		jsonObjectVisit.put(globalVariables.AdjOutDateTime, "2016-12-25T20:02:26Z");
		jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, "2016-12-25T19:02:26Z");
		JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges1.put(globalVariables.CallDateTimejson, "2016-12-25T20:02:26Z");

		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	//Case2: Validating visit should be created successfully when CallDateTime passed with "weekend-Saturday" in calendar days
	@Test(groups = {"All"})
	public void R2267_TC91280_AltEVV_VisitCreation_CallDateTime_in_weekend_Saturday() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

		// logger = extent.startTest("R2267_TC91280_AltEVV_VisitCreation_CallDateTime_in_weekend_Saturday");

		logger.log(LogStatus.INFO, "Validating VisitCreation_with_CallDateTime_falls_in_weekend_Saturday_in_CalenderDays"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleStartTime, "2019-08-03T08:02:26Z");
		jsonObjectVisit.put(globalVariables.ScheduleEndTime, "2019-08-03T11:02:20Z");
		
		jsonObjectVisit.remove("AdjInDateTime");
		jsonObjectVisit.remove("AdjOutDateTime");

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, "2019-08-03T08:02:26Z");
		JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges1.put(globalVariables.CallDateTimejson, "2019-08-03T10:02:20Z");

		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	//Case3: Validating CallDateTime dates which fall under Holidays 
	@Test(groups = {"All"})
	public void R2267_TC91280_AltEVV_VisitCreation_CallDateTime_with_Holidays() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

		// logger = extent.startTest("R2267_TC91280_AltEVV_VisitCreation_CallDateTime_with_Holidays");

		logger.log(LogStatus.INFO, "Validating VisitCreation_CallDateTime_fall_under_Holidays_in_CalenderDays"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		jsonObjectVisit.remove(globalVariables.AdjOutDateTime,"2018-09-03T10:02:26Z");
		jsonObjectVisit.remove(globalVariables.AdjInDateTime,"2018-09-03T22:02:20Z");

		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	//Case4: Validating CallDateTime dates which fall in leap year (visit creation successful)

	@Test(groups = {"All"})
	public void R2267_TC91280_AltEVV_VisitCreation_CallDateTime_in_leapYear() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

		// logger = extent.startTest("R2267_TC91280_AltEVV_VisitCreation_CallDateTime_in_leapYear");

		logger.log(LogStatus.INFO, "Validating VisitCreation_CallDateTime_falls_in_leapYear"); 
	

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.remove(globalVariables.AdjOutDateTime,"2016-02-29T03:02:20Z");
		jsonObjectVisit.remove(globalVariables.AdjInDateTime,"2016-02-29T02:02:26Z");

		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
}
