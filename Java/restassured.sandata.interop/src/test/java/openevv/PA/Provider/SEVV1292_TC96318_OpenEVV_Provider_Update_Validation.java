package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV1292_TC96318_OpenEVV_Provider_Update_Validation extends BaseTest {

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC96318_OpenEVV_Provider_Update_Validation() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96311_OpenEVV_Provider_SuspensionDate_null");

		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVVupdateValue(globalVariables.openevv_provider_json);

		CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url),
				CommonMethods.propertyfileReader(globalVariables.provider_get_url));
	}
}
