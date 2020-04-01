package AltEVV_generic.restassured.sandata.Indiana.Client;

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
 * @author Anupam
 */
//Test Case 91078: OpenEVV-altEVV- Client:  Validate (mix) - ClientLastName field formats/values

public class R2267_TC91078_AltEVV_ClientLastName extends BaseTest { 
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	public static String ClientLastName, lastname= "L_name"; 

	//Case-1 ClientLastName: >30 characters 
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "AltEVVclient")
	public void TC91078_AltEVV_ClientLastName_more_than_30chars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, ClassNotFoundException, SQLException
	{
		// adding method name info via logger
		// logger = extent.startTest("TC91078_AltEVV_ClientLastName_more_than_30chars");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientLastName_with_more_than_30chars"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientLastName", CommonMethods.generateRandomStringOfFixLength(31));

		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		assertionDbVerifier.verifyInboxClient_AltEVVGenreic(js);
	}

	//Case-3 ClientLastName: Null
	@Test(groups = {"All"})
	@AdditionalInfo(module = "AltEVVclient")
	public void TC91078_AltEVV_ClientLastName_with_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// adding method name info via logger
		// logger = extent.startTest("TC91078_AltEVV_ClientLastName_with_null");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientLastName_with_null"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientLastName", null);

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		//Validating the expected Result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.memberClientLastNameNullError);
	}	    

	//Case-5 ClientLastName: Special chars
	@Test(groups = {"All"})
	@AdditionalInfo(module = "AltEVVclient")
	public void TC91078_AltEVV_ClientLastName_with_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// adding method name info via logger
		// logger = extent.startTest("TC91078_AltEVV_ClientLastName_with_specialchars");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientLastName_with_specialchars"); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientLastName", CommonMethods.generateSpecialChar(5));

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientLastNameSpecialCharError);

	}

}
