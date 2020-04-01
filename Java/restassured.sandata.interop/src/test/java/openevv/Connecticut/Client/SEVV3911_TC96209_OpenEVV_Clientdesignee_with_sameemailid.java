package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class SEVV3911_TC96209_OpenEVV_Clientdesignee_with_sameemailid extends BaseTest{
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier Assertion_DbVerifier=new Assertion_DbVerifier();
	
	
	@Test(groups = {"All", "fixing"})
	@AdditionalInfo(module = "OpenEVV")

	public void TC96209_OpenEVV_Clientdesignee_with_sameemailid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC96209_OpenEVV_Clientdesignee_with_sameemailid");

		String Emailid=CommonMethods.generateEmailAddress_string(7);
		
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientDesigneeEmail", Emailid);	

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		Assertion_DbVerifier.jsonAssert_InboxClient_OpenEVV(bodyAsString, jsonObject);
}

}
