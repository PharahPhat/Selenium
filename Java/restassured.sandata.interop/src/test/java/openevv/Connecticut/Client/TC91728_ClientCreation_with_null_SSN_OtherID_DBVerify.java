package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

//Test Case 91728:Inter-op : Open EVV - Client - Validate the Client creation with "null" ClientSSN and ClientOtherID

public class TC91728_ClientCreation_with_null_SSN_OtherID_DBVerify extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC91728_OpenEVV_invalid_ClientSSN_db_verify() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("TC91728_OpenEVV_invalid_ClientSSN_db_verify");

		JSONArray j=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject js = (JSONObject) j.get(0);

		js.put("ClientSSN", null);
		
		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
	}
	
}