
package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

//Test Case 91074: OpenEVV-altEVV- Client: Validate (mix) - ClientID field formats/values
public class R2267_TC91074_AltEVV_ClientID_field_DB extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//Case-1 Testing with ClientID_more_than_10chars
	@Test(groups = {"All"})
	@AdditionalInfo(module = "AltEVVclient")
	public void TC91074_AltEVV_ClientID_more_than_10chars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC91074_AltEVV_ClientID_more_than_10chars");

		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", "92292345789");   // ---------->Case-1 (ClientID: >10 characters)

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The ClientID value is incorrect");

	}
	
	//Case-2 Testing with ClientID_String
	@Test(groups = {"All"})
	public void TC91074_AltEVV_ClientID_with_String() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC91074_AltEVV_ClientID_with_String");

		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", CommonMethods.generateRandomAlphaNumeric(5));   

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}
	
	//Case-2 Testing with ClientID_String
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "AltEVVclient")
	public void TC91074_AltEVV_ClientID_with_alphanumeric() throws InterruptedException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{   
		// adding method name info via logger
		// logger = extent.startTest("TC91074_AltEVV_ClientID_with_String");

		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", CommonMethods.generateRandomAlphaNumeric(10));   

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "AltEVVclient")
	public void TC91074_AltEVV_ClientID_with_null() throws IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// adding method name info via logger
		// logger = extent.startTest("TC91074_AltEVV_ClientID_with_String");

		JSONArray j = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", null);

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}
}