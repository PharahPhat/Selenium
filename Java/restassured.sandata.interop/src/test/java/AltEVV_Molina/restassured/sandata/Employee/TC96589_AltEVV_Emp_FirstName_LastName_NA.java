package AltEVV_Molina.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */
import com.globalMethods.core.Assertion_DbVerifier; public class TC96589_AltEVV_Emp_FirstName_LastName_NA extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All", "Regression"})
	public void TC96589_AltEVV_Emp_FirstName_LastName_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96589_AltEVV_Emp_FirstName_LastName_blank");

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", "");
		js.put("EmployeeLastName", "");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffFirstNameFormatError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffLastNameFormatError);
	}

	@Test(groups = {"All", "Regression"})
	public void TC96589_AltEVV_Emp_FirstName_LastName_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96589_AltEVV_Emp_FirstName_LastName_null");

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", null);
		js.put("EmployeeLastName", null);

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffFirstNameNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffLastNameNullError);
	}

	@Test(groups = {"All", "Regression"})
	public void TC96589_AltEVV_Emp_FirstName_LastName_Not_Present() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96589_AltEVV_Emp_FirstName_LastName_Not_Present");

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		js.remove("EmployeeFirstName");
		js.remove("EmployeeLastName");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffFirstNameNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffLastNameNullError);
	}

}
