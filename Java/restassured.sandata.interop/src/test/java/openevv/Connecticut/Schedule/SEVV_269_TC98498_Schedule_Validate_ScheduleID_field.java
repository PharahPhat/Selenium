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



public class SEVV_269_TC98498_Schedule_Validate_ScheduleID_field extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Smoke"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98498_Schedule_Validate_ScheduleID_field_blank() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC98498_Schedule_Validate_ScheduleID_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleID", "");
	
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr,
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ScheduleIDemptyerror);
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98498_Schedule_Validate_ScheduleID_field_greaterthan_allowed() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC98498_Schedule_Validate_ScheduleID_field_greaterthan_allowed");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleID", CommonMethods.generateRandomAlphaNumeric(41));
	
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ScheduleIDlengtherror);
	}
	
	@Test(groups = {"All",})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98498_Schedule_Validate_ScheduleID_field_with_specialcharacter() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC98498_Schedule_Validate_ScheduleID_field_with_specialcharacter");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleID", CommonMethods.generateRandomAlphaNumeric(10)+"@"+CommonMethods.generateRandomAlphaNumeric(13));
	
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ScheduleIDerror);
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98498_Schedule_Validate_ScheduleID_field_alphanumeric() throws IOException, ParseException, InterruptedException {
		

		// logger = extent.startTest("TC98498_Schedule_Validate_ScheduleID_field_alphanumeric");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleID", CommonMethods.generateRandomAlphaNumeric(23));
	
		
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98498_Schedule_Validate_ScheduleID_field_character() throws IOException, ParseException, ClassNotFoundException, InterruptedException {
		

		// logger = extent.startTest("TC98498_Schedule_Validate_ScheduleID_field_character");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleID", CommonMethods.generateRandomStringOfFixLength(18));
	
		
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98498_Schedule_Validate_ScheduleID_field_numeric() throws IOException, ParseException, InterruptedException
	{
		

		// logger = extent.startTest("TC98498_Schedule_Validate_ScheduleID_field_numeric");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ScheduleID", CommonMethods.generateRandomNumberOfFixLength(12));
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
	}
}
