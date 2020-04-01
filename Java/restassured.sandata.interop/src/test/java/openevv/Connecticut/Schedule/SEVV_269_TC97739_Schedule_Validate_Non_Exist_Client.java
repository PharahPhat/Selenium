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

public class SEVV_269_TC97739_Schedule_Validate_Non_Exist_Client extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Regression", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97739_Schedule_Validate_Non_Exist_Client() throws IOException, ParseException, InterruptedException
	{
		JSONArray jsonArr=GenerateUniqueParam.Schedule_OpenEVV("Schedule");
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		jsonObject.put("ClientID", "96007");

		String bodyAsString = CommonMethods.captureGetResponse(jsonArr,
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule),
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "Client not found");
	}
}
