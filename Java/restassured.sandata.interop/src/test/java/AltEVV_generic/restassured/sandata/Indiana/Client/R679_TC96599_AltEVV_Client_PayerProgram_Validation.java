package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
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

//Test Case 91096:OpenEVV-altEVV- Client Payer: Validate (mix) - PayerID field formats/values

public class R679_TC96599_AltEVV_Client_PayerProgram_Validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();


	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		switch (state) {
			default: return new Object[][]
					{
							{true, CommonMethods.generateRandomAlphaNumeric(9), ""},
							{false, CommonMethods.generateRandomStringOfFixLength(10), PayerProgramLengthError_ALTGeneric},
							{false, null, PayerProgramNullError},
							{false, "", PayerProgramLengthError_ALTGeneric},
					};
			case "PA": return new Object[][]
					{
							{true, "ODP", ""},
							{true, "OLTL", ""},
							{true, "2C", ""},
							{true, "2F", ""},
							{true, "2J", ""},
							{true, "2N", ""},
							{true, "2S", ""},
							{true, "2B", ""},
							{true, "2E", ""},
							{true, "2H", ""},
							{true, "2Q", ""},
							{true, "2A", ""},
							{true, "2G", ""},
							{true, "2K", ""},
							{true, "2P", ""},
							{true, "2D", ""},
							{false, CommonMethods.generateRandomStringOfFixLength(10), PayerProgramLengthError_ALTGeneric},
							{false, null, PayerProgramNullError},
							{false, "", PayerProgramLengthError_ALTGeneric},
							{false, CommonMethods.generateRandomStringOfFixLength(9), payerProgramFormatError}
					};
			case "Colorado": return new Object[][]
					{
							{true, stateInfo.get(PayerProgram), ""},
							{false, CommonMethods.generateRandomAlphaNumeric(9), payerProgramFormatError},
							{false, CommonMethods.generateRandomStringOfFixLength(10), PayerProgramLengthError_ALTGeneric},
							{false, null, PayerProgramNullError},
							{false, "", PayerProgramLengthError_ALTGeneric},
							{false, CommonMethods.generateRandomStringOfFixLength(9), payerProgramFormatError}
					};
		}
	}

	@Test(dataProvider = "dataProvider")
	public void TC96599_AltEVV_Client_PayerProgram_Validation(boolean isValid, String value, String errorMessage) throws IOException, ParseException {
		JSONArray altEVVJsonArray = generateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		Validation.validationField(altEVVJsonArray, Client_Payer_Information, PayerProgram, isValid, value,
				errorMessage, CommonMethods.propertyfileReader(altevv_clients));
	}
}