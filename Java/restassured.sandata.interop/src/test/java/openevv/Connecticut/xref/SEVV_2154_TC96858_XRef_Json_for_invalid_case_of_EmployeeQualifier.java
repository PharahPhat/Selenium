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

public class SEVV_2154_TC96858_XRef_Json_for_invalid_case_of_EmployeeQualifier extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the invalid EmployeeQualifier as blank
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void TC96858_Invalid_xref_relation_when_EmployeeQualifier_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC96858_Invalid_xref_relation_when_EmployeeQualifier_blank");  // adding method name info via logger
		 
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		
		jsonobject.put("EmployeeQualifier", "");
	

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierFormatError);
	
	
	}
	//To validate the invalid EmployeeQualifier as more than 20 character
		@Test(groups = {"All"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC96858_Invalid_xref_relation_when_EmployeeQualifier_more_than_20character() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
		{
			// logger = extent.startTest("TC96858_Invalid_xref_relation_when_EmployeeQualifier_more_than_20character");  // adding method name info via logger
			 
			JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
			
			JSONObject jsonobject = (JSONObject) jsonarray.get(0);
			
			jsonobject.put("EmployeeQualifier", CommonMethods.generateRandomStringOfFixLength(21));
		

			String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

			//Using Assert to validate the expected result
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierFormatError);
		
		
		}
		
	
				//To validate the invalid EmployeeQualifier as more than 20 character
				@Test(groups = {"All"})
				@AdditionalInfo(module = "OpenEVV")
				public void TC96858_Invalid_xref_relation_when_EmployeeQualifier_withspace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
				{
					// logger = extent.startTest("TC96858_Invalid_xref_relation_when_EmployeeQualifier_withspace");  // adding method name info via logger
					 
					JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
					
					JSONObject jsonobject = (JSONObject) jsonarray.get(0);
					
					jsonobject.put("EmployeeQualifier", CommonMethods.generateRandomStringOfFixLength(18)+" ");
				

					String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

					//Using Assert to validate the expected result
					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeQualifierFormatError);
				
				
				}
}
