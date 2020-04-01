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

public class SEVV_538_TC95985_Validate_xref_relation_with_EmployeeQualifier_length extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the invalid Xref EmployeeQualifier
		@Test(groups = {"All"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC95985_Xref_Invalid_xref_relation_when_EmployeeQualifier_length_greater_than_20_digits_mixvalue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
		{
			// logger = extent.startTest("TC95985_Xref_Invalid_xref_relation_when_EmployeeQualifier_length_greater_than_20_digits_mixvalue");  // adding method name info via logger
			 
			//Using Reusable method to load client json
			JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
			
			JSONObject jsonobject = (JSONObject) jsonarray.get(0);
			
			jsonobject.put("EmployeeQualifier", "EmployeeSSN009787865456456456");
		

			String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

			//Using Assert to validate the expected result
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierformat);
		
		
		}
		
		//To validate the invalid Xref end date with invalid date (2018-07-23)
		@Test(groups = {"All"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC95985_Xref_Invalid_xref_relation_when_EmployeeQualifier_length_greater_than_20_digits_integer() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
		{
			// logger = extent.startTest("TC95985_Xref_Invalid_xref_relation_when_EmployeeQualifier_length_greater_than_20_digits_integer ");  // adding method name info via logger
			 
			//Using Reusable method to load client json
              JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
			
			JSONObject jsonobject = (JSONObject) jsonarray.get(0);
			
			jsonobject.put("EmployeeQualifier", "999999999999009787865456456456");
		

			String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

			//Using Assert to validate the expected result
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierformat);
		
		
		}
		
		//To validate the invalid Xref end date with invalid date (2018-07-23)
		@Test(groups = {"All"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC95933_Xref_Invalid_xref_relation_when_EmployeeQualifier_length_greater_than_20_digits_charachter() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
		{
			// logger = extent.startTest("TC95933_Xref_Invalid_xref_relation_when_EmployeeQualifierr_length_greater_than_20_digits_charachter");  // adding method name info via logger
			 
			//Using Reusable method to load client json
             JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
			
			JSONObject jsonobject = (JSONObject) jsonarray.get(0);
			
			jsonobject.put("EmployeeQualifier", "EmployeeCustomIDEpmployyeIDSSN");
		

			String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

			//Using Assert to validate the expected result
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierformat);
		
		
		}


}
