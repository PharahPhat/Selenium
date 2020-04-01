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

//Test Case 88269:Open EVV - Fully Populated Client

public class TC88269_Client_Fully_Populated_Client extends BaseTest
{	
	private Assertion_DbVerifier assertionDbVerifier=new Assertion_DbVerifier();
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the Fully Populated Client with valid json
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV") 
	public void TC88269_OpenEVV_Client_Fully_Populated_valid_case_DB() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC88269_OpenEVV_Client_Fully_Populated_valid_case_DB");

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_OpenEVV(globalVariables.client_openevv);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsString, jsonObject);	


	}
}