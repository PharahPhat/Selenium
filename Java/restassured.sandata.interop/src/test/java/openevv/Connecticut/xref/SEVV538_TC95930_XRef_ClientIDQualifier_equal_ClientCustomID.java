/**
 * 
 */
package openevv.Connecticut.xref;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Anupam
 *
 */

public class SEVV538_TC95930_XRef_ClientIDQualifier_equal_ClientCustomID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	// Case1 Validate ClientIDQualifier_equals_ClientCustomID
	
	@Test(groups = {"Database"})
	@AdditionalInfo(module = "OpenEVV")
	   public void TC95930_OpenEVV_XRef_ClientIDQualifier_equals_ClientCustomID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC95930_OpenEVV_XRef_ClientIDQualifier_equals_ClientCustomID");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95930_OpenEVV_XRef_ClientIDQualifier_equals_ClientCustomID"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonarray.get(0);

		jsobject.put(globalVariables.ClientIDQualifier, "ClientCustomID");

		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

	}
	
	// Case2 Validate ClientIDQualifier_equals_ClientcustomID (Invalid)
	
		@Test(groups = {"All"})
		@AdditionalInfo(module = "OpenEVV")
	   public void TC95930_OpenEVV_XRef_ClientIDQualifier_equals_ClientcustomID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
		{
			// logger = extent.startTest("TC95930_OpenEVV_XRef_ClientIDQualifier_equals_ClientcustomID");  // adding method name info via logger

			logger.log(LogStatus.INFO, "TC95930_OpenEVV_XRef_ClientIDQualifier_equals_ClientcustomID"); // adding what you are verifying details

			//Using Reusable method to load client json
			JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

			//Making json values dynamic

			JSONObject js = (JSONObject) jsonarray.get(0);
			
			js.put(globalVariables.ClientIDQualifier, "ClientcustomID");
		
			String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
		}
	// Case3 Validate ClientIDQualifier_equals_clientCustomID (Invalid)
		
			@Test(groups = {"All"})
			@AdditionalInfo(module = "OpenEVV")
	   public void TC95930_OpenEVV_XRef_ClientIDQualifier_equals_clientCustomID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
			{
				// logger = extent.startTest("TC95930_OpenEVV_XRef_ClientIDQualifier_equals_clientCustomID");  // adding method name info via logger

				logger.log(LogStatus.INFO, "TC95930_OpenEVV_XRef_ClientIDQualifier_equals_clientCustomID"); // adding what you are verifying details

				//Using Reusable method to load client json
				JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

				//Making json values dynamic

				JSONObject js = (JSONObject) jsonarray.get(0);
			
				js.put(globalVariables.ClientIDQualifier, "clientCustomID");
				//assigning db value to local variables.

				String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
				
				CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
			}
			
	// Case4 Validate ClientIDQualifier_equals_clientcustomid (Invalid)
			
				@Test(groups = {"All"})
				@AdditionalInfo(module = "OpenEVV")
	   public void TC95930_OpenEVV_XRef_ClientIDQualifier_equals_clientcustomid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
				{
					// logger = extent.startTest("TC95930_OpenEVV_XRef_ClientIDQualifier_equals_clientcustomid");  // adding method name info via logger

					logger.log(LogStatus.INFO, "TC95930_OpenEVV_XRef_ClientIDQualifier_equals_clientcustomid"); // adding what you are verifying details

					//Using Reusable method to load client json
					JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

					//Making json values dynamic

					JSONObject js = (JSONObject) jsonarray.get(0);
				
					js.put(globalVariables.ClientIDQualifier, "clientcustomid");

					String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
					
					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
				}
				
   // Case5 Validate ClientIDQualifier_Randomvalue
				
				@Test(groups = {"All"})
				@AdditionalInfo(module = "OpenEVV")
	   public void TC95930_OpenEVV_XRef_ClientIDQualifier_Randomvalue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
				{
					// logger = extent.startTest("TC95930_OpenEVV_XRef_ClientIDQualifier_Randomvalue");  // adding method name info via logger

					logger.log(LogStatus.INFO, "TC95930_OpenEVV_XRef_ClientIDQualifier_Randomvalue"); // adding what you are verifying details

					//Using Reusable method to load client json
					JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

					//Making json values dynamic

					JSONObject js = (JSONObject) jsonarray.get(0);
					
					js.put(globalVariables.ClientIDQualifier, CommonMethods.generateRandomNumberOfFixLength(5));

					String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
					
				}
}
