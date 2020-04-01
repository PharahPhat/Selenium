package Ohio_V1.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV_2106_TC97055_Validate_message_in_case_error_in_sub_segments extends BaseTest { 
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All" , "Regression"})
	@AdditionalInfo(module = "OhioVisit")
	public void SEVV_2106_TC97055_Validate_message_summary_in_case_error_in_sub_segments_of_get() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		// logger = extent.startTest("SEVV_2106_TC97055_Validate_message_summary_in_case_error_in_sub_segments_of_get");

		JSONArray jsonArr=GenerateUniqueParam.VisitParam_3P();
		
		JSONObject jsonObject = (JSONObject) jsonArr.get(0);
		
		JSONArray jsonArrPay = (JSONArray) jsonObject.get("VisitException");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);
		jsonObjectPay.put("ExceptionAcknowledged", "");
		jsonObjectPay.put("ExceptionID", "41");
		
		String bodyAsString = CommonMethods.captureResponseOhio_v1(jsonArr, CommonMethods.propertyfileReader(globalVariables.ohio_visit_v1));

		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_visit_get_v1));

		Assert.assertTrue(bodyAsStringget.contains("The ExceptionID format is incorrect. The ExceptionID value must be one of the valid values. The record is being rejected"));
	}

}
