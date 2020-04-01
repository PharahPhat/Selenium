/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Visit;

import java.io.FileNotFoundException;
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

public class R2267_TC91402_AltEVV_VisitCreation_LoadJson_with_Max_lengthexceed extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

// Case1: visit Load json with all fields value=Maximum Length+1, Record should be rejected.
	@Test(groups = {"All", "fixing"})
	public void R2267_TC91402_AltEVV_VisitCreation_LoadJson_with_all_fields_with_Max_lengthexceeds() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException{
		
		// logger = extent.startTest("R2267_TC91402_AltEVV_VisitCreation_LoadJson_with_all_fields_with_Max_lengthexceeds");
		logger.log(LogStatus.INFO, "Validating_VisitCreation_LoadJson_with_all_fields_with_Max_lengthexceed_+1"); 

		String sequenceid=CommonMethods.generateRandomNumberOfFixLength(17);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		
		jsonObjectVisit.put("VisitOtherID",CommonMethods.generateRandomNumberOfFixLength(51));
		jsonObjectVisit.put("PayerID",CommonMethods.generateRandomNumberOfFixLength(65));
		jsonObjectVisit.put("EmployeeOtherID",CommonMethods.generateRandomNumberOfFixLength(65));
		jsonObjectVisit.put("EmployeeIdentifier",CommonMethods.generateRandomNumberOfFixLength(10));	
		jsonObjectVisit.put("ClientOtherID",CommonMethods.generateRandomNumberOfFixLength(25));
		jsonObjectVisit.put("PayerProgram",CommonMethods.generateRandomAlphaNumeric(10));
		jsonObjectVisit.put("Modifier1",CommonMethods.generateRandomStringOfFixLength(3));
		jsonObjectVisit.put("Modifier2",CommonMethods.generateRandomStringOfFixLength(3));
		jsonObjectVisit.put("Modifier3",CommonMethods.generateRandomStringOfFixLength(3));
		jsonObjectVisit.put("Modifier4",CommonMethods.generateRandomStringOfFixLength(3));
		jsonObjectVisit.put("ProcedureCode",CommonMethods.generateRandomAlphaNumeric(6));
		jsonObjectVisit.put("Memo",CommonMethods.generateRandomStringOfFixLength(513));
		
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		
		jsonObjectVisitChanges.put("GroupCode",CommonMethods.generateRandomStringOfFixLength(7));
		
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);
		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.MaxExceedlength_error);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorVisitOtherIdLength);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorIdLength);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorIDFormat_AltEVV);
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorEmployeeOtherIDlength);
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorEmployeeIdentifierlength);
	
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.GroupCodeLengthError);
		
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorClientOtherIdLength);
		
	    CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.SequenceIDLengthError);
			
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorPayorProgramFormat);
			
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier1Length);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier2Length);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier3Length);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Modifier4LengthError);
			
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorProcedureCodelength);

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorMemolength);
			
	}
}
