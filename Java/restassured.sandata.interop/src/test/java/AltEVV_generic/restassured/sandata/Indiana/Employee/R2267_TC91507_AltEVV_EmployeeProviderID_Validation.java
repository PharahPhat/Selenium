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
import static com.globalMethods.core.globalVariables.altevv_emp;

/**
 * @author MayankM
 */
//Test Case 91507: Open EVV - Alt EVV - Worker - ProviderId field validation

public class R2267_TC91507_AltEVV_EmployeeProviderID_Validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		return new Object[][]
				{
						{true, stateInfo.get(ProviderID), ""},
						{false, CommonMethods.generateRandomAlphaNumeric(11), ProviderIDInvalid},
						{false, null, ProviderIDInvalid},
						{false, "", ProviderIDInvalid}
				};
	}

	@Test(dataProvider = "dataProvider")
	public void TC91507_AltEVV_EmployeeProviderID_Validation(boolean isValid, String value, String errorMessage) throws
			IOException, ParseException, InterruptedException {
		JSONArray jsonArray = generateUniqueParam.EmpParams_AltEVV(Staff_intake);
		Validation.validationProviderIdentificationField(jsonArray, ProviderID, isValid, value, errorMessage,
				CommonMethods.propertyfileReader(altevv_emp), 500);
	}
}