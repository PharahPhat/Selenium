package AltEVV_Molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//TC91120: OpenEVV-altEVV- Client Address -ClientAddressLine1 validation field formats/values

import com.globalMethods.core.Assertion_DbVerifier; public class R2858_TC96059_AltEVV_ClientAddLine1 extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void R2858_TC96059_AltEVV_ClientAddressLine1_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96059_AltEVV_ClientAddressLine1_valid");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		
		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd1.put("ClientAddressLine1",CommonMethods.generateRandomStringOfFixLength(30));

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd.put("ClientAddressLine1",CommonMethods.generateRandomStringOfFixLength(30));


		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
}

	@Test(groups = {"All"})
	public void R2858_TC96059_AltEVV_ClientAddressLine1_invalid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2858_TC96059_AltEVV_ClientAddressLine1_invalid_length");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);

		jsonObjectAdd.put("ClientAddressLine1",CommonMethods.getSaltString(35));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLine1 value is incorrect. The length should be between 1 and 30.");
	}

	@Test(groups = {"All"})
	public void R2858_TC96059_AltEVV_ClientAddressLine1_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96059_AltEVV_ClientAddressLine1_null");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);

		jsonObjectAdd.put("ClientAddressLine1",null);

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1NullError);

	}

	@Test(groups = {"All"})
	public void R2858_TC96059_AltEVV_ClientAddressLine1_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96059_AltEVV_ClientAddressLine1_alphanumeric");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		
		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd1.put("ClientAddressLine1",CommonMethods.generateRandomAlphaNumeric(10));

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd.put("ClientAddressLine1",CommonMethods.generateRandomAlphaNumeric(10));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

	}

	@Test(groups = {"All"})
	public void R2858_TC96059_AltEVV_ClientAddressLine1_spcl_char() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96059_AltEVV_ClientAddressLine1_nonumeric");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);

		jsonObjectAdd.put("ClientAddressLine1",CommonMethods.generateSpecialChar(10));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1FormatError);

	}

	@Test(groups = {"All"})
	public void R2858_TC96059_AltEVV_ClientAddressLine1_whitespace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96059_AltEVV_ClientAddressLine1_whitespace");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		
		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd1.put("ClientAddressLine1",CommonMethods.generateRandomStringOfFixLength(10) + " " +CommonMethods.generateRandomStringOfFixLength(5) );

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd.put("ClientAddressLine1",CommonMethods.generateRandomStringOfFixLength(10) + " " +CommonMethods.generateRandomStringOfFixLength(5) );

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	@Test(groups = {"All"})
	public void R2858_TC96059_AltEVV_ClientAddressLine1_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2858_TC96059_AltEVV_ClientAddressLine1_blank");
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);

		jsonObjectAdd.put("ClientAddressLine1","");

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientAddressLine1 value is incorrect. The length should be between 1 and 30");
	}


}