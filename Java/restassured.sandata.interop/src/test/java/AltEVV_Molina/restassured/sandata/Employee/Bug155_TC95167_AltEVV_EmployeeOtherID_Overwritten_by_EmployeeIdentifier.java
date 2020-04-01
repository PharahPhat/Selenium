package AltEVV_Molina.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 95167:Test Case 95167:Validate if EmployeeQualifier is "EmployeeCustomID", EmployeeOtherID (worker_id_custom1) will be overwritten by EmployeeIdentifier

import com.globalMethods.core.Assertion_DbVerifier;

public class Bug155_TC95167_AltEVV_EmployeeOtherID_Overwritten_by_EmployeeIdentifier extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Case1: Validate if EmployeeQualifier is "EmployeeCustomID", EmployeeOtherID (worker_id_custom1) will be overwritten by EmployeeIdentifier
	
	@Test(groups = {"All"})
	public void TC95167_AltEVV_EmployeeQualifier_with_EmployeeCustomID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException

	{
		// logger = extent.startTest("TC95167_AltEVV_EmployeeQualifier_with_EmployeeCustomID");

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("EmployeeQualifier", "EmployeeCustomID");
		jsonObject.put("EmployeeIdentifier", CommonMethods.generateRandomNumberOfFixLength(9));
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}
}