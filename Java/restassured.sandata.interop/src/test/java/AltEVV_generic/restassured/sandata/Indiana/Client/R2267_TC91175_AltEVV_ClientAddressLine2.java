package AltEVV_generic.restassured.sandata.Indiana.Client;

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

import static com.globalMethods.core.globalVariables.ClientAddressLine2;

//TC91120: OpenEVV-altEVV- Client Address -ClientAddressLine2 validation field formats/values

public class R2267_TC91175_AltEVV_ClientAddressLine2 extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();

	@Test(groups = {"All", "fixing"})
	public void R2267_TC91175_AltEVV_ClientAddressLine2_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91175_AltEVV_ClientAddressLine2_valid");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.put(ClientAddressLine2,CommonMethods.generateRandomStringOfFixLength(30));

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.put(ClientAddressLine2,CommonMethods.generateRandomStringOfFixLength(30));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		assertionDbVerifier.verifyInboxClientAddress_ALtEVVGeneric(jsonObject, jsonObjectAdd1);
	}

	@Test(groups = {"All", "fixing"})
	public void R2267_TC91175_AltEVV_ClientAddressLine2_invalid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91175_AltEVV_ClientAddressLine2_invalid_length");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(1);

		jsonObjectAdd.put(ClientAddressLine2,CommonMethods.getSaltString(31));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		assertionDbVerifier.verifyInboxClientAddress_ALtEVVGeneric(jsonObject, jsonObjectAdd);
	}

	@Test(groups = {"All", "fixing"})
	public void R2267_TC91175_AltEVV_ClientAddressLine2_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91175_AltEVV_ClientAddressLine2_null");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.remove(ClientAddressLine2);
		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.remove(ClientAddressLine2);
		

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	@Test(groups = {"All"})
	public void R2267_TC91175_AltEVV_ClientAddressLine2_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91175_AltEVV_ClientAddressLine2_alphanumeric");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.put(ClientAddressLine2,CommonMethods.generateRandomAlphaNumeric(10));

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.put(ClientAddressLine2,CommonMethods.generateRandomAlphaNumeric(10));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));


	}

	@Test(groups = {"All"})
	public void R2267_TC91175_AltEVV_ClientAddressLine2_spcl_char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2267_TC91175_AltEVV_ClientAddressLine2_nonumeric");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.put(ClientAddressLine2,CommonMethods.generateSpecialChar(10));

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.put(ClientAddressLine2,CommonMethods.generateSpecialChar(10));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine2RegularExpressionError);

	}

	@Test(groups = {"All"})
	public void R2267_TC91175_AltEVV_ClientAddressLine2_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2267_TC91175_AltEVV_ClientAddressLine2_blank");
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd.put(ClientAddressLine2,"");

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd1.put(ClientAddressLine2,"");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}


}