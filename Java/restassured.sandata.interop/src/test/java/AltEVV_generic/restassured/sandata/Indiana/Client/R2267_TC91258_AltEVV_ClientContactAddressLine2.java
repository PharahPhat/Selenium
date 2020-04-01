package AltEVV_generic.restassured.sandata.Indiana.Client;

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

//Test Case 91253:Open EVV- altEVV- Client- Validate (mix) - ClientContactAddressLine1 field formats/values

public class R2267_TC91258_AltEVV_ClientContactAddressLine2 extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//validating valid altEVV client  having ClientContactAddressLine2 with 30 char as string
	@Test(groups = {"All", "fixing"})
	public void R2267_TC91258_AltEVV_ClientContactAddressLine2_valid_with_30char_asstring() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactAddressLine2_valid_with_30char_asstring");
		logger.log(LogStatus.INFO, "validating valid altEVV client  having ClientContactAddressLine2 with 30 char as string");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put("ClientContactAddressLine2", CommonMethods.generateRandomAlphaNumeric(30));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		assertionDbVerifier.verifyInboxClientContactAltEVVGeneric(jsonObject, jsonObject1);
	}

	//validating invalid altEVV client having ClientContactAddressLine2 with maximum string
	@Test(groups = {"All", "fixing"})
	public void R2267_TC91258_AltEVV_ClientContactAddressLine2_invalid_with_maxstring() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ClassNotFoundException, SQLException
	{
		// logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactAddressLine2_invalid_with_maxstring");
		logger.log(LogStatus.INFO, "validating invalid altEVV client having ClientContactAddressLine2 with maximum string");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put("ClientContactAddressLine2", CommonMethods.generateRandomStringOfFixLength(31));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		assertionDbVerifier.verifyInboxClientContactAltEVVGeneric(jsonObject, jsonObject1);
	}

	//validating invalid altEVV client having ClientContactAddressLine2 with 30char_with special character
	@Test(groups = {"All"})
	public void R2267_TC91258_AltEVV_ClientContactAddressLine2_invalid_with_30char_specialchar() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactAddressLine2_invalid_with_30char_butnot_string");
		logger.log(LogStatus.INFO, "validating invalid altEVV client having ClientContactAddressLine2 with special character"); 

		String clntcontctaddlin1=  CommonMethods.generateRandomAlphaNumeric(5)+
									CommonMethods.generateSpecialChar(2)+
									CommonMethods.generateRandomNumberOfFixLength(2);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put("ClientContactAddressLine2", clntcontctaddlin1);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactAddressLine2FormatRegularExpressionError);
	}

	//validating invalid altEVV client having ClientContactAddressLine2 with more than 30char with special character
	@Test(groups = {"All"})
	public void R2267_TC91258_AltEVV_ClientContactAddressLine2_invalid_with_morethan_30char_specialchar() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91250_AltEVV_ClientContactAddressLine2_invalid_with_morethan_30char_specialchar");
		logger.log(LogStatus.INFO, "validating invalid altEVV client having ClientContactAddressLine2 with more than 30char_with special character"); 

		String clntcontctaddlin1=  CommonMethods.generateRandomAlphaNumeric(10)+
				CommonMethods.generateSpecialChar(12)+
				CommonMethods.generateRandomNumberOfFixLength(12);

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get("ClientResponsibleParty");
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);

		jsonObject1.put("ClientContactAddressLine2", clntcontctaddlin1);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactAddressLine2FormatRegularExpressionError);
	}

}

