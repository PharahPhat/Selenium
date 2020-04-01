/**
 * 
 */
package AltEVV_Molina.restassured.sandata.Employee;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */

//Test Case 95626:Verify for ProviderID field should accept max of 50 STRING length for ALTEVV (Client/employee).

import static com.globalMethods.core.globalVariables.*;

public class BUG_SEVV_72_TC95626_AltEVV_ProviderID_field_Maxlength_validation extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

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

	//Case1: Verify for ProviderID field should accept max of 50 STRING length for ALTEVV (employee).

	@Test(dataProvider = "dataProvider")
	public void TC95626_AltEVV_ProviderID_field_validation(boolean isValid, String value, String errorMessage)
			throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		logger.log(LogStatus.INFO, "TC95626_AltEVV_ProviderID_field_validation");
		//Using Reusable method to load employee json
		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonProvider =  (JSONObject) jsonObject.get(globalVariables.ProviderIdentification);
		jsonProvider.put(ProviderID, value);

		if (isValid) {
			CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(altevv_Molina_emp));
		}
		else {
			String bodyAsString = CommonMethods.capturePostResponse_500(jsonArray, CommonMethods.propertyfileReader(altevv_Molina_emp));
			CommonMethods.verifyjsonassertFailcase(bodyAsString, errorMessage);
		}
	}
}
