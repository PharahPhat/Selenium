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
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
// Test Case 95263:Inter-Op: Verify that TelephonyPin field is not accepting values less than 0 or in -

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV2858_TC96227_AltEVV_Visit_TelephonePin_less_than_0_or_negative_Scenario3 extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Case: Verify that TelephonyPin field is not accepting values less than 0 or in  -
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96227_AltEVV_Visit_TelephonePin_with_invalidvalue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
	
	// logger = extent.startTest("SEVV2858_TC96227_AltEVV_Visit_TelephonePin_with_invalidvalue");
	logger.log(LogStatus.INFO, "Validating_Visit_Creation_TelephonePin_with_0_or_negativevalue"); 

	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

	JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
	JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
	jsonObjectVisitChanges.put(globalVariables.TelephonyPINjson,"-"+CommonMethods.generateRandomNumberOfFixLength(4));

	JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
	jsonObjectVisitChanges_call.put(globalVariables.TelephonyPINjson,"-"+ CommonMethods.generateRandomNumberOfFixLength(4));


	String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	
	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.TelephonyPINNegativeError);

	
}
}
