package openevv.Connecticut.xref;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SEVV_TC96869_Xref_ClientStatus_valid extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();


	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "Client Xref")
	public void SEVV_TC96869_Validate_XRef_ClientStatus_Active_valid() throws IOException, ParseException, InterruptedException
	{
		// logger = extent.startTest("SEVV_2154_TC96869_Validate_XRef_ClientStatus_Active_valid");  // adding method name info via logger

		//Using Reusable method to load client json

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientStatus", "02");

		//Using Assert to validate the expected result
		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	}


	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "Client Xref")
	public void SEVV_TC96869_Validate_XRef_ClientStatus_Hold_valid() throws IOException, ParseException, InterruptedException
	{
		// logger = extent.startTest("SEVV_2154_TC96869_Validate_XRef_ClientStatus_Hold_valid");  // adding method name info via logger

		//Using Reusable method to load client json

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientStatus", "03");

		//Using Assert to validate the expected result
		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	}

	@Test(enabled = false, groups = {"All"})
	public void SEVV_TC96869_Validate_XRef_ClientStatus_inactive_valid() throws IOException, ParseException, InterruptedException
	{
		// logger = extent.startTest("SEVV_2154_TC96869_Validate_XRef_ClientStatus_inactive_valid");  // adding method name info via logger

		//Using Reusable method to load client json

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientStatus", "04");

		//Using Assert to validate the expected result
		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	}

	@Test(groups = {"All"})
	public void SEVV_TC96869_Validate_XRef_ClientStatus_pending_valid() throws IOException, ParseException, InterruptedException
	{
		// logger = extent.startTest("SEVV_2154_TC96869_Validate_XRef_ClientStatus_pending_valid");  // adding method name info via logger

		//Using Reusable method to load client json

		JSONArray jsonarray=GenerateUniqueParam.XrefParams(globalVariables.xref_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("ClientStatus", "01");

		//Using Assert to validate the expected result
		CommonMethods.validateResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.openevv_xref_url));
	}
}
