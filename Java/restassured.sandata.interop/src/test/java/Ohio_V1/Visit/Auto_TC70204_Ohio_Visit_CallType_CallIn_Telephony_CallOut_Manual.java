package Ohio_V1.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.ohio.intake.Visit.v1.DbVerifier_Ohio_Visit_v1;
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

public class Auto_TC70204_Ohio_Visit_CallType_CallIn_Telephony_CallOut_Manual extends BaseTest {

	private UniqueJsonGenerator_Ohio_Visit_v1 uniqueJsonGeneratorOhioVisitV1=new UniqueJsonGenerator_Ohio_Visit_v1();
	private DbVerifier_Ohio_Visit_v1 dbVerifierOhioVisitV1=new DbVerifier_Ohio_Visit_v1();

	private Map<String, String> jsonField1 =new HashMap<String,String>();
	private Map<String, String> jsonField2 =new HashMap<String,String>();
	
	@Test(groups = {"All", "Regression"})
	public void TC70204_Ohio_Visit_CallType_CallIn_Telephony_CallOut_Manual() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("TC70204_Ohio_Visit_CallType_CallIn_Telephony_CallOut_Manual");
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.generateFieldValue );
		jsonField1.put(GlobalVariable_Ohio_Visit_v1.callTypejson, "Telephony" );
		jsonField2.put(GlobalVariable_Ohio_Visit_v1.callTypejson, "Manual" );

		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.PostGetLog);
		Map<String, JSONObject> returnObject=uniqueJsonGeneratorOhioVisitV1.processOhioVisitV1SubArrayCalls(jsonField1,jsonField2);

		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.DBVerify);
		dbVerifierOhioVisitV1.jsonAssertInboxVisitCallsGeneric(returnObject.get(GlobalVariable_Ohio_Visit_v1.jsonObject),
				returnObject.get(GlobalVariable_Ohio_Visit_v1.jsonObject_callIn),returnObject.get(GlobalVariable_Ohio_Visit_v1.jsonObject_callOut));	
		
	}

}
