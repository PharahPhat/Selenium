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
import java.sql.SQLException;

/**
 * @author Anupam
 */

public class CR5002_TC97073_ALTEVV_Visit_ClientVerifiedService_true_Other_verification_false extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
		@Test(groups = {"All"})
		public void TC97073_ALTEVV_Visit_ClientVerifiedService_true_Other_verification_false() throws
				InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException,
				java.text.ParseException {
			logger.log(LogStatus.INFO, "Visit_ClientVerifiedService_true_Other_verification_false");

			JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
			JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

			jsonObjectVisit.put("ClientVerifiedService", true);
			jsonObjectVisit.put("ClientVerifiedTasks", false);
			jsonObjectVisit.put("ClientVoiceRecording", false);

			CommonMethods.validateResponse(jsonArrayVisit,
					CommonMethods.propertyfileReader(globalVariables.altevv_visit));
		}
}
