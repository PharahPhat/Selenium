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

import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;

public class SEVV4427_TC97932_ALTEVV_EmployeeSSN_validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		switch (state) {
			case "Indiana": return new Object[][]
					{
							{true, CommonMethods.generateRandomNumberOfFixLength(9), ""},
							{true, "0000" + CommonMethods.generateRandomNumberOfFixLength(5), ""},
							{false, null, StaffSSNnullError},
							{false, "", StaffSSNFormatError},
							{false, CommonMethods.generateRandomNumberOfFixLength(10), StaffSSNFormatError}

					};
			case "Colorado": return new Object[][]
					{
							{true, "0000" + CommonMethods.generateRandomNumberOfFixLength(5), ""},
							{true, null, ""},
							{true, "", ""},
							{false, CommonMethods.generateSpecialChar(9), StaffSSNFormatError},
							{false, CommonMethods.generateRandomNumberOfFixLength(10), StaffSSNFormatError},
							{false, CommonMethods.generateRandomNumberOfFixLength(9), StaffSSNFormatError}

					};
			default: return new Object[][]
					{
							{true, CommonMethods.generateRandomNumberOfFixLength(9), ""},
							{true, null, ""},
							{true, "", ""},
							{false, CommonMethods.generateRandomAlphaNumeric(10), StaffSSNFormatError}

					};
		}

	}

	@Test(dataProvider = "dataProvider", groups = "fixing")
	public void TC97932_ALTEVV_Employee_EmployeeSSN_validation(boolean isValid, String value, String errorMessage)
			throws IOException, ParseException {
		JSONArray altEVVJsonArray = generateUniqueParam.EmpParams_AltEVV(Staff_intake);
		altEVVJsonArray = generateUniqueParam.UpdateEmpIdentifier(altEVVJsonArray,value);
		Validation.validationField(altEVVJsonArray, EmployeeSSN, isValid, value, errorMessage,
				CommonMethods.propertyfileReader(altevv_emp));
	}
}
