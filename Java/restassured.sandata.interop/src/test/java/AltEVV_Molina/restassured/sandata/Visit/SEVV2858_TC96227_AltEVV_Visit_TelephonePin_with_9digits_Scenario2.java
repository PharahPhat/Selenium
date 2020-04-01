/**
 * 
 */
package AltEVV_Molina.restassured.sandata.Visit;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
// Test Case 95264:Inter-Op: Verify that TelephonyPin field is accepting values = 9 digits

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV2858_TC96227_AltEVV_Visit_TelephonePin_with_9digits_Scenario2 extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Case: Verify that TelephonyPin field is accepting values = 9 digits
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96227_AltEVV_Visit_TelephonePin_with_9digits() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
	
	// logger = extent.startTest("SEVV2858_TC96227_AltEVV_Visit_TelephonePin_with_9digits");
	logger.log(LogStatus.INFO, "Validating_Visit_Creation_TelephonePin_with_9digit_validlength"); 
	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
     String tpin=CommonMethods.generateRandomNumberOfFixLength(9);
	JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
	JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
	jsonObjectVisitChanges.put(globalVariables.TelephonyPINjson, tpin);

	JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
	jsonObjectVisitChanges_call.put(globalVariables.TelephonyPINjson, tpin);

	CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}
}
