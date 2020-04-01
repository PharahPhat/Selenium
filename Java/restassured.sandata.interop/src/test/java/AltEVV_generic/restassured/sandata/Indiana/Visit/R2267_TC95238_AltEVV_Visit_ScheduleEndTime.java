package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@MayankM

OpenEVV-altEVV- Visits- VisitOtherID field formats/values

 */

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class R2267_TC95238_AltEVV_Visit_ScheduleEndTime extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void R2267_TC95238_Visit_ScheduleEndTime_null() throws InterruptedException, IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("R2267_TC95238_Visit_ScheduleEndTime_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson,null);
		
		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95238_Visit_ScheduleEndTime_invalid() throws InterruptedException, IOException, ParseException {

		// logger = extent.startTest("R2267_TC95238_Visit_ScheduleEndTime_invalid");

		Date date = new Date();
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson,date);
		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson,CommonMethods.generatePastDate_YYYY_MM_dd()+ "T06:47:57Z");

		CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95237_Visit_ScheduleEndTime_less_than_ScheduleStartTime() throws InterruptedException,
			IOException, ParseException {

		// logger = extent.startTest("R2267_TC95237_Visit_ScheduleStartTime_greater_than_ScheduleEndTime");

		Date date = new Date();
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson,date);
		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson,CommonMethods.generateFutureDate_YYYY_MM_dd()+ "T06:47:57Z");

		CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}


}
