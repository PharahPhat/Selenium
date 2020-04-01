package openevv.Connecticut.xref;

import java.io.IOException;

import com.globalMethods.core.*;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_538_TC95984_Validate_xref_relation_when_EmployeeQualifier_other_than_valid extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the invalid EmployeeQualifier
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95984_Invalid_xref_relation_when_EmployeeQualifier_other_than_EmployeeSSN_EmployeeRegID_EmployeeCustomID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC95984_Invalid_xref_relation_when_EmployeeQualifier_other_than_EmployeeSSN_EmployeeRegID_EmployeeCustomID'EmployeeSVN' ");  // adding method name info via logger
		 
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		
		jsonobject.put("EmployeeQualifier", "EmployeeSVN");
	

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierFormatError);
	
	
	}
	
	//To validate the invalid EmployeeQualifier
		@Test(groups = {"Smoke"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC95984_Invalid_xref_relation_when_EmployeeQualifier_other_than_EmployeeSSN_EmployeeRegID_EmployeeCustomID_1() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
		{
			// logger = extent.startTest("TC95984_Invalid_xref_relation_when_EmployeeQualifier_other_than_EmployeeSSN_EmployeeRegID_EmployeeCustomID'EmployeeSSN|EmployeeRegID|EmployeeCustomID' ");  // adding method name info via logger
			 
			JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
			
			JSONObject jsonobject = (JSONObject) jsonarray.get(0);
			
			jsonobject.put("EmployeeQualifier", "EmployeeSSN|EmployeeRegID|EmployeeCustomID");
		

			String bodyAsString = CommonMethods.capturePostResponse(jsonarray,
					CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

			//Using Assert to validate the expected result
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierFormatError);
		
		
		}
	
		//To validate the invalid EmployeeQualifier
		@Test(groups = {"All"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC95984_Invalid_xref_relation_when_EmployeeQualifier_other_than_EmployeeSSN_EmployeeRegID_EmployeeCustomID_2() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
		{
			// logger = extent.startTest("TC95984_Invalid_xref_relation_when_EmployeeQualifier_other_than_EmployeeSSN_EmployeeRegID_EmployeeCustomID'EmployeeRebID' ");  // adding method name info via logger
			 
			JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
			
			JSONObject jsonobject = (JSONObject) jsonarray.get(0);
			
			jsonobject.put("EmployeeQualifier", "EmployeeRebID");
		

			String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

			//Using Assert to validate the expected result
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierFormatError);
		
		
		}



}
