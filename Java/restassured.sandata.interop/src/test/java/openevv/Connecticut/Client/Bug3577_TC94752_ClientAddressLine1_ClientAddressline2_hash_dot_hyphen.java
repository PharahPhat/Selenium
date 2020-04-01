/**
 * 
 */
package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author RRohiteshwar
 *
 */

public class Bug3577_TC94752_ClientAddressLine1_ClientAddressline2_hash_dot_hyphen extends BaseTest
{
	private Assertion_DbVerifier assertionDbVerifier=new Assertion_DbVerifier();
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate valid ClientAddressLine1_ClientAddressline2_hash_dot_hyphen
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void Bug3577_TC94752_ClientAddressLine1_ClientAddressline2_hash_dot_hyphen_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{

		// logger = extent.startTest("Bug3577_TC94752_ClientAddressLine1_ClientAddressline2_hash_dot_hyphen");
	
		logger.log(LogStatus.INFO, "To validate valid ClientAddressLine1_ClientAddressline2_hash_dot_hyphen");
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);

		js.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(5)
				+ "#" + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "." + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "-" + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "_" + CommonMethods.generateRandomNumberOfFixLength(5)
					);
		js.put(globalVariables.ClientAddressLine2, CommonMethods.generateRandomStringOfFixLength(5)
				+ "#" + CommonMethods.generateRandomStringOfFixLength(5)
				+ "." + CommonMethods.generateRandomStringOfFixLength(5)
				+ "-" + CommonMethods.generateRandomStringOfFixLength(5)
				+ "_" + CommonMethods.generateRandomStringOfFixLength(5)
				);
		
		js.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(16));

		JSONArray jsonArray_Sub = (JSONArray) js.get("ClientAddress");
		JSONObject jsonObjectMap_Supp = (JSONObject) jsonArray_Sub.get(0);
		JSONObject jsonObjectMap_Address = (JSONObject) jsonArray_Sub.get(1);
		
		jsonObjectMap_Supp.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(5)
				+ "#" + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "." + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "-" + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "_" + CommonMethods.generateRandomNumberOfFixLength(5)
					);
		jsonObjectMap_Supp.put(globalVariables.ClientAddressLine2, CommonMethods.generateRandomStringOfFixLength(5)
				+ "#" + CommonMethods.generateRandomStringOfFixLength(5)
				+ "." + CommonMethods.generateRandomStringOfFixLength(5)
				+ "-" + CommonMethods.generateRandomStringOfFixLength(5)
				+ "_" + CommonMethods.generateRandomStringOfFixLength(5)
				);
		
		jsonObjectMap_Supp.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(16));

		
		jsonObjectMap_Address.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(5)
				+ "#" + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "." + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "-" + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "_" + CommonMethods.generateRandomNumberOfFixLength(5)
					);
		jsonObjectMap_Address.put(globalVariables.ClientAddressLine2, CommonMethods.generateRandomStringOfFixLength(5)
				+ "#" + CommonMethods.generateRandomStringOfFixLength(5)
				+ "." + CommonMethods.generateRandomStringOfFixLength(5)
				+ "-" + CommonMethods.generateRandomStringOfFixLength(5)
				+ "_" + CommonMethods.generateRandomStringOfFixLength(5)
				);
		
		jsonObjectMap_Address.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(16));

		CommonMethods.verifyPostResponseOPENEVV(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_client_url), 
				CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
	}

	//To validate valid ClientAddressLine1_ClientAddressline2_hash_dot_hyphen
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void Bug3577_TC94752_ClientAddressLine1_ClientAddressline2_Except_hash_dot_hyphen_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{

		// logger = extent.startTest("Bug3577_TC94752_ClientAddressLine1_ClientAddressline2_Except_hash_dot_hyphen_invalid");
	
		logger.log(LogStatus.INFO, "To validate valid ClientAddressLine1_ClientAddressline2_Except_hash_dot_hyphen_invalid");
		
		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);

		js.put(globalVariables.ClientAddressLine1, CommonMethods.generateRandomNumberOfFixLength(5)
				+ "#" + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "&%@" + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "&" + CommonMethods.generateRandomNumberOfFixLength(5)
				+ "%");
		js.put(globalVariables.ClientAddressLine2, CommonMethods.generateRandomStringOfFixLength(5)
				+ "%" + CommonMethods.generateRandomStringOfFixLength(5)
				+ "&%@" + CommonMethods.generateRandomStringOfFixLength(5)
				+ "&" + CommonMethods.generateRandomStringOfFixLength(5)
				+ "%");
		
		js.put(globalVariables.ClientCity, CommonMethods.generateRandomStringOfFixLength(16));


		String bodyAsString = CommonMethods.captureResponseOPENEVV(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		
	  CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1FormatError1);
	}
}
