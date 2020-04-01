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

public class SEVV_269_TC97746_Schedule_Validate_Account_field_null extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97746_Schedule_Validate_Account_field_null() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC97746_Schedule_Validate_Account_field_null");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Account", null);
	  
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Accountnullerror);
	}
	

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97746_Schedule_Validate_Account_field_blank() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC97746_Schedule_Validate_Account_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Account", "");
	  
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Accountformaterror);
	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97746_Schedule_Validate_Account_field_AlphaNumeric() throws IOException, ParseException {


		// logger = extent.startTest("TC97746_Schedule_Validate_Account_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		jsonObject.put("Account", CommonMethods.generateRandomAlphaNumeric(5));


		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));

		CommonMethods.verifyjsonassertpasscase(bodyAsString);
	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97746_Schedule_Validate_Account_field_InvalidLength() throws IOException, ParseException
	{


		// logger = extent.startTest("TC97746_Schedule_Validate_Account_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		jsonObject.put("Account", CommonMethods.generateRandomNumberOfFixLength(11));


		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Accountformaterror);
	}

}
