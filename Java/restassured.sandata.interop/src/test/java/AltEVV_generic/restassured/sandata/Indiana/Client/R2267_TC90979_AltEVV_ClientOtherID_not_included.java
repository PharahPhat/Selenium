package AltEVV_generic.restassured.sandata.Indiana.Client;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import java.io.IOException;

//Test Case 90979: OpenEVV-altEVV- Client:  Validate If the client Json does not include a Client Other ID (external ID)

import com.globalMethods.core.Assertion_DbVerifier; public class R2267_TC90979_AltEVV_ClientOtherID_not_included extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
    
    //Case-1 Testing without ClientOtherID field
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "AltEVVclient")
	public void TC90979_AltEVV_CreateClient_without_ClientOtherID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC90979_AltEVV_CreateClient_without_ClientOtherID");
		
		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientOtherID"); 
		
		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		
		JSONObject js = (JSONObject) j.get(0);
		js.remove("ClientOtherID");
		js.remove("SequenceID");
		 
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		
		//Validating the expected Result
	   Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	}

	
}
