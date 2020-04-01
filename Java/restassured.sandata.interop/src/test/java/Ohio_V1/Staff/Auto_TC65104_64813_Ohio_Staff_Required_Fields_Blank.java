package Ohio_V1.Staff;

import Utills_ExtentReport_Log4j.BaseTest;
import com.ohio.intake.patient.v1.GlobalVariable_V1;
import com.ohio.intake.staff.v1.DataGenerator_staff_v1;
import com.ohio.intake.staff.v1.GlobalVariable_staff_v1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Auto_TC65104_64813_Ohio_Staff_Required_Fields_Blank extends BaseTest{
	
	private DataGenerator_staff_v1 dataGenerator=new DataGenerator_staff_v1();
	
	@Test(groups = {"All", "Smoke"})
	public void TC_65104_Ohio_Staff_Required_Fields_Blank_BusinessEntityId() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		Map<String, String> jsonField =new HashMap<String,String>();

		// logger = extent.startTest("TC_65104_Ohio_Staff_Required_Fields_Blank_BusinessEntityId");
		
		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffBusinessEntityId, "");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffBusinessEntityId);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringPost).toJSONString(), GlobalVariable_staff_v1.staffBusinessEntityIdBlankError);
		
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC_65104_Ohio_Staff_Required_Fields_Blank_BusinessEntityMedicaidIdentifier() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("TC_65104_Ohio_Staff_Required_Fields_Blank_BusinessEntityMedicaidIdentifier");
		Map<String, String> jsonField =new HashMap<String,String>();

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffBusinessEntityMedicaidIdentifier, "");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffBusinessEntityMedicaidIdentifier);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringPost).toJSONString(), GlobalVariable_staff_v1.staffBusinessEntityMedicaidIdentifierBlankError);
		
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC_65104_Ohio_Staff_Required_Fields_Blank_StaffOtherID() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("TC_65104_Ohio_Staff_Required_Fields_Blank_StaffOtherID");
		Map<String, String> jsonField =new HashMap<String,String>();

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffOtherId, "");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffOtherId);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffOtherIdFormatError);
		
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC_65104_Ohio_Staff_Required_Fields_Blank_SequenceID() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("TC_65104_Ohio_Staff_Required_Fields_Blank_SequenceID");
		Map<String, String> jsonField =new HashMap<String,String>();

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.sequenceId, "");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.sequenceId);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.sequenceIDFormatError);
		
	}

	@Test(groups = {"All", "Regression"})
	public void TC_65104_Ohio_Staff_Required_Fields_Blank_StaffID() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("TC_65104_Ohio_Staff_Required_Fields_Blank_StaffID");
		Map<String, String> jsonField =new HashMap<String,String>();

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffId, "");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffId);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffIdFormatError);
		
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC_65104_Ohio_Staff_Required_Fields_Blank_StaffSSN() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("TC_65104_Ohio_Staff_Required_Fields_Blank_StaffSSN");
		Map<String, String> jsonField =new HashMap<String,String>();

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffSSN, "");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffSSN);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffSSNFormatError);
		
	}

	@Test(groups = {"All", "Regression"})
	public void TC_65104_Ohio_Staff_Required_Fields_Blank_StaffLastName() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("TC_65104_Ohio_Staff_Required_Fields_Blank_StaffLastName");
		Map<String, String> jsonField =new HashMap<String,String>();

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffLName, "");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffLName);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffLastNameFormatError);
		
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC_65104_Ohio_Staff_Required_Fields_Blank_StaffFirstName() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("TC_65104_Ohio_Staff_Required_Fields_Blank_StaffFirstName");
		Map<String, String> jsonField =new HashMap<String,String>();

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue );
		jsonField.put(GlobalVariable_staff_v1.staffFName, "");

		logger.log(LogStatus.INFO, GlobalVariable_staff_v1.PostGetLog);
		Map<String, JSONObject> returnObject=dataGenerator.processOhioStaffV1(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_V1.errorVerify + GlobalVariable_staff_v1.staffFName);
		dataGenerator.assertFailErrorMessage(returnObject.get(GlobalVariable_staff_v1.bodyAsStringGet).toJSONString(), GlobalVariable_staff_v1.staffFirstNameFormatError);
		
	}

}
