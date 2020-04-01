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

public class R2154_TC96846_ClientBirthDate_valid extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96846_ClientBirthDate_valid_with_pastdate() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("R2154_TC96846_ClientBirthDate_valid_with_pastdate");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientBirthDate", CommonMethods.generatePastDate_MMddYYYY());	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
	}
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void R2154_TC96846_ClientBirthDate_valid_with_null() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("R2154_TC96846_ClientBirthDate_valid_with_null");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientBirthDate", null);

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
	}

}
