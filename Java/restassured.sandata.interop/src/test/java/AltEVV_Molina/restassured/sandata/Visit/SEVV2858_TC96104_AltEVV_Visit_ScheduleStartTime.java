	package AltEVV_Molina.restassured.sandata.Visit;

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

	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.sql.SQLException;
	import java.util.Date;

	public class SEVV2858_TC96104_AltEVV_Visit_ScheduleStartTime extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void SEVV2858_TC96104_Visit_ScheduleStartTime_null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{

		// logger = extent.startTest("SEVV2858_TC96104_Visit_ScheduleStartTime_null");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson, null);
		
		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All"})
	public void SEVV2858_TC96104_Visit_ScheduleStartTime_invalid() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("SEVV2858_TC96104_Visit_ScheduleStartTime_invalid");

		Date date = new Date();
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson,date);
		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson,CommonMethods.generateFutureDate_YYYY_MM_dd()+ "T06:47:57Z");

		CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	@Test(groups = {"All", "Smoke"})
	public void SEVV2858_TC96104_Visit_ScheduleStartTime_greater_than_ScheduleEndTime() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("SEVV2858_TC96104_Visit_ScheduleStartTime_greater_than_ScheduleEndTime");

		Date date = new Date();
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		jsonObjectVisit.put(globalVariables.ScheduleStartTimejson,date);
		jsonObjectVisit.put(globalVariables.ScheduleEndTimejson,CommonMethods.generateFutureDate_YYYY_MM_dd()+ "T06:47:57Z");

		CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

	}

}
