package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

//Test Case 88430:Open EVV: Verify error messages on uploading client with invalid input of 'ClientMedicaidID'
public class TC88430_ClientMedicaidID extends BaseTest { 
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the invalid ClientMedicaidID equal to 9
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88430_OpenEVV_ClientMedicaidID_length_valid() throws IOException, ParseException
	{
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(9));
		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
	}

	//To validate the invalid ClientMedicaidID length more than 9
	@Test(groups = {"All", "Smoke", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88430_OpenEVV_ClientMedicaidID_length_invalid() throws IOException, ParseException
	{
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(10));
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientMedicaidID format is incorrect.");
	}

	//To validate the ClientMedicaidID with length less than 9
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88430_OpenEVV_ClientMedicaidID_with_length_less_than_9() throws IOException, ParseException
	{
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(5));
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientMedicaidID format is incorrect.");
	}

	//To validate the ClientMedicaidID with alphanumeric value
	@Test(groups = {"All", "Regression", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88430_OpenEVV_ClientMedicaidID_with_alphanumeric() throws IOException, ParseException
	{
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMedicaidID", CommonMethods.generateRandomAlphaNumeric(9));
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientMedicaidID format is incorrect.");
	}

	//To validate the ClientMedicaidID with non numeric value
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88430_OpenEVV_ClientMedicaidID_with_nonnumeric() throws IOException, ParseException
	{
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMedicaidID", CommonMethods.generateRandomStringOfFixLength(9));
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientMedicaidID format is incorrect.");
	}

	//To validate the ClientMedicaidID with null value
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC88430_OpenEVV_ClientMedicaidID_with_nullValue() throws IOException, ParseException
	{
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMedicaidID", null);
		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
	}

	//To validate the ClientMedicaidID with missing value
	@Test(enabled = false, groups = {"All"})
	public void TC88430_OpenEVV_ClientMedicaidID_with_missing_value() throws IOException, ParseException
	{
		//Using Reusable method to load client json
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientMedicaidID", "");
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientMedicaidID format is incorrect.");
	}
}