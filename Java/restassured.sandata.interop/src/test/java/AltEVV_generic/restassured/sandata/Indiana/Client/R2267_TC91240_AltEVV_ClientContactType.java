package AltEVV_generic.restassured.sandata.Indiana.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
 
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//TC91118: OpenEVV-altEVV- Client: Validate If the ClientSSN field is left empty

import com.globalMethods.core.Assertion_DbVerifier; public class R2267_TC91240_AltEVV_ClientContactType extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	// Validating valid altEVV ClientContact type with Family as value
	@Test(groups = {"All"})
	public void R2267_TC91240_AltEVV_ClientContactType_valid_Family_chars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91240_AltEVV_ClientContactType_valid_Family_chars");
		logger.log(LogStatus.INFO, "Validating valid altEVV ClientContact type with Family as value"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArr1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put(globalVariables.ClientContactType, DataGeneratorClient.clientContactType_altevv());

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	// Validating invalid altEVV ClientContact type other than specified value :Family|Friend|Other|Parent|Sibling|Spouse"
	@Test(groups = {"All"})
	public void R2267_TC91240_AltEVV_ClientContactType_invalid_other_than_spcified_value() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2267_TC91240_AltEVV_ClientContactType_invalid_other_than_spcified_value");
		logger.log(LogStatus.INFO, "Validating invalid altEVV ClientContact type other than specified value :Family|Friend|Other|Parent|Sibling|Spouse\""); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArr1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonOb1 = (JSONObject) jsonArr1.get(0);

		jsonOb1.put(globalVariables.ClientContactType, CommonMethods.generateRandomStringOfFixLength(9));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientContactType (Responsible Party) format is not correct.");
	}


}