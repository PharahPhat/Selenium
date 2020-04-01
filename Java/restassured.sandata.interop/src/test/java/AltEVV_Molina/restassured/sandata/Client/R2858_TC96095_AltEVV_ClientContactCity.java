package AltEVV_Molina.restassured.sandata.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
 
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 91261: OpenEVV-altEVV- Client- ClientContactCity field formats/values

import com.globalMethods.core.Assertion_DbVerifier; public class R2858_TC96095_AltEVV_ClientContactCity extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the valid ClientContactCity
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void R2858_TC96095_AltEVV_ClientContactCity_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96095_AltEVV_ClientContactCity_valid");

		JSONArray jsonArr = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonOb = (JSONObject) jsonArr.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactCity", CommonMethods.generateRandomStringOfFixLength(5));

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//To validate the ClientContactCity invalid length
	@Test(groups = {"All"})
	public void R2858_TC96095_AltEVV_ClientContactCity_invalid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("R2858_TC96095_AltEVV_ClientContactCity_invalid_length");

		JSONArray jsonArr = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonOb = (JSONObject) jsonArr.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactCity", CommonMethods.generateRandomStringOfFixLength(31));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,  globalVariables.ClientContactCityLengthError_alt);

	}

	//To validate the ClientContactCity with whitespace
	@Test(groups = {"All"})
	public void R2858_TC96095_AltEVV_ClientContactCity_whitespace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96095_AltEVV_ClientContactCity_invalid_length");

		JSONArray jsonArr = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject jsonOb = (JSONObject) jsonArr.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactCity", CommonMethods.generateRandomStringOfFixLength(8) + " " + CommonMethods.generateRandomStringOfFixLength(6));

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//To validate the ClientContactCity with leading space
	@Test(groups = {"All"})
	public void R2858_TC96095_AltEVV_ClientContactCity_leading_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96095_AltEVV_ClientContactCity_leading_space");

		JSONArray jsonArr = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		
		JSONObject jsonOb = (JSONObject) jsonArr.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactCity", " " + CommonMethods.generateRandomStringOfFixLength(8));

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//To validate the ClientContactCity with trailing space
	@Test(groups = {"All"})
	public void R2858_TC96095_AltEVV_ClientContactCity_trailing_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96095_AltEVV_ClientContactCity_trailing_space");

		JSONArray jsonArr = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonOb = (JSONObject) jsonArr.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactCity", CommonMethods.generateRandomStringOfFixLength(8) + " ");

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//To validate the ClientContactCity with special char
	@Test(groups = {"All"})
	public void R2858_TC96095_AltEVV_ClientContactCity_spcl_char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("R2858_TC96095_AltEVV_ClientContactCity_trailing_space");

		JSONArray jsonArr = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonOb = (JSONObject) jsonArr.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactCity", CommonMethods.generateSpecialChar(10));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,  globalVariables.ClientContactCityFormatError_alt);
	}

}