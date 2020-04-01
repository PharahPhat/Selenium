package openevv.Connecticut.xref;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_538_TC95986_Validate_xref_relation_when_EmployeeID_Valid_Invalid extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the invalid employee_id
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95986_Invalid_xref_relation_when_EmployeeID_length_greaterthan_10_Integer() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC95986_Invalid_xref_relation_when_EmployeeID_length_greaterthan_10_Integer");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeeID", CommonMethods.generateRandomNumberOfFixLength(11));


		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIDformateerror);


	}

	//To validate the valid employee_id
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95986_valid_xref_relation_when_EmployeeID_is_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC95986_valid_xref_relation_when_EmployeeID_is_valid");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeeID", CommonMethods.generateRandomNumberOfFixLength(5));



		//Using Assert to validate the expected result
		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));



	}

	//To validate the invalid employee_id
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95986_Invalid_xref_relation_when_EmployeeID_charachter_only() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC95986_Invalid_xref_relation_when_EmployeeID_charachter_only");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeeID", "abcdefhyui");


		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIDformateerror);
	}

	//to validate invalid employee_id
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95986_Invalid_xref_relation_when_EmployeeID_with_specail_charachter() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC95986_Invalid_xref_relation_when_EmployeeID_with_specail_charachter");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeeID", "9#@0923");


		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIDformateerror);
	}


	//To validate the invalid employee_id
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95986_Invalid_xref_relation_when_EmployeeID_with_leading_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC95986_Invalid_xref_relation_when_EmployeeID_with_leading_space");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeeID", " 987654321");


		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIDformateerror);
	}


	//To validate the invalid employee_id
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95986_Invalid_xref_relation_when_EmployeeID_with_trailing_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC95986_Invalid_xref_relation_when_EmployeeID_with_trailing_space");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("EmployeeID", "987654321 ");


		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeIDformateerror);
	}



}
