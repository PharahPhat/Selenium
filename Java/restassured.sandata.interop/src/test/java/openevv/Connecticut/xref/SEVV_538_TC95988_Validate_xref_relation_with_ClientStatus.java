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
import java.sql.SQLException;

public class SEVV_538_TC95988_Validate_xref_relation_with_ClientStatus extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the invalid ClientStatus
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void TC95988_Invalid_xref_relation_when_ClientStatus_less_than_2_digits() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC95988_Invalid_xref_relation_when_ClientStatus_less_than_2_digits");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientStatus", "1");


		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.DeleteStatusFormatError1);


	}

	//To validate the invalid ClientStatus
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95988_Invalid_xref_relation_when_ClientStatus_other_than_allowed() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC95988_Invalid_xref_relation_when_ClientStatus_other_than_allowed");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientStatus", "05");


		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.DeleteStatusFormatError1);


	}

	//To validate the invalid ClientStatus
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95988_Invalid_xref_relation_when_ClientStatus_morethan_allowed_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC95988_Invalid_xref_relation_when_ClientStatus_morethan_allowed_length");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientStatus", "012");


		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.DeleteStatusFormatError1);


	}

	//To validate the invalid ClientStatus
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95988_Invalid_xref_relation_when_ClientStatus_with_space() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC95988_Invalid_xref_relation_when_ClientStatus_with_space");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientStatus", " 02");


		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.DeleteStatusFormatError1);


	}

	//To validate the valid ClientStatus
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95988_validate_xref_relation_when_ClientStatus_is_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC95988_validate_xref_relation_when_ClientStatus_is_valid");  // adding method name info via logger

		//Using Reusable method to load client json


		//Making json values dynamic
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientStatus", "02");



		//Using Assert to validate the expected result
		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));



	}
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95988_validate_xref_relation_when_ClientStatus_is_valid2() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC95988_validate_xref_relation_when_ClientStatus_is_valid");  // adding method name info via logger

		//Using Reusable method to load client json


		//Making json values dynamic
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientStatus", "04");



		//Using Assert to validate the expected result
		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
		CommonMethods.verifyjsonassertpasscase(bodyAsString);


	}


}
