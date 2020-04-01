package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
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

//Test Case 88399:Open EVV: Verify error messages on uploading client with invalid input to 'DischargeDate'

public class TC88399_Client_DischargeDate_Validation extends BaseTest {
	private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		return new Object[][]
				{
						{true, "2018-12-31", ""},
						{true, "12312018", ""},
						{true, null, ""},
						{true, "", ""},
						{true, CommonMethods.generateTodayDate("yyyy-MM-dd"), ""},
						{false, CommonMethods.genFutureDate_YYYY_MM_dd(1), DischargeDateError},
						{false, "20181231", DischargeDateFormatError},
						{false, "2018/12/31", DischargeDateFormatError},
						{false, "31-12-2018", DischargeDateFormatError},
						{false, "12/31/2018", DischargeDateFormatError},
						{false, "12-31-2018", DischargeDateFormatError},
						{false, "31/12/2018", DischargeDateFormatError},
						{false, "31122018", DischargeDateFormatError},
				};
	}

	@Test(dataProvider = "dataProvider")
	public void TC88399_Client_DischargeDate_Validation(boolean isValid, String value, String errorMessage) throws IOException, ParseException {
		JSONArray jsonArray = generateUniqueParam.ClientParams_OpenEVV(globalVariables.client_openevv);
		Validation.validationField(jsonArray, dischargeDate, isValid, value, errorMessage, CommonMethods.propertyfileReader(openevv_client_url));
	}
}