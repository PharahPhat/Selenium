package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
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

public class R2267_TC91076_AltEVV_ClientFirstName extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();

	//To validate the valid  ClientloyeeFirstName by passing the String Value of 30chars
	@Test(groups = {"All", "Regression", "fixing"})
	@AdditionalInfo(module = "AltEVVclient")
	public void R2267_TC91076_AltEVV_ClientFirstName_valid_String_30char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		
		// logger = extent.startTest("R2267_TC91076_AltEVV_ClientFirstName_valid_String_30char");
		logger.log(LogStatus.INFO, "validating ClientFirstname with valid length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) jsonArray.get(0);

		js.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(30));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		assertionDbVerifier.verifyInboxClient_AltEVVGenreic(js);
	}

	//To validate the valid  ClientloyeeFirstName by passing the String Value as min value as 1 chars
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "AltEVVclient")
	public void R2267_TC91076_AltEVV_ClientFirstName_valid_String_minvalue_1char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91076_AltEVV_ClientFirstName_valid_String_minvalue_1char");

		logger.log(LogStatus.INFO, "To validate the valid  ClientFirstName by passing the String Value as min value as 1 chars"); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(1));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		assertionDbVerifier.verifyInboxClient_AltEVVGenreic(js);
	}

	//To validate the valid  ClientloyeeFirstName by passing the String Value of more than 30chars
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "AltEVVclient")
	public void R2267_TC91076_AltEVV_ClientFirstName_invalid_String_exceeding_30char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91076_AltEVV_ClientFirstName_invalid_String_exceeding_30char");

		logger.log(LogStatus.INFO, "To validate R2267_TC91076_AltEVV_ClientFirstName_invalid_String_exceeding_30char"); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(31));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		assertionDbVerifier.verifyInboxClient_AltEVVGenreic(js);
	}

	//To validate the invalid  ClientloyeeFirstName by passing the value as numeric
	@Test(groups = {"All"})
	public void R2267_TC91076_AltEVV_ClientFirstName_invalid_numeric1() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91076_AltEVV_ClientFirstName_invalid_numeric1");

		logger.log(LogStatus.INFO, "To validate R2267_TC91076_AltEVV_ClientFirstName_invalid_numeric1"); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientFirstName", CommonMethods.generateRandomNumberOfFixLength(15));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientFirstName format is incorrect.");
	}

	//To validate the invalid  ClientloyeeFirstName by passing the value as alphanumeric
	@Test(groups = {"All"})
	@AdditionalInfo(module = "AltEVVclient")
	public void R2267_TC91076_AltEVV_ClientFirstName_invalid_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91076_AltEVV_ClientFirstName_invalid_alphanumeric");

		logger.log(LogStatus.INFO, "To validate the invalid  ClientFirstName by passing the value as alphanumeric"); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", CommonMethods.generateRandomAlphaNumeric(16));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientFirstName format is incorrect.");
	}

	//To validate the invalid  ClientloyeeFirstName by passing the value as special chars
	@Test(groups = {"All"})
	@AdditionalInfo(module = "AltEVVclient")
	public void R2267_TC91076_AltEVV_ClientFirstName_invalid_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91076_AltEVV_ClientFirstName_invalid_specialchars");

		logger.log(LogStatus.INFO, "To validate the invalid  ClientFirstName by passing the value as special chars"); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", CommonMethods.generateSpecialChar(16));

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientFirstName format is incorrect.");
	}

	//To validate the invalid  ClientloyeeFirstName by passing the value as blank
	@Test(groups = {"All"})
	@AdditionalInfo(module = "AltEVVclient")
	public void R2267_TC91076_AltEVV_ClientFirstName_invalid_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91076_AltEVV_ClientFirstName_invalid_blank");

		logger.log(LogStatus.INFO, "//To validate the invalid  ClientFirstName by passing the value as blank"); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", "");

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientFirstName format is incorrect.");
	}

	//To validate the invalid  ClientloyeeFirstName by passing the null 
	@Test(groups = {"All"})
	@AdditionalInfo(module = "AltEVVclient")
	public void R2267_TC91076_AltEVV_ClientFirstName_invalid__null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2267_TC91076_AltEVV_ClientFirstName_invalid__null");

		logger.log(LogStatus.INFO, "To validate the invalid  ClientloyeeFirstName by passing the null "); 

		//Using Reusable method to load Clientloyee json
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientFirstName", null);

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.memberClientFirstNameNullError);
	}

}