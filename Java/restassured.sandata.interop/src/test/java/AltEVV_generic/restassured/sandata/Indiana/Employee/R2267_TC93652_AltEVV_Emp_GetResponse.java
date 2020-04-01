package AltEVV_generic.restassured.sandata.Indiana.Employee;

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
 * @author MayankM
 */
//Test Case 93652: Alt EVV - employee- Validate get Response for created Emloyee

public class R2267_TC93652_AltEVV_Emp_GetResponse extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate get Response for created Emloyee
	@Test(groups = {"All"})
	public void R2267_TC93652_AltEVV_Employee_Validate_GetResponse() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		//Validating the Post Request 
		// logger = extent.startTest("R2267_TC93651_AltEVV_Employee_Validate_GetResponse");

		logger.log(LogStatus.INFO, "// validate the Get response"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
	}


}