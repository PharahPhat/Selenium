
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

public class SEVV538_TC95927_XRef_ClientIDQualifier_equals_ClientID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
String ClientIDval;
	// Case1 Validate ClientIDQualifier_equals_ClientID

	@Test(groups = {"SEVV-17391"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95927_OpenEVV_XRef_ClientIDQualifier_equals_ClientID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC95927_OpenEVV_XRef_ClientIDQualifier_equals_ClientID");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95927_OpenEVV_XRef_ClientIDQualifier_equals_ClientID"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, "ClientID");

		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	}

	// Case2 Validate ClientIDQualifier_equals_Clientid (Invalid)

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95927_OpenEVV_XRef_ClientIDQualifier_equals_Clientid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC95927_OpenEVV_XRef_ClientIDQualifier_equals_Clientid");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95927_OpenEVV_XRef_ClientIDQualifier_equals_Clientid"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, "Clientid");

		//assigning db value to local variables.

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}
	// Case3 Validate ClientIDQualifier_equals_clientID (Invalid)

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95927_OpenEVV_XRef_ClientIDQualifier_equals_clientID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC95927_OpenEVV_XRef_ClientIDQualifier_equals_clientID");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95927_OpenEVV_XRef_ClientIDQualifier_equals_clientID"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, "clientID");

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}

	// Case4 Validate ClientIDQualifier_equals_clientid (Invalid)

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95927_OpenEVV_XRef_ClientIDQualifier_equals_clientid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC95927_OpenEVV_XRef_ClientIDQualifier_equals_clientid");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95927_OpenEVV_XRef_ClientIDQualifier_equals_clientid"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, "clientid");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}

	// Case5 Validate ClientIDQualifier_invalid()

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95927_OpenEVV_XRef_ClientIDQualifier_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC95927_OpenEVV_XRef_ClientIDQualifier_invalid");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95927_OpenEVV_XRef_ClientIDQualifier_invalid"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonarray.get(0);

		jsobject.put(globalVariables.ClientID, CommonMethods.generateRandomNumberOfFixLength(5));
		
		ClientIDval=jsobject.get("ClientID").toString();
		
		jsobject.put(globalVariables.ClientIDQualifier, ClientIDval);

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}
	// Case6 Validate ClientIDQualifier_Randomvalue

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95927_OpenEVV_XRef_ClientIDQualifier_Randomvalue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC95927_OpenEVV_XRef_ClientIDQualifier_Randomvalue");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95927_OpenEVV_XRef_ClientIDQualifier_Randomvalue"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject js = (JSONObject) jsonarray.get(0);

		//Making json values dynamic
		js.put(globalVariables.ClientIDQualifier, CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}
}
