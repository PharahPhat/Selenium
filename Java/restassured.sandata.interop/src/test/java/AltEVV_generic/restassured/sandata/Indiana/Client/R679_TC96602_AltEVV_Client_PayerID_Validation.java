package AltEVV_generic.restassured.sandata.Indiana.Client;

import java.io.IOException;
import java.sql.SQLException;

import com.common.Validation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

//Test Case 91096:OpenEVV-altEVV- Client Payer: Validate (mix) - PayerID field formats/values

import com.globalMethods.core.Assertion_DbVerifier;

import static com.globalMethods.core.globalVariables.*;
import static com.globalMethods.core.globalVariables.altevv_clients;

public class R679_TC96602_AltEVV_Client_PayerID_Validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		switch (state) {
			default: return new Object[][]
					{
							{true, CommonMethods.generateRandomStringOfFixLength(64), ""},
							{false, CommonMethods.generateRandomStringOfFixLength(65), errorPayorIdLength1},
							{false, null, PayerIDNullError},
							{false, "", errorPayorIdLength1}
					};
			case "PA": return new Object[][]
					{
							{true, "PAODP", ""},
							{true, "PAOLTL", ""},
							{true, "PAUPMC", ""},
							{true, "PAHW", ""},
							{true, "PAACP", ""},
							{true, "PAKF", ""},
							{false, CommonMethods.generateRandomStringOfFixLength(10), errorPayorIDFormat_AltEVV},
							{false, CommonMethods.generateRandomAlphaNumeric(10), errorPayorIDFormat_AltEVV},
							{false, null, PayerIDNullError},
							{false, "", errorPayorIDFormat_AltEVV}
					};
			case "Colorado": return new Object[][]
					{
							{true, "COHCPF", ClientPayerID_MaxLength_Error},
							{false, CommonMethods.generateRandomStringOfFixLength(64), errorPayorIDFormat_AltEVV},
							{false, CommonMethods.generateRandomStringOfFixLength(65), errorPayorIdLength1},
							{false, null, PayerIDNullError},
							{false, "", errorPayorIdLength1}
					};
		}
	}

	@Test(dataProvider = "dataProvider")
	public void TC96602_AltEVV_Client_PayerID_Validation(boolean isValid, String value, String errorMessage) throws
			IOException, ParseException {
		JSONArray altEVVJsonArray = generateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		Validation.validationField(altEVVJsonArray, Client_Payer_Information, PayerID, isValid, value,
				errorMessage, CommonMethods.propertyfileReader(altevv_clients));

	}
	
}