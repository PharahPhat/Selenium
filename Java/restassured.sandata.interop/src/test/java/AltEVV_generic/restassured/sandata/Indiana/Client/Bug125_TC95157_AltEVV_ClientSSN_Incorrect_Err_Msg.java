package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

//TC95157: OpenEVV-AltEVV: Correct error should be shown in response IF value of ClientSSN is passed wrong in Json

public class Bug125_TC95157_AltEVV_ClientSSN_Incorrect_Err_Msg extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	//Case1: ClientSSN passed with less then 9chars(Valid case as per latest req doc ALTEVV_5.8)
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "AltEVVclient")
	public void TC95157_AltEVV_ClientSSN_with_9char_length() throws InterruptedException, IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC95157_AltEVV_ClientSSN_with_6char_length");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}
	
	//Case2: ClientSSN passed with max 9chars(Valid case as per latest req doc ALTEVV_5.8)
	@Test(groups = {"All"})
	@AdditionalInfo(module = "AltEVVclient")
	public void TC95157_AltEVV_ClientSSN_with_maxlength() throws InterruptedException, IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException {
		// logger = extent.startTest("TC95157_AltEVV_ClientSSN_with_maxlength");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	}
	
	//Case3: ClientSSN passed wrong in Json(Valid case as per latest req doc ALTEVV_5.8)
	@Test(groups = {"All","Regression"})
	@AdditionalInfo(module = "AltEVVclient")
	public void TC95157_AltEVV_ClientSSN_with_invalidvalue() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC95157_AltEVV_ClientSSN_with_invalidvalue");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientSSN", CommonMethods.generateRandomAlphaNumeric(9));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientSSNFormatError);
	}
}