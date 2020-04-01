package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.*;
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
 */

//Test Case 91389: OpenEVV-altEVV- employee - EmployeeLastName validation field formats/values.

public class R2267_TC91389_AltEVV_EmployeeLastName_Validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		switch (state) {
			case "Vermont":
				return new Object[][]
						{
								{true, CommonMethods.generateRandomStringOfFixLength(30), ""},
								{true, CommonMethods.generateRandomStringOfFixLength(5) + " " + CommonMethods.generateRandomStringOfFixLength(5), ""},
								{false, CommonMethods.generateRandomStringOfFixLength(31), EmpLNameLengthError},
								{false, CommonMethods.generateSpecialChar(10), StaffLastNameFormatError},
								{false, CommonMethods.generateRandomAlphaNumeric(5), StaffLastNameFormatError},
								{false, " ", StaffLastNameFormatError},
								{false, null, StaffLastNameNullError},
								{false, "", StaffLastNameFormatError}
						};
			default:
				return new Object[][]
						{
								{true, CommonMethods.generateRandomStringOfFixLength(30), ""},
								{true, CommonMethods.generateRandomStringOfFixLength(5) + " " + CommonMethods.generateRandomStringOfFixLength(5), ""},
								{false, CommonMethods.generateSpecialChar(10), StaffLastNameFormatError},
								{false, "a3ho5", StaffLastNameFormatError},
								{false, " ", StaffLastNameFormatError},
								{false, null, StaffLastNameNullError},
								{false, "", StaffLastNameFormatError}
						};
		}
	}
	@Test(dataProvider = "dataProvider", groups = "fixing")
	public void TC91389_AltEVV_EmployeeLastName_Validation ( boolean isValid, String value, String errorMessage) throws IOException, ParseException {
		JSONArray altEVVJsonArray = generateUniqueParam.EmpParams_AltEVV(Staff_intake);
		Validation.validationField(altEVVJsonArray,EmployeeLastName, isValid, value, errorMessage,
				CommonMethods.propertyfileReader(altevv_emp));
	}

	@Test(groups = {"indiana", "fixing"})
	public void TC91389_AltEVV_EmployeeLastName_Exceed_MaxLength() throws IOException, ParseException, InterruptedException, SQLException, ClassNotFoundException, java.text.ParseException {
		JSONArray altEVVJsonArray = generateUniqueParam.EmpParams_AltEVV(Staff_intake);
		JSONObject jsonObject = (JSONObject) altEVVJsonArray.get(0);
		jsonObject.put(EmployeeLastName, CommonMethods.generateRandomStringOfFixLength(31));
		CommonMethods.validateResponse(altEVVJsonArray, CommonMethods.propertyfileReader(altevv_emp));

		assertionDbVerifier.verifyInboxWorker_AltEvvGenric(jsonObject);
	}
}