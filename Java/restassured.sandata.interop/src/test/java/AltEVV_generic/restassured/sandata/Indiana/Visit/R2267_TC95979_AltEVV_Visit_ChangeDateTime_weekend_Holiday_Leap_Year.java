package AltEVV_generic.restassured.sandata.Indiana.Visit;

import java.io.FileNotFoundException;
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

/**
 * @author Anupam
 *
 */
import com.globalMethods.core.Assertion_DbVerifier; public class R2267_TC95979_AltEVV_Visit_ChangeDateTime_weekend_Holiday_Leap_Year extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Case1: Validating "ChangeDateTime" field passed which falls under Weekends(Saturday/Sunday) 
	@Test(groups = {"All"})
	public void R2267_TC95979_AltEVV_VisitCreation_in_Weekends_in_CalenderDays() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

		// logger = extent.startTest("R2267_TC95979_AltEVV_VisitCreation_ChangeDateTime_passed_with_weekend");

		logger.log(LogStatus.INFO, "Validating R2267_TC95979_AltEVV_VisitCreation with ChangeDateTime_passed_with_weekend"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.ChangeDateTime, "2018-10-07T19:02:26Z");

		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	//Case2: Validating ChangeDateTime dates which fall under Holidays 
	@Test(groups = {"All"})
	public void R2267_TC95979_AltEVV_VisitCreation_ChangeDateTime_with_Holidays_in_CalenderDays() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

		// logger = extent.startTest("R2267_TC95979_AltEVV_VisitCreation_ChangeDateTime_with_Holidays_in_CalenderDays");

		logger.log(LogStatus.INFO, "Validating R2267_TC95979_AltEVV_VisitCreation_ChangeDateTime_with_Holidays_in_CalenderDays"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);

		jsonObjectVisitChanges.put(globalVariables.ChangeDateTime, "2018-09-03T10:02:26Z");

		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	//Case3: Validating VisitCreation_ChangeDateTime dates which fall in leap year (visit creation successful)
	@Test(groups = {"All"})
	public void R2267_TC95979_AltEVV_VisitCreation_ChangeDateTime_falls_in_leap_year_Calender() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

		// logger = extent.startTest("R2267_TC95979_AltEVV_VisitCreation_ChangeDateTime_falls_in_leap_year_Calender");

		logger.log(LogStatus.INFO, "Validating R2267_TC95979_AltEVV_VisitCreation_ChangeDateTime_falls_in_leap_year_Calender"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);

		jsonObjectVisitChanges.put(globalVariables.ChangeDateTime, "2016-02-29T10:02:26Z");

		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
}
