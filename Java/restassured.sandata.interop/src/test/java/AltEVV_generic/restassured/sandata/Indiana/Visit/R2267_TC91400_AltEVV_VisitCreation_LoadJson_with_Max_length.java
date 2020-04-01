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

/**
 * @author Anupam
 */

public class R2267_TC91400_AltEVV_VisitCreation_LoadJson_with_Max_length extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	// Case1: visit Load json with all fields value=Maximum Length, Record should be created.
	@Test(groups = {"All"})
	public void R2267_TC91400_AltEVV_VisitCreation_LoadJson_with_Maxlength() throws InterruptedException, IOException,
			ParseException {

		// logger = extent.startTest("R2267_TC91400_AltEVV_VisitCreation_LoadJson_with_Maxlength");
		logger.log(LogStatus.INFO, "Validating_VisitCreation_LoadJson_with_all_fields_with_Maxlength"); 

		String sequenceid=CommonMethods.generateRandomNumberOfFixLength(10);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateRandomNumberOfFixLength(50));
		jsonObjectVisit.put("SequenceID",CommonMethods.generateRandomNumberOfFixLength(16));
		jsonObjectVisit.put("EmployeeQualifier","EmployeeRegID");
		// PayerID value will not accept randomly generated value as per latest req specification 7.1x.
		
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCallIn =  (JSONObject) jsonArrayVisitCalls.get(0);
		
		JSONObject jsonObjectVisitCallOut =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCallOut.put(globalVariables.CallAssignmentjson, "Time Out");
		String cid=CommonMethods.generateRandomNumberOfFixLength(16);
		jsonObjectVisitCallIn.put(globalVariables.CallExternalIDjson, cid);
		jsonObjectVisitCallOut.put(globalVariables.CallExternalIDjson, cid);
		  String clid=CommonMethods.generateRandomNumberOfFixLength(10);
		jsonObjectVisitCallIn.put(globalVariables.ClientIdentifierOnCalljson,clid);
		jsonObjectVisitCallOut.put(globalVariables.ClientIdentifierOnCalljson,clid);
		String cidmax=CommonMethods.generateRandomNumberOfFixLength(10);
		jsonObjectVisitCallIn.put(globalVariables.OriginatingPhoneNumberjson,cidmax );
		jsonObjectVisitCallOut.put(globalVariables.OriginatingPhoneNumberjson, cidmax);
		
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);
		
		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
}
