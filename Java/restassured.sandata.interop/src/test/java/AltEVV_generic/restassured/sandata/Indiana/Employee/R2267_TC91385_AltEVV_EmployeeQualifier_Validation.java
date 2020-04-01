/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;

/**
 * @author RRohiteshwar
 */

public class R2267_TC91385_AltEVV_EmployeeQualifier_Validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		switch (state) {
			case "PA": return new Object[][]
					{
							{true, EmployeeCustomID, ""},
							{false, EmployeeSSN, EmployeeQualifierFormatError},
							{false, EmployeeRegID, EmployeeQualifierFormatError},
							{false, "EmployeecustomID", EmployeeQualifierFormatError},
							{false, CommonMethods.generateRandomStringOfFixLength(20), EmployeeQualifierFormatError},
							{false, CommonMethods.generateRandomStringOfFixLength(21), EmployeeQualifierFormatError},
							{false, null, EmployeeQualifierNullError},
							{false, "", EmployeeQualifierFormatError}
					};
			case "Colorado": return new Object[][]
					{
							{true, EmployeeCustomID, ""},
							{false, EmployeeSSN, EmployeeQualifierFormatError},
							{false, EmployeeRegID, EmployeeQualifierFormatError},
							{false, "EmployeecustomID", EmployeeQualifierFormatError},
							{false, CommonMethods.generateRandomStringOfFixLength(20), EmployeeQualifierFormatError},
							{false, CommonMethods.generateRandomStringOfFixLength(21), EmployeeQualifierFormatError},
							{false, null, EmployeeQualifierNullError},
							{false, "", EmployeeQualifierFormatError}
					};
			case "Vermont": return new Object[][]
					{
							{true, EmployeeCustomID, ""},
							{false, EmployeeSSN, EmployeeQualifierFormatError},
							{false, EmployeeRegID, EmployeeQualifierFormatError},
							{false, "EmployeecustomID", EmployeeQualifierFormatError},
							{false, CommonMethods.generateRandomStringOfFixLength(20), EmployeeQualifierFormatError},
							{false, CommonMethods.generateRandomStringOfFixLength(21), EmployeeQualifierFormatError},
							{false, null, EmployeeQualifierNullError},
							{false, "", EmployeeQualifierFormatError}
					};
			default: return new Object[][]
					{
							{true, EmployeeCustomID, ""},
							{true, EmployeeSSN, ""},
							{true, EmployeeRegID, ""},
							{false, CommonMethods.generateRandomStringOfFixLength(20), EmployeeQualifierFormatError},
							{false, CommonMethods.generateRandomStringOfFixLength(21), EmployeeQualifierFormatError},
							{false, null, EmployeeQualifierNullError},
							{false, "", EmployeeQualifierFormatError}
					};
		}

	}

	@Test(dataProvider = "dataProvider")
	public void TC91106_AltEVV_Employee_EmployeeQualifier_Validation(boolean isValid, String value, String errorMessage)
			throws IOException, ParseException {
		JSONArray altEVVJsonArray = generateUniqueParam.EmpParams_AltEVV(Staff_intake);
		Validation.validationField(altEVVJsonArray, EmployeeQualifier, isValid, value, errorMessage,
				CommonMethods.propertyfileReader(altevv_emp));
	}
}
