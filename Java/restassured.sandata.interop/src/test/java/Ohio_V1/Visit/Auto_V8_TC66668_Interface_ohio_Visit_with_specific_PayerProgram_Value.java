package Ohio_V1.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.ohio.intake.Visit.v1.DataGenerator_Ohio_Visit_v1;
import com.ohio.intake.Visit.v1.GlobalVariable_Ohio_Visit_v1;
import com.ohio.intake.Visit.v1.UniqueJsonGenerator_Ohio_Visit_v1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map; 

public class Auto_V8_TC66668_Interface_ohio_Visit_with_specific_PayerProgram_Value extends BaseTest
{
	private String[] PayerProgram_VistV1 = {"State Plan Home Health", "State Plan Private Duty Nursing", "Ohio Home Care Waiver", "State Plan"};
	private DataGenerator_Ohio_Visit_v1 dataGeneratorVisitV1=new DataGenerator_Ohio_Visit_v1();
	private UniqueJsonGenerator_Ohio_Visit_v1 uniqueJsonGeneratorOhioVisitV1=new UniqueJsonGenerator_Ohio_Visit_v1();


	private Map<String, String> jsonField =new HashMap<String,String>();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioVisitV1")
	public void Auto_V8_TC_66668_Interface_ohio_Visit_with_specific_PayerProgram_Value_Valid()
	{	
		for (int i=0; i< PayerProgram_VistV1.length; i++)
		{
			// logger = extent.startTest("Auto_V8_TC_66668_Interface_ohio_Visit_with_specific_PayerProgram_Value_Valid");
			logger.log(LogStatus.INFO, "Auto_V8_TC_66668_Interface_ohio_Visit_with_specific_PayerProgram_Value_Valid");

			logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.generateFieldValue );
			jsonField.put(GlobalVariable_Ohio_Visit_v1.PayerProgram, PayerProgram_VistV1[i] );

			logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.PostGetLog);
		//	Map<String, JSONObject> returnObject=uniqueJsonGeneratorOhioVisitV1.processOhioVisitV1Array(jsonField);

			logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.DBVerify);
		//	dbVerifierOhioVisitV1.jsonAssert_inboxVisit_Ohio_V1(returnObject.get(GlobalVariable_Visit_v1.jsonObject));	
		}
	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioVisitV1")
	public void Auto_V8_TC_66668_Interface_ohio_Visit_with_specific_PayerProgram_Value_Inalid() throws InterruptedException, ParseException, IOException, SQLException, java.text.ParseException, ClassNotFoundException {
		// logger = extent.startTest("Auto_V8_TC_66668_Interface_ohio_Visit_with_specific_PayerProgram_Value_Inalid");
		logger.log(LogStatus.INFO, "Auto_V8_TC_66668_Interface_ohio_Visit_with_specific_PayerProgram_Value_Inalid");

		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.generateFieldValue );
		jsonField.put(GlobalVariable_Ohio_Visit_v1.PayerProgram, CommonMethods.generateRandomNumberOfFixLength(10));

		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.PostGetLog);
		Map<String, JSONObject> returnObject=uniqueJsonGeneratorOhioVisitV1.processOhioVisitV1Array(jsonField);

		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.errorVerify + "PayerProgram");
		dataGeneratorVisitV1.assertFailErrorMessage(returnObject.get(GlobalVariable_Ohio_Visit_v1.bodyAsStrinqgGet).toJSONString(), GlobalVariable_Ohio_Visit_v1.payerProgramFormatError);

		
	}


}
