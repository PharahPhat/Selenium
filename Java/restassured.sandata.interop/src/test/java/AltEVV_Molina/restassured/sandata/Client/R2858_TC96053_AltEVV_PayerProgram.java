package AltEVV_Molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;


import com.globalMethods.core.Assertion_DbVerifier; public class R2858_TC96053_AltEVV_PayerProgram extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	String clntid;

	//validating valid altEVV client  having payer program of Max Length i.e 9 char
	@Test(groups = {"All"})
	public void R2858_TC96053_AltEVV_PayerProgram_valid_Max_Length_string() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96053_AltEVV_PayerProgram_valid_Max_Length_string");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having payer program of Max Length i.e 9 char"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerProgram, CommonMethods.generateRandomStringOfFixLength(9));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//validating invalid altEVV client  having payer program of Max Length i.e 9 c but having specialchar
	@Test(groups = {"All"})
	public void R2858_TC96053_AltEVV_PayerProgram_invalid_Max_Length_specialchar() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96053_AltEVV_PayerProgram_invalid_Max_Length_specialchar");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having payer program of Max Length i.e 9 char"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerProgram, CommonMethods.generateSpecialChar(10));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The PayerProgram value is incorrect. The length should be between 1 and 9");
	}

	//validating invalid altEVV client  having payer program of Max Length  ie 10 char
	@Test(groups = {"All"})
	public void R2858_TC96053_AltEVV_PayerProgram_invalid_Max_plus_one_Length_String() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96053_AltEVV_PayerProgram_valid_Max_Length");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having payer program of Max Length i.e 9 char"); 
		String payerprogrm=CommonMethods.generateRandomStringOfFixLength(10);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.PayerProgram, payerprogrm);
		clntid=jsonObject.get(globalVariables.ClientID).toString();

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The PayerProgram value is incorrect. The length should be between 1 and 9.");
	}
}