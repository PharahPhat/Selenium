package AltEVV_Molina.restassured.sandata.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author MayankM
 */
//Open EVV-Client-Validate - Client Address - Verify Positive response is received with Positive values in ClientAddress segment

public class Bug181_TC95153_AltEVV_ClientAddress_included extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	@Test(groups = {"All"})
	public void Bug181_TC95153_AltEVV_ClientAddress_included_valid() throws InterruptedException, IOException,
			ParseException, SQLException, ClassNotFoundException, java.text.ParseException {
		// logger = extent.startTest("Bug181_TC95153_AltEVV_ClientAddress_included_valid");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArrayAdd = 	(JSONArray) jsonObject.get(globalVariables.addressArrayjson);
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayAdd.get(0);

		jsonObjectAdd.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomStringOfFixLength(10));
		jsonObjectAdd.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(5));

		JSONObject jsonObjectAdd1 = (JSONObject) jsonArrayAdd.get(1);

		jsonObjectAdd1.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomStringOfFixLength(10));
		jsonObjectAdd1.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(5));
		
		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		
	}

	@Test(groups = {"All"})
	public void altEVV_Client_Validations_Address_Segment_without_ClientState() throws InterruptedException, IOException,
			ParseException
	{
		// adding method name info via logger
		// logger = extent.startTest("altEVV_Client_Validations_Address_Segment_without_clientstate");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "altEVV_Client_Validations_Address_Segment_without_clientstate");

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(0);
		js_s.remove("ClientState");

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		//Validating the expected Result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateNullError);
	}

	@Test(groups = {"All"})
	public void altEVV_Client_Validations_Address_Segment_without_clientZIP() throws InterruptedException, IOException,
			ParseException
	{
		// adding method name info via logger
		// logger = extent.startTest("altEVV_Client_Validations_Address_Segment_without_clientZIP");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "altEVV_Client_Validations_Address_Segment_without_clientZIP");

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(0);
		js_s.remove("ClientZip");


		logger.log(LogStatus.INFO, "Passing all parameters without ClientState");
		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipNullError);
	}

	@Test(groups = {"All"})
	public void altEVV_Client_Validations_Address_Segment_without_ClientCity() throws InterruptedException, IOException,
			ParseException
	{
		// adding method name info via logger
		// logger = extent.startTest("altEVV_Client_Validations_Address_Segment_without_cliencity");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "altEVV_Client_Validations_Address_Segment_without_cliencity");

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(0);
		js_s.remove("ClientCity");

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCity_nullerror);
	}

	@Test(groups = {"All"})
	public void altEVV_Client_Validations_Address_Segment_without_ClientAddress1() throws InterruptedException,
			IOException, ParseException
	{
		// adding method name info via logger
		// logger = extent.startTest("altEVV_Client_Validations_Address_Segment_without_clienaddress1");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "altEVV_Client_Validations_Address_Segment_without_clienaddress1");

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(0);
		js_s.remove("ClientAddressLine1");

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1NullError);
	}

	@Test(groups = {"All"})
	public void altEVV_Client_Validations_Address_Segment_without_ClientCounty() throws InterruptedException,
			IOException, ParseException
	{
		// adding method name info via logger
		// logger = extent.startTest("altEVV_Client_Validations_Address_Segment_without_clientcounty");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "altEVV_Client_Validations_Address_Segment_without_clientcounty");

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(0);
		js_s.remove("ClientCounty");

		JSONObject js_s1 = (JSONObject) jsonarray_sub.get(1);
		js_s1.remove("ClientCounty");

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

	}

	@Test(groups = {"All"})
	public void altEVV_Client_Validations_Address_Segment_without_ClientState_add() throws InterruptedException,
			IOException, ParseException
	{
		// adding method name info via logger
		// logger = extent.startTest("altEVV_Client_Validations_Address_Segment_without_clientstate_add");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "altEVV_Client_Validations_Address_Segment_without_clientstate_add");

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(1);
		js_s.remove("ClientState");

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		//Validating the expected Result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientStateNullError);
	}

	@Test(groups = {"All"})
	public void altEVV_Client_Validations_Address_Segment_without_clientZIP_add() throws InterruptedException,
			IOException, ParseException
	{
		// adding method name info via logger
		// logger = extent.startTest("altEVV_Client_Validations_Address_Segment_without_clientZIP_add");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "altEVV_Client_Validations_Address_Segment_without_clientZIP_add");

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(1);
		js_s.remove("ClientZip");


		logger.log(LogStatus.INFO, "Passing all parameters without ClientState");
		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipNullError);
	}

	@Test(groups = {"All"})
	public void altEVV_Client_Validations_Address_Segment_without_ClientCity_add() throws InterruptedException,
			IOException, ParseException
	{
		// adding method name info via logger
		// logger = extent.startTest("altEVV_Client_Validations_Address_Segment_without_cliencity_add");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "altEVV_Client_Validations_Address_Segment_without_cliencity_add");

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(1);
		js_s.remove("ClientCity");

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCity_nullerror);
	}

	@Test(groups = {"All"})
	public void altEVV_Client_Validations_Address_Segment_without_ClienAddress1_add() throws InterruptedException,
			IOException, ParseException
	{
		// adding method name info via logger
		// logger = extent.startTest("altEVV_Client_Validations_Address_Segment_without_clienaddress1_add");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without ClientState");

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		JSONArray jsonarray_sub= (JSONArray) js.get("ClientAddress");
		JSONObject js_s = (JSONObject) jsonarray_sub.get(1);
		js_s.remove("ClientAddressLine1");

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1NullError);
	}

}