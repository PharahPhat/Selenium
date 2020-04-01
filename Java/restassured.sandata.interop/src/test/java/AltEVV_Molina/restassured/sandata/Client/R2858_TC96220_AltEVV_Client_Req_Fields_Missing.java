package AltEVV_Molina.restassured.sandata.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author MayankM
 */
//Test Case 92219: Open EVV-altEVV-Client - Required Fields missing

public class R2858_TC96220_AltEVV_Client_Req_Fields_Missing extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Validating AltEVV Client Creation with Req fields missing
	@Test(groups = {"All"})
	public void R2858_TC92220_AltEVV_Client_Req_Fields_missing_Validation() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC92219_AltEVV_Client_Req_Fields_mising_Validation");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_requiredMissing(globalVariables.client_intake);
	
		String bodyAsString =CommonMethods.capturePostResponse_500(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}


}