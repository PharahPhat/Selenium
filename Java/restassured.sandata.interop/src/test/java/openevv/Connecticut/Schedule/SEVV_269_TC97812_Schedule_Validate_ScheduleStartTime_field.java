package openevv.Connecticut.Schedule;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

 public class SEVV_269_TC97812_Schedule_Validate_ScheduleStartTime_field extends BaseTest {

 	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97812_Schedule_Validate_ScheduleStartTime_field_blank() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97812_Schedule_Validate_ScheduleStartTime_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleStartTime", "");
	
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, 
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Schedulestarttimeerror);
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97813_Schedule_Validate_ScheduleEndTime_field_null() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97813_Schedule_Validate_ScheduleEndTime_field_null");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleStartTime", null);
	
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, 
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Schedulestarttimeerror);
		
	}
	
	@Test(groups = {"All", "Smoke"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97813_Schedule_Validate_ScheduleEndTime_field_invalid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException
	{
		
		
		// logger = extent.startTest("TC97813_Schedule_Validate_ScheduleEndTime_field_invalid");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleStartTime", CommonMethods.generateTodayDate_YYYY_MM_dd());
	
		
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr,
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Schedulestarttimeerror);
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97813_Schedule_Validate_ScheduleEndTime_greaterthan_ScheduleStartTime() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException
	{
		
		
		// logger = extent.startTest("TC97813_Schedule_Validate_ScheduleEndTime_field_invalid");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleEndTime", "2019-06-11T04:15:00Z");
		jsonObject.put("ScheduleStartTime", "2019-06-11T04:35:00Z");
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, 
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Scheduleendstarterror);
		
	}
	
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97813_Schedule_Validate_ScheduleEndTime_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException, ClassNotFoundException
	{
		

		// logger = extent.startTest("TC97813_Schedule_Validate_ScheduleEndTime_valid");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleStartTime", "2019-06-11T04:15:00Z");
	
		
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		
	}


}
