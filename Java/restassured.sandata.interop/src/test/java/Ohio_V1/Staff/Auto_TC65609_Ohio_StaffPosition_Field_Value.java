package Ohio_V1.Staff;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
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

public class Auto_TC65609_Ohio_StaffPosition_Field_Value extends BaseTest
{
	private DataGenerator_staff_v1 dataGenerator=new DataGenerator_staff_v1();
	private DbVerifier_staff_v1 dbVerifier=new DbVerifier_staff_v1();
	private Map<String, String> jsonField =new HashMap<>();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65609_Ohio_staffPosition_Valid() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		// logger = extent.startTest("Auto_TC_65609_Ohio_staffPosition_Valid");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		
			jsonField.put(GlobalVariable_staff_v1.staffPosition, null);

			logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
			dataGenerator.processPositiveOhioStaffV1(jsonField);
	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65609_Ohio_staffPosition_invalid_length() throws Exception
	{	
		// logger = extent.startTest("Auto_TC_65609_Ohio_staffPosition_invalid_length");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffPosition, CommonMethods.generateRandomStringOfFixLength(4));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffPosition);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffPositionlengthError);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65609_Ohio_staffPosition_Invalid_Null() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		// logger = extent.startTest("Auto_TC_65609_Ohio_staffPosition_Valid");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		
			jsonField.put(GlobalVariable_staff_v1.staffPosition,CommonMethods.generateRandomStringOfFixLength(3));

			logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
			Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

			logger.log(LogStatus.INFO, GlobalVariable_staff_v1.DBVerify);
			dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffPositionlengthError);
	}
}
