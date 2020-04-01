/**
 * 
 */
package openevv.Connecticut.xref;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author RRohiteshwar
 */
//Test Case 89739:open evv-Xref- Invalid employee pin

public class TC89739_EmployeePin extends BaseTest {
	@Test(groups = {"All", "fixing"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC89739_OpenEVV_XRef_TC89739_OpenEVV_XRef_EmployeePIN_invalid_more_than_9() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
		{
			// logger = extent.startTest("TC89739_OpenEVV_XRef_TC89739_OpenEVV_XRef_EmployeePIN_invalid_more_than_9");  // adding method name info via logger
			 
			logger.log(LogStatus.INFO, "To validate the invalid EmployeePIN more than 9"); // adding what you are verifing
			
			//Using Reusable method to load client json
			JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

			//Making json values dynamic

			JSONObject js = (JSONObject) j.get(0);
			js.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(10));
			logger.log(LogStatus.INFO, "Passing EmployeePIN as Random ");
	   
			String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
			
			logger.log(LogStatus.INFO, "Validating Json response ");
			//Using Assert to validate the expected result
			Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
			Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
			Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN format is incorrect. The record should satisfy this regular expression"));

			//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
			//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		}

		//To validate the invalid EmployeePIN less than 4
		@Test(groups = {"All", "fixing"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC89739_OpenEVV_XRef_EmployeePIN_invalid_less_than_49() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
		{
			// logger = extent.startTest("TC89739_OpenEVV_XRef_EmployeePIN_invalid_less_than_49");  // adding method name info via logger
			 
			logger.log(LogStatus.INFO, "To validate the invalid EmployeePIN less than 4"); // adding what you are verifing
			//Using Reusable method to load client json
			JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

			//Making json values dynamic

			JSONObject js = (JSONObject) j.get(0);
			js.put("EmployeePIN", CommonMethods.generateRandomNumberOfFixLength(3));
			logger.log(LogStatus.INFO, "Passing EmployeePIN as Random ");
	
			String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
			
			logger.log(LogStatus.INFO, "Validating Json response ");
			//Using Assert to validate the expected result
			Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
			Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
			Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN format is incorrect. The record should satisfy this regular expression"));

			//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
			//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		}

		//To validate the invalid EmployeePIN with alpha numeric
		@Test(groups = {"All", "fixing"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC89739_OpenEVV_XRef_EmployeePIN_invalid_alpha_num() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
		{
			// logger = extent.startTest("TC89739_OpenEVV_XRef_EmployeePIN_invalid_alpha_num");  // adding method name info via logger
			 
			
			//Using Reusable method to load client json
			JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

			//Making json values dynamic

			JSONObject js = (JSONObject) j.get(0);
			js.put("EmployeePIN", CommonMethods.generateRandomAlphaNumeric(5));
			logger.log(LogStatus.INFO, "Passing EmployeePIN as Random ");
	
			String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
			
			logger.log(LogStatus.INFO, "Validating Json response ");
			//Using Assert to validate the expected result
			Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
			Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
			Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN format is incorrect. The record should satisfy this regular expression"));

			//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
			//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		}

		//To validate the invalid EmployeePIN with special character
		@Test(groups = {"All", "fixing"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC89739_OpenEVV_XRef_EmployeePIN_invalid_special_char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
		{
			// logger = extent.startTest("TC89739_OpenEVV_XRef_EmployeePIN_invalid_special_char");  // adding method name info via logger
			//Using Reusable method to load client json
			JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

			//Making json values dynamic

			JSONObject js = (JSONObject) j.get(0);
			js.put("EmployeePIN", CommonMethods.generateSpecialChar(6));
			logger.log(LogStatus.INFO, "Passing EmployeePIN as Random ");

			String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
			
			logger.log(LogStatus.INFO, "Validating Json response ");
			//Using Assert to validate the expected result
			Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
			Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
			Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN format is incorrect. The record should satisfy this regular expression"));

			//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
			//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		}

		//To validate the invalid EmployeePIN with leading space
		@Test(groups = {"All", "fixing"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC89739_OpenEVV_XRef_EmployeePIN_invalid_leading_Space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
		{
			// logger = extent.startTest("TC89739_OpenEVV_XRef_EmployeePIN_invalid_leading_Space");  // adding method name info via logger
			 
			
			
			//Using Reusable method to load client json
			JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

			//Making json values dynamic

			JSONObject js = (JSONObject) j.get(0);
			js.put("EmployeePIN"," " + CommonMethods.generateRandomNumberOfFixLength(6));
			logger.log(LogStatus.INFO, "Passing EmployeePIN as Random ");

			String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
			
			logger.log(LogStatus.INFO, "Validating Json response ");
			//Using Assert to validate the expected result
			Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
			Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
			Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN format is incorrect. The record should satisfy this regular expression"));

			//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
			//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		}
		
		//To validate the invalid EmployeePIN with trailing space
		@Test(groups = {"All", "fixing"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC89739_OpenEVV_XRef_EmployeePIN_invalid_trailing_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
		{
			// logger = extent.startTest("TC89739_OpenEVV_XRef_EmployeePIN_invalid_trailing_space");  // adding method name info via logger
			//Using Reusable method to load client json
			JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

			//Making json values dynamic

			JSONObject js = (JSONObject) j.get(0);
			js.put("EmployeePIN",CommonMethods.generateRandomNumberOfFixLength(6)+" ");
			
			 
			logger.log(LogStatus.INFO, "Passing EmployeePIN as Random ");

			String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
			
			logger.log(LogStatus.INFO, "Validating Json response ");
			//Using Assert to validate the expected result
			Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
			Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
			Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeePIN format is incorrect. The record should satisfy this regular expression"));

			//Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
			//Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
		}
	}

