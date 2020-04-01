/**
 * 
 */
package AltEVV_generic.restassured.sandata.Indiana.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;
import static com.globalMethods.core.globalVariables.altevv_emp;

/**
 * @author Anupam
 */
//Test Case 95626:Verify for ProviderID field should accept max of 50 STRING length for ALTEVV (Client/employee).

public class BUG_SEVV_72_TC95626_AltEVV_Indiana_Employee_ProviderID_field_Maxlength_validation extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();
	//Case1: Verify for ProviderID field should accept max of 50 STRING length for ALTEVV (employee).

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		return new Object[][]
				{
						{true, stateInfo.get(ProviderID), ""},
						{false, CommonMethods.generateRandomAlphaNumeric(51), ProviderIDInvalid},
						{false, null, ProviderIDInvalid},
						{false, "", ProviderIDInvalid}
				};
	}

	@Test(dataProvider = "dataProvider")
	public void TC95626_AltEVV_Indiana_Employee_ProviderID_field_Maxlength_validation(boolean isValid, String value, String errorMessage) throws
			IOException, ParseException, InterruptedException {
		JSONArray altEVVJsonArray = generateUniqueParam.EmpParams_AltEVV(Staff_intake);
		JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
		JSONObject jsonProvider =  (JSONObject) jsonobject.get(globalVariables.ProviderIdentification);
		jsonProvider.put(ProviderID, value);

		if (isValid) {
			CommonMethods.validateResponse(altEVVJsonArray, CommonMethods.propertyfileReader(altevv_emp));
		}
		else {
			String bodyAsString = CommonMethods.capturePostResponse_500(altEVVJsonArray, CommonMethods.propertyfileReader(altevv_emp));
			CommonMethods.verifyjsonassertFailcase(bodyAsString, errorMessage);
		}
	}
}
