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

public class SEVV_269_TC97915_Schedule_Validate_ProceedureCode_field extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97915_Schedule_Validate_ProcedureCode_field_blank() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException, ClassNotFoundException
	{


		// logger = extent.startTest("TC97915_Schedule_Validate_ProceedureCode_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		jsonObject.put("ProcedureCode", "");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ProcedureCodevalueError);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97915_Schedule_Validate_ProcedureCode_field_greaterthan_allowed() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException
	{


		// logger = extent.startTest("TC97915_Schedule_Validate_ProceedureCode_field_greaterthan_allowed");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		jsonObject.put("ProcedureCode", CommonMethods.generateRandomAlphaNumeric(6));


		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ProcedureCodevalueError);
	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97915_Schedule_Validate_ProceedureCode_field_null() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException
	{


		// logger = extent.startTest("TC97915_Schedule_Validate_ProceedureCode_field_null");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		jsonObject.put("ProcedureCode", null);



		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ProcedureCode cannot be null.");
	}

	@Test(groups = {"All",})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97915_Schedule_Validate_ProceedureCode_field_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException, ClassNotFoundException
	{


		// logger = extent.startTest("TC97915_Schedule_Validate_ProceedureCode_field_valid");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		jsonObject.put("ProcedureCode", CommonMethods.generateRandomAlphaNumeric(5));



		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
	}

	@Test(groups = {"All",})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97915_Schedule_Validate_ProceedureCode_field_integer_valid() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException, ClassNotFoundException
	{


		// logger = extent.startTest("TC97915_Schedule_Validate_ProceedureCode_field_integer_valid");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		jsonObject.put("ProcedureCode", CommonMethods.generateRandomNumberOfFixLength(5));

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));

	}



}
