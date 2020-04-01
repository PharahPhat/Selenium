package AltEVV_generic.restassured.sandata.Indiana.Client;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;


public class R2267_TC92350_AltEVV_Clients_Validate_the_Response_json extends BaseTest { 
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//Case-1 Testing without ClientOtherID field
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC92350_Open_EVV_alt_EVV_Clients_Validate_the_Response_json() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC92350_Open_EVV_alt_EVV_Clients_Validate_the_Response_json");

		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson response with valid data "); 

		//loading the Json dynamically with unique value set 
		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

		logger.log(LogStatus.INFO, "Passing all parameters with valid data");
		logger.log(LogStatus.INFO, "extracting request send body " + j.toJSONString());

		// Providing parameter, passing resource and validating API status code and extracting the response in Raw format   
		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}


}
