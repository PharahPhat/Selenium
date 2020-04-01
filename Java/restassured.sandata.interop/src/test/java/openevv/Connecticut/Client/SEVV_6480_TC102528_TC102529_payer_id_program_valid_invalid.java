package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SEVV_6480_TC102528_TC102529_payer_id_program_valid_invalid extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC102528_OpenEVV_payerprogramm_Payerid_have_valid_value() throws IOException, ParseException
	{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArraynew = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObjectnew = (JSONObject) jsonArraynew.get(0);
		jsonObjectnew.put("PayerProgram",CommonMethods.generateRandomNumberOfFixLength(8));	
		jsonObjectnew.put("PayerID", CommonMethods.generateRandomNumberOfFixLength(18));
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
	}
	

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC102529_OpenEVV_Payerprogramm_have_morethan_allowed_length() throws IOException, ParseException
	{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArraynew = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObjectnew = (JSONObject) jsonArraynew.get(0);
		jsonObjectnew.put("PayerProgram",CommonMethods.generateRandomNumberOfFixLength(10));
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayerProgramError);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC102529_OpenEVV_PayerID_have_morethan_allowed_length() throws IOException, ParseException
	{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArraynew = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObjectnew = (JSONObject) jsonArraynew.get(0);
		jsonObjectnew.put("PayerID", CommonMethods.generateRandomNumberOfFixLength(65));
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.payerIdSizeError);
	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC102528_OpenEVV_payerprogramm_have_valid_value() throws IOException, ParseException
	{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArraynew = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObjectnew = (JSONObject) jsonArraynew.get(0);
		jsonObjectnew.put("PayerProgram",CommonMethods.generateRandomNumberOfFixLength(8));
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC102528_OpenEVV_payerIDhave_valid_value() throws IOException, ParseException
	{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArraynew = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObjectnew = (JSONObject) jsonArraynew.get(0);
		jsonObjectnew.put("PayerID", CommonMethods.generateRandomNumberOfFixLength(12));
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC102528_OpenEVV_ClientEligibilityDateBegin_End_valid_value() throws IOException, ParseException
	{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArraynew = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObjectnew = (JSONObject) jsonArraynew.get(0);
		jsonObjectnew.put("ClientEligibilityDateBegin", CommonMethods.generatePastDate_YYYY_MM_dd());	
		jsonObjectnew.put("ClientEligibilityDateEnd", CommonMethods.generatePastDate_YYYY_MM_dd());	
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC102528_OpenEVV_ClientEligibilityDateBegin_end_invalid_value() throws IOException, ParseException
	{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArraynew = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObjectnew = (JSONObject) jsonArraynew.get(0);
		jsonObjectnew.put("ClientEligibilityDateBegin", CommonMethods.generateFutureDate_MM_DD_YYYY());	
		jsonObjectnew.put("ClientEligibilityDateEnd", CommonMethods.generateFutureDate_MM_DD_YYYY());	
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientEligibilityDateEnderror1);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.openevvClientDatebeginerror);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC102528_OpenEVV_ClientEligibilityDateBegin_blank_value() throws IOException, ParseException
	{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArraynew = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObjectnew = (JSONObject) jsonArraynew.get(0);
		jsonObjectnew.put("ClientEligibilityDateBegin", "");		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC102528_OpenEVV_ClientEligibilityDateend_blank_value() throws IOException, ParseException
	{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArraynew = (JSONArray) jsonObject.get("ClientPayerInformation");	
		JSONObject jsonObjectnew = (JSONObject) jsonArraynew.get(0);
		jsonObjectnew.put("ClientEligibilityDateEnd", "");
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
	}
}
