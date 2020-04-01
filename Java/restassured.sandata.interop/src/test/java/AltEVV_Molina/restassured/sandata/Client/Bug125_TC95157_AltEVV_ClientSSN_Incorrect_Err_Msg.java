package AltEVV_Molina.restassured.sandata.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

//TC95157: OpenEVV-AltEVV: Correct error should be shown in response IF value of ClientSSN is passed wrong in Json
public class Bug125_TC95157_AltEVV_ClientSSN_Incorrect_Err_Msg extends BaseTest { 
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	//Case1: ClientSSN passed with less then 9chars(Valid case as per latest req doc ALTEVV_5.8)
	
	@Test(groups = {"All"})
	public void TC95157_AltEVV_ClientSSN_with_9char_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC95157_AltEVV_ClientSSN_with_6char_length");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}
	
	//Case2: ClientSSN passed with max 9chars(Valid case as per latest req doc ALTEVV_5.8)
	@Test(groups = {"All"})
	public void TC95157_AltEVV_ClientSSN_with_maxlength() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC95157_AltEVV_ClientSSN_with_maxlength");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(9));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}
	
	//Case3: ClientSSN passed wrong in Json(Valid case as per latest req doc ALTEVV_5.8)
	@Test(groups = {"All"})
	public void TC95157_AltEVV_ClientSSN_with_invalidvalue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC95157_AltEVV_ClientSSN_with_invalidvalue");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientSSN", CommonMethods.generateRandomAlphaNumeric(9));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientSSNFormatError);
	}
}