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

//TC91118: OpenEVV-altEVV- Client: Validate If the ClientSSN field is left empty

public class R2858_TC96090_AltEVV_ClientContactPhone extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	// Validating valid altEVV  ClientContactphone with 10 digit
	@Test(groups = {"All"})
	public void R2858_TC96090_AltEVV_ClientContactPhone_Valid_with_10Digit() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96090_AltEVV_ClientContactPhone_Valid_with_10Digit");
		logger.log(LogStatus.INFO, "Validating valid altEVV  ClientContactphone with 10 digit"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhone, CommonMethods.generateRandomNumberOfFixLength(10) );

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	// Validating inValid altEVV  ClientContactphone having less than 10 digit
	@Test(groups = {"All"})
	public void R2858_TC96090_AltEVV_ClientContactPhone_inValid_lessthan_10Digit() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2858_TC96090_AltEVV_ClientContactPhone_inValid_lessthan_10Digit");
		logger.log(LogStatus.INFO, "Validating valid altEVV  ClientContactphone having less than 10 digit"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhone, CommonMethods.generateRandomNumberOfFixLength(9) );

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhonelengtherror1);


	}

	// Validating inValid altEVV  ClientContactphone having more than 10 digit
	@Test(groups = {"All"})
	public void R2858_TC96090_AltEVV_ClientContactPhone_inValid_morethan_10Digit() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2858_TC96090_AltEVV_ClientContactPhone_inValid_morethan_10Digit");
		logger.log(LogStatus.INFO, "Validating valid altEVV  ClientContactphone having more than 10 digit"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhone, CommonMethods.generateRandomNumberOfFixLength(11) );

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhonelengtherror1);


	}

	// Validating inValid altEVV  ClientContactphone having leading space than 10 digit
	@Test(groups = {"All"})
	public void R2858_TC96090_AltEVV_ClientContactPhone_inValid_leadingSpace_10Digit() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2858_TC96090_AltEVV_ClientContactPhone_inValid_leadingSpace_10Digit");
		logger.log(LogStatus.INFO, "Validating valid altEVV  ClientContactphone having leading space 10 digit"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhone, " " + CommonMethods.generateRandomNumberOfFixLength(10) );

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhonelengtherror1);


	}

	// Validating inValid altEVV  ClientContactphone having trailing space 10 digit
	@Test(groups = {"All"})
	public void R2858_TC96090_AltEVV_ClientContactPhone_inValid_trailingspace_10Digit() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2858_TC96090_AltEVV_ClientContactPhone_inValid_trailingspace_10Digit");
		logger.log(LogStatus.INFO, " Validating valid altEVV  ClientContactphone having trailing space 10 digit"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhone, CommonMethods.generateRandomNumberOfFixLength(10)
				+ " " );

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhonelengtherror1);


	}

	// Validating inValid altEVV  ClientContactphone having mid space between 10 digit
	@Test(groups = {"All"})
	public void R2858_TC96090_AltEVV_ClientContactPhone_inValid_MidSpace_10Digit() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2858_TC96090_AltEVV_ClientContactPhone_inValid_MidSpace_10Digit");
		logger.log(LogStatus.INFO, "Validating valid altEVV  ClientContactphone having mid space between 10 digit"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhone, CommonMethods.generateRandomNumberOfFixLength(5)
				+ " " + CommonMethods.generateRandomNumberOfFixLength(5) );

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhonelengtherror1);


	}
	
	// Validating inValid altEVV  ClientContactphone having mid space between 10 digit
	@Test(groups = {"All"})
	public void R2858_TC96090_AltEVV_ClientContactPhone_inValid_NotNum_10Digit() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2858_TC96090_AltEVV_ClientContactPhone_inValid_MidSpace_10Digit");
		logger.log(LogStatus.INFO, "Validating valid altEVV  ClientContactphone having mid space between 10 digit"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactPhone, CommonMethods.generateRandomAlphaNumeric(10));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhonelengtherror1);


	}
}