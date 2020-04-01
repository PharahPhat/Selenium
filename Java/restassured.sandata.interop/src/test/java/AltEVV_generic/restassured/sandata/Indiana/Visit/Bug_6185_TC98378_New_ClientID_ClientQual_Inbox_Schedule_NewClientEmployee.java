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

public class Bug_6185_TC98378_New_ClientID_ClientQual_Inbox_Schedule_NewClientEmployee extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All", "fixing"})
	public void TC98378_ClientID_ClientQual_Inbox_Schedule_NewClientEmployee() throws InterruptedException, IOException, ParseException, ClassNotFoundException, SQLException, java.text.ParseException{
		
		// logger = extent.startTest("TC98378_ClientID_ClientQual_Inbox_Schedule");
		
		JSONArray jsonArrayVisit=GenerateUniqueParam.visitParams_AltEVV_WithNewClientAndEmployee();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);
		String bodyAsString = CommonMethods.verifyPostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit),
				CommonMethods.propertyfileReader(globalVariables.altevv_visit_get));

		assertionDbVerifier.jsonAssertInboxVisitAltevvGeneric(bodyAsString, jsonObjectVisit);
	}
}
