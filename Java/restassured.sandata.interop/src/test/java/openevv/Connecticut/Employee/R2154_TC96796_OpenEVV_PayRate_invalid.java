/**
 * 
 */
package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Anupam
 */
// Test Case 96796: OpenEVV employee- Validate PayRate field for Invalid values

public class R2154_TC96796_OpenEVV_PayRate_invalid extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	// Case1: PayRate- abchdh (String)

	@Test(groups = {"All", "fixing"})
	public void TC96796_OpenEVV_PayRate_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC96796_OpenEVV_PayRate_invalid");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.PayRate, CommonMethods.generateRandomStringOfFixLength(6));

		String bodyAsString = CommonMethods.capturePostResponse_400(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		CommonMethods.verifyjsonassertFailcase_400(bodyAsString, globalVariables.Errormesssage);

	}

	// Case2: PayRate- 123.45- Exceeding length

	@Test(groups = {"All"})
	public void TC96796_OpenEVV_PayRate_decimal_lengthexceed() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC96796_OpenEVV_PayRate_decimal_lengthexceed");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.PayRate, CommonMethods.generateRandomNumberOfFixLength(3) + "." + CommonMethods.generateRandomNumberOfFixLength(2));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.PayRatelengthError);
	}

	// Case3: PayRate- 12.3 5 (with spaces)

	@Test(groups = {"All", "fixing"})
	public void TC96796_OpenEVV_PayRate_decimal_with_spaces() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC96796_OpenEVV_PayRate_decimal_with_spaces");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.PayRate, CommonMethods.generateRandomNumberOfFixLength(2) +"." +CommonMethods.generateRandomNumberOfFixLength(1) +" ");

		String bodyAsString = CommonMethods.capturePostResponse_400(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		CommonMethods.verifyjsonassertFailcase_400(bodyAsString, globalVariables.Errormesssage);
	}

	// Case4: PayRate- 12.3@5 (with special chars)

	@Test(groups = {"All", "fixing"})
	public void TC96796_OpenEVV_PayRate_with_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC96796_OpenEVV_PayRate_with_specialchars");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.PayRate, CommonMethods.generateRandomNumberOfFixLength(2) + "." + CommonMethods.generateRandomNumberOfFixLength(2) +CommonMethods.generateSpecialChar(1));

		String bodyAsString = CommonMethods.capturePostResponse_400(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		CommonMethods.verifyjsonassertFailcase_400(bodyAsString, globalVariables.Errormesssage);
	}

}
