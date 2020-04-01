package AltEVV_Molina.restassured.sandata.Client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class R2858_TC96057_AltEVV_ClientAddressIsPrimary_Validate extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void R2858_TC96057_AltEVV_ClientAddressIsPrimary_true_true() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException{
		// logger = extent.startTest("R2858_TC96057_AltEVV_ClientAddressIsPrimary_true_Flase_");

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", true);

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", true);

		CommonMethods.validateResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	@Test(groups = {"All"})
	public void R2858_TC96057_AltEVV_ClientAddressIsPrimary_true_Flase() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException{
		// logger = extent.startTest("R2858_TC96057_AltEVV_ClientAddressIsPrimary_true_Flase_");

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", true);

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", false);

		CommonMethods.validateResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	@Test(groups = {"All"})
	public void R2858_TC96057_AltEVV_ClientAddressIsPrimary_False_true() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException {
		// logger = extent.startTest("R2858_TC96057_AltEVV_ClientAddressIsPrimary_true_Flase_");

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", false);

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", true);

		CommonMethods.validateResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	@Test(groups = {"All"})
	public void R2858_TC96057_AltEVV_ClientAddressIsPrimary_false_Flase() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException{
		// logger = extent.startTest("R2858_TC96057_AltEVV_ClientAddressIsPrimary_true_Flase_");

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", false);

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", false);

		CommonMethods.validateResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}
	
	@Test(groups = {"All"})
	public void R2858_TC96057_AltEVV_ClientAddressIsPrimary_length_otherthan_true_False() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{

		// logger = extent.startTest("R2858_TC96057_AltEVV_ClientAddressIsPrimary_length_otherthan_true_False");

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", CommonMethods.generateRandomStringOfFixLength(5));

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", CommonMethods.generateRandomStringOfFixLength(5));

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressIsPrimaryError);
	}

	@Test(groups = {"All"})
	public void R2858_TC96057_AltEVV_ClientAddressIsPrimary_lengthInvalid() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException{
		// logger = extent.startTest("R2858_TC96057_AltEVV_ClientAddressIsPrimary_lengthInvalid");

		//Using Reusable method to load employee json
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", CommonMethods.generateRandomStringOfFixLength(6));

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", CommonMethods.generateRandomStringOfFixLength(6));

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientAddressIsPrimary format is incorrect.");

	}

	@Test(groups = {"All"})
	public void R2858_TC96057_AltEVV_ClientAddressIsPrimary_InvalidType_num() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException{
		// logger = extent.startTest("R2858_TC96057_AltEVV_ClientAddressIsPrimary_lengthInvalid");

		//Using Reusable method to load employee json
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", CommonMethods.generateRandomNumberOfFixLength(5));

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The ClientAddressIsPrimary format is incorrect."));

	}

	@Test(groups = {"All"})
	public void R2858_TC96057_AltEVV_ClientAddressIsPrimary_blank() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException{
		// logger = extent.startTest("R2858_TC96057_AltEVV_ClientAddressIsPrimary_blank");

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", "");

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", "");

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The ClientAddressIsPrimary format is incorrect."));

	}

	@Test(groups = {"All"})
	public void R2858_TC96057_AltEVV_ClientAddressIsPrimary_null() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
		// logger = extent.startTest("R2858_TC96057_AltEVV_ClientAddressIsPrimary_true_Flase_");

		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", null);

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", null);

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientAddressIsPrimary cannot be null.");
	}

	@Test(groups = {"All"})
	public void R2858_TC96057_AltEVV_ClientAddressIsPrimary_with_specialCharacter() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("R2858_TC96057_AltEVV_ClientAddressIsPrimary_with_specialCharacter");
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);

		JSONArray altEVVJsonArray_add = (JSONArray) jsonobject.get("ClientAddress");

		JSONObject jsonobject_add = (JSONObject) altEVVJsonArray_add.get(0);
		jsonobject_add.put("ClientAddressIsPrimary", CommonMethods.generateSpecialChar(3));

		JSONObject jsonobject_add1 = (JSONObject) altEVVJsonArray_add.get(1);
		jsonobject_add1.put("ClientAddressIsPrimary", CommonMethods.generateSpecialChar(3));

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientAddressIsPrimary format is incorrect.");
	}


}

