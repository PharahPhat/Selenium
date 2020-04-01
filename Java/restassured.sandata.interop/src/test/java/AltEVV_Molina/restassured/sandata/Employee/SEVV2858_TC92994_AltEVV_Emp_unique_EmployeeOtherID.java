package AltEVV_Molina.restassured.sandata.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
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
//Test Case 91542:Open EVV - Alt EVV - Worker - Verify the Unique employeeotherid

public class SEVV2858_TC92994_AltEVV_Emp_unique_EmployeeOtherID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//Validating valid  Unique employee employeeotherid
	@Test(groups = {"All", "fixing"})
	public void SEVV2858_TC92994_AltEVV_Emp_unique_EmployeeOtherID_json_DB_Validation() throws InterruptedException,
			IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC92994_AltEVV_Emp_unique_EmployeeOtherID_json_DB_Validation");
		logger.log(LogStatus.INFO, "Validating valid  Unique employee employeeotherid"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeOtherID", CommonMethods.generateRandomNumberOfFixLength(5));
		String empotherid=jsonObject.get("EmployeeOtherID").toString();
		
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Thread.sleep(30000);

		logger.log(LogStatus.INFO, "Validating that Db does not create 2 workers for the same EmployeeOtherID"); 
	
		jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeOtherID", empotherid);
		jsonObject.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(11));
		
		String bodyAsString_dup = CommonMethods.verifyPostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp),
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp_get));

		assertionDbVerifier.jsonAssertInboxWorker_AltEvvGenric_Not_Existing_In_DB(bodyAsString_dup, jsonObject);
	}
}