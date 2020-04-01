package openevv.Connecticut.xref;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV_538_TC95994_Validate_xref_relation_when_XRefStartDate_Valid_Invalid extends BaseTest { 
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


//To validate the invalid Xref end date with invalid date (2018-07-23)
@Test(groups = {"All", "fixing"})
@AdditionalInfo(module = "OpenEVV")
public void TC95994_Validate_xref_relation_when_XRefStartDate_Invalid_2018_07_23() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
{
	// logger = extent.startTest("TC95997_Validate_xref_relation_when_XRefStartDate_Invalid_2018_07_23");  // adding method name info via logger

	//Using Reusable method to load client json
	JSONArray j=GenerateUniqueParam.XrefParams(globalVariables.openevv_xref_url);

	//Making json values dynamic

	JSONObject js = (JSONObject) j.get(0);
	js.put("XRefStartDate","2018-07-23");
	js.put("XRefEndDate", CommonMethods.generateTodayDate_MMddyyyy());


	String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

	//Using Assert to validate the expected result


	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
	Assert.assertTrue(bodyAsString.contains("ERROR: The XRefStartDate format is incorrect."));
}

//To validate the invalid Xref end date with invalid format ("07/23/2018")
@Test(groups = {"All", "fixing"})
@AdditionalInfo(module = "OpenEVV")
public void TC95994_Validate_xref_relation_when_XRefStartDate_Invalid_case2() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
{
	// logger = extent.startTest("TC95997_Validate_xref_relation_when_XRefStartDate_Invalid_format_07/23/2018");  // adding method name info via logger


	//Using Reusable method to load client json
	JSONArray j=GenerateUniqueParam.XrefParams(globalVariables.openevv_xref_url);

	//Making json values dynamic

	JSONObject js = (JSONObject) j.get(0);
	js.put("XRefStartDate", "07/23/2018");
	js.put("XRefEndDate", CommonMethods.generateTodayDate_MMddyyyy());

	String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
	Assert.assertTrue(bodyAsString.contains("ERROR: The XRefStartDate format is incorrect."));
}

//To validate the invalid Xref end date with invalid format "07-23-2018" 
@Test(groups = {"All", "fixing"})
@AdditionalInfo(module = "OpenEVV")
public void TC95994_Validate_xref_relation_when_XRefStartDate_Invalid_format_case3() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
{
	// logger = extent.startTest("TC95997_Validate_xref_relation_when_XRefStartDate_Invalid_format_07-23-2018");  // adding method name info via logger


	//Using Reusable method to load client json
	JSONArray j=GenerateUniqueParam.XrefParams(globalVariables.openevv_xref_url);

	//Making json values dynamic

	JSONObject js = (JSONObject) j.get(0);
	js.put("XRefStartDate", "07-23-2018");
	js.put("XRefEndDate", CommonMethods.generateTodayDate_MMddyyyy());

	String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));


	Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
	Assert.assertTrue(bodyAsString.contains("ERROR: The XRefStartDate format is incorrect."));
}

//To validate the valid end date
@Test(groups = {"All", "fixing"})
@AdditionalInfo(module = "OpenEVV")
public void TC95994_Validate_xref_relation_when_XRefStartDate_valid_in_inbox_and_stx_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, java.text.ParseException, SQLException, ClassNotFoundException
{
	// logger = extent.startTest("TC95994_Validate_xref_relation_when_XRefStartDate_valid_inbox_and_stx_DB"); // adding method name info via logger

	//Using Reusable method to load client json
	JSONArray j=GenerateUniqueParam.XrefParams(globalVariables.openevv_xref_url);

	JSONObject js = (JSONObject) j.get(0);

	js.put("XRefEndDate", CommonMethods.generateTodayDate_MMddyyyy());
	js.put("XRefStartDate", CommonMethods.generatePastDate_MMddYYYY());

	String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));



}




}
