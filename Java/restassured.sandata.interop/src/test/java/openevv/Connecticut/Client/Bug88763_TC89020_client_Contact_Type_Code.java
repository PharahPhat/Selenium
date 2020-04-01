package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class Bug88763_TC89020_client_Contact_Type_Code extends BaseTest
{
	private Assertion_DbVerifier assertionDbVerifier=new Assertion_DbVerifier();
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void Bug88763_TC89020_client_Contact_Type_Code_validation() throws InterruptedException, IOException, ParseException,
			SQLException, ClassNotFoundException, java.text.ParseException{

		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("ClientDesigneeStatus", "02");
		String bodyAsString = CommonMethods.verifyPostResponseOPENEVV(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.openevv_client_url),
				CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject);
	}
}
