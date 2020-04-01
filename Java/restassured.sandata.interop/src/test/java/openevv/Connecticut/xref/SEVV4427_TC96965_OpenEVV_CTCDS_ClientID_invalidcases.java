package openevv.Connecticut.xref;

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

public class SEVV4427_TC96965_OpenEVV_CTCDS_ClientID_invalidcases extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96965_OpenEVV_CTCDS_ClientID_invalidcases_Alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC96965_OpenEVV_CTCDS_ClientID_invalidcases_Alphanumeric");  // adding method name info via logger
		 
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		
		jsonobject.put("ClientID", CommonMethods.generateRandomAlphaNumeric(5));
	
		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDformaterror);

}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96965_OpenEVV_CTCDS_ClientID_invalidcases_Alphabet() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC96965_OpenEVV_CTCDS_ClientID_invalidcases_Alphabet");  // adding method name info via logger
		 
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		
		jsonobject.put("ClientID", CommonMethods.generateRandomStringOfFixLength(5));
	
		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDformaterror);

}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96965_OpenEVV_CTCDS_ClientID_invalidcases_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC96965_OpenEVV_CTCDS_ClientID_invalidcases_specialchars");  // adding method name info via logger
		 
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		
		jsonobject.put("ClientID", CommonMethods.generateSpecialChar(5));
	
		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDformaterror);

}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96965_OpenEVV_CTCDS_ClientID_invalidcases_spaces() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC96965_OpenEVV_CTCDS_ClientID_invalidcases_spaces");  // adding method name info via logger
		 
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		
		jsonobject.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(3) +" " +CommonMethods.generateRandomNumberOfFixLength(1));
	
		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDformaterror);

}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96965_OpenEVV_CTCDS_ClientID_invalidcases_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC96965_OpenEVV_CTCDS_ClientID_invalidcases_null");  // adding method name info via logger
		 
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		
		jsonobject.put("ClientID", null);
	
		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientID cannot be null.");

}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96965_OpenEVV_CTCDS_ClientID_invalidcases_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC96965_OpenEVV_CTCDS_ClientID_invalidcases_length");  // adding method name info via logger
		 
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		
		jsonobject.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(11));
	
		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDformaterror);

}
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96965_OpenEVV_CTCDS_ClientID_invalidcases_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC96965_OpenEVV_CTCDS_ClientID_invalidcases_optional");  // adding method name info via logger
		 
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		
		jsonobject.put("ClientID", "");
	
		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDformaterror);

}
	

}
