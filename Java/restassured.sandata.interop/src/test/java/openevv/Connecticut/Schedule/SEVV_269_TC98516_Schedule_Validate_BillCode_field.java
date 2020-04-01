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

public class SEVV_269_TC98516_Schedule_Validate_BillCode_field extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_269_TC98516_Schedule_Validate_BillCode_field_blank() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException
	{
		
		// logger = extent.startTest("SEVV_269_TC98516_Schedule_Validate_BillCode_field_blank");

		JSONArray j=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		JSONObject jsonObject = (JSONObject) j.get(0);

		jsonObject.put(globalVariables.Billcode, "");
		
		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_269_TC98516_Schedule_Validate_BillCode_field_greaterthan_allowed() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException
	{
		
		// logger = extent.startTest("SEVV_269_TC98516_Schedule_Validate_BillCode_field_greaterthan_allowed");

		JSONArray j=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		JSONObject jsonObject = (JSONObject) j.get(0);

		jsonObject.put(globalVariables.Billcode, CommonMethods.generateRandomNumberOfFixLength(6));
		
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.billcodelengtherror);
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_269_TC98516_Schedule_Validate_BillCode_field_null() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException
	{
		
		// logger = extent.startTest("SEVV_269_TC98516_Schedule_Validate_BillCode_field_null");

		JSONArray j=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		JSONObject jsonObject = (JSONObject) j.get(0);

		jsonObject.put(globalVariables.Billcode, null);
		
		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void SEVV_269_TC98516_Schedule_Validate_BillCode_field_alphanumeric() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException
	{
		
		// logger = extent.startTest("SEVV_269_TC98516_Schedule_Validate_BillCode_field_alphanumeric");

		JSONArray j=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		JSONObject jsonObject = (JSONObject) j.get(0);

		jsonObject.put(globalVariables.Billcode, CommonMethods.generateSpecialChar(5));
		
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.billcodeformaterror);
	}
	
	

}
