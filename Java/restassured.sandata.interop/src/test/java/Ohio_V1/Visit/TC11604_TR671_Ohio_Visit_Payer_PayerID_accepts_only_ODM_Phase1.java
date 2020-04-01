package Ohio_V1.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.ohio.intake.Visit.v1.DataGenerator_Ohio_Visit_v1;
import com.ohio.intake.Visit.v1.DbVerifier_Ohio_Visit_v1;
import com.ohio.intake.Visit.v1.GlobalVariable_Ohio_Visit_v1;
import com.ohio.intake.Visit.v1.UniqueJsonGenerator_Ohio_Visit_v1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anupam
 *
 */
public class TC11604_TR671_Ohio_Visit_Payer_PayerID_accepts_only_ODM_Phase1 extends BaseTest{
		
	private UniqueJsonGenerator_Ohio_Visit_v1 uniqueJsonGeneratorOhioVisitV1=new UniqueJsonGenerator_Ohio_Visit_v1();
	private DbVerifier_Ohio_Visit_v1 dbVerifierOhioVisitV1=new DbVerifier_Ohio_Visit_v1();
	private DataGenerator_Ohio_Visit_v1 datageneratorv1 = new DataGenerator_Ohio_Visit_v1();
	private Map<String, String> jsonField =new HashMap<String,String>();

	
	@Test(groups = {"All", "Regression"})
	public void TC11604_TR671_Ohio_Visit_Payer_PayerID_accepts_only_ODM_Phase1_valid() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		{
		// logger = extent.startTest("TR671_Ohio_Visit_Payer_PayerID_accepts_only_ODM_Phase1_valid");
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.generateFieldValue );

		JSONArray arrayobj= new JSONArray();

		jsonField.put(GlobalVariable_Ohio_Visit_v1.Payer, "ODM");
		jsonField.put(GlobalVariable_Ohio_Visit_v1.PayerID, "ODM");
		
		jsonField.put(GlobalVariable_Ohio_Visit_v1.PayerProgram, "State Plan");
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.PostGetLog);
		Map<String, JSONObject> returnObjectMain=uniqueJsonGeneratorOhioVisitV1.processOhioVisitV1Array(jsonField);

		arrayobj.add(returnObjectMain.get("jsonObject"));
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.DBVerify);
		
		dbVerifierOhioVisitV1.jsonAssert_OhioinboxVisitV1(returnObjectMain.get(GlobalVariable_Ohio_Visit_v1.jsonObject));	
		
	}
	}
		
	@Test(groups = {"All", "Regression"})
	public void TC11604_TR671_Ohio_Visit_Payer_PayerID_accepts_only_ODM_Phase1_OHCW_valid() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("TR671_Ohio_Visit_Payer_PayerID_accepts_only_ODM_Phase1_OHCW_valid");
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.generateFieldValue );

		JSONArray arrayobj= new JSONArray();

		jsonField.put(GlobalVariable_Ohio_Visit_v1.Payer, "ODM");
		jsonField.put(GlobalVariable_Ohio_Visit_v1.PayerID, "ODM");
		
		jsonField.put(GlobalVariable_Ohio_Visit_v1.PayerProgram, "Ohio Home Care Waiver");
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.PostGetLog);
		Map<String, JSONObject> returnObjectMain=uniqueJsonGeneratorOhioVisitV1.processOhioVisitV1Array(jsonField);

		arrayobj.add(returnObjectMain.get("jsonObject"));
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.DBVerify);
		
		dbVerifierOhioVisitV1.jsonAssert_OhioinboxVisitV1(returnObjectMain.get(GlobalVariable_Ohio_Visit_v1.jsonObject));	
		
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC11604_TR671_Ohio_Visit_Payer_PayerID_accepts_only_ODM_Phase1_casesentitive() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("TR671_Ohio_Visit_Payer_PayerID_accepts_only_ODM_Phase1_casesentitive");
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.generateFieldValue );

		JSONArray arrayobj= new JSONArray();

		jsonField.put(GlobalVariable_Ohio_Visit_v1.Payer, "odm");
		jsonField.put(GlobalVariable_Ohio_Visit_v1.PayerID, "ODM");
		
		jsonField.put(GlobalVariable_Ohio_Visit_v1.PayerProgram, "Ohio Home Care Waiver");
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.PostGetLog);
		Map<String, JSONObject> returnObjectMain=uniqueJsonGeneratorOhioVisitV1.processOhioVisitV1Array(jsonField);

		arrayobj.add(returnObjectMain.get("jsonObject"));
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.errorVerify + GlobalVariable_Ohio_Visit_v1.PayerID);

		datageneratorv1.assertFailErrorMessage(String.valueOf(returnObjectMain.get(GlobalVariable_Ohio_Visit_v1.bodyAsStrinqgGet)),GlobalVariable_Ohio_Visit_v1.PayerID_nullString_Error);	
		
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC11604_TR671_Ohio_Visit_Payer_PayerID_ODA_Phase1_invalid() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("TR671_Ohio_Visit_Payer_PayerID_ODA_Phase1_invalid");
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.generateFieldValue );

		JSONArray arrayobj= new JSONArray();

		jsonField.put(GlobalVariable_Ohio_Visit_v1.Payer, "ODA");
		jsonField.put(GlobalVariable_Ohio_Visit_v1.PayerID, "ODA");
		
		jsonField.put(GlobalVariable_Ohio_Visit_v1.PayerProgram, "Ohio Home Care Waiver");
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.PostGetLog);
		Map<String, JSONObject> returnObjectMain=uniqueJsonGeneratorOhioVisitV1.processOhioVisitV1Array(jsonField);

		arrayobj.add(returnObjectMain.get("jsonObject"));
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.errorVerify + GlobalVariable_Ohio_Visit_v1.PayerID);

		datageneratorv1.assertFailErrorMessage(String.valueOf(returnObjectMain.get(GlobalVariable_Ohio_Visit_v1.bodyAsStrinqgGet)),GlobalVariable_Ohio_Visit_v1.PayerID_nullString_Error);	
		
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC11604_TR671_Ohio_Visit_Payer_PayerID_Odm_Phase1_invalid() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("TR671_Ohio_Visit_Payer_PayerID_ODA_Phase1_invalid");
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.generateFieldValue );

		JSONArray arrayobj= new JSONArray();

		jsonField.put(GlobalVariable_Ohio_Visit_v1.Payer, "Odm");
		jsonField.put(GlobalVariable_Ohio_Visit_v1.PayerID, "Odm");
		
		jsonField.put(GlobalVariable_Ohio_Visit_v1.PayerProgram, "Ohio Home Care Waiver");
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.PostGetLog);
		Map<String, JSONObject> returnObjectMain=uniqueJsonGeneratorOhioVisitV1.processOhioVisitV1Array(jsonField);

		arrayobj.add(returnObjectMain.get("jsonObject"));
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.errorVerify + GlobalVariable_Ohio_Visit_v1.PayerID);

		datageneratorv1.assertFailErrorMessage(String.valueOf(returnObjectMain.get(GlobalVariable_Ohio_Visit_v1.bodyAsStrinqgGet)),GlobalVariable_Ohio_Visit_v1.PayerID_nullString_Error);	
		
	}

}
