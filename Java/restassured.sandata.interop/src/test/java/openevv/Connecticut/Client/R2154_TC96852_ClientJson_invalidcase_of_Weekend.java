/**
 * 
 */
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

public class R2154_TC96852_ClientJson_invalidcase_of_Weekend extends BaseTest { 
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96852_OpenEVV_ClientJson_invalidcases_of_WeekendFormat_mmddyyyy() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96852_OpenEVV_ClientJson_validcases_of_Weekend_mmddyyyy");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("Weekend", CommonMethods.generatePastDate_MMddYYYY());	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.WeekendErrorformat);

	}

	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96852_OpenEVV_ClientJson_invalidcases_of_Weekend_ddmmyyyy() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96852_OpenEVV_ClientJson_invalidcases_of_Weekend_ddmmyyyy");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("Weekend", "15-02-2018");	
		
		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.WeekendErrorformat);

	}
	

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96852_OpenEVV_ClientJson_invalidcases_of_Weekend_ddyyyymm() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96852_OpenEVV_ClientJson_invalidcases_of_Weekend_ddyyyymm");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("Weekend", "25-2018-12");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.WeekendErrorformat);

	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96852_OpenEVV_ClientJson_invalidcases_of_Weekend_mmyyyydd() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96852_OpenEVV_ClientJson_invalidcases_of_Weekend_mmyyyydd");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("Weekend", "01-2018-22");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
				
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.WeekendErrorformat);

	}

}
