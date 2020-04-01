package AltEVV_Molina.restassured.sandata.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
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

//Test Case 91204:OpenEVV-altEVV- Responsible Party/Designated Signer: Validate If the ClientContactFirstName should contains maximum characters.

public class R2858_TC96069_AltEVV_ClientContactFirstName extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//validating valid altEVV client  having ClientContactFirstname with Max_minus_one_Length
	@Test(groups = {"All"})
	public void R2858_TC96069_AltEVV_ClientContactFirstname_valid_Max_minus_one_Length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96069_AltEVV_ClientContactFirstname_valid_Max_minus_one_Length");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Max_minus_one_Length"); 
		String clntcontactfstname=CommonMethods.generateRandomStringOfFixLength(30);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactFirstName, clntcontactfstname);

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//validating valid altEVV client  having ClientContactFirstname with Mid_Length
	@Test(groups = {"All"})
	public void R2858_TC96069_AltEVV_ClientContactFirstname_valid_Mid_Length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96069_AltEVV_ClientContactFirstname_valid_Mid_Length");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Mid_Length"); 
		String clntcontactfstname=CommonMethods.generateRandomStringOfFixLength(15);
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactFirstName, clntcontactfstname);

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//validating valid altEVV client  having ClientContactFirstname with Min_Length
	@Test(groups = {"All"})
	public void R2858_TC96069_AltEVV_ClientContactFirstname_valid_Min_Length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96069_AltEVV_ClientContactFirstname_valid_Min_Length");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Min_Length"); 
		String clntcontactfstname=CommonMethods.generateRandomStringOfFixLength(1);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactFirstName, clntcontactfstname);

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//validating valid altEVV client  having ClientContactFirstname with Max_plus_one_Length
	@Test(groups = {"All"})
	public void R2858_TC96069_AltEVV_ClientContactFirstname_invalid_Max_plus_one_Length() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96069_AltEVV_ClientContactFirstname_invalid_Max_plus_one_Length");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Max_plus_one_Length"); 


		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactFirstName, CommonMethods.generateRandomStringOfFixLength(31));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientContacFirstNameMaxLengthError);
	}

	//validating valid altEVV client  having ClientContactFirstname with Max_minus_specialString
	@Test(groups = {"All"})
	public void R2858_TC96069_AltEVV_ClientContactFirstname_invalid_Max_minus_specialString() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96069_AltEVV_ClientContactFirstname_invalid_Max_minus_specialString");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Max_minus_specialString"); 


		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactFirstName, CommonMethods.generateSpecialChar(15));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientContacFirstNameFormaterror);
	}
	
	//validating valid altEVV client  having ClientContactFirstname with Max_plus_specialString
	@Test(groups = {"All"})
	public void R2858_TC96069_AltEVV_ClientContactFirstname_invalid_Max_plus_specialString() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96069_AltEVV_ClientContactFirstname_invalid_Max_plus_specialString");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with Max_plus_specialString"); 


		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.clientContactFirstName, CommonMethods.generateSpecialChar(31));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.clientContacFirstNameFormaterror);

	}
	
	//validating valid altEVV client  having ClientContactFirstname with _null
	@Test(groups = {"All"})
	public void R2858_TC96069_AltEVV_ClientContactFirstname_valid_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96069_AltEVV_ClientContactFirstname_valid_null");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactFirstname with _null"); 


		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientContactFirstName", "Null");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

}