package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.sql.SQLException;
import java.io.IOException;
import static com.globalMethods.core.globalVariables.*;


/**
 * @author RRohiteshwar
 */
//Test Case 91404:OpenEVV-altEVV- employee - EmployeeEmail validation field formats/values.

public class R2267_TC91404_AltEVV_EmployeePosition_Validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() throws IOException, ParseException {
		switch (state) {
			case "Vermont":
				return new Object[][]
						{
								{true, CommonMethods.generateRandomAlphaNumeric(3), ""},
								{true, null, ""},
								{true, "", ""},
								{false, CommonMethods.generateRandomAlphaNumeric(4), EmployeePositionLengthError},
								{false, " ", EmployeePositionFormatError},
						};
			default:
				return new Object[][]
						{
								{true, DataGeneratorEmployee.generateStaffPosition(), ""},
								{false, CommonMethods.getSaltString(1) + CommonMethods.generateSpecialChar(2), EmployeePositionFormatError},
								{true, CommonMethods.generateRandomNumberOfFixLength(3), EmployeePositionFormatError},
								{true, CommonMethods.generateRandomAlphaNumeric(3), EmployeePositionFormatError},
						};
		}

	}

	@Test(dataProvider = "dataProvider")
	public void R2267_TC91404_AltEVV_employeePosition_Validation(boolean isValid, String value, String errorMessage)
			throws IOException, ParseException, InterruptedException, SQLException, ClassNotFoundException, java.text.ParseException {
		JSONArray altEVVJsonArray = generateUniqueParam.EmpParams_AltEVV(Staff_intake);
		Validation.validationField(altEVVJsonArray, EmployeePosition, isValid, value, errorMessage,
				CommonMethods.propertyfileReader(altevv_emp));
		if(isValid && value != null&& !value.isEmpty())
			assertionDbVerifier.verifyInboxWorker_AltEvvGenric((JSONObject) altEVVJsonArray.get(0));
	}
}