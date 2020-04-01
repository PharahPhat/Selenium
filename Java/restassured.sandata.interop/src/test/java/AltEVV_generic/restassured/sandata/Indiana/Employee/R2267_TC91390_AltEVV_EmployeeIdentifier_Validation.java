package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.naming.directory.BasicAttribute;
import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;

/**
 * @author MayankM
 */

public class R2267_TC91390_AltEVV_EmployeeIdentifier_Validation extends BaseTest {
	private static GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();
	private static JSONArray altEVVJsonArray;

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() throws IOException, ParseException {
		altEVVJsonArray = generateUniqueParam.EmpParams_AltEVV(Staff_intake);
	switch (state) {
			case "PA": return new Object[][]
					{
							{true, "0000" + CommonMethods.generateRandomNumberOfFixLength(5), ""},
							{true, CommonMethods.generateRandomAlphaNumeric(6), ""},
							{true, CommonMethods.generateRandomNumberOfFixLength(6), ""},
							{false, CommonMethods.generateRandomAlphaNumeric(7), errorEmployeeIdentifierFormat},
							{false, CommonMethods.generateRandomNumberOfFixLength(7), errorEmployeeIdentifierFormat},
							{false, "0000" + CommonMethods.generateRandomNumberOfFixLength(6), errorEmployeeIdentifierFormat},
							{false, CommonMethods.generateSpecialChar(6), errorEmployeeIdentifierFormat},
							{false, null, EmployeeIdentifierNullError},
							{false, "", errorEmployeeIdentifierFormat}
					};
			case "Colorado":
				//JSONArray js = generateUniqueParam.EmpParams_AltEVV(Staff_intake);
				JSONObject js = (JSONObject) altEVVJsonArray.get(0);
				return new Object[][]
					{
							{true, js.get(EmployeeIdentifier), ""},
							{false, CommonMethods.generateRandomAlphaNumeric(9), EmployeeIdentifierFormatError},
							{false, CommonMethods.generateRandomAlphaNumeric(10), errorEmployeeIdentifierFormat},
							{false, CommonMethods.generateSpecialChar(6), errorEmployeeIdentifierFormat},
							{false, null, EmployeeIdentifierNullError},
							{false, "", errorEmployeeIdentifierFormat}
					};
			case "Vermont": return new Object[][]
					{
							{true, CommonMethods.generateRandomAlphaNumeric(64), ""},
							{false, CommonMethods.generateRandomAlphaNumeric(65), errorEmployeeIdentifierFormat},
							{false, CommonMethods.generateSpecialChar(60), errorEmployeeIdentifierFormat},
							{false, null, EmployeeIdentifierNullError},
							{false, "", errorEmployeeIdentifierFormat}
					};
			default: return new Object[][]
					{
							{true, CommonMethods.generateRandomAlphaNumeric(9), ""},
							{false, CommonMethods.generateRandomAlphaNumeric(10), errorEmployeeIdentifierFormat},
							{false, CommonMethods.generateSpecialChar(6), errorEmployeeIdentifierFormat},
							{false, null, EmployeeIdentifierNullError},
							{false, "", errorEmployeeIdentifierFormat}
					};
		}

	}

	@Test(dataProvider = "dataProvider")
	public void TC91390_AltEVV_Employee_EmployeeIdentifier_Validation(boolean isValid, String value, String errorMessage) throws IOException, ParseException {
		JSONArray altEVVJsonArray = generateUniqueParam.EmpParams_AltEVV(Staff_intake);
		Validation.validationField(altEVVJsonArray, EmployeeIdentifier, isValid, value, errorMessage,
				CommonMethods.propertyfileReader(altevv_emp));
	}

}

