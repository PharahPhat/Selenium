package openevv.Connecticut.Client;

import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class TC88374_ClientMedicalRecordNumber extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Test case for invalid "ClientMedicalRecordNumber" > 12 digit length.

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88374_OpenEVV_ClientMedicalRecordNumber_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException

	{
		// logger = extent.startTest("TC88374_OpenEVV_ClientMedicalRecordNumber_invalid");
		//Calling Json 
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");

		//changing json key based on test case.
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMedicalRecordNumber", "98765432345678");

		String APIBody =  j.toJSONString();

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString());

		System.out.println(APIBody);

		// Building request using requestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();

		//Setting API's body
		builder.setBody(APIBody);

		//Setting content type as application/json or application/xml
		builder.setContentType("application/json; charset=UTF-8");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		//Asserting that result of client data .
		//Assert.assertEquals(bodyAsString.contains("ERROR: The ClientMedicalRecordNumber length is invalid. The length should be between 0 and 12.|ERROR: The ClientMedicalRecordNumber format is incorrect. The record should satisfy this regular expression [\u0027[\\w]{0,12}$\u0027]. Invalid Value\u003d\u002798765432345678\u0027.") /*Expected value*/, true /*Actual Value*/, "Response body contains ERROR");
		
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));




	}


}




