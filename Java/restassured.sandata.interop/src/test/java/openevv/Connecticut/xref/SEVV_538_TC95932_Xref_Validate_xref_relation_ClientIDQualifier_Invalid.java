package openevv.Connecticut.xref;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV_538_TC95932_Xref_Validate_xref_relation_ClientIDQualifier_Invalid extends BaseTest {

	//To validate the invalid ClientIDQualifier
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95932_Invalid_xref_relation_when_ClientIDQualifier_other_than_ClientID_ClientSSN_ClientOtherID_ClientCustomID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, ClassNotFoundException, SQLException, java.text.ParseException
	{
		// logger = extent.startTest("TC95997_invalid_xref_relation_when_when ClientIDQualifier is 'ClientIDK' ");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientIDQualifier", "ClientIDK");


		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientidQualifierFormatError);

	}

	//To validate the invalid ClientIDQualifier
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95932_Invalid_xref_relation_when_ClientIDQualifier_other_than_ClientID_ClientSSN_ClientOtherID_ClientCustomID_1() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC95932_Invalid_xref_relation_when_when ClientIDQualifier is 'ClientSVN' ");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientIDQualifier", "ClientSVN");


		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientidQualifierFormatError);


	}

	//To validate the invalid ClientIDQualifier
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95932_Invalid_xref_relation_when_ClientIDQualifier_other_than_ClientID_ClientSSN_ClientOtherID_ClientCustomID_2() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{
		// logger = extent.startTest("TC95932_Invalid_xref_relation_when_when ClientIDQualifier is 'ClientID|ClientSSN|ClientOtherID|ClientCustomID' ");  // adding method name info via logger

		//Using Reusable method to load client json
		JSONArray j=CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_xref_json);

		//Making json values dynamic

		JSONObject js = (JSONObject) j.get(0);
		js.put("ClientIDQualifier", "ClientID|ClientSSN|ClientOtherID|ClientCustomID");


		String bodyAsString = CommonMethods.capturePostResponse(j,
			CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));

		//Using Assert to validate the expected result
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientidQualifierFormatError);


	}




}
