package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Anupam
 */
// Test Case 96797: OpenEVV employee- Validate PayRate field for positive values

public class R2154_TC96797_OpenEVV_PayRate_valid extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	// Case1: PayRate- 1.45 (String)

	@Test(groups = {"All"})
	public void TC96797_OpenEVV_PayRate_valid() throws InterruptedException,  IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96797_OpenEVV_PayRate_valid");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.PayRate, CommonMethods.generateRandomNumberOfFixLength(1) +"." +CommonMethods.generateRandomNumberOfFixLength(2));

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

	}

	// Case2: PayRate- 12.45- Max length

	@Test(groups = {"All"})
	public void TC96797_OpenEVV_PayRate_decimal_Maxlength() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96797_OpenEVV_PayRate_decimal_Maxlength");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.PayRate, CommonMethods.generateRandomNumberOfFixLength(2) + "." + CommonMethods.generateRandomNumberOfFixLength(2));

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

	}

	// Case3: PayRate- null 

	@Test(groups = {"All"})
	public void TC96797_OpenEVV_PayRate_with_null() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException
	{
		// logger = extent.startTest("TC96797_OpenEVV_PayRate_with_null");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsonobject = (JSONObject) jsonArr.get(0);

		jsonobject.put(globalVariables.PayRate, null);

		CommonMethods.validateResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
	}
}
