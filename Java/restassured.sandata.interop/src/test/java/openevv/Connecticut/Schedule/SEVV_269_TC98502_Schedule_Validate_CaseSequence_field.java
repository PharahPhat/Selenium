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

public class SEVV_269_TC98502_Schedule_Validate_CaseSequence_field extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98502_Schedule_Validate_CaseSequence_field_blank() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC98502_Schedule_Validate_CaseSequence_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("CaseSequence", "");
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98502_Schedule_Validate_CaseSequence_field_greaterthan_allowed() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC98502_Schedule_Validate_CaseSequence_field_greaterthan_allowed");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("CaseSequence", CommonMethods.generateRandomNumberOfFixLength(5));
	
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CaseSequencelengtherror_Schedule);
	}
	
	@Test(groups = {"All",})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98502_Schedule_Validate_CaseSequence_field_allowed_nemric_valid() throws IOException, ParseException, InterruptedException {
		

		// logger = extent.startTest("TC98502_Schedule_Validate_CaseSequence_field_allowed_nemric_valid");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("CaseSequence", CommonMethods.generateRandomNumberOfFixLength(2));
	
		
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98502_Schedule_Validate_CaseSequence_field_allowed_alphanemric_valid() throws IOException, ParseException, InterruptedException {
		

		// logger = extent.startTest("TC98502_Schedule_Validate_CaseSequence_field_allowed_alphanemric_valid");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("CaseSequence", CommonMethods.generateRandomAlphaNumeric(3));
	
		
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98502_Schedule_Validate_CaseSequence_field_specialcharacter_invalid() throws IOException, ParseException, InterruptedException {
		

		// logger = extent.startTest("TC98502_Schedule_Validate_CaseSequence_field_specialcharacter_invalid");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("CaseSequence", CommonMethods.generateRandomAlphaNumeric(1)+"@"+ CommonMethods.generateRandomAlphaNumeric(1));
	
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.CaseSequenceformaterror_Schedule);
	}
	

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98502_Schedule_Validate_CaseSequence_field_null() throws IOException, ParseException, InterruptedException {
		
		
		// logger = extent.startTest("TC98502_Schedule_Validate_CaseSequence_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("CaseSequence", null);
	
		
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		
		
	}
}
