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

//Test Case 91261: OpenEVV-altEVV- Client- ClientContactState field formats/values

import com.globalMethods.core.Assertion_DbVerifier; public class R2858_TC96096_AltEVV_ClientContactState extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the valid ClientContactState
	@Test(groups = {"All"})
	public void R2858_TC96096_AltEVV_ClientContactState_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96096_AltEVV_ClientContactState_valid");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject jsonOb = (JSONObject) jsonArray.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactState", DataGeneratorClient.generateClientState());

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//To validate the ClientContactState invalid length
	@Test(groups = {"All"})
	public void R2858_TC96096_AltEVV_ClientContactState_invalid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("R2858_TC96096_AltEVV_ClientContactState_invalid_length");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject jsonOb = (JSONObject) jsonArray.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactState", CommonMethods.getSaltString(3));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,  globalVariables.ClientStateLengthError_alt);

	}

	//To validate the ClientContactState with whitespace
	@Test(groups = {"All"})
	public void R2858_TC96096_AltEVV_ClientContactState_whitespace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("R2858_TC96096_AltEVV_ClientContactState_whitespace");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject jsonOb = (JSONObject) jsonArray.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactState",CommonMethods.getSaltString(1)+ " " + CommonMethods.getSaltString(1));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateFormatError_alt);


	}

	//To validate the ClientContactState with leading space
	@Test(groups = {"All"})
	public void R2858_TC96096_AltEVV_ClientContactState_leading_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("R2858_TC96096_AltEVV_ClientContactState_leading_space");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject jsonOb = (JSONObject) jsonArray.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactState", " " + DataGeneratorClient.generateClientState());

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateLengthError_alt);

	}

	//To validate the ClientContactState with trailing space
	@Test(groups = {"All"})
	public void R2858_TC96096_AltEVV_ClientContactState_trailing_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("R2858_TC96096_AltEVV_ClientContactState_trailing_space");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject jsonOb = (JSONObject) jsonArray.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactState", DataGeneratorClient.generateClientState() + " ");

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateLengthError_alt);


	}

	//To validate the ClientContactState with special char
	@Test(groups = {"All"})
	public void R2858_TC96096_AltEVV_ClientContactState_spcl_char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("R2858_TC96096_AltEVV_ClientContactState_trailing_space");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject jsonOb = (JSONObject) jsonArray.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactState", CommonMethods.generateSpecialChar(2));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,  globalVariables.ClientStateFormatError_alt);
	}

}