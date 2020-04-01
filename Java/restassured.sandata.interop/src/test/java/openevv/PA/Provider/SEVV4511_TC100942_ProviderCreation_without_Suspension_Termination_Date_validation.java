package openevv.PA.Provider;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class SEVV4511_TC100942_ProviderCreation_without_Suspension_Termination_Date_validation extends BaseTest{

	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC100942_ProviderCreation_without_Suspension_Termination_Date_Valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC100942_ProviderCreation_without_Suspension_Termination_Date_Valid");
		logger.log(LogStatus.INFO, "TC100942_ProviderCreation_without_Suspension_Termination_Date_Valid");
		
		JSONArray jsonArray = GenerateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);
	
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.remove(globalVariables.SuspensionDate);
		
		jsonObject.remove(globalVariables.TerminationDate);
		
				
		String bodyAsString = CommonMethods.captureResponseIndiana_Provider(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.provider_post_url));
		
		jsonObject.put(globalVariables.ProviderDateBegin, null);
		jsonObject.put(globalVariables.providertaxonomy, null);
		jsonObject.put(globalVariables.SuspensionDate,  null);
		jsonObject.put(globalVariables.TerminationDate, null);
		 
		assertionDbVerifier.jsonAssert_inbox_ProviderSpec7(bodyAsString, jsonObject);
		
	}
	

}
