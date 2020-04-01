package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.ohio.intake.patient.v2.GlobalVariable_V2;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV_6926_TC103261_OpenEVV_Provider_PrimaryContactFirstName_Lastname_Stored_in_Database extends BaseTest{

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC103261_OpenEVV_Provider_PrimaryContactFirstName_Lastname_Stored_in_Database() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
	// logger = extent.startTest("TC103261_OpenEVV_Provider_PrimaryContactFirstName_Lastname_Stored_correctly_in_Database");
	
	JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);

	jsonObject.put(globalVariables.PrimaryContactLastName, CommonMethods.generateRandomStringOfFixLength(11));
	
	jsonObject.put(globalVariables.PrimaryContactFirstName, CommonMethods.generateRandomStringOfFixLength(9));

	String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));
	
	logger.log(LogStatus.INFO, GlobalVariable_V2.DBVerify);
	
	assertionDbVerifier.jsonAssert_inbox_Provider(bodyAsString, jsonObject);
	
	assertionDbVerifier.jsonAssert_stx_Accounts_info(bodyAsString, jsonObject);
	
	assertionDbVerifier.jsonAssert_stx_stxAccouts_interfaces(bodyAsString, jsonObject);
	
}

}
