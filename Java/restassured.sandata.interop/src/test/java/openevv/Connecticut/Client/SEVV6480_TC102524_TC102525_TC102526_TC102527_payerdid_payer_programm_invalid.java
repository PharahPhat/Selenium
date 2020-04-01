package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV6480_TC102524_TC102525_TC102526_TC102527_payerdid_payer_programm_invalid extends BaseTest{
	
	private	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC102524_OpenEVV_payerdid_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC102524_OpenEVV_payerdid_null");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArraynew = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObjectnew = (JSONObject) jsonArraynew.get(0);

		jsonObjectnew.put("PayerID", null);	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorIDNull_AltEVV);


	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC102525_OpenEVV_payerdid_empty() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2154_TC96778_OpenEVV_ClientEmailAddress_Length_max");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArraynew = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObjectnew = (JSONObject) jsonArraynew.get(0);

		jsonObjectnew.put("PayerID", "");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.payerIdSizeError);

	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC102526_OpenEVV_payerprogramm_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2154_TC96778_OpenEVV_ClientEmailAddress_Length_max");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArraynew = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObjectnew = (JSONObject) jsonArraynew.get(0);


		jsonObjectnew.put("PayerProgram", null);	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.payerProgram_openevverror);

	}
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC102527_OpenEVV_payerprogramm_empty() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2154_TC96778_OpenEVV_ClientEmailAddress_Length_max");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArraynew = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObjectnew = (JSONObject) jsonArraynew.get(0);

		jsonObjectnew.put("PayerProgram", "");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerProgramError);

	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC102526_OpenEVV_payerprogramm_Payerid_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2154_TC96778_OpenEVV_ClientEmailAddress_Length_max");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArraynew = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObjectnew = (JSONObject) jsonArraynew.get(0);

		jsonObjectnew.put("PayerProgram", null);	
		jsonObjectnew.put("PayerID", null);	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorIDNull_AltEVV);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.payerProgram_openevverror);

	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC102526_OpenEVV_payerprogramm_Payerid_empty() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2154_TC96778_OpenEVV_ClientEmailAddress_Length_max");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArraynew = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObjectnew = (JSONObject) jsonArraynew.get(0);

		jsonObjectnew.put("PayerProgram", "");	
		jsonObjectnew.put("PayerID", "");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerProgramError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.payerIdSizeError);
		

	}
	

}
