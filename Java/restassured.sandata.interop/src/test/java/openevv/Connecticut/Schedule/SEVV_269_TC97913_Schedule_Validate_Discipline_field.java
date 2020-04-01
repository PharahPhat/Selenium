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

 public class SEVV_269_TC97913_Schedule_Validate_Discipline_field extends BaseTest {
 	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
 	
	@Test(groups = {"All", "Smoke"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97913_Schedule_Validate_Discipline_field_blank() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97913_Schedule_Validate_Discipline_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Discipline", "");
	
		
		
		CommonMethods.validateResponse(jsonArr,
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97913_Schedule_Validate_Discipline_field_greaterthan_allowed() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC97913_Schedule_Validate_Discipline_field_greaterthan_allowed");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Discipline", CommonMethods.generateRandomNumberOfFixLength(18));
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, 
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Disciplineerror);
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97913_Schedule_Validate_Discipline_field_null() throws IOException, ParseException, InterruptedException {
		

		// logger = extent.startTest("TC97913_Schedule_Validate_Discipline_field_null");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Discipline", null);
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	@Test(groups = {"All","Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97913_Schedule_Validate_Discipline_field_valid() throws IOException, ParseException, InterruptedException {
		

		// logger = extent.startTest("TC97913_Schedule_Validate_Discipline_field_valid");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Discipline", CommonMethods.generateRandomNumberOfFixLength(17));

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	
	
	

}
