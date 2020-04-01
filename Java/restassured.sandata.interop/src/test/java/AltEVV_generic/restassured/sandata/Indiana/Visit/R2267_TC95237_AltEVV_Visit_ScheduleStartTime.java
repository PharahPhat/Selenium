package AltEVV_generic.restassured.sandata.Indiana.Visit;

/*
@MayankM

OpenEVV-altEVV- Visits- VisitOtherID field formats/values

 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2267_TC95237_AltEVV_Visit_ScheduleStartTime extends BaseTest { 
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void R2267_TC95237_Visit_ScheduleStartTime_null() throws InterruptedException, IOException, ParseException {

		// logger = extent.startTest("R2267_TC95237_Visit_ScheduleStartTime_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson, null);
		
		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95237_Visit_ScheduleStartTime_invalid() throws InterruptedException, IOException, ParseException {

		// logger = extent.startTest("R2267_TC95237_Visit_ScheduleStartTime_invalid");

		Date date = new Date();
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson,date);
		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson,CommonMethods.generateFutureDate_YYYY_MM_dd()+ "T06:47:57Z");


		CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	@Test(groups = {"All"})
	public void R2267_TC95237_Visit_ScheduleStartTime_greater_than_ScheduleEndTime() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("R2267_TC95237_Visit_ScheduleStartTime_greater_than_ScheduleEndTime");

		Date date = new Date();
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson,date);
		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson,CommonMethods.generateFutureDate_YYYY_MM_dd()+ "T06:47:57Z");


		CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

}
