package Ohio_V1.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.ohio.intake.Visit.v1.DbVerifier_Ohio_Visit_v1;
import com.ohio.intake.Visit.v1.GlobalVariable_Ohio_Visit_v1;
import com.ohio.intake.Visit.v1.UniqueJsonGenerator_Ohio_Visit_v1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map; 

public class Auto_V8_TC72352_Interface_ohio_Visit_with_specific_Procedure_code_Value extends BaseTest
{
	private String[] procedurecodeCapital={"G0156", "G0299", "G0300", "T1000", "T1002", "T1003", "S5125", "T1019","T1001"};
	private String[] procedurecodeSmall= {"g0156", "g0299", "g0300", "t1000", "t1002", "t1003", "s5125", "t1019", "t1001"};
	private DbVerifier_Ohio_Visit_v1 dbVerifierOhioVisitV1=new DbVerifier_Ohio_Visit_v1();
	private UniqueJsonGenerator_Ohio_Visit_v1 uniqueJsonGeneratorOhioVisitV1=new UniqueJsonGenerator_Ohio_Visit_v1();


	private Map<String, String> jsonField =new HashMap<String,String>();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioVisitV1")
	public void Auto_V8_TC_72352_Interface_ohio_Visit_with_specific_Procedure_code_Capital_Value_Valid() throws Exception
	{	
		for (int i=0; i< procedurecodeCapital.length; i++)
		{
			// logger = extent.startTest("Auto_V8_TC_72352_Interface_ohio_Visit_with_specific_Procedure_code_Value_Valid");
			logger.log(LogStatus.INFO, "Auto_V8_TC_72352_Interface_ohio_Visit_with_specific_Procedure_code_Value_Valid");

			logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.generateFieldValue );
			jsonField.put(GlobalVariable_Ohio_Visit_v1.ProcedureCode, procedurecodeCapital[i] );

			
			logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.PostGetLog);
			Map<String, JSONObject> returnObject=uniqueJsonGeneratorOhioVisitV1.processOhioVisitV1SubArrayCalls_SameVaue(jsonField);

			logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.DBVerify);
			dbVerifierOhioVisitV1.jsonAssert_OhioinboxVisitV1(returnObject.get(GlobalVariable_Ohio_Visit_v1.jsonObject));	
		}
	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioVisitV1")
	public void Auto_V8_TC_72352_Interface_ohio_Visit_with_specific_Procedure_code_Small_Value_Valid() throws Exception
	{	
		for (int i=0; i< procedurecodeSmall.length; i++)
		{
			// logger = extent.startTest("Auto_V8_TC_72352_Interface_ohio_Visit_with_specific_Procedure_code_Value_Valid");
			logger.log(LogStatus.INFO, "Auto_V8_TC_72352_Interface_ohio_Visit_with_specific_Procedure_code_Value_Valid");

			logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.generateFieldValue );
			jsonField.put(GlobalVariable_Ohio_Visit_v1.ProcedureCode, procedurecodeSmall[i] );

			logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.PostGetLog);
			Map<String, JSONObject> returnObject=uniqueJsonGeneratorOhioVisitV1.processOhioVisitV1SubArrayCalls_SameVaue(jsonField);

			logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.DBVerify);
			dbVerifierOhioVisitV1.jsonAssert_OhioinboxVisitV1(returnObject.get(GlobalVariable_Ohio_Visit_v1.jsonObject));	
		}
	}


}
