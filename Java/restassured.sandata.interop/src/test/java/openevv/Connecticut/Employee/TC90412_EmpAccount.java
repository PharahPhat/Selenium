package openevv.Connecticut.Employee;

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

/**
 * @author MayankM
 */
//Test Case 90412:Inter-op - Open EVV- employee- Account field validation for any Random Value

public class TC90412_EmpAccount extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the random value for account
	@Test(groups = {"All", "fixing"})
	public void TC90412_EmpAccount_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC90412_EmpAccount_invalid");
		logger.log(LogStatus.INFO, "validating the random value for account"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("Account", CommonMethods.generateRandomNumberOfFixLength(5));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpAccountFormatError);
	}

}	

