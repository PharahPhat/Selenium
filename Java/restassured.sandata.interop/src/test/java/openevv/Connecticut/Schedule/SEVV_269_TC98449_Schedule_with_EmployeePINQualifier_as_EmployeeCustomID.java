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

public class SEVV_269_TC98449_Schedule_with_EmployeePINQualifier_as_EmployeeCustomID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC98449_Schedule_with_EmployeePINQualifier_as_EmployeeCustomID() throws IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, InterruptedException, ClassNotFoundException
	{


		// logger = extent.startTest("TC98449_Schedule_with_EmployeePINQualifier_as_EmployeeCustomID");

		JSONArray jsonArr=GenerateUniqueParam.Scheduling_Openevv();

		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		jsonObject.put("EmployeePINQualifier", globalVariables.EmployeeCustomID);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_schedule));


		CommonMethods.verifyjsonassertpasscase(bodyAsString);
	}


}
