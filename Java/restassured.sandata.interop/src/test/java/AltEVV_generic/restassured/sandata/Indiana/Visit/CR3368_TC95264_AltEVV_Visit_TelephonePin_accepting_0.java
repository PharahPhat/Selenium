/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
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
// Test Case 8490:Inter-Op: Verify that TelephonyPIN field accepting values "0"

public class CR3368_TC95264_AltEVV_Visit_TelephonePin_accepting_0 extends BaseTest {
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	//Case: Verify that TelephonyPIN field accepting values "0"
	
	@Test(groups = {"All"})
	public void TC95264_AltEVV_Visit_TelephonePin_accepting_0() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
	
	// logger = extent.startTest("TC95264_AltEVV_Visit_TelephonePin_accepting_0");
	logger.log(LogStatus.INFO, "Validating_Visit_Creation_TelephonePin_accepting_0"); 

	JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
	JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

	JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
	JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
	jsonObjectVisitChanges.put(globalVariables.TelephonyPINjson, 00000);

	JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
	jsonObjectVisitChanges_call.put(globalVariables.TelephonyPINjson, 00000);

	CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
}
