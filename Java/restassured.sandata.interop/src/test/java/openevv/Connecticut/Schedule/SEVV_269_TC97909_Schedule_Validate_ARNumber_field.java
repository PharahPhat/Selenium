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

 public class SEVV_269_TC97909_Schedule_Validate_ARNumber_field extends BaseTest {
 	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97909_Schedule_Validate_ARNumber_field_morethan_allowed_length() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97909_Schedule_Validate_ARNumber_field_morethan_allowed_length");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ARNumber", CommonMethods.generateRandomNumberOfFixLength(11));
	
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ARNumberlengtherror);
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97909_Schedule_Validate_ARNumber_field_startwith_space() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97909_Schedule_Validate_ARNumber_field_startwith_space");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ARNumber", " " + CommonMethods.generateRandomNumberOfFixLength(9));
	
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ARNumberformaterror);
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97909_Schedule_Validate_ARNumber_field_endwith_space() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97909_Schedule_Validate_ARNumber_field_endwith_space");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ARNumber",CommonMethods.generateRandomNumberOfFixLength(9)+" ");
	
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ARNumberformaterror);
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97909_Schedule_Validate_ARNumber_field_blank() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97909_Schedule_Validate_ARNumber_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ARNumber","");

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	
	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97909_Schedule_Validate_ARNumber_field_valid() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC97909_Schedule_Validate_ARNumber_field_valid");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ARNumber", CommonMethods.generateRandomNumberOfFixLength(10));
	
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	
	@Test(groups = {"All",})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97909_Schedule_Validate_ARNumber_field_valid_alphanumeric() throws IOException, ParseException, InterruptedException {
		

		// logger = extent.startTest("TC97909_Schedule_Validate_ARNumber_field_valid_alphanumeric");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("ARNumber", CommonMethods.generateRandomAlphaNumeric(10));
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	@Test(groups = {"All",})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97909_Schedule_Validate_ARNumber_field_valid_null() throws IOException, ParseException, InterruptedException {
		

		// logger = extent.startTest("TC97909_Schedule_Validate_ARNumber_field_valid_null");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		 jsonObject.put("ARNumber","NULL");
		 
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
}
