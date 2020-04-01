package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author MayankM
 */
//Test Case 91572:Open EVV - employee- Create Multiple employee with Same SSN

public class TC91572_MultipleEmp_SameSSN extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void TC91572_OpenEVV_Emp_ssn_new_dberrorcode() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException 
	{
		// logger = extent.startTest("TC91572_OpenEVV_Emp_ssn_new_dberrorcode");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		JSONObject  js = (JSONObject) jsonArray.get(0);

		String empssn = CommonMethods.generateRandomNumberOfFixLength(9);
		js.put("EmployeeSocialSecurity",empssn);
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		js = (JSONObject) jsonArray.get(0);
		Thread.sleep(5000);
		// To send the request again with same ssn
		js.put("EmployeeSocialSecurity",empssn);

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

	}


}



