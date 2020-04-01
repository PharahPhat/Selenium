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

//Test Case 92339: Open EVV - Alt EVV - Validate client creation without Address Segment
/**
 * @author Anupam
 */

public class R2267_TC92339_AltEVV_Client_Creation_without_Address_Segment extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//Case-1 Testing Client json without Address Segment
	@Test(groups = {"All"})
	public void TC92339_Alt_EVV_Client_Creation_without_Address_Segment() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{   
		// logger = extent.startTest("TC92339_Alt_EVV_Client_Creation_without_Address_Segment");
		logger.log(LogStatus.INFO, "Validating Client_Creation_without_Address_Segment"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonarray_sub= (JSONArray) jsonObject.get("ClientAddress");
		JSONObject js1 = (JSONObject) jsonarray_sub.get(0);
		js1.remove("ClientState");
		js1.remove("ClientCounty");
		js1.remove("ClientAddressLatitude");
		js1.remove("ClientAddressLongitude");
		js1.remove("ClientZip");
		js1.remove("ClientAddressLine2");
		js1.remove("ClientAddressLine1");
		js1.remove("ClientAddressType");
		js1.remove("ClientCity");
		js1.remove("ClientAddressIsPrimary");

		JSONObject js2 = (JSONObject) jsonarray_sub.get(1);
		js2.remove("ClientState");
		js2.remove("ClientCounty");
		js2.remove("ClientAddressLatitude");
		js2.remove("ClientAddressLongitude");
		js2.remove("ClientZip");
		js2.remove("ClientAddressLine2");
		js2.remove("ClientAddressLine1");
		js2.remove("ClientAddressType");
		js2.remove("ClientCity");
		js2.remove("ClientAddressIsPrimary");
		
		

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.memberClientStateNullError);
	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.memberClientZipNullError);
	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCity_nullerror);
	 	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1NullError);
	}
}
