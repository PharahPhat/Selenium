package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
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

//TC91121: OpenEVV-altEVV- Client- Validate (mix) - ClientStatus field formats/values

public class R2267_TC91121_AltEVV_ClientStatus extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void R2267_TC91121_AltEVV_ClientStatus_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_valid");
		logger.log(LogStatus.INFO, "Validate valid Client Address Line 1"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayPayer = 	(JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayPayer.get(0);
		jsonObjectAdd.put("ClientStatus", "01");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	@Test(groups = {"All"})
	public void R2267_TC91121_AltEVV_ClientStatus_invalid_length() throws InterruptedException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91121_AltEVV_ClientStatus_invalid_length");
		logger.log(LogStatus.INFO, "TC91121_AltEVV_ClientStatus_invalid_length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayPayer = 	(JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayPayer.get(0);
		jsonObjectAdd.put("ClientStatus", CommonMethods.generateRandomNumberOfFixLength(3));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStatus_error_format);
		
	}
	@Test
	public void R2267_TC91121_AltEVV_ClientStatus_optional() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_valid");
		logger.log(LogStatus.INFO, "Validate valid Client Address Line 1"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayPayer = 	(JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayPayer.get(0);
		
		jsonObjectAdd.put("ClientStatus", "");


		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	@Test
	public void R2267_TC91121_AltEVV_ClientStatus_invalid_string() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91121_AltEVV_ClientStatus_invalid_string");
		logger.log(LogStatus.INFO, "R2267_TC91121_AltEVV_ClientStatus_invalid_string"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayPayer = 	(JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayPayer.get(0);
		jsonObjectAdd.put("ClientStatus", CommonMethods.generateRandomStringOfFixLength(2));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStatus_error_format);

	}
	
	@Test
	public void R2267_TC91121_AltEVV_ClientStatus_valid_Active() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91121_AltEVV_ClientStatus_valid_Active");
		logger.log(LogStatus.INFO, "R2267_TC91121_AltEVV_ClientStatus_valid_Active"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayPayer = 	(JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayPayer.get(0);
		jsonObjectAdd.put("ClientStatus", "02");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}
	
	@Test
	public void R2267_TC91121_AltEVV_ClientStatus_valid_InActive() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91121_AltEVV_ClientStatus_valid_InActive");
		logger.log(LogStatus.INFO, "R2267_TC91121_AltEVV_ClientStatus_valid_InActive"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayPayer = 	(JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayPayer.get(0);
		jsonObjectAdd.put("ClientStatus", "04");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}
	
	@Test
	public void R2267_TC91121_AltEVV_ClientStatus_valid_Hold() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91121_AltEVV_ClientStatus_valid_Hold");
		logger.log(LogStatus.INFO, "R2267_TC91121_AltEVV_ClientStatus_valid_Hold"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONArray jsonArrayPayer = 	(JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayPayer.get(0);
		jsonObjectAdd.put("ClientStatus", "03");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	@Test
	public void R2267_TC91121_AltEVV_ClientStatus_optional_with_ClientEligibilityDateBegin() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC91121_AltEVV_ClientStatus_optional_with_ClientEligibilityDateBegin");
		logger.log(LogStatus.INFO, "TC91121_AltEVV_ClientStatus_optional_with_ClientEligibilityDateBegin"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientEligibilityDateBegin", CommonMethods.generatePastDate_YYYY_MM_dd());
		JSONArray jsonArrayPayer = 	(JSONArray) jsonObject.get("ClientPayerInformation");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayPayer.get(0);
		jsonObjectAdd.put("ClientStatus", null);
		
		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

}