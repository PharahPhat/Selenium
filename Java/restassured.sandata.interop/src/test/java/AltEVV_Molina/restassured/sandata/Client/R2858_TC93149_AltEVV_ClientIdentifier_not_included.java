package AltEVV_Molina.restassured.sandata.Client;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

import static io.restassured.RestAssured.given;

import java.io.IOException;

//Test Case 90984: OpenEVV-altEVV- Client:  Validate If the client Json does not include a ClientIdentifier [PatientOtherID]

import com.globalMethods.core.Assertion_DbVerifier; public class R2858_TC93149_AltEVV_ClientIdentifier_not_included extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
    
    //Case-1 OpenEVV-altEVV- Client:  Validate If the client Json does not include a ClientIdentifier [PatientOtherID]
	
	@Test(groups = {"All"})
	public void R2858_TC93149_AltEVV_CreateClient_without_ClientIdentifier() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93149_AltEVV_CreateClient_without_ClientIdentifier");
		
		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientIdentifier"); 
		
		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		
		JSONObject js = (JSONObject) j.get(0);
		js.remove("ClientIdentifier");
		 
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	}

	
}
