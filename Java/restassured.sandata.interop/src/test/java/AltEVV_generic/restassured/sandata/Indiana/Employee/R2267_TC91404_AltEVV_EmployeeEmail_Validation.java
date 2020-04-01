package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
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
 * @Update by TuyenTran: SEVV-16619: EmployeeEmail is Optional field
 */
//Test Case 91404:OpenEVV-altEVV- employee - EmployeeEmail validation field formats/values.
//SEVV-16619: EmployeeEmail is Optional field

public class R2267_TC91404_AltEVV_EmployeeEmail_Validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		switch (state) {
			case "Vermont":
				return new Object[][]
						{
								{true, DataGeneratorEmployee.generateEmpEmail(32), ""},
								{false, DataGeneratorEmployee.generateEmpEmail(33), StaffEmailLengthError},
								{false, DataGeneratorEmployee.generateEmpEmail(10) + "@", StaffEmailFormatError},
								{false, DataGeneratorEmployee.generateEmpEmail(10) + " ", StaffEmailFormatError},
								{true, null, ""},
								{true, "", ""}
						};
			default:
				return new Object[][]
						{
								{true, DataGeneratorEmployee.generateEmpEmail(32), ""},
								{false, DataGeneratorEmployee.generateEmpEmail(33), StaffEmailLengthError},
								{false, DataGeneratorEmployee.generateEmpEmail(10) + "@", StaffEmailFormatError},
								{false, DataGeneratorEmployee.generateEmpEmail(10) + " ", StaffEmailFormatError},
								{true, null, ""},
								{true, "", ""}
						};
		}
	}

	@Test(dataProvider = "dataProvider", groups = "fixing")
	public void R2267_TC91404_AltEVV_EmployeeEmail_Validation(boolean isValid, String value, String errorMessage)
			throws IOException, ParseException {
		JSONArray altEVVJsonArray = generateUniqueParam.EmpParams_AltEVV(Staff_intake);
		Validation.validationField(altEVVJsonArray, EmployeeEmail, isValid, value, errorMessage,
				CommonMethods.propertyfileReader(altevv_emp));

	}
}