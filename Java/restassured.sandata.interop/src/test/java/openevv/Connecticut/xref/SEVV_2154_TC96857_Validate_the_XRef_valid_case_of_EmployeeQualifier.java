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

public class SEVV_2154_TC96857_Validate_the_XRef_valid_case_of_EmployeeQualifier extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


	//To validate the valid EmployeeQualifier valid cases
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96857_Validate_the_XRef_valid_case_of_EmployeeQualifier_EmployeeSSN() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96857_Validate_the_XRef_valid_case_of_EmployeeQualifier_EmployeeSSN");  // adding method name info via logger
			JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

			JSONObject jsonobject = (JSONObject) jsonarray.get(0);

			jsonobject.put("EmployeeQualifier","EmployeeSSN" );
			jsonobject.put("ClientID",CommonMethods.generateRandomNumberOfFixLength(5) );

			//Using Assert to validate the expected result
			CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96857_Validate_the_XRef_valid_case_of_EmployeeQualifier_EmployeeRegID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96857_Validate_the_XRef_valid_case_of_EmployeeQualifier_EmployeeRegID");  // adding method name info via logger
	
			JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

			JSONObject jsonobject = (JSONObject) jsonarray.get(0);

			jsonobject.put("EmployeeQualifier","EmployeeRegID" );
			jsonobject.put("ClientID",CommonMethods.generateRandomNumberOfFixLength(5) );

			//Using Assert to validate the expected result
			CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96857_Validate_the_XRef_valid_case_of_EmployeeQualifier_EmployeeCustomID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96857_Validate_the_XRef_valid_case_of_EmployeeQualifier_EmployeeCustomID");  // adding method name info via logger

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

			JSONObject jsonobject = (JSONObject) jsonarray.get(0);

			jsonobject.put("EmployeeQualifier","EmployeeCustomID" );
			jsonobject.put("ClientID",CommonMethods.generateRandomNumberOfFixLength(5) );

			//Using Assert to validate the expected result
			CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		}

	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96857_Validate_the_XRef_valid_case_of_EmployeeQualifier_EmployeePIN() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96857_Validate_the_XRef_valid_case_of_EmployeeQualifier_EmployeePIN");  // adding method name info via logger
	
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

			JSONObject jsonobject = (JSONObject) jsonarray.get(0);

			jsonobject.put("EmployeeQualifier","EmployeePIN" );
			jsonobject.put("ClientID",CommonMethods.generateRandomNumberOfFixLength(5) );

			//Using Assert to validate the expected result
			CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		}

}
