package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Anupam
 *
 */

//Test Case 96777:Open EVV Client- Validate the client Json for invalid case of ClientMedicaidID (Refer the steps for scenario)

public class R2154_TC96777_OpenEVV_ClientMedicaidID_invalid extends BaseTest {
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	//Case1: ClientMedicaidID= mm-dd-yyyy  ex :-- 10-29-2018
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96777_OpenEVV_ClientMedicaidID_invalid_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96777_OpenEVV_ClientMedicaidID_invalid_specialchars");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMedicaidID", CommonMethods.generateSpecialChar(9));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientMedicaidIDformaterror);

	}
	
	//Case2: ClientMedicaidID= INBETWEEN SPACE
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96777_OpenEVV_ClientMedicaidID_Space_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2154_TC96777_OpenEVV_ClientMedicaidID_Space_invalid");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(4) +" " +CommonMethods.generateRandomNumberOfFixLength(4));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientMedicaidIDformaterror);

	}
	
	//Case3:ClientMedicaidID= String Combination with dashes
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96777_OpenEVV_ClientMedicaidID_dashes_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2154_TC96777_OpenEVV_ClientMedicaidID_dashes_invalid");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMedicaidID", CommonMethods.generateRandomAlphaNumeric(3) +"-" +CommonMethods.generateRandomNumberOfFixLength(5));	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientMedicaidIDformaterror);

	}

}