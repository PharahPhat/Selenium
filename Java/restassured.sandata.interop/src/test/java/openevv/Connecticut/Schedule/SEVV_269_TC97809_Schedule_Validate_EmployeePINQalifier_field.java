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

public class SEVV_269_TC97809_Schedule_Validate_EmployeePINQalifier_field extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97809_Schedule_Validate_EmployeePINQalifier_field_blank() throws IOException, ParseException
	{
		
		
		// logger = extent.startTest("TC97809_Schedule_Validate_EmployeePINQalifier_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		jsonObject.put("EmployeePINQualifier", "");
	
		
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr,
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePINQualifierformaterror);
		
	}
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97809_Schedule_Validate_EmployeePINQalifier_field_null() throws IOException, ParseException
	{


		// logger = extent.startTest("TC97809_Schedule_Validate_EmployeePINQalifier_field_blank");

		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);

		jsonObject.put("EmployeePINQualifier", null);



		String bodyAsString = CommonMethods.capturePostResponse(jsonArr,
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeePINQualifierformaterrorNull);

	}


}
