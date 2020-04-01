package openevv.Connecticut.xref;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV_2154_TC96859_XRef_Json_for_valid_case_of_ClientIDQualifier extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();



	//To validate the valid ClientIDQualifier valid cases
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96859_Validate_the_XRef_valid_case_of_ClientIDQualifier() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96859_Validate_the_XRef_valid_case_of_ClientIDQualifier");  // adding method name info via logger
		String[] ClientQualifier= {"ClientID","ClientSSN","ClientOtherID","ClientCustomID"};

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientIDQualifier",ClientQualifier[0] );
		jsonobject.put("ClientID",CommonMethods.generateRandomNumberOfFixLength(5) );

		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));


		Thread.sleep(5000);

		jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientIDQualifier",ClientQualifier[1] );
		jsonobject.put("ClientID",CommonMethods.generateRandomNumberOfFixLength(5) );

		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Thread.sleep(5000);

		jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientIDQualifier",ClientQualifier[2] );
		jsonobject.put("ClientID",CommonMethods.generateRandomNumberOfFixLength(5) );

		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		Thread.sleep(5000);

		jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientIDQualifier",ClientQualifier[3] );
		jsonobject.put("ClientID",CommonMethods.generateRandomNumberOfFixLength(5) );

		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	}
}
