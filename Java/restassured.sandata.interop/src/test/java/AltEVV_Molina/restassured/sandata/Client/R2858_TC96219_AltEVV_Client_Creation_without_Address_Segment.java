package AltEVV_Molina.restassured.sandata.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorClient;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

//Test Case 92339: Open EVV - Alt EVV - Validate client creation without Address Segment
/**
 * @author Anupam
 */

public class R2858_TC96219_AltEVV_Client_Creation_without_Address_Segment extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//Case-1 Testing Client json without Address Segment
	@Test(groups = {"All"})
	public void R2858_TC96219_Alt_EVV_Client_Creation_without_Address_Segment() throws InterruptedException, IOException, ParseException
	{   
		// logger = extent.startTest("R2858_TC96219_Alt_EVV_Client_Creation_without_Address_Segment");
		logger.log(LogStatus.INFO, "Validating Client_Creation_without_Address_Segment"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonarray_sub= (JSONArray) jsonObject.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(0);
		js_s.remove("ClientState");
		js_s.remove("ClientCounty");
		js_s.remove("ClientAddressLatitude");
		js_s.remove("ClientAddressLongitude");
		js_s.remove("ClientZip");
		js_s.remove("ClientAddressLine2");
		js_s.remove("ClientAddressLine1");
		js_s.remove("ClientAddressType");
		js_s.remove("ClientCity");
		js_s.remove("ClientAddressIsPrimary");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateNullError);
	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipNullError);
	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCity_nullerror);
	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1NullError);
	}
	
	@Test(groups = {"All"})
	public void R2858_TC96219_Alt_EVV_Client_Creation_without_Address_Segment_add() throws InterruptedException, IOException, ParseException
	{   
		// logger = extent.startTest("R2858_TC96219_Alt_EVV_Client_Creation_without_Address_Segment");
		logger.log(LogStatus.INFO, "Validating Client_Creation_without_Address_Segment"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonarray_sub= (JSONArray) jsonObject.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(1);
		js_s.remove("ClientState");
		js_s.remove("ClientCounty");
		js_s.remove("ClientAddressLatitude");
		js_s.remove("ClientAddressLongitude");
		js_s.remove("ClientZip");
		js_s.remove("ClientAddressLine2");
		js_s.remove("ClientAddressLine1");
		js_s.remove("ClientAddressType");
		js_s.remove("ClientCity");
		js_s.remove("ClientAddressIsPrimary");
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCity_nullerror);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1NullError);
	}

	//Case-2 Testing Client json with Address Segment (valid)
	@Test(groups = {"All"})
	public void R2858_TC96219_Alt_EVV_Client_Creation_with_Address_Segment() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// logger = extent.startTest("R2858_TC96219_Alt_EVV_Client_Creation_with_Address_Segment");
		logger.log(LogStatus.INFO, "Validating Client_Creation_with_Address_Segment"); 


		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonarray_sub = (JSONArray) jsonObject.get(globalVariables.ClientAddress);	
		JSONObject jsonObject3 = (JSONObject) jsonarray_sub.get(1);

		jsonObject3.put(globalVariables.ClientAddressType, DataGeneratorClient.clientAddressType());
		jsonObject3.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(15));
		jsonObject3.put(globalVariables.ClientState, DataGeneratorClient.generateClientState());

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

}
