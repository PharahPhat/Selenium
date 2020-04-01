package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorClient;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

//Test Case 91261: OpenEVV-altEVV- Client- ClientContactState field formats/values

public class R2267_TC91262_AltEVV_ClientContactState extends BaseTest { 
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the valid ClientContactState
	@Test(groups = {"All"})
	public void TC91262_AltEVV_ClientContactState_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC91262_AltEVV_ClientContactState_valid");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject jsonOb = (JSONObject) jsonArray.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactState", DataGeneratorClient.generateClientState());

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	//To validate the ClientContactState invalid length
	@Test(groups = {"All"})
	public void TC91262_AltEVV_ClientContactState_invalid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC91262_AltEVV_ClientContactState_invalid_length");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject jsonOb = (JSONObject) jsonArray.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactState", CommonMethods.getSaltString(3));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateFormatError_alt);

	}

	//To validate the ClientContactState with whitespace
	@Test(groups = {"All"})
	public void TC91262_AltEVV_ClientContactState_whitespace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC91262_AltEVV_ClientContactState_whitespace");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject jsonOb = (JSONObject) jsonArray.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactState",CommonMethods.getSaltString(1)+ " " + CommonMethods.getSaltString(1));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateFormatError_alt);


	}

	//To validate the ClientContactState with special char
	@Test(groups = {"All"})
	public void TC91262_AltEVV_ClientContactState_spcl_char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC91262_AltEVV_ClientContactState_trailing_space");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject jsonOb = (JSONObject) jsonArray.get(0);

		JSONArray jsonArr1 = (JSONArray) jsonOb.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put("ClientContactState", CommonMethods.generateSpecialChar(2));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,  globalVariables.ClientStateFormatError_alt);
	}

}