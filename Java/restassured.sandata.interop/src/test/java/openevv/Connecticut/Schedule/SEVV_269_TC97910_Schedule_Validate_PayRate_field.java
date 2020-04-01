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

 public class SEVV_269_TC97910_Schedule_Validate_PayRate_field extends BaseTest {
 	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97910_Schedule_Validate_PayRate_field_morethan_allowed_length() throws IOException, ParseException
	{
		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("PayRate", CommonMethods.generateRandomNumberOfFixLength(6));
	
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayRatelengtherror);
	}

	 @Test(groups = {"All", "Regression"})
	 @AdditionalInfo(module = "OpenEVV")
	 public void TC97910_Schedule_Validate_PayRate_field_Null() throws IOException, ParseException {
		 JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");

		 JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		 jsonObject.put("PayRate", null);
		 
		 CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	 }
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97910_Schedule_Validate_PayRate_field_integer() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC97911_Schedule_Validate_BillRate_field_integer");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("PayRate", CommonMethods.generateRandomNumberOfFixLength(5));
	
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	
	}
	
	
	@Test(groups = {"All",})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97910_Schedule_Validate_PayRate_field_decimal_valid() throws IOException, ParseException, InterruptedException {
		

		// logger = extent.startTest("TC97911_Schedule_Validate_BillRate_field_decimal_valid");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("PayRate", CommonMethods.getRandomDouble_Two_Decimal(2, 2));
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
}
