package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.SequenceLengthFormatError;

public class R2267_TC91095_AltEVV_Client_SequenceID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All","Regression"})
	@AdditionalInfo(module = "AltEVVclient")
	public void TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC7340_Open_EVV_altEVV_Visit_changes_validate_sequenceID_Blank");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence Blank"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", "");

		CommonMethods.capturePostResponse_400(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	
	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "AltEVVclient")
	public void TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC7340_Open_EVV_altEVV_Visit_changes_validate_sequenceID_null");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence id as null"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", null);

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains( "ERROR: The SequenceID cannot be null."));


	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "AltEVVclient")
	public void TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_NULL() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC7340_Open_EVV_altEVV_Visit_changes_validate_sequenceID_NULL");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence ID NULL"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", "NULL");

		CommonMethods.capturePostResponse_400(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	}

	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "AltEVVclient")
	public void TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_morethan_50Characters() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC7340_Open_EVV_altEVV_Visit_changes_validate_sequenceID_morethan_50Characters");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence ID more than 50 characters"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(17));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, SequenceLengthFormatError);
	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "AltEVVclient")
	public void TC91095_Open_EVV_altEVV_Visit_changes_validate_sequenceID_invalid_format() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC7340_Open_EVV_altEVV_Visit_changes_validate_sequenceID_invalid_formate");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence ID as Invalid formate"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", "-1234567890");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//Validating the expected Result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The SequenceID value cannot be less than 0");
	}
}


