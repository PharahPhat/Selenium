package AltEVV_Molina.restassured.sandata.Client;

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

import com.globalMethods.core.Assertion_DbVerifier; 

public class R2858_TC96068_AltEVV_ClientContactType extends BaseTest { 
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	// Validating valid altEVV ClientContact type with Family as value
	@Test(groups = {"All"})
	public void R2858_TC96068_AltEVV_ClientContactType_valid_Family_chars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96068_AltEVV_ClientContactType_valid_Family_chars");
		logger.log(LogStatus.INFO, "Validating valid altEVV ClientContact type with Family as value"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactType, DataGeneratorClient.clientContactType_altevv_molina());

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

	}

	// Validating invalid altEVV ClientContact type other than specified value :Family|Friend|Other|Parent|Sibling|Spouse"
	@Test(groups = {"All"})
	public void R2858_TC96068_AltEVV_ClientContactType_invalid_other_than_spcified_value() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2858_TC96068_AltEVV_ClientContactType_invalid_other_than_spcified_value");
		logger.log(LogStatus.INFO, "Validating invalid altEVV ClientContact type other than specified value :Family|Friend|Other|Parent|Sibling|Spouse\""); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactType, CommonMethods.generateRandomStringOfFixLength(9));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

}