package AltEVV_Molina.restassured.sandata.Client;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.response.Response;


import com.globalMethods.core.Assertion_DbVerifier; public class R2858_TC96221_AltEVV_Clients_Validate_the_Get_Response_json extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Case-1 Testing without ClientOtherID field
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2858_TC96221_Open_EVV_alt_EVV_Clients_Validate_the_Response_json() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2858_TC96221_Open_EVV_alt_EVV_Clients_Validate_the_Response_json");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson response with valid data "); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
		JSONObject jsonObject=(JSONObject) j.get(0);

			// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}


}
