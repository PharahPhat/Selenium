package openevv.Connecticut.Employee;

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

import static com.globalMethods.core.globalVariables.EmployeeEmail;
import static com.globalMethods.core.globalVariables.EmployeeEmailAddress;

/**
 * @author MayankM
 */

public class SEVV15079_TC38325_Emp_EmpGenerateSMCWhenCreateNewEmployee extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All", "fixing"})
	public void TC38325_Emp_EmpGenerateSMCWhenCreateNewEmployee() throws InterruptedException, IOException, ParseException, java.text.ParseException, SQLException, ClassNotFoundException {
		// logger = extent.startTest("TC88921_OpenEVV_Emp_GetResponse_Validation");

		JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		JSONObject jsonObject = (JSONObject) j.get(0);

		String bodyAsString = CommonMethods.verifyPostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.openevv_emp_url),
				CommonMethods.propertyfileReader(globalVariables.Emp_get_url));

		assertionDbVerifier.jsonAssertInboxWorker_OpenEVV(bodyAsString, jsonObject);
		assertionDbVerifier.verifyExistingDataIn_STX_MVV_User(jsonObject.get(EmployeeEmailAddress).toString());
	}
}