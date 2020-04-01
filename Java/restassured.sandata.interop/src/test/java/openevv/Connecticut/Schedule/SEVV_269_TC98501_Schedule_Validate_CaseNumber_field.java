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

public class SEVV_269_TC98501_Schedule_Validate_CaseNumber_field  extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98501_Schedule_Validate_CaseNumber_field_blank() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("SEVV_2106_TC97055_Validate_message_summary_in_case_error_in_sub_segments_of_get");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("CaseNumber", "");
	
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98501_Schedule_Validate_CaseNumber_field_greaterthan_allowed() throws IOException, ParseException
	{
		

		// logger = extent.startTest("SEVV_2106_TC97055_Validate_message_summary_in_case_error_in_sub_segments_of_get");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("CaseNumber", CommonMethods.generateRandomAlphaNumeric(10));
	
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CaseSequencelengtherror);
	}
	
	@Test(groups = {"All",})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98501_Schedule_Validate_CaseNumber_field_numeric_valid() throws IOException, ParseException, InterruptedException {
		

		// logger = extent.startTest("SEVV_2106_TC97055_Validate_message_summary_in_case_error_in_sub_segments_of_get");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("CaseNumber", CommonMethods.generateRandomNumberOfFixLength(9));
	
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98501_Schedule_Validate_CaseNumber_field_alphanumeric_valid() throws IOException, ParseException, InterruptedException {
		

		// logger = extent.startTest("SEVV_2106_TC97055_Validate_message_summary_in_case_error_in_sub_segments_of_get");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("CaseNumber", CommonMethods.generateRandomAlphaNumeric(9));
	
		
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98501_Schedule_Validate_CaseNumber_field_underscore_valid() throws IOException, ParseException, InterruptedException {
		

		// logger = extent.startTest("SEVV_2106_TC97055_Validate_message_summary_in_case_error_in_sub_segments_of_get");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("CaseNumber", CommonMethods.generateRandomAlphaNumeric(4)+ "_"+CommonMethods.generateRandomAlphaNumeric(3) );
	
		
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}

}
