package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

//Test Case 91096:OpenEVV-altEVV- Client Payer: Validate (mix) - PayerID field formats/values

public class R679_TC95746_AltEVV_ClientEligibilityDate_Start_End_except_payer extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void R679_TC95746_AltEVV_ClientEligibilityDate_Start_End_invalid() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("R679_TC88493_AltEVV_ClientEligibilityDate_Start_End_invalid");
		logger.log(LogStatus.INFO, "R679_TC88493_AltEVV_ClientEligibilityDate_Start_End_invalid");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		jsonObject1.put("ClientStatus", "02");
		jsonObject1.put("ClientEligibilityDateBegin", null);
		jsonObject1.put("ClientEligibilityDateEnd", null);
		
		
		JSONObject jsonObject2= (JSONObject) jsonArray1.get(1);
		jsonObject2.put("ClientStatus", "02");
		jsonObject2.put("ClientEligibilityDateBegin", null);
		jsonObject2.put("ClientEligibilityDateEnd",  null);
		
		
		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}
}