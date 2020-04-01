package openevv.Connecticut.Employee;
//package OpenEVV.restassured.sandata.employee;

//import com.employee.core.DataGeneratorEmployee_3P;
import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorEmployee;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author MayankM
 *
 */

// TC94744 : Inter-Op: Verifies if EmployeeAddress, EmployeeAddress2 & EmployeeCity fields are accepting values with space

public class TC88789_OpenEVV_FullLoaded_EmpType_Discipline_Dept extends BaseTest
{
    GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();
	@Test(groups = {"All", "fixing"})
	public void TC88789_OpenEVV_fullloaded_EmpType_Discipline_Dept_valid() throws InterruptedException, java.text.ParseException, IOException, ParseException {

		JSONArray jsonArr= generateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		JSONObject js = (JSONObject) jsonArr.get(0);
		js.put("Department", DataGeneratorEmployee.generateEmpDept(3));
		js.put("EmployeeType", DataGeneratorEmployee.generateEmpDept(3));
		js.put("Discipline", DataGeneratorEmployee.generateEmpDept(3));

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}

}
