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

public class Auto_TC65350_Ohio_Staff_Required_Fields_Update extends BaseTest {
	
	private DataGenerator_staff_v1 dataGenerator=new DataGenerator_staff_v1();
	private DbVerifier_staff_v1 dbVerifier=new DbVerifier_staff_v1();
	private Map<String, String> jsonField =new HashMap<>();
	
	@Test(groups = {"All", "Regression"})
	public void TC_65350_Ohio_Staff_Required_Fields_Update() throws ClassNotFoundException, InterruptedException, SQLException, IOException, ParseException, java.text.ParseException{
		
		// logger = extent.startTest("TC_65350_Ohio_Staff_Required_Fields_Update");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		@SuppressWarnings("unused")
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1RequiredWithRequiredSegment(jsonField);
		
		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffSSN, CommonMethods.generateRandomNumberOfFixLength(9));
		jsonField.put(GlobalVariable_staff_v1.staffFName, CommonMethods.generateRandomStringOfFixLength(10));
		jsonField.put(GlobalVariable_staff_v1.staffLName, CommonMethods.generateRandomStringOfFixLength(10));
		
		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObjectRe=dataGenerator.processOhioStaffV1RequiredWithRequiredSegment(jsonField);
		
		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.DBVerify);
		dbVerifier.jsonAssert_StxStaffOhioV1(returnObjectRe.get(GlobalVariable_staff_v1.jsonObject));	
		
	}

}
