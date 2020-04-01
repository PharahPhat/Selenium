package AltEVV_Molina.restassured.sandata.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class R2858_TC93133_AltEVV_Client_SequenceID_Extended extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2858_TC93133_Open_EVV_altEVV_Visit_changes_validate_sequenceID_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93133_Open_EVV_altEVV_Visit_changes_validate_sequenceID_Blank");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence Blank"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", "");

		String bodyAsString= CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The SequenceID value is incorrect. The length should be between 1 and 16.");

	}

	@Test(groups = {"All"})
	public void R2858_TC93133_Open_EVV_altEVV_Visit_changes_validate_sequenceID_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93133_Open_EVV_altEVV_Visit_changes_validate_sequenceID_null");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence id as null"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", null);

		String bodyAsString= CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The SequenceID cannot be null.");


	}

	@Test(groups = {"All"})
	public void R2858_TC93133_Open_EVV_altEVV_Visit_changes_validate_sequenceID_NULL() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93133_Open_EVV_altEVV_Visit_changes_validate_sequenceID_NULL");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence ID NULL"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", "NULL");

		String bodyAsString= CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The SequenceID format is incorrect. The record should satisfy this regular expression");
	}

	@Test(groups = {"All"})
	public void R2858_TC93133_Open_EVV_altEVV_Visit_changes_validate_sequenceID_morethan_50Characters() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93133_Open_EVV_altEVV_Visit_changes_validate_sequenceID_morethan_50Characters");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence ID more than 50 characters"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(17));

		String bodyAsString= CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The SequenceID value is incorrect. The length should be between 1 and 16.");


	}

	@Test(groups = {"All"})
	public void R2858_TC93133_Open_EVV_altEVV_Visit_changes_validate_sequenceID_invalid_format() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC93133_Open_EVV_altEVV_Visit_changes_validate_sequenceID_invalid_formate");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without Sequence ID as Invalid formate"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", "-1234567890");

		String bodyAsString= CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The SequenceID format is incorrect. The record should satisfy this regular expression");

	}
}


