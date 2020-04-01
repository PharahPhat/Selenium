package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;

import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;

/**
 * @author MayankM
 */
//Test Case 91411: OpenEVV-altEVV- employee - EmployeeAPI validation field formats/values

public class R2267_TC91412_AltEVV_EmployeeAPI_Validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();
	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() throws IOException, ParseException {
		switch (state) {
			case "Vermont": return new Object[][]
					{
							{true, CommonMethods.generateRandomAlphaNumeric(25), ""},
							{true, null, ""},
							{true, "",""},
							{false, " ", EmployeeAPIFormatError},
							{false,CommonMethods.generateRandomNumberOfFixLength(30), EmployeeAPILengthError},

					};
			default: return new Object[][]
					{
							{true, CommonMethods.generateRandomNumberOfFixLength(5), ""},
							{true, null, ""},
							{false,CommonMethods.generateRandomNumberOfFixLength(30), EmployeeAPILengthError},
							{false, "", EmployeeAPILengthError},
					};
		}

	}
	@Test(dataProvider = "dataProvider", groups = "fixing")
	public void TC91412_AltEVV_EmployeeAPI_Validation(boolean isValid, String value, String errorMessage)
			throws IOException, ParseException {
		JSONArray altEVVJsonArray = generateUniqueParam.EmpParams_AltEVV(Staff_intake);
		Validation.validationField(altEVVJsonArray, EmployeeAPI, isValid, value, errorMessage,
				CommonMethods.propertyfileReader(altevv_emp));
	}

}