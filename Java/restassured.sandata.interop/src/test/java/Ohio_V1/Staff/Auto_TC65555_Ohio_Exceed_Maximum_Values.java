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

public class Auto_TC65555_Ohio_Exceed_Maximum_Values extends BaseTest
{
	private DataGenerator_staff_v1 dataGenerator=new DataGenerator_staff_v1();
	private DbVerifier_staff_v1 dbVerifier=new DbVerifier_staff_v1();

	//StaffSSn Maximum valid Invalid
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65555_Ohio_Exceed_Maximum_Values_StaffSSN_Valid() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_TC_65555_Ohio_Exceed_Maximum_Values_StaffSSN_Valid");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffSSN, CommonMethods.generateRandomNumberOfFixLength(9));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		dataGenerator.processPositiveOhioStaffV1(jsonField);
	}	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65555_Ohio_Exceed_Maximum_Values_StaffSSN_inalid() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_TC_65555_Ohio_Exceed_Maximum_Values_StaffSSN_inalid");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffSSN, CommonMethods.generateRandomNumberOfFixLength(10));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffSSN);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffSSNLengthError);


	}	
	
	//StaffID Maximum valid Invalid
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65555_Ohio_Exceed_Maximum_Values_staffId_Valid() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_TC_65555_Ohio_Exceed_Maximum_Values_staffId_Valid");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffId, CommonMethods.generateRandomNumberOfFixLength(9));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		dataGenerator.processPositiveOhioStaffV1(jsonField);
	}	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65555_Ohio_Exceed_Maximum_Values_staffId_inalid() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_TC_65555_Ohio_Exceed_Maximum_Values_staffId_inalid");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffId, CommonMethods.generateRandomNumberOfFixLength(10));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffId);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffIdLengthError);


	}	

	//StaffLastName Maximum valid Invalid
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65555_Ohio_Exceed_Maximum_Values_StaffLastName_Valid() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_TC_65555_Ohio_Exceed_Maximum_Values_StaffLastName_Valid");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffLName, CommonMethods.generateRandomStringOfFixLength(30));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		dataGenerator.processPositiveOhioStaffV1(jsonField);
	}	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65555_Ohio_Exceed_Maximum_Values_StaffLastName_inalid() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_TC_65555_Ohio_Exceed_Maximum_Values_StaffLastName_inalid");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffLName, CommonMethods.generateRandomStringOfFixLength(31));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.DBVerify);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffLastNameLengthError);

	}	
	
	//StaffFastName Maximum valid Invalid
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65555_Ohio_Exceed_Maximum_Values_StaffFirstName_Valid() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_TC_65555_Ohio_Exceed_Maximum_Values_StaffFirstName_Valid");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffFName, CommonMethods.generateRandomStringOfFixLength(30));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		dataGenerator.processPositiveOhioStaffV1(jsonField);
	}	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65555_Ohio_Exceed_Maximum_Values_StaffFirstName_inalid() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_TC_65555_Ohio_Exceed_Maximum_Values_StaffLastName_inalid");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffFName, CommonMethods.generateRandomStringOfFixLength(31));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.DBVerify);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffFirstNameLengthError);


	}	
	
	//StaffEmail Maximum valid Invalid
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65555_Ohio_Exceed_Maximum_Values_staffEmail_Valid() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_TC_65555_Ohio_Exceed_Maximum_Values_staffEmail_Valid");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffEmail, CommonMethods.generateEmailAddress_string(49));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		dataGenerator.processPositiveOhioStaffV1(jsonField);
	}	
	
	@Test(groups = {"All", "Regression","fixing"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65555_Ohio_Exceed_Maximum_Values_staffEmail_inalid() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_TC_65555_Ohio_Exceed_Maximum_Values_StaffLastName_inalid");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffEmail, CommonMethods.generateRandomStringOfFixLength(65));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.DBVerify);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffEmailLengthError);


	}	

	//StaffotherID Maximum valid Invalid
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65555_Ohio_Exceed_Maximum_Values_StaffotherID_Valid() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_TC_65555_Ohio_Exceed_Maximum_Values_StaffotherID_Valid");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffOtherId, CommonMethods.generateRandomAlphaNumeric(64));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		dataGenerator.processPositiveOhioStaffV1(jsonField);
	}	
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65555_Ohio_Exceed_Maximum_Values_staffOtherId_inalid() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_TC_65555_Ohio_Exceed_Maximum_Values_staffOtherId_inalid");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffOtherId, CommonMethods.generateRandomAlphaNumeric(65));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.DBVerify);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffOtherIdLengthError);


	}	

	//StaffPosition Maximum valid Invalid

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65555_Ohio_Exceed_Maximum_Values_staffPosition_Valid() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_TC_65555_Ohio_Exceed_Maximum_Values_staffPosition_Valid");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		
		for (int i = 0; i<DataGenerator_staff_v1.StaffPosition.length; i++){

			jsonField.put(GlobalVariable_staff_v1.staffPosition,DataGenerator_staff_v1.generateStaffPosition(i));

			logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
			dataGenerator.processPositiveOhioStaffV1(jsonField);
		}
	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65555_Ohio_Exceed_Maximum_Values_staffPosition_invalid_length() throws Exception
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_TC_65555_Ohio_Exceed_Maximum_Values_staffPosition_invalid_length");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffPosition, CommonMethods.generateRandomStringOfFixLength(4));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffPosition);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffPositionFormatError);

	}

	//SequenceID Maximum valid Invalid

	@Test(groups = {"All", "Regression", "fixing"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65555_Ohio_Exceed_Maximum_Values_sequenceId_Valid_length() throws InterruptedException, java.text.ParseException, ClassNotFoundException, IOException, ParseException, SQLException
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_TC_65555_Ohio_Exceed_Maximum_Values_sequenceId_Valid_length");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.sequenceId, CommonMethods.generateRandomNumberOfFixLength(16));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		dataGenerator.processPositiveOhioStaffV1(jsonField);

	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioStaff")
	public void Auto_TC_65555_Ohio_Exceed_Maximum_Values__sequenceId_invalid_length() throws Exception
	{	
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("Auto_TC_65555_Ohio_Exceed_Maximum_Values__sequenceId_invalid_length");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.sequenceId,  CommonMethods.generateRandomNumberOfFixLength(17));

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.sequenceId);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.sequenceIDLengthError);

	}

}

