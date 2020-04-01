/**
 * 
 */
package openevv.Connecticut.Client;

import java.io.IOException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2154_TC96855_OpenEVV_ClientJson_validcase_of_ClientDesigneeEndDate extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All", "fixing"})	@AdditionalInfo(module = "OpenEVV")
	public void TC96855_OpenEVV_ClientJson_validcase_of_ClientDesigneeEndDate() throws InterruptedException, IOException, ParseException{

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientDesigneeEndDate", CommonMethods.generateTodayDate_YYYY_MM_dd()+ "T06:47:57Z");
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		Assert.assertTrue(bodyAsStringGet.contains("\"status\": \"SUCCESS\","));
		Assert.assertTrue(bodyAsStringGet.contains("\"reason\": \"Transaction Received.\","));
	}

}
