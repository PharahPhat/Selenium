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

public class SEVV_269_TC97920_Schedule_Validate_LiveInCase_field extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97920_Schedule_Validate_LiveInCase_field_otherthan_allowed() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC97920_Schedule_Validate_LiveInCase_field_otherthan_allowed");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("LiveInCase", CommonMethods.generateRandomNumberOfFixLength(1));
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.LiveInCaseFormatError);
	}
	
	@Test(groups = {"All",})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97920_Schedule_Validate_LiveInCase_field_null() throws IOException, ParseException, InterruptedException {
		


		// logger = extent.startTest("TC97920_Schedule_Validate_LiveInCase_field_null");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("LiveInCase", null);
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97920_Schedule_Validate_LiveInCase_field_blank() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97920_Schedule_Validate_LiveInCase_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("LiveInCase", "");

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	@Test(groups = {"All",})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97920_Schedule_Validate_LiveInCase_field_allowed_Y() throws IOException, ParseException, InterruptedException {
		


		// logger = extent.startTest("TC97920_Schedule_Validate_LiveInCase_field_allowed");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("LiveInCase", "Y");

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	@Test(groups = {"All",})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97920_Schedule_Validate_LiveInCase_field_allowed_N() throws IOException, ParseException, InterruptedException {



		// logger = extent.startTest("TC97920_Schedule_Validate_LiveInCase_field_allowed");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		jsonObject.put("LiveInCase", "N");

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
}
