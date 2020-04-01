package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TC95140_Openevv_Client_Endpoint_Saved_in_DB extends BaseTest { private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	

	//To validate the -Client-Load-Maximum Value with valid json
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC95140_Validate_Openevv_Client_data_with_endpoint_Saved_in_DB() throws InterruptedException,  IOException, ParseException,  SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC95140_Validate_Openevv_Client_data_with_endpoint_Saved_in_DB");
		//use method (json_parser) to load the json file
		// To make the values in JSON dynamic
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_OpenEVV(globalVariables.client_openevv);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject);	

	}

}
