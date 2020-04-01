package AltEVV_Molina.restassured.sandata.Employee;

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

public class TC96576_AltEVV_Emp_StaffSSN extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	public void TC96576_AltEVV_Emp_StaffSSN_invalid_length() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC96576_AltEVV_Emp_StaffSSN_invalid_length");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("EmployeeSSN",CommonMethods.generateRandomNumberOfFixLength(10));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffSSNFormatError);
		
	}
	
	@Test(groups = {"All", "Regression"})
	public void TC96576_AltEVV_Emp_StaffSSN_hyphen() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("TC96576_AltEVV_Emp_StaffSSN_hyphen");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("EmployeeSSN",CommonMethods.generateRandomNumberOfFixLength(5) + " - " + CommonMethods.generateRandomNumberOfFixLength(4));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.StaffSSNFormatError);
	}


}
