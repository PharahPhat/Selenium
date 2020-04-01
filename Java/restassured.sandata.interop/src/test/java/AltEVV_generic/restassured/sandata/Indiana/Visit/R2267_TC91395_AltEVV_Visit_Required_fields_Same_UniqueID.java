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

public class R2267_TC91395_AltEVV_Visit_Required_fields_Same_UniqueID extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	// Case1: Should be able to Update all the required fields of a visit
	@Test(groups = {"All"})
	public void R2267_TC91395_AltEVV_VisitCreation_LoadJson_with_required_fields() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException{
		
		// logger = extent.startTest("R2267_TC91395_AltEVV_VisitCreation_LoadJson_with_required_fields_of_visit");
		logger.log(LogStatus.INFO, "Validating VisitCreation_LoadJson_with_required_fields_of_visit"); 

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		Thread.sleep(5000);

		String sequenceid=CommonMethods.generateUniqueID();
		jsonObjectVisit.put("VisitOtherID", CommonMethods.generateUniqueID());
		jsonObjectVisit.put(globalVariables.SequenceIDjson, sequenceid);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("VisitChanges");
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.SequenceIDjson, sequenceid);

		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
}
