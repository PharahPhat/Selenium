package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class Bug_5122_TC97130_OpenEVV_PayerID_validation extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC97130_OpenEVV_PayerID_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC97130_OpenEVV_PayerID_blank");

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("PayerID", " ");	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.openevv_client_url));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorIDFormat_AltEVV);

	}

}
