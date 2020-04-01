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

//Test Case 8488:Inter-Op: Verify that TelephonyPIN field is not accepting values with space


public class CR3368_TC95221_AltEVV_Visit_TelephonyPin_with_spaces extends BaseTest {

	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Case: Verify that TelephonyPIN field is not accepting values with spaces

	@Test(groups = {"All"})
	public void SEVV3368_TC95221_AltEVV_Visit_TelephonyPin_with_Leadingspaces() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{

		// logger = extent.startTest("SEVV3368_TC8488_AltEVV_Visit_TelephonyPin_with_Leadingspaces");
		logger.log(LogStatus.INFO, "Validating_Visit_Creation_TelephonyPin_with_leading_spaces_invalid");


		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.TelephonyPINjson, " "+CommonMethods.generateRandomNumberOfFixLength(8));

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.TelephonyPINjson, " "+CommonMethods.generateRandomNumberOfFixLength(8));

		CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		//Note: Field should not be processed with leading/trailing spaces as per latest Req doc(5.8).Issue noted.
	}

	@Test(groups = {"All"})

	public void SEVV3368_TC95221_AltEVV_Visit_TelephonyPin_with_trailingspaces() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{

		// logger = extent.startTest("SEVV3368_TC8488_AltEVV_Visit_TelephonyPin_with_trailingspaces");
		logger.log(LogStatus.INFO, "Validating_Visit_Creation_TelephonyPin_with_trailing_spaces_invalid"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.TelephonyPINjson, " "+CommonMethods.generateRandomNumberOfFixLength(8));

		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.TelephonyPINjson, CommonMethods.generateRandomNumberOfFixLength(8)+" ");

		CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		//Note: Field should not be processed with leading/trailing spaces as per latest Req doc(5.8).Issue noted.

	}
}

