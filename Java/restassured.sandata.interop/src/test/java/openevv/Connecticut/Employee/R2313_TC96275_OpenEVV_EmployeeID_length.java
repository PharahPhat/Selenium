/**
 * 
 */
package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author Anupam
 */

public class R2313_TC96275_OpenEVV_EmployeeID_length extends BaseTest { 
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate EmployeeID length (invalid >5)
		@Test(groups = {"Smoke"})
		public void TC96275_OpenEVV_EmployeeID_invalid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException
		{
			// logger = extent.startTest("TC96275_OpenEVV_EmployeeID_invalid_length");

			JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
			JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

			jsonObject.put("EmployeeID",CommonMethods.generateRandomNumberOfFixLength(6));

			String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpIDFormatError);

		}
		
		//To validate EmployeeID length (invalid <5)
				@Test(groups = {"All"})
				public void TC96275_OpenEVV_EmployeeID_invalid_length_validation() throws InterruptedException, java.text.ParseException,  IOException, ParseException
				{
					// logger = extent.startTest("TC96275_OpenEVV_EmployeeID_invalid_length");

					JSONArray jsonArray = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
					JSONObject  jsonObject = (JSONObject) jsonArray.get(0);

					jsonObject.put("EmployeeID",CommonMethods.generateRandomNumberOfFixLength(4));

					String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
					CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpIDFormatError);
				}

}
