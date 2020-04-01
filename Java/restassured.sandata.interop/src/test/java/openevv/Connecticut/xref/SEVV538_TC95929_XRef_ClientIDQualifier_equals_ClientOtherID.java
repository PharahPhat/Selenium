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

public class SEVV538_TC95929_XRef_ClientIDQualifier_equals_ClientOtherID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	String ClientOtherIDval;

	// Case1 Validate ClientIDQualifier_equals_ClientOtherID

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95929_OpenEVV_XRef_ClientIDQualifier_equals_ClientOtherID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC95929_OpenEVV_XRef_ClientIDQualifier_equals_ClientOtherID");  // adding method name info via logger

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, "ClientOtherID");

		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	}

	// Case2 Validate ClientIDQualifier_equals_ClientotherID (Invalid)

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95929_OpenEVV_XRef_ClientIDQualifier_equals_ClientotherID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC95929_OpenEVV_XRef_ClientIDQualifier_equals_ClientotherID");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95929_OpenEVV_XRef_ClientIDQualifier_equals_ClientotherID"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, "ClientotherID");

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}
	// Case3 Validate ClientIDQualifier_equals_clientOtherID (Invalid)

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95929_OpenEVV_XRef_ClientIDQualifier_equals_clientOtherID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC95929_OpenEVV_XRef_ClientIDQualifier_equals_clientOtherID");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95929_OpenEVV_XRef_ClientIDQualifier_equals_clientOtherID"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, "clientOtherID");

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}

	// Case4 Validate ClientIDQualifier_equals_clientotherid (Invalid)

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95929_OpenEVV_XRef_ClientIDQualifier_equals_clientotherid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC95929_OpenEVV_XRef_ClientIDQualifier_equals_clientotherid");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95929_OpenEVV_XRef_ClientIDQualifier_equals_clientotherid"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, "clientotherid");

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}

	// Case5 Validate ClientIDQualifier_invalid()

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95929_OpenEVV_XRef_ClientIDQualifier_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC95929_OpenEVV_XRef_ClientIDQualifier_invalid");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95929_OpenEVV_XRef_ClientIDQualifier_invalid"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientOtherID, CommonMethods.generateRandomNumberOfFixLength(5));
		ClientOtherIDval= js.get("ClientOtherID").toString();
		js.put(globalVariables.ClientIDQualifier, ClientOtherIDval);

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	}
	// Case6 Validate ClientIDQualifier_Randomvalue

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95929_OpenEVV_XRef_ClientIDQualifier_Randomvalue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC95929_OpenEVV_XRef_ClientIDQualifier_Randomvalue");  // adding method name info via logger

		logger.log(LogStatus.INFO, "TC95929_OpenEVV_XRef_ClientIDQualifier_Randomvalue"); // adding what you are verifying details

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) jsonarray.get(0);

		js.put(globalVariables.ClientIDQualifier, CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);

	}
}
