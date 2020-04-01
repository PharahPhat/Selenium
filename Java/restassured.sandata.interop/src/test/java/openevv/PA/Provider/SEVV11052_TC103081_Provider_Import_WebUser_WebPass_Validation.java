package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.Constant_SQL;
import com.globalMethods.core.DataBaseVerifier;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV11052_TC103081_Provider_Import_WebUser_WebPass_Validation extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	private DataBaseVerifier dataBaseVerifier= new DataBaseVerifier();
	private Constant_SQL Constant_SQL=new Constant_SQL();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "ProviderImport")
	public void TC103092_Provider_Import_WebUser_Validation() throws InterruptedException, java.text.ParseException,
			IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC103092_Provider_Import_WebUser_Validation");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		String bodyAsString = CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
		
		Map<String,String> DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.getAccountFromProvider,
				jsonObject.get(globalVariables.ProviderID).toString()));

	
		assertionDbVerifier.jsonAssert_stx_Accounts_Web(bodyAsString, globalVariables.Account);
	}

}
