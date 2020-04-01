package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

//Test Case 95166:Validate if EmployeeQualifier is "EmployeeSSN", EmployeeSSN will be overwritten by EmployeeIdentifier
public class Bug155_TC95166_AltEVV_EmployeeSSN_Overwritten_by_EmployeeIdentifier extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//Case1: Validate if EmployeeQualifier is "EmployeeSSN", EmployeeSSN will be overwritten by EmployeeIdentifier
	
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void TC95166_AltEVV_EmployeeQualifier_with_EmployeeSSN() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("TC95166_AltEVV_EmployeeQualifier_with_EmployeeSSN");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("EmployeeQualifier", "EmployeeSSN");
		jsonObject.put("EmployeeIdentifier", CommonMethods.generateRandomNumberOfFixLength(9));
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
	}
}