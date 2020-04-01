/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
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
 * @author neeraj
 */

public class R2267_TC91271_AltEVV_Visit_creation_unknown_Client extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void R2267_TC91271_AltEVV_Visit_Creation_Unknown_Client() throws InterruptedException, IOException,
			ParseException, SQLException, ClassNotFoundException {
		// logger = extent.startTest("R2267_TC91271_AltEVV_Visit_Creation_Unknown_Client");
		logger.log(LogStatus.INFO, "Validating_Visit_Creation_Unknown_Client");

		String CliendID=CommonMethods.generateRandomNumberOfFixLength(5);

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put("ClientID", CliendID);

		jsonObjectVisit.put("ClientIdentifier", CommonMethods.generateRandomNumberOfFixLength(5));

		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		assertionDbVerifier.verifyErrorCodeInboxVisit("-1021", jsonObjectVisit);
	}
}

