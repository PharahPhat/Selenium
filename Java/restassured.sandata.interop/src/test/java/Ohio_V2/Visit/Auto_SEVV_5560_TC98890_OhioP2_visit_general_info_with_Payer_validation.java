package Ohio_V2.Visit;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class Auto_SEVV_5560_TC98890_OhioP2_visit_general_info_with_Payer_validation extends BaseTest{
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Smoke"})
	public void TC98890_Ohio3p_visit_general_info_with_invalidPayer_validation() throws java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC98890_Ohio3p_visit_general_info_with_invalidPayer_validation");
		logger.log(LogStatus.INFO, "TC98890_Ohio3p_visit_general_info_with_invalidPayer_validation"); 

		JSONArray jsonArray = GenerateUniqueParam.VisitParam_v2(globalVariables.Ohio_visit_v2_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.payer, CommonMethods.generatepayer() +CommonMethods.generateRandomAlphaNumeric(2));
		jsonObject.put(globalVariables.PayerProgram, CommonMethods.generatepayerprogram());
		jsonObject.put(globalVariables.ProcedureCode, CommonMethods.generateProcedurecode());
		
		String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2));

		String bodyAsStringGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_get_v2));

		CommonMethods.verifyjsonassertFailcaseinget(bodyAsStringGet, globalVariables.PayerErrorVisit);
	}
}