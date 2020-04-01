package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Anupam
 */
//Test Case 96856: Open EVV Client- Validate the client Json for invalid case of ClientDesigneeEndDate (Refer the steps for scenario)

public class R2154_TC96854_OpenEVV_ClientDesigneeStartDate_invalid extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	//Case1: ClientDesigneeEndDate= mm-dd-yyyy  ex :-- 10-29-2018
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96856_OpenEVV_ClientDesigneeEndDate_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96856_OpenEVV_ClientDesigneeEndDate_invalid");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientDesigneeEndDate", 10-29-2018);	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientDesigneeEndDateformaterror);

	}
	//Case2: ClientDesigneeEndDate= dd-mm-yyyy  ex :-- 10-05-2018
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96856_OpenEVV_ClientDesigneeEndDate_ddmmyyyy_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2154_TC96856_OpenEVV_ClientDesigneeEndDate_ddmmyyyy_invalid");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientDesigneeEndDate", 10-05-2018);	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientDesigneeEndDateformaterror);

	}
	//Case3:ClientDesigneeEndDate= dd-yyyy-mm  ex :-- 05-2018-10
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96856_OpenEVV_ClientDesigneeEndDate_ddyyyymm_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2154_TC96856_OpenEVV_ClientDesigneeEndDate_ddyyyymm_invalid");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientDesigneeEndDate", 05-2018-10);	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientDesigneeEndDateformaterror);

	}

}