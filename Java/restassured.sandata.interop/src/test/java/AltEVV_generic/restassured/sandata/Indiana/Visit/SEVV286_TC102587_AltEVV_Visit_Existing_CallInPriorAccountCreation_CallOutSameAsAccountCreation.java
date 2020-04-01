package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static com.globalMethods.core.globalVariables.ACCID;

public class SEVV286_TC102587_AltEVV_Visit_Existing_CallInPriorAccountCreation_CallOutSameAsAccountCreation extends BaseTest {

	private DataBaseVerifier dataBaseVerifier = new DataBaseVerifier();
	private GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();
	private Constant_SQL Constant_SQL = new Constant_SQL();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	// Case1: Validating visit should not created as we are sending callIn prior to AccountCreation Date and callOut same as Account Creation Date.
	
	@Test(groups = { "All", "fixing"})
	public void TC102587_AltEVV_Visit_Existing_CallInPriorAccountCreationDate_CallOutSameAsAccountCreationDate()
			throws InterruptedException, IOException, ParseException, SQLException,
			java.text.ParseException, ClassNotFoundException {

		// logger = extent.startTest("TC10427_AltEVV_Visit_Existing_CallInPriorAccountCreationDate_CallOutSameAsAccountCreationDate");

		logger.log(LogStatus.INFO, "Visit_CallInPriorAccountCreation_CallOutSameAsAccountCreation");

		String createdAccount = CommonMethods.ConvertDateFromDBToJsonFormat(dataBaseVerifier.executeQueryString(String.format(Constant_SQL.getAccountCreationDateSQL,
				stateInfo.get(ACCID))));

		JSONArray jsonArrayVisit = GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		JSONArray jsonArrayVisitCalls = (JSONArray) jsonObjectVisit.get("Calls");
		JSONObject jsonObjectVisitCall1 = (JSONObject) jsonArrayVisitCalls.get(0);
		jsonObjectVisitCall1.put(globalVariables.CallDateTimejson, CommonMethods.getPastZoneDateTime(createdAccount, 1));
		JSONObject jsonObjectVisitCall2 = (JSONObject) jsonArrayVisitCalls.get(1);
		jsonObjectVisitCall2.put(globalVariables.CallDateTimejson, createdAccount);

		CommonMethods.validateResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		assertionDbVerifier.verifyErrorCodeInboxVisit("-785", jsonObjectVisit);
	}

}
