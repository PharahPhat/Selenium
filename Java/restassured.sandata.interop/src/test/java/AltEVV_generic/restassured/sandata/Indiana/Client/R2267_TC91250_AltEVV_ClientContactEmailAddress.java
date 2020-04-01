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

//Test Case 91250:Open EVV- altEVV- Client- Validate (mix) - ClientContactEmailAddress field formats/values

public class R2267_TC91250_AltEVV_ClientContactEmailAddress extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//validating valid altEVV client  having clientcontactemailaddress with numeric char only
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void R2267_TC91250_AltEVV_ClientContactEmailAddress_valid_num() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactEmailAddress_valid_num");
		logger.log(LogStatus.INFO, "validating valid alt evv client  having clientcontactemailaddress with numeric char only"); 

		String clntcontctemail=CommonMethods.generateEmailAddress_num(12);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientContactEmailAddress", clntcontctemail);

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	//validating valid altEVV client  having clientcontactemailaddress with alphanumeric char only
	@Test(groups = {"All"})
	public void R2267_TC91250_AltEVV_ClientContactEmailAddress_valid_alphnum() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactEmailAddress_valid_alphnum");
		logger.log(LogStatus.INFO, "validating valid alt evv client  having clientcontactemailaddress with alphanumeric char only"); 

		String clntcontctemail= CommonMethods.generateEmailAddress_alpha(12);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientContactEmailAddress", clntcontctemail);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientContactEmailAddress", clntcontctemail);

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	}

	//validating valid altEVV client  having clientcontactemailaddress with alphabet char only
	@Test(groups = {"All"})
	public void R2267_TC91250_AltEVV_ClientContactEmailAddress_valid_alpha() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactEmailAddress_valid_alpha");
		logger.log(LogStatus.INFO, "//validating valid alt evv client  having clientcontactemailaddress with alphabet char only"); 

		String clntcontctemail= CommonMethods.generateEmailAddress_string(12);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientContactEmailAddress", clntcontctemail);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientContactEmailAddress", clntcontctemail);


		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	//validating invalid altEVV client having clientcontactemailaddress with no valid extension
	@Test(groups = {"All"})
	public void R2267_TC91250_AltEVV_ClientContactEmailAddress_invalid_with_novalidation() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactEmailAddress_invalid_with_novalidation");
		logger.log(LogStatus.INFO, "validating invalid altEVV client having clientcontactemailaddress with no valid extension"); 

		String clntcontctemail=CommonMethods.generateEmailAddress_num(64);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientContactEmailAddress", clntcontctemail);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientContactEmailAddress", clntcontctemail);


		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactEmailAddress_MaxLength_Error);
	}

	//validating invalid altEVV client having clientcontactemailaddress with no valid extension
	@Test(groups = {"All"})
	public void R2267_TC91250_AltEVV_ClientContactEmailAddress_invalid_with_maxchar() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactEmailAddress_invalid_with_novalidation");
		logger.log(LogStatus.INFO, "validating invalid altEVV client having clientcontactemailaddress with no valid extension"); 

		String clntcontctemail=CommonMethods.generateRandomAlphaNumeric(14);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientContactEmailAddress", clntcontctemail);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientContactEmailAddress", clntcontctemail);


		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactEmailAddress_Format_Error);
	}

	//validating invalid altEVV client having clientcontactemailaddress with no incomplete validation
	@Test(groups = {"All"})
	public void R2267_TC91250_AltEVV_ClientContactEmailAddress_invalid_with_incompletevalidation() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactEmailAddress_invalid_with_incompletevalidation");
		logger.log(LogStatus.INFO, "validating invalid altEVV client having clientcontactemailaddress with no incomplete validation"); 

		String clntcontctemail=CommonMethods.generateRandomAlphaNumeric(14) + "@mailinator";

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientContactEmailAddress", clntcontctemail);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientContactEmailAddress", clntcontctemail);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactEmailAddress_Format_Error);
	}

}