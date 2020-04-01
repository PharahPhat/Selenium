package openevv.Connecticut.Schedule;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV_269_TC97917_Schedule_Validate_Contract_field extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97917_Schedule_Validate_Contract_field_greaterthan_allowed() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException
	{
		

		// logger = extent.startTest("TC97917_Schedule_Validate_Contract_field_greaterthan_allowed");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Contract", CommonMethods.generateRandomNumberOfFixLength(10));
	
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ContractlengthError);
	}
	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97917_Schedule_Validate_Contract_field_blank() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException
	{
		

		// logger = extent.startTest("TC97917_Schedule_Validate_Contract_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("Contract", "");
	
		
		
		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97917_Schedule_Validate_Contract_field_null() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException, ClassNotFoundException
	{
		

		// logger = extent.startTest("TC97917_Schedule_Validate_Contract_field_null");

		 JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		jsonObject.put("Contract", null);

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));

	}
	
	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97917_Schedule_Validate_Contract_field_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException, ClassNotFoundException
	{
		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		jsonObject.put("Contract", CommonMethods.generateRandomAlphaNumeric(9));

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));

	}

}
