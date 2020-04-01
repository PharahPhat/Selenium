/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Visit;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
// Test Case 8503:Inter-Op: Verify that TelephonyPin field is not accepting values more than 9 digits


public class CR3368_TC95262_AltEVV_Visit_TelephonePin_more_than_9digits extends BaseTest {
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Case: Verify that TelephonyPin field is not accepting values more than 9 digits
	
	@Test(groups = {"All"})
	public void SEVV3368_TC95262_AltEVV_Visit_TelephonePin_more_than_9digit() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
	
	// logger = extent.startTest("SEVV3368_TC8503_AltEVV_Visit_TelephonePin_more_than_9digit");
	logger.log(LogStatus.INFO, "Validating_Visit_Creation_TelephonePin_with_more_than_9digit_invalidlength"); 
	
	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

	JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
	JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
	jsonObjectVisitChanges.put(globalVariables.TelephonyPINjson,CommonMethods.generateRandomNumberOfFixLength(10));

	JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
	jsonObjectVisitChanges_call.put(globalVariables.TelephonyPINjson, CommonMethods.generateRandomNumberOfFixLength(10));


	String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	
	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.TelephonyPINFormatError);

	
	
	
}
}
