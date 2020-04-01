package AltEVV_generic.restassured.sandata.Indiana.Client;

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

//Test Case 92219: Open EVV-altEVV-Client - Required Fields missing

import com.globalMethods.core.Assertion_DbVerifier; public class R2267_TC92220_AltEVV_Client_Req_Fields_Missing extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Validating AltEVV Client Creation with Req fields missing
	@Test(groups = {"All"})
	public void R2267_TC92220_AltEVV_Client_Req_Fields_missing_Validation() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC92219_AltEVV_Client_Req_Fields_mising_Validation");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_requiredMissing(globalVariables.client_intake);

	
		CommonMethods.capturePostResponse_500(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));


//		
	}


}