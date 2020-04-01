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

public class SEVV_269_TC97857_Schedule_Validate_Modifiers_field extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97857_Schedule_Validate_Modifier1_morethan_allowed_length() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97857_Schedule_Validate_Modifier1_morethan_allowed_length");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Modifier1", CommonMethods.generateRandomNumberOfFixLength(3));
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier1LengthError_OpenEVV);
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97857_Schedule_Validate_Modifier2_morethan_allowed_length() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97857_Schedule_Validate_Modifier2_morethan_allowed_length");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		jsonObject.put("Modifier2", CommonMethods.generateRandomNumberOfFixLength(3));
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier2LengthError_OpenEVV);
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97857_Schedule_Validate_Modifier3_morethan_allowed_length() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97857_Schedule_Validate_Modifier3_morethan_allowed_length");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		
		jsonObject.put("Modifier3", CommonMethods.generateRandomNumberOfFixLength(3));
	
		
	
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier3LengthError_OpenEVV);
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97857_Schedule_Validate_Modifier4_morethan_allowed_length() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97857_Schedule_Validate_Modifier4_morethan_allowed_length");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
	
		jsonObject.put("Modifier4", CommonMethods.generateRandomNumberOfFixLength(3));
		
	
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier4LengthError_OpenEVV);
		
	}
	

	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97857_Schedule_Validate_Modifier1_blank() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97857_Schedule_Validate_Modifier1_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Modifier1", "");
		
		
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97857_Schedule_Validate_Modifier2_blank() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97857_Schedule_Validate_Modifier2_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		
		jsonObject.put("Modifier2", "");
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97857_Schedule_Validate_Modifier3_blank() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97857_Schedule_Validate_Modifier3_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		
		jsonObject.put("Modifier3", "");
	
		
	
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97857_Schedule_Validate_Modifier4_blank() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97857_Schedule_Validate_Modifier4_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
	
		jsonObject.put("Modifier4", "");
		
	
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97857_Schedule_Validate_Modifier4_valid() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC97857_Schedule_Validate_Modifier4_valid");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Modifier4", CommonMethods.generateRandomNumberOfFixLength(2));
	
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97857_Schedule_Validate_Modifier3_valid() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC97857_Schedule_Validate_Modifier3_valid");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Modifier3", CommonMethods.generateRandomAlphaNumeric(2));
	
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97857_Schedule_Validate_Modifier2_valid() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC97857_Schedule_Validate_Modifier2_valid");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Modifier2", CommonMethods.generateRandomAlphaNumeric(2));
	
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97857_Schedule_Validate_Modifier1_valid() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC97857_Schedule_Validate_Modifier1_valid");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Modifier1", CommonMethods.generateRandomAlphaNumeric(2));
	
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		
	}
	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97857_Schedule_Validate_Modifier1_null() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC97857_Schedule_Validate_Modifier1_null");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Modifier1", null);
	
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97857_Schedule_Validate_Modifier2_null() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC97857_Schedule_Validate_Modifier2_null");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Modifier2", null);
	
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97857_Schedule_Validate_Modifier3_null() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC97857_Schedule_Validate_Modifier3_null");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Modifier3", null);
	
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97857_Schedule_Validate_Modifier4_null() throws IOException, ParseException
	{
		

		// logger = extent.startTest("TC97857_Schedule_Validate_Modifier4_null");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Modifier4", null);
	
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
}
