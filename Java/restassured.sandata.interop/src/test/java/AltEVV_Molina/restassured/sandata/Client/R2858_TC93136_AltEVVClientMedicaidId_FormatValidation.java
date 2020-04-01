package AltEVV_Molina.restassured.sandata.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class R2858_TC93136_AltEVVClientMedicaidId_FormatValidation extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the invalid ClientMedicaidID length
	@Test(groups = {"All"})
	public void R2858_TC93136_AltEVVClientMedicaidId_length_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("R71852_TC91091_AltEVVClientMedicaidId_length_invalid");

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		//Making json values dynamic
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(65));

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientMedicaidID value is incorrect. The length should be between 1 and 64");
	}

	//To validate the ClientMedicaidID with alphanumeric value
	@Test(groups = {"All"})
	public void R2858_TC93136_AltEVVClientMedicaidId_with_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("R71852_TC91091_AltEVVClientMedicaidId_with_alphanumeric");


		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		//Making json values dynamic
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("ClientMedicaidID", CommonMethods.generateRandomAlphaNumeric(64));

		CommonMethods.validateResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//To validate the ClientMedicaidID with duplicate value
	@Test(groups = {"All"})
	public void R2858_TC93136_AltEVVClientMedicaidId_with_duplicate() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R71852_TC91091_AltEVVClientMedicaidId_with_numeric");


		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		//Making json values dynamic
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(6));

		CommonMethods.validateResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	
		Thread.sleep(10000);

		CommonMethods.validateResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

	}

	//To validate the ClientMedicaidID with whitespace
	@Test(groups = {"All"})
	public void R2858_TC93136_AltEVVClientMedicaidId_with_headingspace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("R71852_TC91091_AltEVVClientMedicaidId_with_headingspace");


		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		//Making json values dynamic
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("ClientMedicaidID", " " + CommonMethods.generateRandomNumberOfFixLength(8));

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientMedicaidID format is incorrect.");
	}

	//To validate the ClientMedicaidID with special character
	@Test(groups = {"All"})
	public void R2858_TC93136_AltEVVClientMedicaidId_with_specialCharacter() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC88430_OpenEVV_ClientMedicaidID_with_specialCharacter");


		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		//Making json values dynamic
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("ClientMedicaidID", CommonMethods.generateSpecialChar(8));

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientMedicaidID format is incorrect.");
	}

	//To validate the ClientMedicaidID with dash character
	@Test(groups = {"All"})
	public void TR2858_TC93136_AltEVVClientMedicaidId_dashCharacter() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TR71852_TC91091_AltEVVClientMedicaidId_dashCharacter");

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		//Making json values dynamic
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		jsonobject.put("ClientMedicaidID", CommonMethods.generateSpecialChar(3) + "-" + CommonMethods.generateSpecialChar(3));

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientMedicaidID format is incorrect.");

	}


}
