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

import java.io.IOException;
import java.sql.SQLException;

public class Bug_6185_TC98379_Existing_ClientID_ClientQual_Inbox_Schedule_ExistingClientEmployee extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@SuppressWarnings("unused")
	@Test(groups = {"All", "Regression"})
	public void TC98379_Existing_ClientID_ClientQual_Inbox_Schedule_ExistingClientEmployee() throws InterruptedException,
			IOException, ParseException, ClassNotFoundException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("ClientID_ClientQual_Inbox_Schedule");
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
	}
}
