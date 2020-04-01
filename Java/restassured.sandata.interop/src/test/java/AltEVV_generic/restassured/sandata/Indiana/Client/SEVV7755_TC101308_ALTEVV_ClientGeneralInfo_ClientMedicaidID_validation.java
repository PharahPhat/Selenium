package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.apache.commons.lang.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;
import static com.globalMethods.core.globalVariables.altevv_clients;

/**
 * @author Anupam
 *
 */

// ClientMedicaidID (64) & MissingMedicaidID(True/False) are optional fields. The unique key for client will be ClientID

public class SEVV7755_TC101308_ALTEVV_ClientGeneralInfo_ClientMedicaidID_validation extends BaseTest{
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		switch (state) {
			case "PA": return new Object[][]
					{
							{true, CommonMethods.generateRandomNumberOfFixLength(10), ""},
							{false, CommonMethods.generateRandomNumberOfFixLength(11), ClientMedicaidIDLengtherror},
							{false, null, ClientMedicaidIDLengtherror},
							{false, "", ClientMedicaidIDformaterror},
							{false, CommonMethods.generateRandomAlphaNumeric(10), ClientMedicaidIDformaterror}
					};
			case "Colorado": return new Object[][]
					{
							{true, RandomStringUtils.randomAlphabetic(1) + CommonMethods.generateRandomNumberOfFixLength(6), ""},
							{false, CommonMethods.generateRandomNumberOfFixLength(65), ClientMedicaidIDLengtherror},
							{false, null, ClientMedicaidIDLengtherror},
							{false, "", ClientMedicaidIDformaterror},
							{false, CommonMethods.generateRandomAlphaNumeric(10), ClientMedicaidIDformaterror}
					};
			default: return new Object[][]
					{
							{true, CommonMethods.generateRandomNumberOfFixLength(64), ""},
							{false, CommonMethods.generateRandomNumberOfFixLength(65), ClientMedicaidIDLengtherror},
							{false, "", ClientMedicaidIDformaterror},
							{false, CommonMethods.generateRandomAlphaNumeric(10), ClientMedicaidIDformaterror}
					};
		}
	}

	@Test(dataProvider = "dataProvider")
	public void TC101308_AltEVV_Client_ClientMedicaidID_Validation(boolean isValid, String value, String errorMessage)
			throws IOException, ParseException {
		JSONArray altEVVJsonArray = generateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		Validation.validationField(altEVVJsonArray, ClientMedicaidID, isValid, value, errorMessage, CommonMethods.propertyfileReader(altevv_clients));
	}
}
