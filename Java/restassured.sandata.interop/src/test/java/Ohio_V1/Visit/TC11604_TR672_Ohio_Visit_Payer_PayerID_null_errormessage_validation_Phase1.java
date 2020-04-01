package Ohio_V1.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.ohio.intake.Visit.v1.DataGenerator_Ohio_Visit_v1;
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
public class TC11604_TR672_Ohio_Visit_Payer_PayerID_null_errormessage_validation_Phase1 extends BaseTest{

	private UniqueJsonGenerator_Ohio_Visit_v1 uniqueJsonGeneratorOhioVisitV1=new UniqueJsonGenerator_Ohio_Visit_v1();
	private DataGenerator_Ohio_Visit_v1 datageneratorv1 = new DataGenerator_Ohio_Visit_v1();
	private Map<String, String> jsonField =new HashMap<String,String>();

	
	@Test(groups = {"All", "Regression"})
	public void TC11604_TR672_Ohio_Visit_Payer_PayerID_null_errormessage_validation_Phase1() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		{
		// logger = extent.startTest("Bug11604_TR672_Ohio_Visit_Payer_PayerID_null_errormessage_validation_Phase1");
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.generateFieldValue );

		JSONArray arrayobj= new JSONArray();

		jsonField.put(GlobalVariable_Ohio_Visit_v1.Payer, null);
		jsonField.put(GlobalVariable_Ohio_Visit_v1.PayerID, null);
		
		jsonField.put(GlobalVariable_Ohio_Visit_v1.PayerProgram, "State Plan");
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.PostGetLog);
		Map<String, JSONObject> returnObjectMain=uniqueJsonGeneratorOhioVisitV1.processOhioVisitV1Array(jsonField);

		arrayobj.add(returnObjectMain.get("jsonObject"));
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.errorVerify + GlobalVariable_Ohio_Visit_v1.PayerID);

		datageneratorv1.assertFailErrorMessage(String.valueOf(returnObjectMain.get(GlobalVariable_Ohio_Visit_v1.bodyAsStrinqgGet)),GlobalVariable_Ohio_Visit_v1.PayerID_null_error);	
		}	
	}
	@Test(groups = {"All", "Regression"})
	public void TC11604_TR672_Ohio_Visit_Payer_PayerID_null_as_string_errormessage_validation_Phase1() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException{
		
		{
		// logger = extent.startTest("TR672_Ohio_Visit_Payer_PayerID_null_as_string_errormessage_validation_Phase1");
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.generateFieldValue );

		JSONArray arrayobj= new JSONArray();

		jsonField.put(GlobalVariable_Ohio_Visit_v1.Payer, "null");
		jsonField.put(GlobalVariable_Ohio_Visit_v1.PayerID, "null");
		
		jsonField.put(GlobalVariable_Ohio_Visit_v1.PayerProgram, "State Plan");
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.PostGetLog);
		Map<String, JSONObject> returnObjectMain=uniqueJsonGeneratorOhioVisitV1.processOhioVisitV1Array(jsonField);

		arrayobj.add(returnObjectMain.get("jsonObject"));
		
		logger.log(LogStatus.INFO, GlobalVariable_Ohio_Visit_v1.errorVerify + GlobalVariable_Ohio_Visit_v1.PayerID);

		datageneratorv1.assertFailErrorMessage(String.valueOf(returnObjectMain.get(GlobalVariable_Ohio_Visit_v1.bodyAsStrinqgGet)),GlobalVariable_Ohio_Visit_v1.PayerID_nullString_Error);	
		
		}		
	}
}
