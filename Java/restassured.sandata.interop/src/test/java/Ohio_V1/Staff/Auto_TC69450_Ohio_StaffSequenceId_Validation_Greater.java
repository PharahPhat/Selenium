package Ohio_V1.Staff;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
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

public class Auto_TC69450_Ohio_StaffSequenceId_Validation_Greater extends BaseTest
{
	private DataGenerator_staff_v1 dataGenerator=new DataGenerator_staff_v1();
	private DbVerifier_staff_v1 dbVerifier=new DbVerifier_staff_v1();
	private Map<String, String> jsonField =new HashMap<>();
//
//	@Test(groups = {"All", "Regression"})
//	@AdditionalInfo(module = "OhioStaff")
//	@Phat -Duplicate -TC65184
	public void Auto_TC_69450_Ohio_StaffSequenceId_Validation_Greater_Valid() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		// logger = extent.startTest("Auto_TC_69450_Ohio_StaffSequenceId_Validation_Greater_Valid");

		String seqId = CommonMethods.generateRandomNumberOfFixLength(16);
		
		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.sequenceId,seqId );

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		dataGenerator.processPositiveOhioStaffV1(jsonField);
		
		
		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.sequenceId,seqId);

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObjectdup=dataGenerator.processOhioStaffV1(jsonField);
		
		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.DBVerify);
		dbVerifier.jsonAssert_StxStaffOhioV1(returnObjectdup.get(GlobalVariable_staff_v1.jsonObject));	
		

	}
	
}
