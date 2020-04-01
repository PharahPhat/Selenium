/**
 * 
 */
package AltEVV_Molina.restassured.sandata.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Anupam
 */
// Test Case 95228:Inter-Op: Verify that TelephonyPIN field is not accepting values with '.'

public class SEVV2858_TC96227_AltEVV_Visit_TelephonyPin_with_dot_invalid_Scenario5 extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Case: Verify that TelephonyPIN field is not accepting values with  '.'
	
	@Test(groups = {"All"})
	public void SEVV2858_TC96227_AltEVV_Visit_TelephonyPin_with_dot_Invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
	
	// logger = extent.startTest("SEVV2858_TC96227_AltEVV_Visit_TelephonyPin_with_dot_Invalid");
	logger.log(LogStatus.INFO, "Validating_Visit_Creation_TelephonyPin_with_dot_invalid"); 
	
	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

	JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
	JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
	jsonObjectVisitChanges.put(globalVariables.TelephonyPINjson,CommonMethods.generateRandomNumberOfFixLength(4)+"."+CommonMethods.generateRandomNumberOfFixLength(4));

	JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
	jsonObjectVisitChanges_call.put(globalVariables.TelephonyPINjson, CommonMethods.generateRandomNumberOfFixLength(4)+"."+CommonMethods.generateRandomNumberOfFixLength(4));


	CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	
}
}
