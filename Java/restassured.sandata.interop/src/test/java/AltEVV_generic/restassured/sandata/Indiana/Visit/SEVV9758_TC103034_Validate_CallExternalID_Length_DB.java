package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
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

public class SEVV9758_TC103034_Validate_CallExternalID_Length_DB extends BaseTest {
	
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	public void TC103034_Validate_CallExternalID_Length_DB() throws FileNotFoundException, InterruptedException, IOException, ParseException, ClassNotFoundException, SQLException, java.text.ParseException{
		// logger = extent.startTest("TC103034_Validate_CallExternalID_Length_DB");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.CallExternalIDjson, CommonMethods.generateRandomNumberOfFixLength(15));
	
		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC103034_Validate_CallExternalID_Length_DB_multiple() throws FileNotFoundException, InterruptedException, IOException, ParseException, ClassNotFoundException, SQLException, java.text.ParseException{
		// logger = extent.startTest("TC103034_Validate_CallExternalID_Length_DB");

		String callExternalID = CommonMethods.generateRandomNumberOfFixLength(16);
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		JSONArray jsonArrayVisitChanges = (JSONArray) jsonObjectVisit.get("Calls");
		
		JSONObject jsonObjectVisitChanges =  (JSONObject) jsonArrayVisitChanges.get(0);
		jsonObjectVisitChanges.put(globalVariables.CallExternalIDjson, callExternalID);
		
		JSONObject jsonObjectVisitChanges_call =  (JSONObject) jsonArrayVisitChanges.get(1);
		jsonObjectVisitChanges_call.put(globalVariables.CallExternalIDjson,callExternalID);

		CommonMethods.validateResponse(jsonArrayVisit,
			CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
	

}
