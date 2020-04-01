package AltEVV_Molina.restassured.sandata.Client;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;

public class R2201_TC96722_AltEVV_ClientContactType extends BaseTest {
    GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
    Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	// Validating valid altEVV ClientContact type with Family as value
	@Test(groups = {"SEVV-17391"})
	public void R2201_TC96722_AltEVV_ClientContactType_valid_Family_chars() throws  IOException, ParseException
	{
		// logger = extent.startTest("R2201_TC96722_AltEVV_ClientContactType_valid_Family_chars");
		logger.log(LogStatus.INFO, "Validating valid altEVV ClientContact type with Family as value"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactType, DataGeneratorClient.clientContactType("Family"));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

	}

    @Test(groups = {"All"})
    public void R2201_TC96722_AltEVV_ClientContactType_valid_Other_chars() throws  IOException, ParseException
    {
        // logger = extent.startTest("R2201_TC96722_AltEVV_ClientContactType_valid_Other_chars");
        logger.log(LogStatus.INFO, "Validating valid altEVV ClientContact type with Family as value");

        JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
        JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

        jsonObject1.put(globalVariables.ClientContactType, DataGeneratorClient.clientContactType("Other"));

        CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
    }

    // Validating invalid altEVV ClientContact type other than specified value :Family|Other"
    @Test(groups = {"All"})
	public void R2201_TC96722_AltEVV_ClientContactType_invalid_maxlength_chars() throws IOException, ParseException
	{
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put(globalVariables.ClientContactType, CommonMethods.generateRandomStringOfFixLength(13));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactTypeFormatError);
	}

    @Test(groups = {"All"})
    public void R2201_TC96722_AltEVV_ClientContactType_invalid_special_chars() throws  IOException, ParseException
    {
        // logger = extent.startTest("R2201_TC96722_AltEVV_ClientContactType_valid_Other_chars");
        logger.log(LogStatus.INFO, "Validating valid altEVV ClientContact type with Family as value");

        JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
        JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

        jsonObject1.put(globalVariables.ClientContactType,CommonMethods.generateRandomAlphaNumeric(12) );

        String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

        CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactTypeFormatError);
    }

}