package openevv.Connecticut.Schedule;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV_269_TC97732_Schedule_fully_populated extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All","Regression", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97732_Schedule_fully_populated() throws IOException, ParseException, SQLException, java.text.ParseException, InterruptedException, ClassNotFoundException
	{
		
		// logger = extent.startTest("TC97732_Schedule_fully_populated");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		String bodyAsString = CommonMethods.verifyPostResponseOPENEVV(jsonArr,
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule),
				CommonMethods.propertyfileReader(globalVariables.openevv_schedule_get));
		
		assertionDbVerifier.jsonAssert_STXSchedule(bodyAsString, jsonObject);
	}

}
