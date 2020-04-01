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

public class R2267_TC91267_AltEVV_Indiana_Client_ProviderID_field_validations extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		return new Object[][]
				{
						{true, stateInfo.get(ProviderID), ""},
						{false, CommonMethods.generateRandomAlphaNumeric(10), ProviderIDInvalid},
						{false, null, ProviderIDInvalid},
						{false, "", ProviderIDInvalid}
				};
	}

	@Test(dataProvider = "dataProvider")
	public void TC91267_AltEVV_Indiana_Client_ProviderID_field_validations(boolean isValid, String value, String errorMessage)
			throws IOException, ParseException, InterruptedException {
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		Validation.validationProviderIdentificationField(jsonArray, ProviderID, isValid, value, errorMessage,
				CommonMethods.propertyfileReader(altevv_clients), 500);
	}
}
