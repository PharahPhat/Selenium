package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class SEVV9758_TC103041_Validate_MobileLogin_Length_DBvalidation extends BaseTest {
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All", "Regression"})
	public void TC103041_Validate_MobileLogin_Length_DB() throws FileNotFoundException, InterruptedException, IOException, ParseException, ClassNotFoundException, SQLException, java.text.ParseException{
		// logger = extent.startTest("TC103041_Validate_MobileLogin_Length_DB");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.MobileLoginjson, CommonMethods.generateRandomNumberOfFixLength(64));
		
		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

	//As per requirement spec7.2x MobileLogin accepts max length of 64chars(String).No length truncation logic is set from DBend.
	@Test(groups = {"All", "Regression"})
	public void TC103041_Validate_MobileLogin_Length_DBvalidation_multiple() throws FileNotFoundException, InterruptedException, IOException, ParseException, ClassNotFoundException, SQLException, java.text.ParseException{
		// logger = extent.startTest("TC103041_Validate_MobileLogin_Length_DBvalidation_multiple");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
        String mLogin=CommonMethods.generateRandomNumberOfFixLength(64);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.MobileLoginjson, mLogin);
		
		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.MobileLoginjson,mLogin);

		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}

}
