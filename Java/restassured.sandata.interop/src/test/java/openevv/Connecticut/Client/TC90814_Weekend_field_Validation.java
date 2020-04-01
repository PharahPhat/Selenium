package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

// Test Case 90814:Open EVV-Client-Validate (mix) - Weekend field formats/values

public class TC90814_Weekend_field_Validation extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	//To validate the invalid Service length
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC90814_OpenEVV_Client_Weekend_Validation_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC90814_OpenEVV_Client_Weekend_Validation_valid");

		System.out.println("**************Started executing positive scenario for weekend*************");
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("Weekend", "2018-01-15T22:20:00Z");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
		//
		Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		System.out.println("###########Positive scenario of Weekend Completed successfully###########");

		//-------------------------------------------------------------------------------------------------------------	
		System.out.println("***************Started executing invalid value scenario for weekend with invalid month**********");
		//Making json values dynamic
		//DataGeneratorClient DataClient = new DataGeneratorClient();

		js.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
		js.put("Weekend", "2018-15-15T22:20:00Z");

		bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The Weekend format is incorrect." ));
		System.out.println("########### Negative scenario with invalid Month value Completed successfully###########");
		//---------------------------------------------------------------------------------------------------------------------	
		System.out.println("*********Started executing invalid Weekend value with MM:YYYY:DD scenario**********");
		//Adding new ClentMedicaidID as old one is already used

		js.put("Weekend", "01-1999-15T22:20:00Z");

		bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The Weekend format is incorrect." ));
		System.out.println("Invalid Weekend date format with MM:YYYY:DD Completed successfully");
		//-----------------------------------------------------------------------------------------------------------------------	
		System.out.println("*********Started executing invalid Weekend value DD:MM:YYYY scenario**********");


		js.put("Weekend", "15-01-1999T22:20:00Z");

		bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The Weekend format is incorrect." ));
		System.out.println("Invalid Weekend date format with DD:MM:YYYY Completed successfully");

		//-----------------------------------------------------------------------------------------------------------------------	
		System.out.println("*********Started executing invalid Weekend value T is missing scenario**********");


		js.put("Weekend", "2018-15-15 22:20:00Z");


		bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		logger.log(LogStatus.INFO, "extracting response body " + bodyAsString);
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The Weekend format is incorrect." ));
		System.out.println("Invalid Weekend date format without T Completed successfully");

		//-----------------------------------------------------------------------------------------------------------------------	
		System.out.println("*********Started executing invalid Weekend value Z is missing scenario**********");

		js.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
		js.put("Weekend", "2018-15-15T22:20:00");

		bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The Weekend format is incorrect." ));
		System.out.println("Invalid Weekend date format without Z Completed successfully");

		//-----------------------------------------------------------------------------------------------------------------------	
		System.out.println("*********Started executing invalid Weekend value time is missing only date scenario**********");

		js.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12));
		js.put("Weekend", "2018-15-15TZ");

		 bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		logger.log(LogStatus.INFO, "Validating Json response ");

		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		//
		Assert.assertTrue(bodyAsString.contains("ERROR: The Weekend format is incorrect." ));
		System.out.println("Invalid Weekend date format without time Completed successfully");

	}
}



