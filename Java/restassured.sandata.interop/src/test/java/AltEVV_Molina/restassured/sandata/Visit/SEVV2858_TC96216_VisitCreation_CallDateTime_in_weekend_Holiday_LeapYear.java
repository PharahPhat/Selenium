/**
 * 
 */
package AltEVV_Molina.restassured.sandata.Visit;

import java.io.FileNotFoundException;
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
import com.globalMethods.core.Assertion_DbVerifier; public class SEVV2858_TC96216_VisitCreation_CallDateTime_in_weekend_Holiday_LeapYear extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Case1: Validating visit should be created successfully when CallDateTime passed with "weekend" in calendar days
	@Test(groups = {"All"})
	public void SEVV2858_TC96216_AltEVV_VisitCreation_CallDateTime_in_weekend_Holiday_LeapYear() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{


		// logger = extent.startTest("SEVV2858_TC96216_AltEVV_VisitCreation_CallDateTime_in_weekend_Holiday_LeapYear");

		logger.log(LogStatus.INFO, "Validating VisitCreation_with_CallDateTime_falls_in_weekend_in_CalenderDays"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisit.put(globalVariables.AdjInDateTime, "2019-05-05T19:02:26Z");
		jsonObjectVisit.put(globalVariables.AdjOutDateTime, "2019-05-05T21:02:26Z");
		jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, "2019-05-05T10:02:26Z");

		JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges1.put(globalVariables.CallDateTimejson, "2019-05-05T21:02:20Z");

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	//Case2: Validating visit should be created successfully when CallDateTime passed with "weekend-Saturday" in calendar days
	@Test(groups = {"All"})
	public void SEVV2858_TC96216_AltEVV_VisitCreation_CallDateTime_in_weekend_Saturday() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

		// logger = extent.startTest("SEVV2858_TC96216_AltEVV_VisitCreation_CallDateTime_in_weekend_Saturday");

		logger.log(LogStatus.INFO, "Validating VisitCreation_with_CallDateTime_falls_in_weekend_Saturday_in_CalenderDays"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);

		jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, "2018-10-06T10:02:26Z");

		JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges1.put(globalVariables.CallDateTimejson, "2018-10-06T22:02:20Z");


		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	//Case3: Validating CallDateTime dates which fall under Holidays 
	@Test(groups = {"All"})
	public void SEVV2858_TC96216_AltEVV_VisitCreation_CallDateTime_with_Holidays() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

		// logger = extent.startTest("SEVV2858_TC96216_AltEVV_VisitCreation_CallDateTime_with_Holidays");

		logger.log(LogStatus.INFO, "Validating VisitCreation_CallDateTime_fall_under_Holidays_in_CalenderDays"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);

		jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, "2018-09-03T10:02:26Z");

		JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges1.put(globalVariables.CallDateTimejson, "2018-09-03T22:02:20Z");

		CommonMethods.validateResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
	}

	//Case4: Validating CallDateTime dates which fall in leap year (visit creation successful)

	@Test(enabled = false, groups = {"All"})
	public void SEVV2858_TC96216_AltEVV_VisitCreation_CallDateTime_in_leapYear() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException{

		// logger = extent.startTest("SEVV2858_TC96216_AltEVV_VisitCreation_CallDateTime_in_leapYear");

		logger.log(LogStatus.INFO, "Validating VisitCreation_CallDateTime_falls_in_leapYear"); 
	

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisit.put(globalVariables.AdjInDateTime, "2016-02-29T19:02:26Z");
		jsonObjectVisit.put(globalVariables.AdjOutDateTime, "2016-02-29T22:02:26Z");
		jsonObjectVisitChanges.put(globalVariables.CallDateTimejson, "2016-02-29T10:02:26Z");

		JSONObject jsonObjectVisitChanges1 =  (JSONObject) jsonArrayVisitChanges.get(1);
		
		jsonObjectVisitChanges1.put(globalVariables.CallDateTimejson, "2016-02-29T22:02:20Z");


		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit));
		String bodyAsStringGet=CommonMethods.captureGetResponseWithUID(bodyAsString, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit_get));

		assertionDbVerifier.jsonAssert_inboxVisitCallsMolina(bodyAsStringGet, jsonObjectVisit, jsonObjectVisitChanges);
			}

}
