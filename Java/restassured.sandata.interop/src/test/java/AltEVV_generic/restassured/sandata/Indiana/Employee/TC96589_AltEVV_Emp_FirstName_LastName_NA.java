package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author MayankM
 */

public class TC96589_AltEVV_Emp_FirstName_LastName_NA extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void TC96589_AltEVV_Emp_FirstName_LastName_blank() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC96589_AltEVV_Emp_FirstName_LastName_blank");

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", "");
		js.put("EmployeeLastName", "");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffFirstNameFormatError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffLastNameFormatError);
	}

	@Test(groups = {"All"})
	public void TC96589_AltEVV_Emp_FirstName_LastName_null() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC96589_AltEVV_Emp_FirstName_LastName_null");

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeFirstName", null);
		js.put("EmployeeLastName", null);

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffFirstNameNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffLastNameNullError);
	}

	@Test(groups = {"All"})
	public void TC96589_AltEVV_Emp_FirstName_LastName_Not_Present() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC96589_AltEVV_Emp_FirstName_LastName_Not_Present");

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject js = (JSONObject) j.get(0);
		js.remove("EmployeeFirstName");
		js.remove("EmployeeLastName");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffFirstNameNullError);
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffLastNameNullError);
	}

}
