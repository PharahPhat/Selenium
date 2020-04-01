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

public class Auto_TC65182_Ohio_StaffSSN_Validation extends BaseTest
{
	DataGenerator_staff_v1 dataGenerator=new DataGenerator_staff_v1();
	DbVerifier_staff_v1 dbVerifier=new DbVerifier_staff_v1();
	Map<String, String> jsonField =new HashMap<String,String>();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65182_Ohio_StaffSSN_Valid_length() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		// logger = extent.startTest("Auto_TC_65182_Ohio_StaffSSN_Valid_length");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffSSN, CommonMethods.generateRandomNumberOfFixLength(9));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		dataGenerator.processPositiveOhioStaffV1(jsonField);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65182_Ohio_StaffSSN_invalid_length() throws Exception
	{	
		// logger = extent.startTest("Auto_TC_65182_Ohio_StaffSSN_invalid_length");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffSSN,  CommonMethods.generateRandomNumberOfFixLength(10));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffSSN);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffSSNLengthError);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65182_Ohio_StaffSSN_null() throws Exception
	{	
		// logger = extent.startTest("Auto_TC_65182_Ohio_StaffSSN_null");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffSSN,null);

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffSSN);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffSSNNull);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65182_Ohio_StaffSSN_missing_value() throws Exception
	{	
		// logger = extent.startTest("Auto_TC_65182_Ohio_StaffSSN_missing_value");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffSSN,"");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffSSN);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffSSNLengthError);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65182_Ohio_StaffSSN_alphanumeric() throws Exception
	{	
		// logger = extent.startTest("Auto_TC_65182_Ohio_StaffSSN_alphanumeric");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffSSN,CommonMethods.generateRandomAlphaNumeric(9));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffSSN);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffSSNFormatError);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65182_Ohio_StaffSSN_string() throws Exception
	{	
		// logger = extent.startTest("Auto_TC_65182_Ohio_StaffSSN_string");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffSSN,CommonMethods.generateRandomStringOfFixLength(9));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffSSN);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffSSNFormatError);

	}

	
}
