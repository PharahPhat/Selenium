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
//Test Case 91542:Open EVV - Alt EVV - Worker - Verify the Unique employeeotherid

public class R2267_TC91542_AltEVV_Emp_unique_EmployeeOtherID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Validating valid  Unique employee employeeotherid
	@Test(groups = {"All", "fixing"})
	public void R2267_TC91542_AltEVV_Emp_unique_EmployeeOtherID_json_DB_Validation() throws InterruptedException,
			IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("R2267_TC91542_AltEVV_Emp_unique_EmployeeOtherID_json_DB_Validation");
		logger.log(LogStatus.INFO, "Validating valid  Unique employee employeeotherid"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		String empOtherID = jsonObject.get(globalVariables.EmployeeOtherID).toString();
		
		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		logger.log(LogStatus.INFO, "Validating that Db does not create 2 workers for the same EmployeeOtherID");

		jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put(globalVariables.EmployeeOtherID, empOtherID);

		String bodyAsString_dup = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
		
		assertionDbVerifier.jsonAssertInboxWorker_AltEvvGenric_Not_Existing_In_DB(bodyAsString_dup, jsonObject);
	}
}