package Ohio_V2.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.ohio.intake.VisitV2.DataGenerator_Ohio_Visit_v2;
import com.ohio.intake.VisitV2.DbVerifier_Ohio_Visit_v2;
import com.ohio.intake.VisitV2.GlobalVariable_Ohio_Visit_v2;
import com.ohio.intake.VisitV2.UniqueJsonGenerator_Ohio_Visit_v2;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class Auto_SEVV_11604_TC675_Ohio_Visit_PayerID_field_mandatory_Phase2 extends BaseTest{
	
	UniqueJsonGenerator_Ohio_Visit_v2 uniqueJsonGeneratorOhioVisitV2=new UniqueJsonGenerator_Ohio_Visit_v2();
	DbVerifier_Ohio_Visit_v2 dbVerifierOhioVisitV2=new DbVerifier_Ohio_Visit_v2();
	
	DataGenerator_Ohio_Visit_v2 datageneratorv2 = new DataGenerator_Ohio_Visit_v2();
	Map<String, String> jsonField =new HashMap<String,String>();

	
	@Test(groups = {"All", "Regression"})
	public void TR675_Ohio_Visit_PayerID_field_null_Phase2() throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		{
		// logger = extent.startTest("TR675_Ohio_Visit_PayerID_field_null_Phase2");
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v2.generateFieldValue );

		JSONArray arrayobj= new JSONArray();

		jsonField.put(GlobalVariable_Ohio_Visit_v2.Payer, "ODM");
		jsonField.put(GlobalVariable_Ohio_Visit_v2.PayerID, null);
		
		jsonField.put(GlobalVariable_Ohio_Visit_v2.PayerProgram, "OHC");
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v2.PostGetLog);
		Map<String, JSONObject> returnObjectMain=uniqueJsonGeneratorOhioVisitV2.processOhioVisitV2Array(jsonField);

		arrayobj.add(returnObjectMain.get("jsonObject"));
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v2.DBVerify);
		
		dbVerifierOhioVisitV2.jsonAssert_OhioinboxVisitv2(returnObjectMain.get(GlobalVariable_Ohio_Visit_v2.jsonObject));

	}
	}
	@Test(groups = {"All", "Regression"})
	public void TR675_Ohio_Visit_Payer_PayerID_field_invalid_Phase2() throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		{
		// logger = extent.startTest("TR675_Ohio_Visit_Payer_PayerID_field_invalid_Phase2");
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v2.generateFieldValue );

		JSONArray arrayobj= new JSONArray();

		jsonField.put(GlobalVariable_Ohio_Visit_v2.Payer, "ODMA");
		jsonField.put(GlobalVariable_Ohio_Visit_v2.PayerID, "ODMA");
		
		jsonField.put(GlobalVariable_Ohio_Visit_v2.PayerProgram, CommonMethods.generatepayerprogram());
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v2.PostGetLog);
		Map<String, JSONObject> returnObjectMain=uniqueJsonGeneratorOhioVisitV2.processOhioVisitV2Array(jsonField);

		arrayobj.add(returnObjectMain.get("jsonObject"));
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v2.errorVerify + GlobalVariable_Ohio_Visit_v2.PayerID);

		datageneratorv2.assertFailErrorMessage(String.valueOf(returnObjectMain.get(GlobalVariable_Ohio_Visit_v2.bodyAsStrinqgGet)),GlobalVariable_Ohio_Visit_v2.Payerformat_Error);		
		
	}
	}

	@Test(groups = {"All"})
	public void TR675_Ohio_Visit_Payer_PayerID_field_null_Phase2() throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		{
		// logger = extent.startTest("TR675_Ohio_Visit_Payer_PayerID_field_null_Phase2");
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v2.generateFieldValue );

		JSONArray arrayobj= new JSONArray();

		jsonField.put(GlobalVariable_Ohio_Visit_v2.Payer, null);
		jsonField.put(GlobalVariable_Ohio_Visit_v2.PayerID, "");
		
		jsonField.put(GlobalVariable_Ohio_Visit_v2.PayerProgram, CommonMethods.generatepayerprogram());
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v2.PostGetLog);
		Map<String, JSONObject> returnObjectMain=uniqueJsonGeneratorOhioVisitV2.processOhioVisitV2Array(jsonField);

		arrayobj.add(returnObjectMain.get("jsonObject"));
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v2.errorVerify + GlobalVariable_Ohio_Visit_v2.PayerID);

		datageneratorv2.assertFailErrorMessage(String.valueOf(returnObjectMain.get(GlobalVariable_Ohio_Visit_v2.bodyAsStrinqgGet)),GlobalVariable_Ohio_Visit_v2.Payer_null_Error);		
		
	}
	}
	@Test(groups = {"All", "Regression"})
	public void TR675_Ohio_Visit_PayerID_field_valid_Phase2() throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		{
		// logger = extent.startTest("TR675_Ohio_Visit_PayerID_field_valid_Phase2");
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v2.generateFieldValue );

		JSONArray arrayobj= new JSONArray();

		jsonField.put(GlobalVariable_Ohio_Visit_v2.Payer, "ODM");
		jsonField.put(GlobalVariable_Ohio_Visit_v2.PayerID, "Aetna");
		
		jsonField.put(GlobalVariable_Ohio_Visit_v2.PayerProgram, "OHC");
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v2.PostGetLog);
		Map<String, JSONObject> returnObjectMain=uniqueJsonGeneratorOhioVisitV2.processOhioVisitV2Array(jsonField);

		arrayobj.add(returnObjectMain.get("jsonObject"));
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v2.DBVerify);
		
		dbVerifierOhioVisitV2.jsonAssert_OhioinboxVisitv2(returnObjectMain.get(GlobalVariable_Ohio_Visit_v2.jsonObject));

	}
	}

}
