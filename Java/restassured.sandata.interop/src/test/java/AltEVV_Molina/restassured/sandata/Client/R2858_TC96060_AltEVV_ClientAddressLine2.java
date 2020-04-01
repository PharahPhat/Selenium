package AltEVV_Molina.restassured.sandata.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

//TC91120: OpenEVV-altEVV- Client Address -ClientAddressLine2 validation field formats/values

public class R2858_TC96060_AltEVV_ClientAddressLine2 extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void R2858_TC96060_AltEVV_ClientAddressLine2_valid() throws InterruptedException, IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException {
		// logger = extent.startTest("R2858_TC96060_AltEVV_ClientAddressLine2_valid");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.put("ClientAddressLine2",CommonMethods.generateRandomStringOfFixLength(30));

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.put("ClientAddressLine2",CommonMethods.generateRandomStringOfFixLength(30));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	@Test(groups = {"All"})
	public void R2858_TC96060_AltEVV_ClientAddressLine2_invalid_length() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96060_AltEVV_ClientAddressLine2_invalid_length");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);

		jsonObjectAdd.put("ClientAddressLine2",CommonMethods.getSaltString(35));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine2_MaxLength_Error);

	}

	@Test(groups = {"All"})
	public void R2858_TC96060_AltEVV_ClientAddressLine2_whitespace1() throws InterruptedException, IOException,
			ParseException, SQLException, ClassNotFoundException, java.text.ParseException {
		// logger = extent.startTest("R2858_TC96060_AltEVV_ClientAddressLine2_invalid_length");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put("ClientAddressLine2", CommonMethods.getSaltString(5) + " " +  CommonMethods.generateRandomNumberOfFixLength(2));


		JSONObject jsonObjectAdd1 = (JSONObject) jsonArray1.get(1);
		jsonObjectAdd1.put("ClientAddressLine2",CommonMethods.getSaltString(5) + " " +  CommonMethods.generateRandomNumberOfFixLength(2));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	@Test(groups = {"All"})
	public void R2858_TC96060_AltEVV_ClientAddressLine2_null() throws InterruptedException, IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException {
		// logger = extent.startTest("R2858_TC96060_AltEVV_ClientAddressLine2_null");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.put("ClientAddressLine2",null);

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.put("ClientAddressLine2",null);

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	@Test(groups = {"All"})
	public void R2858_TC96060_AltEVV_ClientAddressLine2_alphanumeric() throws InterruptedException, IOException,
			ParseException, SQLException, ClassNotFoundException, java.text.ParseException {
		// logger = extent.startTest("R2858_TC96060_AltEVV_ClientAddressLine2_alphanumeric");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.put("ClientAddressLine2",CommonMethods.generateRandomAlphaNumeric(10));

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.put("ClientAddressLine2",CommonMethods.generateRandomAlphaNumeric(10));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

	}

	@Test(groups = {"All"})
	public void R2858_TC96060_AltEVV_ClientAddressLine2_spcl_char() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96060_AltEVV_ClientAddressLine2_nonumeric");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.put("ClientAddressLine2",CommonMethods.generateSpecialChar(10));

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.put("ClientAddressLine2",CommonMethods.generateSpecialChar(10));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine2FormatError);
	}

	@Test(groups = {"All"})
	public void R2858_TC96060_AltEVV_ClientAddressLine2_whitespace() throws InterruptedException, IOException,
			ParseException, SQLException, ClassNotFoundException, java.text.ParseException {
		// logger = extent.startTest("R2858_TC96060_AltEVV_ClientAddressLine2_whitespace");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.put("ClientAddressLine2",CommonMethods.generateRandomStringOfFixLength(10) + " "
				+CommonMethods.generateRandomStringOfFixLength(5) );

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.put("ClientAddressLine2",CommonMethods.generateRandomStringOfFixLength(10) + " "
				+CommonMethods.generateRandomStringOfFixLength(5) );

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

	}

	@Test(groups = {"All"})
	public void R2858_TC96060_AltEVV_ClientAddressLine2_blank() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96060_AltEVV_ClientAddressLine2_blank");
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.put("ClientAddressLine2","");

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.put("ClientAddressLine2","");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine2_MaxLength_Error);
	}
}