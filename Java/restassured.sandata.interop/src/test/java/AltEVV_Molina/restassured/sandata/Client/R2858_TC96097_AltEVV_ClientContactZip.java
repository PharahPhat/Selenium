/**
 * 
 */
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
 * @author RRohiteshwar
 */

public class R2858_TC96097_AltEVV_ClientContactZip extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//validating valid altEVV ClientContactZip validation field formats/values with 5 digit
	@Test(groups = {"All"})
	public void R2858_TC96097_AltEVV_ClientContactZip_valid_5Digit() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96097_AltEVV_ClientContactZip_valid_5Digit");
		logger.log(LogStatus.INFO, "validating valid altEVV client  havingClientContactZip "); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, "0000" + CommonMethods.generateRandomNumberOfFixLength(5));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	
	//validating valid altEVV ClientContactZip validation field formats/values with 5 digit with appending 0000
	@Test(groups = {"All"})
	public void R2858_TC96097_AltEVV_ClientContactZip_valid_5Digit_append_0000() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96097_AltEVV_ClientContactZip_valid");
		logger.log(LogStatus.INFO, "validating valid altEVV client  havingClientContactZip "); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(5) +"0000");

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//validating valid altEVV ClientContactZip validation field formats/values with 5 digit with appending 4digit
	@Test(groups = {"All"})
	public void R2858_TC96097_AltEVV_ClientContactZip_valid_5Digit_append_4digit() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96097_AltEVV_ClientContactZip_valid");
		logger.log(LogStatus.INFO, "validating valid altEVV client  havingClientContactZip "); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(5) + CommonMethods.generateRandomNumberOfFixLength(4));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//validating invalid altEVVClientContactZip _invalid_Leading_space
	@Test(groups = {"All"})
	public void R2858_TC96097_AltEVV_ClientContactZip_invalid_Leading_space() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96097_AltEVV_ClientContactZip_invalid_Leading_space");
		logger.log(LogStatus.INFO, "validating invalid altEVVClientContactZip _invalid_Leading_space"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, " " +CommonMethods.generateRandomNumberOfFixLength(4));


		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipFormatError_alt);

	}

	//validatingClientContactZip _invalid_trailing_space
	@Test(groups = {"All"})
	public void R2858_TC96097_AltEVV_ClientContactZip_invalid_trailing_space() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96097_AltEVV_ClientContactZip_invalid_trailing_space");
		logger.log(LogStatus.INFO, "validatingClientContactZip _invalid_trailing_space"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(4) + " ");

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipFormatError_alt);

	}

	//validating invalid altEVVClientContactZip _invalid_Mid_space
	@Test(groups = {"All"})
	public void R2858_TC96097_AltEVV_ClientContactZip_invalid_Mid_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96097_AltEVV_ClientContactZip_invalid_Mid_space");
		logger.log(LogStatus.INFO, "validating invalid altEVVClientContactZip _invalid_Mid_space"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(2) + " " +CommonMethods.generateRandomNumberOfFixLength(3));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipFormatError_alt);

	}

	//validating invalid altEVVClientContactZip _invalid_leading_trailing_space
	@Test(groups = {"All"})
	public void R2858_TC96097_AltEVV_ClientContactZip_invalid_leading_trailing_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96097_AltEVV_ClientContactZip_invalid_leading_trailing_space");
		logger.log(LogStatus.INFO, "validating invalid altEVVClientContactZip _invalid_leading_trailing_space"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, " " + CommonMethods.generateRandomNumberOfFixLength(4) + " ");

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipFormatError_alt);

	}

	//validating invalid altEVV ClientContactZip invalid_SpecialChar
	@Test(groups = {"All"})
	public void R2858_TC96097_AltEVV_ClientContactZip_invalid_SpecialChar() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96097_AltEVV_ClientContactZip_invalid_SpecialChar");
		logger.log(LogStatus.INFO, "validating invalid altEVV ClientContactZip invalid_SpecialChar"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, CommonMethods.generateSpecialChar(5));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipFormatError_alt);

	}

	//validating invalid altEVV clientClientContactZip _invalid_null_asvalue
	@Test(groups = {"All"})
	public void R2858_TC96097_AltEVV_ClientContactZip_invalid_null_asvalue() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96097_AltEVV_ClientContactZip_invalid_null_asvalue");
		logger.log(LogStatus.INFO, "validating invalid altEVV clientClientContactZip _invalid_null_asvalue"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, "null");

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipFormatError_alt);

	}

	//validating invalid altEVVClientContactZip _invalid_nulll
	@Test(groups = {"All"})
	public void R2858_TC96097_AltEVV_ClientContactZip_valid_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2858_TC96097_AltEVV_ClientContactZip_valid_null");
		logger.log(LogStatus.INFO, "validating invalid altEVVClientContactZip _valid_nulll"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, null);
		
		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//validating invalid AltEVV_ClientContactZip_invalid_blank
	@Test(groups = {"All"})
	public void R2858_TC96097_AltEVV_ClientContactZip_invalid_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96097_AltEVV_ClientContactZip_invalid_blank");
		logger.log(LogStatus.INFO, "validating invalid AltEVV_ClientContactZip_invalid_blank"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.ClientResponsibleParty);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(0));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipLengthError_alt);

	}
}

