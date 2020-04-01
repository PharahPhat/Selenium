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

public class SEVV_269_TC97814_Schedule_Validate_ClientTimeZone_field extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97814_Schedule_Validate_ClientTimeZone_field() throws IOException, ParseException
	{
		// logger = extent.startTest("TC97814_Schedule_Validate_ClientTimeZone_field");
		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		jsonObject.put("ClientTimeZone", "");
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientTimeZoneformaterror);
	}
}
