package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.lang.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;
import static com.globalMethods.core.globalVariables.altevv_clients;

//Test Case TC90984: OpenEVV-altEVV- Client:  Validate If the client Json does not include a ClientIdentifier [PatientOtherID]

public class R2267_TC90984_AltEVV_Client_ClientIdentifier_Validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		switch (state) {
			default: return new Object[][]
					{
							{true, CommonMethods.generateRandomNumberOfFixLength(64), ""},
							{true, CommonMethods.generateRandomAlphaNumeric(10), ""},
							{false, CommonMethods.generateRandomNumberOfFixLength(65), ClientIdentifiervalueError},
							{false, null, errorClientIdentifierNull},
							{false, CommonMethods.generateSpecialChar(10), ClientIdentifierformat},
							{false, "", ClientIdentifierformat}
					};
			case "PA": return new Object[][]
					{
							{true, CommonMethods.generateRandomNumberOfFixLength(10), ""},
							{true, CommonMethods.generateRandomAlphaNumeric(10), ""},
							{false, CommonMethods.generateRandomNumberOfFixLength(11), ClientIdentifiervalueError},
							{false, null, errorClientIdentifierNull},
							{false, CommonMethods.generateSpecialChar(10), ClientIdentifierformat}
					};
			case "Colorado": return new Object[][]
					{
							{true, RandomStringUtils.randomAlphabetic(1) +
									CommonMethods.generateRandomNumberOfFixLength(6), ""},
							{false, CommonMethods.generateRandomAlphaNumeric(7), ClientIdentifierformat},
							{false, null, errorClientIdentifierNull},
							{false, CommonMethods.generateSpecialChar(10), ClientIdentifierformat},
							{false, "", ClientIdentifierformat}
					};
		}

	}

	@Test(dataProvider = "dataProvider")
	public void TC90984_AltEVV_Client_ClientIdentifier_Validation(boolean isValid, String value, String errorMessage) throws IOException, ParseException {
		JSONArray altEVVJsonArray = generateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		Validation.validationField(altEVVJsonArray, ClientIdentifier, isValid, value, errorMessage, CommonMethods.propertyfileReader(altevv_clients));
	}

}
