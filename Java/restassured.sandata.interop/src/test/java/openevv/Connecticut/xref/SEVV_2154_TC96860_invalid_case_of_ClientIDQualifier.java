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

public class SEVV_2154_TC96860_invalid_case_of_ClientIDQualifier extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the invalid ClientIDQualifier as blank
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void TC96860_Invalid_xref_relation_when_ClientIDQualifier_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC96858_Invalid_xref_relation_when_ClientIDQualifier_blank");  // adding method name info via logger
		 
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
		
		JSONObject jsonobject = (JSONObject) jsonarray.get(0);
		
		jsonobject.put("ClientIDQualifier", "");
	

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
	
	
	}
	//To validate the invalid ClientIDQualifier as more than 20 character
		@Test(groups = {"All"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC96860_Invalid_xref_relation_when_ClientIDQualifier_more_than_20character() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
		{
			// logger = extent.startTest("TC96858_Invalid_xref_relation_when_ClientIDQualifier_more_than_20character");  // adding method name info via logger
			 
			JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);
			
			JSONObject jsonobject = (JSONObject) jsonarray.get(0);
			
			jsonobject.put("ClientIDQualifier", CommonMethods.generateRandomStringOfFixLength(21));
		

			String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

			//Using Assert to validate the expected result
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);
		
		
		}

		//To validate the invalid ClientIDQualifier with space
		@Test(groups = {"All"})
		@AdditionalInfo(module = "OpenEVV")
		public void TC96860_Invalid_xref_relation_when_ClientIDQualifier_withspace() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
		{
			// logger = extent.startTest("TC96858_Invalid_xref_relation_when_ClientIDQualifier_withspace");  // adding method name info via logger

			JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

			JSONObject jsonobject = (JSONObject) jsonarray.get(0);

			jsonobject.put("ClientIDQualifier", CommonMethods.generateRandomStringOfFixLength(18)+" ");


			String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

			//Using Assert to validate the expected result
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientIDQualifierformaterror);


		}

}
