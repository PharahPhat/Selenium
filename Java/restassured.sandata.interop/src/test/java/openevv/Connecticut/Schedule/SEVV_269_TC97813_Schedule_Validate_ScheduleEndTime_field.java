package openevv.Connecticut.Schedule;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SEVV_269_TC97813_Schedule_Validate_ScheduleEndTime_field extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97813_Schedule_Validate_ScheduleEndTime_field_blank() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97813_Schedule_Validate_ScheduleEndTime_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleEndTime", "");
	
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Scheduleendtimeerror);
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97813_Schedule_Validate_ScheduleEndTime_field_null() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97813_Schedule_Validate_ScheduleEndTime_field_null");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleEndTime", null);
	
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Scheduleendtimeerror);
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97813_Schedule_Validate_ScheduleEndTime_field_invalid() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97813_Schedule_Validate_ScheduleEndTime_field_invalid");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleEndTime", CommonMethods.generateTodayDate_YYYY_MM_dd());
	
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Scheduleendtimeerror);
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97813_Schedule_Validate_ScheduleEndTime_greaterthan_ScheduleStartTime() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97813_Schedule_Validate_ScheduleEndTime_field_invalid");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleEndTime", "2019-06-11T04:15:00Z");
		jsonObject.put("ScheduleStartTime", "2019-06-11T04:35:00Z");
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Scheduleendstarterror);
		
	}

	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97813_Schedule_Validate_ScheduleEndTime_valid() throws IOException, ParseException, InterruptedException
	{
		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		jsonObject.put("ScheduleEndTime", "2019-06-11T04:55:00Z");
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
}
