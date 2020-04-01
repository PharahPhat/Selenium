/**
 * 
 */
package openevv.Connecticut.xref;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */

public class SEVV538_TC95936_XRef_EmployeeQualifier_equals_EmployeeRegID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	// Case1 Validate EmployeeQualifier_equals_EmployeeRegID

	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95936_XRef_EmployeeQualifier_equals_EmployeeRegID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC95936_XRef_EmployeeQualifier_equals_EmployeeRegID");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95936_XRef_EmployeeQualifier_equals_EmployeeRegID"); // adding what you are verifying details

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("EmployeeQualifier", "EmployeeRegID");
				
		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	}

	// Case2 Validate EmployeeQualifier_equals_Employeeregid (Invalid)

	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95936_XRef_EmployeeQualifier_equals_Employeeregid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC95936_XRef_EmployeeQualifier_equals_Employeeregid");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95936_XRef_EmployeeQualifier_equals_Employeeregid"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonObject=CommonMethods.LoadJSON_OpenEVV(globalVariables.xref_json);

		JSONObject js = (JSONObject) jsonObject.get(0);

		js.put(globalVariables.EmployeeQualifier, "Employeeregid");

		String bodyAsString = CommonMethods.capturePostResponse(jsonObject, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierformat);
	}
	// Case3 Validate EmployeeQualifier_equals_employeeRegID (Invalid)

	@Test(groups = {"All", "fixing"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC95936_XRef_EmployeeQualifier_equals_employeeRegID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
		{
			// logger = extent.startTest("TC95936_XRef_EmployeeQualifier_equals_employeeRegID");  // adding method name info via logger

			logger.log(LogStatus.INFO, "TC95936_XRef_EmployeeQualifier_equals_employeeRegID"); // adding what you are verifying details

			//Using Reusable method to load client json
			JSONArray jsonObject=CommonMethods.LoadJSON_OpenEVV(globalVariables.xref_json);

			//Making json values dynamic

			JSONObject js = (JSONObject) jsonObject.get(0);

			js.put(globalVariables.EmployeeQualifier, "employeeRegID");

			String bodyAsString = CommonMethods.capturePostResponse(jsonObject, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierformat);
		}

		// Case4 Validate EmployeeQualifier_equals_employeeregid (Invalid)

	@Test(groups = {"All", "fixing"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC95936_XRef_EmployeeQualifier_equals_employeeregid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
		{
			// logger = extent.startTest("TC95936_XRef_EmployeeQualifier_equals_employeeregid");  // adding method name info via logger

			logger.log(LogStatus.INFO, "TC95936_XRef_EmployeeQualifier_equals_employeeregid"); // adding what you are verifying details

			//Using Reusable method to load client json
			JSONArray jsonObject=CommonMethods.LoadJSON_OpenEVV(globalVariables.xref_json);

			//Making json values dynamic

			JSONObject js = (JSONObject) jsonObject.get(0);

			js.put(globalVariables.EmployeeQualifier, "employeeregid");	

			String bodyAsString = CommonMethods.capturePostResponse(jsonObject, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierformat);
		}

		// Case5 Validate EmployeeQualifier_Randomvalue

	@Test(groups = {"All", "fixing"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC95936_XRef_EmployeeQualifier_Randomvalue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
		{
			// logger = extent.startTest("TC95936_XRef_EmployeeQualifier_Randomvalue");  // adding method name info via logger

			logger.log(LogStatus.INFO, "TC95936_XRef_EmployeeQualifier_Randomvalue"); // adding what you are verifying details

			//Using Reusable method to load client json
			JSONArray jsonObject=CommonMethods.LoadJSON_OpenEVV(globalVariables.xref_json);

			JSONObject js = (JSONObject) jsonObject.get(0);

			//Making json values dynamic
			js.put(globalVariables.EmployeeQualifier, CommonMethods.generateRandomNumberOfFixLength(5));

			String bodyAsString = CommonMethods.capturePostResponse(jsonObject, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierformat);

		}



}
