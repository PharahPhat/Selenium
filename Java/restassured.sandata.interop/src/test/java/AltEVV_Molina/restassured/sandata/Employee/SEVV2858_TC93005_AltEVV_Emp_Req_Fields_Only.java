package AltEVV_Molina.restassured.sandata.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author MayankM
 */
//Test Case 91103: Alt EVV-Worker-Load-Required Fields Only

public class SEVV2858_TC93005_AltEVV_Emp_Req_Fields_Only extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void SEVV2858_TC93005_AltEVV_Employee_Req_Fields_Validation() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC93005_AltEVV_Employee_Req_Fields_Validation ");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);;
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("EmployeeOtherID", null);
		jsonObject.put("EmployeeManagerEmail", null);
		jsonObject.put("EmployeeAPI", null);
		jsonObject.put("EmployeePosition", null);

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
}


}