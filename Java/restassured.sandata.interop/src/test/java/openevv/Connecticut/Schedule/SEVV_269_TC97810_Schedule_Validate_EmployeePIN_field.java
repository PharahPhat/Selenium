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



public class SEVV_269_TC97810_Schedule_Validate_EmployeePIN_field extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97810_Schedule_Validate_EmployeePIN_field_blank() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97810_Schedule_Validate_EmployeePIN_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("EmployeePIN", "");
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, 
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePINlengtherror);
		
	}
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97810_Schedule_Validate_EmployeePIN_field_null() throws IOException, ParseException
	{


		// logger = extent.startTest("TC97810_Schedule_Validate_EmployeePIN_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		jsonObject.put("EmployeePIN", null);


		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, 
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePINnullerror);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97810_Schedule_Validate_EmployeePIN_field_ALLCHARACTER() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97810_Schedule_Validate_EmployeePIN_field_ALLCHARACTER");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("EmployeePIN", CommonMethods.generateRandomStringOfFixLength(6));
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, 
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePINformaterror);
		
	}
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97810_Schedule_Validate_EmployeePIN_field_SpeicalCHARACTER() throws IOException, ParseException
	{


		// logger = extent.startTest("TC97810_Schedule_Validate_EmployeePIN_field_ALLCHARACTER");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		jsonObject.put("EmployeePIN", CommonMethods.generateSpecialChar(6));


		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, 
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePINformaterror);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97810_Schedule_Validate_EmployeePIN_field_morethan_allowed() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97810_Schedule_Validate_EmployeePIN_field_morethan_allowed");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(10));
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, 
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePINlengtherror);
		
	}
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97810_Schedule_Validate_EmployeePIN_field_valid() throws IOException, ParseException{


		// logger = extent.startTest("TC97810_Schedule_Validate_EmployeePIN_field_morethan_allowed");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		jsonObject.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(9));


		CommonMethods.validateResponse(jsonArr, 
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97810_Schedule_Validate_EmployeePIN_field_valid_less_then_9() throws IOException, ParseException{


			// logger = extent.startTest("TC97810_Schedule_Validate_EmployeePIN_field_morethan_allowed");

			JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");

			JSONObject jsonObject = (JSONObject) jsonArr.get(0);

			jsonObject.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(5));
			
			CommonMethods.validateResponse(jsonArr, 
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
			
		}
}
