package Ohio_V1.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.ohio.intake.Visit.v1.DataGenerator_Ohio_Visit_v1;
import com.ohio.intake.Visit.v1.DbVerifier_Ohio_Visit_v1;
import com.ohio.intake.Visit.v1.GlobalVariable_Ohio_Visit_v1;
import com.ohio.intake.Visit.v1.UniqueJsonGenerator_Ohio_Visit_v1;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV4621_TC100655_OhioVisitCreation_with_Ohiov1_Jsonbody extends BaseTest{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier=new Assertion_DbVerifier();
	UniqueJsonGenerator_Ohio_Visit_v1 uniqueJsonGeneratorOhioVisitV1=new UniqueJsonGenerator_Ohio_Visit_v1();
	DbVerifier_Ohio_Visit_v1 dbVerifierOhioVisitV1=new DbVerifier_Ohio_Visit_v1();
	DataGenerator_Ohio_Visit_v1 datageneratorv1 = new DataGenerator_Ohio_Visit_v1();
	Map<String, String> jsonField =new HashMap<String,String>();


	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OhioVisit_1")
	public void SEVV4621_TC100655_OhioVisitCreation_with_Ohiov1_Jsonbody_Valid() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		{
		// logger = extent.startTest("TR671_Ohio_Visit_Payer_PayerID_accepts_only_ODM_Phase1_valid");
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.generateFieldValue );

		JSONArray arrayobj= new JSONArray();
	
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.PostGetLog);
		Map<String, JSONObject> returnObjectMain=uniqueJsonGeneratorOhioVisitV1.processOhioVisitV1Array(jsonField);

		arrayobj.add(returnObjectMain.get("jsonObject"));
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.DBVerify);
		
		dbVerifierOhioVisitV1.jsonAssert_OhioinboxVisitV1(returnObjectMain.get(GlobalVariable_Ohio_Visit_v1.jsonObject));	
		
	}
	}

}
