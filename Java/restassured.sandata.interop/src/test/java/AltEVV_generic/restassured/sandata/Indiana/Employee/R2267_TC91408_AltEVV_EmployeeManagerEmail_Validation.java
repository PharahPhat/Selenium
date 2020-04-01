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
//Test Case 91408:OpenEVV-altEVV- employee - EmployeeManagerEmail validation field formats/values.

public class R2267_TC91408_AltEVV_EmployeeManagerEmail_Validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();
	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		switch (state) {
			case "Vermont":
				return new Object[][]
						{
								{true, DataGeneratorEmployee.generateEmpEmail(27), ""},
								{true, "", ""},
								{true, null, ""},
								{false, " ", EmployeeManagerEmailFormatError},
								{false, DataGeneratorEmployee.generateEmpEmail(10) + ".test " + " @", EmployeeManagerEmailFormatError},
								{false, DataGeneratorEmployee.generateEmpEmail(60), EmployeeManagerEmailLengthError},
						};
			default:
				return new Object[][]
						{
								{true, DataGeneratorEmployee.generateEmpEmail(27), ""},
						};
		}
	}
	@Test(dataProvider = "dataProvider")
		public void TC91408_AltEVV_EmployeeManagerEmail_Validation( boolean isValid, String value, String errorMessage) throws IOException, ParseException {
			JSONArray altEVVJsonArray = generateUniqueParam.EmpParams_AltEVV(Staff_intake);
			Validation.validationField(altEVVJsonArray, EmployeeManagerEmail, isValid, value, errorMessage,
					CommonMethods.propertyfileReader(altevv_emp));
		}

	}
