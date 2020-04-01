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
//Test Case 91076: OpenEVV-altEVV- Client:  Validate (mix) - ClientFirstName field formats/values

public class R2858_TC93150_AltEVV_ClientFirstName extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the valid  ClientloyeeFirstName by passing the String Value of 30chars
	@Test(groups = {"All"})
	public void R2858_TC93150_AltEVV_ClientFirstName_valid_String_30char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		String field = "f_name";
		// logger = extent.startTest("R2858_TC93150_AltEVV_ClientFirstName_valid_String_30char");
		logger.log(LogStatus.INFO, "validating ClientFirstname with valid length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) jsonArray.get(0);

		js.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(30));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//To validate the valid  ClientloyeeFirstName by passing the String Value as min value as 1 chars
	@Test(groups = {"All"})
	public void R2858_TC93150_AltEVV_ClientFirstName_valid_String_minvalue_1char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC93150_AltEVV_ClientFirstName_valid_String_minvalue_1char");

		logger.log(LogStatus.INFO, "To validate the valid  ClientFirstName by passing the String Value as min value as 1 chars"); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(1));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

	}

	//To validate the valid  ClientloyeeFirstName by passing the String Value as mid space
	@Test(groups = {"All"})
	public void R2858_TC93150_AltEVV_ClientFirstName_valid_String_with_midSpace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC93150_AltEVV_ClientFirstName_valid_String_with_midSpace");

		logger.log(LogStatus.INFO, "To validate the valid  ClientFirstName by passing the String Value as mid space"); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(5)+ " " + CommonMethods.generateRandomStringOfFixLength(5) + " " + CommonMethods.generateRandomStringOfFixLength(5));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//To validate the valid  ClientloyeeFirstName by passing the String Value as null 
	@Test(groups = {"All"})
	public void R2858_TC93150_AltEVV_ClientFirstName_valid_String_with_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC93150_AltEVV_ClientFirstName_valid_String_with_null");

		logger.log(LogStatus.INFO, "To validate the valid  ClientFirstName by passing the String Value as null quoted"); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", "null");

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

	}

	//To validate the valid  ClientloyeeFirstName by passing the String Value of more than 30chars
	@Test(groups = {"All"})
	public void R2858_TC93150_AltEVV_ClientFirstName_invalid_String_exceeding_30char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2858_TC93150_AltEVV_ClientFirstName_invalid_String_exceeding_30char");

		logger.log(LogStatus.INFO, "To validate R2858_TC93150_AltEVV_ClientFirstName_invalid_String_exceeding_30char"); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(31));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientFirstName value is incorrect. The length should be between 1 and 30.");
	
	}

	//To validate the invalid  ClientloyeeFirstName by passing the value as numeric
	@Test(groups = {"All"})
	public void R2858_TC93150_AltEVV_ClientFirstName_invalid_numeric1() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC93150_AltEVV_ClientFirstName_invalid_numeric1");

		logger.log(LogStatus.INFO, "To validate R2858_TC93150_AltEVV_ClientFirstName_invalid_numeric1"); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientFirstName", CommonMethods.generateRandomNumberOfFixLength(15));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientFirstName format is incorrect.");
	}

	//To validate the invalid  ClientloyeeFirstName by passing the value as alphanumeric
	@Test(groups = {"All"})
	public void R2858_TC93150_AltEVV_ClientFirstName_invalid_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC93150_AltEVV_ClientFirstName_invalid_alphanumeric");

		logger.log(LogStatus.INFO, "To validate the invalid  ClientFirstName by passing the value as alphanumeric"); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", CommonMethods.generateRandomAlphaNumeric(16));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientFirstName format is incorrect.");
	}

	//To validate the invalid  ClientloyeeFirstName by passing the value as special chars
	@Test(groups = {"All"})
	public void R2858_TC93150_AltEVV_ClientFirstName_invalid_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC93150_AltEVV_ClientFirstName_invalid_specialchars");

		logger.log(LogStatus.INFO, "To validate the invalid  ClientFirstName by passing the value as special chars"); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", CommonMethods.generateSpecialChar(16));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientFirstName format is incorrect.");
	}

	//To validate the invalid  ClientloyeeFirstName by passing the value as blank
	@Test(groups = {"All"})
	public void R2858_TC93150_AltEVV_ClientFirstName_invalid_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC93150_AltEVV_ClientFirstName_invalid_blank");

		logger.log(LogStatus.INFO, "//To validate the invalid  ClientFirstName by passing the value as blank"); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", "");

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientFirstName format is incorrect.");
	}

	//To validate the invalid  ClientloyeeFirstName by passing the value as leading space
	@Test(groups = {"All"})
	public void R2858_TC93150_AltEVV_ClientFirstName_valid_leading_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC93150_AltEVV_ClientFirstName_valid_leading_space");

		logger.log(LogStatus.INFO, "	//To validate the valid  ClientFirstName by passing the value as leading space"); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", "   " + CommonMethods.generateRandomStringOfFixLength(15));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//To validate the invalid  ClientloyeeFirstName by passing the value as trailing space
	@Test(groups = {"All"})
	public void R2858_TC93150_AltEVV_ClientFirstName_valid_trailing_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC93150_AltEVV_ClientFirstName_valid_trailing_space");

		logger.log(LogStatus.INFO, "//To validate the valid  ClientloyeeFirstName by passing the value as trailing space"); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(15) + "  ");

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

	}

	//To validate the invalid  ClientloyeeFirstName by passing the null 
	@Test(groups = {"All"})
	public void R2858_TC93150_AltEVV_ClientFirstName_invalid__null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2858_TC93150_AltEVV_ClientFirstName_invalid__null");

		logger.log(LogStatus.INFO, "To validate the invalid  ClientloyeeFirstName by passing the null "); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", null);

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientFirstName cannot be null.");
	}

}