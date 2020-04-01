package AltEVV_generic.restassured.sandata.Indiana.Client;

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
import static com.globalMethods.core.globalVariables.altevv_clients;

/**
 * @author MayankM
 */
//Test Case 7337: OpenEVV-altEVV- Client:  Validate (mix) - ClientQualifier field formats/values
public class R2267_TC91083_AltEVV_ClientQualifier extends BaseTest {
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		switch (state) {
			case "PA": return new Object[][]
					{
							{true, ClientCustomID, ""},
							{false, "ClientCustom", ClientQualifierFormatError},
							{false, ClientSSN, ClientQualifierFormatError},
							{false, ClientOtherID, ClientQualifierFormatError},
							{false, null, ClientQualifierNullError_genreic}
					};
			case "Colorado": return new Object[][]
					{
							{true, ClientMedicaidID, ""},
							{false, "ClientMedicaid", ClientQualifierFormatError},
							{false, ClientSSN, ClientQualifierFormatError},
							{false, ClientOtherID, ClientQualifierFormatError},
							{false, ClientCustomID, ClientQualifierFormatError},
							{false, null, ClientQualifierNullError_genreic}
					};
			default: return new Object[][]
					{
							{true, ClientOtherID, ""},
							{true, ClientSSN, ""},
							{true, ClientCustomID, ""},
							{false, CommonMethods.generateRandomStringOfFixLength(21), ClientQualifierFormatError},
							{false, CommonMethods.generateRandomStringOfFixLength(10), ClientQualifierFormatError},
							{false, null, ClientQualifierNullError_genreic}
					};
		}
	}

	@Test(dataProvider = "dataProvider")
	public void TC91083_AltEVV_Client_ClientQualifier_Validation(boolean isValid, String value, String errorMessage) throws IOException, ParseException, InterruptedException {
		JSONArray altEVVJsonArray = generateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		Validation.validationField(altEVVJsonArray, ClientQualifier, isValid, value, errorMessage, CommonMethods.propertyfileReader(altevv_clients));
	}

}