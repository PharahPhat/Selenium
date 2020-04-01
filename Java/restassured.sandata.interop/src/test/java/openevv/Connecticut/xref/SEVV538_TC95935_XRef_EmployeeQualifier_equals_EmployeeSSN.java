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
 */

public class SEVV538_TC95935_XRef_EmployeeQualifier_equals_EmployeeSSN extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	// Case1 Validate EmployeeQualifier_equals_EmployeeSSN

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95935_XRef_EmployeeQualifier_equals_EmployeeSSN() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC95935_XRef_EmployeeQualifier_equals_EmployeeSSN");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95935_XRef_EmployeeQualifier_equals_EmployeeSSN"); // adding what you are verifying details

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		jsonobject.put("EmployeeQualifier", "EmployeeSSN");

		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));


	}

	// Case2 Validate EmployeeQualifier_equals_Employeessn (Invalid)

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC95935_OpenEVV_XRef_EmployeeQualifier_equals_Employeessn() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC95935_OpenEVV_XRef_EmployeeQualifier_equals_Employeessn");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95935_OpenEVV_XRef_EmployeeQualifier_equals_Employeessn"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.EmployeeQualifier, "Employeessn");

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierformat);
	}
	// Case3 Validate EmployeeQualifier_equals_employeeSSN (Invalid)

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC95935_OpenEVV_XRef_EmployeeQualifier_equals_employeeSSN() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC95935_OpenEVV_XRef_EmployeeQualifier_equals_employeeSSN");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95935_OpenEVV_XRef_EmployeeQualifier_equals_employeeSSN"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.EmployeeQualifier, "employeeSSN");

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierformat);
	}

	// Case4 Validate EmployeeQualifier_equals_employeessn (Invalid)

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC95935_XRef_EmployeeQualifier_equals_employeessn() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC95935_XRef_EmployeeQualifier_equals_employeessn");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95935_XRef_EmployeeQualifier_equals_employeessn"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonarray.get(0);

		jsobject.put(globalVariables.EmployeeQualifier, "employeessn");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierformat);
	}

	// Case5 Validate EmployeeQualifier_Randomvalue

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95935_XRef_EmployeeQualifier_Randomvalue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC95935_XRef_EmployeeQualifier_Randomvalue");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95935_XRef_EmployeeQualifier_Randomvalue"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject js = (JSONObject) jsonarray.get(0);

		//Making json values dynamic
		js.put(globalVariables.EmployeeQualifier, CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierformat);

	}



}
