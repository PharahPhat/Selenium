package AltEVV_Molina.restassured.sandata.Client;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//Test Case 92219: Open EVV-altEVV-Client - Required Fields Blank

import com.globalMethods.core.Assertion_DbVerifier; public class R2858_TC96220_AltEVV_Client_Req_Fields_Blank extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Validating AltEVV Client Creation with Req fields blank
	@Test(groups = {"All"})
	public void R2858_TC96220_AltEVV_Client_Req_Fields_Blank_Validation() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC96220_AltEVV_Client_Req_Fields_Blank_Validation");
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ProviderID", "");
		jsonObject.put("SequenceID", "");
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("PayerID", "");
		jsonObject1.put("PayerProgram", "");
		jsonObject1.put("ProcedureCode", "");
		
		JSONArray jsonArrAdd = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObject2 = (JSONObject) jsonArrAdd.get(0);
		jsonObject2.put("ClientZip", "");

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The PayerID value is incorrect.");
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The PayerProgram cannot be null or empty.");
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientZip format is incorrect.");
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The PayerProgram value is incorrect.");
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientZip value is incorrect.");
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ProcedureCode value is incorrect.");
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The SequenceID value is incorrect.");
	}
}

