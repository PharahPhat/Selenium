package openevv.Connecticut.Client;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class TC90298_ClientDesigneeStatus_field extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	// Test Case 90298:Open EVV-Client-Validate (mix) - ClientDesigneeStatus field/format
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90298_OpenEVV_ClientDesigneeStatus() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90298_OpenEVV_ClientDesigneeStatus");

		
		System.out.println("**************Started executing positive scenario*************");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		System.out.println("###########Positive scenario with 02 value Completed successfully###########");
		
	//-------------------------------------------------------------------------------------------------------------	
		System.out.println("***************Started executing invalid value scenario**********");
		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();
				
		js.put("ClientDesigneeStatus", "04");

		bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		logger.log(LogStatus.INFO, "Validating Json response ");
	
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		System.out.println("###########Positive scenario with 04 value Completed successfully###########");
	//---------------------------------------------------------------------------------------------------------------------	
		System.out.println("*********Started executing invalid ClientDesigneeStatus value scenario**********");
		//Adding new ClentMedicaidID as old one is already used
		js.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
		js.put("ClientDesigneeStatus", "05");
		
		 bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		logger.log(LogStatus.INFO, "Validating Json response ");
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientDesigneeStatus format is incorrect." ));
		System.out.println("Invalid ClientDesigneeStatusvalue Completed successfully");
	//-----------------------------------------------------------------------------------------------------------------------	
		System.out.println("*********Started executing invalid ClientDesigneeStatus value(with spaces) scenario**********");
		
		js.put("ClientDesigneeStatus", " 02");
		
		bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		logger.log(LogStatus.INFO, "Validating Json response ");
	
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The ClientDesigneeStatus length is invalid. The length should be between 0 and 2" ));
		System.out.println("Invalid ClientDesigneeStatusvalue(with space) Completed successfully");
						
	}
}
	


