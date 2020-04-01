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

public class Auto_TC68778_Ohio_StaffEmail_Validation extends BaseTest
{
	private DataGenerator_staff_v1 dataGenerator=new DataGenerator_staff_v1();
	private DbVerifier_staff_v1 dbVerifier=new DbVerifier_staff_v1();
	private Map<String, String> jsonField =new HashMap<>();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_68778_Ohio_StaffEmail_Valid_length() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		// logger = extent.startTest("Auto_TC_68778_Ohio_StaffEmail_Valid_length");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffEmail, "abc@ohio.care");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		dataGenerator.processPositiveOhioStaffV1(jsonField);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_68778_Ohio_StaffEmail_invalid_length() throws Exception
	{	
		// logger = extent.startTest("Auto_TC_68778_Ohio_StaffEmail_invalid_length");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffEmail, CommonMethods.generateEmailAddress_alpha(50));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffEmail);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffEmailLengthError);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_68778_Ohio_StaffEmail_null() throws Exception
	{	
		// logger = extent.startTest("Auto_TC_68778_Ohio_StaffEmail_null");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffEmail,null);

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		dataGenerator.processPositiveOhioStaffV1(jsonField);
		
	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_68778_Ohio_StaffEmail_missing_value() throws Exception
	{	
		// logger = extent.startTest("Auto_TC_68778_Ohio_StaffEmail_missing_value");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffEmail,"");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffEmail);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffEmailFormatError);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_68778_Ohio_StaffEmail_invalid_value() throws Exception
	{	
		// logger = extent.startTest("Auto_TC_68778_Ohio_StaffEmail_invalid_value");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffEmail, CommonMethods.generateRandomStringOfFixLength(10));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);
		
		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffEmail);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffEmailFormatError);

	}
	
}
