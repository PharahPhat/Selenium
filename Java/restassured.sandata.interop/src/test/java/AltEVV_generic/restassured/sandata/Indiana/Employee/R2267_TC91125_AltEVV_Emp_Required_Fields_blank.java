package AltEVV_generic.restassured.sandata.Indiana.Employee;

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
 * @author RRohiteshwar
 */
//Test Case 91125: Alt EVV-Worker-Validate - Required Fields Blank [element and value]

public class R2267_TC91125_AltEVV_Emp_Required_Fields_blank extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//Validate invalid employee required field is populated except EmployeeQualifier 
	@Test(groups = {"All", "Smoke"})
	public void R2267_TC91125_AltEVV_Emp_Required_Fields_Null() throws InterruptedException, IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2267_TC91125_AltEVV_Emp_Required_Fields_EmployeeQualifier_Blank ");

		logger.log(LogStatus.INFO, "Validate invalid employee required field is populated except EmployeeQualifier "); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeQualifier", null);
		jsonObject.put("EmployeeIdentifier", null);
		jsonObject.put("SequenceID", null);
		jsonObject.remove("EmployeeSSN");
		jsonObject.put("EmployeeLastName", null);
		jsonObject.put("EmployeeFirstName", null);

		String resp = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(resp, globalVariables.EmployeeQualifier_Error);
		CommonMethods.verifyjsonassertFailcase(resp, globalVariables.errorEmployeeIdentifierNull);
		CommonMethods.verifyjsonassertFailcase(resp, globalVariables.SequenceIDNullError);
		CommonMethods.verifyjsonassertFailcase(resp, globalVariables.StaffSSNnullError);
		CommonMethods.verifyjsonassertFailcase(resp, globalVariables.StaffLastNameNullError);
		CommonMethods.verifyjsonassertFailcase(resp, globalVariables.StaffFirstNameNullError);
	}
}