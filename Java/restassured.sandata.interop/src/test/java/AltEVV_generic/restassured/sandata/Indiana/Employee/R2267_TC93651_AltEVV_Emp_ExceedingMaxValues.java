package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author MayankM
 */
//Test Case 93651: Alt EVV-Worker-Validate-Exceed Maximum Values > to be rejected

public class R2267_TC93651_AltEVV_Emp_ExceedingMaxValues extends BaseTest

{ Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the Staff Intake JSON with exceeding max values
	@Test(groups = {"All"})
	public void R2267_TC93651_AltEVV_Employee_Exceeding_MaxValues() throws InterruptedException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC7422_AltEVV_Employee_Exceeding_MaxValues ");


		JSONArray jsonArray = CommonMethods.LoadJSON_AltEVV("Staff_intake_exceeding_max");
		CommonMethods.capturePostResponse_500(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
	}


}