package Ohio_V1.Staff;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
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

public class Auto_TC65351_Ohio_Staff_Required_Fields_Add_Optional_Fields extends BaseTest{
	
	private DataGenerator_staff_v1 dataGenerator=new DataGenerator_staff_v1();
	private DbVerifier_staff_v1 dbVerifier=new DbVerifier_staff_v1();
	private Map<String, String> jsonField =new HashMap<>();
	
	@Test(groups = {"All", "Smoke"})
	public void TC_65351_Ohio_Staff_Required_Fields_Add_Optional_Fields() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("TC_65351_Ohio_Staff_Required_Fields_Add_Optional_Fields");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1RequiredWithRequiredSegment(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		returnObject.get("jsonObject").put(GlobalVariable_staff_v1.staffEmail, CommonMethods.generateEmailAddress_alpha(10));
		returnObject.get("jsonObject").put(GlobalVariable_staff_v1.staffPosition, DataGenerator_staff_v1.generateStaffPosition(1));
		
		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObjectRe=dataGenerator.processOhioStaffV1(returnObject.get("jsonObject"));
		
		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.DBVerify);
		dbVerifier.jsonAssert_StxStaffOhioV1(returnObjectRe.get(GlobalVariable_staff_v1.jsonObject));	
			
	}

}
