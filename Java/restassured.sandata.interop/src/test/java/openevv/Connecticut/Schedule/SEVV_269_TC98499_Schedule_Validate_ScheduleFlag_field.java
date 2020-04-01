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

 public class SEVV_269_TC98499_Schedule_Validate_ScheduleFlag_field extends BaseTest {
 	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
 	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98499_Schedule_Validate_ScheduleFlag_field_blank() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("_TC98499_Schedule_Validate_ScheduleFlag_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleFlag", "");

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98499_Schedule_Validate_ScheduleFlag_field_greaterthan_allowed() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC98499_Schedule_Validate_ScheduleFlag_field_greaterthan_allowed");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleFlag", CommonMethods.generateRandomNumberOfFixLength(2));
	
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ScheduleFlagformaterror);
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98499_Schedule_Validate_ScheduleFlag_field_valid_1() throws IOException, ParseException, InterruptedException {
		

		// logger = extent.startTest("TC98499_Schedule_Validate_ScheduleFlag_field_valid_1");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleFlag", "1");
	
		
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98499_Schedule_Validate_ScheduleFlag_field_valid_0() throws IOException, ParseException, InterruptedException {
		

		// logger = extent.startTest("TC98499_Schedule_Validate_ScheduleFlag_field_valid_0");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleFlag", "0");
	
		
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		
	}
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98499_Schedule_Validate_ScheduleFlag_field_otherthan_allowed_numeric() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC98499_Schedule_Validate_ScheduleFlag_field_otherthan_allowed_numeric");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleFlag", "3");
	
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ScheduleFlagformaterror);
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98499_Schedule_Validate_ScheduleFlag_field_otherthan_allowed_character() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC98499_Schedule_Validate_ScheduleFlag_field_otherthan_allowed_character");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleFlag", CommonMethods.generateRandomStringOfFixLength(1));
	
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ScheduleFlagformaterror);
	}

}
