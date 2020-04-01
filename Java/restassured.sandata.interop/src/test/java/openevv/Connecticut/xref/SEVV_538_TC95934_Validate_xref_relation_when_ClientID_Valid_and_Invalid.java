package openevv.Connecticut.xref;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_538_TC95934_Validate_xref_relation_when_ClientID_Valid_and_Invalid extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	//To validate the invalid clientid
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
		public void TC95934_Invalid_xref_relation_when_ClientID_length_greaterthan_5_Integer() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC95934_Invalid_xref_relation_when_ClientID_length_greaterthan_10_Integer");  // adding method name info via logger
		 
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientID", "12003456789");
	

		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDFormatError);
	
	
	}
	
	//To validate the invalid clientid
	@Test(groups = {"All", "fixing"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC95934_Valid_xref_relation_when_ClientID_length_lessthan_10_Integer() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
		{
			// logger = extent.startTest("TC95934_Invalid_xref_relation_when_ClientID_length_lessthan_10_Integer");  // adding method name info via logger
			 
			//Using Reusable method to load client json
			JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

			//Making json values dynamic

			JSONObject js = (JSONObject) j.get(0);
			js.put("ClientID", "120034");
		

			String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

			//Using Assert to validate the expected result
			CommonMethods.verifyjsonassertpasscase(bodyAsString);

		}
		
		//To validate the invalid clientid
		@Test(groups = {"All", "fixing"})
				@AdditionalInfo(module = "OpenEVV")
				public void TC95934_Invalid_xref_relation_when_ClientID_chrachter_only() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
				{
					// logger = extent.startTest("TC95934_Invalid_xref_relation_when_ClientID_chrachter_only");  // adding method name info via logger
					 
					//Using Reusable method to load client json
					JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

					//Making json values dynamic

					JSONObject js = (JSONObject) j.get(0);
					js.put("ClientID", "avbeffhghd");
				

					String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

					//Using Assert to validate the expected result
					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDFormatError);
				
				
				}

				//To validate the invalid clientid
				@Test(groups = {"All", "fixing"})
				@AdditionalInfo(module = "OpenEVV")
				public void TC95934_Invalid_xref_relation_when_ClientID_alpha_numeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
				{
					// logger = extent.startTest("TC95934_Invalid_xref_relation_when_ClientID_alpha_numeric");  // adding method name info via logger
					 
					//Using Reusable method to load client json
					JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

					//Making json values dynamic

					JSONObject js = (JSONObject) j.get(0);
					js.put("ClientID", "avbef12345");
				

					String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

					//Using Assert to validate the expected result
					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDFormatError);
				
				
				}
				
				//To validate the invalid clientid
				@Test(groups = {"All", "fixing"})
				@AdditionalInfo(module = "OpenEVV")
				public void TC95934_Invalid_xref_relation_when_ClientID_NULL() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
				{
					// logger = extent.startTest("TC95934_Invalid_xref_relation_when_ClientID_NULL");  // adding method name info via logger
					 
					//Using Reusable method to load client json
					JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

					//Making json values dynamic

					JSONObject js = (JSONObject) j.get(0);
					js.put("ClientID", "NULL");
				

					String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

					//Using Assert to validate the expected result
					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDFormatError);
				
				
				}
				
				//To validate the invalid clientid
				@Test(groups = {"All", "fixing"})
				@AdditionalInfo(module = "OpenEVV")
				public void TC95934_Invalid_xref_relation_when_ClientID_special_character() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
				{
					// logger = extent.startTest("TC95934_Invalid_xref_relation_when_ClientID_Special_Character");  // adding method name info via logger
					 
					//Using Reusable method to load client json
					JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

					//Making json values dynamic

					JSONObject js = (JSONObject) j.get(0);
					js.put("ClientID", "1234@");
				

					String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

					//Using Assert to validate the expected result
					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDFormatError);
				
				
				}
				
				//To validate the invalid clientid
				@Test(groups = {"All", "fixing"})
				@AdditionalInfo(module = "OpenEVV")
				public void TC95934_Invalid_xref_relation_when_ClientID_with_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
				{
					// logger = extent.startTest("TC95934_Invalid_xref_relation_when_ClientID_with_space");  // adding method name info via logger
					 
					//Using Reusable method to load client json
					JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

					//Making json values dynamic

					JSONObject js = (JSONObject) j.get(0);
					js.put("ClientID", "1234 ");
				

					String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

					//Using Assert to validate the expected result
					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDFormatError);
				
				
				}
				
				//To validate the invalid clientid
				@Test(groups = {"All"})
				@AdditionalInfo(module = "OpenEVV")
				public void TC95934_validate_xref_relation_when_ClientID_is_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
				{
					// logger = extent.startTest("TC95934_validate_xref_relation_when_ClientID_is_valid");  // adding method name info via logger
					 
					//Using Reusable method to load client json
					

					//Making json values dynamic
					JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
					
					JSONObject jsonobject = (JSONObject) jsonarray.get(0);
					
					jsonobject.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(5));
				


					//Using Assert to validate the expected result
					String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

				
				
				}
}
