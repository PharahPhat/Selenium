package Ohio_V2.Visit;

import java.io.IOException;
import java.sql.SQLException;

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

import Utills_ExtentReport_Log4j.BaseTest;

public class Auto_SEVV_4621_TC100657_OhioVisitCreation_with_Ohiov2_Jsonbody extends BaseTest{
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier=new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OhioStaff")
	public void TC100657_OhioVisitCreation_with_Ohiov2_Jsonbody() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception {

			// logger = extent.startTest("TC100657_OhioVisitCreation_with_Ohiov2_Jsonbody");

			JSONArray jsonArr=GenerateUniqueParam.VisitParam_v2(globalVariables.Ohio_visit_v2_json);

			JSONObject jsonobject = (JSONObject) jsonArr.get(0);
			
			//jsonobject.put(globalVariables.PayerProgram, CommonMethods.generatepayerprogram());

			String bodyAsString = CommonMethods.captureResponseOhio_v2(jsonArr, CommonMethods.propertyfileReader("ohio_visit_v2"));
			
			String bodyAsStringGet=CommonMethods.captureGetResponseOhioGetWithUID_v2(bodyAsString, CommonMethods.propertyfileReader("ohio_visit_get_v2"));

			Assertion_DbVerifier.jsonAssert_inboxVisit_Ohio(bodyAsStringGet, jsonobject);
		
		}


}
