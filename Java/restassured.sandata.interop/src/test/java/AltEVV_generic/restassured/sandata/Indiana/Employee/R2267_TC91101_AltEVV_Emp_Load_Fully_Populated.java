package AltEVV_generic.restassured.sandata.Indiana.Employee;

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
 * @author RRohiteshwar
 */
//Test Case 91101: Alt EVV-Worker-Load-Fully Populated

public class R2267_TC91101_AltEVV_Emp_Load_Fully_Populated extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Validate valid employee with fully populated value in DB
	@Test(groups = {"All", "fixing"})
	public void R2267_TC91101_AltEVV_Emp_Load_Fully_Populated_DB_Validation() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC7397_AltEVV_Emp_Load_Fully_Populated_DB_Validation ");

		logger.log(LogStatus.INFO, "Validate valid employee with fully populated value in DB"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

		CommonMethods.validateResponse(jsonArray,
								CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		assertionDbVerifier.verifyInboxWorker_AltEvvGenric(jsonObject);
	}

}