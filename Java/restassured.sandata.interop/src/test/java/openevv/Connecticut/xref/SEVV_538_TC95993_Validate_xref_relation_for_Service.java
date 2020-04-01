package openevv.Connecticut.xref;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SEVV_538_TC95993_Validate_xref_relation_for_Service extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the valid service code
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95993_Validate_xref_relation_when_Service_is_valid() throws InterruptedException, IOException, ParseException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC95993_Validate_xref_relation_when_Service_is_valid");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("Service", DataGeneratorClient.servicecodeList());

		//Using Assert to validate the expected result
		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	}

	//To validate the invalid service code
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95993_Invalid_xref_relation_when_Service_is_null() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC95993_Invalid_xref_relation_when_Service_is_null");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("Service", null);

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The Service cannot be null.");
	}

	//To validate the invalid service code
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95993_Invalid_xref_relation_when_Service_is_NULL() throws InterruptedException, IOException, ParseException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC95993_Invalid_xref_relation_when_Service_is_NULL");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("Service", "NULL");

		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

	}

	//To validate the invalid service code
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95993_Invalid_xref_relation_when_Service_is_Blank() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC95993_Invalid_xref_relation_when_Service_is_Blank");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("Service", "");

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The Service format is incorrect. The record should satisfy this regular expression");

	}

	//To validate the invalid service code
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95993_Invalid_xref_relation_when_Service_is_greaterthan_allowed_length() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC95993_Invalid_xref_relation_when_Service_is_greaterthan_allowed_length");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("Service", CommonMethods.generateRandomStringOfFixLength(13));

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The Service format is incorrect. The record should satisfy this regular expression");


	}

	//To validate the invalid service code
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95993_Invalid_xref_relation_when_Service_is_special_character() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC95993_Invalid_xref_relation_when_Service_is_special_character");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("Service", CommonMethods.generateSpecialChar(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The Service format is incorrect. The record should satisfy this regular expression");


	}

	//To validate the invalid service code
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95993_Invalid_xref_relation_when_Service_is_with_space() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC95993_Invalid_xref_relation_when_Service_is_with_space");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("Service", CommonMethods.generateRandomAlphaNumeric(3) + " " +CommonMethods.generateRandomStringOfFixLength(1));

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The Service format is incorrect. The record should satisfy this regular expression");


	}

	//To validate the invalid service code
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95993_validate_xref_relation_when_Service_is_invalid() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC95993_validate_xref_relation_when_Service_is_invalid(");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("Service", CommonMethods.generateRandomAlphaNumeric(13));

		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "ERROR: The Service format is incorrect.");


	}


}
