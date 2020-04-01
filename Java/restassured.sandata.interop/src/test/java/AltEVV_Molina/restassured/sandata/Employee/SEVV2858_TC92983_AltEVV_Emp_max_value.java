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
//Test Case 91414: Open EVV-Alt EVV-Worker-Load-Values with Minimum Length

public class SEVV2858_TC92983_AltEVV_Emp_max_value extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//validate the Staff Intake JSON with min value only in DB repsonse
	@Test(groups = {"All"})
	public void SEVV2858_TC92983_AltEVV_Emp_Min_Value_DB_Validation() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC92983_AltEVV_Emp_Min_Value_DB_Validation ");

		logger.log(LogStatus.INFO, "// validate the Staff Intake JSON with min value in DB only"); 
		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("EmployeeSSN", CommonMethods.generateRandomNumberOfFixLength(9));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

}