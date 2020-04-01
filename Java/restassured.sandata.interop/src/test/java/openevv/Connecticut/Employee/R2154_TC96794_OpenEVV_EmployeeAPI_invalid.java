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
// Test Case 96794: OpenEVV employee- Validate EmployeeAPI field for invalid values

public class R2154_TC96794_OpenEVV_EmployeeAPI_invalid extends BaseTest {
		private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	// Case1: EmployeeAPI- abchdh (String)

	@Test(groups = {"All", "fixing"})
	public void TC96794_OpenEVV_EmployeeAPI_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException
	{
		// logger = extent.startTest("TC96794_OpenEVV_EmployeeAPI_invalid");

		JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

		//Making json values dynamic

		JSONObject jsobject = (JSONObject) jsonArr.get(0);

		jsobject.put(globalVariables.EmployeeAPI, CommonMethods.generateRandomStringOfFixLength(6));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeAPIFormatError);
	}

	// Case2: EmployeeAPI>25 (All digits)- Exceeding length

	@Test(groups = {"All", "fixing"})
	public void TC96794_OpenEVV_EmployeeAPI_numeric_lengthexceed() throws InterruptedException, java.text.ParseException,  IOException, ParseException
		{
			// logger = extent.startTest("TC96794_OpenEVV_EmployeeAPI_numeric_lengthexceed");

			JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

			//Making json values dynamic

			JSONObject jsobject = (JSONObject) jsonArr.get(0);

			jsobject.put(globalVariables.EmployeeAPI, CommonMethods.generateRandomNumberOfFixLength(26));

			String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeAPIFormatError);
		}
	
	// Case3: EmployeeAPI- 1252 78- EmployeeAPI (with spaces)

	@Test(groups = {"All", "fixing"})
	public void TC96794_OpenEVV_EmployeeAPI_numeric_with_spaces() throws InterruptedException, java.text.ParseException,  IOException, ParseException
			{
				// logger = extent.startTest("TC96794_OpenEVV_EmployeeAPI_numeric_with_spaces");

				JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

				//Making json values dynamic

				JSONObject jsobject = (JSONObject) jsonArr.get(0);

				jsobject.put(globalVariables.EmployeeAPI,CommonMethods.generateRandomNumberOfFixLength(4)+ " "+CommonMethods.generateRandomNumberOfFixLength(4));

				String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

				CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeAPIFormatError);
			}
	
	// Case4: EmployeeAPI-124@ (with special chars)

	@Test(groups = {"All", "fixing"})
	public void TC96794_OpenEVV_EmployeeAPI_with_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException
				{
					// logger = extent.startTest("TC96794_OpenEVV_EmployeeAPI_with_specialchars");

					JSONArray jsonArr=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

					//Making json values dynamic

					JSONObject jsobject = (JSONObject) jsonArr.get(0);

					jsobject.put(globalVariables.EmployeeAPI, CommonMethods.generateRandomNumberOfFixLength(5) +CommonMethods.generateSpecialChar(3));

					String bodyAsString = CommonMethods.capturePostResponse(jsonArr, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmployeeAPIFormatError);
				}
				
}
