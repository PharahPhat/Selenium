package AltEVV_Molina.restassured.sandata.Visit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

import com.globalMethods.core.Assertion_DbVerifier; public class SEVV2858_TC96228_AltEVV_Visit_Required_field_except_GeneralSegment_scenario3 extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void SEVV2858_TC96228_AltEVV_with_required_field_except_generalinfosegment_invalid() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException{

		// logger = extent.startTest("SEVV2858_TC96228_AltEVV_with_required_field_except_generalinfosegment_invalid");

		logger.log(LogStatus.INFO, "Validating SEVV2858_TC96228_AltEVV_with_required_field_except_generalinfosegment_invalid"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.VisitOtherIDjson, DataGeneratorVisit.generateVisitOtherID(10));
		jsonObjectVisit.put(globalVariables.SequenceIDjson,DataGeneratorVisit.generateSequenceID(10) );
		jsonObjectVisit.put(globalVariables.EmployeeIdentifier,DataGeneratorVisit.generateEmployeeIdentifier(10));
		jsonObjectVisit.put(globalVariables.ClientIdentifierjson,DataGeneratorVisit.generateClientIdentifier(10));
		jsonObjectVisit.put(globalVariables.VisitCancelledIndicatorjson, false);
		jsonObjectVisit.put(globalVariables.PayerIDjson, DataGeneratorVisit.generatePayerID(5));
		jsonObjectVisit.put(globalVariables.PayerProgramjson,DataGeneratorVisit.generatePayerProgram());
		jsonObjectVisit.put(globalVariables.ProcedureCodejson,DataGeneratorVisit.generateProcedureCode(10));
		jsonObjectVisit.put(globalVariables.VisitTimeZonejson,DataGeneratorVisit.generateVisitTimeZone());
		jsonObjectVisit.put(globalVariables.CallExternalIDjson, CommonMethods.generateRandomNumberOfFixLength(7));
		
		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCalls =  (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCalls.put(globalVariables.CallAssignmentjson, DataGeneratorVisit.generateCallAssignment());

		JSONObject jsonObjectVisitCalls1 =  (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCalls1.put(globalVariables.CallAssignmentjson, DataGeneratorVisit.generateCallAssignment());
		
		
		jsonObjectVisitCalls.put(globalVariables.CallTypejson, "OTHER");
		jsonObjectVisitCalls1.put(globalVariables.CallTypejson, "OTHER");
		jsonObjectVisitCalls.put(globalVariables.ProcedureCodejson,DataGeneratorVisit.generateProcedureCode(10));
		jsonObjectVisitCalls1.put(globalVariables.ProcedureCodejson,DataGeneratorVisit.generateProcedureCode(10));
		jsonObjectVisitCalls.put(globalVariables.ClientIdentifierOnCalljson,CommonMethods.generateRandomNumberOfFixLength(7));
		jsonObjectVisitCalls1.put(globalVariables.ClientIdentifierOnCalljson,CommonMethods.generateRandomNumberOfFixLength(7));
		jsonObjectVisitCalls.put(globalVariables.MobileLoginjson, CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObjectVisitCalls1.put(globalVariables.MobileLoginjson, CommonMethods.generateRandomNumberOfFixLength(10));
		
		jsonObjectVisitCalls.put(globalVariables.CallLatitudejson,DataGeneratorVisit.generateCallLatitude());
		jsonObjectVisitCalls1.put(globalVariables.CallLatitudejson,DataGeneratorVisit.generateCallLatitude());
		jsonObjectVisitCalls.put(globalVariables.CallLongitudejson,DataGeneratorVisit.generateCallLongitude());
		jsonObjectVisitCalls1.put(globalVariables.CallLatitudejson,DataGeneratorVisit.generateCallLatitude());
		jsonObjectVisitCalls.put(globalVariables.Locationjson,CommonMethods.generateRandomNumberOfFixLength(3));
		jsonObjectVisitCalls1.put(globalVariables.CallLatitudejson,DataGeneratorVisit.generateCallLatitude());
		
		jsonObjectVisitCalls.put(globalVariables.TelephonyPINjson,CommonMethods.generateRandomNumberOfFixLength(5));
		jsonObjectVisitCalls1.put(globalVariables.TelephonyPINjson,CommonMethods.generateRandomNumberOfFixLength(5));
		jsonObjectVisitCalls.put(globalVariables.OriginatingPhoneNumberjson,CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObjectVisitCalls1.put(globalVariables.OriginatingPhoneNumberjson,CommonMethods.generateRandomNumberOfFixLength(10));
		
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.ChangeMadeByjson, CommonMethods.generateEmailAddress_string(8));
			
		jsonObjectVisitChanges.put(globalVariables.ChangeDateTimejson,CommonMethods.generateTodayDate_MMddyyyy());
		jsonObjectVisitChanges.put(globalVariables.ChangeReasonMemojson,CommonMethods.getSaltString(5));

		CommonMethods.capturePostResponse_400(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));

	}
}

