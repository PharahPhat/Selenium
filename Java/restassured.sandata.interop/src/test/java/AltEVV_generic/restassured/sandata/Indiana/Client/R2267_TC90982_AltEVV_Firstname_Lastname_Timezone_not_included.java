package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

//Test Case 7328: OpenEVV-altEVV- Client:  Validate If the client Json does not include first name, last name and time zone

public class R2267_TC90982_AltEVV_Firstname_Lastname_Timezone_not_included extends BaseTest {
    private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
    //Case-1 Testing without Clientfirstname_lastname_timezone field
	@Test(groups = {"All"})
	@AdditionalInfo(module = "AltEVVclient")
	public void TC90982_AltEVV_CreateClient_without_firstname_lastname_timezone() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC7328_AltEVV_CreateClient_without_firstname_lastname_timezone");
		
		// adding what you are verifying
		logger.log(LogStatus.INFO, "Validating ClientJson without firstname_lastname_timezone"); 
		
		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject altEVVJsonArrayObject = (JSONObject) altEVVJsonArray.get(0);
		
		altEVVJsonArrayObject.remove("ClientFirstName");
		altEVVJsonArrayObject.remove("ClientLastName");
		altEVVJsonArrayObject.remove("ClientTimezone");
		
		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,CommonMethods.propertyfileReader(globalVariables.altevv_clients));
		
		//Validating the expected Result
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	  
	    Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientFirstName cannot be null."));
	    Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientTimezone cannot be null."));
	    Assert.assertTrue(bodyAsString.contains( "ERROR: The ClientLastName cannot be null."));
	
}

}