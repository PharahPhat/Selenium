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

//Test Case 91261: OpenEVV-altEVV- Client- ClientContactCity field formats/values

public class R2267_TC91261_AltEVV_ClientContactCity extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();

	//To validate the valid ClientContactCity
	@Test(groups = {"All", "fixing"})
	public void TC91261_AltEVV_ClientContactCity_valid() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC91261_AltEVV_ClientContactCity_valid");

		JSONArray jsonArr = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonOb = (JSONObject) jsonArr.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactCity", CommonMethods.generateRandomStringOfFixLength(5));

		CommonMethods.validateResponse(jsonArr,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		assertionDbVerifier.verifyInboxClientContactAltEVVGeneric(jsonOb, jsonOb1);
	}

	//To validate the ClientContactCity invalid length
	@Test(groups = {"All", "fixing"})
	public void TC91261_AltEVV_ClientContactCity_invalid_length() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC91261_AltEVV_ClientContactCity_invalid_length");

		JSONArray jsonArr = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonOb = (JSONObject) jsonArr.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactCity", CommonMethods.generateRandomStringOfFixLength(31));

		CommonMethods.validateResponse(jsonArr,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		assertionDbVerifier.verifyInboxClientContactAltEVVGeneric(jsonOb, jsonOb1);
	}

	//To validate the ClientContactCity with special char
	@Test(groups = {"All"})
	public void TC91261_AltEVV_ClientContactCity_spcl_char() throws IOException, ParseException
	{
		// logger = extent.startTest("TC91261_AltEVV_ClientContactCity_trailing_space");

		JSONArray jsonArr = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonOb = (JSONObject) jsonArr.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactCity", CommonMethods.generateSpecialChar(10));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArr,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,  globalVariables.ClientContactCityFormatError_alt);
	}

}