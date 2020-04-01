package Ohio_V1.Patient;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV4621_TC100583_OhioV1_Clientcreation_with_V1jsonbody extends BaseTest {
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void TC100583_OhioV1_Clientcreation_with_V1jsonbody() throws java.text.ParseException,  IOException, ParseException, SQLException, InterruptedException, ClassNotFoundException
	{
		// logger = extent.startTest("TC100583_OhioV1_Clientcreation_with_V1jsonbody");
		logger.log(LogStatus.INFO, "TC100583_OhioV1_Clientcreation_with_V1jsonbody"); 

		JSONArray jsonArray = GenerateUniqueParam.patient_Ohio("patient_v1");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArray, CommonMethods.propertyfileReader(globalVariables.ohio_patient_v1));
		
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v1));
		
		Assertion_DbVerifier.jsonAssert_InboxClient_3P(bodyAsStringget, jsonObject);
	}

}
