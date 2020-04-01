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

import com.globalMethods.core.Assertion_DbVerifier; public class R2267_TC92228_AltEVV_AllAddresses_individual_changed extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	// Validating valid altEVV condition Send All Addresses when individual changed
	@Test(groups = {"All"})
	public void R2267_TC92228_AltEVV_multipleAddresses_in_addresssegment() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC92228_AltEVV_multipleAddresses_in_addresssegment");
		logger.log(LogStatus.INFO, "Validating AltEVV_multipleAddresses_in_addresssegment"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray_sub = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
	
		JSONObject jsonObject3 = (JSONObject) jsonArray_sub.get(0);
		jsonObject3.put(globalVariables.ClientAddressType, "Business");
		
		jsonObject3.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));



	}

	
}