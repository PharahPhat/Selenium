package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV3911_TC96193_OpenEVV_ClientDesignee_SameEmail_In_Different_Request extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "fixing"})
	public void TC96193_OpenEVV_ClientDesignee_SameEmail_In_Different_Request() throws InterruptedException, IOException, ParseException{
		String emailId=CommonMethods.generateEmailAddress_string(7);
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientDesigneeEmail", emailId);

		CommonMethods.verifyPostResponseOPENEVV(jsonArray, 
				CommonMethods.propertyfileReader(globalVariables.openevv_client_url), 
				CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientDesigneeEmail", emailId);

		String bodyAsString = CommonMethods.captureGetResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.openevv_client_url), 
				CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		CommonMethods.verifyJsonPassCase(bodyAsString);
	}
}
