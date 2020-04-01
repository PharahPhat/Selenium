package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

//Test Case 91096:OpenEVV-altEVV- Client Payer: Validate (mix) - PayerID field formats/values

public class R2267_TC91096_AltEVV_PayerID_field extends BaseTest {
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//validating valid altEVV client  having PayerID_valid of Max Length i.e 64 char
	@Test(groups = {"All"})
	@AdditionalInfo(module = "AltEVVclient")
	public void R2267_TC91096_AltEVV_PayerID_valid_Max_Length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91096_AltEVV_PayerID_valid_Max_Length");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having PayerID_valid of Max Length i.e 64 char"); 
		String payerid=CommonMethods.generateRandomNumberOfFixLength(64);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerID, payerid);
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}
	
	//validating valid altEVV client  having PayerID_valid of min Length i.e 1 char
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "AltEVVclient")
	public void R2267_TC91096_AltEVV_PayerID_valid_Min_Length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91096_AltEVV_PayerID_valid_Min_Length");

		String payerid=CommonMethods.generateRandomNumberOfFixLength(1);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerID, payerid);
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	//validating valid altEVV client  having PayerID_having no value i.e null
	@Test(groups = {"All"})
	@AdditionalInfo(module = "AltEVVclient")
	public void R2267_TC91096_AltEVV_PayerID_invalid_missing_value() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91096_AltEVV_PayerID_invalid_missing_value");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having PayerID_having no value i.e null"); 
		String payerid=null;

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerID, payerid);
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorIDNull_AltEVV);
		
		}
	
	//validating valid altEVV client  having PayerID_having maximum plus one value
	@Test(groups = {"All"})
	@AdditionalInfo(module = "AltEVVclient")
	public void R2267_TC91096_AltEVV_PayerID_invalid_max_plus_one_value() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91096_AltEVV_PayerID_invalid_max_plus_one_value");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having PayerID_having maximum plus one value"); 
		String payerid=CommonMethods.generateRandomNumberOfFixLength(65);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerID, payerid);
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorIdLength1);
	}
}