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

public class R2154_TC96851_OpenEVV_ClientJson_validcases_of_Weekend extends BaseTest 
{ 
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96851_OpenEVV_ClientJson_validcases_of_Weekend_UTCformat() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC96851_OpenEVV_ClientJson_validcases_of_Weekend_UTCformat_YYYY-MM-DDThh:mm:ss.TZ");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

	//	jsonObject.put("Weekend", CommonMethods.generatePastDate_UTCformat());

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		assertionDbVerifier.jsonAssert_InboxClient_OpenEVV(bodyAsString, jsonObject);

	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC96851_OpenEVV_ClientJson_invalidformat_of_Weekend_without_Z() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96851_OpenEVV_ClientJson_invalidformat_of_Weekend_without_Z_YYYY-MM-DDThh:mm:ss.T");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("Weekend", "2018-12-30T06:47:10");

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
	
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.WeekendErrorformat);


	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96851_OpenEVV_ClientJson_invalidcases_of_Weekend_UTCformat_YYYY_MM_DDThhmm() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96851_OpenEVV_ClientJson_invalidcases_of_Weekend_UTCformat_YYYY-MM-DDThh:mm");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("Weekend", "2018-05-10T05:04");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
	
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.WeekendErrorformat);


	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96851_OpenEVV_ClientJson_validcases_of_Weekend_UTCformat_YYYYMMDDThhmm() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96851_OpenEVV_ClientJson_validcases_of_Weekend_UTCformat_YYYYMMDDThhmm");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("Weekend", "2019-01-06T05:04Z");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.WeekendErrorformat);


	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96851_OpenEVV_ClientJson_validcases_of_Weekend_UTCformat_YYYYMMDD() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96851_OpenEVV_ClientJson_validcases_of_Weekend_UTCformat_YYYYMMDD");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("Weekend", "2018-05-10");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.WeekendErrorformat);
		
//		String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

//		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject);


	}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96851_OpenEVV_ClientJson_validcases_of_Weekend_optional() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC96851_OpenEVV_ClientJson_validcases_of_Weekend_optional");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("Weekend", "");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
	
		jsonObject.put("Weekend", null);	

		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject);


	}


}
