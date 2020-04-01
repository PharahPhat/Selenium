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

public class SEVV_269_TC97921_Schedule_Validate_ClientStatus_field extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97921_Schedule_Validate_ClientStatus_field_otherthan_allowed() throws IOException, ParseException
	{
		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		jsonObject.put("Status", "97");
	
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StatusFormatError);
	}
	
	@Test(groups = {"All",})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97921_Schedule_Validate_ClientStatus_field_null() throws IOException, ParseException, InterruptedException {
		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		jsonObject.put("Status", null);
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
	}
	
	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97921_Schedule_Validate_ClientStatus_field_blank() throws IOException, ParseException
	{
		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		jsonObject.put("Status", "");
	
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	@Test(groups = {"All",})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97921_Schedule_Validate_ClientStatus_field_allowed() throws IOException, ParseException, InterruptedException {
		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		jsonObject.put("Status", "01");
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}

}
