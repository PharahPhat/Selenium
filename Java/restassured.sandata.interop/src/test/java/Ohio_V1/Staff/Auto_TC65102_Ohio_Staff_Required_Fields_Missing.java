package Ohio_V1.Staff;

import Utills_ExtentReport_Log4j.BaseTest;
import com.ohio.intake.staff.v1.DataGenerator_staff_v1;
import com.ohio.intake.staff.v1.GlobalVariable_staff_v1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Auto_TC65102_Ohio_Staff_Required_Fields_Missing extends BaseTest {
	
	private DataGenerator_staff_v1 dataGenerator=new DataGenerator_staff_v1();
	private Map<String, String> jsonField =new HashMap<>();
	
	@Test(groups = {"All", "Regression"})
	public void TC_65102_Ohio_Staff_Required_Fields_Missing() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("TC_65102_Ohio_Staff_Required_Fields_Missing");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);

		dataGenerator.processOhioStaffV1RequiredSegmentMissing(jsonField);
	}

}
