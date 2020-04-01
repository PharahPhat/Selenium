package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author MayankM
 */
// TC94744 : Inter-Op: Verifies if EmployeeAddress, EmployeeAddress2 & EmployeeCity fields are accepting values with space

public class Bug_3577_TC94744_EmpAdd_Add2_City_Space extends BaseTest
{
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void TC94744_EmpAdd_Add2_City_Space_validation() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, Exception
	{
		
		// logger = extent.startTest("TC94743_EmpAdd_Add2_City_Space_validation");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject js = (JSONObject) jsonArr.get(0);

		js.put(globalVariables.EmployeeAddress1,CommonMethods.getSaltString(10) + " " + CommonMethods.generateRandomStringOfFixLength(5));
		js.put(globalVariables.EmployeeAddress2, CommonMethods.getSaltString(10) + " " + CommonMethods.generateRandomStringOfFixLength(5));
		js.put(globalVariables.EmployeeCity, CommonMethods.getSaltString(10) + " " + CommonMethods.generateRandomStringOfFixLength(5));

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

}
