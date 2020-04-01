package openevv.Connecticut.xref;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; 
public class SEVV_538_TC95933_Xref_Validate_xref_relation_when_ClientIDQualifier_Mix_greater_than_20_digits extends BaseTest { 
	 
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	//To validate the invalid ClientIDQualifie
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
		public void TC95933_Xref_Invalid_xref_relation_when_ClientIDQualifier_length_greater_than_20_digits_mixvalue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC95933_Xref_Invalid_xref_relation_when_ClientIDQualifier_length_greater_than_20_digits_mixvalue");  // adding method name info via logger
		 
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientIDQualifier", "ClientID009787865456456456");
	

		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientidQualifierFormatError);
	
	
	}
	
	//To validate the invalid ClientIDQualifie
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95933_Xref_Invalid_xref_relation_when_ClientIDQualifier_length_greater_than_20_digits_integer() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC95933_Xref_Invalid_xref_relation_when_ClientIDQualifier_length_greater_than_20_digits_integer ");  // adding method name info via logger
		 
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientIDQualifier", "102229320313132132132123");
	

		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientidQualifierFormatError);
	
	
	}
	
	//To validate the invalid ClientIDQualifie
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95933_Xref_Invalid_xref_relation_when_ClientIDQualifier_length_greater_than_20_digits_charachter() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC95933_Xref_Invalid_xref_relation_when_ClientIDQualifier_length_greater_than_20_digits_charachter");  // adding method name info via logger
		 
		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientIDQualifier", "ClientSSNraviranjankumarIndia");
	

		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientidQualifierFormatError);
	
	
	}


}
