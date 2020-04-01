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


public class R2154_TC96847_ClientBirthDate_invalid extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96847_ClientBirthDate_invalid_dateformat_ddmmyyyy() throws IOException, ParseException{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientBirthDate", 28012019);
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientBirthDateerror);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96847_ClientBirthDate_invalid_format_ddyyyymm() throws IOException, ParseException {
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientBirthDate", 22201901);
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientBirthDateerror);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96847_ClientBirthDate_valid_with_pastdate() throws IOException, ParseException
	{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientBirthDate", CommonMethods.generatePastDate_MMddYYYY());
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96847_ClientBirthDate_invalid_format_yyyymmdd() throws IOException, ParseException {
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientBirthDate", 20190125);
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientBirthDateerror);
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96847_ClientBirthDate_invalid_format_Mmddyyyy_string() throws IOException, ParseException
	{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientBirthDate", CommonMethods.generateTodayDate_MMddyyyy());
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96847_ClientBirthDate_valid_dateformat_Mmddyyyy_future() throws IOException, ParseException{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientBirthDate", CommonMethods.generateFutureDate_MMddyyyy());
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString);
	}
}
