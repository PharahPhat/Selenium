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

//TC91120: OpenEVV-altEVV- Client Address -ClientAddressLine1 validation field formats/values
public class R2267_TC91120_AltEVV_ClientAddLine1 extends BaseTest { 
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All", "fixing"})
	public void R2267_TC91120_AltEVV_ClientAddressLine1_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_valid");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		
		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd1.put("ClientAddressLine1",CommonMethods.generateRandomStringOfFixLength(30));

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd.put("ClientAddressLine1",CommonMethods.generateRandomStringOfFixLength(30));


		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		assertionDbVerifier.verifyInboxClientAddress_ALtEVVGeneric(jsonObject, jsonObjectAdd);
}

	@Test(groups = {"All", "fixing"})
	public void R2267_TC91120_AltEVV_ClientAddressLine1_invalid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_invalid_length");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(1);

		jsonObjectAdd.put("ClientAddressLine1",CommonMethods.getSaltString(31));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		assertionDbVerifier.verifyInboxClientAddress_ALtEVVGeneric(jsonObject, jsonObjectAdd);
	}

	@Test(groups = {"All"})
	public void R2267_TC91120_AltEVV_ClientAddressLine1_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_null");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);

		jsonObjectAdd.put("ClientAddressLine1",null);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1NullError);

	}

	@Test(groups = {"All"})
	public void R2267_TC91120_AltEVV_ClientAddressLine1_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_alphanumeric");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		
		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrAdd.get(0);
		jsonObjectAdd1.put("ClientAddressLine1",CommonMethods.generateRandomAlphaNumeric(10));

		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(1);
		jsonObjectAdd.put("ClientAddressLine1",CommonMethods.generateRandomAlphaNumeric(10));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	@Test(groups = {"All"})
	public void R2267_TC91120_AltEVV_ClientAddressLine1_spcl_char() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_nonumeric");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);

		jsonObjectAdd.put("ClientAddressLine1",CommonMethods.generateSpecialChar(10));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1FormatError);

	}

	@Test(groups = {"All"})
	public void R2267_TC91120_AltEVV_ClientAddressLine1_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2267_TC91118_AltEVV_ClientAddressLine1_blank");
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectAdd = (JSONObject) jsonArrAdd.get(0);

		jsonObjectAdd.put("ClientAddressLine1","");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1FormatError1);
	}


}