/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Client;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;
//Open EVV-altEVV-Client - Validate if an optional field is provided with an invalid value (one not listed in this specification)
/**
 * @author Anupam
 *
 */

public class R2267_TC91363_AltEVV_Client_Optionalfield_with_invalid_value_Validation extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Case1- Client Json passed with_optional field is provided with an invalid value
	@Test(groups = {"All"})
	public void TC91363_AltEVV_CreateClient_with_invalid_ClientStatus_value() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// logger = extent.startTest("TC91363_AltEVV_CreateClient_with_invalid_ClientStatus_value");
		logger.log(LogStatus.INFO, "Validating ClientJson passed with Eligibility_Begindate_optional_with_invalid_ClientStatus_value"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
        JSONArray jsonObject2 = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);
		
		jsonObject3.put(globalVariables.ClientStatus, "10");
		jsonObject3.remove("ClientEligibilityDateEnd");
		jsonObject3.remove("ClientEligibilityDateBegin");


		JSONObject jsonObject4 = (JSONObject) jsonObject2.get(1);
		
		jsonObject4.put(globalVariables.ClientStatus, "10");
		jsonObject4.remove("ClientEligibilityDateEnd");
		jsonObject4.remove("ClientEligibilityDateBegin");



	    String bodyAsString=CommonMethods.capturePostResponse(jsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		
	    CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStatus_error_format);
	
	}
}

