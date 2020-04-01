package Ohio_V1.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.ohio.intake.Visit.v1.DbVerifier_Ohio_Visit_v1;
import com.ohio.intake.Visit.v1.GlobalVariable_Ohio_Visit_v1;
import com.ohio.intake.Visit.v1.UniqueJsonGenerator_Ohio_Visit_v1;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Auto_V8_TC67017_Interface_ohio_Visit_with_Adj_In_Call extends BaseTest
{
	private DbVerifier_Ohio_Visit_v1 dbVerifierOhioVisitV1=new DbVerifier_Ohio_Visit_v1();
	private UniqueJsonGenerator_Ohio_Visit_v1 uniqueJsonGeneratorOhioVisitV1=new UniqueJsonGenerator_Ohio_Visit_v1();


	private Map<String, String> jsonField =new HashMap<String,String>();
	private Map<String, String> jsonObject =new HashMap<String,String>();


	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioVisitV1")
	public void Auto_V8_TC_67017_Interface_ohio_Visit_with_Adj_In_Call_Valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{	
			// logger = extent.startTest("Auto_V8_TC_72352_Interface_ohio_Visit_with_specific_Procedure_code_Value_Valid");
			logger.log(LogStatus.INFO, "Auto_V8_TC_72352_Interface_ohio_Visit_with_specific_Procedure_code_Value_Valid");
			JSONArray a= new JSONArray();
			logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.generateFieldValue );
			jsonField.put(GlobalVariable_Ohio_Visit_v1.AdjOutDateTime, CommonMethods.dateToDateTimeFormat_z(CommonMethods.generatePastDate_YYYY_MM_dd_1day()));
			jsonField.put(GlobalVariable_Ohio_Visit_v1.AdjInDateTime, CommonMethods.dateToDateTimeFormat_z(CommonMethods.generatecurrentDate_YYYY_MM_dd_Time()));

			logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.PostGetLog);
			Map<String, JSONObject> returnObject=uniqueJsonGeneratorOhioVisitV1.processOhioVisitV1Array(jsonField );
			a.add(returnObject.get("jsonObject"));
			
			logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.DBVerify);
			dbVerifierOhioVisitV1.jsonAssert_OhioinboxVisitV1(returnObject.get(GlobalVariable_Ohio_Visit_v1.jsonObject));	
	}



}
