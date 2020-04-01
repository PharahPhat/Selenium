package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

//TC91118: OpenEVV-altEVV- Client: Validate If the ClientSSN field is left empty

public class R2267_TC91118_AltEVV_ClientSSN extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void R2267_TC91118_AltEVV_ClientSSN_invalid_length() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91118_AltEVV_ClientSSN_invalid_length");
		logger.log(LogStatus.INFO, "Validate invalid Client SSN length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientSSN", CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientSSNLengthError_AltEVV);
	}

	@Test(groups = {"All"})
	public void R2267_TC91118_AltEVV_ClientSSN_alphanumeric() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91118_AltEVV_ClientSSN_alphanumeric");
		logger.log(LogStatus.INFO, "Validate invalid Client SSN alphanumeric"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		String clientssn = CommonMethods.generateRandomAlphaNumeric(9);
		jsonObject.put("ClientSSN",clientssn );

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientSSN format is incorrect.");

	}

	@Test(groups = {"All"})
	public void R2267_TC91118_AltEVV_ClientSSN_nonnumeric() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91118_AltEVV_ClientSSN_nonumeric");
		logger.log(LogStatus.INFO, "Validate invalid Client SSN length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		String clientssn = CommonMethods.generateRandomStringOfFixLength(9);
		jsonObject.put("ClientSSN",clientssn );

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientSSN format is incorrect.");

	}

	@Test(groups = {"All"})
	public void R2267_TC91118_AltEVV_ClientSSN_dash() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91118_AltEVV_ClientSSN_nonumeric");
		logger.log(LogStatus.INFO, "Validate invalid Client SSN length"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		String clientssn = CommonMethods.generateRandomStringOfFixLength(4) + "-" + CommonMethods.generateRandomStringOfFixLength(4);
		jsonObject.put("ClientSSN",clientssn);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientSSN format is incorrect.");

	}

	@Test(groups = {"All"})
	public void R2267_TC91118_AltEVV_ClientSSN_leading_zeros() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91118_AltEVV_ClientSSN_leading_zeros");
		logger.log(LogStatus.INFO, "Validate invalid Client SSN with leading zeros"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		String clientssn = "00" + CommonMethods.generateRandomNumberOfFixLength(7);
		jsonObject.put("ClientSSN",clientssn);

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	@Test(groups = {"All"})
	public void R2267_TC91118_AltEVV_ClientSSN_Empty() throws InterruptedException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91118_AltEVV_ClientSSN_valid");
		logger.log(LogStatus.INFO, "Validate valid Client SSN"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientSSN", "");

		String clientotherid = CommonMethods.generateRandomNumberOfFixLength(9);
		jsonObject.put("ClientOtherID", clientotherid);

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}
}