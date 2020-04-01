package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static com.globalMethods.core.globalVariables.*;

/**
 * @author RRohiteshwar
 * Updated by tuyen.tran@sandata.com following by SEVV-18215
 */
//Test Case 91406: OpenEVV-altEVV- employee - EmployeeOtherID validation field formats/values

public class R2267_TC91406_AltEVV_EmployeeOtherID_Validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
			switch (state) {
			case "Vermont": return new Object[][]
					{
							{true, CommonMethods.generateRandomStringOfFixLength(64), ""},
							{true, null, ""},
							{true, "", ""},
							{false, CommonMethods.generateRandomAlphaNumeric(65), errorEmployeeOtherIDMaxLengthValidation},
					};
			case "Indiana": return new Object[][]
					{
							{true, CommonMethods.generateRandomStringOfFixLength(64), ""},
							{true, null, ""},
							{true, "", ""},
							{true, CommonMethods.generateRandomAlphaNumeric(65), ""},
					};
			default: return new Object[][]
					{
							{true, CommonMethods.generateRandomStringOfFixLength(64), ""},
							{true, CommonMethods.generateRandomStringOfFixLength(1), ""},
							{true, null, ""},
							{true, "", ""},
							{false, CommonMethods.generateRandomNumberOfFixLength(65), errorEmployeeOtherIDMaxLengthValidation},
							{false, CommonMethods.generateRandomNumberOfFixLength(10)+ CommonMethods.generateSpecialChar(5)+ CommonMethods.generateRandomNumberOfFixLength(3), EmployeeOtherIDFormatError}
					};
		}
	}

	@Test(dataProvider = "dataProvider", groups = "fixing")
	public void TC91406_AltEVV_EmployeeOtherID_Validation(boolean isValid, String value, String errorMessage)
	throws IOException, ParseException {
		JSONArray altEVVJsonArray = generateUniqueParam.EmpParams_AltEVV(Staff_intake);
		Validation.validationField(altEVVJsonArray, EmployeeOtherID, isValid, value, errorMessage,
				CommonMethods.propertyfileReader(altevv_emp));
	}
}