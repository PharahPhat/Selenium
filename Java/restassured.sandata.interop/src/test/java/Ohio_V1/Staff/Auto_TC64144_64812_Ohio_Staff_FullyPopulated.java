package Ohio_V1.Staff;

import Utills_ExtentReport_Log4j.BaseTest;
import com.ohio.intake.staff.v1.DataGenerator_staff_v1;
import com.ohio.intake.staff.v1.DbVerifier_staff_v1;
import com.ohio.intake.staff.v1.GlobalVariable_staff_v1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Auto_TC64144_64812_Ohio_Staff_FullyPopulated extends BaseTest {

	private DataGenerator_staff_v1 dataGenerator=new DataGenerator_staff_v1();
	private Map<String, String> jsonField =new HashMap<>();
	
	@Test(groups = {"All", "Regression"})
	public void TC_64144_64812_Ohio_Staff_FullyPopulated() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("TC_64144_64812_Ohio_Staff_FullyPopulated");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		dataGenerator.processPositiveOhioStaffV1(jsonField);
	}
}
