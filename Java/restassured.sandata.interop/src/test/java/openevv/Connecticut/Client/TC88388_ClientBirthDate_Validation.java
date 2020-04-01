package openevv.Connecticut.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.common.Validation;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;

//Test Case 88388:Open EVV: Verify error messages on uploading client with invalid input to ClientBirthDate

public class TC88388_ClientBirthDate_Validation extends BaseTest

{
	private GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		return new Object[][]
				{
						{true, "12311990", ""},
						{true, null, ""},
						{true, "", ""},
						{false, "12-31-1990", ClientBirthDateerror},
						{false, "12/31/1990", ClientBirthDateerror},
						{false, "19901213", ClientBirthDateerror},
						{false, "19903112", ClientBirthDateerror},
						{false, "31121990", ClientBirthDateerror},

				};
	}


	@Test(dataProvider = "dataProvider")
	public void TC88388_ClientBirthDate_Validation (boolean isValid, String value, String errorMessage) throws
	IOException, ParseException {
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_OpenEVV(client_openevv);
		Validation.validationField(jsonArray, ClientBirthDate, isValid, value, errorMessage,
				CommonMethods.propertyfileReader(openevv_client_url));
	}

}