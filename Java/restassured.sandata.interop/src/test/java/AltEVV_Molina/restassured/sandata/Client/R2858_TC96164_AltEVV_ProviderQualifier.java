/**
 * 
 */
package AltEVV_Molina.restassured.sandata.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorClient;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.ACCID;
import static com.globalMethods.core.globalVariables.ProviderID;

public class R2858_TC96164_AltEVV_ProviderQualifier extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	//validating valid altEVV client validation for providerQualifier field having value SandataID,
	@Test(groups = {"All"})
	public void R2858_TC96164_AltEVV_ProviderQualifier_valid_SandataID_asvalue() throws  IOException, ParseException
	{
		// logger = extent.startTest("R78152_TC91263_AltEVV_ClientContactZip_valid_5Digit");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientZip");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put(ProviderID, stateInfo.get(ACCID));
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("SandataID"));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
		}
/*
//		NPI = NULL with account 28007
	//validating valid altEVV client validation for providerQualifier field having value  NPI
	@Test(groups = {"All"})
	public void R2858_TC96164_AltEVV_ProviderQualifier_valid_NPI_asvalue() throws   IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96164_AltEVV_ProviderQualifier_valid_NPI_asvalue");
		logger.log(LogStatus.INFO, "validating valid altEVV client validation for providerQualifier field having value  NPI");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("NPI"));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

	}
//  API is NULL with account 28007
	//validating valid altEVV client validation for providerQualifier field having value API
	@Test(groups = {"All"})
	public void R2858_TC96164_AltEVV_ProviderQualifier_valid_API_asvalue() throws IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96164_AltEVV_ProviderQualifier_valid_API_asvalue");
		logger.log(LogStatus.INFO, "validating valid altEVV client validation for providerQualifier field having value API");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("API"));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}
*/

	//validating valid altEVV client validation for providerQualifier field having value MedicaidID
	@Test(groups = {"All"})
	public void R2858_TC96164_AltEVV_ProviderQualifier_valid_MedicaidID_asvalue() throws IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96164_AltEVV_ProviderQualifier_valid_MedicaidID_asvalue");
		logger.log(LogStatus.INFO, "validating valid altEVV client validation for providerQualifier field having value MedicaidID"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("MedicaidID"));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		}
/*
//	TAXID is NULL in db with account 28007
	//validating valid altEVV client validation for providerQualifier field having value TaxID
	@Test(groups = {"All"})
	public void R2858_TC96164_AltEVV_ProviderQualifier_valid_TaxID_asvalue() throws   IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96164_AltEVV_ProviderQualifier_valid_TaxID_asvalue");
		logger.log(LogStatus.INFO, "validating valid altEVV client validation for providerQualifier field having value TaxID");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("TaxID"));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		}
//		Taxonomy is not mapping with account 28007
	//validating valid altEVV client validation for providerQualifier field having value Taxonomy
	@Test(groups = {"All"})
	public void R2858_TC96164_AltEVV_ProviderQualifier_valid_Taxonomy_asvalue() throws   IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96164_AltEVV_ProviderQualifier_valid_Taxonomy_asvalue");
		logger.log(LogStatus.INFO, "validating valid altEVV client validation for providerQualifier field having value Taxonomy");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("Taxonomy"));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

	}
*/

	//validating valid altEVV client validation for providerQualifier field having value Legacy
	@Test(groups = {"All"})
	public void R2858_TC96164_AltEVV_ProviderQualifier_valid_Legacy_asvalue() throws  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96164_AltEVV_ProviderQualifier_valid_Legacy_asvalue");
		logger.log(LogStatus.INFO, "validating valid altEVV client validation for providerQualifier field having value Legacy"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("Legacy"));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}

	//validating valid altEVV client validation for providerQualifier field having value Other
	@Test(groups = {"All"})
	public void R2858_TC96164_AltEVV_ProviderQualifier_valid_Other_asvalue() throws   IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96164_AltEVV_ProviderQualifier_valid_Other_asvalue");
		logger.log(LogStatus.INFO, "validating valid altEVV client validation for providerQualifier field having value Other"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("Other"));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

	}

	//validating invalid altEVV client validation for providerQualifier field other than the assigned value
	@Test(groups = {"All"})
	public void R2858_TC96164_AltEVV_ProviderQualifier_invalid_Other_than_Assignedasvalue() throws  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96164_AltEVV_ProviderQualifier_invalid_Other_than_Assignedasvalue");
		logger.log(LogStatus.INFO, "validating invalid altEVV client validation for providerQualifier field other than the assigned value"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", DataGeneratorClient.providerQualifierType("wewqeqwe"));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		logger.log(LogStatus.INFO, "Validating JSON response ");

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ProvideQualifier_generic);

	}

	//validating invalid altEVV client validation for providerQualifier field other than the assigned value but alphanumeric
	@Test(groups = {"All"})
	public void R2858_TC96164_AltEVV_ProviderQualifier_invalid_Other_than_Assignedasvalue_alphanumeric() throws   IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96164_AltEVV_ProviderQualifier_invalid_Other_than_Assignedasvalue_alphanumeric");
		logger.log(LogStatus.INFO, "validating invalid altEVV client validation for providerQualifier field other than the assigned value but alphanumeric"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", CommonMethods.generateRandomAlphaNumeric(20));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		logger.log(LogStatus.INFO, "Validating JSON response ");

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ProvideQualifier_generic);
	}

	//validating invalid altEVV client validation for providerQualifier field other than the assigned value but null
	@Test(groups = {"All"})
	public void R2858_TC96164_AltEVV_ProviderQualifier_invalid_Other_than_Assignedasvalue_null() throws  IOException, ParseException
	{
		// logger = extent.startTest("R2858_TC96164_AltEVV_ProviderQualifier_invalid_Other_than_Assignedasvalue_null");
		logger.log(LogStatus.INFO, "validating invalid altEVV client validation for providerQualifier field other than the assigned value but null"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectPay =  (JSONObject) jsonObject.get("ProviderIdentification");
		jsonObjectPay.put("ProviderQualifier", CommonMethods.generateRandomAlphaNumeric(20));

		String bodyAsString =CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

		logger.log(LogStatus.INFO, "Validating JSON response ");

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ProvideQualifier_generic);
	}

}

